
package exhibitionAdministrator;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class exhibitionAdministratorContactInformation extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try  {
             String tt=request.getParameter("tt");
              String fn=request.getParameter("fn");
              String ln =request.getParameter("ln");
            
              String dob=request.getParameter("dob");
                String le=request.getParameter("le");
              String dn=request.getParameter("dn");
                String pn=request.getParameter("pn");
             
                      Connection con;
                        con=exhibitionAdministratorOneTimeConnection.getConnection();
                         PreparedStatement pas=con.prepareStatement("insert into exhibitionAdminContact(title,firstName,lastName,gender,dateOfBirth,level,degination,phoneNo,createdBy,modifiedBy,modifiedByFlag,photoMediaId) values(?,?,?,(select id from media),?,?,?,?,(select id from exhibitionAdmin where id=3),(select id from exhibitionAdmin where id=3),(select id from roles where id=1),(select id from media where id=1))");
                           
                         pas.setString(1,tt);
                         pas.setString(2,fn);
                         pas.setString(3,ln);
                     
                         pas.setString(4,dob);
                         pas.setString(5,le);
                         pas.setString(6,dn);
                         pas.setString(7,pn);
                           
                         int n= pas.executeUpdate();
                         if(n>0)
                         {
                         out.println("okk"); 
                         }
                         else
                         {
                             out.print("wrong");
                         }
           
        }
           catch(Exception ee)
        {
           out.println("error"+ee.toString());
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
