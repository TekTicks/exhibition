package Global;
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

            String CNAME=request.getParameter("cname");
            Global.global.cname1=CNAME;
            String EMAIL=request.getParameter("emailid");
            Global.global.email1=EMAIL; 
            String PHONE=request.getParameter("contact");
            String PASSWORD=request.getParameter("password");
            Global.global.password1=PASSWORD;
            String COUNTRYCODE=request.getParameter("ccode");
            COUNTRYCODE=COUNTRYCODE+PHONE;
            Global.global.contact1=COUNTRYCODE;
                 
            Class.forName("com.mysql.jdbc.Driver"); 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Exhibition","root","12345"); 
            Statement stat=con.createStatement();
            ResultSet rs=stat.executeQuery("select * from ownerProfile where primEmail='"+EMAIL+"' or primContact='"+PHONE+"'");
            int count=0;
            while(rs.next())
                {
                    String email_id=rs.getString(5);
                      Global.global.emailid=email_id; 
                    String phone_no=rs.getString(7);
                      Global.global.phoneno=phone_no;  
                        count++;
                }
            if(count>0)
                {
                  if(EMAIL.equals(Global.global.emailid))
                    {
                      out.print("invalidemail");    
                    }
                  else if(PHONE.equals(Global.global.phoneno))
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
