<%
response.setHeader("Cache-Control", "no-cache"); //Forces caches to obtain a new copy of the page from the origin server
response.setHeader("Cache-Control", "no-store"); //Directs caches not to store the page under any circumstance
response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
response.setHeader("Pragma", "no-cache"); %>
<%-- 
    Document   : d
    Created on : Mar 31, 2016, 12:27:05 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<HTML>

<%
          
           session.invalidate();
%>
     <SCRIPT>
         function fdfsdf(){
    top.window.close();
     window.open("/Exhibition/html/exhibitionAdministratorLogin.jsp") ; //Give the name of login page here….
         }
     </SCRIPT>
     <body onload="fdfsdf()">
    
     </BODY>
</HTML>




           
         
    
  