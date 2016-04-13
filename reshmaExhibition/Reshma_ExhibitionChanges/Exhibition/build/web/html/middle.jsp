<%-- 
    Document   : middle
    Created on : Mar 28, 2016, 10:52:42 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<script>
function closeMe()
{
var win = window.open("logout.jsp","_self"); /* url = "" or "about:blank"; target="_self" */
win.close();
}
</script>
</head>
<body>
<input type="button" name="CloseMe" value="Close Me" onclick="closeMe()" />
</body>
</html>