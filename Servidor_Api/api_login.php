<?php
$info = file_get_contents('php://input');
$arrayinfo = json_decode($info);

$emailJava = $arrayinfo->email;
$senhaJava = $arrayinfo->senha;

@$conect = mysql_connect("192.185.176.15","siste183_vitor","aimeudeus");
@mysql_select_db("siste183_api_app", $conect);

@$query = mysql_query("SELECT *FROM `usuario` WHERE usr_email = '".$emailJava."'");
$linhas_afetadas = mysql_affected_rows();

$arr = '';
if($linhas_afetadas == 0)
    $arr = false;
else{
    while(@$row=mysql_fetch_assoc($query)){
        $emailBanco = $row['usr_email'];
        $senhaBanco = $row['usr_senha'];

        if($emailJava == $emailBanco && $senhaJava == $senhaBanco)
            $arr = true;
        else
            $arr = false;
    }
}
 $data =  [
    "status" => $arr
 ];

 print_r(json_encode($data))
?>
