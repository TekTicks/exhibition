/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 window.onload = function()
    {
      // fix for windows 8
      if (navigator.appVersion.indexOf("Windows NT 6.2") != -1)
        document.head.innerHTML += '<link rel="stylesheet" type="text/css" href="pages/css/windows.chrome.fix.css" />'
    } 
    
function val(){
 if((login_frm.newpassword.value).length < 6)
{
	//alert("Phone number should be minimum 10 digits");
         $("#msgbox1").html('Password should be minimum 6 digits').addClass('myerror').fadeTo(3000,1,function()
			             {
			             });
	login_frm.newpassword.focus(); 
	return false;
}
else if((login_frm.confirmpassword.value).length < 6)
{
	//alert("Phone number should be maximum 10 digits");
         $("#msgbox2").html('Password should be manimum 6 digits').addClass('myerror').fadeTo(3000,1,function()
			             {
			             });
	login_frm.confirmpassword.focus(); 
	return false;
}

/*else if  ((login_frm.newpassword.value)!=(login_frm.confirmpassword.value)) {
        //alert("Passwords do not match.");
         $("#msgbox3").html('Passwords does not match.').addClass('myerror').fadeTo(3000,1,function()
			             {
			             });
        return false;
        } */
else
return true;
}

function phoneCheck(){
 if((login_frm.mobileNo.value).length < 10)
{
	//alert("Phone number should be minimum 10 digits");
         $("#msgbox1").html('Password should be minimum 10 digits').addClass('myerror').fadeTo(3000,1,function()
			             {
			             });
	login_frm.newpassword.focus(); 
	return false;
}
else 
return false;
}