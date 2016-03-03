package exhibitionAdministrator;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class exhibitionAdministratorLoginCheck extends HttpServlet {
           protected void processRequest(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException { 
           response.setContentType("text/html");
           PrintWriter out = response.getWriter();
              try
                  {
                        // value fetch from exhibitionAdministratorLogin.jsp file
                        String uname=request.getParameter("un");  
                        request.setAttribute("email",uname);                    
                        String pass=request.getParameter("pw");
                        HttpSession ss=request.getSession(true);
                        Connection con;
                        con=exhibitionAdministratorOneTimeConnection.getConnection();
                        Statement stat=con.createStatement();   
                        Statement st=con.createStatement();   
                        // email id and password is verified from exhibitionAdmin table
                       
                        ResultSet rs=stat.executeQuery("select * from exhibitionAdmin where email='"+uname+"' or password='"+pass+"'");
                          ResultSet rs1;    
    
                        int count=0; 
                          while(rs.next())
                           {
                                 String un=rs.getString("email");
                                 ss.setAttribute("emailValid", un);           // emailValid variable is set using session object
                                String e=(String)ss.getAttribute("emailValid");
                                 String pw=rs.getString("password");
                                 ss.setAttribute("passwordValid", pw);        // passwordValid variable is set using session object
                                 String idValid=rs.getString("id");         
                                 ss.setAttribute("idValid" , idValid);        // idValid variable is set using session object
                                 String mn=rs.getString("mobileNo");
                                 ss.setAttribute("MN",mn);                    // mn variable is set using session object
                                 String usn=rs.getString("userName");
                                 ss.setAttribute("userNameValid", usn);       // userName variable is set using session object
                                 String le=rs.getString("level");
                                 ss.setAttribute("levelValid", le);           // levelValid variable is set using session object
                                 count++;
                                 String idR2=(String)ss.getAttribute("idValid"); 
                                 HttpSession oh=request.getSession(true);
                                   rs1=st.executeQuery("select * from exhibitionAdminContact where id='"+idR2+"' "); 
                                   while(rs1.next())
                                   {
                                String title=rs1.getString(2);
                                oh.setAttribute("titleValid", title);  
                                String firstName=rs1.getString(3);
                                oh.setAttribute("firstNameValid", firstName);  
                                String lastName=rs1.getString(4);
                                oh.setAttribute("lastNameValid", lastName);  
                                String gender=rs1.getString(5);
                                 oh.setAttribute("genderValid", gender); 
                                String dateOfBirth=rs1.getString(6);
                                 oh.setAttribute("dateOfBirthValid", dateOfBirth); 
                                String level=rs1.getString(7);
                                 oh.setAttribute("levelValid", level); 
                                String degination=rs1.getString(8);
                                 oh.setAttribute("deginationValid", degination); 
                                String phoneNo=rs1.getString(9);
                                 oh.setAttribute("phoneNoValid", phoneNo); 
                                   }
                         
                           }
                         
                  
                           if(count>0)
                           {
                               //HttpSession ss=request.getSession(false);
                               if( !uname.equals(ss.getAttribute("emailValid")) )         // textbox and table value of email compared 
                               {
                                    out.print("emailinvalid");        
                               }
                               else if(! pass.equals(ss.getAttribute("passwordValid")))   //textbox and table value of password are checked
                               {
                                   out.print("passwordinvalid");        
                               } 
                               else  
                               {           
                                // out.print("valid");   
                                   HttpSession oh=request.getSession(false);
                                  String tt=(String)oh.getAttribute("titleValid");  
                                  out.print(tt);
                                   String fN=(String)oh.getAttribute("firstNameValid");  
                                   //out.print(fN);
                                   String lN=(String)oh.getAttribute("lastNameValid");  
                                   //out.print(lN);
                                   String gn=(String)oh.getAttribute("genderValid");  
                                   //out.print(gn);
                                   String dobV=(String)oh.getAttribute("dateOfBirthValid"); 
                                  // out.print(dobV);
                                   String leV=(String)oh.getAttribute("levelValid");  
                                   String deV=(String)oh.getAttribute("deginationValid");  
                                   String pNV=(String)oh.getAttribute("phoneNoValid");  
                                   
                                if(tt.equals("")|| fN.equals("")|| lN.equals("")|| gn.equals("")|| dobV.equals("")||leV.equals("")|| deV.equals("")|| pNV.equals("")) 
                                { 
                                    out.print("firstVisitor");
                                }
                                else
                                {
                                  out.print("secondVisitor");
                                }
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
