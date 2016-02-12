/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import sun.net.www.http.HttpClient;
//import org.json.JSONObject;

import java.sql.*;
       import javax.sql.*;
       import java.io.*;
       import org.json.JSONArray;
        import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
        import java.util.Collection;
import javax.json.stream.JsonParser;
        import org.apache.http.*;
        
      //import org.apache.http.client.HttpClient;
         import org.apache.http.client.methods.HttpPost;
       import org.apache.http.impl.client.DefaultHttpClient;
 //parser technique       
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;

import com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.RestAssured.given;
import com.jayway.restassured.matcher.RestAssuredMatchers.*;
import java.math.BigDecimal;
import java.net.URLConnection;
import java.nio.charset.Charset;
import javax.json.JsonObject;
import javax.json.stream.JsonLocation;
import org.hamcrest.Matchers.*;
import org.json.JSONException;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
 

/**
 *
 * @author Admin
 */
public class pass extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet pass</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet pass at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        new JavaHttpUrlConnectionReader();
        
  }
        
        
    }

    
    
    
    
    
    
    
    
    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
  /*  @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, JSONException {
       
        */
         
       // String main[]=new String[10];
     
	/*	
           try
           {
                
               
              
              DefaultHttpClient defaultClient = new DefaultHttpClient();
                HttpPost httpPostRequest = new HttpPost("http://localhost:8080/jsondem/pass.java");
                HttpResponse httpResponse = defaultClient.execute(httpPostRequest);

                BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent(),"UTF-8"));

                 String json = reader.readLine();

              JSONObject json1 = (JSONObject)new JSONParser().parse(json);
               
       
               */
               
           /* ArrayList<String> list = new ArrayList<String>();
            for(int i = 0; i < arr.length(); i++){
             list.add(arr.getJSONObject(i).getString("signUp"));
            }  */ 
               
               
            
           /*  ArrayList<String> list = new ArrayList<String>();     

                if (arr != null) { 
                int len = arr.length();
                for (int i=0;i<len;i++){ 
                 list.add(arr.get(i).toString());
                 
                }

                }  
                
                for(int i = 0; i < list.size(); i++) {   
    System.out.print(list.get(i));
}  
                
               /* main = list.toArray(new String[list.size()]);
              System.out.println(main[0]);
              System.out.println(main[1]);
              System.out.println(main[2]);
              System.out.println(main[3]);*/
            /*
                        }
           catch(Exception e)
           {
               e.printStackTrace();
           }
               
*/
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
                   
                 
              
        
   // }
   
    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
  /*  @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>*/

  
 
//}


