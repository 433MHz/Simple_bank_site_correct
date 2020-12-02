<%@page import="java.util.LinkedList"%>
<%@page import= "used_by_all.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Bank Account</title>
</head>
<body style="text-align: center; padding: 70px;">
<%!User user;%>
<%
	user = (User) session.getAttribute("user");
%>


Hello <%out.print(user.getName()); %> <br>
You have on your account: <%out.print(user.getMoney()); %> USD<br>
<br>

<h1>Add money</h1><br>
<form action="AddMoney" method="post">
How much money you want to add? <input type="text" name="moneyAddTextArea"> <input type="submit" name="moneyAddButton" value="Add"><br>
<% if(request.getAttribute("infoAdd") != null){out.print(request.getAttribute("infoAdd"));} %>
<br>
</form>

<h1>Money transfer</h1><br>
<form action="SendMoney" method="post">
To who you want send money? (type receiver login) <input type="text" name="reciverNameMoneyTransfer"><br> 
How much you want send?                          <input type="text" name="moneyAmountMoneyTransfer"><br><br>
<input type="submit" name="moneyTransferButton" value="Send"><br>
<% if(request.getAttribute("infoSend") != null){out.print(request.getAttribute("infoSend"));} %><br><br>
</form>

<form action="operationsHistory.jsp" method="post">
	<input type="submit" value="Go to operations history"><br><br>
</form>
<form action="index.jsp" method="post">
	<input type="submit" value="Logout">
</form>
</body>
</html>