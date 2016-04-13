package org.apache.jsp.html;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ownerPortal.dbConnection;
import java.sql.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>  \n");
      out.write("<script language=\"javascript\" type=\"text/javascript\">  \n");
      out.write("var xmlHttp  \n");
      out.write("var xmlHttp\n");
      out.write("function showChild(int){\n");
      out.write("    if (typeof XMLHttpRequest != \"undefined\"){\n");
      out.write("        xmlHttp= new XMLHttpRequest();\n");
      out.write("    }\n");
      out.write("    else if (window.ActiveXObject){\n");
      out.write("        xmlHttp= new ActiveXObject(\"Microsoft.XMLHTTP\");\n");
      out.write("    }\n");
      out.write("    if (xmlHttp==null){\n");
      out.write("        alert(\"Browser does not support XMLHTTP Request\")\n");
      out.write("        return;\n");
      out.write("    } \n");
      out.write("    var url=\"child.jsp\";\n");
      out.write("    url +=\"?count=\" +int;\n");
      out.write("    xmlHttp.onreadystatechange = childChange;\n");
      out.write("    xmlHttp.open(\"GET\", url, true);\n");
      out.write("    xmlHttp.send(null);\n");
      out.write("}\n");
      out.write("\n");
      out.write("function childChange(){   \n");
      out.write("    if (xmlHttp.readyState==4 || xmlHttp.readyState==\"complete\"){   \n");
      out.write("        document.getElementById(\"child\").innerHTML=xmlHttp.responseText   \n");
      out.write("    }   \n");
      out.write("}\n");
      out.write("</script>  \n");
      out.write("</head>  \n");
      out.write("<body>  \n");
      out.write("<table border=\"1\">\n");
      out.write("<tr><th>Category</th><th>Sub-Category</th> <th>city</th></tr>\n");
      out.write("<tr><td>\n");
      out.write("<select name='parent' class=\"select-cat\">  \n");
      out.write(" <option value=\"none\">Select</option>  \n");
      out.write("    ");

 Connection con5;
 con5=dbConnection.getConnection();
 Statement stmt = con5.createStatement();  
 ResultSet rs = stmt.executeQuery("Select * from country WHERE continentId IS NOT NULL");
 while(rs.next()){
     
      out.write("\n");
      out.write("      <option value=\"");
      out.print(rs.getInt(1));
      out.write('"');
      out.write('>');
      out.print(rs.getString(2));
      out.write("</option>  \n");
      out.write("      ");

 }
     
      out.write("\n");
      out.write("</select> \n");
      out.write("</td>\n");
      out.write("<td >\n");
      out.write("  <select name='state' class=\"select-sub-cat\"> \n");
      out.write("   </select> \n");
      out.write("</td>\n");
      out.write("\n");
      out.write("</tr>\n");
      out.write("</table>\n");
      out.write("</body> \n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
