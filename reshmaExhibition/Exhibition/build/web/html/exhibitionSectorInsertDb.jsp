<%-- 
    Document   : createModeratorInsertDb
    Created on : Jan 29, 2016, 4:19:59 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <%@ page import="java.sql.*"%>
        <%@ page import="javax.sql.*"%>
        <%@ page import="java.sql.DriverManager;" %>
        <%
         try
            {
                
                  
             String sectorName=request.getParameter("sectorName");
           String description=request.getParameter("description");
                     
             Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exhibition","root","123");
              
        String val = "insert into exhibitionSector(sectorName,sectorMediaId,description,createdBy,modifiedBy)  values (?,(select id from media),?,(select id from exhibitionAdmin where id=1),(select id from exhibitionAdmin where id=1))" ;
                PreparedStatement ps = con.prepareStatement(val);
                 
                   
                 ps.setString(1, sectorName);
                   ps.setString(2, description);
                  
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
