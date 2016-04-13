package org.apache.jsp.html;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Scanner;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
import java.sql.DriverManager;
import java.util.Scanner.*;

public final class fdsafsdf_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write(" \n");
      out.write("\n");
      out.write(" \n");
      out.write("<html>      \n");
      out.write("<head>\n");
      out.write("    <script data-require=\"jquery@*\" data-semver=\"2.0.3\" src=\"http://code.jquery.com/jquery-2.0.3.min.js\"></script>\n");
      out.write("    <script data-require=\"bootstrap@*\" data-semver=\"3.1.1\" src=\"//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js\"></script>\n");
      out.write("    <link data-require=\"bootstrap-css@3.1.1\" data-semver=\"3.1.1\" rel=\"stylesheet\" href=\"//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css\" />\n");
      out.write("    <link rel=\"stylesheet\" href=\"style.css\" />\n");
      out.write("    <script src=\"script.js\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div class=\"modal fade\" id=\"confirm-delete\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\n");
      out.write("        <div class=\"modal-dialog\">\n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("            \n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>\n");
      out.write("                    <h4 class=\"modal-title\" id=\"myModalLabel\">Confirm Delete</h4>\n");
      out.write("                </div>\n");
      out.write("            \n");
      out.write("                <div class=\"modal-body\">\n");
      out.write("                    <p>You are about to delete one track, this procedure is irreversible.</p>\n");
      out.write("                    <p>Do you want to proceed?</p>\n");
      out.write("                    <p class=\"debug-url\"></p>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                <div class=\"modal-footer\">\n");
      out.write("                    <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Cancel</button>\n");
      out.write("                    <a class=\"btn btn-danger btn-ok\">Delete</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("                     \n");
      out.write("                     \n");
      out.write("                     \n");
      out.write("                     \n");
      out.write("                     \n");
      out.write("                     ");
  
                         Class.forName("com.mysql.jdbc.Driver"); 
                         java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exhibition","root","admin"); 
                         Statement stat=con.createStatement();
                         ResultSet rs=stat.executeQuery("select * from owner");
                         
                     
      out.write("                          \n");
      out.write("                     ");

                         while(rs.next())
                         {
                             String cid=rs.getString("id");
                             String fname = rs.getString("username"); 
                     
      out.write("\n");
      out.write("                      <input type=\"text\" size=\"50\" value=\"");
      out.print(cid);
      out.print(fname);
      out.write("\" placeholder=\"id\">\n");
      out.write("                      <a href=\"#\" data-href=\"/web/delete?id=");
      out.print(cid);
      out.write("\" data-toggle=\"modal\" data-target=\"#confirm-delete\">Delete record ");
      out.print(cid);
      out.write("</a><br>  \n");
      out.write("                     ");

                         }
                     
      out.write("\n");
      out.write("                     \n");
      out.write("\n");
      out.write("\n");
      out.write("                     \n");
      out.write("<!--\n");
      out.write("    <button class=\"btn btn-default\" data-href=\"/web/delete?id=54\" data-toggle=\"modal\" data-target=\"#confirm-delete\">\n");
      out.write("        Delete record #54\n");
      out.write("    </button> <br>\n");
      out.write("<button class=\"btn btn-default\" data-href=\"/delete.php?55\" data-toggle=\"modal\" data-target=\"#confirm-delete\">\n");
      out.write("        Delete record #55\n");
      out.write("</button><br>\n");
      out.write("<button class=\"btn btn-default\" data-href=\"/delete.php?56\" data-toggle=\"modal\" data-target=\"#confirm-delete\">\n");
      out.write("        Delete record #56\n");
      out.write("</button><br>\n");
      out.write("    <button class=\"btn btn-default\" data-href=\"/delete.php?57\" data-toggle=\"modal\" data-target=\"#confirm-delete\">\n");
      out.write("        Delete record #57\n");
      out.write("    </button> <br>\n");
      out.write("    <button class=\"btn btn-default\" data-href=\"/delete.php?558\" data-toggle=\"modal\" data-target=\"#confirm-delete\">\n");
      out.write("        Delete record #558\n");
      out.write("    </button><br>\n");
      out.write("    <button class=\"btn btn-default\" data-href=\"/delete.php?559\" data-toggle=\"modal\" data-target=\"#confirm-delete\">\n");
      out.write("        Delete record #559\n");
      out.write("    </button><br>\n");
      out.write("    <button class=\"btn btn-default\" data-href=\"/delete.php?550\" data-toggle=\"modal\" data-target=\"#confirm-delete\">\n");
      out.write("        Delete record #550\n");
      out.write("    </button><br> \n");
      out.write("    -->\n");
      out.write("   \n");
      out.write("    <script>\n");
      out.write("        $('#confirm-delete').on('show.bs.modal', function(e) {\n");
      out.write("            $(this).find('.btn-ok').attr('href', $(e.relatedTarget).data('href'));\n");
      out.write("            \n");
      out.write("            $('.debug-url').html('Delete URL: <strong>' + $(this).find('.btn-ok').attr('href') + '</strong>');\n");
      out.write("        });\n");
      out.write("    </script>\n");
      out.write("</body>\n");
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
