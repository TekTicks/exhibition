package exhibitionAdministrator;
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
public class exhibitionAdministratorMobileNo extends HttpServlet
{
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
        {
                response.setContentType("text/html;charset=UTF-8");
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                try
                { 
                        // value fetch from textbox of exhibitionAdministratorMobileNo.jsp file
                        String mobile=request.getParameter("un");
                        HttpSession ss=request.getSession(false);
                        Connection con;
                        con=exhibitionAdministratorOneTimeConnection.getConnection();
                        Statement stat=con.createStatement();
                        // textbox value of mobileNo checked with exhibitionAdmin Table
                        ResultSet rs=stat.executeQuery("select * from exhibitionAdmin where mobileNo='"+mobile+"'");         
                        int count=0;
                        while(rs.next())
                        {
                             count++;
                        }
                        if(count>0)
                        {  
                            if(!(mobile.equals(ss.getAttribute("MN")))  && !(mobile.length()==10))   // mobile No 10 digit validation 
                            {
                                 out.print("wrong");
                            }
                            else
                            {
                                 out.print("ok");
                                 // response.sendRedirect("/Exhibition/html/exhibitionAdministratorFogotPassword.jsp");
                            }
                         }
                         else
                         {
                                out.print("ERROR");
                         }
             }
             catch(Exception e)
             {  
                   out.println("errorsss" +e);
  
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