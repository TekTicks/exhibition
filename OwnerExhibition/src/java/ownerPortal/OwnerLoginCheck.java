package ownerPortal;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class OwnerLoginCheck extends HttpServlet 
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();
        try
        { 
                           String uname=request.getParameter("un");
                           String pass=request.getParameter("pw");
                           // one time Database connection
                           Connection con;
                           con=dbConnection.getConnection();
                           Statement stat=con.createStatement();
                           //ResultSet rs=stat.executeQuery("select a.* from owner a where a.userName='"+uname+"' and a.password='"+pass+"'");
                           ResultSet rs=stat.executeQuery("select a.*,b.*,c.* from owner a,ownerProfile b,industry c where a.userName='"+uname+"' and a.password='"+pass+"'");
                           int count=0;
                           while(rs.next())
                           {
                               String un1=rs.getString("userName");
                               String pw1=rs.getString("password");
                               String id=rs.getString(1);
                               String cname=rs.getString("name");
                               String primEmail=rs.getString("primEmail");
                               String secEmail=rs.getString("secEmail");  
                               String primContact=rs.getString("primContact");
                               String secContact=rs.getString("secContact");
                               String about=rs.getString("about");
                               String website=rs.getString("website");
                               String industry=rs.getString("industryName");
                               
                               // Creating session
                               HttpSession ss=request.getSession();
                               ss.setAttribute("username",un1);
                               ss.setAttribute("password",pw1);
                               ss.setAttribute("ownerId",id);
                               ss.setAttribute("cname",cname);
                               ss.setAttribute("primEmail1",primEmail);
                               ss.setAttribute("secEmail1",secEmail);
                               ss.setAttribute("primContact1",primContact);
                               ss.setAttribute("secContact1",secContact);
                               ss.setAttribute("about1",about);
                               ss.setAttribute("website1",website);
                               ss.setAttribute("industry1",industry);
                             /* ownerPortal.Global.ownerId=rs.getString("id");
                              ownerPortal.Global.companyname=rs.getString("name"); 
                              ownerPortal.Global.primaryemail=rs.getString("primEmail");
                              ownerPortal.Global.secondaryemail=rs.getString("secEmail");
                              ownerPortal.Global.primarycontact=rs.getString("primContact");
                              ownerPortal.Global.secondarycontact=rs.getString("secContact");
                              ownerPortal.Global.about=rs.getString("about");
                              ownerPortal.Global.website=rs.getString("website");*/
                              
                              count++;
                           }
                           if(count>0)
                           {
                              HttpSession ss=request.getSession();
                              String userName=(String)ss.getAttribute("username");
                              String password1=(String)ss.getAttribute("password");
                              
                              if( !uname.equals(userName))
                               {
                                    out.print("emailinvalid");        

                               }
                               else if(! pass.equals(password1))
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
                           
                           /* ResultSet rs1=stat1.executeQuery("select * from ownerProfile");
                           int count1=0;
                           while(rs1.next())
                           {
                               String companyname=rs.getString(2);
                               ownerPortal.Global.companyname=companyname;
                               String primaryemail=rs.getString(3);
                               ownerPortal.Global.primaryemail=primaryemail;
                               String secemail=rs.getString(4);
                               ownerPortal.Global.secondaryemail=secemail;
                               String primarycontact=rs.getString(5);
                               ownerPortal.Global.primarycontact=primarycontact;
                               String seccontact=rs.getString(6);
                               ownerPortal.Global.secondarycontact=seccontact;
                               String about=rs.getString(7);
                               ownerPortal.Global.about=about;
                               String website=rs.getString(8);
                               ownerPortal.Global.website=website;
                               ownerPortal.Global.profileId=rs.getString("id");
                               count1++;
                           }
                           */
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

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
       
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
