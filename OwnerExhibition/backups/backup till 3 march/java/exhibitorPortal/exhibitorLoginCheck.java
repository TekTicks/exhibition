package exhibitorPortal;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ownerPortal.dbConnection;
public class exhibitorLoginCheck extends HttpServlet 
{
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
        {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            try
            { 
                HttpSession ss1=request.getSession(true);
                String uname=request.getParameter("un");
                String pass=request.getParameter("pw");
                // one time Database connection
                Connection con;
                con=dbConnection.getConnection();
                Statement stat=con.createStatement();
                ResultSet rs=stat.executeQuery("select * from exhibitor  where username='"+uname+"' or password='"+pass+"'");
                int count=0;
                while(rs.next())
                {
                   //set session for username,password and id of exhibitor
                    ss1.setAttribute("username",rs.getString("username"));
                    ss1.setAttribute("password",rs.getString("password"));
                    ss1.setAttribute("exhibitorId",rs.getString("id"));
                    count++;
                }
                    if(count>0)
                    {
                        if( !uname.equals(ss1.getAttribute("username")))
                            {
                             out.print("emailinvalid");        
                            }
                        else if(! pass.equals(ss1.getAttribute("password")))
                            {
                             out.print("passwordinvalid");        
                            }
                        else
                            {
                             out.print("valid");        
                            }

                    }
                    else
                        {        
                            out.print("ERROR");

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

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
       
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
