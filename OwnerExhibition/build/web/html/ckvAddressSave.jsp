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
        <title>Owner Address</title>
    </head>
    <body>
        <%@ page import="java.sql.*" %>
        <%@ page import="java.io.*" %>
        <%@ page import="java.sql.DriverManager;" %>

 
                        <%
                           try
                       {
                           
                            String ADDRESS1 =request.getParameter("address1");
                            String ADDRESS2 =request.getParameter("address2");
                            String ZIPCODE =request.getParameter("zipcode");
                            String LANDMARK =request.getParameter("landmark");
                            String MAPLINK =request.getParameter("maplink");
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Exhibition","root","12345");
                            //PreparedStatement ps=con.prepareStatement("insert into ownerProfile values (?,?,?,?,?,?,?)");
                            PreparedStatement ps1=con.prepareStatement("insert into ownerAddress(address1,address2,landmark,pincode,cityId,mapLink,createdBy,modifiedBy)values(?,?,?,?,(select id from city),?,(select id from owner),(select id from owner))");
 
                            ps1.setString(1,ADDRESS1);
                            ps1.setString(2,ADDRESS2);
                            ps1.setString(3,ZIPCODE);
                            ps1.setString(4,LANDMARK);
                            ps1.setString(5,MAPLINK);
                            ps1.executeUpdate();
                            out.print("<center>data saved</center>");
                        }
                        catch(Exception ee)
                        {
                          response.redirectout.println("error"+ee);                       
                        }
                             
                        %>
    </body>
</html>
