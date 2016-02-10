<%-- 
    Document   : profilePageDb
    Created on : Jan 28, 2016, 5:02:15 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
      <%@ page import="java.sql.*"%>
        <%@ page import="javax.sql.*"%>
        <%@ page import="java.sql.DriverManager;" %>
        <%
         try
            {
                
                  
             String mobileNo=request.getParameter("mobileNo");
             if(mobileNo==null)
              mobileNo="";
                   String email=request.getParameter("email");
                     String userName=request.getParameter("userName");
                   String password=request.getParameter("password");
                  String level=request.getParameter("level");
                 String modifiedBy=request.getParameter("modifiedBy");
                  
        
             Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exhibition","root","123");
              
        String val = "insert into exhibitionAdmin(exhibitionId,mobileNo,email,userName,password,level,createdBy,modifiedBy,modifiedByFlag)  values ((select id from exhibition), ?, ?, ? , ?, ?,(select id from owner),?,(select id from roles))" ;
                PreparedStatement ps = con.prepareStatement(val);
                 
                   
                 
                   ps.setString(1, mobileNo);
                   ps.setString(2, email);
                   ps.setString(3,userName);
                   ps.setString(4, password);
                   ps.setString(5, level);
                 ps.setString(6, modifiedBy);
                 int n =  ps.executeUpdate(); 
       
                       if(n>0)
                  {
                        out.println("<script type=\"text/JavaScript\">");
                out.println("alert(\"data inserted successfully..\")");
                out.println("</script>");
                  }
                  else
                  {
                        out.println("<script type=\"text/JavaScript\">");
                out.println("alert(\"Insertion Failed\")");
                out.println("</script>");
                  }
      
           con.close();
            
            }
           catch(Exception e)
           {
               out.println("error" +e);
           }

            %>
    </body>
</html>
