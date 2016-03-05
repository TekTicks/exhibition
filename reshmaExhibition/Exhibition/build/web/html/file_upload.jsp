
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*,java.sql.*,java.io.*" %>
<%@page import="javax.servlet.*" %>
<%@page import="javax.servlet.http.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>File_upload</title>
        <link rel="stylesheet" href="style.css" />
        <script type="text/javascript" src="jquery.min.js"></script>
        <script type="text/javascript" src="jquery.form.js"></script>
    <script type="text/javascript" >

$(document).ready(function() 
{ 
$('#photoimg').change(function()	
{
$("#imageform").ajaxForm(
{
 target: '#preview'
}).submit();
});
}); 

   </script>
</head>
   
   
  <body>
      <table>
<tr><td><div><h2>Dynamic file uploading in JSP, without refreshing, using Ajax and Jquery</h2></div></td></tr>
<tr><td style="padding-bottom:30px;">by <a href="http://tuts.wtfdiary.com">Tuts-Wtfdiary</a></td></tr>

<tr><td>

<fieldset style="height:80px;width:400px;" color="#CCC">
<form id="imageform" method="post" enctype="multipart/form-data" action='ajax_file.jsp'>
<b>Upload image from your computer:</b> <input type="file" name="photoimg" id="photoimg" /><br><br/>
<div class="color_small">Please upload image(jpeg,jpg,gif,bmp,png) file only.</div>
</form>
</fieldset>
</td></tr>

<tr style="height:10px;"><td></td></tr>
<tr><td>
<div id='preview'></div>
</td></tr>
<tr style="height:10px;"><td></td></tr>
<tr>
<td>

</tr>
</table>
  </body>
</html>
