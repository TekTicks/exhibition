<%-- 
    Document   : formAction
    Created on : Mar 17, 2016, 4:47:30 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<HTML>
    <HEAD>
        <TITLE>Reading Checkboxes</TITLE>
    </HEAD>

    <BODY>
        <H1>Reading Checkboxes</H1>
        <%
             HttpSession r=request.getSession(true);
            String m= request.getParameter("check1");
            if(request.getParameter("check1") != null) {
                out.println("Checkbox 1 was checked.<BR>");
                m="1";
                r.setAttribute("m", m);
            }
            else {
                out.println("Checkbox 1 was not checked.<BR>");
            }

            if(request.getParameter("check2") != null) {
                out.println("Checkbox 2 was checked.<BR>");
            }
            else {
                out.println("Checkbox 2 was not checked.<BR>");
            }

            if(request.getParameter("check3") != null) {
                out.println("Checkbox 3 was checked.<BR>");
            }
            else {
                out.println("Checkbox 3 was not checked.<BR>");
            }
              response.sendRedirect("index.jsp");
        %>
    </BODY>
</HTML>

