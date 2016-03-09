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

public class ownerAddAdministrator extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        try
        {
            
            //retrieve ownerId from session
            HttpSession ss=request.getSession();
            String ownerId=(String)ss.getAttribute("ownerId");
            //retrieve all values through session from ownerAdminCheck
            String userName=(String)ss.getAttribute("uname");
            String password=(String)ss.getAttribute("pass");
            String emailId=(String)ss.getAttribute("emailId");
            String phoneNo=(String)ss.getAttribute("phoneNo");
            String exhibitionName=(String)ss.getAttribute("exhName"); 
            
            //One time database connection  
            Connection con;
            con=dbConnection.getConnection();
            PreparedStatement ps=con.prepareStatement("insert into exhibitionAdmin(exhibitionId,mobileNo,email,userName,password,level,createdBy,modifiedBy,modifiedByFlag) values((select id from exhibition where id=?),?,?,?,?,?,(select id from owner where id=?),(select id from owner where id=?),(select id from roles where id=1))");
            ps.setString(1,exhibitionName );
            ps.setString(2,phoneNo );
            ps.setString(3,emailId );
            ps.setString(4,userName );
            ps.setString(5, password);
            ps.setInt(6, 0);
            ps.setString(7, ownerId);
            ps.setString(8, ownerId);
            
            ps.executeUpdate();
          
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
