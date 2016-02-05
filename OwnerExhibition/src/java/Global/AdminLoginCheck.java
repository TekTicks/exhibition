/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Global;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.sql.DriverManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;  
import javax.servlet.http.HttpSession;  

  

/**
 *
 * @author Admin
 */
public class AdminLoginCheck extends HttpServlet {

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
            response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try
        { 
                           String uname=request.getParameter("un");
                           String pass=request.getParameter("pw");
                          
                           Class.forName("com.mysql.jdbc.Driver"); 
                           java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Exhibition","root","12345"); 
                           Statement stat=con.createStatement();
                           ResultSet rs=stat.executeQuery("select * from owner where userName='"+uname+"' or password='"+pass+"'");
                           int count=0;
                           while(rs.next())
                           {
                               String un=rs.getString("userName");
                               Global.global.un=un;
                               String pw=rs.getString("password");
                               Global.global.pw=pw;
                               count++;
                           }
                           if(count>0)
                           {
                               if( !uname.equals(Global.global.un))
                               {
                                    out.print("emailinvalid");        

                               }
                               else if(! pass.equals(Global.global.pw))
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
