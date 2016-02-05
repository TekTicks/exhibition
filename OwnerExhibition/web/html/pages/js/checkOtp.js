
                   function check()
                   {
                     var generatedOTP = 1234;
                     var enteredOTP=document.getElementById('enteredOTP').value;
                if(generatedOTP==enteredOTP)
                {
                    //alert(" OTP match");
                    $("#otpMsgBox").html('OTP match').addClass('myinfo').fadeTo(900,1,function()
			             {document.location='/Exhibition/ckvInsert';
			             });
                             
              //  response.sendRedirect("/Exhibition/ckvDemoServlet");
                }
                else
                {
                     $("#otpMsgBox").html('Please Enter valid OTP').addClass('myerror').fadeTo(900,1,function()
			             {
			             });
                                     //document.location='ckvOtp.jsp';
                }
                   }	
   
   
   
    window.onload = function()
    {
      // fix for windows 8
      if (navigator.appVersion.indexOf("Windows NT 6.2") != -1)
        document.head.innerHTML += '<link rel="stylesheet" type="text/css" href="pages/css/windows.chrome.fix.css" />'
    }
   