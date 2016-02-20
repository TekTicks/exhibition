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
File fff = new File("C:/ckv/"+saveFile);
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


for (FileItem item : formItems) {
    if (item.isFormField()) {
        // Process regular form field (input type="text|radio|checkbox|etc", select, etc).
        String fieldname = item.getFieldName();
        String fieldvalue = item.getString();
        // ... (do your job here)
    } else {
        // Process form file field (input type="file").
        String fieldname = item.getFieldName();
        String filename = FilenameUtils.getName(item.getName());
        InputStream filecontent = item.getInputStream();
        // ... (do your job here)
    }
}


 String socialMedia=request.getParameter("socialmedia");
 String socialMediaLink=request.getParameter("socialmedialink");
 String photo=request.getParameter("file");
 HttpSession ss=request.getSession();
 String id=(String)ss.getAttribute("ownerId");
                            
                            
try{
Class.forName("com.mysql.jdbc.Driver").newInstance();
connection = DriverManager.getConnection(connectionURL, "root", "12345");
psmnt = connection.prepareStatement("insert into media(link,type) values(?,?)");
psmnt.setString(1, fff.getPath());
psmnt.setString(2, "");
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