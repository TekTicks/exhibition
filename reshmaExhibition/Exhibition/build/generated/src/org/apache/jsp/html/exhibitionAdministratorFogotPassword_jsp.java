package org.apache.jsp.html;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class exhibitionAdministratorFogotPassword_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("  <head>\n");
      out.write("    <meta http-equiv=\"content-type\" content=\"text/html;charset=UTF-8\" />\n");
      out.write("    <meta charset=\"utf-8\" />\n");
      out.write("    <title>exhibition Administrator Login</title>\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no, shrink-to-fit=no\" />\n");
      out.write("    <link rel=\"apple-touch-icon\" href=\"pages/ico/60.png\">\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"76x76\" href=\"pages/ico/76.png\">\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"120x120\" href=\"pages/ico/120.png\">\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"152x152\" href=\"pages/ico/152.png\">\n");
      out.write("    <link rel=\"icon\" type=\"image/x-icon\" href=\"favicon.ico\" />\n");
      out.write("    <meta name=\"apple-mobile-web-app-capable\" content=\"yes\">\n");
      out.write("    <meta name=\"apple-touch-fullscreen\" content=\"yes\">\n");
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
      out.write("    <script type=\"text/javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js\"></script>\n");
      out.write("    <script src=\"pages/js/jquery-1.4.2.min.js\"></script>\n");
      out.write("    <!--<script src=\"assets/js/checkPassword.js\" type=\"text/javascript\"></script> -->\n");
      out.write("    <!--[if lte IE 9]>\n");
      out.write("        <link href=\"pages/css/ie9.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("    <![endif]-->\n");
      out.write("    \n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("\t$(document).ready(function(){\n");
      out.write("\t\t$(\"#login_frm\").submit(function(){\n");
      out.write("\n");
      out.write("\t\t\t //remove previous class and add new \"myinfo\" class\n");
      out.write("\t     //   $(\"#msgbox\").removeClass().addClass('myinfo').text('Validating Your Login ').fadeIn(1000);\n");
      out.write("\n");
      out.write("\t\t\t\n");
      out.write("\t\t\tthis.timer = setTimeout(function () {\n");
      out.write("\t\t\t\t$.ajax({\n");
      out.write("\t\t          \turl: '/Exhibition/html/report.jsp',\n");
      out.write("\t\t          \tdata: 'un='+ $('#newpassword').val() +'&pw=' + $('#confirmpassowrd').val(),\n");
      out.write("\t\t          \ttype: 'post',\n");
      out.write("\t\t   \t\tsuccess: function(msg){\n");
      out.write("                                \n");
      out.write("                                if(msg != 'ERROR') // Message Sent, check and redirect\n");
      out.write("\t\t\t\t{\n");
      out.write("                                      \n");
      out.write("                                      \n");
      out.write("                                          $(\"#msgbox3\").html('Data updated successfully').addClass('myinfo').fadeTo(900,1,function()\n");
      out.write("\t\t\t             {\n");
      out.write("\t\t\t                 //redirect to secure page\n");
      out.write("\t\t\t              //document.location='/Exhibition/html/receiveOTP.jsp?user='+msg;\n");
      out.write("\t\t\t             });\n");
      out.write("                                        \n");
      out.write("                                    \n");
      out.write("                                  \n");
      out.write("                                }\n");
      out.write("\t\t\t\telse\n");
      out.write("\t\t\t\t{\n");
      out.write("\t\t\t\t\t$(\"#msgbox3\").fadeTo(200,0.1,function() //start fading the messagebox\n");
      out.write("\t\t                {\n");
      out.write("\t\t\t                  //add message and change the class of the box and start fading\n");
      out.write("\t\t\t                 $(this).html('sorry ..data not found').removeClass().addClass('myerror').fadeTo(900,1);\n");
      out.write("                                 });\n");
      out.write("                                }\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t});\n");
      out.write("\t\t\t}, 200);\n");
      out.write("\t\t\treturn false;\n");
      out.write(" \t\t});\t\t\n");
      out.write("\n");
      out.write("\t});\n");
      out.write("   </script>  \n");
      out.write("<style>\n");
      out.write("#exists{display:none}\n");
      out.write("#cross{display:none}\n");
      out.write(".myinfo\n");
      out.write("{\n");
      out.write("\tmargin: 5px auto;\n");
      out.write("\tbackground:#d6e3f5;\n");
      out.write("\tborder: 1px #0010ac solid;\n");
      out.write("\tpadding:5px;\n");
      out.write("\tcolor:#0010ac;\n");
      out.write("\tfont-size:12px;\n");
      out.write("\twidth:350px;\n");
      out.write("\tmin-height:0px;\n");
      out.write("\t-moz-border-radius:4px;\n");
      out.write("\t-webkit-border-radius:4px;\n");
      out.write("\ttext-align: center;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".myerror\n");
      out.write("{\n");
      out.write("\tmargin: 5px auto;\n");
      out.write("\tbackground:#FFDFDF;\n");
      out.write("\tborder: 1px #FF0000 solid;\n");
      out.write("\tpadding:5px;\n");
      out.write("\tcolor:#FF0000;\n");
      out.write("\tfont-size:12px;\n");
      out.write("\twidth:350px;\n");
      out.write("\tmin-height:0px;\n");
      out.write("\t-moz-border-radius:4px;\n");
      out.write("\t-webkit-border-radius:4px;\n");
      out.write("\ttext-align: center;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("   \n");
      out.write("     <script type=\"text/javascript\">\n");
      out.write("    window.onload = function()\n");
      out.write("    {\n");
      out.write("      // fix for windows 8\n");
      out.write("      if (navigator.appVersion.indexOf(\"Windows NT 6.2\") != -1)\n");
      out.write("        document.head.innerHTML += '<link rel=\"stylesheet\" type=\"text/css\" href=\"pages/css/windows.chrome.fix.css\" />'\n");
      out.write("    }\n");
      out.write("    </script>\n");
      out.write("  </head>\n");
      out.write("  <body class=\"fixed-header \">\n");
      out.write(" <div class=\"login-wrapper \"> -->\n");
      out.write("    <div class=\"bg-pic\">\n");
      out.write("        <!-- START Background Pic-->\n");
      out.write("      <img src=\"assets/img/demo/new-york-city-buildings-sunrise-morning-hd-wallpaper.jpg\" data-src=\"assets/img/demo/new-york-city-buildings-sunrise-morning-hd-wallpaper.jpg\" data-src-retina=\"assets/img/demo/new-york-city-buildings-sunrise-morning-hd-wallpaper.jpg\" alt=\"\" class=\"lazy\">\n");
      out.write("        <!-- END Background Pic-->\n");
      out.write("        <!-- START Background Caption-->\n");
      out.write("        <div class=\"bg-caption pull-bottom sm-pull-bottom text-white p-l-20 m-b-20\">\n");
      out.write("        <!--  <h2 class=\"semi-bold text-white\">\n");
      out.write("\t\t\t\t\tPages make it easy to enjoy what matters the most in the life</h2>\n");
      out.write("          <p class=\"small\">\n");
      out.write("            images Displayed are solely for representation purposes only, All work copyright of respective owner, otherwise � 2013-2014 REVOX.\n");
      out.write("          </p>-->\n");
      out.write("        </div>\n");
      out.write("        <!-- END Background Caption-->\n");
      out.write("      </div>\n");
      out.write("      <div class=\"login-container bg-white\">\n");
      out.write("        <div class=\"p-l-50 m-l-20 p-r-50 m-r-20 p-t-50 m-t-30 sm-p-l-15 sm-p-r-15 sm-p-t-40\">\n");
      out.write("            <h1> <center> Forgot Password </center></h1> <br> <br>\n");
      out.write("          \n");
      out.write("          <!-- START Login Form -->\n");
      out.write("          <form id=\"login_frm\" class=\"p-t-15\" role=\"form\" action=\"/Exhibition/ForgotPasswordServlet\" >\n");
      out.write("            <!-- START Form Control-->\n");
      out.write("           \n");
      out.write("             <div class=\"form-group form-group-default\">\n");
      out.write("            \n");
      out.write("              <div class=\"controls\">\n");
      out.write("             <input type=\"password\" class=\"form-control\" id=\"newpassword\" name=\"newpassword\" placeholder=\"Enter New Password\" style=\"text-align: center\" required>\n");
      out.write("            </div>  \t<div id=\"msgbox1\"></div></div>\n");
      out.write("           <div class=\"form-group form-group-default\">\n");
      out.write("            \n");
      out.write("              <div class=\"controls\">\n");
      out.write("<input type=\"password\" class=\"form-control\" id=\"confirmpassword\" name=\"confirmpassword\" placeholder=\"Confirm Password\" style=\"text-align: center\" required>\n");
      out.write("            </div>\t<div id=\"msgbox2\"></div> </div>\n");
      out.write("            <div id=\"msgbox3\"></div>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("              <div class=\"row\">\n");
      out.write("            \n");
      out.write("                  <button class=\"btn btn-primary btn-cons m-t-10\" type=\"submit\" >Update</button> \n");
      out.write("                  \n");
      out.write("                 <button class=\"btn btn-primary btn-cons m-t-10\" type=\"submit\" onclick=\"/Exhibition/html/exhibitionAdminLog.jsp\">Cancel</button>  </div>\n");
      out.write("           \n");
      out.write("          </form>\n");
      out.write("          <!--END Login Form-->\n");
      out.write("          \n");
      out.write("        </div>\n");
      out.write("      </div> </div>\n");
      out.write("      <!-- END Login Right Container-->\n");
      out.write("  <!--  </div> -->\n");
      out.write("   \n");
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
      out.write("       \n");
      out.write("    <!-- END VENDOR JS -->\n");
      out.write("    <script src=\"pages/js/pages.min.js\"></script>\n");
      out.write("    <script>\n");
      out.write("    $(function()\n");
      out.write("    {\n");
      out.write("      $('#form-login').validate();\n");
      out.write("    });\n");
      out.write("    </script>\n");
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
