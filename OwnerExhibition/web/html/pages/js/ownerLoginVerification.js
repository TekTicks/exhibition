$(document).ready(function(){
		$("#login_frm").submit(function(){

			 //remove previous class and add new "myinfo" class
	        $("#msgbox3").removeClass().addClass('myinfo').text('Validating Your Login ').fadeOut(1000);
                $("#msgbox1").removeClass().addClass('myinfo').text('Validating Your Login ').fadeOut(0);

			
			this.timer = setTimeout(function () {
				$.ajax({
		          	url: '/Exhibition/AdminLoginCheck',
		          	data: 'un='+ $('#login_id').val() +'&pw=' + $('#password').val(),
		          	type: 'post',
		   		success: function(msg){
                                  
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
			                 //redirect to secure page
			                 document.location='/Exhibition/html/index.html';
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
        
        
    window.onload = function()
    {
      // fix for windows 8
      if (navigator.appVersion.indexOf("Windows NT 6.2") != -1)
        document.head.innerHTML += '<link rel="stylesheet" type="text/css" href="pages/css/windows.chrome.fix.css" />'
    }
