<%-- 
    Document   : trysql
    Created on : Jan 28, 2016, 3:52:22 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
         <%@ page import=" java.util.Arrays.* "%>
        <%@page import="java.awt.Button"%>
        <%@page import="java.sql.DriverManager"%>
        <%@ page import="java.sql.*"%>
        <%@ page import="javax.sql.*"%>
        <%
         try
            {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exhibitionproject","root","123");
            
                
                if(!con.isClosed())
                {
                     out.println("done");
                }
            else
                {
                      out.println("error");
                }
               
           
                  con.close();
            
            }
            catch(Exception e)
            {
                out.println(e);
            }
           
            %>
    </body>
</html>
