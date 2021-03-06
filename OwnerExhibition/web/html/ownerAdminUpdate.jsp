 
<%@page import="ownerPortal.dbConnection"%>
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
  <!--  <script src="pages/js/ownerRegVerification.js"></script> -->
    
   
    

  </head>
  <body class="fixed-header ">
    <div class="register-container full-height sm-p-t-30">
      <div class="container-sm-height full-height">
        <div class="row row-sm-height">
          <div class="col-sm-12 col-sm-height col-middle">
           <h1><b> Add Administrator</h1>
           <h3>Pages makes it easy to enjoy what matters the most in your life</h3>
            
            <form name="login_frm" action="/Exhibition/ownerAdminUpdate" method="post" id="login_frm" class="p-t-15"  >
            
                
                <%
                    try
                    {
                            //getting id of ownerAddress in url from ownerProfile
                            String id=request.getParameter("adminId");
                            //one time connection
                            Connection con;
                            con=dbConnection.getConnection();
                            Statement stat=con.createStatement();
                            ResultSet rs=stat.executeQuery("select * from exhibitionAdmin where id='"+id+"'");
                            while(rs.next())
                            {
                              String id1=rs.getString(1);
                              String exhibitionId=rs.getString(2);
                              String mobileNo=rs.getString(3);
                              String emailId=rs.getString(4);
                              String username=rs.getString(5);
                              String password=rs.getString(6);
                              //creating session of id of ownerAddress
                              
                %>
                            
                <div class="row">
                 <div class="col-sm-12">
                  <div class="form-group form-group-default">
                    <label>Username</label>
                    <input type="text" name="uname" id="uname" placeholder=""  value="<%out.print(username);%>" class="form-control" required>
                    <div id="msgbox"></div> 
                  </div>
                 </div>
                </div>
                
                <div class="row">
                 <div class="col-sm-12">
                  <div class="form-group form-group-default">
                    <label>Email</label>
                    <input type="email" name="email" id="email" value="<%out.print(emailId);%>" placeholder="We will send loging details to you" class="form-control" required>
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
                    <input type="tel" name="phone" id="phone" value="<%out.print(mobileNo);%>" maxlength="10" minlength="10" class="form-control" placeholder="" required>
                </div><div id="msgbox2"></div><div id="msgbox3"></div><div id="msgbox6"></div><div id="msgbox7"></div><div id="msgbox13"></div>

                <div class="row">
                 <div class="col-sm-12">
                  <div class="form-group form-group-default">
                    <label>Password</label>
                    <input type="text" name="password" id="password" value="<%out.print(password);%>" placeholder="Minimum of 6 Charactors" minlength="6" class="form-control" required>
                  <div id="msgbox9"></div>
                  </div>
                 </div>
                </div>
                <%      } 
                    }
                catch(Exception e)
                {
                out.print(e);
                 }
                %>
            
                <div class="form-group form-group-default required">
                     <%@page import="java.io.*;" %>
                     <%@page import="java.sql.*;" %>
                     <%@page import="java.sql.DriverManager;" %>
                     <%@page import="java.util.Scanner.*;" %>
                     <%   
                       //getting id of admin in url from ownerProfile
                       String adminId=request.getParameter("adminId");
                       //setting session for getting value of adminId on ownerAdminUpdate.java
                       HttpSession ss=request.getSession();
                       ss.setAttribute("ownerAdminId",adminId);
                       //one time databse connectivity.
                       Connection con1;
                       con1=dbConnection.getConnection();
                       Statement stat1=con1.createStatement();
                       ResultSet rs1=stat1.executeQuery("select a.*,b.* from exhibition a, exhibitionAdmin b where a.id=b.exhibitionId and b.id='"+adminId+"'");
                         
                     %>   
                        <label>Exhibitions</label>
                        <select class="full-width" name="exhibitionName" id="exhibitionName"  data-init-plugin="select2">
                         <%
                         while(rs1.next())
                         {
                           String sm=rs1.getString(2);
                        %>  
                             <optgroup label=''><option><%=sm %></option></optgroup>
                             <% } %>
                             
                           <optgroup label="Select Exhibition :">
                               <%     
                                   Connection con2;
                                   con2=dbConnection.getConnection();
                                   Statement stat2=con2.createStatement();
                                   ResultSet rs2=stat2.executeQuery("select a.*,b.* from exhibitionAdmin a,exhibition b where a.id='"+adminId+"'");
                                   //ResultSet rs2=stat2.executeQuery("select * from exhibitionAdmin");
                               %>      
                               <% while(rs2.next())
                                { 
                               %>
                               <option value="<%out.print(rs2.getString(13));%>"><%out.print(rs2.getString(14));%></option>
                               <% 
                                 }
                               %>  </optgroup> 
                              
                        </select>
                               <div id="msgbox4">
                                   
                               </div>
                            </div> 
              <br>
                    
                <button class="btn btn-primary btn-cons m-t-10" type="submit">Submit</button>
                <button class="btn btn-primary btn-cons m-t-10" type="button" onclick="document.location.href='/Exhibition/html/ownerAdministrator.jsp'">Cancel</button> 
              
                 
  
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
