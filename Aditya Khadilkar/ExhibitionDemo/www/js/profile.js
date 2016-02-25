function getprofile()
{
	//alert("getprofile");
	var request = createCORSRequest( "post", "http://exhibition.tekticks.co.in" );
	if(request)
	{
		var visitorId = localStorage.getItem("visitorId");
		var data = {"profile":[{"visitorId":visitorId}]};
		
		var getData = function(data)
		{
		//	alert(JSON.stringify(data));
		$.ajax({
		url:"http://exhibition.tekticks.co.in/application/json/retrivalProfile_json.php",
		type: 'POST',
		contentType: 'application/json',
		data: JSON.stringify(data),
		dataType:"json",
		success:function(response)
		{
					//$(".floating-label").hide();
					$("#pName").text(JSON.stringify(response.visitor[0].name).replace(/"/g,""));
					$("#pEmailId").text(JSON.stringify(response.visitor[0].emailId).replace(/"/g,""));
					$("#pMobileNo").text(JSON.stringify(response.visitor[0].mobileNo).replace(/"/g,""));
					//$("#pbirthdate").val(convertDate(JSON.stringify(response.visitor[0].dob).replace(/"/g,"")));
					
					//$("#pcity").val(JSON.stringify(response.visitor[0].city).replace(/"/g,""));
					
					//$("#pgender").val(JSON.stringify(response.visitor[0].gender).replace(/"/g,""));
					//alert(JSON.stringify(response.visitor[0].photoLink));
					//$("#profilePic").attr("src",JSON.stringify(response.visitor[0].photoLink).replace(/"/g,""));
					
					//var show = document.getElementById('profileShow');
					//show.style.visibility = 'visible';
					
		}
		});
		}
			getData(data);
	}
	
}


function sendprofile()
{
	var request = createCORSRequest( "post", "http://exhibition.tekticks.co.in" );
	if(request)
	{
		var visitorId = localStorage.getItem("visitorId");
		var data = {"profile":[{"visitorId":visitorId}]};
		
		var getData = function(data)
		{
		//	alert(JSON.stringify(data));
		$.ajax({
		url:"http://exhibition.tekticks.co.in/application/json/update_json.php",
		type: 'POST',
		contentType: 'application/json',
		data: JSON.stringify(data),
		dataType:"json",
		success:function(response)
		{
					$(".floating-label").hide();
					$("#pName").val(JSON.stringify(response.visitor[0].name).replace(/"/g,""));
					$("#pMobileNo").val(JSON.stringify(response.visitor[0].mobileNo).replace(/"/g,""));
					$("#pEmailId").val(JSON.stringify(response.visitor[0].emailId).replace(/"/g,""));
					
					//$("#pbirthdate").val(convertDate(JSON.stringify(response.visitor[0].dob).replace(/"/g,"")));
					
					//$("#pcity").val(JSON.stringify(response.visitor[0].city).replace(/"/g,""));
					
					//$("#pgender").val(JSON.stringify(response.visitor[0].gender).replace(/"/g,""));
					//alert(JSON.stringify(response.visitor[0].photoLink));
					//$("#profilePic").attr("src",JSON.stringify(response.visitor[0].photoLink).replace(/"/g,""));
					
					//var show = document.getElementById('profileShow');
					//show.style.visibility = 'visible';
					
					var a = document.getElementById('profileNext');
							a.setAttribute("href","profileEdit.html");
							document.getElementById('profileNext').click();
					
		}
		});
		}
			getData(data);
	}
	
}




 //function convertDate(dateString){
//var p = dateString.split(/\D/g)
//return [p[2],p[1],p[0] ].join("-")
//}

 /*function profile()
{ var show = document.getElementById('profileShow');
    show.style.visibility = 'visible';
	var pname = document.getElementById('pname').value;
	var pemail = document.getElementById('pemail').value;
	var pphone = document.getElementById('pphone').value;
	var pgender = document.getElementById('pgender').value;
	var pbirthdate = document.getElementById('pbirthdate').value;
	var pcity = document.getElementById('pcity').value;
	var visitorId = localStorage.getItem("visitorId");
	var request = createCORSRequest( "post", "http://socialworker.tekticks.co.in" );
	var fileName = upload();
	alert(fileName);
	if(request)
	{
	
	
		var data = {"profile":[{"visitorId":visitorId,"pname":pname,"pemail":pemail,"pphone":pphone,"pgender":pgender,"pbirthdate":pbirthdate,"pcity":pcity}]};
		var sendData = function(data)
		{
	$.ajax({
		url:"http://socialworker.tekticks.co.in/json/signupProfile_json.php",
		type: 'POST',
		contentType: 'application/json',
		data: JSON.stringify(data),
		dataType:"json",
		success:function(response)
		{
			/* if(JSON.stringify(response.status)==200) */
						/* {
	                        $("#mobileError").hide();
							$("#emailError").hide();
	
	                    } */
		/* else if(JSON.stringify(response.status)==202)
						{
							$("#mobileError").text(JSON.stringify(response.statusMessage).replace(/"/g,""));
							$("#mobileError").fadeIn();
						}
						else if(JSON.stringify(response.status)==203)
						{
							$("#emailError").text(JSON.stringify(response.statusMessage).replace(/"/g,""));
							$("#emailError").fadeIn();
						}
 */
		//}
	  
//});
		//} 
	//sendData(data);
	//console.log(data);

	
	//}
	//}
	
