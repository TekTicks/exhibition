package org.apache.jsp.html;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.util.Iterator;
import java.io.File;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.*;

public final class employee_005fupload_005fprofile_005fimage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("   \n");
      out.write("   \n");
      out.write("   \n");
      out.write("   \n");
      out.write("   \n");
      out.write(" \n");
      out.write("        <center><h1>Your  Profile has been Uploaded</h1></center>\n");
      out.write("  \n");
      out.write(" ");

 boolean isMultipart = ServletFileUpload.isMultipartContent(request);
 if (!isMultipart) {
 } else {
   FileItemFactory factory = new DiskFileItemFactory();
   ServletFileUpload upload = new ServletFileUpload(factory);
   List items = null;
   try {
   items = upload.parseRequest(request);
   } catch (FileUploadException e) {
   e.printStackTrace();
   }
   Iterator itr = items.iterator();
   while (itr.hasNext()) 
	   {
   FileItem item = (FileItem) itr.next();
   if (item.isFormField())
	   {
	 } else
	   {
    try {
	   String itemName = item.getName();
           out.print(itemName);
   File savedFile = new File(config.getServletContext().getRealPath("/")
+"emp_image\\image\\"+itemName);
   item.write(savedFile);
     
      out.write("<center></table><table ><tr><td width=\"210\"></td><td> <img  border=\"2\"\n");
      out.write(" src=image/");
      out.print(itemName );
      out.write(" width=\"137\"  height=\"140\"></td></tr></table><table\n");
      out.write(" border=\"2\" width=\"350\">\n");
      out.write("      ");
 
   } catch (Exception e) {
   e.printStackTrace();
   }
   }
   }
   }
   
      out.write("\n");
      out.write("     </td></tr></table></center>");
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
