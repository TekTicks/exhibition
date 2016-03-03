
<%-- 
    Document   : ckvRegister
    Created on : Jan 22, 2016, 6:56:24 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
  <head>
 
    <meta http-equiv="content-type" content="text/html;charset=UTF-8" />
    <meta charset="utf-8" />
    <title>Owner Registration Page</title>
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
    <link href="pages/css/ckvajax.css" rel="stylesheet" type="text/css" />   
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="pages/js/jquery-1.4.2.min.js"></script>
    <script src="pages/js/ownerRegValidation.js"></script>
    <script src="pages/js/ownerRegVerification.js"></script>
    
    <script>
        
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

    
 
    </script>

  </head>
  <body class="fixed-header ">
    <div class="register-container full-height sm-p-t-30">
      <div class="container-sm-height full-height">
        <div class="row row-sm-height">
          <div class="col-sm-12 col-sm-height col-middle">
           <h1><b> Sign up </h1>
           <h3>Pages makes it easy to enjoy what matters the most in your life</h3>
            
            <form name="login_frm" id="login_frm" class="p-t-15"  >
            
                <div class="row">
                 <div class="col-sm-12">
                  <div class="form-group form-group-default">
                    <label>Company Name</label>
                    <input type="text" name="cname" id="cname" placeholder="" class="form-control" required>
                    <div id="msgbox"></div> 
                  </div>
                 </div>
                </div>
                
                <div class="row">
                 <div class="col-sm-12">
                  <div class="form-group form-group-default">
                    <label>Email</label>
                    <input type="email" name="email" id="email" placeholder="We will send loging details to you" class="form-control" required>
                     <div id="msgbox1"></div> <div id="msgbox8"></div>
                  </div>
                </div>
               </div>

                <div class="form-group form-group-default input-group">
                    <span class="input-group-addon">
                    <select class="cs-select cs-skin-slide cs-transparent" id="prefix" data-init-plugin="cs-select">
                    <option data-countryCode="GB" value="44" Selected>UK (+44)</option>
                    <option data-countryCode="US" value="1">USA (+1)</option>
                    <option data-countryCode="AR" value="54">Argentina (+54)</option>
                    <option data-countryCode="AU" value="61">Australia (+61)</option>
                    <option data-countryCode="AT" value="43">Austria (+43)</option>
                    <option data-countryCode="BE" value="32">Belgium (+32)</option>
                    <option data-countryCode="BZ" value="501">Belize (+501)</option>
                    <option data-countryCode="CN" value="86">China (+86)</option>
                    <option data-countryCode="IN" value="91">India (+91)</option>
                    <option data-countryCode="MY" value="60">Malaysia (+60)</option>
                    <option data-countryCode="ZW" value="263">Zimbabwe (+263)</option>
                    </select>
                    </span>
                    <label>Contact Number</label>
                    <input type="tel" name="phone" id="phone" maxlength="10" minlength="10" class="form-control" placeholder="" required>
                </div><div id="msgbox2"></div><div id="msgbox5"></div><div id="msgbox6"></div><div id="msgbox7"></div><div id="msgbox13"></div>

                                
                <div class="row">
                 <div class="col-sm-12">
                  <div class="form-group form-group-default">
                    <label>Password</label>
                    <input type="password" name="password" id="password" placeholder="Minimum of 6 Charactors" minlength="6" class="form-control" required>
                  <div id="msgbox9"></div><div id="msgbox10"></div>
                  </div>
                 </div>
                </div>
                
                <div class="row">
                 <div class="col-sm-12">
                  <div class="form-group form-group-default">
                    <label> Confirm Password</label>
                    <input type="password" name="cpassword" placeholder="Minimum of 6 Charactors" minlength="6" class="form-control" required>
                     <div id="msgbox3"></div><div id="msgbox11"></div><div id="msgbox12"></div>
                  </div>
                 </div>
                </div>

              <!--  <div class="row m-t-10">
                <div class="col-md-6">
                </div>
                <div class="col-md-6 text-right">
                  <a href="https://www.facebook.com/" class="text-info small">Help? Contact Support</a>
                </div>
                </div>-->
              <br>
                 
                <button class="btn btn-primary btn-cons m-t-10" type="submit" onclick="return val();">Submit</button>
                <button class="btn btn-primary btn-cons m-t-10" >Cancel</button> 
              
                 
  
                <input type="hidden" name="country"  id="abc" >
            </form>
          </div>
        </div>
      </div>
    </div>
      
      
<!--*******************************************************Template Content ***********************************************************-->      
    <div class=" full-width">
      <div class="register-container m-b-10 clearfix">
        <div class="inline pull-left">
          <img src="assets/img/demo/pages_icon.png" alt="" class="m-t-5 " data-src="assets/img/demo/pages_icon.png" data-src-retina="assets/img/demo/pages_icon_2x.png" width="60" height="60">
        </div>
        <div class="col-md-10 m-t-15">
          <p class="hinted-text small inline ">No part of this website or any of its contents may be reproduced, copied, modified or adapted, without the prior written consent of the author, unless otherwise indicated for stand-alone materials.</p>
        </div>
      </div>
    </div>
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
    <script src="pages/js/pages.min.js"></script>
   
  </body>
</html>
