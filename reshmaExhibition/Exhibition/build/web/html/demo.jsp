<HTML>
    <HEAD>
        <TITLE>JSP page Counter</TITLE>
    </HEAD>

    <BODY>
        <H1>JSP page Counter</H1>
        <%
    

        Integer applicationCount = (Integer)application.getAttribute("applicationCount");
        if (applicationCount == null) {
            applicationCount = new Integer(1);
        } else {
            applicationCount= new Integer(applicationCount.intValue() + 1);
        }

        application.setAttribute("applicationCount", applicationCount);
        %>

        
        <BR>
        Visitors to this page so far <%=applicationCount%> (visitor).
    </BODY>
</HTML>  