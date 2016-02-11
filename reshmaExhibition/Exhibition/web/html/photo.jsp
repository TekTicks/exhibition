<%-- 
    Document   : photo
    Created on : Feb 9, 2016, 6:00:39 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <script type="text/javascript" src="http://ajax.googleapis.com/
ajax/libs/jquery/1.5/jquery.min.js"></script>
<script type="text/javascript" src="jquery.form.js"></script>
<script type="text/javascript">
$(document).ready(function() 
{ 
$('#photoimg').live('change', function() 
{ 
$("#preview").html('');
$("#preview").html('<img src="loader.gif" alt="Uploading...."/>');
$("#imageform").ajaxForm(
{
target: '#preview'
}).submit();
});
}); 
</script>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <form id="imageform" method="post" enctype="multipart/form-data" action='ajaximage.php'>
Upload image <input type="file" name="photoimg" id="photoimg" />
</form>

<div id='preview'>
</div>
    </body>
</html>
