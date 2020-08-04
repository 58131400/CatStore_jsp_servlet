
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="khachhang.model.bean.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header class="top-header-bar-container">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<ul class="top-header-bar">
					<c:choose>
						<c:when test="${user != null }">
						<li class="top-account float-right"><a href="/CatStore/signin"><i class="fas fa-sign-out-alt fa-2x"></i></a></li>
							<li class="top-cart float-right"><a href="/CatStore/cart"><i
									class="fa fa-shopping-cart"></i> My Cart <span class="price">${sessionScope.cart.getCartItems().size() }</span>
							</a></li>

							<li class="top-account"><a
								href="<%=request.getContextPath()%>/myaccount"><i
									class="fa fa-user"></i> <%=((User) (session.getAttribute("user"))).getUsername()%></a></li>
						</c:when>
						<c:otherwise>
						
							<li class="top-account float-right"><a
								href="<%=request.getContextPath()%>/signin"><i
									class="fas fa-sign-in-alt"></i>Sign in</a></li>
							<li class="top-account float-right" style="margin-right: 20px;"><a
								href="<%=request.getContextPath()%>/signup"><i
									class="far fa-registered"></i>Sign up</a></li>
						</c:otherwise>
					</c:choose>
					
				</ul>
			</div>
		</div>
	</div>
</header>

<header id="masthead" class="site-header" role="banner">
	<div class="site-branding container">
		<div class="row">
			<div class="col-sm-4 header-logo">
				<a href="<%=request.getContextPath()%>/home"
					class="custom-logo-link" rel="home"><img width="150"
					height="70" class="custom-logo" alt="MEOW"
					src="<%=request.getContextPath()%>/image/Logo.png"></a>
			</div>
		</div>
	</div>
	<nav id="site-navigation" class="main-navigation" role="navigation">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<ul id="desktop-menu" class="sf-menu">
						<li id="menu-item-83"
							class="menu-item menu-item-type-custom menu-item-object-custom current-menu-item current_page_item menu-item-home menu-item-83 active">
							<a title="Home" href="<%=request.getContextPath()%>/home">Home</a>
						</li>
						<li id="menu-item-86"
							class="menu-item menu-item-type-post_type menu-item-object-page menu-item-86"><a
							title="Shop" href="<%=request.getContextPath()%>/cat">Cat</a></li>
						<li id="menu-item-84"
							class="menu-item menu-item-type-post_type menu-item-object-page menu-item-84"><a
							title="Blog" href="<%=request.getContextPath()%>/food">Food</a></li>
						<li id="menu-item-85"
							class="menu-item menu-item-type-post_type menu-item-object-page menu-item-85"><a
							title="Contact" href="<%=request.getContextPath()%>/fashion">Fashion</a></li>
					</ul>
					<button href="#" id="mobile-menu-trigger"
						class="mobile-menu-closed">
						<i class="fas fa-bars"></i>
					</button>

				</div>
			</div>
		</div>
	</nav>
</header>
