<%@page import="ownerPortal.dbConnection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.io.File" %>
<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@ page import="org.apache.commons.fileupload.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@page import="org.apache.commons.io.FilenameUtils"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@ page import="java.io.*,java.sql.*,java.util.zip.*" %>

<center><h1>Your  Profile has been Uploaded</h1></center>
<%    String socialmedia = "";
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


File savedFile = new File("D:/exhibitionMain/web/html/images/" + itemName);
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
String connectionURL = "jdbc:mysql://localhost:3306/ExhibitionProject";
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
                PreparedStatement ps1=con.prepareStatement("insert into exhibitorSocialMedia(socialMediaId,link,createdBy,modifiedBy)values((select id from socialMedia where socialMedia=?),?,(select id from exhibitor where id='"+21+"'),(select id from exhibitor where id='"+21+"'),(select id from media where id='"+Logo+"'))");
                ps1.setString(1,socialmedia);
                ps1.setString(2,socialmedialink);
                ps1.executeUpdate();
                
                response.sendRedirect("/Exhibition/html/ownerProfile.jsp"); 
}
catch(Exception e){
    
         out.println("error"+e.toString());
        }


}





%>


<%


%>