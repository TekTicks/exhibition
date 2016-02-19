function forgotpass()
{

	localStorage.clear(); 
	var request = createCORSRequest( "post", "http://socialworker.tekticks.co.in" );
	if(request)
	{
		
		var mobileNo = document.getElementById('mobileNo').value;
		var mobileNoValidate = validatePhone(mobileNo);
		if(mobileNoValidate)
		{
			$("#mobileError").hide();
		}
		else
		{
			$("#mobileError").fadeIn();
		}
		
		var otp = document.getElementById('otp').value;
		var otpValidate = validateOtp(otp);
		if(otpValidate)
		{
			$("#otpError").hide();
		}
		else
		{
			$("#otpError").fadeIn();
		}
		
		var newPassword = document.getElementById('newPassword').value;
		var newPasswordValidate = validateNewPassword(newPassword);
		if(newPasswordValidate)
		{
			$("#newPasswordError").hide();
		}
		else
		{
			$("#newPasswordError").fadeIn();
		}
		
		var confirmPassword = document.getElementById('confirmPassword').value;
		var confirmPasswordValidate = validateConfirmPassword(confirmPassword);
		if(confirmPasswordValidate)
		{
			$("#confirmPasswordError").hide();
		}
		else
		{
			$("#confirmPasswordError").fadeIn();
		}
		
		if(mobileNoValidate)
		{
			var data = {"forgotpass":[{"mobileNo":mobileNo}]};
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
							localStorage.setItem("mobileNo", mobileNo);
							/* var visitorId = JSON.stringify(response.visitorId).replace(/"/g,"");
							localStorage.login="true";
						    localStorage.setItem("visitorId",visitorId); */
							var a = document.getElementById('next');
							a.setAttribute("href","sw_changepassword.html");
							document.getElementById('next').click();
						}
						else if(JSON.stringify(response.status)==202)
						{
							$("#mobileError").text(JSON.stringify(response.statusMessage).replace(/"/g,""));
							$("#mobileError").fadeIn();
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