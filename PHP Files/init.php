<?php

$db_name = "project";
$mysql_user = "root";
$server_name = "localhost";

$connection = mysqli_connect($server_name,$mysql_user,"",$db_name);
if(!$connection){
//echo "Connection not successful";	
}

else{
//echo "Connection successful";	
}

?>