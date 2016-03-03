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

public class exhibitionAdministratorContactInformationFirstTimeUse extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
          response.setContentType("text/html;charset=UTF-8");
          PrintWriter out = response.getWriter();
       try
            {
                // value fetch from textbox from exhibitionSector.jsp file
                 String title=request.getParameter("title");
                 String firstName=request.getParameter("firstName");  
                 String lastName=request.getParameter("lastName"); 
                 String dateOfBirth=request.getParameter("dateOfBirth");  
                 String level=request.getParameter("level");
                 String degination=request.getParameter("degination");  
                 String phoneNo=request.getParameter("phoneNo");
                Connection con;
                con=exhibitionAdministratorOneTimeConnection.getConnection();
                HttpSession ss=request.getSession(false);
                String idValid=(String)ss.getAttribute("idValid");   
                String val = "update exhibitionAdminContact set title='"+title+"',firstName='"+firstName+"',lastName='"+lastName+"',dateOfBirth='"+dateOfBirth+"',level='"+level+"',degination='"+degination+"',phoneNo='"+phoneNo+"' where id='"+idValid+"' ";
                // data inserted in exhibitionAdminContact table
                PreparedStatement ps = con.prepareStatement(val);  
              
                int n=  ps.executeUpdate(); 
                  if(n!=0)
                  {
                        out.print("ok");
                  }
                  else
                  {
                        out.print("wrn");
                  }
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
