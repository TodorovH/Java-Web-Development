<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<c:set var="user" value='<%= ((HttpServletRequest) request).getSession().getAttribute("username") %>' />
<c:set var="account_amount" value='<%= ((HttpServletRequest) request).getSession().getAttribute("account_amount") %>' />
<c:set var="account_currency" value='<%= ((HttpServletRequest) request).getSession().getAttribute("account_currency") %>' />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/styles.css" rel="stylesheet" type="text/css"/>
<title>Web Banking operations</title>
</head>
<body id="home-container">
	<div id="main-container">
		<div id="home-header">
			Welcome to Web Banking Operations.
		</div>
		<div id="home-body">
			<fieldset>
				<legend>Personal information</legend>
				<p>Client: ${user}</p>
				<p>Amount: ${account_amount} ${account_currency}</p>
			</fieldset>
			<div id="operation-form">
				<form method="post">
					<div>
						<fieldset>
							<legend>Type of operation</legend>
							<input type="radio" name="operation" value="deposit" id="deposit" checked="checked" />
							<label for="deposit">Deposit</label>
							
							<input type="radio" name="operation" value="withdraw" id="withdraw"/>
							<label for="withdraw">Withdraw</label>
						</fieldset>
						<fieldset>
							<legend>Currency</legend>
							<input type="radio" name="currency" value="bgn" id="bgn" checked="checked" />
							<label for="bgn">BGN</label>
							
							<input type="radio" name="currency" value="&dollar;" id="us_dollar"/>
							<label for="us_dollar">&dollar;</label>
							
							<input type="radio" name="currency" value="euro" id="euro"/>
							<label for="euro">&euro;</label>
						</fieldset>
					</div>
					<input type="text" name="amount_to_change" placeholder="0.00" /><br>
					<input type="submit" value="Submit" />
				</form>
			</div>
		</div>
		<div id="home-footer">
			Enterprise Java Beans version 0.1
		</div>
	</div>
</body>
</html>