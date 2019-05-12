<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> Please Login</h1>
<form action = "LoginServlet" method= "post">
<input type="text" placeholder="enter user name" name="username"><br>
<input type="password" placeholder="enter your password" name="password"><br>
<input type="submit" value= "sign in">
</form>
</body>
</html>