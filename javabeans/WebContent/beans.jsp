<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Beans</title>
</head>
<body>
 <h1>reading information using Beans</h1>
 <jsp:useBean id="user" class="javabeans.User"></jsp:useBean>
 
 <jsp:setProperty property="*" name="user"/>
 username= <jsp:getProperty property="username" name="user"/>
 password= <jsp:getProperty property="password" name="user"/>
</body>
</html>