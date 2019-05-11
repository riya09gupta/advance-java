<%@page import="beans2.register"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="riya" class="beans2.register"></jsp:useBean>
<jsp:setProperty property="*" name="riya"/>

<%  register rs= new register();
    rs.add(riya.getUsername(), riya.getPassword());
    if(rs.i >0){
		out.println("welcome to the website");
		
		
	}
	else{
		out.println("not welcome to website");
	}%>
 


</body>
</html>