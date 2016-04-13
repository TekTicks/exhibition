package org.apache.jsp.html;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ownerPortal.dbConnection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Iterator;
import java.io.File;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.*;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.fileupload.FileItem;
import java.io.*;
import java.sql.*;
import java.util.zip.*;

public final class ownerProfileContactPersonUpdateDemo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<center><h1>Your  Profile has been Uploaded</h1></center>\n");
    
            String r;
      String title = "";
      String fname = "";
      String lname = "";
      String email = "";
      String gender = "";
      String dob = "";
      String designation = "";
      String phoneno = "";
      String mobileno = "";
      String phnNo = "";
      String mobNo = "";
      
    int count1 = 0;
    boolean isMultipart = ServletFileUpload.isMultipartContent(request);
    if (!isMultipart) 
    { 
    }
    else 
    {
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List items = null;
        try 
        {
            items = upload.parseRequest(request);
        }
        catch (FileUploadException e)
        {
        e.printStackTrace();
        }
        Iterator itr = items.iterator();
        while (itr.hasNext()) 
        {
            FileItem item = (FileItem) itr.next();
            if (item.isFormField())
            {

                String title1 = item.getFieldName();
                String value = item.getString();

                String fname1 = item.getFieldName();
                String value1 = item.getString();

                String lname1 = item.getFieldName();
                String value2 = item.getString();

                String email1 = item.getFieldName();
                String value3 = item.getString();

                String gender1 = item.getFieldName();
                String value4 = item.getString();

                String dob1 = item.getFieldName();
                String value5 = item.getString();

                String designation1 = item.getFieldName();
                String value6 = item.getString();

                String phoneno1 = item.getFieldName();
                String value7 = item.getString();

                String mobileno1 = item.getFieldName();
                String value8 = item.getString();

                String phnNo1 = item.getFieldName();
                String value9 = item.getString();

                String mobileNo1 = item.getFieldName();
                String value10 = item.getString();


                if (title1.equals("title")) {
                title = value;
                count1 = 1;
                }

                if (fname1.equals("fname")) {
                fname = value1;
                count1 = 1;
                }

                if (lname1.equals("lname")) {
                lname = value2;
                count1 = 1;
                }


                if (email1.equals("email")) {
                email = value3;
                count1 = 1;
                }

                if (gender1.equals("gender")) {
                gender = value4;
                count1 = 1;
                }

                if (dob1.equals("dob")) {
                dob = value5;
                count1 = 1;
                }

                if (designation1.equals("designation")) {
                designation = value6;
                count1 = 1;
                }

                if (phoneno1.equals("phoneno")) {
                phoneno = value7;
                count1 = 1;
                }

                if (mobileno1.equals("mobileno")) {
                mobileno = value8;
                count1 = 1;
                }

                if (phnNo1.equals("phnNo")) {
                phnNo = value9;
                count1 = 1;
                }

                if (mobileNo1.equals("mobNo")) {
                mobNo = value10;
                count1 = 1;
                }
                        
            } 
            else
            {
                try 
                {
                    String itemName = item.getName();
                    File savedFile = new File("D:/pagal/Exhibition Project Main/Esssxhibition/web/html/imagessssss/" + itemName);
                    item.write(savedFile);
                    if (count1 == 1) 
                    {
                        HttpSession ss=request.getSession();
                        ss.setAttribute("fileNassssme",itemName);   
                    }
                } 
                catch (Exception e) 
                {
                    e.printStackTrace();
                }
            }
        }
        out.print(gender);
        Connection con1;
        con1=dbConnection.getConnection();
        PreparedStatement psmnt = null;
        try
        {
            HttpSession ss=request.getSession();
            String fileName=(String)ss.getAttribute("fileName");
            psmnt = con1.prepareStatement("insert into media(link,type) values('"+fileName+"',?)");
            psmnt.setString(1, "");
            psmnt.executeUpdate();

            Connection con5;
            con5=dbConnection.getConnection();
            Statement stat5=con5.createStatement();
            ResultSet rs5=stat5.executeQuery("select * from media where link='"+fileName+"'");

            if(!rs5.next())
            {
            }
            else
            { 
                String logoMediaID=rs5.getString(1);
                //set Session
                 ss.setAttribute("photoMediaId",logoMediaID);
            }
            String photoMediaId=(String)ss.getAttribute("photoMediaId");
             //retrieve id of contactPerson from ownerProfileContactPersonUpdate.jsp
            String id=(String)ss.getAttribute("contactPersonId");
            Connection con;
            con=dbConnection.getConnection();
             
            PreparedStatement ps=con.prepareStatement("update ownerContactPerson set title=?,firstName=?,lastName=?,photoMediaId=?,gender=?,dateOfBirth=?,degination=?,phoneNo=?,mobileNo=?,email=?,primCountryCodeId=?,secCountryCodeId=? where id='"+id+"'");
            ps.setString(1,title);
            ps.setString(2, fname);
            ps.setString(3, lname);
            ps.setString(4, photoMediaId);
            ps.setString(5, gender);
            ps.setString(6, dob);
            ps.setString(7, designation);
            ps.setString(8, phoneno);
            ps.setString(9, mobileno);
            ps.setString(10, email);
            ps.setString(11,phnNo);
            ps.setString(12,mobNo);
            ps.executeUpdate();
            //response.sendRedirect("/Exhibition/html/ownerProfile.jsp"); 
        }

        catch(Exception e)
        {
           //out.println("error"+e.toString());
           
              r=e.getMessage();
                  out.print(r);
        }
    }


      out.write('\n');
      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
