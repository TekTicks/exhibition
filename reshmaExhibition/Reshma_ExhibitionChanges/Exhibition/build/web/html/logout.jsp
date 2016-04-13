<%-- 
    Document   : middle
    Created on : Mar 28, 2016, 10:52:42 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>

<head>
<SCRIPT LANGUAGE="JavaScript">

function goNewWin() {

//***Get what is below onto one line***

window.open("/Exhibition/html/exhibitionAdministratorLogin.jsp",'TheNewpop','toolbar=1,location=1,directories=1,status=1,menubar=1,scrollbars=1,resizable=1'); 

//***Get what is above onto one line*** 

self.close();

}

</SCRIPT> 
</head>
<body onLoad="goNewWin()">
<A HREF="javascript:goNewWin()"></A>
</body>
</html>