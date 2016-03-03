<%-- 
    Document   : tableDemo
    Created on : Feb 10, 2016, 12:52:10 PM
    Author     : Admin
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            
            try
        {
            ArrayList<String> arr1 =new ArrayList<String>();
            ArrayList<String> arr2 =new ArrayList<String>();
            arr1.add("New Delhi");
            arr1.add("Maharashtra");
            arr1.add("Goa");
            arr2.add("Kabul");
            arr2.add("Karachi");
            arr2.add("Punjab");
            String valajax=request.getParameter("valajax");
            if(valajax.equals("v1"))
            {
                response.getWriter().write("<label><b>&nbsp &nbsp  Select state<b></label><br>");
                response.getWriter().write("&nbsp &nbsp<select  class=\"full-width\" data-init-plugin=\"select2\"> ");
                //response.getWriter().write("DropDown 1:<select> ");
                for(int i=0;i<arr1.size();i++)
                {
                     response.getWriter().write("<option>"+arr1.get(i)+"</option>");
                }
                
                response.getWriter().write("</select> ");
            }
             if(valajax.equals("v2"))
            {
                 response.getWriter().write("<label><b>&nbsp &nbsp Select state<b></label><br>");
                response.getWriter().write("&nbsp &nbsp<select  class=\"full-width\" data-init-plugin=\"select2\"> ");
                for(int i=0;i<arr2.size();i++)
                {
                     response.getWriter().write("<option>"+arr2.get(i)+"</option>");
                }
                
                response.getWriter().write("</select> ");
            }
         }
        catch(Exception ee)
        {
            out.println("error"+ee);
        }
            %>
            
    </body>
</html>
