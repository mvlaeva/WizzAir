<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
	<form method="post" action="/Home">
	
		<label>Username: </label>
		 <input type="text" name="username"
			placeholder="username">
			 <br /> 
			 
			 <label>Password: </label> 
			 <input
			type="password" name="password" placeholder="password">
			 <br />
			 
			 
		<label>Re-enter password: 
		</label> <input type="password"
			placeholder="password"> 
			<br /> 
			
			<label>Email address:
		</label> <input type="text" name="email" placeholder="email"> <br />
		<button value="Register" type="submit">Register</button>
</body>
</html>