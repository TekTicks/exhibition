<%-- 
    Document   : profilePageContact
    Created on : Jan 29, 2016, 3:28:03 PM
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
                
                  
             String title=request.getParameter("title");
             
                   String firstName=request.getParameter("firstName");
                     String lastName=request.getParameter("lastName");
                   String gender=request.getParameter("gender");
                     String dateOfBirth=request.getParameter("dateOfBirth");
                  String level=request.getParameter("level");
                 String degination=request.getParameter("degination");
                    String phoneNo=request.getParameter("phoneNo");
        
             Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exhibition","root","123");
              
        String val = "insert into exhibitionAdminContact(title,firstName,lastName,gender,dateOfBirth,level,degination,phoneNo,createdBy,modifiedBy,modifiedByFlag,photoMediaId)  values (?, ?, ? , ?, ? , ? , ?, ?,(select id from exhibitionAdmin where id=2),(select id from exhibitionAdmin where id=1),(select id from roles),(select id from media))" ;
                PreparedStatement ps = con.prepareStatement(val);
                 
                   
                 ps.setString(1, title);
                   ps.setString(2, firstName);
                   ps.setString(3, lastName);
                   ps.setString(4,gender);
                   ps.setString(5, dateOfBirth);
                   ps.setString(6, level);
                 ps.setString(7, degination);
                  ps.setString(8,phoneNo);
                  int n=  ps.executeUpdate(); 
        
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

