
package ownerPortal;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Fetch_State extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
        try
        {
            ArrayList<String> arr1 =new ArrayList<String>();
            ArrayList<String> arr2 =new ArrayList<String>();
            ArrayList<String> arr3 =new ArrayList<String>();
            ArrayList<String> arr4 =new ArrayList<String>(); 
            
            String valajax=request.getParameter("valajax");  
           
            Connection con3;
              con3=dbConnection.getConnection();
               Statement stat3=con3.createStatement();
                ResultSet rs3=stat3.executeQuery("select * from city where stateName='maharashtra'");
                   while(rs3.next())
                     { 
                         String idState1=rs3.getString(2);
                          arr3.add("");
                           arr3.add(idState1);
                     }
                   
             if(valajax.equals(valajax))
            {
                response.getWriter().write("<label><b>&nbsp &nbsp  Select state<b></label><br>");
                response.getWriter().write("&nbsp &nbsp<select  class=\"full-width\" data-init-plugin=\"select2\"> ");
                //response.getWriter().write("DropDown 1:<select> ");
                for(int i=0;i<arr3.size();i++)
                {
                     response.getWriter().write("<option>"+arr3.get(i)+"</option>");
                }
                
                response.getWriter().write("</select> ");
            }
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
