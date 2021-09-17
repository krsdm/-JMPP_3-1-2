$(document).ready(function(){

    /*   Edit button handler   */

    $(".editbtn").click(function(){
        let id = $(this).attr('data-whatever');
        let firstname = $(".user" + id + " .firstname").text();
        let lastname = $(".user" + id + " .lastname").text();
        let email = $(".user" + id + " .email").text();
        let age = $(".user" + id + " .age").text();
        let pass = $(".user" + id + " .d-none").text();
        let userRoles = $(".user" + id + " .roles").text().trim().split(" ");
        let allRoles = $.map($("#editUserForm option"), option => $(option).text().trim());

        $('#editUserForm').attr("action", "/admin/" + id + "/edit");
        $('#editUserForm #id').val(id);
        $('#editUserForm #name').val(firstname);
        $('#editUserForm #surname').val(lastname);
        $('#editUserForm #email').val(email);
        $('#editUserForm #age').val(age);
        $('#editUserForm #password').val(pass);

        $('#editUserForm #roles').empty();
        $.each(allRoles, function (i, role) {
            if (userRoles.indexOf(role) > -1){
                $('#editUserForm #roles').append("<option value='ROLE_" + role + "' selected>" + role + "</option>");
            } else {
                $('#editUserForm #roles').append("<option value='ROLE_" + role + "'>" + role + "</option>");
            }
        });
    });

    /*   Delete button handler   */

    $(".delbtn").click(function(){
        let id = $(this).attr('data-whatever');
        let firstname = $(".user" + id + " .firstname").text();
        let lastname = $(".user" + id + " .lastname").text();
        let email = $(".user" + id + " .email").text();
        let age = $(".user" + id + " .age").text();
        let roles = $(".user" + id + " .roles").text().trim().split(" ");

        $('#delUserForm').attr("action", "/admin/" + id);
        $('#delUserForm #id').val(id);
        $('#delUserForm #name').val(firstname);
        $('#delUserForm #surname').val(lastname);
        $('#delUserForm #email').val(email);
        $('#delUserForm #age').val(age);

        $('#delUserForm #roles').empty();
        $.each(roles, function (i, role) {
            $('#delUserForm #roles').append("<option>" + role + "</option>");
        });
    });

});