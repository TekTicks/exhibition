
 function val2(){
     $("#msgbox5").removeClass().addClass('myinfo').text('Validating Your Login ').fadeOut(0);
if(login_frm.newpassword.value!="" && login_frm.confirmPassword.value!=="")
{
 if  ((login_frm.newpassword.value)!=(login_frm.confirmPassword.value)) {
        //alert("Passwords do not match.");
         $("#msgbox5").html('Passwords do not match.').addClass('myerror').fadeTo(500,1,function()
			             {
			             });
        return false;
        }	 
			
                        }	
    
    else
return true;
 }

 
 