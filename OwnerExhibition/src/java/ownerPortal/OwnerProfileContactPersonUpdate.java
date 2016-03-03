
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
import javax.servlet.http.HttpSession;


public class OwnerProfileContactPersonUpdate extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
          PrintWriter out = response.getWriter();
        try  {
                            
            HttpSession ss=request.getSession();
            String id=(String)ss.getAttribute("contactPersonId");
            String title =request.getParameter("title");;
            String fname =request.getParameter("fname");
            String lname =request.getParameter("lname");
            String email =request.getParameter("email");
            String gender =request.getParameter("gender");
            String dob =request.getParameter("dob");
            String designation =request.getParameter("designation");
            String phoneno =request.getParameter("phoneno");
            String mobileno =request.getParameter("mobileno");
            String phnNo =request.getParameter("phnNo");
            String mobNo =request.getParameter("mobNo");
            //One time database connection                 
            Connection con;
            con=dbConnection.getConnection();
            PreparedStatement ps=con.prepareStatement("update ownerContactPerson set title=?,firstName=?,lastName=?,gender=?,dateOfBirth=?,degination=?,phoneNo=?,mobileNo=?,email=?,primCountryCodeId=?,secCountryCodeId=? where id='"+id+"'");
                                 
            ps.setString(1,title);
            ps.setString(2, fname);
            ps.setString(3, lname);
            ps.setString(4, gender);
            ps.setString(5, dob);
            ps.setString(6, designation);
            ps.setString(7, phoneno);
            ps.setString(8, mobileno);
            ps.setString(9, email);
            ps.setString(10,phnNo);
            ps.setString(11,mobNo);
                               
            int n= ps.executeUpdate();
            if(n>0)
            {
                out.print("ok");
            }
            else
            {
                out.print("error");
            }
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
