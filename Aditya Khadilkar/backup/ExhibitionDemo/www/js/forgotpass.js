function forgotpass()
{
	var Otp = localStorage.getItem("otp");
	var request = createCORSRequest( "post", "http://exhibition.tekticks.co.in" );
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
		
		
		if(Otp!=otp)
		{
			myApp.alert('OTP Does Not Match..Please Re-Enter!!','OTP Error');
		}

		else
		{
		
		if(mobileNoValidate)
		{
		var data = {"password":[{"mobileNo":mobileNo,"newPassword":newPassword,"confirmPassword":confirmPassword}]};
			var sendData = function(data)
			{   
				$.ajax
				({
				url: 'http://exhibition.tekticks.co.in/application/json/forgotJson.php',
				type: 'POST',
				contentType: 'application/json',
				data: JSON.stringify(data),
				dataType: 'json',
				success: function(response)
										{
						if(JSON.stringify(response.status)==200)
						{
							
							myApp.alert('Password Changed','Password');
							
							navi();
							
							
							var a = document.getElementById('cPasswordNext');
							a.setAttribute("href","logo.html");
							document.getElementById('cPasswordNext').click();
							
						}
						/*else if(JSON.stringify(response.status)==203)
						{
							myApp.alert('Passwords does not match','Password');
						}
						
						else if(JSON.stringify(response.status)==202)
						{
							$("#loginInfo").text(JSON.stringify(response.statusMessage).replace(/"/g,""));
							$("#loginInfo").fadeIn();
						}*/
			
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
}

function changePassword()
{
	var visitorId = localStorage.getItem("visitorId");
	var request = createCORSRequest( "post", "http://exhibition.tekticks.co.in" );
	if(request)
	{
		var password = document.getElementById('cCurrentPassword').value;
		var passwordValidate = validatePassword(password);
		if(passwordValidate)
		{
			$("#passwordError").hide();
		}
		else
		{
			$("#passwordError").fadeIn();
		}
		
		var newPassword = document.getElementById('cNewPassword').value;
		var newPasswordValidate = validateNewPassword(newPassword);
		if(newPasswordValidate)
		{
			$("#newPasswordError").hide();
		}
		else
		{
			$("#newPasswordError").fadeIn();
		}
		
		var confirmPassword = document.getElementById('cConfirmPassword').value;
		var confirmPasswordValidate = validateConfirmPassword(confirmPassword);
		if(confirmPasswordValidate)
		{
			$("#confirmPasswordError").hide();
		}
		else
		{
			$("#confirmPasswordError").fadeIn();
		}
		
		
		if(newPassword!=confirmPassword)
		{
			myApp.alert('Passwords are not the same..Please Re-Enter!!','Password Error');
		}
		
		else
		{
		
		if(passwordValidate)
		{
		var data = {"password":[{"visitorId":visitorId,"password":password,"newPassword":newPassword}]};
			var sendData = function(data)
			{   
				$.ajax
				({
				url: 'http://exhibition.tekticks.co.in/application/json/changePasswordJson.php',
				type: 'POST',
				contentType: 'application/json',
				data: JSON.stringify(data),
				dataType: 'json',
				success: function(response)
										{
						if(JSON.stringify(response.status)==200)
						{
							
							myApp.alert('Password Changed','Password');
							
							navi();
							
							
							var a = document.getElementById('changePasswordNext');
							a.setAttribute("href","logo.html");
							document.getElementById('changePasswordNext').click();
							
						}
						/*else if(JSON.stringify(response.status)==203)
						{
							$("#loginInfo").text(JSON.stringify(response.statusMessage).replace(/"/g,""));
							$("#loginInfo").fadeIn();
						}
						else if(JSON.stringify(response.status)==202)
						{
							$("#loginInfo").text(JSON.stringify(response.statusMessage).replace(/"/g,""));
							$("#loginInfo").fadeIn();
						}*/
			
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
}

function generateOtp()
{
	
	var request = createCORSRequest( "post", "http://exhibition.tekticks.co.in" );
	if(request)
	{
		var mobileNo = document.getElementById('mobileNo').value;
		var data = {"otp":[{"mobileNo":mobileNo}]};
		
		var sendData = function(data)
		{
		
		$.ajax({
		url:"http://exhibition.tekticks.co.in/application/json/otpGeneration.php",
		type: 'POST',
		contentType: 'application/json',
		data: JSON.stringify(data),
		dataType:"json",
		success:function(response)
		{
			if(JSON.stringify(response.status)==200)
			{
				var otp = JSON.stringify(response.otp).replace(/"/g,"");
				localStorage.setItem("otp", otp);
				myApp.alert('Your OTP Is '+otp,'One Time Password');
			}			
			else if(JSON.stringify(response.status)==203)
			{
				myApp.alert('This Number Does Not Exist..Make A New Account!!','Error');
			}
		},
		error: function(xhr, textStatus, error)
		{
			console.log(xhr.statusText);
			console.log(textStatus);
			console.log(error);
		}
					
		
		});
		}
			sendData(data);
	}
	
}