<%-- 
    Document   : pass
    Created on : Jan 19, 2016, 6:38:28 PM
    Author     : DJ
--%>

<%@page import="oracle.jrockit.jfr.parser.Parser.main(String[])"%>
<%@page import="java.util.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sun.net.www.http.HttpClient"%>
<%@page import="org.json.JSONObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    
       
       <%@ page import="java.sql.*" %>
       <%@ page import="javax.sql.*" %>
       <%@ page import="java.io.*" %> 
       <%@ page import="org.json.JSONArray;"%>
        <%@ page import="java.lang.reflect.Type;"%>
        <%@ page import="java.util.Collection;"%>
        <%@ page import="org.apache.http.*;"%> 
        
      <%@ page import ="org.apache.http.client.HttpClient;"%>
         <%@ page import ="org.apache.http.client.methods.HttpPost;"%>
        <%@ page import ="org.apache.http.impl.client.DefaultHttpClient;"%>

       
       <% 
           String main[]=new String[10];
           try
           {
                DefaultHttpClient defaultClient = new DefaultHttpClient();
                HttpPost httpPostRequest = new HttpPost("http://localhost:8080/jsondem/pass.jsp");
                HttpResponse httpResponse = defaultClient.execute(httpPostRequest);

                BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent(),"UTF-8"));

                 String json = reader.readLine();

               JSONArray arr = new JSONArray(json);
               
               
               
               
           /* ArrayList<String> list = new ArrayList<String>();
            for(int i = 0; i < arr.length(); i++){
             list.add(arr.getJSONObject(i).getString("signUp"));
            }  */ 
               
               
               
             ArrayList<String> list = new ArrayList<String>();     

                if (arr != null) { 
                int len = arr.length();
                for (int i=0;i<len;i++){ 
                 list.add(arr.get(i).toString());
                }

                }  
                
                main = list.toArray(new String[list.size()]);
              out.print(main[0]);
              out.print(main[1]);
              out.print(main[2]);
              out.print(main[03]);
           }
           catch(Exception e)
           {
               out.println(e);
           }
               

    //JSONObject jsonObject = new JSONObject(json);
                
                     
                   /*  
                    int j=0;
                    String name =request.getParameter(main[0]);
                    String mobileno =request.getParameter(main[1]);
                    String email =request.getParameter(main[2]);
                    String password =request.getParameter(main[3]);
                    Class.forName("com.mysql.jdbc.Driver"); 
                    java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","admin"); 
                    PreparedStatement ps=con.prepareStatement("insert into comments values(?,?,?,?)");
                    //ps.setString(1,locationID);
                    ps.setString(1, name);
                    ps.setString(2,mobileno);
                    ps.setString(3, email);
                    ps.setString(4, password);
                //    ps.setString(5, city);
                    ps.executeUpdate();
                    out.println("<script>alert('Data saved Successfully');</Script>");*/
                   
                 
               %>
             
    
</html>
