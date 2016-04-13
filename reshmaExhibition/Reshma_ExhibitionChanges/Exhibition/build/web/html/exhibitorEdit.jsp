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
    <script src="assets/plugins/boostrapv3/js/bootstrap.min.js" type="text/javascript"></script>
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
    
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="pages/js/jquery-1.4.2.min.js"></script>

  <script type="text/javascript">
	$(document).ready(function(){
		$("#form-register").submit(function(){

			 //remove previous class and add new "myinfo" class
	       // $("#msgbox").removeClass().addClass('myinfo').text('Validating Your Login ').fadeIn(1000);

			
			this.timer = setTimeout(function () {
				$.ajax({   
		          	url: '/Exhibition/exhibitorEdit',
		          	data: 'companyName='+ $('#companyName').val()+'&exId=' + $('#exId').val()+'&userName=' + $('#userName').val(),
		          	type: 'post',
		   		success: function(msg){
                                  
                                if(msg != 'error') // Message Sent, check and redirect
				{
                                        if(msg != 'wrong')
                                        {
                                         $("#msgbox1").fadeTo(300,1,function() //start fading the messagebox
                                       {
                                            //add message and change the class of the box and start fading
                                             $(this).html('data updated..!').removeClass().addClass('myinfo').fadeTo(300,1).fadeout();
                                          document.location='/Exhibition/html/exhibitorView.jsp';
                                     });   
                                    }
                                else 
                                { 
                                 $("#msgbox2").fadeTo(300,1,function() //start fading the messagebox
                                                {
                                                //add message and change the class of the box and start fading
                                                    $(this).html('Records are not updated.!').removeClass().addClass('myerror').fadeTo(300,1).fadeOut();
                                                });
                                 }
                                }
                            else
                            {
                               $("#msgbox2").fadeTo(300,1,function() //start fading the messagebox
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
                <% 
                      try { 
                          String m;
                          HttpSession ss1=request.getSession(true);
                          String myex_id=request.getParameter("exid");
                          ss1.setAttribute("myid",myex_id);
                          Connection con;
                        con=dbConnection.getConnection();
                         Statement stat1=con.createStatement();
                         String query="select * from exhibitor where id= '"+myex_id+" '";
                         ResultSet rs=stat1.executeQuery(query);  
                         int count=0;
                         while(rs.next())
                         {
                            HttpSession CM=request.getSession(true);
                             String phoneCountryId=rs.getString("primCountryCodeId");   
                             CM.setAttribute("phoneCountryId", phoneCountryId);
                          
                            
                                     %>
                
                <div class="row">
                <div class="col-sm-12">
                  <div class="form-group form-group-default">
                    <label> Company Name</label>
                    <input type="text" name="companyName" id="companyName" placeholder="comapny name" value="<%out.print(rs.getString("companyName"));%>" class="form-control" required>
                  </div>
                </div>
              </div>
              <div class="row">
                <div class="col-sm-12">
                  <div class="form-group form-group-default">
                    <label> User Name</label>
                    <input type="email" name="userName" id="userName" placeholder="username as email" value="<%out.print(rs.getString("username"));%>" class="form-control" required>
                  </div>
                </div>
              </div>
                <div class="row">
                <div class="col-sm-12">
                  <div class="form-group form-group-default">
                    <label> Email</label>
                    <input type="email" name="email" id="email" placeholder="email id" value="<%out.print(rs.getString("email"));%>"  class="form-control" disabled>
                  </div>
                </div>
              </div> <div id="msgbox1"></div>
              <div class="row">
                <div class="col-sm-12">
                  <div class="form-group form-group-default">
                    <label>Password</label>
                    <input type="password" name="password" id="password" placeholder="Minimum of 6 Charactors" value="<%out.print(rs.getString("password"));%>" class="form-control" required>
                  </div>
                </div>
              </div> 
                
                <div class="row">
                    
                    <div class="col-sm-4"> 
                         <div class="form-group form-group-default">
                    <label>Country Code</label>
                     <%    
                    try { 
                        
                        String im =(String)CM.getAttribute("phoneCountryId");
                           Connection con1;
                        con1=dbConnection.getConnection();
                           Statement sta2=con1.createStatement();
                           ResultSet rsy2=sta2.executeQuery("select * from country where id='"+im+"' ");
                           int cou1=0;
                           
                      while(rsy2.next())
                         { 
                           String id1=rsy2.getString(1);
                         
                         %>
                    
                         <select class="full-width" data-init-plugin="select2" name="countryId" id="countryId" disabled>
                           <option class="full-width" value="<%=id1%>"><%out.print(rsy2.getString(4));%></option>
                            <%   
                         }
                        } 
                   catch(Exception e) 
                      { 
                      out.print("error" +e); 
                      }
                        %>  
                       <optgroup label="Select id">
                        
                      <%    
                    try { 
                            Connection con5;
                        con5 = dbConnection.getConnection();
                           Statement sa5=con5.createStatement();
                           ResultSet ry5=sa5.executeQuery("select * from country");
                           int cou1=0;
                         while(ry5.next())
                         { 
                          String R2=ry5.getString(1);
                         %>
                               <option value="<%= R2%>"><%out.print(ry5.getString(4));%></option>
                               <%   
                                   cou1++;
                         }
                        } 
                   catch(Exception e) 
                      { 
                      out.print("error" +e); 
                      }
                        %>  
                        
                         
                        </select>
                         </div> </div>
                <div class="col-sm-8">
                  <div class="form-group form-group-default">
                    <label> Mobile No</label>
                    <input type="text" name="phone" id="phone" onkeypress="return validate(event)" maxlength="10" placeholder="mobile no" class="form-control" value="<%out.print(rs.getString("mobileNo"));%>"  disabled>
                  </div>
                </div>
              </div><div id="msgbox3"></div>
                 
              
              <div class="form-group form-group-default">
                     <%
                          String mn=rs.getString("isMainExhibitor");
                          if("0".equals(mn))
                          {
                              mn="yes"; 
                          }
                          else
                          {
                              mn="no";
                          }
                      %>
                     
                           <label>Is Main Exhibitor</label>
                        <select class="full-width" data-init-plugin="select2"  name="exId" id="exId">   
                            <option class="full-width" value="<%out.print(rs.getString("isMainExhibitor"));%>" ><%= mn%></option>
                              <optgroup label="Select options">
                                   <option class="full-width" value="1">yes</option>
                                     <option class="full-width" value="0">no</option>
                        </select>
                      </div>
                <%
                             count++;
                         }              
                      }    
                    catch (Exception e)
                    {
                        out.print("error");
                    }
                   %>  
              <div id="msgbox1"></div><div id="msgbox2"></div>
                        <button class="btn btn-primary btn-cons m-t-10" type="submit">Update account</button>
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