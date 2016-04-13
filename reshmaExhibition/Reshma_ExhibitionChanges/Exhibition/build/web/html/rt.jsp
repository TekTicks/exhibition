<%-- 
    Document   : rt
    Created on : Mar 29, 2016, 4:35:37 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
<script language="javascript">

function open_a_window() 
{
   window.open("window_to_close.htm",'_self'); 
   window.close();
   return false;
}

</script>




The window closer:


<script language="javascript">

function quitBox(cmd) 
{      
    if (cmd=='quit')    
    {
       open(location, '_self').close();    
    }     
    return false;   
}

</script>
<input type="button" onclick="return open_a_window();" value="Open New Window/Tab" />
<input type="button" onclick="return quitBox('quit');" value="Close This Window/Tab" /> 
</html>
