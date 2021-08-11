<?php
 include ('config.php');
if($_SERVER['REQUEST_METHOD']=='POST'){
    $email = $_POST['email'];
    $password = $_POST['password'];
    
    $Sql_Query = "select * from user where email = '$email' and password = '$password' ";
    
    $check = mysqli_fetch_array(mysqli_query($conn,$Sql_Query));
    
    if(isset($check)){
        $result["success"]="1";
        $result["message"]="success";
        echo json_encode($result);
        mysqli_close($conn);
    }
    else 
    {
        $result["success"]="0";
        $result["message"]="error";
        echo json_encode($result);
        mysqli_close($conn);
    }
}

?>