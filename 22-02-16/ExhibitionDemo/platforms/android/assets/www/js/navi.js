function navi()
	{
	profileReload();
	var request = createCORSRequest( "post", "http://socialworker.tekticks.co.in" );
	if(request)
	{
	$.ajax({
		url:"http://socialworker.tekticks.co.in/json/sw_newsSlider_json.php",
		dataType:"json",
		contentType: 'application/json',
		success:function(data)
		{
			var n=Object.keys(data.newsInformation).length;
		var newsid = []; // create array here
		$.each(data.newsInformation, function (index, newsInformation) {
        newsid.push(newsInformation.id); //push values here
		});
				var newsTitle = []; // create array here
		$.each(data.newsInformation, function (index, newsInformation) {
        newsTitle.push(newsInformation.newsTitle); //push values here
		});
		
		var imageLink = []; // create array here
		$.each(data.newsInformation, function (index, newsInformation) {
        imageLink.push(newsInformation.imageLink); //push values here
		});
		 
		 for (var i = 0; i < n; i++)
				{	
				localStorage.setItem("newsId"+i,JSON.stringify(newsid[i]).replace(/"/g,"")); 
				localStorage.setItem("imageLink"+i,JSON.stringify(imageLink[i]).replace(/"/g,"")); 
				localStorage.setItem("newsTitle"+i,JSON.stringify(newsTitle[i]).replace(/"/g,"")); 
					
				}
		 var divId = "divNews";
				jQuery(divId).ready(function() {
					localNews();  
					});
					
	}});
	}
//		alert("navi");
		if(localStorage.getItem("visitorId") === null)
		{
			$("#signup").fadeIn();
			$("#signin").fadeIn();
			$("#Profile").fadeOut();				
		}
		else
		{
			$("#signup").fadeOut();
			$("#signin").fadeOut();
			$("#Profile").fadeIn();	
			
		}
	}
