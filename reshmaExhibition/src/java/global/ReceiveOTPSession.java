/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package global;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
/**
 *
 * @author Admin
 */
public class ReceiveOTPSession extends HttpServlet {

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
         response.setContentType("text/html");
        PrintWriter out = response.getWriter();
            
             try
             {
                  String mobileNo=request.getParameter("mobileNo");
                 
               Class.forName("com.mysql.jdbc.Driver"); 
                           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exhibition","root","123"); 
                           Statement stat=con.createStatement();
                          
                           ResultSet rs=stat.executeQuery("select * from exhibitionAdmin where mobileNo='"+mobileNo+"'");
                                
                      int count=0;
                           
                           while(rs.next())
                           {
                      
                           count++;
                             
                           }
                           if(count>0)
                           {  
                               
                                 HttpSession session = request.getSession(true);
                                 session.setAttribute("demoid", mobileNo);
                                
                               /*   ServletContext sc=getServletContext();
                               sc.setAttribute("demoid",mobileNo);
                         RequestDispatcher rsd = request.getRequestDispatcher("exhibitionAdministratorFogotPassword.jsp");
                                  rsd.forward(request,response);   */
                           response.sendRedirect("/Exhibition/html/exhibitionAdministratorFogotPassword.jsp");
                               
                           }
                           else
                           {        
                                 out.print("ERROR");
                              response.sendRedirect("/Exhibition/html/receiveOTP.jsp");
                           }     
    }
     catch(Exception e)
     {
           out.println("errorsss" +e);
    
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
        processRequest(request, response);
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
