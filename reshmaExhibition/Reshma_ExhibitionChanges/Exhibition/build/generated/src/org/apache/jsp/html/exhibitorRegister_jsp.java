package org.apache.jsp.html;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.Statement;
import exhibitionAdministrator.exhibitionAdministratorOneTimeConnection;
import java.sql.Connection;

public final class exhibitorRegister_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("   <meta http-equiv=\"content-type\" content=\"text/html;charset=UTF-8\" />\r\n");
      out.write("    <meta charset=\"utf-8\" />\r\n");
      out.write("    <title>Pages - Admin Dashboard UI Kit - Form Wizard</title>\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no, shrink-to-fit=no\" />\r\n");
      out.write("    <link rel=\"apple-touch-icon\" href=\"pages/ico/60.png\">\r\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"76x76\" href=\"pages/ico/76.png\">\r\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"120x120\" href=\"pages/ico/120.png\">\r\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"152x152\" href=\"pages/ico/152.png\">\r\n");
      out.write("    <link rel=\"icon\" type=\"image/x-icon\" href=\"favicon.ico\" />\r\n");
      out.write("    <meta name=\"apple-mobile-web-app-capable\" content=\"yes\">\r\n");
      out.write("    <meta name=\"apple-touch-fullscreen\" content=\"yes\">\r\n");
      out.write("    <meta name=\"apple-mobile-web-app-status-bar-style\" content=\"default\">\r\n");
      out.write("    <meta content=\"\" name=\"description\" />\r\n");
      out.write("    <meta content=\"\" name=\"author\" />\r\n");
      out.write("    <link href=\"assets/plugins/pace/pace-theme-flash.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("    <link href=\"assets/plugins/boostrapv3/css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("    <link href=\"assets/plugins/font-awesome/css/font-awesome.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("    <link href=\"assets/plugins/jquery-scrollbar/jquery.scrollbar.css\" rel=\"stylesheet\" type=\"text/css\" media=\"screen\" />\r\n");
      out.write("    <link href=\"assets/plugins/bootstrap-select2/select2.css\" rel=\"stylesheet\" type=\"text/css\" media=\"screen\" />\r\n");
      out.write("    <link href=\"assets/plugins/switchery/css/switchery.min.css\" rel=\"stylesheet\" type=\"text/css\" media=\"screen\" />\r\n");
      out.write("    <link href=\"pages/css/pages-icons.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("    <link class=\"main-stylesheet\" href=\"pages/css/pages.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("     <script src=\"assets/js/phoneNoValidation.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <!--[if lte IE 9]>\r\n");
      out.write("\t<link href=\"assets/plugins/codrops-dialogFx/dialog.ie.css\" rel=\"stylesheet\" type=\"text/css\" media=\"screen\" />\r\n");
      out.write("\t<![endif]-->\r\n");
      out.write("    <script type=\"text/javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js\"></script>\r\n");
      out.write("    <script src=\"pages/js/jquery-1.4.2.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("  <script type=\"text/javascript\">\r\n");
      out.write("\t$(document).ready(function(){\r\n");
      out.write("\t\t$(\"#form-register\").submit(function(){\r\n");
      out.write("\r\n");
      out.write("\t\t\t //remove previous class and add new \"myinfo\" class\r\n");
      out.write("\t       // $(\"#msgbox\").removeClass().addClass('myinfo').text('Validating Your Login ').fadeIn(1000);\r\n");
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tthis.timer = setTimeout(function () {\r\n");
      out.write("\t\t\t\t$.ajax({   \r\n");
      out.write("\t\t          \turl: '/Exhibition/exhibitorRegister',\r\n");
      out.write("\t\t          \tdata: 'companyName='+ $('#companyName').val() +'&userName=' + $('#userName').val()+'&email=' + $('#email').val() +'&password=' + $('#password').val()+'&cpassword=' + $('#cpassword').val()+'&countryId=' + $('#countryId').val()+'&phone=' + $('#phone').val() +'&exId=' + $('#exId').val(),\r\n");
      out.write("\t\t          \ttype: 'post',\r\n");
      out.write("\t\t   \t\tsuccess: function(msg){\r\n");
      out.write("                                  alert(msg);\r\n");
      out.write("                                if(msg != 'error') // Message Sent, check and redirect\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("                                        if(msg == 'passwordInvalid')\r\n");
      out.write("                                        {\r\n");
      out.write("                                         $(\"#msgbox1\").fadeTo(300,1,function() //start fading the messagebox\r\n");
      out.write("                                       {\r\n");
      out.write("                                            //add message and change the class of the box and start fading\r\n");
      out.write("                                             $(this).html('Password invalid..!').removeClass().addClass('myinfo').fadeTo(300,1).fadeout();\r\n");
      out.write("                                          //  document.location='/Exhibition/html/exhibitionAdministratorContactInformationFirstTimeUse.jsp';\r\n");
      out.write("                                     });\r\n");
      out.write("                                        \r\n");
      out.write("                                    }\r\n");
      out.write("                                   else if(msg == 'emailInvalid')\r\n");
      out.write("                                        {\r\n");
      out.write("                                         $(\"#msgbox2\").fadeTo(300,1,function() //start fading the messagebox\r\n");
      out.write("                                       {\r\n");
      out.write("                                            //add message and change the class of the box and start fading\r\n");
      out.write("                                             $(this).html('email invalid.!').removeClass().addClass('myinfo').fadeTo(300,1).fadeout();\r\n");
      out.write("                                          //  document.location='/Exhibition/html/exhibitionAdministratorContactInformationFirstTimeUse.jsp';\r\n");
      out.write("                                     });\r\n");
      out.write("                                        \r\n");
      out.write("                                    }\r\n");
      out.write("                                 else if(msg == 'mobileNoInvalid')\r\n");
      out.write("                                        {\r\n");
      out.write("                                         $(\"#msgbox3\").fadeTo(300,1,function() //start fading the messagebox\r\n");
      out.write("                                       {\r\n");
      out.write("                                            //add message and change the class of the box and start fading\r\n");
      out.write("                                             $(this).html('mobileNo invalid..!').removeClass().addClass('myinfo').fadeTo(300,1).fadeout();\r\n");
      out.write("                                          //  document.location='/Exhibition/html/exhibitionAdministratorContactInformationFirstTimeUse.jsp';\r\n");
      out.write("                                     });\r\n");
      out.write("                                        \r\n");
      out.write("                                    }\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("                                else \r\n");
      out.write("                                { \r\n");
      out.write("                                    \r\n");
      out.write("                                    \r\n");
      out.write("                                     if(msg != 'wrn')\r\n");
      out.write("                                        {\r\n");
      out.write("                                         $(\"#msgbox4\").fadeTo(300,1,function() //start fading the messagebox\r\n");
      out.write("                                       {\r\n");
      out.write("                                            //add message and change the class of the box and start fading\r\n");
      out.write("                                             $(this).html('records saved..!').removeClass().addClass('myinfo').fadeTo(300,1).fadeout();\r\n");
      out.write("                                          //  document.location='/Exhibition/html/exhibitionAdministratorContactInformationFirstTimeUse.jsp';\r\n");
      out.write("                                     });\r\n");
      out.write("                                        \r\n");
      out.write("                                    }\r\n");
      out.write("                                    else {\r\n");
      out.write("                                 $(\"#msgbox4\").fadeTo(300,1,function() //start fading the messagebox\r\n");
      out.write("                                                {\r\n");
      out.write("                                                //add message and change the class of the box and start fading\r\n");
      out.write("                                                    $(this).html('Records are not updated.!').removeClass().addClass('myerror').fadeTo(300,1).fadeOut();\r\n");
      out.write("                                                });\r\n");
      out.write("                                }\r\n");
      out.write("                                 }\r\n");
      out.write("                                }\r\n");
      out.write("                            else\r\n");
      out.write("                            {\r\n");
      out.write("                               $(\"#msgbox4\").fadeTo(300,1,function() //start fading the messagebox\r\n");
      out.write("                                                {\r\n");
      out.write("                                                //add message and change the class of the box and start fading\r\n");
      out.write("                                                    $(this).html('sorry sql exceptions are there!').removeClass().addClass('myerror').fadeTo(300,1).fadeOut();\r\n");
      out.write("                                                });\r\n");
      out.write("                                }\r\n");
      out.write("                            \r\n");
      out.write("                                }\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t}, 200);\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write(" \t\t});\t\t\r\n");
      out.write("\r\n");
      out.write("\t});\r\n");
      out.write("   </script>  \r\n");
      out.write("            \r\n");
      out.write("    <style>\r\n");
      out.write("#exists{display:none}\r\n");
      out.write("#cross{display:none}\r\n");
      out.write(".myinfo\r\n");
      out.write("{\r\n");
      out.write("\tmargin: 5px auto;\r\n");
      out.write("\tbackground:white;\r\n");
      out.write("\tborder: 0px;\r\n");
      out.write("\tpadding:5px;\r\n");
      out.write("\tcolor:#0010ac;\r\n");
      out.write("\tfont-size:13px;\r\n");
      out.write("\twidth:350px;\r\n");
      out.write("\tmin-height:0px;\r\n");
      out.write("\t-moz-border-radius:4px;\r\n");
      out.write("\t-webkit-border-radius:4px;\r\n");
      out.write("\ttext-align: left;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".myerror\r\n");
      out.write("{\r\n");
      out.write("\tmargin: 5px auto;\r\n");
      out.write("\tbackground:white;\r\n");
      out.write("\tborder: 0px;\r\n");
      out.write("\tpadding:5px;\r\n");
      out.write("\tcolor:#FF0000;\r\n");
      out.write("\tfont-size:12px;\r\n");
      out.write("\twidth:350px;\r\n");
      out.write("\tmin-height:0px;\r\n");
      out.write("\t-moz-border-radius:4px;\r\n");
      out.write("\t-webkit-border-radius:4px;\r\n");
      out.write("\ttext-align:left;\r\n");
      out.write("}\r\n");
      out.write("</style> \r\n");
      out.write("\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("    window.onload = function()\r\n");
      out.write("    {\r\n");
      out.write("      // fix for windows 8\r\n");
      out.write("      if (navigator.appVersion.indexOf(\"Windows NT 6.2\") != -1)\r\n");
      out.write("        document.head.innerHTML += '<link rel=\"stylesheet\" type=\"text/css\" href=\"pages/css/windows.chrome.fix.css\" />'\r\n");
      out.write("    }\r\n");
      out.write("    </script>\r\n");
      out.write("  </head>\r\n");
      out.write("  <body class=\"fixed-header   \">\r\n");
      out.write("    <div class=\"register-container full-height sm-p-t-30\">\r\n");
      out.write("      <div class=\"container-sm-height full-height\">\r\n");
      out.write("        <div class=\"row row-sm-height\">\r\n");
      out.write("            <div class=\"col-sm-12 col-sm-height col-middle\"><br><br>\r\n");
      out.write("            <img src=\"assets/img/logo.png\" alt=\"logo\" data-src=\"assets/img/logo.png\" data-src-retina=\"assets/img/logo_2x.png\" width=\"78\" height=\"22\">\r\n");
      out.write("            <h3></h3>\r\n");
      out.write("            <p>\r\n");
      out.write("              <small>\r\n");
      out.write("        Create a pages account. If you have a facebook account, log into it for this process. Sign in with <a href=\"#\" class=\"text-info\">Facebook</a> or <a href=\"#\" class=\"text-info\">Google</a>\r\n");
      out.write("    </small>\r\n");
      out.write("            </p>\r\n");
      out.write("            <form id=\"form-register\" name=\"form-register\" class=\"p-t-15\" role=\"form\" action=\"/Exhibition/exhibitorRegister\" method=\"post\">\r\n");
      out.write("             <div class=\"row\">\r\n");
      out.write("                <div class=\"col-sm-12\">\r\n");
      out.write("                  <div class=\"form-group form-group-default\">\r\n");
      out.write("                    <label> Company Name</label>\r\n");
      out.write("                    <input type=\"text\" name=\"companyName\" id=\"companyName\" placeholder=\"comapny name\" class=\"form-control\" required>\r\n");
      out.write("                  </div>\r\n");
      out.write("                </div>\r\n");
      out.write("              </div>\r\n");
      out.write("              <div class=\"row\">\r\n");
      out.write("                <div class=\"col-sm-12\">\r\n");
      out.write("                  <div class=\"form-group form-group-default\">\r\n");
      out.write("                    <label> User Name</label>\r\n");
      out.write("                    <input type=\"email\" name=\"userName\" id=\"userName\" placeholder=\"username as email\" class=\"form-control\" required>\r\n");
      out.write("                  </div>\r\n");
      out.write("                </div>\r\n");
      out.write("              </div>\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                <div class=\"col-sm-12\">\r\n");
      out.write("                  <div class=\"form-group form-group-default\">\r\n");
      out.write("                    <label> Email</label>\r\n");
      out.write("                    <input type=\"email\" name=\"email\" id=\"email\" placeholder=\"email id\" class=\"form-control\" required>\r\n");
      out.write("                  </div>\r\n");
      out.write("                </div>\r\n");
      out.write("              </div> <div id=\"msgbox1\"></div>\r\n");
      out.write("              <div class=\"row\">\r\n");
      out.write("                <div class=\"col-sm-12\">\r\n");
      out.write("                  <div class=\"form-group form-group-default\">\r\n");
      out.write("                    <label>Password</label>\r\n");
      out.write("                    <input type=\"password\" name=\"password\" id=\"password\" placeholder=\"Minimum of 6 Charactors\" class=\"form-control\" required>\r\n");
      out.write("                  </div>\r\n");
      out.write("                </div>\r\n");
      out.write("              </div> \r\n");
      out.write("                 <div class=\"row\">\r\n");
      out.write("                <div class=\"col-sm-12\">\r\n");
      out.write("                  <div class=\"form-group form-group-default\">\r\n");
      out.write("                    <label>Confirm Password</label>\r\n");
      out.write("                    <input type=\"password\" name=\"cpassword\"  id=\"cpassword\" placeholder=\"Minimum of 6 Charactors\" class=\"form-control\" required>\r\n");
      out.write("                  </div>\r\n");
      out.write("                </div>\r\n");
      out.write("              </div><div id=\"msgbox2\"></div>\r\n");
      out.write("              \r\n");
      out.write("              <div class=\"row\">    \r\n");
      out.write("                   <div class=\"form-group form-group-default\">\r\n");
      out.write("                     \r\n");
      out.write("                    <div class=\"col-sm-4\">\r\n");
      out.write("                        <label>Country Code</label>\r\n");
      out.write("                     ");
    
                    try { 
                         
                           Connection con;
                           con= exhibitionAdministratorOneTimeConnection.getConnection(); 
                           Statement sta1=con.createStatement();
                           ResultSet rsy=sta1.executeQuery("select * from country ");
                           int cou1=0;
                     
      out.write("\r\n");
      out.write("                      \r\n");
      out.write("                        <select class=\"cs-select cs-skin-slide cs-transparent\" data-init-plugin=\"select2\" name=\"countryId\" id=\"countryId\">  \r\n");
      out.write("                       <optgroup label=\"Select id\">\r\n");
      out.write("                         ");
 while(rsy.next())
                         { 
                           String id1=rsy.getString(1);
                         
                         
      out.write("\r\n");
      out.write("                        <option class=\"\" value=\"");
      out.print(id1);
      out.write("\"> ");
out.print(rsy.getString(4));
      out.write(" </option>\r\n");
      out.write("                         ");
   
                         }
                        } 
                   catch(Exception e) 
                      { 
                      out.print("error" +e); 
                      }
                        
      out.write("  \r\n");
      out.write("                         \r\n");
      out.write("                        </select> </div>\r\n");
      out.write("                          <div class=\"col-sm-4\">\r\n");
      out.write("                    <label> Mobile No</label>\r\n");
      out.write("                    <input type=\"text\" name=\"phone\" id=\"phone\" onkeypress=\"return validate(event)\" maxlength=\"10\" placeholder=\"mobile no\" class=\"form-control\" required>\r\n");
      out.write("                  </div>\r\n");
      out.write("                   </div> </div>\r\n");
      out.write("             <div id=\"msgbox3\"></div>\r\n");
      out.write("               <div class=\"form-group form-group-default\">\r\n");
      out.write("                           <label>Is Main Exhibitor</label>\r\n");
      out.write("                        <select class=\"full-width\" data-init-plugin=\"select2\" name=\"exId\" id=\"exId\">   \r\n");
      out.write("                        <option value=\"1\">Yes</option>\r\n");
      out.write("                        <option value=\"0\">No</option>\r\n");
      out.write("                        </select>\r\n");
      out.write("                      </div>  \r\n");
      out.write("             \r\n");
      out.write("              \r\n");
      out.write("              <div class=\"row m-t-10\">\r\n");
      out.write("                <div class=\"col-md-6\">\r\n");
      out.write("                  <p>I agree to the <a href=\"#\" class=\"text-info small\">Pages Terms</a> and <a href=\"#\" class=\"text-info small\">Privacy</a>.</p>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-md-6 text-right\">\r\n");
      out.write("                  <a href=\"#\" class=\"text-info small\">Help? Contact Support</a>\r\n");
      out.write("                </div>\r\n");
      out.write("              </div><div id=\"msgbox4\"></div>\r\n");
      out.write("                        <button class=\"btn btn-primary btn-cons m-t-10\" type=\"submit\">Create a new account</button>\r\n");
      out.write("                          <button class=\"btn btn-primary btn-cons m-t-10\" type=\"submit\" onclick=\"document.location.href='/Exhibition/html/exhibitorView.jsp';\">Cancel</button>\r\n");
      out.write("                          <br><br><br>\r\n");
      out.write("            </form>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("                        <br><br><br>\r\n");
      out.write("    <!-- START OVERLAY -->\r\n");
      out.write("    <div class=\"overlay hide\" data-pages=\"search\">\r\n");
      out.write("      <!-- BEGIN Overlay Content !-->\r\n");
      out.write("      <div class=\"overlay-content has-results m-t-20\">\r\n");
      out.write("        <!-- BEGIN Overlay Header !-->\r\n");
      out.write("        <div class=\"container-fluid\">\r\n");
      out.write("          <!-- BEGIN Overlay Logo !-->\r\n");
      out.write("          <img class=\"overlay-brand\" src=\"assets/img/logo.png\" alt=\"logo\" data-src=\"assets/img/logo.png\" data-src-retina=\"assets/img/logo_2x.png\" width=\"78\" height=\"22\">\r\n");
      out.write("          <!-- END Overlay Logo !-->\r\n");
      out.write("          <!-- BEGIN Overlay Close !-->\r\n");
      out.write("          <a href=\"#\" class=\"close-icon-light overlay-close text-black fs-16\">\r\n");
      out.write("            <i class=\"pg-close\"></i>\r\n");
      out.write("          </a>\r\n");
      out.write("          <!-- END Overlay Close !-->\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- END Overlay Header !-->\r\n");
      out.write("        <div class=\"container-fluid\">\r\n");
      out.write("          <!-- BEGIN Overlay Controls !-->\r\n");
      out.write("          <input id=\"overlay-search\" class=\"no-border overlay-search bg-transparent\" placeholder=\"Search...\" autocomplete=\"off\" spellcheck=\"false\">\r\n");
      out.write("          <br>\r\n");
      out.write("          <div class=\"inline-block\">\r\n");
      out.write("            <div class=\"checkbox right\">\r\n");
      out.write("              <input id=\"checkboxn\" type=\"checkbox\" value=\"1\" checked=\"checked\">\r\n");
      out.write("              <label for=\"checkboxn\"><i class=\"fa fa-search\"></i> Search within page</label>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"inline-block m-l-10\">\r\n");
      out.write("            <p class=\"fs-13\">Press enter to search</p>\r\n");
      out.write("          </div>\r\n");
      out.write("          <!-- END Overlay Controls !-->\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- BEGIN Overlay Search Results, This part is for demo purpose, you can add anything you like !-->\r\n");
      out.write("        <div class=\"container-fluid\">\r\n");
      out.write("          <span>\r\n");
      out.write("                <strong>suggestions :</strong>\r\n");
      out.write("            </span>\r\n");
      out.write("          <span id=\"overlay-suggestions\"></span>\r\n");
      out.write("          <br>\r\n");
      out.write("          <div class=\"search-results m-t-40\">\r\n");
      out.write("            <p class=\"bold\">Pages Search Results</p>\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("              <div class=\"col-md-6\">\r\n");
      out.write("                <!-- BEGIN Search Result Item !-->\r\n");
      out.write("                <div class=\"\">\r\n");
      out.write("                  <!-- BEGIN Search Result Item Thumbnail !-->\r\n");
      out.write("                  <div class=\"thumbnail-wrapper d48 circular bg-success text-white inline m-t-10\">\r\n");
      out.write("                    <div>\r\n");
      out.write("                      <img width=\"50\" height=\"50\" src=\"assets/img/profiles/avatar.jpg\" data-src=\"assets/img/profiles/avatar.jpg\" data-src-retina=\"assets/img/profiles/avatar2x.jpg\" alt=\"\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                  </div>\r\n");
      out.write("                  <!-- END Search Result Item Thumbnail !-->\r\n");
      out.write("                  <div class=\"p-l-10 inline p-t-5\">\r\n");
      out.write("                    <h5 class=\"m-b-5\"><span class=\"semi-bold result-name\">ice cream</span> on pages</h5>\r\n");
      out.write("                    <p class=\"hint-text\">via john smith</p>\r\n");
      out.write("                  </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- END Search Result Item !-->\r\n");
      out.write("                <!-- BEGIN Search Result Item !-->\r\n");
      out.write("                <div class=\"\">\r\n");
      out.write("                  <!-- BEGIN Search Result Item Thumbnail !-->\r\n");
      out.write("                  <div class=\"thumbnail-wrapper d48 circular bg-success text-white inline m-t-10\">\r\n");
      out.write("                    <div>T</div>\r\n");
      out.write("                  </div>\r\n");
      out.write("                  <!-- END Search Result Item Thumbnail !-->\r\n");
      out.write("                  <div class=\"p-l-10 inline p-t-5\">\r\n");
      out.write("                    <h5 class=\"m-b-5\"><span class=\"semi-bold result-name\">ice cream</span> related topics</h5>\r\n");
      out.write("                    <p class=\"hint-text\">via pages</p>\r\n");
      out.write("                  </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- END Search Result Item !-->\r\n");
      out.write("                <!-- BEGIN Search Result Item !-->\r\n");
      out.write("                <div class=\"\">\r\n");
      out.write("                  <!-- BEGIN Search Result Item Thumbnail !-->\r\n");
      out.write("                  <div class=\"thumbnail-wrapper d48 circular bg-success text-white inline m-t-10\">\r\n");
      out.write("                    <div><i class=\"fa fa-headphones large-text \"></i>\r\n");
      out.write("                    </div>\r\n");
      out.write("                  </div>\r\n");
      out.write("                  <!-- END Search Result Item Thumbnail !-->\r\n");
      out.write("                  <div class=\"p-l-10 inline p-t-5\">\r\n");
      out.write("                    <h5 class=\"m-b-5\"><span class=\"semi-bold result-name\">ice cream</span> music</h5>\r\n");
      out.write("                    <p class=\"hint-text\">via pagesmix</p>\r\n");
      out.write("                  </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- END Search Result Item !-->\r\n");
      out.write("              </div>\r\n");
      out.write("              <div class=\"col-md-6\">\r\n");
      out.write("                <!-- BEGIN Search Result Item !-->\r\n");
      out.write("                <div class=\"\">\r\n");
      out.write("                  <!-- BEGIN Search Result Item Thumbnail !-->\r\n");
      out.write("                  <div class=\"thumbnail-wrapper d48 circular bg-info text-white inline m-t-10\">\r\n");
      out.write("                    <div><i class=\"fa fa-facebook large-text \"></i>\r\n");
      out.write("                    </div>\r\n");
      out.write("                  </div>\r\n");
      out.write("                  <!-- END Search Result Item Thumbnail !-->\r\n");
      out.write("                  <div class=\"p-l-10 inline p-t-5\">\r\n");
      out.write("                    <h5 class=\"m-b-5\"><span class=\"semi-bold result-name\">ice cream</span> on facebook</h5>\r\n");
      out.write("                    <p class=\"hint-text\">via facebook</p>\r\n");
      out.write("                  </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- END Search Result Item !-->\r\n");
      out.write("                <!-- BEGIN Search Result Item !-->\r\n");
      out.write("                <div class=\"\">\r\n");
      out.write("                  <!-- BEGIN Search Result Item Thumbnail !-->\r\n");
      out.write("                  <div class=\"thumbnail-wrapper d48 circular bg-complete text-white inline m-t-10\">\r\n");
      out.write("                    <div><i class=\"fa fa-twitter large-text \"></i>\r\n");
      out.write("                    </div>\r\n");
      out.write("                  </div>\r\n");
      out.write("                  <!-- END Search Result Item Thumbnail !-->\r\n");
      out.write("                  <div class=\"p-l-10 inline p-t-5\">\r\n");
      out.write("                    <h5 class=\"m-b-5\">Tweats on<span class=\"semi-bold result-name\"> ice cream</span></h5>\r\n");
      out.write("                    <p class=\"hint-text\">via twitter</p>\r\n");
      out.write("                  </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- END Search Result Item !-->\r\n");
      out.write("                <!-- BEGIN Search Result Item !-->\r\n");
      out.write("                <div class=\"\">\r\n");
      out.write("                  <!-- BEGIN Search Result Item Thumbnail !-->\r\n");
      out.write("                  <div class=\"thumbnail-wrapper d48 circular text-white bg-danger inline m-t-10\">\r\n");
      out.write("                    <div><i class=\"fa fa-google-plus large-text \"></i>\r\n");
      out.write("                    </div>\r\n");
      out.write("                  </div>\r\n");
      out.write("                  <!-- END Search Result Item Thumbnail !-->\r\n");
      out.write("                  <div class=\"p-l-10 inline p-t-5\">\r\n");
      out.write("                    <h5 class=\"m-b-5\">Circles on<span class=\"semi-bold result-name\"> ice cream</span></h5>\r\n");
      out.write("                    <p class=\"hint-text\">via google plus</p>\r\n");
      out.write("                  </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- END Search Result Item !-->\r\n");
      out.write("              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- END Overlay Search Results !-->\r\n");
      out.write("      </div>\r\n");
      out.write("      <!-- END Overlay Content !-->\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- END OVERLAY -->\r\n");
      out.write("    <!-- BEGIN VENDOR JS -->\r\n");
      out.write("    <script src=\"assets/plugins/pace/pace.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"assets/plugins/jquery/jquery-1.11.1.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"assets/plugins/modernizr.custom.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"assets/plugins/jquery-ui/jquery-ui.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"assets/plugins/boostrapv3/js/bootstrap.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"assets/plugins/jquery/jquery-easy.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"assets/plugins/jquery-unveil/jquery.unveil.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"assets/plugins/jquery-bez/jquery.bez.min.js\"></script>\r\n");
      out.write("    <script src=\"assets/plugins/jquery-ios-list/jquery.ioslist.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"assets/plugins/jquery-actual/jquery.actual.min.js\"></script>\r\n");
      out.write("    <script src=\"assets/plugins/jquery-scrollbar/jquery.scrollbar.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"assets/plugins/bootstrap-select2/select2.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"assets/plugins/classie/classie.js\"></script>\r\n");
      out.write("    <script src=\"assets/plugins/switchery/js/switchery.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"assets/plugins/jquery-validation/js/jquery.validate.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <!-- END VENDOR JS -->\r\n");
      out.write("    <!-- BEGIN CORE TEMPLATE JS -->\r\n");
      out.write("    <script src=\"pages/js/pages.min.js\"></script>\r\n");
      out.write("    <!-- END CORE TEMPLATE JS -->\r\n");
      out.write("    <!-- BEGIN PAGE LEVEL JS -->\r\n");
      out.write("    <script src=\"assets/js/scripts.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    \r\n");
      out.write("       <script src=\"assets/plugins/pace/pace.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"assets/plugins/jquery/jquery-1.11.1.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"assets/plugins/modernizr.custom.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"assets/plugins/jquery-ui/jquery-ui.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"assets/plugins/boostrapv3/js/bootstrap.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"assets/plugins/jquery/jquery-easy.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"assets/plugins/jquery-unveil/jquery.unveil.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"assets/plugins/jquery-bez/jquery.bez.min.js\"></script>\r\n");
      out.write("    <script src=\"assets/plugins/jquery-ios-list/jquery.ioslist.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"assets/plugins/jquery-actual/jquery.actual.min.js\"></script>\r\n");
      out.write("    <script src=\"assets/plugins/jquery-scrollbar/jquery.scrollbar.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"assets/plugins/bootstrap-select2/select2.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"assets/plugins/classie/classie.js\"></script>\r\n");
      out.write("    <script src=\"assets/plugins/switchery/js/switchery.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"assets/plugins/bootstrap3-wysihtml5/bootstrap3-wysihtml5.all.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"assets/plugins/jquery-autonumeric/autoNumeric.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"assets/plugins/dropzone/dropzone.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"assets/plugins/bootstrap-tag/bootstrap-tagsinput.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"assets/plugins/jquery-inputmask/jquery.inputmask.min.js\"></script>\r\n");
      out.write("    <script src=\"assets/plugins/boostrap-form-wizard/js/jquery.bootstrap.wizard.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"assets/plugins/jquery-validation/js/jquery.validate.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"assets/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"assets/plugins/summernote/js/summernote.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"assets/plugins/moment/moment.min.js\"></script>\r\n");
      out.write("    <script src=\"assets/plugins/bootstrap-daterangepicker/daterangepicker.js\"></script>\r\n");
      out.write("    <script src=\"assets/plugins/bootstrap-timepicker/bootstrap-timepicker.min.js\"></script>\r\n");
      out.write("    <!-- END VENDOR JS -->\r\n");
      out.write("    <!-- BEGIN CORE TEMPLATE JS -->\r\n");
      out.write("    <script src=\"pages/js/pages.min.js\"></script>\r\n");
      out.write("    <!-- END CORE TEMPLATE JS -->\r\n");
      out.write("    <!-- BEGIN PAGE LEVEL JS -->\r\n");
      out.write("    <script src=\"assets/js/form_elements.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"assets/js/scripts.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <!-- END PAGE LEVEL JS -->\r\n");
      out.write("    <script>\r\n");
      out.write("    $(function()\r\n");
      out.write("    {\r\n");
      out.write("      $('#form-register').validate()\r\n");
      out.write("    })\r\n");
      out.write("    </script>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
