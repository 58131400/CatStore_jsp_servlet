<%@ page import = "admin.model.bean.Product" %>
<%@ page import = "admin.model.bean.ProductCat" %>
<%@ page import = "admin.model.bean.ProductClothes" %>
<%@ page import = "admin.model.bean.ProductFood" %>
<% String root = request.getContextPath(); %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link
		href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
		rel="stylesheet" />
	<link href="/CatStore/view/admin/static/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css" />

	<link href="/CatStore/view/admin/static/css/sb-admin-2.min.css" rel="stylesheet" />
	<link href="/CatStore/view/admin/static/css/custom.css" rel="stylesheet" />
	<link href="/CatStore/view/admin/static/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet" />

	<title>Product Detail - Meow</title>
</head>

<body>

	<!-- Page Wrapper  -->
	<div id="wrapper">

		<!-- Sidebar -->
		<%@ include file = "../../layouts/sidebar.jsp" %>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->

			<!-- Topbar -->
			<%@ include file = "../../layouts/topbar.jsp" %>
			<!-- End of Topbar -->

			<!-- Begin Page Content -->
			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="d-sm-flex align-items-center justify-content-between mb-4">
					<h1 class="h3 mb-0 text-gray-800">Product management</h1>
				</div>

				<!-- DataTales Example -->
				<div class="card shadow mb-4">
					<div class="card-header py-3">
						<h6 class="m-0 font-weight-bold text-primary">Product Detail</h6>
					</div>
					<%
						Product product = (Product)request.getAttribute("product");
						ProductCat cat = null;
						ProductClothes clothes = null;
						ProductFood food = null;
		
						if(product instanceof ProductCat) {
							cat = (ProductCat) product;
						} else if(product instanceof ProductClothes) {
							clothes = (ProductClothes) product;
						} else if(product instanceof ProductFood) {
							food = (ProductFood) product;
						}
					%>
					<div class="card-body">
						<div class="row">
							<div class="col-12 col-md-6">
								<div class="form-group">
									<label>Product name</label>
									<input type="text" class="form-control" disabled value="<%= product.getName() %>">
								</div>
								<div class="form-group">
									<label>Price</label>
									<input type="text" class="form-control" disabled value="<%= product.getPrice() %>">
								</div>
								<div class="form-group">
									<label>Amount</label>
									<input type="text" class="form-control" disabled value="<%= product.getAmount() %>">
								</div>
								<div class="form-group">
									<label>Original</label>
									<input type="text" class="form-control" disabled
										value="<%= product.getOriginal() %>">
								</div>
								<div class="form-group">
									<label>Description</label>
									<textarea class="form-control" disabled><%= product.getDescription() %></textarea>
								</div>
							</div>
							<div class="user col-12 col-md-6">
								<div class="form-group">
									<label>Category</label>
									<input type="text" class="form-control" disabled
										value="<%= product.getCategory().getName() %>">
								</div>

								<!-- forCat -->
								<%
									if(cat != null) {
								%>
								<div class="form-group">
									<label>Sex</label>
									<input type="text" class="form-control" disabled
										value="<%= cat.isSex() ? "Male" : "Female" %>">
								</div>
								<div class="form-group">
									<label>Age</label>
									<input type="text" class="form-control" disabled value="<%= cat.getAge() %>">
								</div>
								<div class="form-group">
									<label>Color</label>
									<input type="text" class="form-control" disabled value="<%= cat.getColor() %>">
								</div>
								<%
									}
								%>

								<!-- forClothes-->
								<%
									if(clothes != null) {
								%>
								<div class="form-group">
									<label>Color</label>
									<input type="text" class="form-control" disabled value="<%= clothes.getColor() %>">
								</div>
								<div class="form-group">
									<label>Size</label>
									<input type="text" class="form-control" disabled value="<%= clothes.getSize() %>">
								</div>
								<div class="form-group">
									<label>Material</label>
									<input type="text" class="form-control" disabled
										value="<%= clothes.getMaterial() %>">
								</div>
								<%
									}
								%>

								<!-- forFood -->
								<%
									if(food != null) {
								%>
								<div class="form-group">
									<label>D.O.M</label>
									<input type="text" class="form-control" disabled value="<%= food.getDom() %>">
								</div>
								<div class="form-group">
									<label>Exp.</label>
									<input type="text" class="form-control" disabled value="<%= food.getExp() %>">
								</div>
								<div class="form-group">
									<label>Weight</label>
									<input type="text" class="form-control" disabled value="<%= food.getWeight() %>">
								</div>
								<%
									}
								%>

								<div class="form-group">
									<label>Image</label>
									<br />
									<img src="<%= root %>/image/<%= product.getImage() %>" alt="Ảnh chổ này" />
								</div>
								<div class="form-group">
									<a href="<%= root %>/admin/products/edit?id=<%= product.getId() %>"
										class="btn btn-success">Edit</a>
									<a href="<%= root %>/admin/products" class="btn btn-secondary">Go to back</a>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>
			<!-- End Page Content -->

			<!-- Footer -->
			<%@ include file = "../../layouts/footer.jsp" %>
			<!-- End of Footer -->

			<!-- End of Main Content -->

		</div>
		<!-- End of Content Wrapper -->

		<!-- Logout Modal-->
		<%@ include file = "../../layouts/logoutModal.jsp" %>

	</div>
	<!-- End of Page Wrapper -->

	<!-- Bootstrap core JavaScript-->
	<script src="/CatStore/view/admin/static/vendor/jquery/jquery.min.js"></script>
	<script src="/CatStore/view/admin/static/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="/CatStore/view/admin/static/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="/CatStore/view/admin/static/js/sb-admin-2.min.js"></script>

	<!-- Custome Script -->
	<script src="/CatStore/view/admin/static/js/custom.js"></script>

	<!-- Page level plugins -->
	<script src="/CatStore/view/admin/static/vendor/datatables/jquery.dataTables.min.js"></script>
	<script src="/CatStore/view/admin/static/vendor/datatables/dataTables.bootstrap4.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="/CatStore/view/admin/static/js/demo/datatables-demo.js"></script>
	<!-- End of Scripts -->
</body>

</html>