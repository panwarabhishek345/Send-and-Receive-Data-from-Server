<?php

require "init.php";

$u_name = $_POST['name'];
$u_password = $_POST['password'];
$u_contact = $_POST['contact'];
$u_country = $_POST['country'];

$sql_query = "insert into users values('$u_name','$u_password','$u_contact','$u_country');";

if(mysqli_query($connection,$sql_query)){
	//echo "Data Inserted";
}
else{
	//echo "Error!";
}

?>