<%@page import="project2.DBconnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String user = request.getParameter("username");
	String pass = request.getParameter("password");
	DBconnection db = new DBconnection();
	db.add(user,pass);
	if(db.i >0){
		out.println("welcome to the website");
		
		
	}
	else{
		out.println("not welcome to website");
	}
%>

</body>
</html>