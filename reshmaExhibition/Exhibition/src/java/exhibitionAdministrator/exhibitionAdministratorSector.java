package exhibitionAdministrator;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class exhibitionAdministratorSector extends HttpServlet {
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
              // value fetch from textbox of exhibitionAdministratorSector.jsp file
              String sectorName=request.getParameter("SN");
              String description=request.getParameter("ds");
              Connection con;
              con=exhibitionAdministratorOneTimeConnection.getConnection(); 
              String val = "insert into exhibitionSector(sectorName,sectorMediaId,description,createdBy,modifiedBy)  values (?,(select id from media where id=1),?,(select id from exhibitionAdmin where id=3),(select id from exhibitionAdmin where id=3))" ;
              // data inserted in exhibitionSector table
              PreparedStatement ps = con.prepareStatement(val);  
               ps.setString(1, sectorName);
               ps.setString(2, description);
               int n=  ps.executeUpdate(); 
                  if(n>0)
                  {
                        out.print("ok");
                  }
                  else
                  {
                        out.print("error");
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
