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

public class ownerProfileSocialMediaSave extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
         try
            {
                               
                String socialMedia=request.getParameter("socialmedia");
                String socialMediaLink=request.getParameter("socialmedialink");
                //Retrieve session from OwnerLoginCheck            
                HttpSession ss=request.getSession();
                String id=(String)ss.getAttribute("ownerId");
                //One time database connection            
                Connection con;
                con=dbConnection.getConnection();
                //  PreparedStatement ps=con.prepareStatement("insert into socialMedia(socialMedia,createdBy,modifiedBy)values(?,?,?)");
                //  ps.setString(1,socialMedia);
                //  ps.setInt(2,1);
                //  ps.setInt(3,1);
                //  ps.executeUpdate();
                
                // Inserting data into ownerSocialMedia            
                PreparedStatement ps1=con.prepareStatement("insert into ownerSocialMedia(socialMediaId,link,createdBy,modifiedBy,iconMediaId)values((select id from socialMedia where socialMedia=?),?,(select id from owner where id='"+id+"'),(select id from owner where id='"+id+"'),(select id from media where id=1))");
                ps1.setString(1,socialMedia);
                ps1.setString(2,socialMediaLink);
                ps1.executeUpdate();
                
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
