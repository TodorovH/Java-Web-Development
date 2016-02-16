<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="date" value="<%= new java.util.Date() %>" />
<c:set var="toShowDate" value="true" />

<h1>Java Web</h1>
<div>Some Content</div>
<div>System Version 0.1</div>
<c:if test='${toShowDate == "true"}'>
	<div>${date}</div>
</c:if>

