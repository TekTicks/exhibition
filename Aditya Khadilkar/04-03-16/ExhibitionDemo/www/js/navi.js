function navi()
{
	localStorage.clear();
	
	var request = createCORSRequest( "post", "http://exhibition.tekticks.co.in" );
	if(request)
	{
		
		if(localStorage.getItem("visitorId") === null)
		{
			$("#signup").fadeIn();
			$("#signin").fadeIn();
			$("#profile").fadeOut();
			document.getElementById("list1").style.marginTop = "0px";			
		}
		else
		{
			$("#signup").fadeOut();
			$("#signin").fadeOut();
			$("#profile").fadeIn();	
		
		}
	}
	//profileReload();
}


function profileReload()
{	
var request = createCORSRequest( "post", "http://exhibition.tekticks.co.in" );
	if(request)
	{
var visitorId=localStorage.getItem("visitorId");
var data = {"profile":[{"visitorId":visitorId}]};
	var sendData = function(data)
	{
	$.ajax({
		url:"http://exhibition.tekticks.co.in/application/json/sw_visitor.php",
		dataType:"json",
		type: 'POST',
		data: JSON.stringify(data),
		contentType: 'application/json',
		success:function(response)
		{	
		if(JSON.stringify(response.status)==200)
			{ 
			
				var profileName= JSON.stringify(response.visitor.name).replace(/"/g,"");
			   var profilePic= JSON.stringify(response.visitor.profilePic).replace(/"/g,""); 
			   					
			 	if(profilePic=="null")
				{
					document.getElementById("profilePic").style.backgroundImage='linear-gradient(rgba(0, 0, 0, 0.3),rgba(0, 0, 0, 0.8)),url(img/Profilelogo.png)';
					
				}
				else
				{
				document.getElementById("profilePic").style.backgroundImage='linear-gradient(rgba(0, 0, 0, 0.3),rgba(0, 0, 0, 0.8)),url("data:image/(png|jpg);base64,'+profilePic+'")';
				}
		 
			$("#profileName").text(profileName);
			//$("#profilePic").attr("src",profilePic);
			localStorage.setItem("profileName", profileName);
			localStorage.setItem("profileImage", profilePic);
			
			}
		}
	});
	}
sendData(data);	
//console.log(data);
	}
}
