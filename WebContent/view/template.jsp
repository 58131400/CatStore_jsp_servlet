
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>


<!DOCTYPE html>
<html>
<head>
<title><%=request.getAttribute("title") %></title>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/initial/css/bootstrap.min.css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/initial/js/jquery-3.3.1.js"></script>


<link rel="stylesheet" type="text/css" href="css/style.min.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/styles.css">
<link rel="stylesheet" id="woocommerce-layout-css" href="initial/css/woocommerce-layout.css" type="text/css" media="all">
<link rel="stylesheet" id="woocommerce-smallscreen-css" href="initial/css/woocommerce-smallscreen.css" type="text/css" media="only screen and (max-width: 768px)">
<link rel="stylesheet" id="woocommerce-general-css" href="initial/css/woocommerce.css" type="text/css" media="all">
<style id="woocommerce-inline-inline-css" type="text/css">
.woocommerce form .form-row .required { visibility: visible; }
</style>

<link rel="stylesheet" id="font-awesome-css" href="fontawesome/css/all.css" type="text/css" media="all">
<link rel="stylesheet" id="owlCarousel-css" href="initial/css/owl.carousel.min.css" type="text/css" media="all">
<link rel="stylesheet" id="owlCarousel-theme-css" href="initial/css/owl.theme.default.css" type="text/css" media="all">
<link rel="stylesheet" id="dashicons-css" href="initial/css/dashicons.min.css" type="text/css" media="all">
<link rel="stylesheet" id="tyche-css" href="css/style(1).css" type="text/css" media="all">
<link rel="stylesheet" id="tyche-style-css" href="css/style(2).css" type="text/css" media="all">
<link rel="stylesheet" href ="css/mystyle.css">
<script type="text/javascript" src="js/myscript.js"></script>
<script type="text/javascript"
	src="initial/js/bootstrap.min.js"></script>

</head>
<body>

<header><%@ include file="./fragment/header.jsp"%></header> 

<content>

<%switch(request.getAttribute("title").toString()) 
{
case "home":
%>
<jsp:include page="home.jsp"></jsp:include>
<%
break;
case "signin":
%>
<jsp:include page="signIn.jsp"></jsp:include>
<%
break;
case "account":
%>
<jsp:include page="personalInfo.jsp"></jsp:include>
<%
break;
case "cart":
%>
<jsp:include page="cart.jsp"></jsp:include>
<%
break;
case "cats":
%>
<jsp:include page="cats.jsp"></jsp:include>
<%
break;
case "foods":
%>
<jsp:include page="foods.jsp"></jsp:include>
<%
break;
case "fashions":
%>
<jsp:include page="fashions.jsp"></jsp:include>
<%
break;
case "singleProduct":
%>
<jsp:include page="SingleProduct.jsp"></jsp:include>
<%
break;
case "signup":
%>
<jsp:include page="signup.jsp"></jsp:include>
<%
break;
}%> 
</content>
<footer>
	<jsp:include page="./fragment/footer.jsp"></jsp:include>
</footer>

</body>
</html>