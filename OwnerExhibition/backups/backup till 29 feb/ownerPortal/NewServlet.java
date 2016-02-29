/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ownerPortal;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "NewServlet", urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet {

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
            arr1.add("");
            arr1.add("New Delhi");
            arr1.add("Maharashtra");
            arr1.add("Goa");
            arr2.add("Kabul");
            arr2.add("Karachi");
            arr2.add("Punjab");
            arr3.add("pune");
            arr3.add("thane");
            arr3.add("karjat");
            arr4.add("Delhi");
            arr4.add("Minto Road");
            arr4.add("Janakpuri");
            String valajax=request.getParameter("valajax");
            if(valajax.equals("v1"))
            {
                response.getWriter().write("<label><b>&nbsp &nbsp  Select state<b></label><br>");
                response.getWriter().write("&nbsp &nbsp<select  class=\"full-width\" data-init-plugin=\"select2\"> ");
                //response.getWriter().write("DropDown 1:<select> ");
                for(int i=0;i<arr1.size();i++)
                {
                     response.getWriter().write("<option>"+arr1.get(i)+"</option>");
                }
                
                response.getWriter().write("</select> ");
            }
             if(valajax.equals("v2"))
            {
                 response.getWriter().write("<label><b>&nbsp &nbsp Select state<b></label><br>");
                response.getWriter().write("&nbsp &nbsp<select  class=\"full-width\" data-init-plugin=\"select2\"> ");
                for(int i=0;i<arr2.size();i++)
                {
                     response.getWriter().write("<option>"+arr2.get(i)+"</option>");
                }
                
                response.getWriter().write("</select> ");
            }
             
            
             
              if(valajax.equals("New Delhi"))
            {
                
                for(int i=0;i<arr4.size();i++)
                {
                     response.getWriter().write("<option>"+arr4.get(i)+"</option>");
                }
                
            }
               if(valajax.equals("Maharashtra"))
            {
      
                for(int i=0;i<arr3.size();i++)
                {
                     response.getWriter().write("<option>"+arr3.get(i)+"</option>");
                }
                
            
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
