(function () {
    var $usernameFld, $passwordFld;
    var $removeBtn, $editBtn, $createBtn;
    var $firstNameFld, $lastNameFld, $roleFld, $idFld;
    var $userRowTemplate, $tbody;
    var userService = new AdminUserServiceClient();
    var users = [];
    $(main);

    function main() {
        $usernameFld = $("#usernameFld");
        $passwordFld = $("#passwordFld");
        $removeBtn = $("#removeBtn");
        $editBtn = $("#editBtn");
        $createBtn = $("#createBtn");
        $firstNameFld = $("#firstNameFld");
        $lastNameFld = $("#lastNameFld");
        $roleFld = $("#roleFld");
        $idFld = $("#idFld");
        $userRowTemplate = $("#userRowTemplate");
        $tbody = $("#userList");
        $createBtn.click(createUser);
        $editBtn.click(updateUser);
        findAllUsers();
    }

    function createUser() {
        const newUser = {
            username: $usernameFld.val(),
            password: $passwordFld.val(),
            firstName: $firstNameFld.val(),
            lastName: $lastNameFld.val(),
            role: $roleFld.val()
        };
        $usernameFld.val("");
        $passwordFld.val("");
        $firstNameFld.val("");
        $lastNameFld.val("");
        $roleFld.val("");
        console.log(newUser);
        userService.createUser(newUser).then(findAllUsers);
    }

    function findAllUsers() {
        userService.findAllUsers().then(renderUsers);
    }
    function findUserById(id) {
        userService.findUserById(id).then(selectUser);
    }
    function deleteUser(index) {
        userService.deleteUser(index).then(findAllUsers);
    }
    function selectUser(user) {
        $usernameFld.val(user.username);
        $passwordFld.val(user.password);
        $firstNameFld.val(user.firstName);
        $lastNameFld.val(user.lastName);
        $roleFld.val(user.role);
        $idFld.val(user._id);
    }
    function updateUser() {
        const user = {
            username: $usernameFld.val(),
            password: $passwordFld.val(),
            firstName: $firstNameFld.val(),
            lastName: $lastNameFld.val(),
            role: $roleFld.val()
        };
        $usernameFld.val("");
        $passwordFld.val("");
        $firstNameFld.val("");
        $lastNameFld.val("");
        $roleFld.val("");
        console.log(user);
        userService.updateUser($idFld.val(),user).then(findAllUsers);
    }
    function renderUser(user) {
        let $row = $userRowTemplate.clone();
        $row.removeClass("wbdv-hidden");
        $row.find(".wbdv-username").html(user.username);
        $row.find(".wbdv-password").html(user.password);
        $row.find(".wbdv-first-name").html(user.firstName);
        $row.find(".wbdv-last-name").html(user.lastName);
        $row.find(".wbdv-role").html(user.role);
        $row.find(".wbdv-remove").click(() => {
            deleteUser(user._id);
        });
        $row.find(".wbdv-edit").click(() => {
            selectUser(user);
        });
        $tbody.append($row);
    }
    function renderUsers(users) {
        $tbody.empty();
        for (let u in users){
            const user = users[u];
            renderUser(user);
        }
    }
})();
