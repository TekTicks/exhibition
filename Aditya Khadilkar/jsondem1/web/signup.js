function signup()
{
   var request = createCORSRequest( "get", "http://localhost:8080/jsondem/pass" );
    var name = document.getElementById('name').value;
    var mobileNo = document.getElementById('mobileNo').value;
    var emailId = document.getElementById('emailId').value;
    var password = document.getElementById('password').value;
    alert(name);
    alert(mobileNo);
    alert(emailId);
    alert(password);
    var data = {"signUp":[{"name":name,"password":password,"mobileNo":mobileNo,"emailId":emailId}]};
	alert(JSON.stringify(data));
	var sendData = function(data){   
	alert(JSON.stringify(data));
      $.ajax({
                type: 'GET',
                dataType: "json",
                url:'http://localhost:8080/jsondem/pass',
                contentType: 'application/json',
                data: JSON.stringify(data),
	success: function(response)
	{
             

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

