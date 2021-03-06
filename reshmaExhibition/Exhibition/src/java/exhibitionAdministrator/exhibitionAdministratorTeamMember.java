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
public class exhibitionAdministratorTeamMember extends HttpServlet 
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
          response.setContentType("text/html;charset=UTF-8");
          PrintWriter out = response.getWriter();
          try
          { 
                  
                    // value fetch from exhibitionAdministratorTeam.jsp 
                    HttpSession ss=request.getSession(false);
                    String idValid = (String) ss.getAttribute("idValid");     
                   
                    // value fetch from textbox of exhibitionAdministratorTeam.jsp             
                    String tagline=request.getParameter("tagline");
                    String title=request.getParameter("title");
                    String firstName=request.getParameter("firstName");
                    String lastName=request.getParameter("lastName");
                 String gender= request.getParameter("optionyes");
                   
                    String dateOfBirth=request.getParameter("dateOfBirth");
                    String degination=request.getParameter("degination");
                    String phoneCountryId=request.getParameter("phoneCountryId");
                    String phoneNo=request.getParameter("phone");
                    String mobileCountryId=request.getParameter("mobileCountryId");
                   // out.print(mobileCountryId);
                    String mobileNo=request.getParameter("mobileNo");
                    String email=request.getParameter("email");

                    Connection con;
                    con=exhibitionAdministratorOneTimeConnection.getConnection();  
                   
                        String val = "insert into exhibitionTeam(tagline,title,firstName,lastName,gender,dateOfBirth,degination,phoneNo,mobileNo,email,phoneCountryId,mobileCountrytId,createdBy,modifiedBy,modifiedByFlag)  values (?,?,?,?,?,?,?,?,?,?,?,?,(select id from owner where id=1), '"+idValid+"' ,(select id from roles where id=1))" ;
                        // data inserted in exhibitionTeam table
                        PreparedStatement ps = con.prepareStatement(val); 
                        ps.setString(1, tagline);
                        ps.setString(2, title);
                        ps.setString(3, firstName);
                        ps.setString(4, lastName);
                        ps.setString(5,gender);
                        ps.setString(6, dateOfBirth);
                        ps.setString(7, degination);
                        ps.setString(8, phoneNo);
                        ps.setString(9, mobileNo);
                        ps.setString(10, email);    
                         ps.setString(11, phoneCountryId);
                        ps.setString(12, mobileCountryId);   
                        int n=  ps.executeUpdate(); 
                        if(n>0)
                        {
                              out.print("ok");
                        }
                        else
                        {
                              out.print("wrong");
                        }
                        con.close();
                        response.sendRedirect("/Exhibition/html/exhibitionAdministratorTeam.jsp");
                  
                 }
                  catch(Exception e)
           {
             out.print("error");
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