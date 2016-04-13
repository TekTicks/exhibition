<%-- 
    Document   : ownerLogout
    Created on : Apr 10, 2016, 11:57:32 PM
    Author     : chandan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
session.setAttribute("ownerId", null);
session.invalidate();
response.sendRedirect("ownerLogin.jsp");
%>
    </body>
</html>
