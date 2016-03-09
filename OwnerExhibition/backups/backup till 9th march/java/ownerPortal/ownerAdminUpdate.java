
package ownerPortal;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ownerAdminUpdate extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        try
        {   
            //Retrieve adminId from ownerAdminUpdate.jsp
            HttpSession ss=request.getSession();
            String idd=(String)ss.getAttribute("ownerAdminId"); 

            String emailId=request.getParameter("email");
            String phoneNo=request.getParameter("phone");
            String password=request.getParameter("password");
            String socailMedia=request.getParameter("exhibitionName");
            //One time database connection  
            Connection con;
            con=dbConnection.getConnection();
            PreparedStatement ps=con.prepareStatement("update exhibitionAdmin set email=?,mobileNo=?,password=? where id='"+idd+"'");
            ps.setString(1,emailId );
            ps.setString(2,phoneNo );
            ps.setString(3,password );
            ps.executeUpdate();
            Connection con1;
            con1=dbConnection.getConnection();
            PreparedStatement ps1=con1.prepareStatement("update exhibitionAdmin set exhibitionId=? where  id='"+idd+"' ");
            ps1.setString(1,socailMedia );
            ps1.executeUpdate();
            
            //Redirected to ownerAdministrator page
            response.sendRedirect("/Exhibition/html/ownerAdministrator.jsp");
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
