function val1(){
    if(login_frm.login_id.value=="")
    {
        //alert("Please enter the phone number");
        $("#msgbox4").html('Please enter Emailid.....').addClass('myerror').fadeOut(5000,function()
			             {
			             });
	login_frm.login_id.focus(); 
	return false;
        
    }
    
  
    else if(!(login_frm.login_id.value.match(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/)))
    {
        $("#msgbox5").html('Please enter valid email Id.....').addClass('myerror').fadeOut(5000,function()
			             {
			             });
	login_frm.login_id.focus(); 
	return false;
	 
		 
			
	
    }

else if((login_frm.password.value)=="")
{
	//alert("Phone number should be maximum 10 digits");
         $("#msgbox6").html('Please Enter Password').addClass('myerror').fadeOut(5000,function()
			             {
			             });
	login_frm.password.focus(); 
	return false;
}

else if((login_frm.password.value).length < 6)
{
	//alert("Phone number should be maximum 10 digits");
         $("#msgbox7").html('Passswor should more than or equal to 6 digit').addClass('myerror').fadeOut(5000,function()
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




 function val2(){
     
 if((login_frm.newpassword.value)=="")
{
	//alert("Phone number should be maximum 10 digits");
         $("#msgbox1").html('Please Enter Password').addClass('myerror').fadeOut(5000,function()
			             {
			             });
	login_frm.newpassword.focus(); 
	return false;
}
else if((login_frm.newpassword.value).length < 6)
{
	//alert("Phone number should be maximum 10 digits");
         $("#msgbox2").html('Passswor should more than or equal to 6 digit').addClass('myerror').fadeOut(5000,function()
			             {
			             });
	login_frm.newpassword.focus(); 
	return false;
}


else if((login_frm.confirmPassword.value)=="")
{
	//alert("Phone number should be maximum 10 digits");
         $("#msgbox3").html('Please Enter Confirm Password').addClass('myerror').fadeOut(5000,function()
			             {
			             });
	login_frm.confirmPassword.focus(); 
	return false;
}

else if((login_frm.confirmPassword.value).length < 6)
{
	//alert("Phone number should be maximum 10 digits");
         $("#msgbox4").html('Passswor should more than or equal to 6 digit').addClass('myerror').fadeOut(5000,function()
			             {
			             });
	login_frm.confirmPassword.focus(); 
	return false;
}


else if  ((login_frm.newpassword.value)!=(login_frm.confirmPassword.value)) {
        //alert("Passwords do not match.");
         $("#msgbox5").html('Passwords do not match.').addClass('myerror').fadeOut(5000,function()
			             {
			             });
        return false;
        }	 
			
	
    
    else
return true;
 }