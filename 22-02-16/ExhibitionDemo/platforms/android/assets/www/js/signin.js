function signin()
{
	localStorage.clear(); 
	var request = createCORSRequest( "post", "http://socialworker.tekticks.co.in" );
	if(request)
	{
		var emailId = document.getElementById('emailId').value;
		var emailIdValidate = validateEmail(emailId);
		if(emailIdValidate)
		{
			$("#emailError").hide();
		}
		else
		{
			$("#emailError").fadeIn();
		}
		var password = document.getElementById('password').value;
		var passwordValidate = validatePassword(password);
		if(passwordValidate)
		{
			$("#passwordError").hide();
		}
		else
		{
			$("#passwordError").fadeIn();
		}
		if(mobileNoValidate && passwordValidate)
		{
		var data = {"signIn":[{"mobileNo":mobileNo,"password":password}]};
			var sendData = function(data)
			{   
				$.ajax
				({
				url: 'http://socialworker.tekticks.co.in/json/signInJson.php',
				type: 'POST',
				contentType: 'application/json',
				data: JSON.stringify(data),
				dataType: 'json',
				success: function(response)
					{
						if(JSON.stringify(response.status)==200)
						{
							$("#mobileError").hide();
							$("#passwordError").hide();
							var visitorId = JSON.stringify(response.visitorId).replace(/"/g,"");
							localStorage.setItem("visitorId",visitorId);
							$("#signupnow").fadeOut();
							$("#signinnow").fadeOut();
							$("#profile").fadeIn();	
							var a = document.getElementById('next');
							a.setAttribute("href","sw_index.html");
							document.getElementById('next').click();
							
						}
						else if(JSON.stringify(response.status)==203)
						{
							$("#mobileError").text(JSON.stringify(response.statusMessage).replace(/"/g,""));
							$("#mobileError").fadeIn();
						}
						else if(JSON.stringify(response.status)==202)
						{
							$("#passwordError").text(JSON.stringify(response.statusMessage).replace(/"/g,""));
							$("#passwordError").fadeIn();
						}
			
					},
					error: function(xhr, textStatus, error)
					{
						console.log(xhr.statusText);
						console.log(textStatus);
						console.log(error);
					}
				});
			};
			sendData(data);
		}
	}
}
	
 
	







	