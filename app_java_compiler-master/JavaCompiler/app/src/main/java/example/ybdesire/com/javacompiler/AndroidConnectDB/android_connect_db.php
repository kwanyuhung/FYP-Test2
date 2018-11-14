<?php

$db = mysqli_connect("localhost","root","");

mysqli_query($db,"SET CHARACTER SET 'UTF8';");
mysqli_query($db,'SET NAMES UTF8;');
mysqli_query($db,'SET CHARACTER_SET_CLIENT=UTF8;');
mysqli_query($db,'SET CHARACTER_SET_RESULTS=UTF8;');
mysqli_select_db($db,"user");


$sql = $_POST['query_string'];
//$sql = "SELECT * FROM animals";
$res = mysqli_query($db,$sql);
$output = array();
while($row = mysqli_fetch_assoc($res))
    $output[]= $row;

print(json_encode($output));

mysqli_close($db);

