<%-- 
    Document   : exhibitionTeamInsertDb
    Created on : Jan 29, 2016, 5:05:35 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

  <%@ page import="java.sql.*"%>
        <%@ page import="javax.sql.*"%>
        <%@ page import="java.sql.DriverManager;" %>
        <%
         try
            {
                
                  
             String tagline=request.getParameter("tagline");
           String title=request.getParameter("title");
            String firstName=request.getParameter("firstName");
           String lastName=request.getParameter("lastName");
            String gender=request.getParameter("gender");
            String dateOfBirth=request.getParameter("dateOfBirth");
           String degination=request.getParameter("degination");
           String phoneNo=request.getParameter("phoneNo");
           String mobileNo=request.getParameter("mobileNo");
           String email=request.getParameter("email");
           String modifiedBy=request.getParameter("modifiedBy");
                     
             Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exhibition","root","123");
              
        String val = "insert into exhibitionTeam(tagline,title,firstName,lastName,gender,dateOfBirth,degination,phoneNo,mobileNo,email,createdBy,modifiedBy,modifiedByFlag)  values (?,?,?,?,?,?,?,?,?,?,(select id from exhibitionAdmin where id=1),?,(select id from roles))" ;
                PreparedStatement ps = con.prepareStatement(val);
                 
                   
                 ps.setString(1, tagline);
                   ps.setString(2, title);
                     ps.setString(3, firstName);
                   ps.setString(4, lastName);
                     ps.setString(5,gender);
                   ps.setString(6, dateOfBirth);
                     ps.setString(7, degination);
                   ps.setString(8, phoneNo);
                    ps.setString(9, mobileNo);
                     ps.setString(10, email);
                      ps.setString(11, modifiedBy);
                  
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

