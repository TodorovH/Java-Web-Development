<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form JSP</title>
</head>
<body>
	<form action="Form.jsp" method="POST">
		<input type="text" name="Id" placeholder="Id..."><br />
		<input type="text" name="Topic" placeholder="Topic..."><br />
		<input type="text" name="Date" placeholder="Date..."><br />
        <button>Submit</button>
        <button>Cancel</button>
    </form>
</body>
</html>