package ownerPortal;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class OwnerLoginCheck extends HttpServlet 
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
                           //ResultSet rs=stat.executeQuery("select a.* from owner a where a.userName='"+uname+"' and a.password='"+pass+"'");
                           ResultSet rs=stat.executeQuery("select a.*,b.*,c.* from owner a,ownerProfile b,industry c where a.userName='"+uname+"' or a.password='"+pass+"'");
                           int count=0;
                           while(rs.next())
                           {
                               String un1=rs.getString("userName");
                                 ss1.setAttribute("username",un1);
                               String pw1=rs.getString("password");
                                 ss1.setAttribute("password",pw1);
                               String id=rs.getString(1);
                                 ss1.setAttribute("ownerId",id);
                               String cname=rs.getString("name");
                                 ss1.setAttribute("cname",cname);
                               String primEmail=rs.getString("primEmail");
                                 ss1.setAttribute("primEmail1",primEmail);
                               String secEmail=rs.getString("secEmail"); 
                                 ss1.setAttribute("secEmail1",secEmail);
                               String primContact=rs.getString("primContact");
                                 ss1.setAttribute("primContact1",primContact);
                               String secContact=rs.getString("secContact");
                                 ss1.setAttribute("secContact1",secContact);
                               String about=rs.getString("about");
                                 ss1.setAttribute("about1",about);
                               String website=rs.getString("website");
                                 ss1.setAttribute("website1",website);
                               String industry=rs.getString("industryName");
                                 ss1.setAttribute("industry1",industry);
                               // Creating session
                              
                            
                              count++;
                           }
                           if(count>0)
                           {
                            //  HttpSession ss1 = request.getSession(false);
                              //String userName=(String)ss1.getAttribute("username");
                             // String password1=(String)ss1.getAttribute("password");
                              
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
