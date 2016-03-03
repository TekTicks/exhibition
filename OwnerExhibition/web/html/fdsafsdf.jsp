 <%@page import="java.util.Scanner"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 
<html>      
<head>
    <script data-require="jquery@*" data-semver="2.0.3" src="http://code.jquery.com/jquery-2.0.3.min.js"></script>
    <script data-require="bootstrap@*" data-semver="3.1.1" src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    <link data-require="bootstrap-css@3.1.1" data-semver="3.1.1" rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" />
    <link rel="stylesheet" href="style.css" />
    <script src="script.js"></script>
</head>
<body>
<div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
            
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">Confirm Delete</h4>
                </div>
            
                <div class="modal-body">
                    <p>You are about to delete one track, this procedure is irreversible.</p>
                    <p>Do you want to proceed?</p>
                    <p class="debug-url"></p>
                </div>
                
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-danger btn-ok">Delete</a>
                </div>
            </div>
        </div>
    </div>
                     <%@page import="javax.servlet.*" %>
                     <%@page import="java.io.*" %>
                     <%@page import="java.sql.*" %>
                     <%@page import="java.sql.DriverManager"%>
                     <%@page import="java.util.Scanner.*" %>
                     <%  
                         Class.forName("com.mysql.jdbc.Driver"); 
                         java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exhibition","root","12345"); 
                         Statement stat=con.createStatement();
                         ResultSet rs=stat.executeQuery("select * from owner");
                         
                     %>                          
                     <%
                         while(rs.next())
                         {
                             String cid=rs.getString("id");
                             String fname = rs.getString("username"); 
                     %>
                      <input type="text" size="50" value="<%=cid%><%=fname%>" placeholder="id">
                      <a data-href="/Exhibition/delete?id=<%=cid%>" data-toggle="modal" data-target="#confirm-delete">Delete record <%=cid%></a><br>  
                     <%
                         }
                     %>
                     


                     
<!--
    <button class="btn btn-default" data-href="/web/delete?id=54" data-toggle="modal" data-target="#confirm-delete">
        Delete record #54
    </button> <br>
<button class="btn btn-default" data-href="/delete.php?55" data-toggle="modal" data-target="#confirm-delete">
        Delete record #55
</button><br>
<button class="btn btn-default" data-href="/delete.php?56" data-toggle="modal" data-target="#confirm-delete">
        Delete record #56
</button><br>
    <button class="btn btn-default" data-href="/delete.php?57" data-toggle="modal" data-target="#confirm-delete">
        Delete record #57
    </button> <br>
    <button class="btn btn-default" data-href="/delete.php?558" data-toggle="modal" data-target="#confirm-delete">
        Delete record #558
    </button><br>
    <button class="btn btn-default" data-href="/delete.php?559" data-toggle="modal" data-target="#confirm-delete">
        Delete record #559
    </button><br>
    <button class="btn btn-default" data-href="/delete.php?550" data-toggle="modal" data-target="#confirm-delete">
        Delete record #550
    </button><br> 
    -->
   
  
 
</body>
</html>
