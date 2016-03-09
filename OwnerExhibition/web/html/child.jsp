<%@page import="ownerPortal.dbConnection"%>
<%@page import="java.sql.*"%>
<%
 int parentID=Integer.parseInt(request.getParameter("count"));  
 try{
Connection con;
 con=dbConnection.getConnection();
 Statement stmt = con.createStatement();  
 ResultSet rs = stmt.executeQuery("Select * from state where countrytId='"+parentID+"' ");  
   while(rs.next()){
       String id=rs.getString(1);
       %>
       <option value="<%=id%> "><%out.print(rs.getString(2));%></option>  
       <%
   }  
 
 }
 catch(Exception e){
     System.out.println(e);
 }

 %>
