/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

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
try
{
    
    //String myUrl = "http://localhost:8080/jsondem/pass";
        
      //  myUrl = URLEncoder.encode(myUrl, "UTF-8");
        
        /*URL url = new URL(myUrl);
        
         HttpURLConnection connection = (HttpURLConnection) url.openConnection();
         connection.setRequestMethod("GET");
         
         connection.setDoOutput(true);
         
         connection.setReadTimeout(15*1000);
            connection.connect();*/
        
            
           // BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            
           // BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(myUrl).openStream(), "UTF-8"));
           
        
    
            /*DefaultHttpClient defaultClient = new DefaultHttpClient();
                HttpPost httpPostRequest = new HttpPost("http://localhost:8080/JSONClean/pass");
                HttpResponse httpResponse = defaultClient.execute(httpPostRequest);

                BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent(),"UTF-8"));

                 String json = reader.readLine();

              JSONObject json1 = (JSONObject)new JSONParser().parse(json);*/
           
            PrintWriter out = response.getWriter();
         String queryString = request.getQueryString();
            JSONObject json1 = new JSONObject(queryString);
        
                String name = json1.getString("name");
		String password = json1.getString("password");
                String mobileNo = json1.getString("mobileNo");
                String emailId = json1.getString("emailId");
        
                out.println("Name: " + name);
                out.println("password: " + password);
                out.println("mobile number: " + mobileNo);
                out.println("emailId: " + emailId);     
}
catch(Exception e)
{
    out.println(e);
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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
