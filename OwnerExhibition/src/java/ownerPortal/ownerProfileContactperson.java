
package ownerPortal;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ownerProfileContactperson extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();
         try
                           {
                            String title=request.getParameter("title");
                            String firstname=request.getParameter("fname");
                            String lastname =request.getParameter("lname");
                            String email =request.getParameter("email");
                            String gender =request.getParameter("gender");
                            String dateofbirth =request.getParameter("dob");
                            String designation =request.getParameter("designation");
                            String phoneno =request.getParameter("phoneno");
                            String mobileno =request.getParameter("mobileno");
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Exhibition","root","12345");
                            PreparedStatement ps=con.prepareStatement("insert into ownerContactPerson(title,firstName,lastName,photoMediaId,gender,dateOfBirth,degination,phoneNo,mobileNo,email,createdBy,modifiedBy)values(?,?,?,(select id from media where id=1),?,?,?,?,?,?,(select id from owner where id=1),(select id from owner where id=1))");
                                 ps.setString(1,title);
                                 ps.setString(2,firstname);
                                 ps.setString(3, lastname);
                                 ps.setString(4, gender); 
                                 ps.setString(5, dateofbirth);
                                 ps.setString(6, designation);
                                 ps.setString(7, phoneno); 
                                 ps.setString(8, mobileno); 
                                 ps.setString(9, email); 
                                 ps.executeUpdate();
                            
                            
                                 out.print("<center>data saved</center>");
                           }
                           catch(Exception ee)
                           {
                               out.println("error"+ee);
                         
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
