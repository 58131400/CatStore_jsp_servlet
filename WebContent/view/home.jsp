<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en-US">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<body
	class="home page-template-default page page-id-2 wp-custom-logo theme-tyche woocommerce-js">
	<div id="page" class="site">
		<section class="main-slider">
			<div class="owl-carousel owl-theme owl-loaded owl-drag"
				id="main-slider">

				<div class="owl-stage-outer">
					<div class="owl-stage"
						>
						<div class="owl-item cloned" style="width: 1349px;">
							<div class="item">
								<img width="1600" height="545"
									src="<%=request.getContextPath()%>/image/HomePage/Slide/Asset3.png"
								
									alt=""
									>
								
							</div>
						</div>
				</div>
				</div>
				<div class="owl-nav disabled">
					<button class="main-slider-previous">
						<i class="fas fa-angle-left"></i>
					</button>
					<button class="main-slider-next">
						<i class="fas fa-angle-right"></i>
					</button>
				</div>
				<div class="owl-dots disabled"></div>
			</div>
			<div class="main-slider-bar hidden-xs">
				<div class="container">
					<ul class="main-slider-info">
						<li class="col-sm-4 col-xs-12">
							<div class="main-slider-info-cell">
								<div class="cell-icon">
									<i class="dashicons dashicons-admin-site"></i>
								</div>
								<div class="cell-content">
									<span class="cell-caption"> FREE SHIPPING </span> <span
										class="cell-subcaption"> On all orders over 90$ </span>
								</div>
							</div>
						</li>
						<li class="col-sm-4 col-xs-12">
							<div class="main-slider-info-cell">
								<div class="cell-icon">
									<i class="dashicons dashicons-smartphone"></i>
								</div>
								<div class="cell-content">
									<span class="cell-caption"> CALL US ANYTIME </span> <span
										class="cell-subcaption"> +04786445953 </span>
								</div>
							</div>
						</li>
						<li class="col-sm-4 col-xs-12">
							<div class="main-slider-info-cell">
								<div class="cell-icon">
									<i class="dashicons dashicons-location-alt"></i>
								</div>
								<div class="cell-content">
									<span class="cell-caption"> OUR LOCATION </span> <span
										class="cell-subcaption"> 557-6308 Lacinia Road. NYC </span>
								</div>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</section>
		<div class="site-content">

			<section class="content-area-1">
				<div class="container">
					<div class="row">
						<div class="col-xs-12">
							<jsp:include page="/view/fragment/BestSale.jsp"></jsp:include>
							
						</div>
					</div>
				</div>
			</section>

			<section class="content-area-2">
				<div class="container">
	</div>
			</section>


			<section class="content-area-3">
				<div class="container">
				<jsp:include page="/view/fragment/ListAllProduct.jsp"></jsp:include>
			</div>
			</section>


			<section class="content-area-4">
				<div class="container">
					<div class="row">
						<div class="col-xs-12">
							<div id="tyche_recent-3"
								class="tyche-recent-posts widget widget_tyche_recent">
								<h3 class="widget-title">
									<span>COMMING SOON</span>
								</h3>
								
								<c:forEach var = "p" items="${listCommingSoon}">
								<div class="col-md-6">
									<div class="tyche-recent-post-alternate-widget">
									<div class="tyche-meta">
										<div class="tyche-date">
											<span class="day">${p.getDateAdded().getDayOfMonth()}</span> <span class="month">${p.getDateAdded().getMonth()}</span>
										</div>
										<div class="tyche-image">
											<a
												href="">
												<img width="160" height="90"
												src="<%=request.getContextPath() %>/image/${p.getImage()}"
												class="attachment-tyche-recent-post-alternate-image size-tyche-recent-post-alternate-image wp-post-image"
												alt="">
											</a>
										</div>
									</div>
									<div class="tyche-post-content" style="width: 30%;">
										<p>
											<a
												href="/CatStore/singleproduct?id=${p.getId() }">${p.getName() }</a>
										</p>
										<ul class="meta-list">
											<li class="post-author"><icon class="far fa-user"></icon>
												<a href="https://colorlib.com/tyche/author/raibercristian/">raibercristian</a></li>
											<li class="post-comments"><span class="sep">/</span> <icon
													class="fas fa-comments"></icon> <a
												href="https://colorlib.com/tyche/2017/06/12/best-fabrics-dream-dress-dare-try/#comments">0</a></li>
										</ul>
									</div>
								</div>
								</div>
							</c:forEach>
							</div>
						</div>
	</div>
				</div>
			</section>


			

		</div>
		</div>
</body>
		
