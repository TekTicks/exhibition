<%-- 
    Document   : tableDemo
    Created on : Feb 10, 2016, 12:52:10 PM
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
        <table class="table table-hover demo-table-search" id="tableWithSearch">
                     <%@page import="java.io.*;" %>
                     <%@page import="java.sql.*;" %>
                     <%@page import="java.sql.DriverManager;" %>
                     <thead>
                        <tr><th>ID</th>
                        <th>UserName</th>
                        <th>Password</th>        
                        <th>FirstName</th>
                        <th>LastName</th>
                        <th>Email</th>
                        </tr>
                  </thead>
                  <tbody>
                    <%   
                         Class.forName("com.mysql.jdbc.Driver"); 
                           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Exhibition","root","12345"); 
                         Statement stat=con.createStatement();
                         ResultSet rs=stat.executeQuery("select * from ownerAddress");
                         int count=0;
                         while(rs.next())
                         {
                            count++;
                            out.println("<tr>");
                            out.println("<td class='v-align-middle semi-bold'><p>"+rs.getString(1)+"</p></td>");
                            out.println("<td><p> "+rs.getString(2)+"</p></td>");
                            out.println("<td><p> "+rs.getString(3)+"</p></td>");
                            out.println("<td><p> "+rs.getString(4)+"</p></td>");
                            out.println("<p><td> "+rs.getString(5)+"</p></td>");
                            out.println("<p><td> "+rs.getString(6)+"</p></td>");
                            /* out.println("<td><input type='radio' name='aproval' value='Yes'>Yes<input type='radio' name='aproval' value='No'>No</</td>");*/
                            out.println(" </tr>");
                        }
                   %>   
                   </tbody>
                </table>
    </body>
</html>
