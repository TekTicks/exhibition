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

public class ckvInsert extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try
        {
            HttpSession ss=request.getSession();
            String emailId=(String)ss.getAttribute("email");
            String phoneNo=(String)ss.getAttribute("phone");
            String password=(String)ss.getAttribute("password");
            String cname=(String)ss.getAttribute("cname");
            String ccode=(String)ss.getAttribute("ccode");
            
            //One time database connection  
            Connection con;
            con=dbConnection.getConnection();
            PreparedStatement ps=con.prepareStatement("insert into owner(userName,password,createdBy,modifiedBy) values(?,?,?,?)");
         
            ps.setString(1,emailId);
            ps.setString(2,password);
            ps.setInt(3,1);
            ps.setInt(4,1);
            ps.executeUpdate();
             
            PreparedStatement ps1=con.prepareStatement("insert into ownerProfile(name,logoMediaId,about,primEmail,secEmail,primContact,secContact,website,createdBy,countryCodeId,secCountryCodeId) values(?,(select id from media where id=1),?,?,?,?,?,?,(select id from owner where userName=?),(select id from country where id=?),(select id from country where id=?))");
            ps1.setString(1,cname );
            ps1.setString(2,"");
            ps1.setString(3, emailId);
            ps1.setString(4,"");
            ps1.setString(5,phoneNo );
            ps1.setString(6,"");
            ps1.setString(7,"");
            ps1.setString(8, emailId);
            ps1.setString(9, ccode);
            ps1.setString(10,ccode);
            ps1.executeUpdate();
            
            response.sendRedirect("/Exhibition/html/ownerRegThankyou.jsp");
          
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
