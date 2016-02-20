package org.apache.jsp.html;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ownerLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("  <head>\n");
      out.write("    <meta http-equiv=\"content-type\" content=\"text/html;charset=UTF-8\" />\n");
      out.write("    <meta charset=\"utf-8\" />\n");
      out.write("    <title>Owner Login</title>\n");
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
      out.write("    <link href=\"pages/css/ie9.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("    <script type=\"text/javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js\"></script>\n");
      out.write("    <script src=\"pages/js/jquery-1.4.2.min.js\"></script>\n");
      out.write("    <script src=\"pages/js/ownerloginValidation.js\"></script>\n");
      out.write("    <link href=\"pages/css/ownerLoginAjax.css\" rel=\"stylesheet\" type=\"text/css\" />  \n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <script>\n");
      out.write("        $(document).ready(function(){\n");
      out.write("\t\t$(\"#login_frm\").submit(function(){\n");
      out.write("                //remove previous class and add new \"myinfo\" class\n");
      out.write("\t        $(\"#msgbox3\").removeClass().addClass('myinfo').text('Validating Your Login ').fadeOut(0);\n");
      out.write("                $(\"#msgbox1\").removeClass().addClass('myinfo').text('Validating Your Login ').fadeOut(0);\n");
      out.write("\t\t\tthis.timer = setTimeout(function () {\n");
      out.write("                            $.ajax({\n");
      out.write("\t\t            url: '/Exhibition/OwnerLoginCheck',\n");
      out.write("\t\t            data: 'un='+ $('#login_id').val() +'&pw=' + $('#password').val(),\n");
      out.write("\t\t            type: 'post',\n");
      out.write("\t\t   \t    success: function(msg){\n");
      out.write("                                alert(msg);\n");
      out.write("                                if(msg != 'ERROR') // Message Sent, check and redirect\n");
      out.write("\t\t\t\t{\n");
      out.write("                                       if(msg == 'emailinvalid')\n");
      out.write("                                        {\n");
      out.write("                                            $(\"#msgbox1\").fadeTo(200,0.1,function() //start fading the messagebox\n");
      out.write("                                             {\n");
      out.write("                                               //add message and change the class of the box and start fading\n");
      out.write("                                               $(this).html('EmailId doesnt exists...').removeClass().addClass('myerror').fadeTo(900,10);\n");
      out.write("                                             });\n");
      out.write("                                        }\n");
      out.write("                                        else if(msg =='passwordinvalid')\n");
      out.write("                                        {\n");
      out.write("                                            $(\"#msgbox3\").fadeTo(200,0.1,function() //start fading the messagebox\n");
      out.write("                                              {\n");
      out.write("                                                //add message and change the class of the box and start fading\n");
      out.write("                                                $(this).html('Sorry, Wrong Password.').removeClass().addClass('myerror').fadeTo(900,1);\n");
      out.write("                                              });\n");
      out.write("                                         }\n");
      out.write("                                        else\n");
      out.write("                                        {\n");
      out.write("                                          $(\"#msgbox3\").html('Login Verified, Logging in.....').addClass('myinfo').fadeTo(900,1,function()\n");
      out.write("\t\t\t                  {\n");
      out.write("                                            document.location='/Exhibition/html/ownerProfile.jsp';\n");
      out.write("\t\t\t                    //redirect to secure page\n");
      out.write("\t\t\t                   });\n");
      out.write("                                        }\n");
      out.write("                                }\n");
      out.write("\t\t\t\telse\n");
      out.write("\t\t\t\t{\n");
      out.write("                                    $(\"#msgbox3\").fadeTo(200,0.1,function() //start fading the messagebox\n");
      out.write("\t\t                    {\n");
      out.write("\t\t\t            $(this).html('Sorry, Wrong Combination Of Username And Password.').removeClass().addClass('myerror').fadeTo(900,1);\n");
      out.write("                                    }); \n");
      out.write("                                }\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t});\n");
      out.write("\t\t\t}, 200);\n");
      out.write("\t\t\treturn false;\n");
      out.write(" \t\t});\t\t\n");
      out.write("\n");
      out.write("\t});     \n");
      out.write("    </script>\n");
      out.write("\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("   <body class=\"fixed-header   \">\n");
      out.write("        <div class=\"login-wrapper \">\n");
      out.write("            \n");
      out.write("        <!-- START Login Background Pic Wrapper-->\n");
      out.write("        <div class=\"bg-pic\">\n");
      out.write("        <!-- START Background Pic-->\n");
      out.write("        <img src=\"assets/img/demo/new-york-city-buildings-sunrise-morning-hd-wallpaper.jpg\" data-src=\"assets/img/demo/new-york-city-buildings-sunrise-morning-hd-wallpaper.jpg\" data-src-retina=\"assets/img/demo/new-york-city-buildings-sunrise-morning-hd-wallpaper.jpg\" alt=\"\" class=\"lazy\">\n");
      out.write("        <!-- END Background Pic-->\n");
      out.write("         </div>\n");
      out.write("         <!-- END Login Background Pic Wrapper-->\n");
      out.write("      \n");
      out.write("      \n");
      out.write("         <!-- START Login Right Container-->\n");
      out.write("         <div class=\"login-container bg-white\">\n");
      out.write("         <div class=\"p-l-50 m-l-20 p-r-50 m-r-20 p-t-50 m-t-30 sm-p-l-15 sm-p-r-15 sm-p-t-40\">\n");
      out.write("         <p class=\"p-t-35\"><h2><b>Owner Login</b></h2>\n");
      out.write("         \n");
      out.write("         \n");
      out.write("         <!-- START Login Form -->\n");
      out.write("         <form name=\"login_frm\" id=\"login_frm\" class=\"p-t-15\" >\n");
      out.write("             <!-- START Form Control-->\n");
      out.write("            <div class=\"form-group form-group-default\">\n");
      out.write("                <label>Email</label>\n");
      out.write("                <div class=\"controls\">\n");
      out.write("                <input type=\"text\" name=\"login_id\" id=\"login_id\" placeholder=\"Enter Email Id\" class=\"form-control\" required>\n");
      out.write("             </div>\n");
      out.write("            </div>\n");
      out.write("              <div id=\"msgbox1\"></div>\n");
      out.write("            <!-- END Form Control-->\n");
      out.write("            <!-- START Form Control-->\n");
      out.write("            <div class=\"form-group form-group-default\">\n");
      out.write("              <label>Password</label>\n");
      out.write("              <div class=\"controls\">\n");
      out.write("              <input type=\"password\" class=\"form-control\" id=\"password\" minlength=\"6\" name=\"password\"  placeholder=\"Enter Password\" required>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- END Form Control-->\n");
      out.write("            <div id=\"msgbox2\"></div>\n");
      out.write("            <div id=\"msgbox3\"></div><div id=\"msgbox6\"></div><div id=\"msgbox7\"></div>\n");
      out.write("            <!-- START Form Control-->\n");
      out.write("            <div class=\"row\">\n");
      out.write("            <div class=\"col-md-6 no-padding\">\n");
      out.write("            <div class=\"checkbox \">\n");
      out.write("                 <input type=\"checkbox\" value=\"1\" id=\"checkbox1\">\n");
      out.write("                  <label for=\"checkbox1\">Keep Me Signed in</label> </div> </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- END Form Control-->  \n");
      out.write("            <div align=\"right\">\n");
      out.write("                <a href=\"/Exhibition/html/ownerLoginEmailVerify.jsp\" class=\"text-info small\"><font size=\"2.5\"><b>Forgot Password..?</font></a>\n");
      out.write("            </div>\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <center>\n");
      out.write("            <button class=\"btn btn-primary btn-cons m-t-10\" name=\"login\" id=\"login\"  type=\"submit\" onclick=\"return val1();\">Sign in</button>\n");
      out.write("            <button class=\"btn btn-primary btn-cons m-t-10\" name=\"clear\" id=\"clear\"  type=\"reset\">Clear</button>\n");
      out.write("            </center>\n");
      out.write("          </form>\n");
      out.write("          <!--END Login Form-->\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <!-- END Login Right Container-->\n");
      out.write("    </div>\n");
      out.write("    <!-- END PAGE CONTAINER -->\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    \n");
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
      out.write("    <!-- BEGIN CORE TEMPLATE JS -->\n");
      out.write("    <script src=\"pages/js/pages.min.js\"></script>\n");
      out.write("    <!-- END CORE TEMPLATE JS -->\n");
      out.write("    <!-- BEGIN PAGE LEVEL JS -->\n");
      out.write("    <script src=\"assets/js/scripts.js\" type=\"text/javascript\"></script>\n");
      out.write("    <!-- END PAGE LEVEL JS -->\n");
      out.write("    <script>\n");
      out.write("    $(function()\n");
      out.write("    {\n");
      out.write("      $('#form-login').validate()\n");
      out.write("    })\n");
      out.write("    </script>\n");
      out.write("  </body>\n");
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
