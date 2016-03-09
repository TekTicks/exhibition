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
<%    String title = "";
      String fname = "";
      String lname = "";
      String email = "";
      String gender = "";
      String dob = "";
      String designation = "";
      String phoneno = "";
      String mobileno = "";
      String phnNo = "";
      String mobileNo = "";
 
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
    
String title1 = item.getFieldName();
String value = item.getString();

String fname1 = item.getFieldName();
String value1 = item.getString();

String lname1 = item.getFieldName();
String value2 = item.getString();

String email1 = item.getFieldName();
String value3 = item.getString();

String gender1 = item.getFieldName();
String value4 = item.getString();

String dob1 = item.getFieldName();
String value5 = item.getString();

String designation1 = item.getFieldName();
String value6 = item.getString();

String phoneno1 = item.getFieldName();
String value7 = item.getString();

String mobileno1 = item.getFieldName();
String value8 = item.getString();

String phnNo1 = item.getFieldName();
String value9 = item.getString();

String mobileNo1 = item.getFieldName();
String value10 = item.getString();


if (title1.equals("title")) {
title = value;
count1 = 1;
}

if (fname1.equals("fname")) {
fname = value1;
count1 = 1;
}

if (lname1.equals("lname")) {
lname = value2;
count1 = 1;
}


if (email1.equals("email")) {
email = value3;
count1 = 1;
}

if (gender1.equals("gender")) {
gender = value4;
count1 = 1;
}

if (dob1.equals("dob")) {
dob = value5;
count1 = 1;
}

if (designation1.equals("designation")) {
designation = value6;
count1 = 1;
}

if (phoneno1.equals("phoneno")) {
phoneno = value7;
count1 = 1;
}

if (mobileno1.equals("mobileno")) {
mobileno = value8;
count1 = 1;
}

if (phnNo1.equals("phnNo")) {
phnNo = value9;
count1 = 1;
}

if (mobileNo1.equals("mobileNo")) {
mobileNo = value10;
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
     
      String fileName1=(String)ss.getAttribute("fileName");
      out.print(fileName1);
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      connection = DriverManager.getConnection(connectionURL, "root", "12345");
      psmnt = connection.prepareStatement("insert into media(link,type) values('"+fileName1+"',?)");
        psmnt.setString(1, "");
        psmnt.executeUpdate();

 
    Connection con5;
    con5=dbConnection.getConnection();
    Statement stat5=con5.createStatement();
    ResultSet rs5=stat5.executeQuery("select * from media where link='"+fileName1+"'");

     if(!rs5.next())
    {

    }
     else

    { 
         String logoMediaID=rs5.getString(1);
            ss.setAttribute("contactPersonPhotoId",logoMediaID);
    }

 
 
 
 String contactPersonPhotoId1=(String)ss.getAttribute("contactPersonPhotoId");
 out.print(contactPersonPhotoId1);
 
 
  Connection con;
  con=dbConnection.getConnection();
                // Inserting data into ownerSocialMedia            
              PreparedStatement ps=con.prepareStatement("insert into ownerContactPerson(title,firstName,lastName,photoMediaId,gender,dateOfBirth,degination,phoneNo,mobileNo,email,createdBy,modifiedBy,primCountryCodeId,secCountryCodeId)values(?,?,?,(select id from media where id=?),?,?,?,?,?,?,(select id from owner where id='"+idd+"'),(select id from owner where id='"+idd+"'),(select id from country where id=?),(select id from country where id=?))");
              ps.setString(1, title);
              ps.setString(2, fname);
              ps.setString(3, lname);
              ps.setString(4, contactPersonPhotoId1);
              ps.setString(5, gender); 
              ps.setString(6, dob);
              ps.setString(7, designation);
              ps.setString(8, phoneno); 
              ps.setString(9, mobileno); 
              ps.setString(10, email); 
              ps.setString(11, phnNo); 
              ps.setString(12, mobileNo); 
              ps.executeUpdate();
                
               response.sendRedirect("/Exhibition/html/ownerProfile.jsp"); 
}
catch(Exception e){
    
         out.println("error"+e.toString());
        }


}





%>


<%


%>