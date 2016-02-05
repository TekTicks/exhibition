<%-- 
    Document   : demoJSP
    Created on : Jan 8, 2016, 10:54:24 AM
    Author     : chandan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Owner Profile</title>
    </head>
    <body bgcolor="#D8CEF6">
        <%@ page import="java.sql.*" %>
        <%@ page import="java.io.*" %>
        <%@ page import="java.sql.DriverManager;" %>

 
                        <%
                           try
                           {
                            String USERNAME =request.getParameter("username1");
                            String PASSWORD =request.getParameter("password");
                            String EMAIL =request.getParameter("email");
                            String CONTACTNO =request.getParameter("contactno");
                            String LEVEL =request.getParameter("level");

                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Exhibition","root","12345");
                            //PreparedStatement ps=con.prepareStatement("insert into ownerProfile values (?,?,?,?,?,?,?)");
                            PreparedStatement ps=con.prepareStatement("insert into exhibitionAdmin(exhibitionId,mobileNo,email,userName,password,level,createdBy,modifiedBy,modifiedByFlag) values((select id from exhibition),?,?,?,?,?,(select id from owner),(select id from owner),(select id from roles))");
                            //PreparedStatement ps1=con.prepareStatement("insert into ownerAddress(address1,address2,landmark,pincode,cityId,mapLink,createdBy,modifiedBy)values(?,?,?,?,(select id from city),?,(select id from owner),(select id from owner))");

                                 ps.setString(3, USERNAME);
                                 ps.setString(4,PASSWORD);
                                 ps.setString(2, EMAIL);
                                 ps.setString(1, CONTACTNO); 
                                 ps.setString(5, LEVEL); 
                                 
                                 out.print("<center>data saved</center>");
                           }
                           catch(Exception ee)
                           {
                               out.println("error"+ee);
                         
                           }
                             
                            %>
            </body>
</html>
