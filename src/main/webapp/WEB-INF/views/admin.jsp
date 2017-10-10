<%@include file="commonTemplates/header.jsp" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

	<div class="container-wrapper">
		<div class="container">
			<div class="page-header">
				<h1>Administrator Page</h1>
				<p>This is administrator Page.Use links to navigate </p>
			</div>
			
			<c:if test="${pageContext.request.userPrincipal.name != null}">
				<h2>
					Welcome ${pageContext.request.userPrincipal.name} | <a href="<c:url 
						value="/j_spring_security_logout" />">Logout</a>
				
				</h2>
			</c:if>
			
			<h3>
				<a href="<c:url value="/admin/productInventory"/>">Product Inventory</a>
			</h3>
			

<%@ include file="commonTemplates/footer.jsp" %>