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
public class exhibitionAdministratorSocialMediaEdit extends HttpServlet
{
          protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
          {
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                try
                {
                    // value fetch from exhibitionAdministratorSocialMedia.jsp 
                    HttpSession ss1=request.getSession(false);
                    String myex_id=(String)ss1.getAttribute("myex_id");
                    // value fetch from exhibitionAdministratorSocialMedia.jsp
                    out.print(myex_id);
                     String exhibitionId=request.getParameter("EI");
                    String link=request.getParameter("link");    
                    String url=request.getParameter("url");  
                    Connection con;
                    con=exhibitionAdministratorOneTimeConnection.getConnection();
                    String query = "update exhibitionSocialMedia set exhibitionId ='"+exhibitionId+"' , link ='"+link+"' , socialMediaId='"+url+"' where id='"+myex_id+"' ";
                    // data updated in exhibitionSocialMedia table
                    PreparedStatement ps=con.prepareStatement(query);
                    int rs= ps.executeUpdate();
                    if(rs !=0)
                    {
                         out.print("ok");   
                    }
                    else
                    {
                         out.print("wrong");
                    }       
               }
               catch(Exception e)
               {
                    out.print("error");
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