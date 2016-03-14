package exhibitionAdministrator;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ownerAddAdministrator extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
         HttpSession idC=request.getSession(true);
        try
        {
              
            //retrieve ownerId from session
            HttpSession ss=request.getSession();
           
            //retrieve all values through session from ownerAdminCheck
            String userName=(String)ss.getAttribute("uname");
            String password=(String)ss.getAttribute("pass");
            String emailId=(String)ss.getAttribute("emailId");
            String phoneNo=(String)ss.getAttribute("phoneNo");
            
            String ccode=(String)ss.getAttribute("ccode1");
           
        
           
            
            //One time database connection  
            Connection con;
             con=exhibitionAdministratorOneTimeConnection.getConnection();
            Statement st=con.createStatement();
            
            String val="insert into exhibitionAdmin(exhibitionId,mobileNo,email,userName,password,level,createdBy,modifiedBy,modifiedByFlag,countryId) values((select id from exhibition where id=1),?,?,?,?,1,(select id from owner where id=1),(select id from owner where id=1),(select id from roles where id=1),(select id from country where id=?))";
            PreparedStatement ps=con.prepareStatement(val,Statement.RETURN_GENERATED_KEYS);
     
            ps.setString(1,phoneNo );
            ps.setString(2,emailId );
            ps.setString(3,userName );
            ps.setString(4, password);
            ps.setString(5, ccode);
            
            
             ps.executeUpdate();
           
                 ResultSet rs = ps.getGeneratedKeys();     
                  if(rs.next())
                         {
                            String idCopy= rs.getString(1);
                            idC.setAttribute("idCopy", idCopy);
                             out.print("generated key=" +idCopy);
                         }
                         //HttpSession idC=request.getSession(false);
                          Connection con6;
             con6=exhibitionAdministratorOneTimeConnection.getConnection();
                        String idL=(String)idC.getAttribute("idCopy");
                         String query="insert into exhibitionAdminContact(id,title,firstName,lastName,gender,dateOfBirth,level,degination,phoneNo,createdBy,modifiedBy,modifiedByFlag,photoMediaId,countryId)values('"+idL+"','','','','0',0,0,'','',0,0,0,0,0)";
                         PreparedStatement pt=con6.prepareStatement(query);
                         pt.executeUpdate();
                    
            //Redirected to ownerAdministrator page
         response.sendRedirect("/Exhibition/html/ownerAdministrator.jsp");
           }
        catch(Exception ee)
        {
            out.println("error"+ee);
            
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
