package global;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.*;
//import javax.servlet.RequestDispatcher;


public class ExhibitionAdminPersonal extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
          response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {
             String mn=request.getParameter("mn");
           
         String us=request.getParameter("us");
             String pw=request.getParameter("pw");
             String le=request.getParameter("le");
         
             Class.forName("com.mysql.jdbc.Driver"); 
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exhibition","root","123"); 
        
     // String query="update exhibitionAdmin set mobileNo='"+mn+"'  where email='"+Global.un+"'" ;
      if (!(mn.length()== 10) )
     
              {
                   out.print("mobileNoInvalid");
              }
 
                
        else
      {
    String query = "update exhibitionAdmin set mobileNo ='"+mn+"',userName ='"+us+"',password ='"+pw+"',level ='"+le+"' where email='"+Global.un+"' ";
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
        catch(ClassNotFoundException | SQLException ee)
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

    private boolean isNaN(char[] value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
