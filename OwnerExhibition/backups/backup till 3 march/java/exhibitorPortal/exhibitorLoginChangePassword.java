package exhibitorPortal;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ownerPortal.dbConnection;
public class exhibitorLoginChangePassword extends HttpServlet 
{

        protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
        {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            try
            {
                HttpSession ss=request.getSession();
                String userName=(String)ss.getAttribute("username");
                String  password=request.getParameter("newpassword");
                // One time Database Connection
                Connection con;
                con=dbConnection.getConnection();
                //updating Owner Table           
                String query = "update exhibitor set password ='"+password+"' where userName='"+userName+"'";
                PreparedStatement ps = con.prepareStatement(query);
                int i =  ps.executeUpdate();
                if(i>0)
                {
                    response.sendRedirect("/Exhibition/html/exhibitorLoginThankyou.jsp");
                } 
                else
                {
                    out.println("error");
                } 
            }
            catch(Exception ee)
            {
               out.println("error"+ee.toString());
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
