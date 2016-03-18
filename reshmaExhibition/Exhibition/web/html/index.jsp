<%-- 
    Document   : index
    Created on : Mar 17, 2016, 4:46:22 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<HTML>
    <HEAD>
        <TITLE>Submitting Check Boxes</TITLE>
    </HEAD>
 
    <BODY>
        <H1>Submitting Check Boxes</H1>
        <FORM ACTION="formAction.jsp" METHOD="post">
             <INPUT TYPE="CHECKBOX" NAME="check1" VALUE="check1" >
             Checkbox 1
            <BR>
            <INPUT TYPE="CHECKBOX" NAME="check2" VALUE="check2">
            Checkbox 2
            <BR>
            <INPUT TYPE="CHECKBOX" NAME="check3" VALUE="check3" >
            Checkbox 3
            <BR>
            <INPUT TYPE="SUBMIT" VALUE="Submit">
            <%HttpSession r=request.getSession(false);%>
            <% String r1=(String)r.getAttribute("m");
                 out.print(r1);
             %>
            
            
        </FORM>
    </BODY>
</HTML>