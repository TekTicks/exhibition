
 function val2(){
if(login_frm.newpassword.value!="" && login_frm.confirmPassword.value!=="")
{
 if  ((login_frm.newpassword.value)!=(login_frm.confirmPassword.value)) {
        //alert("Passwords do not match.");
         $("#msgbox5").html('Passwords do not match.').addClass('myerror').fadeOut(5000,function()
			             {
			             });
        return false;
        }	 
			
                        }	
    
    else
return true;
 }

 
 