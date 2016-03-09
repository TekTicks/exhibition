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
      String p_email = "";
      String s_email = "";
      String ccodePrimary = "";
      String p_contact = "";
      String ccodeSecondary = "";
      String s_contact = "";
      String about = "";
      String website = "";
      
      
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



if (name.equals("cname")) {
cname = value;
count1 = 1;
}

if (addrs.equals("p_email")) {
p_email = value1;
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

if (primary_contact.equals("p_contact")) {
p_contact = value4;
count1 = 1;
}

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

} else {
try {
String itemName = item.getName();


File savedFile = new File("D:/pagal/Exhibition/web/html/" + itemName);
item.write(savedFile);
if (count1 == 1) {
HttpSession ss=request.getSession();
ss.setAttribute("fileName",itemName);   
/*out.println("<tr><td align='left'><b>Name:</td><td><b>" + cname);
out.println("<tr><td align='left'><b>Name:</td><td><b>" + p_email);
out.println("<tr><td align='left'><b>Name:</td><td><b>" + s_email);
out.println("<tr><td align='left'><b>Name:</td><td><b>" + ccodePrimary);
out.println("<tr><td align='left'><b>Name:</td><td><b>" + p_contact);
out.println("<tr><td align='left'><b>Name:</td><td><b>" + ccodeSecondary);
out.println("<tr><td align='left'><b>Name:</td><td><b>" + s_contact);
out.println("<tr><td align='left'><b>Name:</td><td><b>" + about);
out.println("<tr><td align='left'><b>Name:</td><td><b>" + website);
out.println("<tr><td align='left'><b>Name:</td><td><b>" + industry);*/
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
                                     ss.setAttribute("logoMediaID",logoMediaID);

                                 
                            }
                           
 
 
    out.print(ccodePrimary);
 String logoMediaId=(String)ss.getAttribute("logoMediaID");
 
 Connection con;
 con=dbConnection.getConnection();
 PreparedStatement ps=con.prepareStatement("update exhibitorProfile a,exhibitor b set b.companyName=?,a.primEmail=?,a.secEmail=?,a.primContact=?,a.secContact=?,a.primCountryCodeId=?,a.secCountryCodeId=?,a.about=?, a.website=?,a.logoMediaId=? where a.createdBy='"+1+"' ");
                                 
                            ps.setString(1, cname);
                           
                            ps.setString(2, p_email);
                            ps.setString(3, s_email);
                            ps.setString(4, p_contact);
                            ps.setString(5, s_contact);
                            ps.setString(6, ccodePrimary);
                          
                            ps.setString(7, ccodeSecondary);
                            ps.setString(8, about);
                            ps.setString(9, website);
                            ps.setString(10,logoMediaId);
                            ps.executeUpdate();
                            response.sendRedirect("/Exhibition/html/exhibitorProfile.jsp");
                            
}
catch(Exception e){
    
         out.println("error"+e.toString());
        }


}





%>

<%


%>