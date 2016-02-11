
package global;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class exhibitionSocialMediaDb extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();
       try
            {
                  
             String exhibitionId=request.getParameter("EI");
           String link=request.getParameter("link");
           
                     
             Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exhibition","root","123");
              
        String val = "insert into exhibitionSocialMedia(exhibitionId,socialMediaId,link,createdBy,modifiedBy,modifiedByFlag)  values (?,(select id from media where id=1),?,(select id from exhibitionAdmin where id=3),(select id from exhibitionAdmin where id=3),(select id from roles where id=1))" ;
                PreparedStatement ps = con.prepareStatement(val);
                 
                   
                 ps.setString(1, exhibitionId);
                   ps.setString(2, link);
                    
                   
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
