/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package global;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class MobileNoVerify extends HttpServlet {

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
       // response.setContentType("text/html");
        PrintWriter out = response.getWriter();
            
             try
             {
                
                  String mobile=request.getParameter("un");
                 
                  out.println(mobile);
                 
               Class.forName("com.mysql.jdbc.Driver"); 
                           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exhibition","root","123"); 
                           Statement stat=con.createStatement();
                          
                           ResultSet rs=stat.executeQuery("select * from exhibitionAdmin where mobileNo='"+mobile+"'");
                                
                      int count=0;
                           
                           while(rs.next())
                           {
                               String mob=rs.getString("mobileNo");
                               Global.mob=mob;
                           count++;
                             
                           }
                           if(count>0)
                           {  
                               if(!mobile.equals(Global.mob))
                               {
                                    out.println("invalid mobile");
                                }
                               else
                               {
                                    HttpSession session = request.getSession(true);
                                 session.setAttribute("demoid", mobile);
                                
                               /*   ServletContext sc=getServletContext();
                               sc.setAttribute("demoid",mobileNo);
                         RequestDispatcher rsd = request.getRequestDispatcher("exhibitionAdministratorFogotPassword.jsp");
                                  rsd.forward(request,response);   */
                            
                           response.sendRedirect("/Exhibition/html/exhibitionAdministratorFogotPassword.jsp");
                               }
                           }
                           else
                           {
                                 out.println("ERROR");
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