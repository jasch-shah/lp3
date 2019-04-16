<!doctype html>
<?php

$connect = mysqli_connect("localhost","root","");
mysqli_select_db($connect,"miniproj");
    
if(isset($_POST['submit'])){
	$user = $_POST['username'];
	$pass = $_POST['password'];
    
    for($i = 0; $i<strlen($user); $i++){
        if($user[$i] == "'"){
            echo("Don't try an injection attack. the cops are on their way!!!");
            exit();
        }
    }
    
    for($i = 0; $i<strlen($pass); $i++){
        if($pass[$i] == "'" ){
            echo("Don't try an injection attack. the cops are on their way!!!");
            exit();
        }
    }
    
    $query = "select * from users where id ='$user' and pass = '$pass'";
    $query_run = mysqli_query($connect,$query);
    
        
	if(mysqli_num_rows($query_run)>0){
		
        header('location:success.html');
	}
    else{
	echo("error ! please enter correct data!");
	}
}
?>
<html>
<head>
<meta charset="utf-8">
<title>Untitled Document</title>
</head>

<body>
<form action="" method="post">
	<table align="center">
		<tr>
			<td>username:</td>
			<td><input type="text" name="username" placeholder="enter your username"></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="password" name ="password" placeholder="enter your password"></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" name="submit" value="submit"</td>
		</tr>
	</table>
</form>
</body>
</html>