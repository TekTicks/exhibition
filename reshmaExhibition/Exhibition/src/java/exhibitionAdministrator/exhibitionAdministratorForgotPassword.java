
package exhibitionAdministrator;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet; 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class exhibitionAdministratorForgotPassword extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html");
        PrintWriter out = response.getWriter();
            
             try
             { 
                 
                 String password=request.getParameter("un");
                 out.print(password);
                   String cpassword=request.getParameter("pw");
                   out.print(cpassword);
                    HttpSession ss=request.getSession(false);
                 String mob = (String)ss.getAttribute("MN");
                   out.print(mob);
                   
                  if( (!(password.equals(cpassword))) || !(password.length()<6) || !(cpassword.length()<6) )
               {
                    out.print("wrong");
               }
               else
                {
                        Connection con;
                        con=exhibitionAdministratorOneTimeConnection.getConnection();
                        
                       String query = "update exhibitionAdmin set password ='"+password+"' where mobileNo='"+mob+"'";
                      PreparedStatement ps = con.prepareStatement(query);
                       
                      // ps.setString(1,password);
                           
                     int i =  ps.executeUpdate(); 
                  out.print("ok");
                }
               
    }
     catch(Exception e)
     {
           out.print("errorsss" +e);
    
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
