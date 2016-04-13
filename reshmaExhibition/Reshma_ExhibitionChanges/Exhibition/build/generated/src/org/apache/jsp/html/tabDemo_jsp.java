package org.apache.jsp.html;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ownerPortal.dbConnection;
import java.io.*;;
import java.sql.*;;
import java.sql.DriverManager;;

public final class tabDemo_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("       \n");
      out.write("<div class=\"tab-pane slide-left padding-20\" id=\"tab1\">\n");
      out.write("                    \n");
      out.write("                 \n");
      out.write("               <div class=\"container-fluid container-fixed-lg\">\n");
      out.write("            <!-- START PANEL -->\n");
      out.write("            <div class=\"panel panel-transparent\">\n");
      out.write("              <div class=\"panel-heading\">\n");
      out.write("                <div class=\"panel-title\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"pull-right\">\n");
      out.write("                  <div class=\"col-xs-12\">\n");
      out.write("                      <button id=\"show-modal\" class=\"btn btn-primary btn-cons\" onclick=\"document.location.href='/Exhibition/html/exhibitorRepresentativeAddContactInfo.jsp';\"><i class=\"fa fa-plus\"></i> Add ContactInfo\n");
      out.write("                    </button>\n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"clearfix\"></div>\n");
      out.write("              </div>\n");
      out.write("              <div class=\"panel-body\">\n");
      out.write("                  \n");
      out.write("\n");
      out.write("               <table class=\"table table-hover demo-table-search\" id=\"tableWithSearch\">\n");
      out.write("                     \n");
      out.write("                     \n");
      out.write("                     \n");
      out.write("                     <thead>\n");
      out.write("                        <tr>\n");
      out.write("                          <!--  <th>ID</th> -->\n");
      out.write("                        <th>Date</th>\n");
      out.write("                        <th>Name</th>        \n");
      out.write("                        <th>EMAIL ID</th>\n");
      out.write("                        <th>Phone No</th>\n");
      out.write("                        <th>Update/Delete.</th>\n");
      out.write("                        </tr>\n");
      out.write("                  </thead>\n");
      out.write("                  <tbody>\n");
      out.write("                    ");
   
                         HttpSession ss=request.getSession();
                         String idd=(String)ss.getAttribute("exhibitorId");
                         Connection con;
                         con=dbConnection.getConnection();
                         Statement stat=con.createStatement();
                         ResultSet rs=stat.executeQuery("select * from exhibitorRepresentative where createdBy='"+idd+"'");
                         int count=0;
                        
                         while(rs.next())
                         {
                            count++;
                            out.println("<tr>");
                            String firstName=rs.getString(4);
                            String lastName=rs.getString(5);
                            String fullname=firstName+" "+lastName;
                            //out.println("<td class='v-align-middle semi-bold'><p>"+rs1.getString(7)+"</p></td>");
                            out.println("<td class='v-align-middle semi-bold'><p>"+rs.getString(10)+"</p></td>");
                            out.println("<td class='v-align-middle semi-bold'><p>"+fullname+"</p></td>");
                            out.println("<td class='v-align-middle semi-bold'><p>"+rs.getString(7)+"</p></td>");
                            out.println("<td class='v-align-middle semi-bold'><p>"+rs.getString(8)+"</p></td>");
                            String kv=rs.getString(1);
                            String kv1=rs.getString(2);
                            String kv2=rs.getString(3);
                            String kv3=rs.getString(9);
                            
                             HttpSession ss1=request.getSession();
                                  ss1.setAttribute("id",kv);
                                  ss1.setAttribute("date",kv2);
                                  ss1.setAttribute("socialmedia1",kv1);
                                  ss1.setAttribute("link1",kv3);
                                  
                            
                           
      out.write("\n");
      out.write("                          \n");
      out.write("                             <td>\n");
      out.write("                                 <div class=\"btn-group\">\n");
      out.write("                                  <!-- passing id of ownerSocailMedia from url-->\n");
      out.write("                                 <button  type=\"button\" class=\"btn btn-success\" onclick=\"document.location.href='/Exhibition/html/exhibitorRepresentativeEditContactInfo.jsp?myid1=");
      out.print( kv );
      out.write("';\"><i class=\"fa fa-pencil\"></i></button>\n");
      out.write("                                <button type=\"button\" class=\"btn btn-success\" data-toggle=\"modal\" data-target=\"#confirm-delete\" data-href=\"/Exhibition/exhibitorRepresentativeAddContactInfoDelete?myid1=");
      out.print(kv);
      out.write("\"><i class=\"fa fa-trash-o\"></i>                                 </button>\n");
      out.write("                                 </div>\n");
      out.write("                            </td>");

                            out.println(" </tr>");
                        }
                       
                   
      out.write("   \n");
      out.write("                   </tbody>\n");
      out.write("                </table>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- END PANEL -->\n");
      out.write("          </div>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("\n");
      out.write("                    \n");
      out.write("                </div>");
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
