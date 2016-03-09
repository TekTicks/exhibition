<%@page import="ownerPortal.dbConnection"%>
<%@page import="java.sql.*"%>
<%
 int parentID1=Integer.parseInt(request.getParameter("count1"));  
 out.print(parentID1);
 String buffer="<select name='state' onchange='showCity(this.value);'><option value='-1'>Select</option>";  
 try{
Connection con;
 con=dbConnection.getConnection();
 Statement stmt = con.createStatement();  
 ResultSet rs = stmt.executeQuery("Select * from city where stateId='"+parentID1+"' ");  
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
