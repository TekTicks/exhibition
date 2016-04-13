package org.apache.jsp.html;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class calenderDemo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("   <meta http-equiv=\"content-type\" content=\"text/html;charset=UTF-8\" />\n");
      out.write("    <meta charset=\"utf-8\" />\n");
      out.write("    <title>Pages - Admin Dashboard UI Kit - Form Wizard</title>\n");
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
      out.write("    <meta http-equiv=\"Pragma\" content=\"no-cache\">\n");
      out.write("<meta http-equiv=\"Cache-Control\" content=\"no-cache\">\n");
      out.write("<meta http-equiv=\"Expires\" content=\"Sat, 01 Dec 2001 00:00:00 GMT\">\n");
      out.write("     <script src=\"assets/js/phoneNoValidation.js\" type=\"text/javascript\"></script>\n");
      out.write("     \n");
      out.write("    <!--[if lte IE 9]>\n");
      out.write("\t<link href=\"assets/plugins/codrops-dialogFx/dialog.ie.css\" rel=\"stylesheet\" type=\"text/css\" media=\"screen\" />\n");
      out.write("\t<![endif]-->\n");
      out.write("    <script type=\"text/javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js\"></script>\n");
      out.write("    <script src=\"pages/js/jquery-1.4.2.min.js\"></script>\n");
      out.write("   \n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <script>\n");
      out.write("        $(\".datepicker-component2\").each(function() {\n");
      out.write("    $(this).datepicker();\n");
      out.write("});\n");
      out.write("\n");
      out.write("$(\".datepicker-component2\").click(function() {\n");
      out.write("    $(\".datepicker-days .day\").click(function() {\n");
      out.write("        $('.datepicker').hide();\n");
      out.write("    });\n");
      out.write("});\n");
      out.write("            </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    \n");
      out.write("        \n");
      out.write("        \n");
      out.write("          <div class=\"form-group\">\n");
      out.write("                          \n");
      out.write("                         \n");
      out.write("                                <label class=\"col-sm-3 control-label\"> &nbsp &nbsp &nbsp Date Of Birth   </label>\n");
      out.write("                               \n");
      out.write("                                  <div class=\"col-sm-8\">\n");
      out.write("                                <div style=\"text-align:right;padding-right:1%; position:relative;\">                           \n");
      out.write("                    <input type=\"text\" class=\"form-control\" data-date-format=\"yyyy-mm-dd\" placeholder=\"Pick a date\" id=\"datepicker-component2\" name=\"dateOfBirth\" value=\"\" required>\n");
      out.write("                                </div>   \n");
      out.write("                                      </div>\n");
      out.write("            <div class=\"col-sm-1\">  <span class=\"input-lg\"> <i class=\"fa fa-calendar\"></i>  </span></div>\n");
      out.write("                         </div> \n");
      out.write("         <script src=\"assets/plugins/pace/pace.min.js\" type=\"text/javascript\"></script>\n");
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
      out.write("    <script src=\"assets/plugins/bootstrap3-wysihtml5/bootstrap3-wysihtml5.all.min.js\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"assets/plugins/jquery-autonumeric/autoNumeric.js\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"assets/plugins/dropzone/dropzone.min.js\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"assets/plugins/bootstrap-tag/bootstrap-tagsinput.min.js\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"assets/plugins/jquery-inputmask/jquery.inputmask.min.js\"></script>\n");
      out.write("    <script src=\"assets/plugins/boostrap-form-wizard/js/jquery.bootstrap.wizard.min.js\" type=\"text/javascript\"></script>\n");
      out.write("    <script src=\"assets/plugins/jquery-validation/js/jquery.validate.min.js\" type=\"text/javascript\"></script>\n");
      out.write("    <script src=\"assets/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js\" type=\"text/javascript\"></script>\n");
      out.write("    <script src=\"assets/plugins/summernote/js/summernote.min.js\" type=\"text/javascript\"></script>\n");
      out.write("    <script src=\"assets/plugins/moment/moment.min.js\"></script>\n");
      out.write("    <script src=\"assets/plugins/bootstrap-daterangepicker/daterangepicker.js\"></script>\n");
      out.write("    <script src=\"assets/plugins/bootstrap-timepicker/bootstrap-timepicker.min.js\"></script>\n");
      out.write("    <!-- END VENDOR JS -->\n");
      out.write("    <!-- BEGIN CORE TEMPLATE JS -->\n");
      out.write("    <script src=\"pages/js/pages.min.js\"></script>\n");
      out.write("    <!-- END CORE TEMPLATE JS -->\n");
      out.write("    <!-- BEGIN PAGE LEVEL JS -->\n");
      out.write("    <script src=\"assets/js/form_elements.js\" type=\"text/javascript\"></script>\n");
      out.write("    <script src=\"assets/js/scripts.js\" type=\"text/javascript\"></script>\n");
      out.write("    </body>\n");
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
