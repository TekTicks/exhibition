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
                 
                           String EMAIL=request.getParameter("email");
                           Class.forName("com.mysql.jdbc.Driver"); 
                           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Exhibition","root","12345"); 
                           Statement stat=con.createStatement();
                           ResultSet rs=stat.executeQuery("select * from ownerProfile where primEmail='"+EMAIL+"'");
                           int count=0;
                           while(rs.next())
                           {
                               count++;
                           }
                           if(count>0)
                           {
                                 out.print("valid");        
                           }
                           else
                           {        
                                 out.print("ERROR");
                              
                           }     
        }
        catch(Exception ee)
        {
           out.println("error"+ee.toString());
        }
                             
                            %>
            </body>
</html>
