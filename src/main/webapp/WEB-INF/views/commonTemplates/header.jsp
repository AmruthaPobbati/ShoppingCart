<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Shopping Cart Application</title>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.4.min.js"></script>

<script type="text/javascript" src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>

<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">
	
<link href="<c:url value="/resources/css/main.css"/>"
	rel="stylesheet">
	
<link href="<c:url value="/resources/css/carousel.css"/>"
	rel="stylesheet">
	
<link href="https://cdn.datatables.net/1.10.10/css/jquery.dataTables.min.css" rel="stylesheet">
</head>
<!-- NAVBAR
================================================== -->
<body>
	<div class="navbar-wrapper">
		<div class="container">

			<nav class="navbar navbar-inverse navbar-static-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="<c:url value="/" />">Shopping Cart</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li><a href="<c:url value="/"/>">Home</a></li>
						<li><a href="<c:url value="/product/productList/all"/>">Products</a></li>
					</ul>
					<ul class="nav navbar-nav pull-right">
						<c:if test="${pageContext.request.userPrincipal.name != null }">
							<li><a>Welcome : ${pageContext.request.userPrincipal.name}</a></li>
							<c:if test="${pageContext.request.userPrincipal.name != 'admin'}">
								<li><a href="<c:url value="/customer/cart" />">Cart</a></li>
							</c:if>
							<c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
								<li><a href="<c:url value="/admin" />">Admin</a></li>
							</c:if>
							<li><a href="<c:url value="/j_spring_security_logout" />">Logout</a></li>
						</c:if>
						<c:if test="${pageContext.request.userPrincipal.name == null }">
						<li><a href="<c:url value="/login"/>"><span class="glyphicon glyphicon-log-in"></span>
								Login &nbsp; &nbsp; &nbsp;</a></li>
						<li><a href="<c:url value="/register"/>"><span class="glyphicon glyphicon-user"></span>
								Register</a></li>
						</c:if>
						
					</ul>
				</div>
			</div>
			</nav>

		</div>
	</div>