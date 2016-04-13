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
<%    String cname = "";
     // String p_email = "";
      String s_email = "";
      String ccodePrimary = "";
      //String p_contact = "";
      String ccodeSecondary = "";
      String s_contact = "";
      String about = "";
      String website = "";
      String industry = "";
      
      
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



String sec_email = item.getFieldName();
String value2 = item.getString();

String countryCodePrimary = item.getFieldName();
String value3 = item.getString();

String primary_contact = item.getFieldName();
String value4 = item.getString();

String countryCodeSecondary = item.getFieldName();
String value5 = item.getString();

String sec_contact = item.getFieldName();
String value6 = item.getString();

String about1 = item.getFieldName();
String value7 = item.getString();

String website1 = item.getFieldName();
String value8 = item.getString();

String industry1 = item.getFieldName();
String value9 = item.getString();

if (name.equals("cname")) {
cname = value;
count1 = 1;
}



if (sec_email.equals("s_email")) {
s_email = value2;
count1 = 1;
}

if (countryCodePrimary.equals("ccodePrimary")) {
ccodePrimary = value3;
count1 = 1;
}
/*
if (primary_contact.equals("p_contact")) {
p_contact = value4;
count1 = 1;
}*/

if (countryCodeSecondary.equals("ccodeSecondary")) {
ccodeSecondary = value5;
count1 = 1;
}

if (sec_contact.equals("s_contact")) {
s_contact = value6;
count1 = 1;
}

if (about1.equals("about")) {
about = value7;
count1 = 1;
}

if (website1.equals("website")) {
website = value8;
count1 = 1;
}

if (industry1.equals("industry")) {
industry = value9;
count1 = 1;
}
} else {
try {
String itemName = item.getName();


File savedFile = new File("E:/exhibitionMain/web/html/images/" + itemName);
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

Connection con1;
con1=dbConnection.getConnection();
PreparedStatement psmnt = null;
try{
      HttpSession ss=request.getSession();
      String idd=(String)ss.getAttribute("ownerId");
      String fileName=(String)ss.getAttribute("fileName");
      out.print(fileName);
      psmnt = con1.prepareStatement("insert into media(link,type) values('"+fileName+"',?)");
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
                                 out.print(logoMediaID);
                            }
                           
 
 

 String iddsf=(String)ss.getAttribute("logoMediaID");
 if(iddsf==null)
 {
     iddsf="1";
 }
 else
 {
 Connection con;
 con=dbConnection.getConnection();
 PreparedStatement ps=con.prepareStatement("update ownerProfile a,ownerIndustry b set a.name=?,a.secEmail=?,a.secContact=?,a.secCountryCodeId=?,a.about=?, a.website=?,b.industryId=?,logoMediaId=? where a.createdBy='"+idd+"' ");
                                 
                            ps.setString(1, cname);
                           // ps.setString(2, p_email);
                            ps.setString(2, s_email);
                           // ps.setString(4, p_contact);
                            ps.setString(3, s_contact);
                            ps.setString(4, ccodeSecondary);
                            ps.setString(5, about);
                            ps.setString(6, website);
                            ps.setString(7, industry);
                            ps.setString(8,iddsf);
                            ps.executeUpdate();
                            response.sendRedirect("/Exhibition/html/ownerProfile.jsp");
}
}
catch(Exception e){
    
         out.println("error"+e.toString());
        }


}





%>
