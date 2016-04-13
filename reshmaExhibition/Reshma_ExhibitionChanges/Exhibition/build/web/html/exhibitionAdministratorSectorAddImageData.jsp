
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


<%    String sectorName = "";
      String description = "";
     
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



if (sn.equals("sectorName")) {
sectorName = value1;
count1 = 1;
}

if (de.equals("description")) {
description = value2;
count1 = 1;
}

} else {
try {
String itemName = item.getName();
File savedFile = new File("D:/exhibitionMain/web/html/images/" + itemName);
item.write(savedFile);
out.println(savedFile);
if (count1 == 1) {
HttpSession ss=request.getSession();
ss.setAttribute("fileName",itemName);   
out.println(sectorName);
out.println(description);

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
    
      HttpSession ss=request.getSession();
       String idValid=(String)ss.getAttribute("idValid");    
       out.print(idValid);
      String fileName=(String)ss.getAttribute("fileName");
      //out.println(fileName);
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
 out.print(iddsf);
 
  Connection con2;
                        con2=dbConnection.getConnection();
out.print("dfdkjfks");
 PreparedStatement ps=con2.prepareStatement("insert into exhibitionSector(sectorName,sectorMediaId,description,createdBy,modifiedBy)  values (?,'"+iddsf+"',?,'"+idValid+"','"+idValid+"')");
                                 
                            ps.setString(1, sectorName);
                            ps.setString(2, description);  
                          int n=  ps.executeUpdate();
                         
                        if(n>0)
                        {
                            out.print("ok");
                        }
                        else
                        {
                             out.print("wrn");
                        }
                            response.sendRedirect("/Exhibition/html/exhibitionAdministratorSector.jsp");
}
catch(Exception e){
    
         out.println("error"+e.toString());
        }


}





%>
</td></tr></table>
</center>

<%


%>