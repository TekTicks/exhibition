 package exhibitionAdministrator;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class exhibitionAdministratorPersonalInformation extends HttpServlet
{
          protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
          {
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                try
                {
                        //value fetch from textbox of exhibitionAdministratorProfilePage.jsp file
                        String mn=request.getParameter("mn");
                        String us=request.getParameter("us");
                        String pw=request.getParameter("pw");
                        String le=request.getParameter("le");
                        Connection con;
                        con=exhibitionAdministratorOneTimeConnection.getConnection();
                        HttpSession ss=request.getSession(false);
                        String rs1 = (String) ss.getAttribute("emailValid");       // emailValid value fetch from exhibitionAdministratorLoginCheck.java file
                        if (!(mn.length() == 10) )       // mobile no validation
                        {
                              out.print("mobileNoInvalid");
                        }  
                        else
                        {
                              String query = "update exhibitionAdmin set mobileNo ='"+mn+"',userName ='"+us+"',password ='"+pw+"',level ='"+le+"' where email='"+rs1+"' ";
                              // data updated in exhibitionAdmin table
                              PreparedStatement ps=con.prepareStatement(query);
                              int rs= ps.executeUpdate();
                              if(rs !=0)
                              {
                                    out.print("ok");   
                              }
                              else
                              {
                                    out.print("wrong");
                              }
                         }
                }
                catch(Exception ee)
                {
                      out.println("error" +ee.toString());
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