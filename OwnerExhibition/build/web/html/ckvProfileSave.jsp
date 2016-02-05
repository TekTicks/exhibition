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
                            String NAME =request.getParameter("name");;
                            String PEMAIL =request.getParameter("p_email");
                            String SEMAIL =request.getParameter("s_email");
                            String ABOUT =request.getParameter("about");
                            String PCONTACT =request.getParameter("p_contact");
                            String SCONTACT =request.getParameter("s_contact");
                            String WEBSITE =request.getParameter("website");
                           
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Exhibition","root","12345");
                            //PreparedStatement ps=con.prepareStatement("insert into ownerProfile values (?,?,?,?,?,?,?)");
                            PreparedStatement ps=con.prepareStatement("insert into ownerProfile(logoMediaId,name,about,primEmail,secEmail,primContact,secContact,website,createdBy)values((select id from media),?,?,?,?,?,?,?,(select id from owner))");
                            //PreparedStatement ps1=con.prepareStatement("insert into ownerAddress(address1,address2,landmark,pincode,cityId,mapLink,createdBy,modifiedBy)values(?,?,?,?,(select id from city),?,(select id from owner),(select id from owner))");

                          

                                 ps.setString(1, NAME);
                                 ps.setString(2,PEMAIL);
                                 ps.setString(3, SEMAIL);
                                 ps.setString(4, ABOUT); 
                                 ps.setString(5, PCONTACT);
                                 ps.setString(6, SCONTACT);
                                 ps.setString(7, WEBSITE); 
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
