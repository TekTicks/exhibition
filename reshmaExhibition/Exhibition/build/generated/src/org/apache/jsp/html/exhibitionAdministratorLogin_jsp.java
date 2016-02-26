package org.apache.jsp.html;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class exhibitionAdministratorLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>Exhibition Administrator Login</title>\n");
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
      out.write("    <script type=\"text/javascript\">\n");
      out.write("\t$(document).ready(function(){\n");
      out.write("\t\t$(\"#login_frm\").submit(function(){\n");
      out.write("\n");
      out.write("\t\t\t //remove previous class and add new \"myinfo\" class\n");
      out.write("\t        $(\"#msgbox\").removeClass().addClass('myinfo').text('Validating Your Login ').fadeIn(1000);\n");
      out.write("\n");
      out.write("\t\t\t\n");
      out.write("\t\t\tthis.timer = setTimeout(function () {\n");
      out.write("\t\t\t\t$.ajax({\n");
      out.write("\t\t          \turl: '/Exhibition/exhibitionAdministratorLoginCheck',\n");
      out.write("\t\t          \tdata: 'un='+ $('#login_id').val() +'&pw=' + $('#password').val(),\n");
      out.write("\t\t          \ttype: 'post',\n");
      out.write("\t\t   \t\tsuccess: function(msg){\n");
      out.write("                                if(msg != 'ERROR') // Message Sent, check and redirect\n");
      out.write("\t\t\t\t{\n");
      out.write("                                    if(msg == 'emailinvalid')\n");
      out.write("                                    {  \n");
      out.write("                                             \t$(\"#msgbox1\").fadeTo(300,1,function() //start fading the messagebox\n");
      out.write("                                        {\n");
      out.write("\t\t\t                  //add message and change the class of the box and start fading\n");
      out.write("\t\t\t                 $(this).html('invalid email....').removeClass().addClass('myerror').fadeTo(300,1);\n");
      out.write("                                      //  document.location='/Exhibition/html/exhibitionAdministratorLogin.jsp?user';\n");
      out.write("                                      });\n");
      out.write(" \n");
      out.write("\n");
      out.write("                                    }\n");
      out.write("                                    else if(msg =='passwordinvalid')\n");
      out.write("                                    {\n");
      out.write("                                               \n");
      out.write("                                               \t$(\"#msgbox2\").fadeTo(300,1,function() //start fading the messagebox\n");
      out.write("\t\t                {\n");
      out.write("\t\t\t                  //add message and change the class of the box and start fading\n");
      out.write("\t\t\t                 $(this).html('Sorry, Wrong Password.').removeClass().addClass('myerror').fadeTo(300,1);\n");
      out.write("                                       // document.location='/Exhibition/html/exhibitionAdministratorLogin.jsp?user';\n");
      out.write("                                 });\n");
      out.write(" \n");
      out.write("                                    }\n");
      out.write("                                    else\n");
      out.write("                                    {\n");
      out.write("                                          $(\"#msgbox3\").html('Login Verified, Logging in.....').addClass('myinfo').fadeTo(300,1,function()\n");
      out.write("\t\t\t             {\n");
      out.write("\t\t\t                 //redirect to secure page\n");
      out.write("\t\t\t              document.location='/Exhibition/html/exhibitionAdministratorProfilePage.jsp';\n");
      out.write("\t\t\t             });\n");
      out.write("                                        \n");
      out.write("                                    }\n");
      out.write("                                \n");
      out.write("                                }\n");
      out.write("\t\t\t\telse\n");
      out.write("\t\t\t\t{\n");
      out.write("\t\t\t\t\t$(\"#msgbox3\").fadeTo(300,1,function() //start fading the messagebox\n");
      out.write("\t\t                {\n");
      out.write("\t\t\t                  //add message and change the class of the box and start fading\n");
      out.write("\t\t\t                 $(this).html('Sorry, Wrong Combination Of Username And Password.').removeClass().addClass('myerror').fadeTo(300,1);\n");
      out.write("                                       //  document.location='/Exhibition/html/exhibitionAdministratorLogin.jsp?user';\n");
      out.write("                                 });\n");
      out.write("                                }\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t});\n");
      out.write("\t\t\t}, 200);\n");
      out.write("\t\t\treturn false;\n");
      out.write(" \t\t});\t\t\n");
      out.write("\n");
      out.write("\t});\n");
      out.write("   </script>   \n");
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
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    function clearForm(oForm) {\n");
      out.write("    \n");
      out.write("  var elements = oForm.elements; \n");
      out.write("    \n");
      out.write("  oForm.reset();\n");
      out.write("\n");
      out.write("  for(i=0; i<elements.length; i++) {\n");
      out.write("      \n");
      out.write("  field_type = elements[i].type.toLowerCase();\n");
      out.write("  \n");
      out.write("  switch(field_type) {\n");
      out.write("  \n");
      out.write("    case \"text\": \n");
      out.write("    case \"password\": \n");
      out.write("    case \"msg\" :\n");
      out.write("     \n");
      out.write("   \n");
      out.write("      elements[i].value = \"\"; \n");
      out.write("      break;\n");
      out.write("    default: \n");
      out.write("      break;\n");
      out.write("  }\n");
      out.write("    }\n");
      out.write("}\n");
      out.write("    \n");
      out.write("    </script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    window.onload = function()\n");
      out.write("    {\n");
      out.write("      // fix for windows 8\n");
      out.write("      if (navigator.appVersion.indexOf(\"Windows NT 6.2\") != -1)\n");
      out.write("        document.head.innerHTML += '<link rel=\"stylesheet\" type=\"text/css\" href=\"pages/css/windows.chrome.fix.css\" />'\n");
      out.write("    }\n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write("   <body class=\"fixed-header   \">\n");
      out.write("        <div class=\"login-wrapper \">\n");
      out.write("      <!-- START Login Background Pic Wrapper-->\n");
      out.write("      <div class=\"bg-pic\">\n");
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
      out.write("      <!-- END Login Background Pic Wrapper-->\n");
      out.write("      <!-- START Login Right Container-->\n");
      out.write("      <div class=\"login-container bg-white\">\n");
      out.write("        <div class=\"p-l-50 m-l-20 p-r-50 m-r-20 p-t-50 m-t-30 sm-p-l-15 sm-p-r-15 sm-p-t-40\">\n");
      out.write("         <!-- <img src=\"assets/img/logo.png\" alt=\"logo\" data-src=\"assets/img/logo.png\" data-src-retina=\"assets/img/logo_2x.png\" width=\"78\" height=\"22\"> -->\n");
      out.write("         <p class=\"p-t-35\"><h2><b>Administrator Login</b></h2>\n");
      out.write("          <!-- START Login Form -->\n");
      out.write("         <form name=\"login_frm\" id=\"login_frm\" action=\"\" method=\"post\" class=\"p-t-15\" >\n");
      out.write("            <!-- START Form Control-->\n");
      out.write("            <div class=\"form-group form-group-default\">\n");
      out.write("              <label>Email</label>\n");
      out.write("              <div class=\"controls\">\n");
      out.write("                <input type=\"text\" name=\"login_id\" id=\"login_id\" placeholder=\"\" class=\"form-control\" required>\n");
      out.write("              </div>\n");
      out.write("                             \t<div id=\"msgbox1\"></div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <!-- END Form Control-->\n");
      out.write("            <!-- START Form Control-->\n");
      out.write("            <div class=\"form-group form-group-default\">\n");
      out.write("              <label>Password</label>\n");
      out.write("              <div class=\"controls\">\n");
      out.write("                  <input type=\"password\" class=\"form-control\" id=\"password\" name=\"password\"  placeholder=\"Credentials\" required>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("              \n");
      out.write("                               \t<div id=\"msgbox2\"></div>\n");
      out.write("                                <div id=\"msgbox3\"></div>\n");
      out.write("\n");
      out.write("            <!-- START Form Control-->\n");
      out.write("            <div class=\"row\">\n");
      out.write("              <div class=\"col-md-6 no-padding\">\n");
      out.write("                <div class=\"checkbox \">\n");
      out.write("              <!--    <input type=\"checkbox\" value=\"1\" id=\"checkbox1\">\n");
      out.write("                  <label for=\"checkbox1\">Keep Me Signed in</label>-->\n");
      out.write("                                  <a href=\"/Exhibition/html/exhibitionAdministratorMobileNo.jsp\" class=\"text-info small\">Forgot Password..?</a>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("              <div class=\"col-md-6 text-right\">\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- END Form Control-->\n");
      out.write("            <button class=\"btn btn-primary btn-cons m-t-10\" name=\"login\" id=\"login\"  type=\"submit\">Sign in</button>\n");
      out.write("            <button class=\"btn btn-primary btn-cons m-t-10\" name=\"clear\" id=\"clear\"  type=\"button\" value=\"Clear Form\" onclick=\"clearForm(this.form);\">Clear</button>\n");
      out.write("\n");
      out.write("          </form>\n");
      out.write("          <!--END Login Form-->\n");
      out.write("          <div class=\"pull-bottom sm-pull-bottom\">\n");
      out.write("            <div class=\"m-b-30 p-r-80 sm-m-t-20 sm-p-r-15 sm-p-b-20 clearfix\">\n");
      out.write("              <div class=\"col-sm-3 col-md-2 no-padding\">\n");
      out.write("          <!--      <img alt=\"\" class=\"m-t-5\" data-src=\"assets/img/demo/pages_icon.png\" data-src-retina=\"assets/img/demo/pages_icon_2x.png\" height=\"60\" src=\"assets/img/demo/pages_icon.png\" width=\"60\">\n");
      out.write("              </div>\n");
      out.write("              <div class=\"col-sm-9 no-padding m-t-10\">\n");
      out.write("                <p><small>\n");
      out.write("\t\t        \t\tCreate a pages account. If you have a facebook account, log into it for this process. Sign in with <a href=\"#\" class=\"text-info\">Facebook</a> or <a href=\"#\" class=\"text-info\">Google</a></small>\n");
      out.write("                </p>-->\n");
      out.write("              </div>\n");
      out.write("                        <div id=\"error_box\"></div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <!-- END Login Right Container-->\n");
      out.write("    </div>\n");
      out.write("    <!-- END PAGE CONTAINER -->\n");
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
      out.write("      $('#form-login').validate();\n");
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
