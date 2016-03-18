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
public class exhibitionAdministratorTeamMemberEdit extends HttpServlet
{
          protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
          {
                    response.setContentType("text/html;charset=UTF-8");
                    PrintWriter out = response.getWriter();
                try
                {
                    // data fetch from exhibitionAdministratorTeam.jsp
                    HttpSession ssy=request.getSession(false);
                    String rr=(String) ssy.getAttribute("myid");
                    //out.print(rr);
                    // values fetch from textbox of exhibitionAdministratorTeam.jsp
                    String firstName=request.getParameter("firstName");
                    String lastName=request.getParameter("lastName"); 
                    String tagline=request.getParameter("tagline");
                    String title=request.getParameter("title");
                    String gender=request.getParameter("optionyes");
                    out.print(gender);
                    String dateOfBirth=request.getParameter("dateOfBirth"); 
                    String degination=request.getParameter("degination");
                    String phoneNo=request.getParameter("phone"); 
                    String mobileNo=request.getParameter("mobileNo");
                    String email=request.getParameter("email");  
                       String mobileCountryId=request.getParameter("mobileCountryId");
                      // out.print(mobileCountryId);
                    String phoneCountryId=request.getParameter("phoneCountryId");  
                    Connection con;
                    con=exhibitionAdministratorOneTimeConnection.getConnection();
                    String query = "update exhibitionTeam set tagline ='"+tagline+"',title ='"+title+"',firstName ='"+firstName+"',lastName ='"+lastName+"',gender ='"+gender+"',dateOfBirth ='"+dateOfBirth+"',degination ='"+degination+"',phoneNo ='"+phoneNo+"',mobileNo ='"+mobileNo+"',email ='"+email+"',mobileCountrytId='"+mobileCountryId+"',phoneCountryId='"+phoneCountryId+"' where id='"+rr+"' ";
                    // data updated in exhibitionTeam table
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