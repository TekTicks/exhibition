<%@page import="org.apache.commons.io.FilenameUtils"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@ page import="java.io.*,java.sql.*,java.util.zip.*" %>
<%
String saveFile="";
String contentType = request.getContentType();
if((contentType != null)&&(contentType.indexOf("multipart/form-data") >= 0)){
DataInputStream in = new DataInputStream(request.getInputStream());
int formDataLength = request.getContentLength();
byte dataBytes[] = new byte[formDataLength];
int byteRead = 0;
int totalBytesRead = 0;
while(totalBytesRead < formDataLength){
byteRead = in.read(dataBytes, totalBytesRead,formDataLength);
totalBytesRead += byteRead;
}
String file = new String(dataBytes);
saveFile = file.substring(file.indexOf("filename=\"") + 10);
saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1,saveFile.indexOf("\""));
int lastIndex = contentType.lastIndexOf("=");
String boundary = contentType.substring(lastIndex + 1,contentType.length());
int pos;
pos = file.indexOf("filename=\"");
pos = file.indexOf("\n", pos) + 1;
pos = file.indexOf("\n", pos) + 1;
pos = file.indexOf("\n", pos) + 1;
int boundaryLocation = file.indexOf(boundary, pos) - 4;
int startPos = ((file.substring(0, pos)).getBytes()).length;
int endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;
File fff = new File("D:/pagal/Exhibition/web/html/"+saveFile);
FileOutputStream fileOut = new FileOutputStream(fff);
fileOut.write(dataBytes, startPos, (endPos - startPos));
fileOut.flush();
fileOut.close();
response.sendRedirect("/Exhibition/html/ownerProfileSocialMedia.jsp"); 
%>
<%
Connection connection = null;
String connectionURL = "jdbc:mysql://localhost:3306/Exhibition";
PreparedStatement psmnt = null;


HttpSession ss=request.getSession();
ss.setAttribute("fileName",saveFile);                            
                            
try{
Class.forName("com.mysql.jdbc.Driver").newInstance();
connection = DriverManager.getConnection(connectionURL, "root", "12345");
psmnt = connection.prepareStatement("insert into media(link,type) values('"+saveFile+"',?)");
//psmnt.setString(1, );
psmnt.setString(1, "");
int s = psmnt.executeUpdate();
if(s>0){
System.out.println("Uploaded successfully !");
}
else{
System.out.println("Error!");
}
}
catch(Exception e){
    
         out.println("error"+e.toString());
        }
}
%>