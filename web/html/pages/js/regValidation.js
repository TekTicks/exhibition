 
    window.onload = function()
    {
      // fix for windows 8
      if (navigator.appVersion.indexOf("Windows NT 6.2") != -1)
        document.head.innerHTML += '<link rel="stylesheet" type="text/css" href="pages/css/windows.chrome.fix.css" />'
    } 
    
function val(){
    if(login_frm.cname.value=="")
    {
        //alert("Please enter the phone number");
        $("#msgbox").html('Please enter company name.....').addClass('myerror').fadeOut(5000,function()
			             {
			             });
	login_frm.cname.focus(); 
	return false;
        
    }
    else if(login_frm.email.value=="")
    {
	//alert("Please enter the phone number");
        $("#msgbox1").html('Please enter valid email Id.....').addClass('myerror').fadeOut(5000,function()
			             {
			             });
	login_frm.email.focus(); 
	return false;
    }
  
    else if(!(login_frm.email.value.match(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/)))
    {
        $("#msgbox8").html('Please enter valid email Id.....').addClass('myerror').fadeOut(5000,function()
			             {
			             });
	login_frm.email.focus(); 
	return false;
	 
		 
			
	
    }
else if(login_frm.phone.value=="")
{
	//alert("Please enter the phone number");
        $("#msgbox2").html('Please enter valid phone number.....').addClass('myerror').fadeOut(5000,function()
			             {
			             });
	login_frm.phone.focus(); 
	return false;
}
else if(isNaN(login_frm.phone.value))
{
	//alert("Invalid phone number");
         $("#msgbox5").html('Invalid phone number').addClass('myerror').fadeOut(5000,function()
			             {
			             });
	login_frm.phone.focus(); 
	return false;
}
else if((login_frm.phone.value).length < 10)
{
	//alert("Phone number should be minimum 10 digits");
         $("#msgbox6").html('Phone number should be minimum 10 digits').addClass('myerror').fadeOut(5000,function()
			             {
			             });
	login_frm.phone.focus(); 
	return false;
}
else if((login_frm.phone.value).length > 10)
{
	//alert("Phone number should be maximum 10 digits");
         $("#msgbox7").html('Phone number should be maximum 10 digits').addClass('myerror').fadeOut(5000,function()
			             {
			             });
	login_frm.phone.focus(); 
	return false;
}
else if((login_frm.password.value)=="")
{
	//alert("Phone number should be maximum 10 digits");
         $("#msgbox9").html('Please Enter Password').addClass('myerror').fadeOut(5000,function()
			             {
			             });
	login_frm.password.focus(); 
	return false;
}

else if((login_frm.password.value).length < 6)
{
	//alert("Phone number should be maximum 10 digits");
         $("#msgbox10").html('Passswor should more than or equal to 6 digit').addClass('myerror').fadeOut(5000,function()
			             {
			             });
	login_frm.password.focus(); 
	return false;
}
else if((login_frm.cpassword.value)=="")
{
	//alert("Phone number should be maximum 10 digits");
         $("#msgbox11").html('Please Enter Confirm Password').addClass('myerror').fadeOut(5000,function()
			             {
			             });
	login_frm.cpassword.focus(); 
	return false;
}

else if((login_frm.cpassword.value).length < 6)
{
	//alert("Phone number should be maximum 10 digits");
         $("#msgbox12").html('Passswor should more than or equal to 6 digit').addClass('myerror').fadeOut(5000,function()
			             {
			             });
	login_frm.cpassword.focus(); 
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

    