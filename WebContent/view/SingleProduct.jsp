<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="product-template-default single single-product postid-41 wp-custom-logo theme-tyche woocommerce woocommerce-page woocommerce-js">

	<div class="site-content">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<nav class="woocommerce-breadcrumb">
						<a href="https://colorlib.com/tyche">Home</a>&nbsp;/&nbsp;<a
							href="https://colorlib.com/tyche/product-category/most-wanted/">${product.getCategoryid() }</a>&nbsp;/&nbsp;${product.getName() }
					</nav>
					
					<div id="product-31"
						class="product type-product post-31 status-publish first instock product_cat-belts product_cat-most-wanted product_tag-belt product_tag-colorful product_tag-fitt has-post-thumbnail taxable shipping-taxable purchasable product-type-simple">
						<div
							class="woocommerce-product-gallery woocommerce-product-gallery--with-images woocommerce-product-gallery--columns-4 images"
							data-columns="4"
							style="opacity: 1; transition: opacity 0.25s ease-in-out 0s;">
							<a href="https://colorlib.com/tyche/product/fitt-belts/#"
								class="woocommerce-product-gallery__trigger">🔍</a>
							<figure class="woocommerce-product-gallery__wrapper">
								<div
									data-thumb="https://colorlib.com/tyche/wp-content/uploads/sites/17/2017/06/belts-823257_1920-150x150.jpg"
									data-thumb-alt="" class="woocommerce-product-gallery__image"
									style="position: relative; overflow: hidden;">
									<a href=""><img
										width="540" height="386"
										src="/CatStore/image/${product.getImage() }"
										class="wp-post-image" alt="" title="belts-823257_1920"
										data-caption=""
										data-src="/CatStore/image/${product.getImage() }"
										data-large_image=""
										data-large_image_width="1920" data-large_image_height="1372"
										srcset=""
										sizes="(max-width: 540px) 100vw, 540px"></a><img
										role="presentation" alt=""
										src="/CatStore/image/${product.getImage() }"
										class="zoomImg"
										style="position: absolute; top: -962.288px; left: -374.5px; opacity: 0; width: 1920px; height: 1372px; border: none; max-width: none; max-height: none;">
								</div>
							</figure> 
							
						</div>						
						<div class="summary entry-summary">
							<h1 class="product_title entry-title">${product.getName()}</h1>
							
							<div class="woocommerce-product-details__short-description">
								<p>Sex: <c:if test="${product.getSex()==true}">Male</c:if>
								<c:if test="${product.getSex()==false}">Female</c:if></p>
								<p>Age: ${product.getAge()} year</p>
								<p>Hair Color: ${product.getColor()}</p>
							</div>
							<p class="price">
								<span class="woocommerce-Price-amount amount"><fmt:formatNumber pattern="###,###,###,###"> ${product.getPrice()}</fmt:formatNumber> VND</span>
							</p>
							<form action ="/CatStore/singleproduct" method="post">
							<input type="hidden" name ="id" value="${product.getId() }">
							<input type="number" value="1" min = 1 max="" name="quantity" style="width:100px">
							<button type="submit" value="submit" name="gui">Add to Cart </button>
							</form>
							
						</div>
						<div class="woocommerce-tabs wc-tabs-wrapper">
							<ul class="tabs wc-tabs tyche-wc-tabs" role="tablist">
								<li class="description_tab active" id="tab-title-description"
									role="tab" aria-controls="tab-description"><a
									href="https://colorlib.com/tyche/product/fitt-belts/#tab-description">Description</a>
								</li>
								<li class="reviews_tab" id="tab-title-reviews" role="tab"
									aria-controls="tab-reviews"><a
									href="https://colorlib.com/tyche/product/fitt-belts/#tab-reviews">Reviews
										(1)</a></li>
							</ul>
							<div
								class="woocommerce-Tabs-panel woocommerce-Tabs-panel--description panel entry-content wc-tab"
								id="tab-description" role="tabpanel"
								aria-labelledby="tab-title-description" style="display: block;">
								<h2>Description</h2>
								<p>${product.getDescription()}</p>
							</div>
							<div
								class="woocommerce-Tabs-panel woocommerce-Tabs-panel--reviews panel entry-content wc-tab"
								id="tab-reviews" role="tabpanel"
								aria-labelledby="tab-title-reviews" style="display: none;">
								<div id="reviews" class="woocommerce-Reviews">
									<div id="comments">
										<h2 class="woocommerce-Reviews-title">
											1 review for <span>${product.getName()}</span>
										</h2>
										<ol class="commentlist">
											<li class="review even thread-even depth-1"
												id="li-comment-1971">
												<div id="comment-1971" class="comment_container">
													<img alt=""
														src=""
							
														srcset="https://secure.gravatar.com/avatar/169408e00648d6118f001bd966eeafa2?s=120&amp;d=mm&amp;r=g 2x"
														class="avatar avatar-60 photo" height="60" width="60">
													<div class="comment-text">
														<div class="star-rating" role="img"
															aria-label="Rated 4 out of 5">
															<span style="width: 80%">Rated <strong
																class="rating">4</strong> out of 5
															</span>
														</div>
														<p class="meta">
															<strong class="woocommerce-review__author">VOPT
															</strong> <span class="woocommerce-review__dash">–</span>
															<time class="woocommerce-review__published-date"
																datetime="2019-06-07T05:56:35+00:00">June 7, 2019</time>
														</p>
														<div class="description">
															<p>say hello</p>
														</div>
													</div>
												</div>
											</li>
										</ol>
									</div>
									<div class="clear"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>


</body>
</html>>