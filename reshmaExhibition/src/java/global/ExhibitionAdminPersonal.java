package global;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Admin
 */
public class ExhibitionAdminPersonal extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
          response.setContentType("text/html");
        PrintWriter out = response.getWriter();
       
                         String title=request.getParameter("title");
                            String firstName=request.getParameter("firstName");
                            String lastName=request.getParameter("lastName");
                             String gender=request.getParameter("gender");
                             String dateOfBirth=request.getParameter("dateOfBirth");
  
                             String level=request.getParameter("level");
                               String degination=request.getParameter("degination");
                               String phoneNo=request.getParameter("phoneNo");
                                String createdBy=request.getParameter("createdBy");
                                 String modifiedBy=request.getParameter("modifiedBy");
                                  try
        {
           
                           Class.forName("com.mysql.jdbc.Driver"); 
                           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exhibition","root","123"); 
                          
                        String query = "insert into exhibitionAdminContact(title,firstName,lastName,gender,dateOfBirth,level,degination,phoneNo,createdOn,modifiedOn,createdBy,modifiedBy,modifiedByFlag,photoMediaId)  values(?,?,?,?,?,?,?,?,?,?,(select id from exhibitionAdmin where id=1),(select id from exhibitionAdmin where id=1),(select id from roles where id =1),(select id from media where id=1))";
                                
                     PreparedStatement ps = con.prepareStatement(query);
                      
                      ps.setString(1, title);
                   ps.setString(2, firstName);
                     ps.setString(3, lastName);
                   ps.setString(4, gender);
                    ps.setString(5, dateOfBirth);
                   ps.setString(6, level);
                    ps.setString(7, degination);
                   ps.setString(8, phoneNo);
                    ps.setString(9, createdBy);
                   ps.setString(10, modifiedBy);
                     
                   int n=  ps.executeUpdate(); 
        
                  if(n>0)
                  {
                        out.println("<script type=\"text/JavaScript\">");
                out.println("alert(\"data inserted successfully..\")");
                out.println("</script>");
                  }
                  else
                  {
                        out.println("<script type=\"text/JavaScript\">");
                out.println("alert(\"Insertion Failed\")");
                out.println("</script>");
                  }
      
           con.close();
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
