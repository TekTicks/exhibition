package ownerPortal;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class OwnerLoginCheck extends HttpServlet 
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();
        try
        { 
                           String uname=request.getParameter("un");
                        
                           String pass=request.getParameter("pw");
                          
                           Class.forName("com.mysql.jdbc.Driver"); 
                           java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Exhibition","root","12345"); 
                           Statement stat=con.createStatement();
                           ResultSet rs=stat.executeQuery("select * from owner where userName='"+uname+"' or password='"+pass+"'");
                           int count=0;
                           while(rs.next())
                           {
                               String un=rs.getString("userName");
                               ownerPortal.Global.un=un;
                               String pw=rs.getString("password");
                               ownerPortal.Global.pw=pw;
                               count++;
                           }
                           if(count>0)
                           {
                               if( !uname.equals(ownerPortal.Global.un))
                               {
                                    out.print("emailinvalid");        

                               }
                               else if(! pass.equals(ownerPortal.Global.pw))
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
