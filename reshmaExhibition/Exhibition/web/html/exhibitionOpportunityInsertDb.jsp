<%-- 
    Document   : exhibitonSocialMediaInsertDb
    Created on : Jan 29, 2016, 5:41:00 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

  <%@ page import="java.sql.*"%>
        <%@ page import="javax.sql.*"%>
        <%@ page import="java.sql.DriverManager;" %>
        <%
         try
            {
                
                  
             String opportunityTitle=request.getParameter("opportunityTitle");
           String email=request.getParameter("email");
           String mobile=request.getParameter("mobile");
           String contactNo=request.getParameter("contactNo");
           String message=request.getParameter("message");
         
                     
             Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exhibition","root","123");
              
        String val = "insert into exhibitionOfficeAddress(exhibitionId,opportunityTitle,)  values (?,?,?,?,?,?,(select id from city),?,(select id from exhibitionAdmin where id=2),(select id from exhibitionAdmin where id=2),(select id from roles),(select id from media))" ;
                PreparedStatement ps = con.prepareStatement(val);
                 
                   
                 ps.setString(1,opportunityTitle);
                   ps.setString(2, email);
                    ps.setString(3, mobile);
                   ps.setString(4,contactNo);
                     ps.setString(5,message);
                  
                   
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

