<%@ include file="getcon.jsp"%>
<html>
<head>
<title>View Image Page</title>
</head>
<body>
<table width="100%" border="0">
<!-- main content -->
<%
ResultSet rs=null;
try
{
 
rs=st.executeQuery("select link from media");
 
while(rs.next())
{
%>
<table width="70%" height="160" border="1" align="center">
<tr>
<!-- Mention Directory where your images has been saved-->
 
<td><img src="UploadedFiles/<%=rs.getString("link") %>" width="115" height="128" /></td>
</tr>
</table>
<%
}
}
catch(Exception e)
{
out.print(""+e.getMessage());
}
%>
 
</table>
</body>
</html>
