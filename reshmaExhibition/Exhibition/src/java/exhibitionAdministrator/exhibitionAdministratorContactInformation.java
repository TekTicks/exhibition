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

public class exhibitionAdministratorContactInformation extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
          response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {
              //values fetch from textbox of exhibitionAdministratorProfile.jsp file
              String tt=request.getParameter("t1");  
              String fn=request.getParameter("fn");
              String ln =request.getParameter("ln");
              String dob=request.getParameter("dob");
              String le=request.getParameter("le");
              String dn=request.getParameter("dn");
              String pn=request.getParameter("pn");
              Connection con;
              con=exhibitionAdministratorOneTimeConnection.getConnection();
              
              HttpSession ss=request.getSession(false);
              String rs1 = (String)ss.getAttribute("idValid"); 
               String mediaid=(String)ss.getAttribute("mediaId1");
               
               HttpSession ssC=request.getSession(false);
                String fileName = (String)ssC.getAttribute("fileName"); 
                out.print(fileName);
               
     /*     PreparedStatement   psmnt = con.prepareStatement("insert into media(link,type) values('"+fileName+"',?)");
//psmnt.setString(1, );
psmnt.setString(1, "");
int s = psmnt.executeUpdate();
if(s>0){
System.out.println("Uploaded successfully !");
}
else{
System.out.println("Error!");
}  */
                
              // idValid fetch from exhibitionAdminLoginCheck.java file 
              //value fetch from insertimage.jsp file
              PreparedStatement ps=con.prepareStatement("update exhibitionAdminContact set title='"+tt+"',firstName='"+fn+"',lastName='"+ln+"',dateOfBirth='"+dob+"' ,level='"+le+"',degination='"+dn+"',phoneNo='"+pn+"' where id='"+rs1+"' ");
              //data is updated in exhibitionAdmin table
              int rst = ps.executeUpdate();
              if(rst !=0)
              {
                 out.print("dataupdated");
              }
              else
              {
                 out.print("dataupdateinvalid");
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
