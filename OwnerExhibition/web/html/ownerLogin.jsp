<%-- 
    Document   : Admin
    Created on : Dec 8, 2015, 4:36:02 PM
    Author     : DJ
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8" />
    <meta charset="utf-8" />
    <title>Owner Login</title>
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
    <script src="pages/js/ownerloginValidation.js"></script>
     <script src="pages/js/ownerLoginVerification.js"></script>
    <link href="pages/css/ownerLoginAjax.css" rel="stylesheet" type="text/css" />   


</head>
   <body class="fixed-header   ">
        <div class="login-wrapper ">
            
        <!-- START Login Background Pic Wrapper-->
        <div class="bg-pic">
        <!-- START Background Pic-->
        <img src="assets/img/demo/new-york-city-buildings-sunrise-morning-hd-wallpaper.jpg" data-src="assets/img/demo/new-york-city-buildings-sunrise-morning-hd-wallpaper.jpg" data-src-retina="assets/img/demo/new-york-city-buildings-sunrise-morning-hd-wallpaper.jpg" alt="" class="lazy">
        <!-- END Background Pic-->
         </div>
         <!-- END Login Background Pic Wrapper-->
      
      
         <!-- START Login Right Container-->
         <div class="login-container bg-white">
         <div class="p-l-50 m-l-20 p-r-50 m-r-20 p-t-50 m-t-30 sm-p-l-15 sm-p-r-15 sm-p-t-40">
         <p class="p-t-35"><h2><b>Owner Login</b></h2>
         <!-- START Login Form -->
         <form name="login_frm" id="login_frm" action="" method="post" class="p-t-15" >
             <!-- START Form Control-->
             <div class="form-group form-group-default">
             <label>Email</label>
             <div class="controls">
             <input type="email" name="login_id" id="login_id" placeholder="Enter Email Id" class="form-control" required>
             </div>
            </div>
              <div id="msgbox1"></div>
            <!-- END Form Control-->
            <!-- START Form Control-->
            <div class="form-group form-group-default">
              <label>Password</label>
              <div class="controls">
              <input type="password" class="form-control" id="password" minlength="6" name="password"  placeholder="Enter Password" required>
              </div>
            </div>
            <!-- END Form Control-->
            <div id="msgbox2"></div>
            <div id="msgbox3"></div><div id="msgbox6"></div><div id="msgbox7"></div>
            <!-- START Form Control-->
            <div class="row">
            <div class="col-md-6 no-padding">
            <div class="checkbox ">
                 <input type="checkbox" value="1" id="checkbox1">
                  <label for="checkbox1">Keep Me Signed in</label> </div> </div>
            </div>
            <!-- END Form Control-->  
            <div align="right">
                <a href="/Exhibition/html/ownerLoginEmailVerify.jsp" class="text-info small"><font size="2.5"><b>Forgot Password..?</font></a>
            </div>
            <br>
            <br>
            <center>
            <button class="btn btn-primary btn-cons m-t-10" name="login" id="login"  type="submit" onclick="return val1();">Sign in</button>
            <button class="btn btn-primary btn-cons m-t-10" name="clear" id="clear"  type="reset">Clear</button>
            </center>
          </form>
          <!--END Login Form-->
          
          
          
          
          
          
          
          <div class="pull-bottom sm-pull-bottom">
            <div class="m-b-30 p-r-80 sm-m-t-20 sm-p-r-15 sm-p-b-20 clearfix">
              <div class="col-sm-3 col-md-2 no-padding">
               <img alt="" class="m-t-5" data-src="assets/img/demo/pages_icon.png" data-src-retina="assets/img/demo/pages_icon_2x.png" height="60" src="assets/img/demo/pages_icon.png" width="60">
              </div>
              <div class="col-sm-9 no-padding m-t-10">
                <p><small>
		        		Create a pages account. If you have a facebook account, log into it for this process. Sign in with <a href="#" class="text-info">Facebook</a> or <a href="#" class="text-info">Google</a></small>
                </p>
              </div>
                        <div id="error_box"></div>

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
    <script src="assets/js/scripts.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS -->
    <script>
    $(function()
    {
      $('#form-login').validate()
    })
    </script>
  </body>
</html>