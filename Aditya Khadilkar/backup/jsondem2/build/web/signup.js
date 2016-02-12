function signup()
{
   var request = createCORSRequest( "GET", "http://localhost:8080/jsondem/pass" );
    var name = document.getElementById('name').value;
    var mobileNo = document.getElementById('mobileNo').value;
    var emailId = document.getElementById('emailId').value;
    var password = document.getElementById('password').value;
    alert(name);
    alert(mobileNo);
    alert(emailId);
    alert(password);
    var data ={"name":name,"password":password,"mobileNo":mobileNo,"emailId":emailId};
    /*var obj = JSON.parse(data);*/
    /*obj['signUp'].push();*/
   /*data = JSON.stringify(obj);*/
	alert(JSON.stringify(data));
	var sendData = function(data){   
	alert(JSON.stringify(data));
      $.ajax({
     url:'http://localhost:8080/jsondem/pass',
     type: 'GET',
     contentType: 'application/json',
    data: JSON.stringify(data),
	success: function(response)
	{
             //JSON.parse(data);
           // alert("data parsed");
            //alert(data);
            alert('hieeeee');
            alert(response);
	},
        error: function(response)
        {
          alert('error'+response);
        }
});
};
sendData(data);
}


