<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="regForm" method="post">
		Name: <input type="text" name="name1" placeholder="Enter Name" /> <br>
		<br> Email: <input type="text" name="email1"
			placeholder="Enter Email" /> <br> <br>
			 Password: <input
			type="password" name="password1" placeholder="Enter Password" /> <br>
		<br> Gender: <input type="radio" name="gender1" value="Male" /> Male <input
			type="radio" name="gender1" value="Female" />Female <br><br>
			 City:<select name="city1">
			<option>Select City</option>
			<option>Pune</option>
			<option>Delhi</option>
			<option>Indore</option>
			<option>Banglore</option>
		</select> <br>
		<br> <input type="submit" value="Register" />
	</form>
</body>
</html>