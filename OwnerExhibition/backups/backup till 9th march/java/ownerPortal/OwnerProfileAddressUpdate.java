package ownerPortal;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OwnerProfileAddressUpdate extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
          PrintWriter out = response.getWriter();
        try  
           {
                  // Reterive id
                  HttpSession ss=request.getSession();
                  String id=(String)ss.getAttribute("ownerAddId");
                  
                  String address1 =request.getParameter("address1");;
                  String address2 =request.getParameter("address2");
                  String zipcode =request.getParameter("zipcode");
                  String landmark =request.getParameter("landmark");
                  String maplink =request.getParameter("maplink");
                   //One time database connection          
                  Connection con;
                  con=dbConnection.getConnection();
                  PreparedStatement ps=con.prepareStatement("update ownerAddress set address1=?,address2=?,landmark=?,pincode=?,mapLink=? where id='"+id+"'");
                  ps.setString(1,address1);
                  ps.setString(2, address2);
                  ps.setString(3, landmark);
                  ps.setString(4, zipcode);
                  ps.setString(5, maplink);
                  ps.executeUpdate();
                  response.sendRedirect("/Exhibition/html/ownerProfile.jsp"); 
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