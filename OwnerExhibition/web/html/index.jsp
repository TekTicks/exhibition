<%@page import="ownerPortal.dbConnection"%>
<%@page import="java.sql.*"%>
<html>
<head>  
<script language="javascript" type="text/javascript">  
var xmlHttp  
var xmlHttp
function showChild(int){
    if (typeof XMLHttpRequest != "undefined"){
        xmlHttp= new XMLHttpRequest();
    }
    else if (window.ActiveXObject){
        xmlHttp= new ActiveXObject("Microsoft.XMLHTTP");
    }
    if (xmlHttp==null){
        alert("Browser does not support XMLHTTP Request")
        return;
    } 
    var url="child.jsp";
    url +="?count=" +int;
    xmlHttp.onreadystatechange = childChange;
    xmlHttp.open("GET", url, true);
    xmlHttp.send(null);
}

function childChange(){   
    if (xmlHttp.readyState==4 || xmlHttp.readyState=="complete"){   
        document.getElementById("child").innerHTML=xmlHttp.responseText   
    }   
}
</script>  
</head>  
<body>  
<table border="1">
<tr><th>Category</th><th>Sub-Category</th> <th>city</th></tr>
<tr><td>
<select name='parent' class="select-cat">  
 <option value="none">Select</option>  
    <%
 Connection con5;
 con5=dbConnection.getConnection();
 Statement stmt = con5.createStatement();  
 ResultSet rs = stmt.executeQuery("Select * from country WHERE continentId IS NOT NULL");
 while(rs.next()){
     %>
      <option value="<%=rs.getInt(1)%>"><%=rs.getString(2)%></option>  
      <%
 }
     %>
</select> 
</td>
<td >
  <select name='state' class="select-sub-cat"> 
   </select> 
</td>

</tr>
</table>
</body> 
</html>























