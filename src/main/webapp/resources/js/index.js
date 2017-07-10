

$(document).ready(function () {
    $("#regform").validate({

        groups: {
            myDate: 'month day year'
        },
        errorPlacement: function(error, element) {
            if(element.attr("name") == "month"
                || element.attr("name") == "day"
                || element.attr("name") == "year" )
                error.insertBefore("#nav");

            else if(element.attr("name") == "box" )
                error.insertAfter("#paragraph");
            else
                error.insertAfter(element);
        },



        rules: {
            "name": {
                required: true,
                minlength: 2
            },
            "email": {
                required: true,
                email: true
            },
            //box: "required"

        },

        messages: {
            "name": {
                required: "Please enter a name"
            },
            "email": {
                required: "Please enter an email",
                email: "Email is invalid"
            },
                box:"Please check the box to indicate that you have read and agree to the Privacy Policy agreement!"

        },

        /*submitHandler: function (form) {
            alert('valid form submitted');
            return false;
        }
        */
    });

});

