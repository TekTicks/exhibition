<%-- 
    Document   : exhibitorLogin
    Created on : Jan 27, 2016, 5:56:34 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8" />
    <meta charset="utf-8" />
    <title>exhibition Administrator Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no, shrink-to-fit=no" />
    <link rel="apple-touch-icon" href="pages/ico/60.png">
    <link rel="apple-touch-icon" sizes="76x76" href="pages/ico/76.png">
    <link rel="apple-touch-icon" sizes="120x120" href="pages/ico/120.png">
    <link rel="apple-touch-icon" sizes="152x152" href="pages/ico/152.png">
    <link rel="icon" type="image/x-icon" href="favicon.ico" />
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-touch-fullscreen" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="default">
    <meta content="" name="description" />
    <meta content="" name="author" />
    <link href="assets/plugins/pace/pace-theme-flash.css" rel="stylesheet" type="text/css" />
    <link href="assets/plugins/boostrapv3/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="assets/plugins/font-awesome/css/font-awesome.css" rel="stylesheet" type="text/css" />
    <link href="assets/plugins/jquery-scrollbar/jquery.scrollbar.css" rel="stylesheet" type="text/css" media="screen" />
    <link href="assets/plugins/bootstrap-select2/select2.css" rel="stylesheet" type="text/css" media="screen" />
    <link href="assets/plugins/switchery/css/switchery.min.css" rel="stylesheet" type="text/css" media="screen" />
    <link href="pages/css/pages-icons.css" rel="stylesheet" type="text/css">
    <link class="main-stylesheet" href="pages/css/pages.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="pages/js/jquery-1.4.2.min.js"></script>
    <!--<script src="assets/js/checkPassword.js" type="text/javascript"></script> -->
    <!--[if lte IE 9]>
        <link href="pages/css/ie9.css" rel="stylesheet" type="text/css" />
    <![endif]-->
    
    <script type="text/javascript">
	$(document).ready(function(){
		$("#login_frm").submit(function(){

			 //remove previous class and add new "myinfo" class
	     //   $("#msgbox").removeClass().addClass('myinfo').text('Validating Your Login ').fadeIn(1000);

			
			this.timer = setTimeout(function () {
				$.ajax({
		          	url: '/Exhibition/html/ForgotPasswordServlet',
		          	data: 'un='+ $('#newpassword').val() +'&pw=' + $('#confirmpassowrd').val(),
		          	type: 'post',
		   		success: function(msg){
                                alert(msg);
                                if(msg != 'ERROR') // Message Sent, check and redirect
				{
                                      
                                      
                                          $("#msgbox3").html('Data updated successfully').addClass('myinfo').fadeTo(900,1,function()
			             {
			                 //redirect to secure page
			              document.location='/Exhibition/html/report.jsp?user='+msg;
			             });
                                        
                                    
                                  
                                }
				else
				{
					$("#msgbox3").fadeTo(200,0.1,function() //start fading the messagebox
		                {
			                  //add message and change the class of the box and start fading
			                 $(this).html('sorry ..mobileNo not found').removeClass().addClass('myerror').fadeTo(900,1);
                                 });
                                }
				
				
				});
			}, 200);
			return false;
 		});		

	});
   </script>  
<style>
#exists{display:none}
#cross{display:none}
.myinfo
{
	margin: 5px auto;
	background:#d6e3f5;
	border: 1px #0010ac solid;
	padding:5px;
	color:#0010ac;
	font-size:12px;
	width:350px;
	min-height:0px;
	-moz-border-radius:4px;
	-webkit-border-radius:4px;
	text-align: center;
}

.myerror
{
	margin: 5px auto;
	background:#FFDFDF;
	border: 1px #FF0000 solid;
	padding:5px;
	color:#FF0000;
	font-size:12px;
	width:350px;
	min-height:0px;
	-moz-border-radius:4px;
	-webkit-border-radius:4px;
	text-align: center;
}
</style>
   
     <script type="text/javascript">
    window.onload = function()
    {
      // fix for windows 8
      if (navigator.appVersion.indexOf("Windows NT 6.2") != -1)
        document.head.innerHTML += '<link rel="stylesheet" type="text/css" href="pages/css/windows.chrome.fix.css" />'
    }
    </script>
  </head>
  <body class="fixed-header ">
 <div class="login-wrapper "> -->
    <div class="bg-pic">
        <!-- START Background Pic-->
      <img src="assets/img/demo/new-york-city-buildings-sunrise-morning-hd-wallpaper.jpg" data-src="assets/img/demo/new-york-city-buildings-sunrise-morning-hd-wallpaper.jpg" data-src-retina="assets/img/demo/new-york-city-buildings-sunrise-morning-hd-wallpaper.jpg" alt="" class="lazy">
        <!-- END Background Pic-->
        <!-- START Background Caption-->
        <div class="bg-caption pull-bottom sm-pull-bottom text-white p-l-20 m-b-20">
        <!--  <h2 class="semi-bold text-white">
					Pages make it easy to enjoy what matters the most in the life</h2>
          <p class="small">
            images Displayed are solely for representation purposes only, All work copyright of respective owner, otherwise � 2013-2014 REVOX.
          </p>-->
        </div>
        <!-- END Background Caption-->
      </div>
      <div class="login-container bg-white">
        <div class="p-l-50 m-l-20 p-r-50 m-r-20 p-t-50 m-t-30 sm-p-l-15 sm-p-r-15 sm-p-t-40">
            <h1> <center> Forgot Password </center></h1> <br> <br>
          
          <!-- START Login Form -->
          <form id="login_frm" class="p-t-15" role="form" action="/Exhibition/ForgotPasswordServlet" >
            <!-- START Form Control-->
           
             <div class="form-group form-group-default">
            
              <div class="controls">
             <input type="password" class="form-control" id="newpassword" name="newpassword" placeholder="Enter New Password" style="text-align: center" required>
            </div>  	<div id="msgbox1"></div></div>
           <div class="form-group form-group-default">
            
              <div class="controls">
<input type="password" class="form-control" id="confirmpassword" name="confirmpassword" placeholder="Confirm Password" style="text-align: center" required>
            </div>	<div id="msgbox2"></div> </div>
            <div id="msgbox3"></div>
            
            
              <div class="row">
            
                  <button class="btn btn-primary btn-cons m-t-10" type="submit" >Update</button> 
                  
                 <button class="btn btn-primary btn-cons m-t-10" type="submit" onclick="/Exhibition/html/exhibitionAdminLog.jsp">Cancel</button>  </div>
           
          </form>
          <!--END Login Form-->
          
        </div>
      </div> </div>
      <!-- END Login Right Container-->
  <!--  </div> -->
   
    <script src="assets/plugins/pace/pace.min.js" type="text/javascript"></script>
    <script src="assets/plugins/jquery/jquery-1.11.1.min.js" type="text/javascript"></script>
    <script src="assets/plugins/modernizr.custom.js" type="text/javascript"></script>
    <script src="assets/plugins/jquery-ui/jquery-ui.min.js" type="text/javascript"></script>
    <script src="assets/plugins/boostrapv3/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="assets/plugins/jquery/jquery-easy.js" type="text/javascript"></script>
    <script src="assets/plugins/jquery-unveil/jquery.unveil.min.js" type="text/javascript"></script>
    <script src="assets/plugins/jquery-bez/jquery.bez.min.js"></script>
    <script src="assets/plugins/jquery-ios-list/jquery.ioslist.min.js" type="text/javascript"></script>
    <script src="assets/plugins/jquery-actual/jquery.actual.min.js"></script>
    <script src="assets/plugins/jquery-scrollbar/jquery.scrollbar.min.js"></script>
    <script type="text/javascript" src="assets/plugins/bootstrap-select2/select2.min.js"></script>
    <script type="text/javascript" src="assets/plugins/classie/classie.js"></script>
    <script src="assets/plugins/switchery/js/switchery.min.js" type="text/javascript"></script>
    <script src="assets/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
       
    <!-- END VENDOR JS -->
    <script src="pages/js/pages.min.js"></script>
    <script>
    $(function()
    {
      $('#form-login').validate();
    });
    </script>
  </body>
</html>
