<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<div id="tyche_products-3"
								class="tyche-products primary widget widget_tyche_products">
								<h3 class="widget-title">
									<span>BEST SALE</span>
								</h3>
								<div class="row tyche-product-slider-container">
									
									<div class="col-sm-9 col-xs-12">
										<div
											class="owl-carousel tyche-product-slider owl-loaded owl-drag"
											data-attr-elements="3">



											<div class="owl-stage-outer">
												<div class="owl-stage"
													style="transform: translate3d(0px, 0px, 0px); transition: all 0s ease 0s; width: 879px;">
													<c:forEach var="p" items="${listBestSale}">
													<div class="owl-item active"
														style="width: 262.667px; margin-right: 30px;">
														<div class="item">
															<div class="tyche-product primary">
																<div class="tyche-product-image"
																	style="position: relative; overflow: hidden;">
																	<img style="width:255px; height:320px"
																		src="<%=request.getContextPath() %>/image/${p.getImage()}"
																		
																		class="attachment-shop_catalog size-shop_catalog"
																		alt=""> 
																</div>
																<div class="tyche-product-body">
																	<h3>
																		<a
																			href="/CatStore/singleproduct?id=${p.getId() }"
																			class="woocommerce-LoopProduct-link woocommerce-loop-product__link">${p.getName() }
																			</a>
																	</h3>
																	<span class="price"><fmt:formatNumber pattern="#,###,###,###">${p.getPrice() }</fmt:formatNumber> VNĐ</span>
																	<a rel="nofollow"
																		href="/CatStore/cart?action=add&id=${p.getId() }"
																		data-quantity="1" data-product_id="19"
																		data-product_sku=""
																		class="ajax_add_to_cart add_to_cart_button button primary"><span
																		class="fas fa-shopping-cart"></span> Add to cart</a>
																</div>
															</div>
														</div>
													</div>
													</c:forEach>
											</div>
											</div>
											<div class="owl-nav disabled">
												<div class="owl-prev">prev</div>
												<div class="owl-next">next</div>
											</div>
											<div class="owl-dots disabled">
												<div class="owl-dot active">
													<span></span>
												</div>
											</div>
										</div>
									</div>
									<div class="col-sm-3 hidden-xs">
										<div class="tyche-banner"
											style="background-image: url(https://colorlib.com/tyche/wp-content/uploads/sites/17/2017/06/long-dress-1438140_1920.jpg)">
											<div class="tyche-banner-caption">
												<span class="first_line"> SAVE UP TO </span> <span
													class="second_line"> 50% </span> <span class="third_line">
													ON OUR GALLA DRESSES </span> <a href="https://colorlib.com/">BUY
													NOW</a>
											</div>
										</div>
									</div>
								</div>
							</div>
							
</body>
</html>