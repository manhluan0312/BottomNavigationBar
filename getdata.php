<?php
require "config.php";
$query="SELECT * FROM sinhvien";
$data=mysqli_query($conn,$query);
$mangSV= array();

class SinhVien{
    function __construct($id,$anh,$hoten,$namsinh,$diachi)
{
  $this->id=$id;
  $this->anh=$anh;
  $this->hotenSV=$hoten;
  $this->namsinhSV=$namsinh;
  $this->diachiSV=$diachi;
}
}

while ($row=mysqli_fetch_assoc($data)){
   
  array_push($mangSV,new SinhVien($row ['id'],$row ['anh'],$row ['hoten'],$row ['namsinh'],$row ['diachi']));

}
echo json_encode($mangSV);
?>