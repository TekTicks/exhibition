function navi()
{
	
	profileReload();
	//document.getElementById("list1").style.paddingTop = "0px";
	var request = createCORSRequest( "post", "http://socialworker.tekticks.co.in" );
	if(request)
	{
		
		if(localStorage.getItem("visitorId") === null)
		{
			$("#signup").fadeIn();
			$("#signin").fadeIn();
			$("#profile").fadeOut();
						
		}
		else
		{
			$("#signup").fadeOut();
			$("#signin").fadeOut();
			$("#profile").fadeIn();	
		
		}
	}
}


/*function profileReload()
{	
var request = createCORSRequest( "post", "http://socialworker.tekticks.co.in" );
	if(request)
	{
var visitorId=localStorage.getItem("visitorId");
var data = {"profile":[{"visitorId":visitorId}]};
	var sendData = function(data)
	{
	$.ajax({
		url:"http://socialworker.tekticks.co.in/json/sw_visitor.php",
		dataType:"json",
		type: 'POST',
		data: JSON.stringify(data),
		contentType: 'application/json',
		success:function(response)
		{	
		if(JSON.stringify(response.status)==200)
			{ 
			
				var profileName= JSON.stringify(response.visitor.name).replace(/"/g,"");
			   var photoLink= JSON.stringify(response.visitor.photoLink).replace(/"/g,""); 
			   					
			 	if(photoLink=="null")
				{
					document.getElementById("profile1").style.backgroundImage='linear-gradient(rgba(0, 0, 0, 0.3),rgba(0, 0, 0, 0.8)),url(img/Profilelogo.png)';
					
				}
				else
				{
				document.getElementById("profile1").style.backgroundImage='linear-gradient(rgba(0, 0, 0, 0.3),rgba(0, 0, 0, 0.8)),url('+photoLink+')';
				}
		 
			$("#profileName").text(profileName);
			//$("#photoLink").attr("src",photoLink);
			localStorage.setItem("profileName", profileName);
			localStorage.setItem("profileImage", photoLink);
			
			}
		}
	});
	}
sendData(data);	
console.log(data);
	}
}
*/