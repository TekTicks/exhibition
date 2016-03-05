
  
<HTML>
    <head>
        <%-- 
    Document   : data
    Created on : Mar 3, 2016, 12:07:46 PM
    Author     : Admin
--%>
<%@ page import="exhibitionAdministrator.*;" %>
<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload" %>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@ page import="org.apache.commons.fileupload.*"%>
<%@ page import="java.util.*, java.io.*" %>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page import="java.io.File"%>
 

<%@page import = "java.sql.ResultSet;"%>
<%@page import ="java.sql.Statement;"%>
<%@page import = "exhibitionAdministrator.exhibitionAdministratorOneTimeConnection;"%>
<%@page import = "java.sql.Connection;"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <%@ page language="java" %>
  <%@ page import="java.io.*,java.sql.*,java.util.zip.*" %>
  
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8" />
    <meta charset="utf-8" />
    <title>Pages - Admin Dashboard UI Kit - Form Wizard</title>
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
    <!--[if lte IE 9]>
	<link href="assets/plugins/codrops-dialogFx/dialog.ie.css" rel="stylesheet" type="text/css" media="screen" />
	<![endif]-->
      <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="pages/js/jquery-1.4.2.min.js"></script>
   
 
    </head>
    <body>

                          
                           <FORM ENCTYPE="multipart/form-data" ACTION="uploadFile1.jsp" METHOD=POST name="login" id="login">

 <div id="uploadFormLayer">
<label><b>Upload Image File:</b></label><br/>
<input name="file" type="file" class="inputFile" onchange="readURL(this);"  />
	<script type="text/javascript">
									function readURL(input) {
									if (input.files && input.files[0]) {
									var reader = new FileReader();
									reader.onload = function (e) {
									$('#tempImg')
									.attr('src', e.target.result)
									.width(125)
									.height(125);
									$('#flag').val("1");
									};
									reader.readAsDataURL(input.files[0]);
									}
									}
									</script>
									<input type="hidden" id="flag" name="flag">
	<img id="tempImg"  src="" width="125" height="125"> 
 </div>  
                               


                               
            <button class="btn btn-success" name="login" id="name" type="submit" value="submit">Save</button>
                          <button class="btn btn-default">Cancel</button>
                       
      </form>

         <script type="text/javascript">
	$(document).ready(function(e){
		$("#login").on('submit',(function(e){
	       //remove previous class and add new "myinfo" class
	       // $("#msgbox").removeClass().addClass('myinfo').text('Validating Your Login ').fadeIn(1000);
			this.timer = setTimeout(function () {
				$.ajax({
		          	url: '/Exhibition/ImageServlet',
		          	data: 'file=' + $('#123').val() ,
		          	type: 'post',
		   		success: function(msg){ 
                                    alert(msg);
                                if(msg != 'error') // Message Sent, check and redirect
				{
                                        if(msg !='wrn')
                                        {
                                          $("#msgbox1").html('data inserted').addClass('myinfo').fadeTo(200,1,function()
			             {
			                 //redirect to secure page
			              //document.location='/Exhibition/html/exhibitionAdminPersonal.jsp';
			             });      
                                    }
                                else
                                {
                                    $("#msgbox2").fadeTo(100,1,function() //start fading the messagebox
		                {
			                  //add message and change the class of the box and start fading
			                 $(this).html('records are not inserted..').removeClass().addClass('myerror').fadeTo(300,1);
                                        // document.location='/Exhibition/html/exhibitionAdminLog.jsp?user';
                                 });
                                }
                            }
                            else
                            {
                                $("#msgbox2").fadeTo(100,1,function() //start fading the messagebox
		                {
			                  //add message and change the class of the box and start fading
			                 $(this).html('sorry').removeClass().addClass('myerror').fadeTo(300,1);
                                        // document.location='/Exhibition/html/exhibitionAdminLog.jsp?user';
                                 });
                            }
                                }
				});
			}, 200);
			return false;
 		}));		

	});
   </script> 	
    
      
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
    <script src="assets/plugins/bootstrap3-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
    <script type="text/javascript" src="assets/plugins/jquery-autonumeric/autoNumeric.js"></script>
    <script type="text/javascript" src="assets/plugins/dropzone/dropzone.min.js"></script>
    <script type="text/javascript" src="assets/plugins/bootstrap-tag/bootstrap-tagsinput.min.js"></script>
    <script type="text/javascript" src="assets/plugins/jquery-inputmask/jquery.inputmask.min.js"></script>
    <script src="assets/plugins/boostrap-form-wizard/js/jquery.bootstrap.wizard.min.js" type="text/javascript"></script>
    <script src="assets/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
    <script src="assets/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js" type="text/javascript"></script>
    <script src="assets/plugins/summernote/js/summernote.min.js" type="text/javascript"></script>
    <script src="assets/plugins/moment/moment.min.js"></script>
    <script src="assets/plugins/bootstrap-daterangepicker/daterangepicker.js"></script>
    <script src="assets/plugins/bootstrap-timepicker/bootstrap-timepicker.min.js"></script>
    <!-- END VENDOR JS -->
    <!-- BEGIN CORE TEMPLATE JS -->
    <script src="pages/js/pages.min.js"></script>
    <!-- END CORE TEMPLATE JS -->
    <!-- BEGIN PAGE LEVEL JS -->
    <script src="assets/js/form_wizard.js" type="text/javascript"></script>
    <script src="assets/js/scripts.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS -->
</body>
</HTML>