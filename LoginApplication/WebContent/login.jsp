<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript/jsp" src="/home/bridgeit/BitBucket/LoginApplication/WebContent/login.js"></script>	
	<title>Home Page</title>
</head>
<body>
		<div>
			<b><p style="font-size: 55px;background-color: lightsteelblue;color: black;padding-left: 519px">Sign in</p></b>
		</div>	
		<%HttpSession se=request.getSession(false); %>
		<% if (se!=null) { %>
			   <b><%=request.getAttribute("msg")==null ? "":request.getAttribute("msg")%></b>
				<%session.invalidate(); %>			   
    	<% }else{
			};%>	
	<%--${msg}--%> 			
	<div class="container">
	<div style="height: 300px;">
		
		<form action="login" method="post" style="margin-left: 32%;margin-right: 35%;background-color: darkgray;height:75%;border-style: double;">
			<br><input type="text" placeholder="username" name="uname" id="email"
					style="position: relative; font-size: 16px; height: 28px; margin-left: 96px;"></input><br>						
			<br><input type="password" placeholder="password" name="pass" id="pass" style="position: relative;font-size: 16px;height: 28px;margin-left: 96px;" ></input><br>
			<br><input type="submit" onclick="validate()" name="sign up" style="position: relative;font-size: 16px;height: 28px;margin-left: 96px;background-color: peru;"/>
			<a href="register">New user</a>
		</form>
	</div>
	</div>		
</body>
</html>