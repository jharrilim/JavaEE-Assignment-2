<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.aaj.fruitstore.config.Constants"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fruit Store</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<style type="text/css">
td {
	padding-left: 0.5em;
	padding-right: 0.5em;
	padding-top: 0.3em;
	padding-bottom: 0.3em;
}
</style>

</head>
<body>
	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1"%>
	<div class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="/<%=Constants.APP_NAME%>/">Fruit Store</a>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto" style="list-style: none;">
				<li class="nav-item ${pageContext.request.requestURI eq '/GroupAAJ_COMP303Assignment2/' ? ' active' : ''}">
					<a class="nav-link" href="/<%=Constants.APP_NAME%>/">Home <span
						class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item ${pageContext.request.requestURI eq '/GroupAAJ_COMP303Assignment2/store.jsp' ? ' active' : ''}">
					<a class="nav-link" href="/<%=Constants.APP_NAME%>/store">Store</a>
				</li>
				<li class="nav-item ${pageContext.request.requestURI eq '/GroupAAJ_COMP303Assignment2/cart.sjp' ? ' active' : ''}">
					<a class="nav-link" href="/<%=Constants.APP_NAME%>/cart">Cart</a>
				</li>
			</ul>
		</div>
	</div>