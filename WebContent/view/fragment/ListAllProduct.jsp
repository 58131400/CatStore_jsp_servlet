<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<div class="row">
		<div class="col-xs-12">
			<div id="tyche_products-9"
				>
				<ul style="margin-top: 30px;margin-bottom:30px" class="nav nav-pills nav-justified" id="pills-tab" role="tablist">
					<li class="nav-item">
						<a href="#cats-pill" class="nav-link active" id="cat-tab"
							data-toggle="pill" role="tab" aria-selected="true"><b>CATS</b></a>
					</li>
					<li class="nav-item">
						<a href="#foods-pill" id="food-tab" data-toggle="pill" role="tab"
							class=" nav-link " aria-selected="false"> <b>FOODS</b>
						</a>
					</li>
					<li class=" nav-item">
						<a href="#fashions-pill" id="food-tab" data-toggle="pill"
							role="tab" class="nav-link" aria-selected="false"> <b>FASHIONS</b>
						</a>
					</li>
				</ul>

				<div class="row tyche-product-slider-container">
					<div class="tab-content" id="pills-tabContent">
						<div class="tab-pane fade show active" id="cats-pill" role="tabpanel">
							<jsp:include page="ListMeo.jsp"></jsp:include>
						</div>
						<div class="tab-pane fade" id="foods-pill" role="tabpanel">
							<jsp:include page="ListMeo.jsp"></jsp:include>
						</div>
						<div class="tab-pane fade" id="fashions-pill" role="tabpanel">
							<jsp:include page="ListMeo.jsp"></jsp:include>
						</div>
					</div>


				</div>
			</div>
		</div>
	</div>

</body>
</html>