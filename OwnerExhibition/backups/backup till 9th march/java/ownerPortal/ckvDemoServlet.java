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
public class ckvDemoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try
        {
            HttpSession ss=request.getSession();
            String CNAME=request.getParameter("cname");
              ss.setAttribute("cname",CNAME);
            String EMAIL=request.getParameter("emailid");
             ss.setAttribute("email",EMAIL);
            String PHONE=request.getParameter("contact");
              ss.setAttribute("phone",PHONE);
            String PASSWORD=request.getParameter("password");
             ss.setAttribute("password",PASSWORD);
            String COUNTRYCODE=request.getParameter("ccode");
             ss.setAttribute("ccode",COUNTRYCODE);
            //COUNTRYCODE=COUNTRYCODE+PHONE;
           // Global.global.contact1=COUNTRYCODE;
            
           
           Connection con;
           con=dbConnection.getConnection();
            Statement stat=con.createStatement();
            ResultSet rs=stat.executeQuery("select * from ownerProfile where primEmail='"+EMAIL+"' or primContact='"+PHONE+"'");
            int count=0;
            while(rs.next())
                {
                    String email_id=rs.getString(5);
                     ss.setAttribute("email1",email_id);   
                    String phone_no=rs.getString(7);
                     ss.setAttribute("phone1",phone_no); 
                        count++;
                }
            if(count>0)
                {
                    String emailId=(String)ss.getAttribute("email1");
                    String phoneNo=(String)ss.getAttribute("phone1");
                  if(EMAIL.equals(emailId ))
                    {
                      out.print("invalidemail");    
                    }
                  else if(PHONE.equals( phoneNo))
                    {
                      out.print("invalidphone");    
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
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
         HttpSession session = request.getSession(true);
        String cname = (String)request.getAttribute("cname");
        session.setAttribute("Cname", cname);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
