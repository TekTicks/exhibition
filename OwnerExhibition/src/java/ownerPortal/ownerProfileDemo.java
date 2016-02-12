/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ownerPortal;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ownerProfileDemo extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();
         try
                           {
                            String companyname =request.getParameter("cname");
                            String primaryemail=request.getParameter("p_email");
                            String secemail =request.getParameter("s_email");
                            String primarycontact =request.getParameter("p_contact");
                            String seccontact =request.getParameter("s_contact");
                            String about =request.getParameter("about");
                            String website =request.getParameter("website");
                            String industry =request.getParameter("industry");
                            ownerPortal.Global.industry=industry;
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Exhibition","root","12345");
                            PreparedStatement ps=con.prepareStatement("insert into ownerProfile(name,logoMediaId,about,primEmail,secEmail,primContact,secContact,website,createdBy)values(?,(select id from media where id=1),?,?,?,?,?,?,(select id from owner where id=?))");
                                 ps.setString(1,companyname);
                                 ps.setString(2,about);
                                 ps.setString(3, primaryemail);
                                 ps.setString(4, secemail); 
                                 ps.setString(5, primarycontact);
                                 ps.setString(6, seccontact);
                                 ps.setString(7, website); 
                                 ps.setString(8,ownerPortal.Global.ownerId);
                                 ps.executeUpdate();
                            PreparedStatement ps1=con.prepareStatement("insert into industry(industryName,createdBy,modifiedBy) values(?,?,?)");
                                 ps1.setString(1, industry);
                                 ps1.setInt(2,1);
                                 ps1.setInt(3,1);
                                 
                                 ps1.executeUpdate();
                                 response.sendRedirect("/Exhibition/html/ownerProfile.jsp"); 
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
