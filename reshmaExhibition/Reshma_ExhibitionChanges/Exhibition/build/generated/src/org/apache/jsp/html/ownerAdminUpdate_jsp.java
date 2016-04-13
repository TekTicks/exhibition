package org.apache.jsp.html;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ownerPortal.dbConnection;
import java.io.*;;
import java.sql.*;;
import java.sql.DriverManager;;
import java.util.Scanner.*;;

public final class ownerAdminUpdate_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write(" \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("  <head>\n");
      out.write(" \n");
      out.write("    <meta http-equiv=\"content-type\" content=\"text/html;charset=UTF-8\" />\n");
      out.write("    <meta charset=\"utf-8\" />\n");
      out.write("    <title>Owner Registration Page</title>\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\n");
      out.write("    <link rel=\"apple-touch-icon\" href=\"pages/ico/60.png\"> \n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"76x76\" href=\"pages/ico/76.png\">\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"120x120\" href=\"pages/ico/120.png\">\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"152x152\" href=\"pages/ico/152.png\"> \n");
      out.write("    <link rel=\"icon\" type=\"image/x-icon\" href=\"favicon.ico\" />\n");
      out.write("    <meta name=\"apple-mobile-web-app-capable\" content=\"yes\">\n");
      out.write("    <meta name=\"apple-mobile-web-app-status-bar-style\" content=\"default\">\n");
      out.write("    <meta content=\"\" name=\"description\" />\n");
      out.write("    <meta content=\"\" name=\"author\" />\n");
      out.write("    <link href=\"assets/plugins/pace/pace-theme-flash.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("    <link href=\"assets/plugins/boostrapv3/css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("    <link href=\"assets/plugins/font-awesome/css/font-awesome.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("    <link href=\"assets/plugins/jquery-scrollbar/jquery.scrollbar.css\" rel=\"stylesheet\" type=\"text/css\" media=\"screen\" />\n");
      out.write("    <link href=\"assets/plugins/bootstrap-select2/select2.css\" rel=\"stylesheet\" type=\"text/css\" media=\"screen\" />\n");
      out.write("    <link href=\"assets/plugins/switchery/css/switchery.min.css\" rel=\"stylesheet\" type=\"text/css\" media=\"screen\" />\n");
      out.write("    <link href=\"pages/css/pages-icons.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("    <link class=\"main-stylesheet\" href=\"pages/css/pages.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("    <link href=\"pages/css/ie9.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("    <link href=\"pages/css/ckvajax.css\" rel=\"stylesheet\" type=\"text/css\" />   \n");
      out.write("    <script type=\"text/javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js\"></script>\n");
      out.write("    <script src=\"pages/js/jquery-1.4.2.min.js\"></script>\n");
      out.write("    <script src=\"pages/js/ownerRegValidation.js\"></script>\n");
      out.write("  <!--  <script src=\"pages/js/ownerRegVerification.js\"></script> -->\n");
      out.write("    \n");
      out.write("   \n");
      out.write("    \n");
      out.write("\n");
      out.write("  </head>\n");
      out.write("  <body class=\"fixed-header \">\n");
      out.write("    <div class=\"register-container full-height sm-p-t-30\">\n");
      out.write("      <div class=\"container-sm-height full-height\">\n");
      out.write("        <div class=\"row row-sm-height\">\n");
      out.write("          <div class=\"col-sm-12 col-sm-height col-middle\">\n");
      out.write("           <h1><b> Add Administrator</h1>\n");
      out.write("           <h3>Pages makes it easy to enjoy what matters the most in your life</h3>\n");
      out.write("            \n");
      out.write("            <form name=\"login_frm\" action=\"/Exhibition/ownerAdminUpdate\" method=\"post\" id=\"login_frm\" class=\"p-t-15\"  >\n");
      out.write("            \n");
      out.write("                \n");
      out.write("                ");

                    try
                    {
                            //getting id of ownerAddress in url from ownerProfile
                            String id=request.getParameter("adminId");
                            //one time connection
                            Connection con;
                            con=dbConnection.getConnection();
                            Statement stat=con.createStatement();
                            ResultSet rs=stat.executeQuery("select * from exhibitionAdmin where id='"+id+"'");
                            while(rs.next())
                            {
                              String id1=rs.getString(1);
                              String exhibitionId=rs.getString(2);
                              String mobileNo=rs.getString(3);
                              String emailId=rs.getString(4);
                              String username=rs.getString(5);
                              String password=rs.getString(6);
                              //creating session of id of ownerAddress
                              
                
      out.write("\n");
      out.write("                            \n");
      out.write("                <div class=\"row\">\n");
      out.write("                 <div class=\"col-sm-12\">\n");
      out.write("                  <div class=\"form-group form-group-default\">\n");
      out.write("                    <label>Username</label>\n");
      out.write("                    <input type=\"text\" name=\"uname\" id=\"uname\" placeholder=\"\"  value=\"");
out.print(username);
      out.write("\" class=\"form-control\" required>\n");
      out.write("                    <div id=\"msgbox\"></div> \n");
      out.write("                  </div>\n");
      out.write("                 </div>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                <div class=\"row\">\n");
      out.write("                 <div class=\"col-sm-12\">\n");
      out.write("                  <div class=\"form-group form-group-default\">\n");
      out.write("                    <label>Email</label>\n");
      out.write("                    <input type=\"email\" name=\"email\" id=\"email\" value=\"");
out.print(emailId);
      out.write("\" placeholder=\"We will send loging details to you\" class=\"form-control\" required>\n");
      out.write("                     <div id=\"msgbox1\"></div> <div id=\"msgbox8\"></div>\n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("               </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-group form-group-default input-group\">\n");
      out.write("                    <span class=\"input-group-addon\">\n");
      out.write("                    <select class=\"cs-select cs-skin-slide cs-transparent\" id=\"prefix\" data-init-plugin=\"cs-select\">\n");
      out.write("                    <option data-countryCode=\"GB\" value=\"44\" Selected>UK (+44)</option>\n");
      out.write("                    <option data-countryCode=\"US\" value=\"1\">USA (+1)</option>\n");
      out.write("                    <option data-countryCode=\"AR\" value=\"54\">Argentina (+54)</option>\n");
      out.write("                    <option data-countryCode=\"AU\" value=\"61\">Australia (+61)</option>\n");
      out.write("                    <option data-countryCode=\"AT\" value=\"43\">Austria (+43)</option>\n");
      out.write("                    <option data-countryCode=\"BE\" value=\"32\">Belgium (+32)</option>\n");
      out.write("                    <option data-countryCode=\"BZ\" value=\"501\">Belize (+501)</option>\n");
      out.write("                    <option data-countryCode=\"CN\" value=\"86\">China (+86)</option>\n");
      out.write("                    <option data-countryCode=\"IN\" value=\"91\">India (+91)</option>\n");
      out.write("                    <option data-countryCode=\"MY\" value=\"60\">Malaysia (+60)</option>\n");
      out.write("                    <option data-countryCode=\"ZW\" value=\"263\">Zimbabwe (+263)</option>\n");
      out.write("                    </select>\n");
      out.write("                    </span>\n");
      out.write("                    <label>Contact Number</label>\n");
      out.write("                    <input type=\"tel\" name=\"phone\" id=\"phone\" value=\"");
out.print(mobileNo);
      out.write("\" maxlength=\"10\" minlength=\"10\" class=\"form-control\" placeholder=\"\" required>\n");
      out.write("                </div><div id=\"msgbox2\"></div><div id=\"msgbox3\"></div><div id=\"msgbox6\"></div><div id=\"msgbox7\"></div><div id=\"msgbox13\"></div>\n");
      out.write("\n");
      out.write("                                \n");
      out.write("                <div class=\"row\">\n");
      out.write("                 <div class=\"col-sm-12\">\n");
      out.write("                  <div class=\"form-group form-group-default\">\n");
      out.write("                    <label>Password</label>\n");
      out.write("                    <input type=\"text\" name=\"password\" id=\"password\" value=\"");
out.print(password);
      out.write("\" placeholder=\"Minimum of 6 Charactors\" minlength=\"6\" class=\"form-control\" required>\n");
      out.write("                  <div id=\"msgbox9\"></div>\n");
      out.write("                  </div>\n");
      out.write("                 </div>\n");
      out.write("                </div>\n");
      out.write("                ");
      } 
                    }
                catch(Exception e)
                {
                out.print(e);
                 }
                
      out.write("\n");
      out.write("            \n");
      out.write("                <div class=\"form-group form-group-default required\">\n");
      out.write("                     \n");
      out.write("                     \n");
      out.write("                     \n");
      out.write("                     \n");
      out.write("                     ");
   
                       HttpSession ss1=request.getSession();
                       //getting id of ownerAddress in url from ownerProfile
                       String id=request.getParameter("adminId");
                       HttpSession ss=request.getSession();
                       ss.setAttribute("ownerAddId",id);
                       Connection con1;
                       con1=dbConnection.getConnection();
                       Statement stat1=con1.createStatement();
                       ResultSet rs1=stat1.executeQuery("select a.*,b.* from exhibition a, exhibitionAdmin b where a.id=b.exhibitionId and b.id='"+id+"'");
                         
                     
      out.write("   \n");
      out.write("                     \n");
      out.write("                        <label>Exhibition</label>\n");
      out.write("                        <select class=\"full-width\" name=\"exhibitionName\" id=\"socialmedia\"  data-init-plugin=\"select2\">\n");
      out.write("                         ");

                         while(rs1.next())
                         {
                           String sm=rs1.getString(2);
                           String ide=rs1.getString(1);
                           ss1.setAttribute("id",ide);              //value="<%=sm 
      out.write("\"\n");
      out.write("                        %>  \n");
      out.write("                             <optgroup label=''><option  >");
      out.print(sm );
      out.write("</option></optgroup>\n");
      out.write("                             ");
 } 
      out.write("\n");
      out.write("                             \n");
      out.write("                           <optgroup label=\"Select Exhibition :\">\n");
      out.write("                               ");
     
                                   Connection con2;
                                   con2=dbConnection.getConnection();
                                   Statement stat2=con2.createStatement();
                                   ResultSet rs2=stat2.executeQuery("select a.*,b.* from exhibitionAdmin a,exhibition b where a.id='"+id+"'");
                                   //ResultSet rs2=stat2.executeQuery("select * from exhibitionAdmin");
                               
      out.write("      \n");
      out.write("                               ");
 while(rs2.next())
                                { 
                               
      out.write("\n");
      out.write("                               <option value=\"");
out.print(rs2.getString(13));
      out.write('"');
      out.write('>');
out.print(rs2.getString(14));
      out.write("</option>\n");
      out.write("                               ");
 
                                 }
                               
      out.write("  </optgroup> \n");
      out.write("                              \n");
      out.write("                        </select>\n");
      out.write("                     <div id=\"msgbox4\"></div>\n");
      out.write("                            </div> \n");
      out.write("              <br>\n");
      out.write("              \n");
      out.write("              \n");
      out.write("              \n");
      out.write("              \n");
      out.write("              \n");
      out.write("              \n");
      out.write("              \n");
      out.write("              \n");
      out.write("              \n");
      out.write("              \n");
      out.write("              \n");
      out.write("              \n");
      out.write("              \n");
      out.write("              \n");
      out.write("              \n");
      out.write("                      \n");
      out.write("              \n");
      out.write("              \n");
      out.write("              \n");
      out.write("              \n");
      out.write("                 \n");
      out.write("                <button class=\"btn btn-primary btn-cons m-t-10\" type=\"submit\">Submit</button>\n");
      out.write("                <button class=\"btn btn-primary btn-cons m-t-10\" type=\"button\" onclick=\"document.location.href='/Exhibition/html/ownerAdministrator.jsp'\">Cancel</button> \n");
      out.write("              \n");
      out.write("                 \n");
      out.write("  \n");
      out.write("                <input type=\"hidden\" name=\"country\"  id=\"abc\" >\n");
      out.write("            </form>\n");
      out.write("                               \n");
      out.write("              \n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("      \n");
      out.write("      \n");
      out.write("<!--*******************************************************Template Content ***********************************************************-->      \n");
      out.write("    <div class=\" full-width\">\n");
      out.write("      <div class=\"register-container m-b-10 clearfix\">\n");
      out.write("        <div class=\"inline pull-left\">\n");
      out.write("          <img src=\"assets/img/demo/pages_icon.png\" alt=\"\" class=\"m-t-5 \" data-src=\"assets/img/demo/pages_icon.png\" data-src-retina=\"assets/img/demo/pages_icon_2x.png\" width=\"60\" height=\"60\">\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-md-10 m-t-15\">\n");
      out.write("          <p class=\"hinted-text small inline \">No part of this website or any of its contents may be reproduced, copied, modified or adapted, without the prior written consent of the author, unless otherwise indicated for stand-alone materials.</p>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <!-- START OVERLAY -->\n");
      out.write("    <div class=\"overlay hide\" data-pages=\"search\">\n");
      out.write("      <!-- BEGIN Overlay Content !-->\n");
      out.write("      <div class=\"overlay-content has-results m-t-20\">\n");
      out.write("        <!-- BEGIN Overlay Header !-->\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("          <!-- BEGIN Overlay Logo !-->\n");
      out.write("          <img class=\"overlay-brand\" src=\"assets/img/logo.png\" alt=\"logo\" data-src=\"assets/img/logo.png\" data-src-retina=\"assets/img/logo_2x.png\" width=\"78\" height=\"22\">\n");
      out.write("          <!-- END Overlay Logo !-->\n");
      out.write("          <!-- BEGIN Overlay Close !-->\n");
      out.write("          <a href=\"#\" class=\"close-icon-light overlay-close text-black fs-16\">\n");
      out.write("            <i class=\"pg-close\"></i>\n");
      out.write("          </a>\n");
      out.write("          <!-- END Overlay Close !-->\n");
      out.write("        </div>\n");
      out.write("        <!-- END Overlay Header !-->\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("          <!-- BEGIN Overlay Controls !-->\n");
      out.write("          <input id=\"overlay-search\" class=\"no-border overlay-search bg-transparent\" placeholder=\"Search...\" autocomplete=\"off\" spellcheck=\"false\">\n");
      out.write("          <br>\n");
      out.write("          <div class=\"inline-block\">\n");
      out.write("            <div class=\"checkbox right\">\n");
      out.write("              <input id=\"checkboxn\" type=\"checkbox\" value=\"1\" checked=\"checked\">\n");
      out.write("              <label for=\"checkboxn\"><i class=\"fa fa-search\"></i> Search within page</label>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"inline-block m-l-10\">\n");
      out.write("            <p class=\"fs-13\">Press enter to search</p>\n");
      out.write("          </div>\n");
      out.write("          <!-- END Overlay Controls !-->\n");
      out.write("        </div>\n");
      out.write("        <!-- BEGIN Overlay Search Results, This part is for demo purpose, you can add anything you like !-->\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("          <span>\n");
      out.write("                <strong>suggestions :</strong>\n");
      out.write("            </span>\n");
      out.write("          <span id=\"overlay-suggestions\"></span>\n");
      out.write("          <br>\n");
      out.write("          <div class=\"search-results m-t-40\">\n");
      out.write("            <p class=\"bold\">Pages Search Results</p>\n");
      out.write("            <div class=\"row\">\n");
      out.write("              <div class=\"col-md-6\">\n");
      out.write("                <!-- BEGIN Search Result Item !-->\n");
      out.write("                <div class=\"\">\n");
      out.write("                  <!-- BEGIN Search Result Item Thumbnail !-->\n");
      out.write("                  <div class=\"thumbnail-wrapper d48 circular bg-success text-white inline m-t-10\">\n");
      out.write("                    <div>\n");
      out.write("                      <img width=\"50\" height=\"50\" src=\"assets/img/profiles/avatar.jpg\" data-src=\"assets/img/profiles/avatar.jpg\" data-src-retina=\"assets/img/profiles/avatar2x.jpg\" alt=\"\">\n");
      out.write("                    </div>\n");
      out.write("                  </div>\n");
      out.write("                  <!-- END Search Result Item Thumbnail !-->\n");
      out.write("                  <div class=\"p-l-10 inline p-t-5\">\n");
      out.write("                    <h5 class=\"m-b-5\"><span class=\"semi-bold result-name\">ice cream</span> on pages</h5>\n");
      out.write("                    <p class=\"hint-text\">via john smith</p>\n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("                <!-- END Search Result Item !-->\n");
      out.write("                <!-- BEGIN Search Result Item !-->\n");
      out.write("                <div class=\"\">\n");
      out.write("                  <!-- BEGIN Search Result Item Thumbnail !-->\n");
      out.write("                  <div class=\"thumbnail-wrapper d48 circular bg-success text-white inline m-t-10\">\n");
      out.write("                    <div>T</div>\n");
      out.write("                  </div>\n");
      out.write("                  <!-- END Search Result Item Thumbnail !-->\n");
      out.write("                  <div class=\"p-l-10 inline p-t-5\">\n");
      out.write("                    <h5 class=\"m-b-5\"><span class=\"semi-bold result-name\">ice cream</span> related topics</h5>\n");
      out.write("                    <p class=\"hint-text\">via pages</p>\n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("                <!-- END Search Result Item !-->\n");
      out.write("                <!-- BEGIN Search Result Item !-->\n");
      out.write("                <div class=\"\">\n");
      out.write("                  <!-- BEGIN Search Result Item Thumbnail !-->\n");
      out.write("                  <div class=\"thumbnail-wrapper d48 circular bg-success text-white inline m-t-10\">\n");
      out.write("                    <div><i class=\"fa fa-headphones large-text \"></i>\n");
      out.write("                    </div>\n");
      out.write("                  </div>\n");
      out.write("                  <!-- END Search Result Item Thumbnail !-->\n");
      out.write("                  <div class=\"p-l-10 inline p-t-5\">\n");
      out.write("                    <h5 class=\"m-b-5\"><span class=\"semi-bold result-name\">ice cream</span> music</h5>\n");
      out.write("                    <p class=\"hint-text\">via pagesmix</p>\n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("                <!-- END Search Result Item !-->\n");
      out.write("              </div>\n");
      out.write("              <div class=\"col-md-6\">\n");
      out.write("                <!-- BEGIN Search Result Item !-->\n");
      out.write("                <div class=\"\">\n");
      out.write("                  <!-- BEGIN Search Result Item Thumbnail !-->\n");
      out.write("                  <div class=\"thumbnail-wrapper d48 circular bg-info text-white inline m-t-10\">\n");
      out.write("                    <div><i class=\"fa fa-facebook large-text \"></i>\n");
      out.write("                    </div>\n");
      out.write("                  </div>\n");
      out.write("                  <!-- END Search Result Item Thumbnail !-->\n");
      out.write("                  <div class=\"p-l-10 inline p-t-5\">\n");
      out.write("                    <h5 class=\"m-b-5\"><span class=\"semi-bold result-name\">ice cream</span> on facebook</h5>\n");
      out.write("                    <p class=\"hint-text\">via facebook</p>\n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("                <!-- END Search Result Item !-->\n");
      out.write("                <!-- BEGIN Search Result Item !-->\n");
      out.write("                <div class=\"\">\n");
      out.write("                  <!-- BEGIN Search Result Item Thumbnail !-->\n");
      out.write("                  <div class=\"thumbnail-wrapper d48 circular bg-complete text-white inline m-t-10\">\n");
      out.write("                    <div><i class=\"fa fa-twitter large-text \"></i>\n");
      out.write("                    </div>\n");
      out.write("                  </div>\n");
      out.write("                  <!-- END Search Result Item Thumbnail !-->\n");
      out.write("                  <div class=\"p-l-10 inline p-t-5\">\n");
      out.write("                    <h5 class=\"m-b-5\">Tweats on<span class=\"semi-bold result-name\"> ice cream</span></h5>\n");
      out.write("                    <p class=\"hint-text\">via twitter</p>\n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("                <!-- END Search Result Item !-->\n");
      out.write("                <!-- BEGIN Search Result Item !-->\n");
      out.write("                <div class=\"\">\n");
      out.write("                  <!-- BEGIN Search Result Item Thumbnail !-->\n");
      out.write("                  <div class=\"thumbnail-wrapper d48 circular text-white bg-danger inline m-t-10\">\n");
      out.write("                    <div><i class=\"fa fa-google-plus large-text \"></i>\n");
      out.write("                    </div>\n");
      out.write("                  </div>\n");
      out.write("                  <!-- END Search Result Item Thumbnail !-->\n");
      out.write("                  <div class=\"p-l-10 inline p-t-5\">\n");
      out.write("                    <h5 class=\"m-b-5\">Circles on<span class=\"semi-bold result-name\"> ice cream</span></h5>\n");
      out.write("                    <p class=\"hint-text\">via google plus</p>\n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("                <!-- END Search Result Item !-->\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- END Overlay Search Results !-->\n");
      out.write("      </div>\n");
      out.write("      <!-- END Overlay Content !-->\n");
      out.write("    </div>\n");
      out.write("    <!-- END OVERLAY -->\n");
      out.write("    <!-- BEGIN VENDOR JS -->\n");
      out.write("    <script src=\"assets/plugins/pace/pace.min.js\" type=\"text/javascript\"></script>\n");
      out.write("    <script src=\"assets/plugins/jquery/jquery-1.11.1.min.js\" type=\"text/javascript\"></script>\n");
      out.write("    <script src=\"assets/plugins/modernizr.custom.js\" type=\"text/javascript\"></script>\n");
      out.write("    <script src=\"assets/plugins/jquery-ui/jquery-ui.min.js\" type=\"text/javascript\"></script>\n");
      out.write("    <script src=\"assets/plugins/boostrapv3/js/bootstrap.min.js\" type=\"text/javascript\"></script>\n");
      out.write("    <script src=\"assets/plugins/jquery/jquery-easy.js\" type=\"text/javascript\"></script>\n");
      out.write("    <script src=\"assets/plugins/jquery-unveil/jquery.unveil.min.js\" type=\"text/javascript\"></script>\n");
      out.write("    <script src=\"assets/plugins/jquery-bez/jquery.bez.min.js\"></script>\n");
      out.write("    <script src=\"assets/plugins/jquery-ios-list/jquery.ioslist.min.js\" type=\"text/javascript\"></script>\n");
      out.write("    <script src=\"assets/plugins/jquery-actual/jquery.actual.min.js\"></script>\n");
      out.write("    <script src=\"assets/plugins/jquery-scrollbar/jquery.scrollbar.min.js\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"assets/plugins/bootstrap-select2/select2.min.js\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"assets/plugins/classie/classie.js\"></script>\n");
      out.write("    <script src=\"assets/plugins/switchery/js/switchery.min.js\" type=\"text/javascript\"></script>\n");
      out.write("    <script src=\"assets/plugins/jquery-validation/js/jquery.validate.min.js\" type=\"text/javascript\"></script>\n");
      out.write("    <!-- END VENDOR JS -->\n");
      out.write("    <script src=\"pages/js/pages.min.js\"></script>\n");
      out.write("   \n");
      out.write("  </body>\n");
      out.write("</html>\n");
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
