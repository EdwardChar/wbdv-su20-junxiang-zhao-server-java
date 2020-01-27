(function () {
    var $usernameFld, $passwordFld;
    var $removeBtn, $editBtn, $createBtn;
    var $firstNameFld, $lastNameFld, $roleFld;
    var $userRowTemplate, $tbody;
    var userService = new AdminUserServiceClient();
    var userList = $("userList");
    var users = [];
    $(main);

    function main() {
        $usernameFld = $("usernameFld");
        $passwordFld = $("passwordFld");
        $removeBtn = $("removeBtn");
        $editBtn = $("editBtn");
        $createBtn = $("createBtn");
        $firstNameFld = $("firstNameFld");
        $lastNameFld = $("lastNameFld");
        $roleFld = $("roleFld");
        $userRowTemplate = $("userRowTemplate");
        $tbody = $("tbody");
    }
    function createUser() { … }
    function findAllUsers() { … }
    function findUserById() { … }
    function deleteUser(index) {    }
    function selectUser() { … }
    function updateUser() { … }
    function renderUser(user) { … }
    function renderUsers(users) {
        userList.empty();
        for (let u in users){
            const user = users[u];
            let $deleteBtn = $("<button>Delete</button>");
            $deleteBtn.click(() => {
                deleteUser(u);
            })

            var $li = $("<li>${user.username}</li>")
            $li.append($deleteBtn);
            userList.append($li);
        }


    }
})();
