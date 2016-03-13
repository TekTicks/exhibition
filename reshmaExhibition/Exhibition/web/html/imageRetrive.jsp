<%-- 
    Document   : imageRetrive
    Created on : Mar 12, 2016, 4:48:21 PM
    Author     : Admin
--%>

<%@page import="java.io.OutputStream"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="exhibitionAdministrator.exhibitionAdministratorOneTimeConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
             HttpSession obj=request.getSession(false);
             String media=(String)obj.getAttribute("mediaId");
        
 Connection con;
     con=exhibitionAdministratorOneTimeConnection.getConnection(); ;
ResultSet rs = null;
PreparedStatement pstmt = null;
OutputStream oImage;
try {
pstmt = con.prepareStatement("select link from media where id='"+media +"'");
rs = pstmt.executeQuery();
    if(rs.next()) {
        byte barray[] = rs.getBytes(1);
        response.setContentType("image/gif");
        oImage=response.getOutputStream();
        oImage.write(barray);
        oImage.flush();
        oImage.close();
    }
}
catch(Exception ex){
    //ex.printStackTrace();
}finally {
    try{
    if(con!=null)
       con.close();
    }catch(Exception ex){
       // ex.printStackTrace();
    }
}
        %>
    </body>
</html>
