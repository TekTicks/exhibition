
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


<% 
      String speakersName = "";
      String description = "";
      String designation = "";
      String qualification = "";
    
    
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

String sn = item.getFieldName(); 
String value1 = item.getString();    
    
String de = item.getFieldName();
String value2 = item.getString();

String deg = item.getFieldName(); 
String value3 = item.getString();    
    
String qua = item.getFieldName();
String value4 = item.getString();


if (sn.equals("speakersName")) {
speakersName = value1;
count1 = 1;
}

if (de.equals("description")) {
description = value2;
count1 = 1;
}
if (deg.equals("designation")) {
designation = value3;
count1 = 1;
}

if (qua.equals("qualification")) {
qualification = value4;
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
}
} catch (Exception e) {
e.printStackTrace();
}
}
}
 Connection connection;
                        connection=dbConnection.getConnection();
PreparedStatement psmnt = null;
try{
    
      HttpSession ss1=request.getSession();
       String idValid=(String)ss1.getAttribute("myex_id");    
      
     HttpSession ss=request.getSession();
      String fileName=(String)ss.getAttribute("fileName");
     
     // Class.forName("com.mysql.jdbc.Driver").newInstance();
      Connection con;
      con=dbConnection.getConnection();
psmnt = con.prepareStatement("insert into media(link,type) values('"+fileName+"',?)");
//psmnt.setString(1, );
psmnt.setString(1, "");
 psmnt.executeUpdate();
                        Connection con5;
                        con5 = dbConnection.getConnection();
                               Statement stat5=con5.createStatement();
                               ResultSet rs5=stat5.executeQuery("select * from media where link='"+fileName+"'");
                            
                           
                             if(!rs5.next())
                            {
                             
                            }
                             else
                                
                            { 
                                 String logoMediaID=rs5.getString(1);
                            //set Session
                                    ss.setAttribute("logoMediaID",logoMediaID);

                                 
                            }
                           
 
 
 
 String iddsf=(String)ss.getAttribute("logoMediaID");

 
  Connection con2;
                        con2=dbConnection.getConnection();
 String val="update exhibitionSpeakers set name='"+speakersName+"' , description='"+description+"',designation='"+designation+"' , qualification='"+qualification+"', profileMediaId='"+iddsf+"' where id='"+idValid+"' ";
 PreparedStatement ps=con2.prepareStatement(val);
                          
                          int n=  ps.executeUpdate();
                         
                        if(n>0)
                        {
                            out.print("ok");
                        }
                        else
                        {
                             out.print("wrn");
                        }
                        response.sendRedirect("/Exhibition/html/exhibitionSpeakerView.jsp");
}
catch(Exception e){
    
         out.println("error"+e.toString());
        }


}





%>
