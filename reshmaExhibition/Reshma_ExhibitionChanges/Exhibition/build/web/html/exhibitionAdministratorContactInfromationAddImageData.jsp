
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
       String title = "";
      String firstName = "";
      String lastName = "";
      String dateOfBirth = "";
      String level = "";
      String degination = "";
      String phone = "";
     String contactCountryId="";
   // out.print("fdsfjklsdf");
int count = 0;

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
String tt = item.getFieldName();
String value = item.getString();

String fn = item.getFieldName();
String value1 = item.getString();

String ln = item.getFieldName();
String value2 = item.getString();

String dob = item.getFieldName();
String value3 = item.getString();

String lev = item.getFieldName();
String value4 = item.getString();

String deg = item.getFieldName();
String value5 = item.getString();

String pn = item.getFieldName();
String value6 = item.getString();

String ccd = item.getFieldName();
String value7 = item.getString();

if (tt.equals("title")) {
title = value;
count = 1;
}

if (fn.equals("firstName")) {
firstName = value1;
count= 1;
}

if (ln.equals("lastName")) {
lastName = value2;
count = 1;
}

if (dob.equals("dateOfBirth")) {
dateOfBirth = value3;
count = 1;
}

if (lev.equals("level")) {
level = value4;
count = 1;
}

if (deg.equals("degination")) {
degination = value5;
count= 1;
}

if (pn.equals("phone")) {
phone = value6;
count= 1;
}
if (ccd.equals("contactCountryId")) {
contactCountryId = value7;
count= 1;
}

} else {
try {
String itemName = item.getName();


File savedFile = new File("D:/exhibitionMain/web/html/images/" + itemName);
item.write(savedFile);
if (count == 1) {
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
    
      HttpSession ss=request.getSession();
      String idValid=(String)ss.getAttribute("idValid");
      String fileName=(String)ss.getAttribute("fileName");
      //String logId=(String)ss.getAttribute("logoMedia");
      Connection con;
     con=dbConnection.getConnection();
psmnt = con.prepareStatement("insert into media(link,type) values('"+fileName+"',?)");
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
                                     ss.setAttribute("logoMediaID",logoMediaID);

                                 
                            }
                           
 
 
 
 String iddsf=(String)ss.getAttribute("logoMediaID");
  Connection con2;
                        con2=dbConnection.getConnection();
 PreparedStatement ps=con2.prepareStatement("update exhibitionAdminContact set title=?,firstName=?,lastName=?,dateOfBirth=?,level=?,degination=?,phoneNo=?,createdBy='"+idValid+"',modifiedBy='"+idValid+"',photoMediaId='"+iddsf+"',countryId=? where id='"+idValid+"'");
                                 
                            ps.setString(1, title);
                            ps.setString(2, firstName);
                            ps.setString(3, lastName);
                            ps.setString(4, dateOfBirth);
                            ps.setString(5, level);
                            ps.setString(6, degination);
                            ps.setString(7, phone);
                            ps.setString(8, contactCountryId);
                           int n= ps.executeUpdate();
                           if(n >0)
                           {
                               out.print("ok");
                           }
                           else
                           {
                               out.print("wrong");
                           }
                          response.sendRedirect("/Exhibition/html/exhibitionAdministratorProfilePage.jsp");
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