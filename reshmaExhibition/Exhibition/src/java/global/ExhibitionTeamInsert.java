/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package global;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class ExhibitionTeamInsert extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
          PrintWriter out = response.getWriter();
        try
            {
                                
             String tagline=request.getParameter("tagline");
           String title=request.getParameter("title");
            String firstName=request.getParameter("firstName");
           String lastName=request.getParameter("lastName");
            String gender=request.getParameter("gender");
            String dateOfBirth=request.getParameter("dateOfBirth");
           String degination=request.getParameter("degination");
           String phoneNo=request.getParameter("phoneNo");
           String mobileNo=request.getParameter("mobileNo");
           String email=request.getParameter("email");
           String modifiedBy=request.getParameter("modifiedBy");
                     
             Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exhibition","root","123");
              
        String val = "insert into exhibitionTeam(tagline,title,firstName,lastName,gender,dateOfBirth,degination,phoneNo,mobileNo,email,createdBy,modifiedBy,modifiedByFlag)  values (?,?,?,?,?,?,?,?,?,?,(select id from owner where id=1),?,(select id from roles where id=1))" ;
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
                      ps.setString(11, modifiedBy);
                  
                  int n=  ps.executeUpdate(); 
        
                  if(n>0)
                  {
                        out.println("ok");
                  }
                  else
                  {
                        out.println("error");
                  }
      
           con.close();
            
            }
           catch(Exception e)
           {
               out.println("error" +e);
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
