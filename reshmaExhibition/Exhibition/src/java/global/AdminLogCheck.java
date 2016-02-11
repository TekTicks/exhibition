package global;
import java.io.*;
import java.sql.*;
import java.sql.DriverManager;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminLogCheck extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
           response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try
        {
                           String uname=request.getParameter("un");
                           request.setAttribute("email",uname);                    
                           String pass=request.getParameter("pw");
                           Class.forName("com.mysql.jdbc.Driver"); 
                           java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exhibition","root","123"); 
                           Statement stat=con.createStatement();
                           ResultSet rs=stat.executeQuery("select * from exhibitionAdmin where email='"+uname+"' or password='"+pass+"'");
                           int count=0; 
                           while(rs.next())
                           {
                                 String un=rs.getString("email");
                                 Global.un=un;
                                 String pw=rs.getString("password");
                                 Global.pwd=pw;
                          
                                           String mn=rs.getString("mobileNo");
                                           global.personalInformation.mobileNoPI=mn;
                                           String usn=rs.getString("userName");
                                           global.personalInformation.userNamePI=usn;
                                        
                                           String le=rs.getString("level");
                                           global.personalInformation.levelPI=le;
                                 count++;
                           }
                           if(count>0)
                           {
                               if( !uname.equals(Global.un))
                               {
                                    out.print("emailinvalid");        

                               }
                               else if(! pass.equals(Global.pwd))
                               {
                                   out.print("passwordinvalid");        

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
