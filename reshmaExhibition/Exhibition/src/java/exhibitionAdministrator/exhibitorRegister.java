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
public class exhibitorRegister extends HttpServlet
{
        protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                try 
                {
                       HttpSession sst=request.getSession(true);
                        //values fetch from textbox of exhibitorRegister.jsp file
                        String CN=request.getParameter("companyName"); 
                        String UN=request.getParameter("userName");
                        String EM=request.getParameter("email");
                        String PASS=request.getParameter("password");
                        String CPASS=request.getParameter("cpassword");
                        String CI=request.getParameter("countryId");
                        String MN=request.getParameter("phone");
                        String m= request.getParameter("exId"); 
                        char x=EM.charAt(0);
                        Connection con;
                        con=exhibitionAdministratorOneTimeConnection.getConnection(); 
                        HttpSession ss=request.getSession(false);
                        String idValid=(String)ss.getAttribute("idValid");
                       // value fetch from exhibitionAdminLoginCheck.java file
                        Statement stat=con.createStatement();   
                        ResultSet rs=stat.executeQuery("select * from exhibitor");
                        int len=0;
                        while(rs.next())
                        {
                             String em=rs.getString(7);
                             //out.print(em);
                              sst.setAttribute("emailId1",em);
                              String mb=rs.getString(5);
                              sst.setAttribute("mobileNo",mb);
                         len++; 
                       } 
                        if(!(CPASS.equals(PASS)))
                        {
                            out.print("passwordInvalid");
                        }
                            else if((sst.getAttribute("emailId1").equals(EM))) 
                            {
                                out.print("emailInvalid");
                             }
                            else if((sst.getAttribute("mobileNo").equals(MN))) 
                            {
                                out.print("mobileNoInvalid");
                             }
                       else
                        {
                          
                        String val = "insert into exhibitor(firstLetter,isMainExhibitor,companyName,mobileNo,username,email,password,createdBy,modifiedBy,countryId)  values ('"+x+"',?,?,?,?,?,?,'"+idValid+"','"+idValid+"',?)" ;
                        //data inserted in exhibitionFAQ table
                        PreparedStatement ps = con.prepareStatement(val);  
                        ps.setString(1, m);
                        ps.setString(2, CN);
                        ps.setString(3, MN);
                        ps.setString(4, UN);
                        ps.setString(5, EM);
                        ps.setString(6, PASS);
                        ps.setString(7, CI);
                        int n=  ps.executeUpdate(); 
                        out.print(n);
                        if(n>0)
                        {
                              out.print("ok");
                        }
                        else
                        {
                              out.print("wrn");
                        }
                        } 
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
