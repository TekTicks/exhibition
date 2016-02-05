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
    
        <%@ page import="java.sql.*" %>
        <%@ page import="java.io.*" %>
        <%@ page import="java.sql.DriverManager;" %>

 
                        <%
                           try
                           {
                            String TITLE =request.getParameter("title1");
                            String FNAME =request.getParameter("fname");
                            String LNAME =request.getParameter("lname");
                            String GENDER=request.getParameter("optionyes");
                            String DOB =request.getParameter("dateofbirth");
                            String DESIGNATION =request.getParameter("designation");
                            String PHONENO =request.getParameter("telephone");
                            String MOBILENO =request.getParameter("mobileno");
                            String EMAIL =request.getParameter("email");
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Exhibition","root","12345");
                            PreparedStatement ps=con.prepareStatement("insert into ownerContactPerson(title,firstName,lastName,photoMediaId,gender,dateOfBirth,degination,phoneNo,mobileNo,email,createdBy,modifiedBy)values(?,?,?,(select id from media),?,?,?,?,?,?,(select id from owner),(select id from owner))");
                                 ps.setString(1, TITLE);
                                 ps.setString(2,FNAME);
                                 ps.setString(3, LNAME);
                                 ps.setString(4, GENDER); 
                                 ps.setString(5, DOB);
                                 ps.setString(6, DESIGNATION);
                                 ps.setString(7, PHONENO); 
                                 ps.setString(8, MOBILENO); 
                                 ps.setString(9, EMAIL); 
                                 ps.executeUpdate();
                                 
                                 out.print("<center>data saved</center>");
                           }
                           catch(Exception ee)
                           {
                               out.println("error"+ee);
                         
                           }
                             
                            %>
            </body>
</html>
