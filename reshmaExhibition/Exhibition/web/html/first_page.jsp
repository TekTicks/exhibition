<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd"> 
<%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %> 
<html> 
    <head> 
        <title>Create table in mysql database using jsp</title>
    </head> 
    <body bgcolor="#ffffcc">
        <form action="" method="get">
            <TABLE style="background-color: #ECE5B6;" WIDTH="50%">
                
                <tr>
                    <td width="20%">Stream</td>
                    <td width="25%"><input type="radio" name="gender" 
                        value="male">Male</td>
                    <td width="30%"><input type="radio" name="gender" value="Female" 
					    checked>Female</td>
                   
                </tr>
                
               
				<tr><td></td><td></td>
				<td><input type="submit" name="submit" value="submit"></td></tr>
                                
                                
            </TABLE>
            
              <h2><p>Welcome <%=request.getParameter("name")%>...<br></p></h2>
   		<TABLE style="background-color: #ECE5B6;" WIDTH="30%">
              <tr width="100%">
                             <tr>
                    <td width="50%">Stream</td>
                    <td width="50%"><%=request.getParameter("gender")%></td>
                </tr>
              
                
				<tr><td></td><td align="right">
			  <A HREF="first_page.jsp">
					<font size="4" color="blue">edit</font></A>
			</td>
	    </tr>
        </table>   
        </form>
    </body> 
</html>