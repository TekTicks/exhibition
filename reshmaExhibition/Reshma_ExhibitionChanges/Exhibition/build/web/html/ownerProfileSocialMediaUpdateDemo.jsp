<%@page import="ownerPortal.dbConnection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.io.File" %>
<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@ page import="org.apache.commons.fileupload.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="org.apache.commons.io.FilenameUtils"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@ page import="java.io.*,java.sql.*,java.util.zip.*" %>

<center><h1>Your  Profile has been Uploaded</h1></center>
<%    
    
    String socialmedialink = "";
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
                String link1 = item.getFieldName();
                String value = item.getString();
                if (link1.equals("socialmedialink")) 
                {
                    socialmedialink = value;
                    count1 = 1;
                }
            } 
            else
            {
                try 
                {
                    String itemName = item.getName();
                    File savedFile = new File("E:/exhibitionMain/web/html/images/" + itemName);
                    item.write(savedFile);
                    if (count1 == 1) 
                    {
                        HttpSession ss=request.getSession();
                        ss.setAttribute("fileName",itemName);   
                        out.println("<tr><td align='left'><b>Name:</td><td><b>" + socialmedialink);
                    }
                } 
                catch (Exception e) 
                {
                    e.printStackTrace();
                }
            }
        }
        Connection con1;
        con1=dbConnection.getConnection();
        PreparedStatement psmnt = null;
        try
        {
            HttpSession ss=request.getSession();
            String fileName=(String)ss.getAttribute("fileName");
            String logId=(String)ss.getAttribute("logoMedia");
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
                ss.setAttribute("logoMediaID12",logoMediaID);
            }
                String ID12=(String)ss.getAttribute("logoMediaID12");
                String id=(String)ss.getAttribute("id1");

            Connection con;
            con=dbConnection.getConnection();
            PreparedStatement ps=con.prepareStatement("update ownerSocialMedia set link=?,iconMediaId=? where id='"+id+"' ");
            ps.setString(1, socialmedialink);
            ps.setString(2,ID12);
            ps.executeUpdate();
            response.sendRedirect("/Exhibition/html/ownerProfile.jsp");
        }
        catch(Exception e)
        {
              response.sendRedirect("/Exhibition/html/404.html");
              //out.println("error"+e.toString());
        }
    }

%>

