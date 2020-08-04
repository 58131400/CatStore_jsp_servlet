<%@page import="khachhang.model.bean.Item"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
td, th {
	text-align: center;
}
</style>
</head>
<body
	class="page-template-default page page-id-5 wp-custom-logo theme-tyche woocommerce-cart woocommerce-page woocommerce-js">
	<div id="page" class="site">



		<div class="site-content">
			<div class="container">
				<div class="row">
					<div class="col-xs-12">
						<div class="tyche-breadcrumbs">
							<span itemscope=""
								itemtype="http://data-vocabulary.org/Breadcrumb"><a
								itemprop="url" href="https://colorlib.com/tyche"><span
									itemprop="title">Home </span></a></span><span class="tyche-breadcrumb-sep">/</span><span
								itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a
								itemprop="url" href="https://colorlib.com/tyche/shop/"><span
									itemprop="title">Shop</span></a></span><span class="tyche-breadcrumb-sep">/</span><span
								class="breadcrumb-leaf">Cart</span>
						</div>
					</div>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<div id="primary" class="content-area col-md-12">
						<main id="main" class="site-main" role="main">


							<article id="post-5"
								class="post-5 page type-page status-publish hentry">
								<div class="row">
									<div class="col-md-12">
										<header>
											<h1 class="page-title margin-top">Cart</h1>
										</header>
									</div>
								</div>
								<div class="woocommerce">
									<c:choose>
										<c:when test="${sessionScope.cart == null }">


											<div class="woocommerce">
												<div class="woocommerce-notices-wrapper"></div>
												<p class="cart-empty woocommerce-info">Your cart is
													currently empty.</p>
												<p class="return-to-shop">
													<a class="button wc-backward" href="/CatStore/home">
														Return to shop </a>
												</p>
											</div>
										</c:when>
										<c:otherwise>
											<form class="woocommerce-cart-form" action="/CatStore/cart"
												method="post">
												<table
													class="shop_table shop_table_responsive cart woocommerce-cart-form__contents"
													cellspacing="0">
													<tr>
														<th class="product-remove">&nbsp;</th>
														<th class="product-thumbnail">Image</th>
														<th class="product-name">Product</th>
														<th class="product-price">Price</th>
														<th class="product-quantity">Quantity</th>
														<th class="product-subtotal">Subtotal</th>
													</tr>
													<c:forEach var="item"
														items="${sessionScope.cart.getCartItems() }">
														<tr class="woocommerce-cart-form__cart-item cart_item">

															<td class="product-remove"><a
																href="/CatStore/cart?action=remove&id=${item.getKey() }"
																class="remove" aria-label="Remove this item"
																data-product_id="19" data-product_sku="">x</a></td>

															<td class="product-thumbnail"><a
																href="https://colorlib.com/tyche/product/black-top/"><img
																	width="255" height="320"
																	src="/CatStore/image/${item.getValue().getProduct().getImage() }"
																	class="attachment-woocommerce_thumbnail size-woocommerce_thumbnail"
																	alt="" /></a></td>

															<td class="product-name" data-title="Product"><a
																href="">${item.getValue().getProduct().getName() }</a></td>

															<td class="product-price" data-title="Price"><span
																class="woocommerce-Price-amount amount">
																	<fmt:formatNumber
																			pattern="#,###,###,###">${item.getValue().getPrice()}</fmt:formatNumber> VNĐ</span>
															</td>

															<td><input style="width: 50px;" type="number"
																id="quantity_5ea5cac028a3c" name="quantity"
																value="${item.getValue().getQuantity()}" title="Qty"
																size="4" placeholder="" " /></td>

															<td class="product-subtotal" data-title="Subtotal"><span
																class="woocommerce-Price-amount amount"><span
																	class="woocommerce-Price-currencySymbol"> </span> <fmt:formatNumber
																		pattern="#,###,###,###">${item.getValue().getProduct().getPrice() * item.getValue().getQuantity() }</fmt:formatNumber>
																	VNĐ</span></td>
														</tr>
													</c:forEach>
													<tr>
														<td colspan="6"><button type="submit" class="button"
																name="update_cart" value="Update cart">Update
																cart</button></td>
													</tr>
												</table>
											</form>
											<div class="cart-collaterals">
												<div class="cart_totals ">
													<h2>Cart totals</h2>
													<table class="shop_table shop_table_responsive">
														<tr class="order-total">
															<th>Total</th>
															<td data-title="Total"><strong><span
																	class="woocommerce-Price-amount amount"><fmt:formatNumber
																			pattern="#,###,###,###">${sessionScope.cart.total() }</fmt:formatNumber>
																</span></strong></td>
														</tr>
													</table>
													<div class="wc-proceed-to-checkout">
														<a href="/CatStore/cart?action=process"
															class="checkout-button button alt wc-forward">
															Proceed to checkout</a>
													</div>
												</div>
											</div>
										</c:otherwise>
									</c:choose>
								</div>
							</article>
							<!-- #post-## -->

						</main>
						<!-- #main -->
					</div>
					<!-- #primary -->

				</div>
			</div>
		</div>
		<!-- #content -->
	</div>
</body>
</html>