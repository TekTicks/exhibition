<%-- 
    Document   : employee_upload_profile_image
    Created on : Mar 3, 2016, 12:08:24 PM
    Author     : Admin
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="exhibitionAdministrator.exhibitionAdministratorOneTimeConnection"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
   <%@ page import="java.util.Iterator" %>
   <%@ page import="java.io.File" %>
   <%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
   <%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
   <%@ page import="org.apache.commons.fileupload.*"%>
 
   <%@ page import="javax.servlet.http.HttpSession" %>
    <%    
  HttpSession imageSession=request.getSession(false);
              File f1= (File)imageSession.getAttribute("imageLocation");  
              out.print(f1);
      
  try {
Connection con;
 con=exhibitionAdministratorOneTimeConnection.getConnection();    
Statement st=con.createStatement();

ResultSet rs=st.executeQuery("select * from media where link='"+f1+"'");
   int c=0;
   while(rs.next())
   {
       c++;
       String n=rs.getString(1);
       out.println(n);
   }
 
  }
  catch(Exception e)
  {
      out.print("error" +e);
  }
    %>