<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" uri="http://jwd.bg/tags" %>
<%@ attribute name="title" %>
<%@ attribute name="user" %>
<%@ attribute name="project_name" %>
<%@ attribute name="version" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Containers, Filters and Sessions</title>
	</head>
	<body>
		<ct:Header title="${title}" />
		<ct:Body user="${user}" />
		<ct:Footer project_name="${project_name}" version="${version}" />
	</body>
</html>