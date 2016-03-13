
<%@page import="exhibitionAdministrator.exhibitionAdministratorOneTimeConnection"%>
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


<%    String exId = "";
      String title = "";
      String email = "";
      String mobileCountryId = "";
      String mobile = "";
      String contactCountryId = "";
      String contactNo = "";
      
      
    
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
String ei = item.getFieldName(); 
String value1 = item.getString();

String ttt = item.getFieldName();
String value2 = item.getString();

String emm = item.getFieldName();
String value3 = item.getString();

String mcid = item.getFieldName();
String value4 = item.getString();

String mbb = item.getFieldName();
String value5 = item.getString();

String ccid= item.getFieldName();
String value6 = item.getString();

String contno = item.getFieldName();
String value7 = item.getString();


if (ei.equals("exId")) {
exId = value1;
count1 = 1;
}

if (ttt.equals("title")) {
title = value2;
count1 = 1;
}

if (emm.equals("email")) {
email = value3;
count1 = 1;
}

if (mcid.equals("mobileCountryId")) {
mobileCountryId = value4;
count1 = 1;
}

if (mbb.equals("mobile")) {
mobile = value5;
count1 = 1;
}

if (ccid.equals("contactCountryId")) {
contactCountryId = value6;
count1 = 1;
}

if (contno.equals("contactNo")) {
contactNo = value7;
count1 = 1;
}
} else {
try {
String itemName = item.getName();
File savedFile = new File("C:/Users/Admin/Documents/NetBeansProjects/Exhibition/web/html/images/" + itemName);
item.write(savedFile);
out.println(savedFile);
if (count1 == 1) {
HttpSession ss=request.getSession();
ss.setAttribute("fileName",itemName);   
out.println(exId);
out.println(title);
out.println(email);
out.println(mobile);
out.println(contactNo);
out.println(mobileCountryId);
out.println(contactCountryId);

}
} catch (Exception e) {
e.printStackTrace();
}
}
}
Connection connection = null;
String connectionURL = "jdbc:mysql://localhost:3306/exhibition";
PreparedStatement psmnt = null;
try{
    
      HttpSession ss=request.getSession();
       String idValid=(String)ss.getAttribute("idValid");    
       out.print(idValid);
      String fileName=(String)ss.getAttribute("fileName");
      out.println(fileName);
     // Class.forName("com.mysql.jdbc.Driver").newInstance();
      Connection con;
       con=exhibitionAdministratorOneTimeConnection.getConnection();
psmnt = con.prepareStatement("insert into media(link,type) values('"+fileName+"',?)");
//psmnt.setString(1, );
psmnt.setString(1, "");
 psmnt.executeUpdate();
                         Connection con5;
                       con5=exhibitionAdministratorOneTimeConnection.getConnection();
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
 con2=exhibitionAdministratorOneTimeConnection.getConnection();

 PreparedStatement ps=con2.prepareStatement("insert into exhibitionOpportunity(exhibitionId,opportunityTitle,email,mobile,contactNo,mediaId,message,mobileCountryId,contactCountryId,createdBy,modifiedBy,modifiedByFlag)  values (?,?,?,?,?,'"+iddsf+"','opportunity_message',?,?,'"+idValid+"','"+idValid+"',(select id from roles where id=1))");
                                 
                            ps.setString(1, exId);
                            ps.setString(2, title);
                            ps.setString(3, email);
                            ps.setString(4, mobile);
                             ps.setString(5, contactNo);  
                              ps.setString(6, mobileCountryId);
                            ps.setString(7, contactCountryId);  
                           
                          int n=  ps.executeUpdate();
                         
                        if(n>0)
                        {
                            out.print("ok");
                        }
                        else
                        {
                             out.print("wrn");
                        }
                            response.sendRedirect("/Exhibition/html/exhibitionAdministratorOpportunityThankUPage.jsp");
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