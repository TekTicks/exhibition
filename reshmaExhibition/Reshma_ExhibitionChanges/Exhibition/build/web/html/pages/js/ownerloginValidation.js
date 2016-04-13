
 function val2(){
     $("#msgbox3").removeClass().addClass('myinfo').text('Validating Your Login ').fadeOut(0);
if(login_frm.password.value!="" && login_frm.cpassword.value!=="")
{
 if  ((login_frm.password.value)!=(login_frm.cpassword.value)) {
        //alert("Passwords do not match.");
         $("#msgbox3").html('Passwords do not match.').addClass('myerror').fadeTo(500,1,function()
			             {
			             });
        return false;
        }	 
			
                        }	
    
    else
return true;
 }

 
 