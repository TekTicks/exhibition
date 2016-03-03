
package ownerPortal;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ownerAddExhibition", urlPatterns = {"/ownerAddExhibition"})
public class ownerAddExhibition extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();
        try  {
            //Retrive ownerId from session 
            HttpSession ss=request.getSession();
            String ownerId=(String)ss.getAttribute("ownerId");
            String exhibitionName =request.getParameter("exhibitionName");
            Connection con;
            con=dbConnection.getConnection();
            PreparedStatement ps=con.prepareStatement("insert into exhibition(name,tagline,location,logoMediaId,shortDescription,longDescription,startDate,endDate,address1,address2,pincode,cityId,maplink,website,createdBy,modifiedBy,modifiedByFlag) values(?,'','',1,'','','07-04-02','05-04-02','','','',1,'','',(select id from owner where id='"+ownerId+"'),(select id from owner where id='"+ownerId+"'),1);");
            ps.setString(1,exhibitionName);
            int n=ps.executeUpdate();
           if(n>0)
           {
               out.print("ok");
           }
           else
           {
               out.print("error");
           }
        }
        catch(Exception e)
        {
            out.print(e);
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
