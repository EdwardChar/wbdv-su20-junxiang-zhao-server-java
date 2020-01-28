(function () {
    var $usernameFld, $passwordFld;
    var $removeBtn, $editBtn, $createBtn;
    var $firstNameFld, $lastNameFld, $roleFld;
    var $userRowTemplate, $tbody;
    var userService = new AdminUserServiceClient();
    var $userList;
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
        $userRowTemplate = $("#userRowTemplate");
        $tbody = $("tbody");
        $userList = $tbody;
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
    function findUserById() {  }
    function deleteUser(index) {
        userService.deleteUser(index).then(findAllUsers);
    }
    function selectUser() {
        $usernameFld.val(user.username);
        $passwordFld.val(user.password);
        $firstNameFld.val(user.firstName);
        $lastNameFld.val(user.lastName);
        $roleFld.val(user.role);  }
    function updateUser() {

    }
    function renderUser(user) {
    }
    function renderUsers(users) {
        $userList.empty();
        for (let u in users){
            const user = users[u];
            let $deleteBtn = $("<i></i>");
            $deleteBtn.addClass("fa-2x fa fa-times wbdv-remove");
            $deleteBtn.click(() => {
                deleteUser(user._id);
            })
            let $editBtn = $("<i></i>");
            $editBtn.addClass("fa-2x fa fa-pencil wbdv-edit");
            $editBtn.click(() => {
                renderUser(user);
            });
            let $btnArea = $("<span></span>");
            $btnArea.addClass("float-right");
            $btnArea.append($deleteBtn);
            $btnArea.append($editBtn);
            let $usernameCell = $(`<td>${user.username}</td>`);
            let $passwordCell = $(`<td>${user.password}</td>`);
            let $firstNameCell = $(`<td>${user.firstName}</td>`);
            let $lastNameCell = $(`<td>${user.lastName}</td>`);
            let $roleCell = $(`<td>${user.role}</td>`);
            let $btnCell = $("<td></td>")
            $btnCell.append($btnArea);
            let $row = $("<tr></tr>");
            $row.append($usernameCell);
            $row.append($passwordCell);
            $row.append($firstNameCell);
            $row.append($lastNameCell);
            $row.append($roleCell);
            $row.append($btnCell);
            $userList.append($row);
        }
    }
})();
