<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="commonTemplates/header.jsp" %>

<script>
$(document).ready(function(){

    $('.table').DataTable({
        "lengthMenu": [[1,2,3,5,10,-1], [1,2,3,5,10, "All"]]
    });
});

</script>

	<div class="container-wrapper">
		<div class="container">
			<div class="page-header">
				<h1>Product Inventory Page</h1>
				
			</div>

			<table class="table table-striped table-hover rounded" >
				<thead>
					<tr class="bg-primary">
						<th>thumbNail</th>
						<th>Product Name</th>
						<th>Category</th>
						<th>Condition</th>
						<th>Price</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${products}" var="product">
						<tr>
							<td><img src="<c:url value="/resources/images/${product.id}.png "/>" alt="image" style="width:128px;height:128px;"></td>
							<td>${product.name}</td>
							<td>${product.category}</td>
							<td>${product.condition}</td>
							<td>${product.price} USD</td>
							
							<td>
							
							<a href="<spring:url value="/product/viewProduct/${product.id}"/>" class="btn btn-success">View</a>
							<a href="<spring:url value="/admin/product/deleteProduct/${product.id}"/>" class="btn btn-danger">Delete</a>
							<a href="<spring:url value="/admin/product/editProduct/${product.id}"/>" class="btn btn-success">Edit</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			
			<a href="<spring:url value="/admin/product/addProduct" />" class="btn btn-primary">Add Product</a>

<%@ include file="commonTemplates/footer.jsp" %>