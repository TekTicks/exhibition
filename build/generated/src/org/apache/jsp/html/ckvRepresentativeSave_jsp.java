package org.apache.jsp.html;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.io.*;
import java.sql.DriverManager;;

public final class ckvRepresentativeSave_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Owner Profile</title>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("\n");
      out.write(" \n");
      out.write("                        ");

                           try
                           {
                            String TITLE =request.getParameter("title1");
                            out.print(TITLE);
                            String FNAME =request.getParameter("fname");
                            String LNAME =request.getParameter("lnmae");
                            String GENDER=request.getParameter("optionyes");
                            String DOB =request.getParameter("dateofbirth");
                            String DESIGNATION =request.getParameter("designation");
                            String PHONENO =request.getParameter("telephone");
                            String MOBILENO =request.getParameter("mobileno");
                            String EMAIL =request.getParameter("email");
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Exhibition","root","12345");
                            //PreparedStatement ps=con.prepareStatement("insert into ownerProfile values (?,?,?,?,?,?,?)");
                            PreparedStatement ps=con.prepareStatement("insert into ownerContactPerson(title,firstName,lastName,photoMediaId,gender,dateOfBirth,degination,phoneNo,mobileNo,email,createdBy,modifiedBy)values(?,?,?,(select id from media),?,?,?,?,?,?,(select id from owner),(select id from owner))");
                            //PreparedStatement ps1=con.prepareStatement("insert into ownerAddress(address1,address2,landmark,pincode,cityId,mapLink,createdBy,modifiedBy)values(?,?,?,?,(select id from city),?,(select id from owner),(select id from owner))");

                          

                                 ps.setString(1, TITLE);
                                 ps.setString(2,FNAME);
                                 ps.setString(3, LNAME);
                                 ps.setString(4, GENDER); 
                                 ps.setString(5, DOB);
                                 ps.setString(6, DESIGNATION);
                                 ps.setString(7, PHONENO); 
                                 ps.setString(8, MOBILENO); 
                                 ps.setString(9, EMAIL); 
                                 ps.executeUpdate();
                                 
                                 out.print("<center>data saved</center>");
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
