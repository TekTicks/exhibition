<?php
//Access Control Headers
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Credentials: true');
header('Access-Control-Allow-Headers: Content-Type');

//Include Files
include 'jsonFormat.php';
include 'jsonDeliver.php';
include 'config.php';

//Fetch and decode JSON
//$josn = '{"password":[{"visitorId":visitorId,"password":abc12234,"newPassword":"abcdghgf"}]}'; 
$json = file_get_contents("php://input");
$data = json_decode($json, true);	
$jsonresponse =	"";
@$visitorId=$data['password'][0]['visitorId'];
@$password=$data['password'][0]['password'];
@$newPassword=$data['password'][0]['newPassword'];

$updateVisitorQuery="update visitor
set password='$newPassword'	
where id='$visitorId'";	
mysql_query($updateVisitorQuery,$conn); 
	
$jsonresponse=$visitorId;			
deliver_response(200,"visitor profile updated","visitor",$jsonresponse);
	


?>