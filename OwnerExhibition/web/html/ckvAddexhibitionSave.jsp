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
                            String EXNAME =request.getParameter("exhibitionname");;
                            String TAGNAME =request.getParameter("tagname");
                            String LOCATION =request.getParameter("location");
                            String SHORTDESC =request.getParameter("s_desc");
                            String LONGDESC =request.getParameter("l_desc");
                            String STARTDATE =request.getParameter("startdate");
                            String ENDDATE =request.getParameter("enddate");
                            String ADDRESS1 =request.getParameter("address1");
                            String ADDRESS2 =request.getParameter("address2");
                            String WEBSITE =request.getParameter("website");
                            String PINCODE =request.getParameter("pincode");
                            String MAPLINK =request.getParameter("maplink");
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Exhibition","root","12345");
                            //PreparedStatement ps=con.prepareStatement("insert into ownerProfile values (?,?,?,?,?,?,?)");
                            PreparedStatement ps=con.prepareStatement("insert into exhibition(name,tagline,location,logoMediaId,shortDescription,longDescription,startDate,endDate,"
                                    + "address1,address2,pincode,cityId,maplink,website,createdBy,modifiedBy,modifiedByFlag)values(?,?,?,(select id from media),?,?,?,?,?,?,?,(select id from city),?,?,(select id from owner),(select id from owner),(select id from roles))");

                          

                                 ps.setString(1, EXNAME);
                                 ps.setString(2,TAGNAME);
                                 ps.setString(3, LOCATION);
                                 ps.setString(4, SHORTDESC); 
                                 ps.setString(5, LONGDESC);
                                 ps.setString(6, STARTDATE);
                                 ps.setString(7, ENDDATE); 
                                 ps.setString(8, ADDRESS1); 
                                 ps.setString(9, ADDRESS2); 
                                 ps.setString(12, WEBSITE); 
                                 ps.setString(10, PINCODE); 
                                 ps.setString(11, MAPLINK); 
                                 
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
