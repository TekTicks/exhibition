package org.apache.jsp.html;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.DriverManager;
import java.util.List;
import java.util.Iterator;
import java.io.File;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.*;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.fileupload.FileItem;
import java.io.*;
import java.sql.*;
import java.util.zip.*;

public final class imageUpload_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<center><h1>Your  Profile has been Uploaded</h1></center>\r\n");
    String cname = "";
      String p_email = "";
int count1 = 0;

boolean isMultipart = ServletFileUpload.isMultipartContent(request);
if (!isMultipart) {
} else {
FileItemFactory factory = new DiskFileItemFactory();
ServletFileUpload upload = new ServletFileUpload(factory);
List items = null;
try {
items = upload.parseRequest(request);
} catch (FileUploadException e) {
e.printStackTrace();
}
Iterator itr = items.iterator();
while (itr.hasNext()) {
FileItem item = (FileItem) itr.next();
if (item.isFormField()) {
String name = item.getFieldName();
String value = item.getString();

String addrs = item.getFieldName();
String value1 = item.getString();

if (name.equals("cname")) {
cname = value;
count1 = 1;
}

if (addrs.equals("p_email")) {
p_email = value1;
count1 = 1;
}
} else {
try {
String itemName = item.getName();


File savedFile = new File("D:/pagal/Exhibition/web/html/" + itemName);
item.write(savedFile);
if (count1 == 1) {
    HttpSession ss=request.getSession();
ss.setAttribute("fileName",itemName);   
out.println("<tr><td align='left'><b>Name:</td><td><b>" + cname);
out.println("<tr><td align='left'><b>Name:</td><td><b>" + p_email);
}
} catch (Exception e) {
e.printStackTrace();
}
}
}
Connection connection = null;
String connectionURL = "jdbc:mysql://localhost:3306/Exhibition";
PreparedStatement psmnt = null;
try{
    
      HttpSession ss=request.getSession();

    String idd=(String)ss.getAttribute("fileName");
Class.forName("com.mysql.jdbc.Driver").newInstance();
connection = DriverManager.getConnection(connectionURL, "root", "12345");
psmnt = connection.prepareStatement("insert into media(link,type) values('"+idd+"',?)");
//psmnt.setString(1, );
psmnt.setString(1, "");
int s = psmnt.executeUpdate();
if(s>0){
System.out.println("Uploaded successfully !");
}
else{
System.out.println("Error!");
}
}
catch(Exception e){
    
         out.println("error"+e.toString());
        }


}






      out.write("\r\n");
      out.write("</td></tr></table>\r\n");
      out.write("</center>\r\n");
      out.write("\r\n");




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
