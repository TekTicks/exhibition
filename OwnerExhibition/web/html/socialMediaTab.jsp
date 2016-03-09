 <%@page import="ownerPortal.dbConnection"%>
<div class="tab-pane slide-left padding-20" id="tab2">
                    
                 
               <div class="container-fluid container-fixed-lg">
            <!-- START PANEL -->
            <div class="panel panel-transparent">
              <div class="panel-heading">
                <div class="panel-title">
                </div>
                <div class="pull-right">
                  <div class="col-xs-12">
                      <button id="show-modal" class="btn btn-primary btn-cons" onclick="document.location.href='/Exhibition/html/ownerProfileSocialMedia.jsp';"><i class="fa fa-plus"></i> Add 
                    </button>
                  </div>
                </div>
                <div class="clearfix"></div>
              </div>
              <div class="panel-body">
                  

               <table class="table table-hover demo-table-search" id="tableWithSearch">
                     <%@page import="java.io.*;" %>
                     <%@page import="java.sql.*;" %>
                     <%@page import="java.sql.DriverManager;" %>
                     <thead>
                        <tr>
                          <!--  <th>ID</th> -->
                        <th>Date</th>
                        <th>Social Media</th>        
                        <th>Link</th>
                        <th>Update/Delete.</th>
                        </tr>
                  </thead>
                  <tbody>
                    <%   
                         HttpSession ss=request.getSession();
                         String idd=(String)ss.getAttribute("ownerId");
                         Connection con1;
                         con1=dbConnection.getConnection();
                         Statement stat1=con1.createStatement();
                         ResultSet rs1=stat1.executeQuery("select a.*,b.* from socialMedia a,ownerSocialMedia b where a.id=b.socialMediaId and b.createdBy='"+idd+"'");
                         int count1=0;
                        
                         while(rs1.next())
                         {
                            count1++;
                            out.println("<tr>");
                            //out.println("<td class='v-align-middle semi-bold'><p>"+rs1.getString(7)+"</p></td>");
                            out.println("<td class='v-align-middle semi-bold'><p>"+rs1.getString(3)+"</p></td>");
                            out.println("<td class='v-align-middle semi-bold'><p>"+rs1.getString(2)+"</p></td>");
                            out.println("<td class='v-align-middle semi-bold'><p>"+rs1.getString(9)+"</p></td>");
                            //out.println("<td class='v-align-middle semi-bold'><p>"+rs1.getString(14)+"</p></td>");
                            String kv=rs1.getString(7);
                            String kv1=rs1.getString(2);
                            String kv2=rs1.getString(3);
                            String kv3=rs1.getString(9);
                            String kv4=rs1.getString(14);
                            
                             HttpSession ss1=request.getSession();
                                  ss1.setAttribute("id",kv);
                                  ss1.setAttribute("date",kv2);
                                  ss1.setAttribute("socialmedia1",kv1);
                                  ss1.setAttribute("link1",kv3);
                                  ss1.setAttribute("iconMediaId",kv4);
                                  
                            
                           %>
                          
                             <td>
                                 <div class="btn-group">
                                  <!-- passing id of ownerSocailMedia from url-->
                                 <button  type="button" class="btn btn-success" onclick="document.location.href='/Exhibition/html/ownerProfileSocialMediaEdit.jsp?myid=<%= kv %>';"><i class="fa fa-pencil"></i></button>
                                <button type="button" class="btn btn-success" data-toggle="modal" data-target="#confirm-delete" data-href="/Exhibition/OwnerProfileSocialMediaDelete?myid=<%=kv%>"><i class="fa fa-trash-o"></i>                                 </button>
                                 </div>
                            </td><%
                            out.println(" </tr>");
                        }
                       
                   %>   
                   </tbody>
                </table>
              </div>
            </div>
            <!-- END PANEL -->
          </div>
            
            
              <div class="padding-20 bg-white">
                  <ul class="pager wizard">
                    <li class="next">
                      <button class="btn btn-primary btn-cons btn-animated from-left fa fa-truck pull-right" type="button">
                        <span>Next</span>
                      </button>
                    </li>
                    <li class="next finish hidden">
                      <button class="btn btn-primary btn-cons btn-animated from-left fa fa-cog pull-right" type="button">
                        <span>Finish</span>
                      </button>
                    </li>
                    <li class="previous first hidden">
                      <button class="btn btn-default btn-cons btn-animated from-left fa fa-cog pull-right" type="button">
                        <span>First</span>
                      </button>
                    </li>
                    <li class="previous">
                      <button class="btn btn-default btn-cons pull-right" type="button">
                        <span>Previous</span>
                      </button>
                    </li>
                  </ul>
                </div>
                    
                </div>
                            