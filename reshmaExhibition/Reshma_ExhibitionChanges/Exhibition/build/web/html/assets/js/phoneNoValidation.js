function validate(key)
{

var keycode = (key.which) ? key.which : key.keyCode;
var phn = document.getElementById('phone');
var cd = document.getElementById('mobileNo');
//comparing pressed keycodes
if (!(keycode==8 || keycode==46)&&(keycode < 48 || keycode > 57))
{
return false;
}
else
{
return true;
}
}

