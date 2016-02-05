function val2(){
    if(login_frm.emailid.value=="")
    {
        //alert("Please enter the phone number");
        $("#msgbox4").html('Please enter Emailid.....').addClass('myerror').fadeOut(5000,function()
			             {
			             });
	login_frm.emailid.focus(); 
	return false;
        
    }
    
  
    else if(!(login_frm.emailid.value.match(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/)))
    {
        $("#msgbox5").html('Please enter valid email Id.....').addClass('myerror').fadeOut(5000,function()
			             {
			             });
	login_frm.emailid.focus(); 
	return false;
	 
		 
			
	
    }

else
return true;
}
