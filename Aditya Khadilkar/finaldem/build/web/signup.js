function signup() {
    var request = createCORSRequest( 'post', 'http://localhost:8080/jsondem/pass' );
        var name = document.getElementById('name').value;
        var mobileNo = document.getElementById('mobileNo').value;
        var emailId = document.getElementById('emailId').value;
        var password = document.getElementById('password').value;
        var data = {
            "name" : name,
            "password" : password,
            "mobileNo" : mobileNo,
            "emailId" : emailId
        };
        var sendData = function(data) {
            alert("sending: " + JSON.stringify(data));
            $.ajax({
                url : 'http://localhost:8080/jsondem/pass1',
                type : 'POST',
                contentType : 'application/json',
                data : JSON.stringify(data),
                success : function(response) {
                    alert(response);
                },
                error : function(response) {
                    alert('error' + JSON.stringify(response));
                }
            });
        };
        sendData(data);
    }

