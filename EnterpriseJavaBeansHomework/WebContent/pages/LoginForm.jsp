<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/styles.css" rel="stylesheet" type="text/css"/>
<title>Log in</title>
</head>
<body id="login-container">
	<div id="form-container">
		<div id="login-header">Sign in</div>
		<div id="login-form">
			<form action="/EnterpriseJavaBeansHomework/pages/HomePage.jsp" method="post">
				Username<br>
				<input type="text" name="username" placeholder="Username..." /><br>
				Password<br>
				<input type="password" name="password" placeholder="Password..." /><br>
				<input type="submit" value="Login" />
			</form>
		</div>
	</div>
</body>
</html>