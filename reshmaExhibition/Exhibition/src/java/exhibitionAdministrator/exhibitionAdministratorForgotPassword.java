package exhibitionAdministrator;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class exhibitionAdministratorForgotPassword extends HttpServlet
{
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
        {
               response.setContentType("text/html");
               PrintWriter out = response.getWriter();
               try
               { 
                    // value fetch from textbox of exhibitionAdministratorForgotPassword.jsp file
                   
                    String password=request.getParameter("un"); 
                     out.print(password);
                    String cpassword=request.getParameter("pw");
                     out.print(cpassword);
                    HttpSession ss=request.getSession(false);
                    String mob = (String)ss.getAttribute("MN");  // value fetch from exhibitionAdministratorMobileNo.jsp file
                     out.print(mob);
                     Connection con;
                     con=exhibitionAdministratorOneTimeConnection.getConnection();
                    int m= password.length();
                    out.print(m);
                    int mn= cpassword.length();  
                     out.print(mn);
                    if  (!(password.equals(cpassword)) || (m < 6) || (mn < 6) )   //steps for mobile no validations
                    {
                        out.print("invalidPassword");
                    }
                    else
                    {
                        
                        String query = "update exhibitionAdmin set password ='"+password+"' where mobileNo='"+mob+"'";
                        // password is updated in exhibitionAdmin table
                        PreparedStatement ps = con.prepareStatement(query);   
                         int i =  ps.executeUpdate(); 
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
