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

public class exhibitorEdit extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
          response.setContentType("text/html;charset=UTF-8");
          PrintWriter out = response.getWriter();
       try
         {
              HttpSession ss1=request.getSession(false);
              String myex_id=(String)ss1.getAttribute("myid");
              out.print(myex_id);
              String CN=request.getParameter("companyName"); 
              String UN=request.getParameter("userName");  
              String m= request.getParameter("exId");          
              Connection con;
              con=exhibitionAdministratorOneTimeConnection.getConnection();
              String query = "update exhibitor set companyName='"+CN+"',username ='"+UN+"',isMainExhibitor ='"+m+"' where id='"+myex_id+"' ";
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
