<?php
date_default_timezone_set("Asia/Kolkata");
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Credentials: true');
header('Access-Control-Allow-Headers: Content-Type');
include 'jsonFormat.php';
include 'jsonDeliver.php';
include 'config.php';
//var data = {"profile":[{"visitorId":visitorId,"pname":pname,"pemail":pemail,"pphone":pphone,"pgender":pgender,"pbirthdate":pbirthdate,"pcity":pcity}]};
//$json = {"events":[{"eventId":eventId}]}; 
$json = file_get_contents("php://input");
$data = json_decode($json, true);
$jsonresponse=array();
$pname=$data['profile'][0]['pname'];
$visitorId=$data['profile'][0]['visitorId'];
$pemail=$data['profile'][0]['pemail'];
$pphone=$data['profile'][0]['pphone'];
$pGender=$data['profile'][0]['pGender'];
$pprofession=$data['profile'][0]['pProfession'];
$pEducation=$data['profile'][0]['pEducation'];
$pBirthDate=$data['profile'][0]['pBirthDate'];

//echo $pbirthdate;
			
		//insert into comment table
		//$dob=strtotime('27-10-1987');
		$dob = date('Y-m-d',strtotime($pBirthDate));

//@$createdon = date('Y-m-d h:i:s', time());			
$updateVisitorProfileQuery="update visitorProfile
set name='$pname',
gender='$pGender',
dateOfBirth='$dob',	
profession='$pprofession',
education='$pEducation'
where createdBy='$visitorId'";	
mysql_query($updateVisitorProfileQuery,$conn); 
	
			
//deliver_response(200,"visitor profile updated","visitor",$jsonresponse);


 
	
?>