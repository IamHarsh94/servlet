<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register page</title>
</head>
<body>


		
		<div class="container">
				<div>
					<b><p style="font-size: 55px;background-color: lightsteelblue;color: black;padding-left: 462px">Create Account</p></b>
				</div>
				<%= session.getAttribute("msg") == null ? "" : session.getAttribute("msg") %>
				<% session.invalidate();%>
			<div style="height: 300px;">
				<form action="registration" method="post" style="margin-left: 32%;margin-right: 35%;background-color: darkgray;height: 110%;border-style: double;"><br>	
					<br><input type="text" placeholder="id" name="userId" id="I" style="position: relative;font-size: 16px;height: 28px;margin-left: 96px;"></input><br>
					<br><input type="text" placeholder="firstname" name="Fname" id="F" style="position: relative;font-size: 16px;height: 28px;margin-left: 96px;"></input><br>
					<br><input type="text" placeholder="lastname" name="Lname" id="L" style="position: relative;font-size: 16px;height: 28px;margin-left: 96px;"></input><br>
					<br><input type="text" placeholder="username" name="Uname" id="U" style="position: relative;font-size: 16px;height: 28px;margin-left: 96px;"></input><br>
					<br><input type="password" placeholder="password" name="Pass" id="P" style="position: relative;font-size: 16px;height: 28px;margin-left: 96px;"></input><br>
					<br><input type="submit" value="create account" onclick="Validate()" style="position: relative;font-size: 16px;height: 28px;margin-left: 122px;background-color: peru;"/>	
					<a href="login">Home</a>
				</form>
			
			</div>
		
		
		</div>
		
</body>
</html>