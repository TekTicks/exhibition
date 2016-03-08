
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 
<html>      
<head>
   
     <meta http-equiv="content-type" content="text/html;charset=UTF-8" />
    <meta charset="utf-8" />
    <title>Pages - Admin Dashboard UI Kit - Blank Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no, shrink-to-fit=no" />
    <link rel="apple-touch-icon" href="pages/ico/60.png">
    <link rel="apple-touch-icon" sizes="76x76" href="pages/ico/76.png">
    <link rel="apple-touch-icon" sizes="120x120" href="pages/ico/120.png">
    <link rel="apple-touch-icon" sizes="152x152" href="pages/ico/152.png">
    <link rel="icon" type="image/x-icon" href="favicon.ico" />
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-touch-fullscreen" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="default">
    <meta content="" name="description" />
    <meta content="" name="author" />
    <link href="assets/plugins/pace/pace-theme-flash.css" rel="stylesheet" type="text/css" />
    <link href="assets/plugins/boostrapv3/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="assets/plugins/font-awesome/css/font-awesome.css" rel="stylesheet" type="text/css" />
    <link href="assets/plugins/jquery-scrollbar/jquery.scrollbar.css" rel="stylesheet" type="text/css" media="screen" />
    <link href="assets/plugins/bootstrap-select2/select2.css" rel="stylesheet" type="text/css" media="screen" />
    <link href="assets/plugins/switchery/css/switchery.min.css" rel="stylesheet" type="text/css" media="screen" />
    <link href="assets/plugins/jquery-datatable/media/css/dataTables.bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="assets/plugins/jquery-datatable/extensions/FixedColumns/css/dataTables.fixedColumns.min.css" rel="stylesheet" type="text/css" />
    <link href="assets/plugins/datatables-responsive/css/datatables.responsive.css" rel="stylesheet" type="text/css" media="screen" />
    <link href="pages/css/pages-icons.css" rel="stylesheet" type="text/css">
    <link class="main-stylesheet" href="pages/css/pages.css" rel="stylesheet" type="text/css" />
    
       
  
      <script data-require="jquery@*" data-semver="2.0.3" src="http://code.jquery.com/jquery-2.0.3.min.js"></script>
    <script data-require="bootstrap@*" data-semver="3.1.1" src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    <link data-require="bootstrap-css@3.1.1" data-semver="3.1.1" rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" />
    <link rel="stylesheet" href="style.css" />
    <script src="script.js"></script>
     <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="pages/js/jquery-1.4.2.min.js"></script>
 <script type="text/javascript">
	$(document).ready(function(){
		$("#login").submit(function(){
                 //remove previous class and add new "myinfo" class
	        // $("#msgbox").removeClass().addClass('myinfo').text('Validating Your Login ').fadeIn(1000);
			this.timer = setTimeout(function () {
				$.ajax({
		          	url: '/Exhibition/exhibitionAdministratorFacilities',
		          	data: 'exId=' + $('#exId').val() +'&title=' + $('#title').val() +'&description=' + $('#description').val(),
		          	type: 'post',
		   		success: function(msg){
                                  alert(msg);
                                if(msg != 'error') // Message Sent, check and redirect
				{
                                        if(msg !='wrn')
                                        {
                                          $("#msgbox1").html('data inserted').addClass('myinfo').fadeTo(200,1,function()
			             {
			                 //redirect to secure page
			              //document.location='/Exhibition/html/exhibitionAdminPersonal.jsp';
			             });  
                                    }
                                else
                                {
                                    $("#msgbox2").fadeTo(100,1,function() //start fading the messagebox
		                {
			                  //add message and change the class of the box and start fading
			                 $(this).html('records are not inserted..').removeClass().addClass('myerror').fadeTo(300,1);
                                        // document.location='/Exhibition/html/exhibitionAdminLog.jsp?user';
                                 });
                                }
                            }
                            else
                            {
                                $("#msgbox2").fadeTo(100,1,function() //start fading the messagebox
		                {
			                  //add message and change the class of the box and start fading
			                 $(this).html('sorry').removeClass().addClass('myerror').fadeTo(300,1);
                                        // document.location='/Exhibition/html/exhibitionAdminLog.jsp?user';
                                 });
                            }
                                }
				});
			}, 200);
			return false;
 		});		

	});
   </script> 
     <style>
#exists{display:none}
#cross{display:none}
.myinfo
{
	margin: 5px auto;
	background:#d6e3f5;
	border: 1px #0010ac solid;
	padding:5px;
	color:#0010ac;
	font-size:12px;
	width:350px;
	min-height:0px;
	-moz-border-radius:4px;
	-webkit-border-radius:4px;
	text-align: center;
}

.myerror
{
	margin: 5px auto;
	background:#FFDFDF;
	border: 1px #FF0000 solid;
	padding:5px;
	color:#FF0000;
	font-size:12px;
	width:350px;
	min-height:0px;
	-moz-border-radius:4px;
	-webkit-border-radius:4px;
	text-align: center;
}
</style>
</head>
<body>
<div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
            
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">Confirm Delete</h4>
                </div>
            
                <div class="modal-body">
                    <p>You are about to delete one track, this procedure is irreversible.</p>
                    <p>Do you want to proceed?</p>
                    <p class="debug-url"></p>
                </div>
                
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-danger btn-ok">Delete</a>
                </div>
            </div>
        </div>
    </div>
                     <%@page import="javax.servlet.*" %>
                     <%@page import="java.io.*" %>
                     <%@page import="java.sql.*" %>
                     <%@page import="java.sql.DriverManager"%>
                   
                     <%  
                         Class.forName("com.mysql.jdbc.Driver"); 
                         java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exhibition","root","123"); 
                         Statement stat=con.createStatement();
                         ResultSet rs=stat.executeQuery("select * from exhibitionAdmin");
                         
                     %>   
                       
                          
                     <%
                         while(rs.next())
                         {
                              String cid=rs.getString("id");
                             String fname = rs.getString("username"); 
                     %>
                            
                      <a href="#" data-href="/web/delete?id=<%=cid%>" data-toggle="modal" data-target="#confirm-delete">Delete record </a><br>  
                     <%
                         }
                     %>
                     



  
   
   
    <script>
        $('#confirm-delete').on('show.bs.modal', function(e) {
            $(this).find('.btn-ok').attr('href', $(e.relatedTarget).data('href'));
            
            $('.debug-url').html('Delete URL: <strong>' + $(this).find('.btn-ok').attr('href') + '</strong>');
        });
    </script>
</body>
   <script data-require="jquery@*" data-semver="2.0.3" src="http://code.jquery.com/jquery-2.0.3.min.js"></script>
    <script data-require="bootstrap@*" data-semver="3.1.1" src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    <link data-require="bootstrap-css@3.1.1" data-semver="3.1.1" rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" />
    <link rel="stylesheet" href="style.css" />
    <script src="script.js"></script>
 <script src="assets/plugins/pace/pace.min.js" type="text/javascript"></script>
    <script src="assets/plugins/jquery/jquery-1.11.1.min.js" type="text/javascript"></script>
    <script src="assets/plugins/modernizr.custom.js" type="text/javascript"></script>
    <script src="assets/plugins/jquery-ui/jquery-ui.min.js" type="text/javascript"></script>
    <script src="assets/plugins/boostrapv3/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="assets/plugins/jquery/jquery-easy.js" type="text/javascript"></script>
    <script src="assets/plugins/jquery-unveil/jquery.unveil.min.js" type="text/javascript"></script>
    <script src="assets/plugins/jquery-bez/jquery.bez.min.js"></script>
    <script src="assets/plugins/jquery-ios-list/jquery.ioslist.min.js" type="text/javascript"></script>
    <script src="assets/plugins/jquery-actual/jquery.actual.min.js"></script>
    <script src="assets/plugins/jquery-scrollbar/jquery.scrollbar.min.js"></script>
    <script type="text/javascript" src="assets/plugins/bootstrap-select2/select2.min.js"></script>
    <script type="text/javascript" src="assets/plugins/classie/classie.js"></script>
    <script src="assets/plugins/switchery/js/switchery.min.js" type="text/javascript"></script>
    <script src="assets/plugins/jquery-datatable/media/js/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="assets/plugins/jquery-datatable/extensions/TableTools/js/dataTables.tableTools.min.js" type="text/javascript"></script>
    <script src="assets/plugins/jquery-datatable/media/js/dataTables.bootstrap.js" type="text/javascript"></script>
    <script src="assets/plugins/jquery-datatable/extensions/Bootstrap/jquery-datatable-bootstrap.js" type="text/javascript"></script>
    <script type="text/javascript" src="assets/plugins/datatables-responsive/js/datatables.responsive.js"></script>
    <script type="text/javascript" src="assets/plugins/datatables-responsive/js/lodash.min.js"></script>
    <!-- END VENDOR JS -->
    <!-- BEGIN CORE TEMPLATE JS -->
    <script src="pages/js/pages.min.js"></script>
    <!-- END CORE TEMPLATE JS -->
    <!-- BEGIN PAGE LEVEL JS -->
    <script src="assets/js/datatables.js" type="text/javascript"></script>
    <script src="assets/js/scripts.js" type="text/javascript"></script>
</html>
       