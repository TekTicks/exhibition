$(document).ready(function(){
		$("#login_frm").submit(function(){

			 //remove previous class and add new "myinfo" class
	        $("#msgbox3").removeClass().addClass('myinfo').text('Validating Your Login ').fadeOut(0);
                $("#msgbox1").removeClass().addClass('myinfo').text('Validating Your Login ').fadeOut(0);

			
			this.timer = setTimeout(function () {
				$.ajax({
		          	url: '/Exhibition/OwnerLoginCheck',
		          	data: 'un='+ $('#login_id').val() +'&pw=' + $('#password').val(),
		          	type: 'post',
		   		success: function(msg){
                                  alert(msg);
                                if(msg != 'ERROR') // Message Sent, check and redirect
				{
                                        if(msg == 'emailinvalid')
                                        {
                                             	$("#msgbox1").fadeTo(200,0.1,function() //start fading the messagebox
                                                {
                                                 //add message and change the class of the box and start fading
                                                 $(this).html('EmailId doesnt exists...').removeClass().addClass('myerror').fadeTo(900,10);
                                                });
                                        }
                                        else if(msg =='passwordinvalid')
                                        {
                                               
                                               	$("#msgbox3").fadeTo(200,0.1,function() //start fading the messagebox
                                                    {
                                             //add message and change the class of the box and start fading
                                            $(this).html('Sorry, Wrong Password.').removeClass().addClass('myerror').fadeTo(900,1);
                                          });
 
                                         }
                                    else
                                    {
                                          $("#msgbox3").html('Login Verified, Logging in.....').addClass('myinfo').fadeTo(900,1,function()
			             {
                                          document.location='/Exhibition/html/index.html';
			                 //redirect to secure page
			               
			             });
                                        
                                    }
                                
                                }
				else
				{
					$("#msgbox3").fadeTo(200,0.1,function() //start fading the messagebox
		                {
			                 $(this).html('Sorry, Wrong Combination Of Username And Password.').removeClass().addClass('myerror').fadeTo(900,1);
                                 }); 
                                }
				}
				
				});
			}, 200);
			return false;
 		});		

	});     