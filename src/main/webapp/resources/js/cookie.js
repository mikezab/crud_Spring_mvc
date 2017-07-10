/**
 * Created by JPMC-B2-PC010 on 16/06/2017.
 */
function checkCookie()
{
    if(document.cookie!==""){
        $('#regform').remove();
        $('#image').remove();
        $('#p-registration').remove();
        $('#section-center').remove();
    }
}


function writeCookie()
{
    if(typeof(Storage) !== "undefined"){

        if (document.regform.name.value == "" || document.regform.email.value == "") {
            //alert("Please Enter Name!");
            return;
        }

        else if(document.regform.year.value == "" || document.regform.month.value == "" || document.regform.day.value == "" ){
            return;
        }

    }else {
        alert("Sorry! No Web Storage support..");
    }

    cookievalue=encodeURI(document.regform.name.value);
    document.cookie="name=" + cookievalue;
    //alert("Thank you! You've successfully registered!: " + " " + cookievalue );

    $('#regform').remove();
    $('#image').remove();
    $('#p-registration').remove();
    $('#section-center').remove();
}
