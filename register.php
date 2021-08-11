<?php

if($_SERVER['REQUEST_METHOD'] =='POST'){
    $username=$_POST['username'];
    $password=$_POST['password'];
    $email=$_POST['email'];


    require_once'config.php';

    $sqli="INSERT INTO user(id,username,password,email) VALUES(NULL,'$username','$password','$email')";

    if(mysqli_query($conn,$sqli))
    {
        $result["success"]="1";
        $result["message"]="success";
        echo json_encode($result);
        mysqli_close($conn);
    } else
    {
        $result["success"]="0";
        $result["message"]="error";
        echo json_encode($result);
        mysqli_close($conn);
    }
}

?>