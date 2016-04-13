package org.apache.jsp.html;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ownerPortal.dbConnection;
import java.io.*;;
import java.sql.*;;
import java.sql.DriverManager;;
import java.util.Scanner.*;;

public final class ownerRegistration_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("  <head>\n");
      out.write(" \n");
      out.write("    <meta http-equiv=\"content-type\" content=\"text/html;charset=UTF-8\" />\n");
      out.write("    <meta charset=\"utf-8\" />\n");
      out.write("    <title>Owner Registration Page</title>\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\n");
      out.write("    <link rel=\"apple-touch-icon\" href=\"pages/ico/60.png\"> \n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"76x76\" href=\"pages/ico/76.png\">\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"120x120\" href=\"pages/ico/120.png\">\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"152x152\" href=\"pages/ico/152.png\"> \n");
      out.write("    <link rel=\"icon\" type=\"image/x-icon\" href=\"favicon.ico\" />\n");
      out.write("    <meta name=\"apple-mobile-web-app-capable\" content=\"yes\">\n");
      out.write("    <meta name=\"apple-mobile-web-app-status-bar-style\" content=\"default\">\n");
      out.write("    <meta content=\"\" name=\"description\" />\n");
      out.write("    <meta content=\"\" name=\"author\" />\n");
      out.write("    <link href=\"assets/plugins/pace/pace-theme-flash.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("    <link href=\"assets/plugins/boostrapv3/css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("    <link href=\"assets/plugins/font-awesome/css/font-awesome.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("    <link href=\"assets/plugins/jquery-scrollbar/jquery.scrollbar.css\" rel=\"stylesheet\" type=\"text/css\" media=\"screen\" />\n");
      out.write("    <link href=\"assets/plugins/bootstrap-select2/select2.css\" rel=\"stylesheet\" type=\"text/css\" media=\"screen\" />\n");
      out.write("    <link href=\"assets/plugins/switchery/css/switchery.min.css\" rel=\"stylesheet\" type=\"text/css\" media=\"screen\" />\n");
      out.write("    <link href=\"pages/css/pages-icons.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("    <link class=\"main-stylesheet\" href=\"pages/css/pages.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("    <link href=\"pages/css/ckvajax.css\" rel=\"stylesheet\" type=\"text/css\" />   \n");
      out.write("    <script type=\"text/javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js\"></script>\n");
      out.write("    <script src=\"pages/js/jquery-1.4.2.min.js\"></script>\n");
      out.write("   <!-- <script src=\"pages/js/ownerRegValidation.js\"></script> -->\n");
      out.write("    <script src=\"pages/js/phonenoValidation.js\"></script> \n");
      out.write("    <script src=\"pages/js/ownerloginValidation.js\"></script>\n");
      out.write("\n");
      out.write("    <script>\n");
      out.write("        \n");
      out.write("\t$(document).ready(function(){\n");
      out.write("\t\t$(\"#login_frm\").submit(function(){\n");
      out.write("                     \n");
      out.write("                              $(\"#msgbox1\").removeClass().addClass('myinfo').text(' ').fadeOut(0);\n");
      out.write("                              $(\"#msgbox2\").removeClass().addClass('myinfo').text('').fadeOut(0);\n");
      out.write("\t\t\tthis.timer = setTimeout(function () {\n");
      out.write("\t\t\t\t$.ajax({\n");
      out.write("\t\t          \turl: '/Exhibition/ckvDemoServlet',\n");
      out.write("\t\t          \tdata: 'emailid='+ $('#email').val()+'&contact='+ $('#phone').val()+'&cname='+ $('#cname').val()+'&password='+ $('#password').val()+'&ccode='+ $('#prefix').val()+'&cpassword='+ $('#cpassword').val(),\n");
      out.write("\t\t          \ttype: 'post',\n");
      out.write("                                \n");
      out.write("\t\t   \t\tsuccess: function(msg){\n");
      out.write("                                  \n");
      out.write("                                if(msg != 'ERROR') // Message Sent, check and redirect\n");
      out.write("\t\t\t\t{\t\t\t\t// and direct to the success page\n");
      out.write("\t\t\t\t\tif(msg == 'invalidemail')\t\n");
      out.write("                                        {\n");
      out.write("\t\t\t\t\t$(\"#msgbox1\").html('Email id already exists').addClass('myerror').fadeTo(900,1,function()\n");
      out.write("\t\t\t             {\n");
      out.write("\t\t\t                \n");
      out.write("\t\t\t             });\n");
      out.write("                                        }\n");
      out.write("                                        else if(msg == 'invalidphone')\n");
      out.write("                                        {\n");
      out.write("                                            $(\"#msgbox2\").html('Phone number already exists').addClass('myerror').fadeTo(900,1,function()\n");
      out.write("\t\t\t             {\n");
      out.write("\t\t\t                 \n");
      out.write("\t\t\t             });\n");
      out.write("                                        }\n");
      out.write("                                          else                                         {\n");
      out.write("                                          $(\"#msgbox2\").html('Invalid phone id and email.....').addClass('myinfo').fadeOut(5000,0.5,function()\n");
      out.write("\t\t\t             {\n");
      out.write("\t\t\t                 \n");
      out.write("\t\t\t             });\n");
      out.write("                                        }\n");
      out.write("                                        \n");
      out.write("                                }\n");
      out.write("\t\t\t\telse\n");
      out.write("\t\t\t\t{\n");
      out.write("\t\t\t\t\t$(\"#msgbox3\").fadeTo(200,0.1,function() //start fading the messagebox\n");
      out.write("\t\t                {\n");
      out.write("\t\t\t           $(this).html('valid data!!').removeClass().addClass('myinfo').fadeOut(5000,1);\n");
      out.write("                                        document.location='ownerRegOtpVerify.jsp?user='+msg;\n");
      out.write("    });\n");
      out.write("                                }\n");
      out.write("                                \n");
      out.write("                                \n");
      out.write("                                \n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t});\n");
      out.write("\t\t\t}, 200);\n");
      out.write("\t\t\treturn false;\n");
      out.write(" \t\t\n");
      out.write("    \n");
      out.write("    });\t\t\n");
      out.write("\n");
      out.write("\t});\n");
      out.write("\n");
      out.write("    \n");
      out.write(" \n");
      out.write("    </script>\n");
      out.write("\n");
      out.write("  </head>\n");
      out.write("  <body class=\"fixed-header \">\n");
      out.write("    <div class=\"register-container full-height sm-p-t-30\">\n");
      out.write("      <div class=\"container-sm-height full-height\">\n");
      out.write("        <div class=\"row row-sm-height\">\n");
      out.write("          <div class=\"col-sm-12 col-sm-height col-middle\">\n");
      out.write("           <h1><b> Sign up </h1>\n");
      out.write("           <h3> Pages makes it easy to enjoy what matters the most in your life</h3>\n");
      out.write("            \n");
      out.write("            <form name=\"login_frm\" id=\"login_frm\" class=\"p-t-15\" >\n");
      out.write("            \n");
      out.write("                <div class=\"row\">\n");
      out.write("                 <div class=\"col-sm-12\">\n");
      out.write("                  <div class=\"form-group form-group-default\">\n");
      out.write("                    <label>Company Name</label>\n");
      out.write("                    <input type=\"text\" name=\"cname\" id=\"cname\" placeholder=\"\" class=\"form-control\" required>\n");
      out.write("                    <div id=\"msgbox\"></div> \n");
      out.write("                  </div>\n");
      out.write("                 </div>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                <div class=\"row\">\n");
      out.write("                 <div class=\"col-sm-12\">\n");
      out.write("                  <div class=\"form-group form-group-default\">\n");
      out.write("                    <label>Email</label>\n");
      out.write("                    <input type=\"email\" name=\"email\" id=\"email\" placeholder=\"We will send loging details to you\" class=\"form-control\" required>\n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("                    <div id=\"msgbox1\"></div>\n");
      out.write("               </div>\n");
      out.write("                    \n");
      out.write("                \n");
      out.write("                \n");
      out.write("                 \n");
      out.write("                     \n");
      out.write("                     \n");
      out.write("                     \n");
      out.write("                     ");
   
                       Connection con;
                       con=dbConnection.getConnection();
                       Statement stat=con.createStatement();
                       ResultSet rs=stat.executeQuery("select * from country");
                     
      out.write("  \n");
      out.write("                     \n");
      out.write("                <div class=\"form-group form-group-default input-group\">\n");
      out.write("                    <span class=\"input-group-addon\">\n");
      out.write("                    <select class=\"cs-select cs-skin-slide cs-transparent\" id=\"prefix\" data-init-plugin=\"cs-select\">\n");
      out.write("                     ");

                         while(rs.next())
                         {
                           String sm=rs.getString(4);
                           String id=rs.getString(1);
                        
      out.write("\n");
      out.write("                          %>\n");
      out.write("                             <optgroup label=''><option  value=\"");
      out.print(id );
      out.write('"');
      out.write('>');
      out.print(sm );
      out.write("</option></optgroup>\n");
      out.write("                       \n");
      out.write("                        ");

                         }
                        
      out.write("\n");
      out.write("                    </select>\n");
      out.write("                    </span>\n");
      out.write("                    <label>Contact Number</label>\n");
      out.write("                    <input type=\"tel\" name=\"phone\" onkeypress=\"return validate(event)\"  id=\"phone\" maxlength=\"10\" minlength=\"10\" pattern=\"[789][0-9]{9}\" class=\"form-control\" placeholder=\"\" required>\n");
      out.write("                </div>\n");
      out.write("                    <div id=\"msgbox2\"></div>\n");
      out.write("\n");
      out.write("                                \n");
      out.write("                <div class=\"row\">\n");
      out.write("                 <div class=\"col-sm-12\">\n");
      out.write("                  <div class=\"form-group form-group-default\">\n");
      out.write("                    <label>Password</label>\n");
      out.write("                    <input type=\"password\" name=\"password\" id=\"password\" placeholder=\"Minimum of 6 Charactors\" minlength=\"6\" class=\"form-control\" required>\n");
      out.write("                 </div>\n");
      out.write("                 </div></div>\n");
      out.write("                \n");
      out.write("                <div class=\"row\">\n");
      out.write("                 <div class=\"col-sm-12\">\n");
      out.write("                  <div class=\"form-group form-group-default\">\n");
      out.write("                    <label> Confirm Password</label>\n");
      out.write("                    <input type=\"password\" name=\"cpassword\" id=\"cpassword\" placeholder=\"Minimum of 6 Charactors\" minlength=\"6\" class=\"form-control\" required>\n");
      out.write("                  </div>\n");
      out.write("                 </div>\n");
      out.write("                     <div id=\"msgbox3\"></div>\n");
      out.write("                </div>\n");
      out.write("              <br>\n");
      out.write("                <button class=\"btn btn-primary btn-cons m-t-10\" type=\"submit\" onclick=\"return val2();\">Submit</button>\n");
      out.write("                <button class=\"btn btn-primary btn-cons m-t-10\" type=\"button\" onclick=\"document.location.href='/Exhibition/html/ownerLogin.jsp'\" >Cancel</button> \n");
      out.write("              \n");
      out.write("                 \n");
      out.write("  \n");
      out.write("            </form>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("      \n");
      out.write("      \n");
      out.write("<!--*******************************************************Template Content ***********************************************************-->      \n");
      out.write("    <div class=\" full-width\">\n");
      out.write("      <div class=\"register-container m-b-10 clearfix\">\n");
      out.write("        <div class=\"inline pull-left\">\n");
      out.write("          <img src=\"assets/img/demo/pages_icon.png\" alt=\"\" class=\"m-t-5 \" data-src=\"assets/img/demo/pages_icon.png\" data-src-retina=\"assets/img/demo/pages_icon_2x.png\" width=\"60\" height=\"60\">\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-md-10 m-t-15\">\n");
      out.write("          <p class=\"hinted-text small inline \">No part of this website or any of its contents may be reproduced, copied, modified or adapted, without the prior written consent of the author, unless otherwise indicated for stand-alone materials.</p>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <!-- START OVERLAY -->\n");
      out.write("    <div class=\"overlay hide\" data-pages=\"search\">\n");
      out.write("      <!-- BEGIN Overlay Content !-->\n");
      out.write("      <div class=\"overlay-content has-results m-t-20\">\n");
      out.write("        <!-- BEGIN Overlay Header !-->\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("          <!-- BEGIN Overlay Logo !-->\n");
      out.write("          <img class=\"overlay-brand\" src=\"assets/img/logo.png\" alt=\"logo\" data-src=\"assets/img/logo.png\" data-src-retina=\"assets/img/logo_2x.png\" width=\"78\" height=\"22\">\n");
      out.write("          <!-- END Overlay Logo !-->\n");
      out.write("          <!-- BEGIN Overlay Close !-->\n");
      out.write("          <a href=\"#\" class=\"close-icon-light overlay-close text-black fs-16\">\n");
      out.write("            <i class=\"pg-close\"></i>\n");
      out.write("          </a>\n");
      out.write("          <!-- END Overlay Close !-->\n");
      out.write("        </div>\n");
      out.write("        <!-- END Overlay Header !-->\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("          <!-- BEGIN Overlay Controls !-->\n");
      out.write("          <input id=\"overlay-search\" class=\"no-border overlay-search bg-transparent\" placeholder=\"Search...\" autocomplete=\"off\" spellcheck=\"false\">\n");
      out.write("          <br>\n");
      out.write("          <div class=\"inline-block\">\n");
      out.write("            <div class=\"checkbox right\">\n");
      out.write("              <input id=\"checkboxn\" type=\"checkbox\" value=\"1\" checked=\"checked\">\n");
      out.write("              <label for=\"checkboxn\"><i class=\"fa fa-search\"></i> Search within page</label>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"inline-block m-l-10\">\n");
      out.write("            <p class=\"fs-13\">Press enter to search</p>\n");
      out.write("          </div>\n");
      out.write("          <!-- END Overlay Controls !-->\n");
      out.write("        </div>\n");
      out.write("        <!-- BEGIN Overlay Search Results, This part is for demo purpose, you can add anything you like !-->\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("          <span>\n");
      out.write("                <strong>suggestions :</strong>\n");
      out.write("            </span>\n");
      out.write("          <span id=\"overlay-suggestions\"></span>\n");
      out.write("          <br>\n");
      out.write("          <div class=\"search-results m-t-40\">\n");
      out.write("            <p class=\"bold\">Pages Search Results</p>\n");
      out.write("            <div class=\"row\">\n");
      out.write("              <div class=\"col-md-6\">\n");
      out.write("                <!-- BEGIN Search Result Item !-->\n");
      out.write("                <div class=\"\">\n");
      out.write("                  <!-- BEGIN Search Result Item Thumbnail !-->\n");
      out.write("                  <div class=\"thumbnail-wrapper d48 circular bg-success text-white inline m-t-10\">\n");
      out.write("                    <div>\n");
      out.write("                      <img width=\"50\" height=\"50\" src=\"assets/img/profiles/avatar.jpg\" data-src=\"assets/img/profiles/avatar.jpg\" data-src-retina=\"assets/img/profiles/avatar2x.jpg\" alt=\"\">\n");
      out.write("                    </div>\n");
      out.write("                  </div>\n");
      out.write("                  <!-- END Search Result Item Thumbnail !-->\n");
      out.write("                  <div class=\"p-l-10 inline p-t-5\">\n");
      out.write("                    <h5 class=\"m-b-5\"><span class=\"semi-bold result-name\">ice cream</span> on pages</h5>\n");
      out.write("                    <p class=\"hint-text\">via john smith</p>\n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("                <!-- END Search Result Item !-->\n");
      out.write("                <!-- BEGIN Search Result Item !-->\n");
      out.write("                <div class=\"\">\n");
      out.write("                  <!-- BEGIN Search Result Item Thumbnail !-->\n");
      out.write("                  <div class=\"thumbnail-wrapper d48 circular bg-success text-white inline m-t-10\">\n");
      out.write("                    <div>T</div>\n");
      out.write("                  </div>\n");
      out.write("                  <!-- END Search Result Item Thumbnail !-->\n");
      out.write("                  <div class=\"p-l-10 inline p-t-5\">\n");
      out.write("                    <h5 class=\"m-b-5\"><span class=\"semi-bold result-name\">ice cream</span> related topics</h5>\n");
      out.write("                    <p class=\"hint-text\">via pages</p>\n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("                <!-- END Search Result Item !-->\n");
      out.write("                <!-- BEGIN Search Result Item !-->\n");
      out.write("                <div class=\"\">\n");
      out.write("                  <!-- BEGIN Search Result Item Thumbnail !-->\n");
      out.write("                  <div class=\"thumbnail-wrapper d48 circular bg-success text-white inline m-t-10\">\n");
      out.write("                    <div><i class=\"fa fa-headphones large-text \"></i>\n");
      out.write("                    </div>\n");
      out.write("                  </div>\n");
      out.write("                  <!-- END Search Result Item Thumbnail !-->\n");
      out.write("                  <div class=\"p-l-10 inline p-t-5\">\n");
      out.write("                    <h5 class=\"m-b-5\"><span class=\"semi-bold result-name\">ice cream</span> music</h5>\n");
      out.write("                    <p class=\"hint-text\">via pagesmix</p>\n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("                <!-- END Search Result Item !-->\n");
      out.write("              </div>\n");
      out.write("              <div class=\"col-md-6\">\n");
      out.write("                <!-- BEGIN Search Result Item !-->\n");
      out.write("                <div class=\"\">\n");
      out.write("                  <!-- BEGIN Search Result Item Thumbnail !-->\n");
      out.write("                  <div class=\"thumbnail-wrapper d48 circular bg-info text-white inline m-t-10\">\n");
      out.write("                    <div><i class=\"fa fa-facebook large-text \"></i>\n");
      out.write("                    </div>\n");
      out.write("                  </div>\n");
      out.write("                  <!-- END Search Result Item Thumbnail !-->\n");
      out.write("                  <div class=\"p-l-10 inline p-t-5\">\n");
      out.write("                    <h5 class=\"m-b-5\"><span class=\"semi-bold result-name\">ice cream</span> on facebook</h5>\n");
      out.write("                    <p class=\"hint-text\">via facebook</p>\n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("                <!-- END Search Result Item !-->\n");
      out.write("                <!-- BEGIN Search Result Item !-->\n");
      out.write("                <div class=\"\">\n");
      out.write("                  <!-- BEGIN Search Result Item Thumbnail !-->\n");
      out.write("                  <div class=\"thumbnail-wrapper d48 circular bg-complete text-white inline m-t-10\">\n");
      out.write("                    <div><i class=\"fa fa-twitter large-text \"></i>\n");
      out.write("                    </div>\n");
      out.write("                  </div>\n");
      out.write("                  <!-- END Search Result Item Thumbnail !-->\n");
      out.write("                  <div class=\"p-l-10 inline p-t-5\">\n");
      out.write("                    <h5 class=\"m-b-5\">Tweats on<span class=\"semi-bold result-name\"> ice cream</span></h5>\n");
      out.write("                    <p class=\"hint-text\">via twitter</p>\n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("                <!-- END Search Result Item !-->\n");
      out.write("                <!-- BEGIN Search Result Item !-->\n");
      out.write("                <div class=\"\">\n");
      out.write("                  <!-- BEGIN Search Result Item Thumbnail !-->\n");
      out.write("                  <div class=\"thumbnail-wrapper d48 circular text-white bg-danger inline m-t-10\">\n");
      out.write("                    <div><i class=\"fa fa-google-plus large-text \"></i>\n");
      out.write("                    </div>\n");
      out.write("                  </div>\n");
      out.write("                  <!-- END Search Result Item Thumbnail !-->\n");
      out.write("                  <div class=\"p-l-10 inline p-t-5\">\n");
      out.write("                    <h5 class=\"m-b-5\">Circles on<span class=\"semi-bold result-name\"> ice cream</span></h5>\n");
      out.write("                    <p class=\"hint-text\">via google plus</p>\n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("                <!-- END Search Result Item !-->\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- END Overlay Search Results !-->\n");
      out.write("      </div>\n");
      out.write("      <!-- END Overlay Content !-->\n");
      out.write("    </div>\n");
      out.write("    <!-- END OVERLAY -->\n");
      out.write("    <!-- BEGIN VENDOR JS -->\n");
      out.write("    <script src=\"assets/plugins/pace/pace.min.js\" type=\"text/javascript\"></script>\n");
      out.write("    <script src=\"assets/plugins/jquery/jquery-1.11.1.min.js\" type=\"text/javascript\"></script>\n");
      out.write("    <script src=\"assets/plugins/modernizr.custom.js\" type=\"text/javascript\"></script>\n");
      out.write("    <script src=\"assets/plugins/jquery-ui/jquery-ui.min.js\" type=\"text/javascript\"></script>\n");
      out.write("    <script src=\"assets/plugins/boostrapv3/js/bootstrap.min.js\" type=\"text/javascript\"></script>\n");
      out.write("    <script src=\"assets/plugins/jquery/jquery-easy.js\" type=\"text/javascript\"></script>\n");
      out.write("    <script src=\"assets/plugins/jquery-unveil/jquery.unveil.min.js\" type=\"text/javascript\"></script>\n");
      out.write("    <script src=\"assets/plugins/jquery-bez/jquery.bez.min.js\"></script>\n");
      out.write("    <script src=\"assets/plugins/jquery-ios-list/jquery.ioslist.min.js\" type=\"text/javascript\"></script>\n");
      out.write("    <script src=\"assets/plugins/jquery-actual/jquery.actual.min.js\"></script>\n");
      out.write("    <script src=\"assets/plugins/jquery-scrollbar/jquery.scrollbar.min.js\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"assets/plugins/bootstrap-select2/select2.min.js\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"assets/plugins/classie/classie.js\"></script>\n");
      out.write("    <script src=\"assets/plugins/switchery/js/switchery.min.js\" type=\"text/javascript\"></script>\n");
      out.write("    <script src=\"assets/plugins/jquery-validation/js/jquery.validate.min.js\" type=\"text/javascript\"></script>\n");
      out.write("    <!-- END VENDOR JS -->\n");
      out.write("    <script src=\"pages/js/pages.min.js\"></script>\n");
      out.write("   \n");
      out.write("  </body>\n");
      out.write("</html>\n");
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