$(document).ready(function() {
    $("#delete-btn").click(function() {
        var id = $("${user.id}").val();

        $.ajax({
            url: '/delete',
            method: 'get',
            data: $("#user-row"+id).serialize(),


            success: function (obj) {
                $("#user-row"+id).remove();
            },

            error: function (xhr, status, error) {
                alert(xhr.responseText);
            }

        });

    })
});
