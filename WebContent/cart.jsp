<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
	<h1>Your Cart</h1>
	<table class="table-striped table-hover table-responsive">
		<thead>
			<tr>
				<td>SKU</td>
				<td>Name</td>
				<td>Price</td>
				<td>Country</td>
				<td>Calories</td>
				<td>Description</td>
				<td>In Cart</td>
				<td>Amount</td>
			</tr>
		</thead>
		<c:forEach var="fruit" items="${cartList}">
			<tr>
				<form method="POST" action="${pageContext.request.contextPath}/cart">
				<td>${fruit.getSku()} <input type="hidden" name="sku" value="${fruit.getSku()}" /></td>
				<td>${fruit.getName()}<input type="hidden" name="name" value="${fruit.getName()}" /></td>
				<td>$${fruit.getPrice()}<input type="hidden" name="price" value="${fruit.getPrice()}" /></td>
				<td>${fruit.getCountryOfOrigin()}<input type="hidden" name="country" value="${fruit.getCountryOfOrigin()}" /></td>
				<td>${fruit.getCalories()}<input type="hidden" name="calories" value="${fruit.getCalories()}" /></td>
				<td>${fruit.getDescription()}<input type="hidden" name="description" value="${fruit.getDescription()}" /></td>
				<td>${fruit.getAmount()}</td>
				<td><input type="number" name="amount" /></td>
				<td><input class="btn btn-danger" type="submit" value="Remove" /></td>
				</form>
			</tr>
		</c:forEach>
	</table>
	<a class="btn btn-default" href="${pageContext.request.contextPath}/store">Continue Shopping</a>
</div>
<jsp:include page="footer.jsp"></jsp:include>
