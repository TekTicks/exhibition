<% response.setHeader("Cache-Control", "no-cache"); 
response.setHeader("Cache-Control", "no-store"); 
response.setDateHeader("Expires", 0); 
response.setHeader("Pragma", "no-cache");%>
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
      String t1 = "";
      String fn = "";
      String ln = "";
      String dateOfBirth = "";
      String le = "";
      String degination = "";
      String contactNo = "";
     String  contactCountryId="";
    
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

String title = item.getFieldName(); 
String value1 = item.getString();    
    
String firstName = item.getFieldName();
String value2 = item.getString();

String lastName = item.getFieldName();
String value3 = item.getString();

String dob = item.getFieldName();
String value4 = item.getString();

String level = item.getFieldName();
String value5 = item.getString();

String deg= item.getFieldName();
String value6 = item.getString();

String contno = item.getFieldName();
String value7 = item.getString();

String cci = item.getFieldName();
String value8 = item.getString();



if (title.equals("t1")) {
t1 = value1;
count1 = 1;
}

if (firstName.equals("fn")) {
fn = value2;
count1 = 1;
}

if (lastName.equals("ln")) {
ln = value3;
count1 = 1;
}

if (dob.equals("dateOfBirth")) {
dateOfBirth = value4;
count1 = 1;
}

if (level.equals("le")) {
le = value5;
count1 = 1;
}

if (deg.equals("degination")) {
degination = value6;
count1 = 1;
}

if (contno.equals("contactNo")) {
contactNo = value7;
count1 = 1;
}

if (cci.equals("contactCountryId")) {
contactCountryId = value8;
count1 = 1;
}
} else {
try {
String itemName = item.getName();
File savedFile = new File("C:/Users/Admin/Documents/NetBeansProjects/Exhibition Project Main/Exhibition/web/html/images/" + itemName);
item.write(savedFile);
if (count1 == 1) {
HttpSession ss=request.getSession();
ss.setAttribute("fileName",itemName);   
out.print("My date" +contactNo);


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
      
       // HttpSession ss=request.getSession();
      String fileName=(String)ss.getAttribute("fileName");
     
     // Class.forName("com.mysql.jdbc.Driver").newInstance();
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
 String val="update exhibitionAdminContact set title='"+t1+"' , firstName='"+fn+"', lastName='"+ln+"',dateOfBirth='"+dateOfBirth+"' , level='"+le+"',degination='"+degination+"',phoneNo='"+contactNo+"',photoMediaId='"+iddsf+"',countryId='"+contactCountryId+"' where id='"+idValid+"' ";
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
                          response.sendRedirect("/Exhibition/html/exhibitionAdministratorProfilePage.jsp");
}
catch(Exception e){
    
         out.println("error"+e.toString());
        }


}





%>
