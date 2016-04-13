package org.apache.jsp.html;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class modalDemo_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<div id=\"myModal\" class=\"modal fade\">\n");
      out.write("  <div class=\"modal-dialog\">\n");
      out.write("    <div class=\"modal-content\">\n");
      out.write("      <!-- dialog body -->\n");
      out.write("      <div class=\"modal-body\">\n");
      out.write("        <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("        Hello world!\n");
      out.write("      </div>\n");
      out.write("      <!-- dialog buttons -->\n");
      out.write("      <div class=\"modal-footer\"><button type=\"button\" class=\"btn btn-primary\">OK</button></div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!-- sometime later, probably inside your on load event callback -->\n");
      out.write("<script>\n");
      out.write("    $(\"#myModal\").on(\"show\", function() {    // wire up the OK button to dismiss the modal when shown\n");
      out.write("        $(\"#myModal a.btn\").on(\"click\", function(e) {\n");
      out.write("            console.log(\"button pressed\");   // just as an example...\n");
      out.write("            $(\"#myModal\").modal('hide');     // dismiss the dialog\n");
      out.write("        });\n");
      out.write("    });\n");
      out.write("    $(\"#myModal\").on(\"hide\", function() {    // remove the event listeners when the dialog is dismissed\n");
      out.write("        $(\"#myModal a.btn\").off(\"click\");\n");
      out.write("    });\n");
      out.write("    \n");
      out.write("    $(\"#myModal\").on(\"hidden\", function() {  // remove the actual elements from the DOM when fully hidden\n");
      out.write("        $(\"#myModal\").remove();\n");
      out.write("    });\n");
      out.write("    \n");
      out.write("    $(\"#myModal\").modal({                    // wire up the actual modal functionality and show the dialog\n");
      out.write("      \"backdrop\"  : \"static\",\n");
      out.write("      \"keyboard\"  : true,\n");
      out.write("      \"show\"      : true                     // ensure the modal is shown immediately\n");
      out.write("    });\n");
      out.write("</script>");
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
