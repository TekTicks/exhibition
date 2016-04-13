<%
response.setHeader("Cache-Control", "no-cache"); //Forces caches to obtain a new copy of the page from the origin server
response.setHeader("Cache-Control", "no-store"); //Directs caches not to store the page under any circumstance
response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
response.setHeader("Pragma", "no-cache"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
      <meta http-equiv="Pragma" content="no-cache"> 
<meta http-equiv="Expires" content="-1"> 
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate"> 
    <meta http-equiv="content-type" content="text/html;charset=UTF-8" />
    <meta charset="utf-8" />
    <title>Administrator Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <link rel="apple-touch-icon" href="pages/ico/60.png"> 
    <link rel="apple-touch-icon" sizes="76x76" href="pages/ico/76.png">
    <link rel="apple-touch-icon" sizes="120x120" href="pages/ico/120.png">
    <link rel="apple-touch-icon" sizes="152x152" href="pages/ico/152.png"> 
    <link rel="icon" type="image/x-icon" href="favicon.ico" />
    <meta name="apple-mobile-web-app-capable" content="yes">
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
    <link href="pages/css/ie9.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="pages/js/jquery-1.4.2.min.js"></script>
    <link href="pages/css/ownerLoginAjax.css" rel="stylesheet" type="text/css" />  
    <script type="text/javascript">
	$(document).ready(function()
        {
		$("#login_frm").submit(function()
                {
                    $("#msgbox3").removeClass().addClass('myinfo').text('Validating Your Login ').fadeOut(0);
                $("#msgbox1").removeClass().addClass('myinfo').text('Validating Your Login ').fadeOut(0);
                $("#msgbox2").removeClass().addClass('myinfo').text('Validating Your Login ').fadeOut(0);
                $("#msgbox4").removeClass().addClass('myinfo').text('Validating Your Login ').fadeOut(0);
                	 //remove previous class and add new "myinfo" class
                      //  $("#msgbox").removeClass().addClass('myinfo').text('Validating Your Login ').fadeIn(1000);		
			this.timer = setTimeout(function () 
                        {
				$.ajax(
                                {
                                	url: '/Exhibition/exhibitionAdministratorLoginCheck',
                                        data: 'un='+ $('#login_id').val() +'&pw=' + $('#password').val(),
                                        type: 'post',
                                        success: function(msg){  
                                           
                                        if(msg != 'ERROR') // Message Sent, check and redirect
                                        { 
                                            if(msg == 'emIn')
                                            {  
                                             	$("#msgbox1").fadeTo(200,0.1,function() //start fading the messagebox
                                                {
                                                //add message and change the class of the box and start fading
                                                    $(this).html('Sorry, Invalid Email.!').removeClass().addClass('myerror').fadeTo(900,1);
                                                });
                                            }
                                            else if(msg == 'passwordinvalid')
                                            {
                                               	$("#msgbox3").fadeTo(200,0.1,function() //start fading the messagebox
                                                {
                                                     //add message and change the class of the box and start fading
                                                      $(this).html('Sorry, Wrong Password.!').removeClass().addClass('myerror').fadeTo(900,1);
                                                });
                                            }
                                            else
                                            {
                                             
                                                 if(msg != 'secondVisitor') 
                                                 {
                                                    	$("#msgbox2").fadeTo(200,0.1,function() //start fading the messagebox
                                                {
                                                    //add message and change the class of the box and start fading
                                                    $(this).html('Login Verified(first Vistor)..!').removeClass().addClass('myinfo').fadeTo(900,1);
                                       document.location='/Exhibition/html/exhibitionAdministratorContactInformationFirstTimeUse.jsp';
                                                });
                                            }
                                            else
                                            {
                                             $("#msgbox2").fadeTo(200,0.1,function() //start fading the messagebox
                                                    {
                                                        //add message and change the class of the box and start fading
                                                         $(this).html('Login Verified(second Visitor)..!').removeClass().addClass('myinfo').fadeTo(900,1);
                                                         document.location='/Exhibition/html/exhibitionAdministratorProfilePage.jsp';
                                                    });
                                             
                                            }  
                                        
                                    }
                                
                                } 
				else
				{
					$("#msgbox4").fadeTo(200,0.1,function() //start fading the messagebox
		                {
			                  //add message and change the class of the box and start fading
			                 $(this).html('Sorry, Wrong Combination Of Username And Password.!').removeClass().addClass('myerror').fadeTo(900,1);
                                       //  document.location='/Exhibition/html/exhibitionAdministratorLogin.jsp?user';
                                 });
                                }
				}
				
				});
			}, 200);
			return false;
 		});		

	});
   </script>   
 
<script type="text/javascript">
    function clearForm(oForm) 
    {
          var elements = oForm.elements; 
          oForm.reset();
          for(i=0; i<elements.length; i++) 
          {
            field_type = elements[i].type.toLowerCase();
            switch(field_type) 
            {
                case "text": 
                case "password": 
                case "msg" :
                elements[i].value = ""; 
                break;
                default: 
                break;
            }
        }
    }
    
    </script>
</head>
   <BODY class="fixed-header ">
             <div class="login-wrapper ">
             <!-- START Login Background Pic Wrapper-->
                <div class="bg-pic">
                    <!-- START Background Pic-->
                    <img src="assets/img/demo/new-york-city-buildings-sunrise-morning-hd-wallpaper.jpg" data-src="assets/img/demo/new-york-city-buildings-sunrise-morning-hd-wallpaper.jpg" data-src-retina="assets/img/demo/new-york-city-buildings-sunrise-morning-hd-wallpaper.jpg" alt="" class="lazy">
                    <!-- END Background Pic-->
                    <!-- START Background Caption-->
                    <div class="bg-caption pull-bottom sm-pull-bottom text-white p-l-20 m-b-20">
                    <!--  <h2 class="semi-bold text-white">Pages make it easy to enjoy what matters the most in the life</h2>
                    <p class="small">
                    images Displayed are solely for representation purposes only, All work copyright of respective owner, otherwise � 2013-2014 REVOX.
                    </p>-->
                    </div>
                    <!-- END Background Caption-->
                </div>
                <!-- END Login Background Pic Wrapper-->
                <!-- START Login Right Container-->
                <div class="login-container bg-white">
                    <div class="p-l-50 m-l-20 p-r-50 m-r-20 p-t-50 m-t-30 sm-p-l-15 sm-p-r-15 sm-p-t-40">
                        <!-- <img src="assets/img/logo.png" alt="logo" data-src="assets/img/logo.png" data-src-retina="assets/img/logo_2x.png" width="78" height="22"> -->
                        <p class="p-t-35"><h2><b>Administrator Login</b></h2>
                        <!-- START Login Form -->
                        <form name="login_frm" id="login_frm" action="" method="post" class="p-t-15" >
                        <!-- START Form Control-->
                        <div class="form-group form-group-default">
                            <label>Email</label>
                            <div class="controls">
                            <input type="text" name="login_id" id="login_id" placeholder="" class="form-control" required>
                            </div>
                         
                        </div>   <div id="msgbox1"></div>
                        <!-- END Form Control-->
                        <!-- START Form Control-->
                    <div class="form-group form-group-default">
                        <label>Password</label>
                        <div class="controls">
                        <input type="password" class="form-control" id="password" name="password"  placeholder="Credentials" required>
                        </div>
                    </div>
                    <div id="msgbox3"></div> 
                    <!-- START Form Control-->
                    <div class="row">
                    <div class="col-md-6 no-padding">
                    <div class="checkbox ">
                    <!--<input type="checkbox" value="1" id="checkbox1">
                    <label for="checkbox1">Keep Me Signed in</label>-->
                    <a href="/Exhibition/html/exhibitionAdministratorMobileNo.jsp" class="text-info small">Forgot Password..?</a>
                   </div>
              </div>
              <div class="col-md-6 text-right">
              </div>
            </div>   <div id="msgbox2"></div> <div id="msgbox4"></div> 
            <!-- END Form Control-->    
            <button class="btn btn-primary btn-cons m-t-10" name="login" id="login"  type="submit">Sign in</button>
            <button class="btn btn-primary btn-cons m-t-10" name="clear" id="clear"  type="button" value="Clear Form" onclick="clearForm(this.form);">Clear</button>

    </form> 
          <!--END Login Form-->
          <div class="pull-bottom sm-pull-bottom">
            <div class="m-b-30 p-r-80 sm-m-t-20 sm-p-r-15 sm-p-b-20 clearfix">
              <div class="col-sm-3 col-md-2 no-padding">
                <!--      <img alt="" class="m-t-5" data-src="assets/img/demo/pages_icon.png" data-src-retina="assets/img/demo/pages_icon_2x.png" height="60" src="assets/img/demo/pages_icon.png" width="60">
                </div>
                <div class="col-sm-9 no-padding m-t-10">
                <p><small>
   		Create a pages account. If you have a facebook account, log into it for this process. Sign in with <a href="#" class="text-info">Facebook</a> or <a href="#" class="text-info">Google</a></small>
                </p>-->
              </div>
            </div>
          </div>
        </div>
      </div>
      <!-- END Login Right Container-->
    </div>
    <!-- END PAGE CONTAINER -->
    <!-- BEGIN VENDOR JS -->
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
    <!-- BEGIN CORE TEMPLATE JS -->
    <script src="pages/js/pages.min.js"></script>
    <!-- END CORE TEMPLATE JS -->
    <!-- BEGIN PAGE LEVEL JS -->
     </body>
</html>