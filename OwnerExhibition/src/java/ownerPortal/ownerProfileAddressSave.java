
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
import javax.servlet.http.HttpSession;


public class ownerProfileAddressSave extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         try
                           {
                               
                                HttpSession ss=request.getSession();
                            String id=(String)ss.getAttribute("ownerId");
                            String address1=request.getParameter("address1");
                            String address2=request.getParameter("address2");
                            String zipcode =request.getParameter("zipcode");
                            String landmark =request.getParameter("landmark");
                            String maplink =request.getParameter("maplink");
                            String country =request.getParameter("one");
                             String state =request.getParameter("two");
                              String city =request.getParameter("three");
                            
                           
                          Connection con;
                           con=dbConnection.getConnection();
                            PreparedStatement ps=con.prepareStatement("insert into ownerAddress(address1,address2,landmark,pincode,cityId,maplink,createdBy,modifiedBy)values(?,?,?,?,(select id from city where id=1),?,(select id from owner where id='"+id+"'),(select id from owner where id='"+id+"'))");
                                ps.setString(1,address1);
                                ps.setString(2,address2);
                                ps.setString(3, landmark);
                                ps.setString(4, zipcode); 
                                ps.setString(5, maplink);
                                ps.executeUpdate();
                              PreparedStatement ps1=con.prepareStatement("insert into country(countryName,continentId,createdBy,modifiedBy)values(?,(select id from continents where id=1),?,?)");
                                ps1.setString(1,country);    
                                ps1.setInt(2,1);  
                                ps1.setInt(3,1);  
                                ps1.executeUpdate();
                                   
                                PreparedStatement ps2=con.prepareStatement("insert into state(stateName,countrytId,createdBy,modifiedBy)values(?,(select id from country where id=1),?,?)");
                                ps2.setString(1,state);    
                                ps2.setInt(2,1);  
                                ps2.setInt(3,1);  
                                ps2.executeUpdate();
                                
                                PreparedStatement ps3=con.prepareStatement("insert into city(cityName,citytId,createdBy,modifiedBy)values(?,(select id from state where id=1),?,?)");
                                ps3.setString(1,city);    
                                ps3.setInt(2,1);  
                                ps3.setInt(3,1);  
                                ps3.executeUpdate();
                                
                                 // response.sendRedirect("/Exhibition/html/ownerProfile.jsp");
                           out.print("dfasfsd");
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
