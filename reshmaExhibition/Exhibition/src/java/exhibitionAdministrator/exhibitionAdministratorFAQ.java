package exhibitionAdministrator;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class exhibitionAdministratorFAQ extends HttpServlet
{
        protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                try 
                {
                        //values fetch from textbox of exhibitionAdministratorFAQ.jsp file
                        String exId=request.getParameter("exId");  
                        String tt=request.getParameter("title");
                        String que=request.getParameter("que");
                        String ans=request.getParameter("ans");
                        Connection con;
                        con=exhibitionAdministratorOneTimeConnection.getConnection(); 
                        HttpSession ss=request.getSession(false);
                        String idValid=(String)ss.getAttribute("idValid");  // value fetch from exhibitionAdminLoginCheck.java file
                        String val = "insert into exhibitionFAQ(exhibitionId,title,question,answer,createdBy,modifiedBy,modifiedByFlag)  values (?,?,?,?,'"+idValid+"','"+idValid+"',(select id from roles where id=1))" ;
                        //data inserted in exhibitionFAQ table
                        PreparedStatement ps = con.prepareStatement(val);  
                        ps.setString(1, exId);
                        ps.setString(2, tt);
                        ps.setString(3, que);
                        ps.setString(4, ans);
                        int n=  ps.executeUpdate(); 
                        if(n>0)
                        {
                              out.print("ok");
                        }
                        else
                        {
                              out.print("wrn");
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
