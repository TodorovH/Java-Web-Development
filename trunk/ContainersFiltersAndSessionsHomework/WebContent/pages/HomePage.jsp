<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" uri="http://jwd.bg/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<c:set var="user" value='<%= ((HttpServletRequest) request).getSession().getAttribute("loggedUser") %>' />

<ct:Page>
	<jsp:attribute name="title">Containers, Filters and Sessions</jsp:attribute>
	<jsp:attribute name="user">Welcome, ${user}</jsp:attribute>
	<jsp:attribute name="project_name">Containers, Filters and Sessions</jsp:attribute>
	<jsp:attribute name="version">Version 0.1</jsp:attribute>
</ct:Page>