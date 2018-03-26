<%@ page session="true" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<jsp:include  page="header.jsp"></jsp:include>
<div class="container">
	<h1>Welcome to the Fruit Store.</h1>
	<h2>You may view purchasable items <a href="${pageContext.request.contextPath}/store">here.</a></h2>

</div>
<jsp:include page="footer.jsp"></jsp:include>
