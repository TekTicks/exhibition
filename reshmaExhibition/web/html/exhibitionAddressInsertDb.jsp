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
           String title=request.getParameter("title");
           String address1=request.getParameter("address1");
           String address2=request.getParameter("address2");
           String landmark=request.getParameter("landmark");
           String pincode=request.getParameter("pincode");
            String mapLink=request.getParameter("mapLink");
           
                     
             Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exhibition","root","123");
              
        String val = "insert into exhibitionOfficeAddress(exhibitionId,title,address1,address2,landmark,pincode,cityId,mapLink,createdBy,modifiedBy,modifiedByFlag,photoMediaId)  values (?,?,?,?,?,?,(select id from city),?,(select id from exhibitionAdmin where id=2),(select id from exhibitionAdmin where id=2),(select id from roles),(select id from media))" ;
                PreparedStatement ps = con.prepareStatement(val);
                 
                   
                 ps.setString(1, exhibitionId);
                   ps.setString(2, title);
                    ps.setString(3, address1);
                   ps.setString(4,address2);
                     ps.setString(5,landmark);
                   ps.setString(6,pincode);
                    ps.setString(7,mapLink); 
                   
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

