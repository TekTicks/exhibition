
	$(document).ready(function(){
		$("#login_frm").submit(function(){
                         var countrycode=document.getElementById('prefix').value;
                               var phonenumber=document.getElementById('phone').value;
                               var result=countrycode+phonenumber;
                                document.getElementById('abc').value = result;
                                //document.getElementById('contactno').value = countrycode+phonenumber;
                              $("#msgbox1").removeClass().addClass('myinfo').text('Checking Emailid........ ').fadeOut(1);
                              $("#msgbox13").removeClass().addClass('myinfo').text('Checking phoneno........ ').fadeOut(1);
			this.timer = setTimeout(function () {
				$.ajax({
		          	url: '/Exhibition/ckvDemoServlet',
		          	data: 'emailid='+ $('#email').val()+'&contact='+ $('#abc').val()+'&cname='+ $('#cname').val()+'&password='+ $('#password').val()+'&ccode='+ $('#prefix').val(),
		          	type: 'post',
                                
		   		success: function(msg){
                                      // alert(msg);
                                if(msg != 'ERROR') // Message Sent, check and redirect
				{				// and direct to the success page
					if(msg == 'invalidemail')	
                                        {
					$("#msgbox1").html('Email id Already exists.....').addClass('myerror').fadeTo(900,1,function()
			             {
			                 //redirect to secure page
			                //document.location='ckvOtp.jsp?user='+msg;
			             });
                                        }
                                        else if(msg == 'invalidphone')
                                        {
                                            $("#msgbox13").html('phone no exists.....').addClass('myerror').fadeTo(900,1,function()
			             {
			                 //redirect to secure page
			                //document.location='ckvOtp.jsp?user='+msg;
			             });
                                        }
                                      
                                          else                                         {
                                          $("#msgbox2").html('Invalid phone id and email.....').addClass('myinfo').fadeOut(5000,0.5,function()
			             {
			                 
			             });
                                        }
                                        
                                }
				else
				{
					$("#msgbox2").fadeTo(200,0.1,function() //start fading the messagebox
		                {
			           $(this).html('valid data!!').removeClass().addClass('myinfo').fadeOut(5000,1);
                                        document.location='ownerRegOtpVerify.jsp?user='+msg;
    });
                                }
                                
                                
                                
				}
				
				});
			}, 200);
			return false;
 		
    
    });		

	});

    
 