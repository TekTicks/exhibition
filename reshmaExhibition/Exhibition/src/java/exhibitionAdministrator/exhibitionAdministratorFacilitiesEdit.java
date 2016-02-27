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

public class exhibitionAdministratorFacilitiesEdit extends HttpServlet {
          protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
          response.setContentType("text/html;charset=UTF-8");
          PrintWriter out = response.getWriter();
       try
         {
              HttpSession obj=request.getSession(false);
              String myex_id=(String)obj.getAttribute("myid");   // value fetch from exhibitionAdministratorFacilities.jsp file 
              //values fetch from textbox of exhibitionAdministratorFacilities.jsp file
              String exId=request.getParameter("exId");  
              String title=request.getParameter("title");
              String des=request.getParameter("description"); 
              Connection con;
              con=exhibitionAdministratorOneTimeConnection.getConnection();
              String query = "update exhibitionFacilities set exhibitionId='"+exId+"',title ='"+title+"',description ='"+des+"'where id='"+myex_id+"' ";
              //data updated in exhibitionFacilities table
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
