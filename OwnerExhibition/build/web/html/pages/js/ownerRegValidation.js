 
    window.onload = function()
    {
      // fix for windows 8
      if (navigator.appVersion.indexOf("Windows NT 6.2") != -1)
        document.head.innerHTML += '<link rel="stylesheet" type="text/css" href="pages/css/windows.chrome.fix.css" />'
    } 
    
   
   
function val(){
 
   $("#msgbox1").removeClass().addClass('myinfo').text('matching password........ ').fadeOut(1);

 if(isNaN(login_frm.phone.value))
{
	//alert("Invalid phone number");
         $("#msgbox5").html('Invalid phone number').addClass('myerror').fadeOut(5000,function()
			             {
			             });
	
	return false;
}





else if  ((login_frm.password.value)!=(login_frm.cpassword.value)) {
        //alert("Passwords do not match.");
         $("#msgbox3").html('Passwords do not match.').addClass('myerror').fadeOut(5000,function()
			             {
			             });
        return false;
        }
else
return true;
}

    