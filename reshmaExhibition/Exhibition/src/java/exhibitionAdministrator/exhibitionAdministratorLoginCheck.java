package exhibitionAdministrator;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class exhibitionAdministratorLoginCheck extends HttpServlet {
           protected void processRequest(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException { 
           response.setContentType("text/html");
           PrintWriter out = response.getWriter();
              try
                  {
                        // value fetch from exhibitionAdministratorLogin.jsp file
                        String uname=request.getParameter("un");  
                        request.setAttribute("email",uname);                    
                        String pass=request.getParameter("pw");
                        HttpSession ss=request.getSession(true);
                        Connection con;
                        con=exhibitionAdministratorOneTimeConnection.getConnection();
                        Statement stat=con.createStatement();
                        // email id and password is verified from exhibitionAdmin table
                        ResultSet rs=stat.executeQuery("select * from exhibitionAdmin where email='"+uname+"' or password='"+pass+"'");
                       
                        int count=0; 
                          while(rs.next())
                           {
                                 String un=rs.getString("email");
                                 ss.setAttribute("emailValid", un);           // emailValid variable is set using session object
                                 String pw=rs.getString("password");
                                 ss.setAttribute("passwordValid", pw);        // passwordValid variable is set using session object
                                 String idValid=rs.getString("id");         
                                 ss.setAttribute("idValid" , idValid);        // idValid variable is set using session object
                                 String mn=rs.getString("mobileNo");
                                 ss.setAttribute("MN",mn);                    // mn variable is set using session object
                                 String usn=rs.getString("userName");
                                 ss.setAttribute("userNameValid", usn);       // userName variable is set using session object
                                 String le=rs.getString("level");
                                 ss.setAttribute("levelValid", le);           // levelValid variable is set using session object
                                 count++;
                           }
                           if(count>0)
                           {
                               //HttpSession ss=request.getSession(false);
                               if( !uname.equals(ss.getAttribute("emailValid")) )         // textbox and table value of email compared 
                               {
                                    out.print("emailinvalid");        
                               }
                               else if(! pass.equals(ss.getAttribute("passwordValid")))   //textbox and table value of password are checked
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
