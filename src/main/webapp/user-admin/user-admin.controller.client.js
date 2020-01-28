(function () {
    var $usernameFld, $passwordFld;
    var $removeBtn, $editBtn, $createBtn;
    var $firstNameFld, $lastNameFld, $roleFld;
    var $userRowTemplate, $tbody;
    var userService = new AdminUserServiceClient();
    var userList;
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
        $tbody = $("#tbody");
        userList = $("#userList");
        $createBtn.click(createUser);
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
        users.push(newUser);
        renderUsers();
    }

    function findAllUsers() {  }
    function findUserById() {  }
    function deleteUser(index) {    }
    function selectUser() {  }
    function updateUser() {  }
    function renderUser(user) {  }
    function renderUsers() {
        userList.empty();
        for (let u in users){
            const user = users[u];
            let $deleteBtn = $("<i></i>");
            $deleteBtn.addClass("fa-2x fa fa-times wbdv-remove");
            $deleteBtn.click(() => {
                deleteUser(u);
            })
            let $editBtn = $("<i></i>");
            $editBtn.addClass("fa-2x fa fa-pencil wbdv-edit");
            $editBtn.click(() => {

            });
            let $btnArea = $("<span></span>");
            $btnArea.addClass("float-right");
            $btnArea.append($deleteBtn);
            $btnArea.append($editBtn);
            let $usernameCell = $("<td>${user.username}</td>");
            let $passwordCell = $("<td>${user.password}</td>");
            let $firstNameCell = $("<td>${user.firstName}</td>");
            let $lastNameCell = $("<td>${user.lastName}</td>");
            let $roleCell = $("<td>${user.role}</td>");
            let $row = $("<tr></tr>");
            $row.append($usernameCell);
            $row.append($passwordCell);
            $row.append($firstNameCell);
            $row.append($lastNameCell);
            $row.append($roleCell);
            $row.append($btnArea);
            userList.append($row);
        }
    }
})();
