package org.apache.jsp.html;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ownerPortal.dbConnection;
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

public final class ownerProfileContactInfoSave_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<center><h1>Your  Profile has been Uploaded</h1></center>\n");
    String socialmedia = "";
      String socialmedialink = "";
     
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
String socialMedia = item.getFieldName();
String value = item.getString();

String link = item.getFieldName();
String value1 = item.getString();



if (socialMedia.equals("socialmedia")) {
socialmedia = value;
count1 = 1;
}

if (link.equals("socialmedialink")) {
socialmedialink = value1;
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
out.println("<tr><td align='left'><b>Name:</td><td><b>" + socialmedia);
out.println("<tr><td align='left'><b>Name:</td><td><b>" + socialmedialink);

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
      String idd=(String)ss.getAttribute("ownerId");
      String fileName=(String)ss.getAttribute("fileName");
      String logId=(String)ss.getAttribute("logoMedia");
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      connection = DriverManager.getConnection(connectionURL, "root", "12345");
      psmnt = connection.prepareStatement("insert into media(link,type) values('"+fileName+"',?)");
        //psmnt.setString(1, );
        psmnt.setString(1, "");
        psmnt.executeUpdate();

 
 
                            Connection con5;
                               con5=dbConnection.getConnection();
                               Statement stat5=con5.createStatement();
                               ResultSet rs5=stat5.executeQuery("select * from media where link='"+fileName+"'");
                            
                           
                             if(!rs5.next())
                            {
                             
                            }
                             else
                                
                            { 
                                 String logoMediaID=rs5.getString(1);
                                    //set Session
                                    ss.setAttribute("socialMediaLogo",logoMediaID);

                                 
                            }
                           
 
 
 
 String Logo=(String)ss.getAttribute("socialMediaLogo");
 
  Connection con;
  con=dbConnection.getConnection();
                
                
                // Inserting data into ownerSocialMedia            
                PreparedStatement ps1=con.prepareStatement("insert into ownerSocialMedia(socialMediaId,link,createdBy,modifiedBy,iconMediaId)values((select id from socialMedia where socialMedia=?),?,(select id from owner where id='"+idd+"'),(select id from owner where id='"+idd+"'),(select id from media where id='"+Logo+"'))");
                ps1.setString(1,socialmedia);
                ps1.setString(2,socialmedialink);
                ps1.executeUpdate();
                
                response.sendRedirect("/Exhibition/html/ownerProfile.jsp"); 
}
catch(Exception e){
    
         out.println("error"+e.toString());
        }


}






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
