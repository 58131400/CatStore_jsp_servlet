<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<body>
	<div class="col-xs-12">
		<div class="owl-carousel tyche-product-slider owl-loaded owl-drag"
			data-attr-elements="4">
			<div class="owl-stage-outer">
				<div class="owl-stage"
					style="transform: translate3d(0px, 0px, 0px); transition: all 0s ease 0s; width: 1170px;">
					<c:forEach var="cat" items="${listCatPagin}" >
					<div class="owl-item active"
						style="width: 262.5px; margin-right: 30px;">
						<div class="item">
							<div class="tyche-product orange">
								<div class="tyche-product-image"
									style="position: relative; overflow: hidden;">
									<img style="width:255px; height:320px"
										src="<%=request.getContextPath() %>/image/<c:out value= "${cat.getImage() }"></c:out>"								
										class="attachment-shop_catalog size-shop_catalog" alt="">
										<%  %>
									<img role="presentation"
										src="<%=request.getContextPath() %>/image/<c:out value= "${cat.getImage() }"></c:out>"
										class="zoomImg"
										style="position: absolute; top: 0px; left: 0px; opacity: 0; width: 768px; height: 576px; border: none; max-width: none; max-height: none;">
								</div>
								<div class="tyche-product-body">
									<h3>
										<a href="/CatStore/singleproduct?id=${cat.getId() }"
											class="woocommerce-LoopProduct-link woocommerce-loop-product__link">${ cat.getName() }</a>
									</h3>
									
									<span class="price"><span
										class="woocommerce-Price-amount amount"><fmt:formatNumber pattern="#,###,###,###"> ${cat.getPrice()}</fmt:formatNumber> VNĐ</span></span> <a
										rel="nofollow"
										href="/CatStore/cart?action=add&id=${cat.getId() }"
										data-quantity="1" data-product_id="56" data-product_sku=""
										class="ajax_add_to_cart add_to_cart_button button orange"><span
										class="fas fa-shopping-cart"></span> Add to cart</a>
								</div>
							</div>
						</div>
					</div>

					</c:forEach>
				</div>
				<!--pagination  -->
				<div class=" d-flex justify-content-center">
				<div aria-label="Page navigation">
					<ul class="pagination pagination-lg" id="cat_pagination">

						<c:if test="${pageIndex == 1 }">
							<li class="page-item disabled" id="1"><a class="page-link"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a></li>
						</c:if>
						<c:if test="${pageIndex > 1 }">
							<li class="page-item " id="${pageIndex-1 }"><a class="page-link"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a></li>
						</c:if>
						<c:forEach var="i" begin="1" end="${totalPage}">
							<c:choose>
								<c:when test="${i == pageIndex}">
									<li class="page-item active" id="${i}"><a
										class="page-link" >${i}</a></li>
								</c:when>
								<c:otherwise>
									<li class="page-item " id="${i}"><a
										class="page-link">${i}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:choose>
							<c:when test="${pageIndex == totalPage }">
							<li class="page-item disabled" id="${pageIndex}"><a class="page-link"
								aria-label="Next"> <span aria-hidden="true">&raquo;</span>
							</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item" id="${pageIndex+1 }"><a class="page-link"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span></a>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
				</div>
			</div>

		</div>
	</div>
</body>
</html>
