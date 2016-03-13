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
public class exhibitionAdminRegister extends HttpServlet 
{
          protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
          {
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                try
        {
           
            String userName=request.getParameter("uname");
            String password=request.getParameter("pass");
            String emailId=request.getParameter("emailId");
            String phoneNo=request.getParameter("phoneNo");
             String countryId=request.getParameter("countryId");

            //One time database connection  
            Connection con;
            con=exhibitionAdministratorOneTimeConnection.getConnection();
            PreparedStatement ps=con.prepareStatement("insert into exhibitionAdmin(exhibitionId,mobileNo,email,userName,password,level,countryId,createdBy,modifiedBy,modifiedByFlag) values((select id from exhibition where id=1),?,?,?,?,1,?,(select id from owner where id=1),(select id from owner where id=1),(select id from roles where id=1))");
            //ps.setString(1,exhibitionName );
            ps.setString(1,phoneNo );
            ps.setString(2,emailId );
            ps.setString(3,userName );
            ps.setString(4, password);
            ps.setString(5, countryId);
            ps.executeUpdate();

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