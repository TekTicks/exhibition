/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ownerPortal;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OwnerProfileUpdate extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
          PrintWriter out = response.getWriter();
        try  {              
                            String cname =request.getParameter("cname");
                            String p_email =request.getParameter("p_email");
                            String s_email =request.getParameter("s_email");
                            String p_contact =request.getParameter("p_contact");
                            String s_contact =request.getParameter("s_contact");
                            String about =request.getParameter("about");
                            String website =request.getParameter("website");
                            String industry =request.getParameter("industry");
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Exhibition","root","12345");
                                 
                                PreparedStatement ps=con.prepareStatement("update ownerProfile,industry set name=?,primEmail=?,secEmail=?,primContact=?,secContact=?,about=?, website=?,industryName=? where name=? ");
                                 ps.setString(1, cname);
                                 ps.setString(2, p_email);
                                 ps.setString(3, s_email);
                                 ps.setString(4, p_contact);
                                 ps.setString(5, s_contact);
                                 ps.setString(6, about);
                                 ps.setString(7, website);
                                 ps.setString(8, industry);
                                 ps.setString(9,cname );
                                 ps.executeUpdate();
                                 
                                 
                                    
                       out.print("data updated");
//response.sendRedirect("/Exhibition/html/ownerProfile.jsp"); 
        }
                           catch(Exception ee)
                           {
                               out.println("error"+ee);
                         
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
