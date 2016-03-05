package org.apache.jsp.html;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.sql.*;
import model.*;;

public final class ajax_005ffile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

        OutputStream fout = null;
           InputStream filecontent = null; 
           String type="";
 
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("   <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    ");

  
    final String path ="D:/tp/image";
    final Part filePart = request.getPart("photoimg");
    //return content type of the file
    type=filePart.getHeader("content-type");
    System.out.println(type);
    //checking content type of file. 
  if(type.equals("image/jpeg") || type.equals("image/png") || type.equals("image/jpg") || type.equals("image/gif") || type.equals("image/bmp") )
      {
        final String fileName = FileName.getFileName(filePart);
      //copy the content of the file
        try {
            fout = new FileOutputStream(new File(path + File.separator + fileName));
            filecontent = filePart.getInputStream();
            int read = 0;
            final byte[] bytes = new byte[32*1024];

            while ((read =filecontent.read(bytes)) != -1) {
                fout.write(bytes, 0, read);
            }
            fout.flush();
            fout.close();
           
      out.write("\n");
      out.write("            \n");
      out.write("<!--           displayImage is the name of the servlet-->\n");
      out.write("<img src=\"displayImage/");
      out.print(fileName);
      out.write("\" height=\"300px;\" width=\"350px;\" />\n");
      out.write("           \n");
      out.write("           ");
 } catch (Exception e) {   
      out.write("\n");
      out.write("         <div style=\"font-size:30px; color:red\">File  is not successfully uploaded</div>\");\n");
      out.write("         \n");
      out.write("        ");
 } } else { 
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("         <div style=\"font-size:30px; color:red\">Please upload image(jpeg,jpg,gif,bmp,png) file only</div>\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("    </body>\n");
      out.write("    </html>\n");
      out.write("\n");
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
