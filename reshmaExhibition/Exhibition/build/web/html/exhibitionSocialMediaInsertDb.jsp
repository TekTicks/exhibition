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
                
                  
             String exhibitionId=request.getParameter("exhibitionId");
           String link=request.getParameter("link");
           
                     
             Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exhibition","root","123");
              
        String val = "insert into exhibitionSocialMedia(exhibitionId,socialMediaId,link,createdBy,modifiedBy,modifiedByFlag)  values (?,(select id from media),?,(select id from exhibitionAdmin where id=2),(select id from exhibitionAdmin where id=2),(select id from roles))" ;
                PreparedStatement ps = con.prepareStatement(val);
                 
                   
                 ps.setString(1, exhibitionId);
                   ps.setString(2, link);
                    
                   
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

