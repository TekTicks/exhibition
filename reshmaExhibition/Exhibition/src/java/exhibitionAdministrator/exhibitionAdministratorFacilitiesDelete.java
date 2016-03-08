package exhibitionAdministrator;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class exhibitionAdministratorFacilitiesDelete extends HttpServlet 
{
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
        {
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                try
                {
                     HttpSession idDelete=request.getSession(false);
                   String idDel= (String)idDelete.getAttribute("myex_id");
                   out.print(idDel);
                     //value fetch from exhibitionAdministratorFacilities.jsp file
                    Connection con;
                    con=exhibitionAdministratorOneTimeConnection.getConnection();
                    Statement st=con.createStatement();
                    st.executeUpdate("delete from exhibitionFacilities where id='"+idDel+"'");      //data deleted from exhibitionFacilities table
                    response.sendRedirect("/Exhibition/html/exhibitionAdministratorFacilities.jsp");     //page redirected to exhibitionAministratorFacilities.jsp
                    con.close();
                }
                catch(Exception e)
                {
                    out.print("error" +e);
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
