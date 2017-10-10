<%@include file="commonTemplates/header.jsp" %>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Product Details</h1>
			<p>Find the detailed information of your selected product</p>
		</div>
		
		<div class="conatiner" ng-app="cartApp">
			<div class="row">
				<div class="col-md-6 ">
					<img src="<c:url value="/resources/images/${product.id}.png "/>" alt="image" style="width:400px;height:250px;">
				</div>
				<div class="col-md-6">
					<h3> ${product.name}</h3>
					<p>${product.description}</p>
					<p><strong>Manufacturer:</strong>${product.manufacturer}</p>
					<p><strong>Category:</strong>${product.category}</p>
					<p><strong>Condition:</strong>${product.condition}</p>
					<h4>${product.price}</h4>
					
					<br>
					
					<c:set var="role" scope="page" value="${param.role}" />
                    <c:set var="url" scope="page" value="/product/productList/all" />
                    <c:if test="${role='admin'}">
                        <c:set var="url" scope="page" value="/admin/productInventory" />
                    </c:if>
					
					<p ng-controller="cartCtrl">
						<a href="<c:url value="${url}"/>" class="btn btn-default">Back</a>
						<a href="#" class="btn btn-large btn-warning" ng-click="addToCart('${product.id }')"><span class="glyphicon glyphicon-shopping-cart"></span>Add To Cart</a>
						<a href="<c:url value="/customer/cart"/>" class="btn btn-default">View Cart</a>
					</p>
				</div>
			</div>
		</div>

<script src="<c:url value="/resources/js/controller.js"/>"></script>
<%@include file="commonTemplates/footer.jsp" %>