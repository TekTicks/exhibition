package org.apache.jsp.html;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.io.*;
import java.sql.DriverManager;;

public final class ckvProfileSave_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body bgcolor=\"#D8CEF6\">\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("\n");
      out.write(" \n");
      out.write("                        ");

                           try
                           {
                            String NAME =request.getParameter("name");;
                            String PEMAIL =request.getParameter("p_email");
                            String SEMAIL =request.getParameter("s_email");
                            String ABOUT =request.getParameter("about");
                            String PCONTACT =request.getParameter("p_contact");
                            String SCONTACT =request.getParameter("s_contact");
                            String WEBSITE =request.getParameter("website");

                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Exhibition","root","12345");
                            PreparedStatement ps=con.prepareStatement("insert into ownerProfile values (?,?,?,?,?,?,?)");
                                 ps.setString(1, NAME);
                                 ps.setString(2,PEMAIL);
                                 ps.setString(3, SEMAIL);
                                 ps.setString(4, ABOUT); 
                                 ps.setString(5, PCONTACT);
                                 ps.setString(6, SCONTACT);
                                 ps.setString(7, WEBSITE); 
                                 ps.executeUpdate();
                                 out.println("<center>data saved</center>");
                           }
                           catch(Exception ee)
                           {
                               out.println("error"+ee);
                         
                           }
                             
                            
      out.write("\n");
      out.write("            </body>\n");
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
