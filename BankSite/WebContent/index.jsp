<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Login page</title>
	</head>


<body style="text-align: center; padding: 70px;">
<form action="LoginRegisterRedirectorServlet" method="post">
	Login: <input type="text" name="loginText"><br>
	Password: <input type="Password" name="passwordText"><br>
	<input type="submit" name="LoginButton" value="Log In">   <input type="submit" name="RegisterButton" value="Register">
	</form>
	
	<%
	String temp = (String) request.getAttribute("indexInfo");
	if(temp == null);
	else out.print(temp);
		%>
	
 
 </body>
</html>