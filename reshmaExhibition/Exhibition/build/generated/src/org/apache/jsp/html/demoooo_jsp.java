package org.apache.jsp.html;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class demoooo_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("  <head>\n");
      out.write("    <meta http-equiv=\"content-type\" content=\"text/html;charset=UTF-8\" />\n");
      out.write("    <meta charset=\"utf-8\" />\n");
      out.write("    <title>Pages - Admin Dashboard UI Kit</title>\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\n");
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
      out.write("    <!--[if lte IE 9]>\n");
      out.write("        <link href=\"pages/css/ie9.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("    <![endif]-->\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("    window.onload = function()\n");
      out.write("    {\n");
      out.write("      // fix for windows 8\n");
      out.write("      if (navigator.appVersion.indexOf(\"Windows NT 6.2\") != -1)\n");
      out.write("        document.head.innerHTML += '<link rel=\"stylesheet\" type=\"text/css\" href=\"pages/css/windows.chrome.fix.css\" />'\n");
      out.write("    }\n");
      out.write("    </script>\n");
      out.write("  </head>  \n");
      out.write("  <body class=\"fixed-header   \">\n");
      out.write("<div class=\"container-fluid container-fixed-lg bg-white\">\n");
      out.write("            <div class=\"panel panel-transparent\">\n");
      out.write("              <div class=\"panel-heading\">\n");
      out.write("                <div class=\"panel-title\">Boostrap Native Modals\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("              <div class=\"panel-body\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                  <div class=\"col-lg-4 col-sm-6\">\n");
      out.write("                    <div class=\"panel panel-transparent\">\n");
      out.write("                      <div class=\"panel-heading no-padding\">\n");
      out.write("                        <div class=\"panel-title\">\n");
      out.write("                          Slide Up\n");
      out.write("                        </div>\n");
      out.write("                      </div>\n");
      out.write("                      <div class=\"panel-body no-padding\">\n");
      out.write("                        <div class=\"m-b-15\">\n");
      out.write("                          <img alt=\"\" src=\"assets/img/demo/1.svg\" class=\"full-width\">\n");
      out.write("                        </div>\n");
      out.write("                        <p>\n");
      out.write("                          This modal slides in from the bottom and rests on the middle of the screen, to add this simply add the class\n");
      out.write("                          <code>slide-up</code> to the <code>modal</code> div\n");
      out.write("                        </p>\n");
      out.write("                        <div class=\"radio radio-success inline\">\n");
      out.write("                          <input id=\"slideup_full\" name=\"slideup_toggler\" type=\"radio\" value=\"full\">\n");
      out.write("                          <label for=\"slideup_full\">Large</label>\n");
      out.write("                          <br>\n");
      out.write("                          <input id=\"slideup_default\" name=\"slideup_toggler\" type=\"radio\" value=\"default\" checked>\n");
      out.write("                          <label for=\"slideup_default\">Default</label>\n");
      out.write("                          <br>\n");
      out.write("                          <input id=\"slideup_small\" name=\"slideup_toggler\" type=\"radio\" value=\"mini\">\n");
      out.write("                          <label for=\"slideup_small\">Small</label>\n");
      out.write("                        </div>\n");
      out.write("                        <button class=\"btn btn-green btn-lg pull-right bottom-right\" id=\"btnToggleSlideUpSize\">Generate</button>\n");
      out.write("                      </div>\n");
      out.write("                    </div>\n");
      out.write("                  </div> </div></div>\n");
      out.write("                    <body>\n");
      out.write("                    </html>\n");
      out.write("                       ");
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
