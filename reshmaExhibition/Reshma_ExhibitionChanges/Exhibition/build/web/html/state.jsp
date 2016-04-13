<%@page import="ownerPortal.dbConnection"%>
<%@page import="java.sql.*"%>
<%
String country=request.getParameter("count");  
 String buffer="<select class='full-width'  name='state' onchange='showCity(this.value);' data-init-plugin='select2' ><option value='-1'>Select</option>";  
 try{
    Connection con2;
     con2=dbConnection.getConnection(); 
 Statement stmt2 = con2.createStatement();  
 ResultSet rs2 = stmt2.executeQuery("Select * from state where countrytid='"+country+"' ");  
   while(rs2.next()){
   buffer=buffer+"<option value='"+rs2.getString(1)+"'>"+rs2.getString(2)+"</option>";  
   }  
 buffer=buffer+"</select>";  
 response.getWriter().println(buffer); 
 }
 catch(Exception e){
     System.out.println(e);
 }

 %>