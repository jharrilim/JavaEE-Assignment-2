<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp" />
<div class="container">
	<h1>Fruit Store</h1>
	<table class="table-striped table-hover table-responsive">
		<thead>
			<tr>
				<td>SKU</td>
				<td>Name</td>
				<td>Price</td>
				<td>Country</td>
				<td>Calories</td>
				<td>Description</td>
				<td>In Stock</td>
				<td>Amount</td>
			</tr>
		</thead>
		<c:forEach var="fruit" items="${fruitList}">
			<tr>
				<form method="POST" action="${pageContext.request.contextPath}/store">
				<td>${fruit.getSku()} <input type="hidden" name="sku" value="${fruit.getSku()}" /></td>
				<td>${fruit.getName()}</td>
				<td>$${fruit.getPrice()}</td>
				<td>${fruit.getCountryOfOrigin()}</td>
				<td>${fruit.getCalories()}</td>
				<td>${fruit.getDescription()}</td>
				<td>${fruit.getAmount()}</td>
				<td><input type="number" name="amount" /></td>
				<td><input class="btn btn-primary" type="submit" value="Add To Cart" /></td>
				</form>
			</tr>
		</c:forEach>
	</table>



</div>
<jsp:include page="footer.jsp" />
