package exhibitionAdministrator;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class exhibitionAdministratorSocialMediaDelete extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
          response.setContentType("text/html;charset=UTF-8");
          PrintWriter out = response.getWriter();
       try
          {
               // value fetch from exhibitionAdministratorSocialMedia table
               String myex_id=request.getParameter("myid");
               Connection con;
               con=exhibitionAdministratorOneTimeConnection.getConnection();
               Statement st=con.createStatement();
               st.executeUpdate("delete from exhibitionSocialMedia where id='"+myex_id+"'"); 
               //data deleted from exhibitionSocialMedia table
               response.sendRedirect("/Exhibition/html/exhibitionAdministratorSocialMedia.jsp");   // page is redirect to exhibitionAdministratorSocialMedia.jsp 
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
