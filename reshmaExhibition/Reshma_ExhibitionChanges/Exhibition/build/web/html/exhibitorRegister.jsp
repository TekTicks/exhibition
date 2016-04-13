<%@page import="ownerPortal.dbConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
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
     <script src="assets/js/phoneNoValidation.js" type="text/javascript"></script>
    <!--[if lte IE 9]>
	<link href="assets/plugins/codrops-dialogFx/dialog.ie.css" rel="stylesheet" type="text/css" media="screen" />
	<![endif]-->
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="pages/js/jquery-1.4.2.min.js"></script>

  <script type="text/javascript">
	$(document).ready(function(){
		$("#form-register").submit(function(){

			 //remove previous class and add new "myinfo" class
	       // $("#msgbox").removeClass().addClass('myinfo').text('Validating Your Login ').fadeIn(1000);

			
			this.timer = setTimeout(function () {
				$.ajax({   
		          	url: '/Exhibition/exhibitorRegister',
		          	data: 'companyName='+ $('#companyName').val() +'&userName=' + $('#userName').val()+'&email=' + $('#email').val() +'&password=' + $('#password').val()+'&cpassword=' + $('#cpassword').val()+'&countryId=' + $('#countryId').val()+'&mobileNo=' + $('#phone').val() +'&exId=' + $('#exId').val(),
		          	type: 'post',
		   		success: function(msg){
                                
                                if(msg != 'error') // Message Sent, check and redirect
				{
                                        if(msg == 'passwordInvalid')
                                        {
                                         $("#msgbox1").fadeTo(300,1,function() //start fading the messagebox
                                       {
                                            //add message and change the class of the box and start fading
                                             $(this).html('Password invalid..!').removeClass().addClass('myinfo').fadeTo(300,1).fadeout();
                                          //  document.location='/Exhibition/html/exhibitionAdministratorContactInformationFirstTimeUse.jsp';
                                     });
                                        
                                    }
                                   else if(msg == 'emailInvalid')
                                        {
                                         $("#msgbox2").fadeTo(300,1,function() //start fading the messagebox
                                       {
                                            //add message and change the class of the box and start fading
                                             $(this).html('email invalid.!').removeClass().addClass('myinfo').fadeTo(300,1).fadeout();
                                          //  document.location='/Exhibition/html/exhibitionAdministratorContactInformationFirstTimeUse.jsp';
                                     });
                                        
                                    }
                                 else if(msg == 'mobileNoInvalid')
                                        {
                                         $("#msgbox3").fadeTo(300,1,function() //start fading the messagebox
                                       {
                                            //add message and change the class of the box and start fading
                                             $(this).html('mobileNo invalid..!').removeClass().addClass('myinfo').fadeTo(300,1).fadeout();
                                          //  document.location='/Exhibition/html/exhibitionAdministratorContactInformationFirstTimeUse.jsp';
                                     });
                                        
                                    }
				
                                else 
                                { 
                                    
                                         $("#msgbox4").fadeTo(300,1,function() //start fading the messagebox
                                       {
                                            //add message and change the class of the box and start fading
                                             $(this).html('records saved..!').removeClass().addClass('myinfo').fadeTo(300,1).fadeout();
                                         // document.location.href='/Exhibition/html/exhibitionAdministratorSector.jsp';
                                           //document.location='/Exhibition/html/exhibitorView.jsp';
                                     });
                                 document.location='/Exhibition/exhibitorInsert';

                                     
                                }
                                }
                            else
                            {
                               $("#msgbox4").fadeTo(300,1,function() //start fading the messagebox
                                                {
                                                //add message and change the class of the box and start fading
                                                    $(this).html('sorry sql exceptions are there!').removeClass().addClass('myerror').fadeTo(300,1).fadeOut();
                                                });
                                }
                            
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
	background:white;
	border: 0px;
	padding:5px;
	color:#0010ac;
	font-size:13px;
	width:350px;
	min-height:0px;
	-moz-border-radius:4px;
	-webkit-border-radius:4px;
	text-align: left;
}

.myerror
{
	margin: 5px auto;
	background:white;
	border: 0px;
	padding:5px;
	color:#FF0000;
	font-size:12px;
	width:350px;
	min-height:0px;
	-moz-border-radius:4px;
	-webkit-border-radius:4px;
	text-align:left;
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
  <body class="fixed-header   ">
    <div class="register-container full-height sm-p-t-30">
      <div class="container-sm-height full-height">
        <div class="row row-sm-height">
            <div class="col-sm-12 col-sm-height col-middle"><br><br>
            <img src="assets/img/logo.png" alt="logo" data-src="assets/img/logo.png" data-src-retina="assets/img/logo_2x.png" width="78" height="22">
            <h3></h3>
            <p>
              <small>
        Create a pages account. If you have a facebook account, log into it for this process. Sign in with <a href="#" class="text-info">Facebook</a> or <a href="#" class="text-info">Google</a>
    </small>
            </p>
            <form id="form-register" name="form-register" class="p-t-15" role="form" action="" method="">
             <div class="row">
                <div class="col-sm-12">
                  <div class="form-group form-group-default">
                    <label> Company Name</label>
                    <input type="text" name="companyName" id="companyName" placeholder="comapny name" class="form-control" required>
                  </div>
                </div>
              </div>
              <div class="row">
                <div class="col-sm-12">
                  <div class="form-group form-group-default">
                    <label> User Name</label>
                    <input type="email" name="userName" id="userName" placeholder="username as email" class="form-control" required>
                  </div>
                </div>
              </div>
                <div class="row">
                <div class="col-sm-12">
                  <div class="form-group form-group-default">
                    <label> Email</label>
                    <input type="email" name="email" id="email" placeholder="email id" class="form-control" required>
                  </div>
                </div>
              </div> <div id="msgbox1"></div>
              <div class="row">
                <div class="col-sm-12">
                  <div class="form-group form-group-default">
                    <label>Password</label>
                    <input type="password" name="password" id="password" placeholder="Minimum of 6 Charactors" class="form-control" required>
                  </div>
                </div>
              </div> 
                 <div class="row">
                <div class="col-sm-12">
                  <div class="form-group form-group-default">
                    <label>Confirm Password</label>
                    <input type="password" name="cpassword"  id="cpassword" placeholder="Minimum of 6 Charactors" class="form-control" required>
                  </div>
                </div>
              </div><div id="msgbox2"></div>
              
              <div class="row">    
                   <div class="form-group form-group-default">
                     
                    <div class="col-sm-4">
                        <label>Country Code</label>
                     <%    
                    try { 
                         
                           Connection con;
                        con=dbConnection.getConnection();
                           Statement sta1=con.createStatement();
                           ResultSet rsy=sta1.executeQuery("select * from country ");
                           int cou1=0;
                     %>
                      
                        <select class="cs-select cs-skin-slide cs-transparent" data-init-plugin="select2" name="countryId" id="countryId">  
                       <optgroup label="Select id">
                         <% while(rsy.next())
                         { 
                           String id1=rsy.getString(1);
                         
                         %>
                        <option class="" value="<%=id1%>"> <%out.print(rsy.getString(4));%> </option>
                         <%   
                         }
                        } 
                   catch(Exception e) 
                      { 
                      out.print("error" +e); 
                      }
                        %>  
                         
                        </select> </div>
                          <div class="col-sm-4">
                    <label> Mobile No</label>
                    <input type="text" name="phone" id="phone" onkeypress="return validate(event)" maxlength="10" placeholder="mobile no" class="form-control" required>
                  </div>
                   </div> </div>
             <div id="msgbox3"></div>
               <div class="form-group form-group-default">
                           <label>Is Main Exhibitor</label>
                        <select class="full-width" data-init-plugin="select2" name="exId" id="exId">   
                        <option value="1">Yes</option>
                        <option value="0">No</option>
                        </select>
                      </div>  
             
              
             <div id="msgbox4"></div>
                        <button class="btn btn-primary btn-cons m-t-10" type="submit">Create a new account</button>
                        <button class="btn btn-primary btn-cons m-t-10" type="button" onclick="document.location.href='/Exhibition/html/exhibitorView.jsp';">Cancel</button>
                          <br><br><br>
            </form>
          </div>
        </div>
      </div>
    </div>
                        <br><br><br>
    <!-- START OVERLAY -->
    <div class="overlay hide" data-pages="search">
      <!-- BEGIN Overlay Content !-->
      <div class="overlay-content has-results m-t-20">
        <!-- BEGIN Overlay Header !-->
        <div class="container-fluid">
          <!-- BEGIN Overlay Logo !-->
          <img class="overlay-brand" src="assets/img/logo.png" alt="logo" data-src="assets/img/logo.png" data-src-retina="assets/img/logo_2x.png" width="78" height="22">
          <!-- END Overlay Logo !-->
          <!-- BEGIN Overlay Close !-->
          <a href="#" class="close-icon-light overlay-close text-black fs-16">
            <i class="pg-close"></i>
          </a>
          <!-- END Overlay Close !-->
        </div>
        <!-- END Overlay Header !-->
        <div class="container-fluid">
          <!-- BEGIN Overlay Controls !-->
          <input id="overlay-search" class="no-border overlay-search bg-transparent" placeholder="Search..." autocomplete="off" spellcheck="false">
          <br>
          <div class="inline-block">
            <div class="checkbox right">
              <input id="checkboxn" type="checkbox" value="1" checked="checked">
              <label for="checkboxn"><i class="fa fa-search"></i> Search within page</label>
            </div>
          </div>
          <div class="inline-block m-l-10">
            <p class="fs-13">Press enter to search</p>
          </div>
          <!-- END Overlay Controls !-->
        </div>
        <!-- BEGIN Overlay Search Results, This part is for demo purpose, you can add anything you like !-->
        <div class="container-fluid">
          <span>
                <strong>suggestions :</strong>
            </span>
          <span id="overlay-suggestions"></span>
          <br>
          <div class="search-results m-t-40">
            <p class="bold">Pages Search Results</p>
            <div class="row">
              <div class="col-md-6">
                <!-- BEGIN Search Result Item !-->
                <div class="">
                  <!-- BEGIN Search Result Item Thumbnail !-->
                  <div class="thumbnail-wrapper d48 circular bg-success text-white inline m-t-10">
                    <div>
                      <img width="50" height="50" src="assets/img/profiles/avatar.jpg" data-src="assets/img/profiles/avatar.jpg" data-src-retina="assets/img/profiles/avatar2x.jpg" alt="">
                    </div>
                  </div>
                  <!-- END Search Result Item Thumbnail !-->
                  <div class="p-l-10 inline p-t-5">
                    <h5 class="m-b-5"><span class="semi-bold result-name">ice cream</span> on pages</h5>
                    <p class="hint-text">via john smith</p>
                  </div>
                </div>
                <!-- END Search Result Item !-->
                <!-- BEGIN Search Result Item !-->
                <div class="">
                  <!-- BEGIN Search Result Item Thumbnail !-->
                  <div class="thumbnail-wrapper d48 circular bg-success text-white inline m-t-10">
                    <div>T</div>
                  </div>
                  <!-- END Search Result Item Thumbnail !-->
                  <div class="p-l-10 inline p-t-5">
                    <h5 class="m-b-5"><span class="semi-bold result-name">ice cream</span> related topics</h5>
                    <p class="hint-text">via pages</p>
                  </div>
                </div>
                <!-- END Search Result Item !-->
                <!-- BEGIN Search Result Item !-->
                <div class="">
                  <!-- BEGIN Search Result Item Thumbnail !-->
                  <div class="thumbnail-wrapper d48 circular bg-success text-white inline m-t-10">
                    <div><i class="fa fa-headphones large-text "></i>
                    </div>
                  </div>
                  <!-- END Search Result Item Thumbnail !-->
                  <div class="p-l-10 inline p-t-5">
                    <h5 class="m-b-5"><span class="semi-bold result-name">ice cream</span> music</h5>
                    <p class="hint-text">via pagesmix</p>
                  </div>
                </div>
                <!-- END Search Result Item !-->
              </div>
              <div class="col-md-6">
                <!-- BEGIN Search Result Item !-->
                <div class="">
                  <!-- BEGIN Search Result Item Thumbnail !-->
                  <div class="thumbnail-wrapper d48 circular bg-info text-white inline m-t-10">
                    <div><i class="fa fa-facebook large-text "></i>
                    </div>
                  </div>
                  <!-- END Search Result Item Thumbnail !-->
                  <div class="p-l-10 inline p-t-5">
                    <h5 class="m-b-5"><span class="semi-bold result-name">ice cream</span> on facebook</h5>
                    <p class="hint-text">via facebook</p>
                  </div>
                </div>
                <!-- END Search Result Item !-->
                <!-- BEGIN Search Result Item !-->
                <div class="">
                  <!-- BEGIN Search Result Item Thumbnail !-->
                  <div class="thumbnail-wrapper d48 circular bg-complete text-white inline m-t-10">
                    <div><i class="fa fa-twitter large-text "></i>
                    </div>
                  </div>
                  <!-- END Search Result Item Thumbnail !-->
                  <div class="p-l-10 inline p-t-5">
                    <h5 class="m-b-5">Tweats on<span class="semi-bold result-name"> ice cream</span></h5>
                    <p class="hint-text">via twitter</p>
                  </div>
                </div>
                <!-- END Search Result Item !-->
                <!-- BEGIN Search Result Item !-->
                <div class="">
                  <!-- BEGIN Search Result Item Thumbnail !-->
                  <div class="thumbnail-wrapper d48 circular text-white bg-danger inline m-t-10">
                    <div><i class="fa fa-google-plus large-text "></i>
                    </div>
                  </div>
                  <!-- END Search Result Item Thumbnail !-->
                  <div class="p-l-10 inline p-t-5">
                    <h5 class="m-b-5">Circles on<span class="semi-bold result-name"> ice cream</span></h5>
                    <p class="hint-text">via google plus</p>
                  </div>
                </div>
                <!-- END Search Result Item !-->
              </div>
            </div>
          </div>
        </div>
        <!-- END Overlay Search Results !-->
      </div>
      <!-- END Overlay Content !-->
    </div>
    <!-- END OVERLAY -->
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
    <script src="assets/js/form_elements.js" type="text/javascript"></script>
    <script src="assets/js/scripts.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS -->
    <script>
    $(function()
    {
      $('#form-register').validate()
    })
    </script>
  </body>
</html>