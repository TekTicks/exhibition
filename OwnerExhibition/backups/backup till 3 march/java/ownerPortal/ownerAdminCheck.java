package ownerPortal;
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

public class ownerAdminCheck extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try
        {
            //set all inputs in session variable used in ownerAddAdministrator.java
             HttpSession ss=request.getSession();
            String userName=request.getParameter("uname");
            ss.setAttribute("uname",userName);
            String EMAIL=request.getParameter("emailid");
              ss.setAttribute("emailId",EMAIL);
            String PHONE=request.getParameter("contact");
             ss.setAttribute("phoneNo",PHONE);
            String PASSWORD=request.getParameter("password");
            ss.setAttribute("pass",PASSWORD);
            String exhibitionName=request.getParameter("exhibitionName");
            ss.setAttribute("exhName",exhibitionName);
            
            
           Connection con;
           con=dbConnection.getConnection();
           Statement stat=con.createStatement();
           ResultSet rs=stat.executeQuery("select * from exhibitionAdmin where email='"+EMAIL+"' or mobileNo='"+PHONE+"'");
           int count=0;
           while(rs.next())
                {
                    
                  String email_id=rs.getString(4);
                     ss.setAttribute("emailId1",email_id);
                  String phone_no=rs.getString(3);
                     ss.setAttribute("phoneNo1",phone_no);
                  count++;
                }
        if(count>0)
                {
                  String emailId=(String)ss.getAttribute("emailId1");
                  String phoneNo=(String)ss.getAttribute("phoneNo1");
                
                  if(EMAIL.equals(emailId))
                    {
                      out.print("invalidemail");    
                    }
                  else if(PHONE.equals(phoneNo))
                    {
                      out.print("invalidphone");    
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