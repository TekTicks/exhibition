function signup()
{
   /*var request = createCORSRequest( 'post', 'http://localhost:8080/JSONClean/pass');*/
    var name = document.getElementById('name').value;
    var mobileNo = document.getElementById('mobileNo').value;
    var emailId = document.getElementById('emailId').value;
    var password = document.getElementById('password').value;
    alert(name);
    alert(mobileNo);
    alert(emailId);
    alert(password);
    var data ={
        "name" : name,
        "password" : password,
        "mobileNo" : mobileNo,
        "emailId" : emailId
    };
    /*var obj = JSON.parse(data);*/
    /*obj['signUp'].push();*/
   /*data = JSON.stringify(obj);*/
	
	var sendData = function(data){   
	alert("sending: "+JSON.stringify(data));
      $.ajax({
     url:'http://localhost:8080/JSONClean/pass',
     type: 'POST',
     contentType: 'application/json',
    data: JSON.stringify(data),
	success: function(response)
	{
             //JSON.parse(data);
           // alert("data parsed");
            //alert(data);
            alert(response);
	},
        error: function(response)
        {
          alert('error'+JSON.stringify(response));
        }
});
};
sendData(data);
}


