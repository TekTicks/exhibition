
function Validation()
{
var a = document.login.mobileNo.value;
if(a=="")
{
alert("please Enter the Contact Number");
document.form.phone.focus();
return false;
}
if(isNaN(a))
{
alert("Enter the valid Mobile Number(Like : 9566137117)");
document.form.phone.focus();
return false;
}
if((a.length < 1) || (a.length > 10))
{
alert(" Your Mobile Number must be 1 to 10 Integers");
document.form.phone.select();
return false;
}
}