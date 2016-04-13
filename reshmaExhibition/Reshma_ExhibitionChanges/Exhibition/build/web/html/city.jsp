


<%@page import="ownerPortal.dbConnection"%>
<%@page import="java.sql.*"%>
<%
String state=request.getParameter("count"); 
 String buffer="<select class='full-width' data-init-plugin='select2' name='city'><option value='-1'>Select</option>";  
 try{
    Connection con;
  con=dbConnection.getConnection();
 Statement stmt = con.createStatement();  
 ResultSet rs = stmt.executeQuery("Select * from city where citytId='"+state+"' ");  
   while(rs.next()){
   buffer=buffer+"<option value='"+rs.getString(1)+"'>"+rs.getString(2)+"</option>";  
   }  
 buffer=buffer+"</select>";  
 response.getWriter().println(buffer); 
 }
 catch(Exception e){
     System.out.println(e);
 }
 %>