<%@ page import="admin.model.bean.Category"%>
<%@ page import="admin.model.bean.Product"%>
<%@ page import="admin.model.bean.ProductCat"%>
<%@ page import="admin.model.bean.ProductClothes"%>
<%@ page import="admin.model.bean.ProductFood"%>
<%@ page import="java.util.ArrayList"%>

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

	<title>Product List - Meow</title>
</head>

<body>

	<!-- Page Wrapper  -->
	<div id="wrapper">

		<!-- Sidebar -->
		<%@ include file="../../layouts/sidebar.jsp"%>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->

			<!-- Topbar -->
			<%@ include file="../../layouts/topbar.jsp"%>
			<!-- End of Topbar -->

			<!-- Begin Page Content -->
			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="d-sm-flex align-items-center justify-content-between mb-4">
					<h1 class="h3 mb-0 text-gray-800">Product management</h1>
				</div>

				<%
					String message = (String) session.getAttribute("message");
					if (message != null) {
				%>
				<div class="alert alert-success" role="alert"><%=message%></div>
				<%
					}
				%>
				<%
					String error = (String) session.getAttribute("error");
					if (error != null) {
				%>
				<div class="alert alert-danger" role="alert"><%=error%></div>
				<%
					}
				%>

				<!-- DataTales Example -->
				<div class="card shadow mb-4">
					<div class="card-header py-3">
						<h6 class="m-0 font-weight-bold text-primary">Edit Product</h6>
					</div>
					<%
						Product product = (Product) request.getAttribute("product");
						ProductCat cat = null;
						ProductClothes clothes = null;
						ProductFood food = null;

						if (product instanceof ProductCat) {
							cat = (ProductCat) product;
						} else if (product instanceof ProductClothes) {
							clothes = (ProductClothes) product;
						} else if (product instanceof ProductFood) {
							food = (ProductFood) product;
						}
					%>
					<form class="card-body needs-validation" novalidate method="post" enctype="multipart/form-data">
						<div class="row">
							<div class="col-12 col-md-6">
								<div class="form-group">
									<label>Product name</label>
									<input type="text" class="form-control" required name="name"
										value="<%=product.getName()%>" />
								</div>
								<div class="form-group">
									<label>Price</label>
									<input type="number" class="form-control" min="1" required name="price"
										value="<%=product.getPrice()%>" />
								</div>
								<div class="form-group">
									<label>Amount</label>
									<input type="number" class="form-control" min="1" required name="amount"
										value="<%=product.getAmount()%>">
								</div>
								<div class="form-group">
									<label>Original</label>
									<input type="text" class="form-control" required name="original"
										value="<%=product.getOriginal()%>">
								</div>
								<div class="form-group">
									<label>Description</label>
									<textarea class="form-control" required
										name="description"><%=product.getDescription()%></textarea>
								</div>
								<div class="form-group">
									<label>Date added</label>
									<input type="date" class="form-control" required name="dateAdded"
										value="<%=product.getDateAdded()%>">
								</div>
							</div>
							<div class="user col-12 col-md-6">
								<div class="form-group">
									<label>Category</label>
									<select class="form-control" name="category">
										<%
											@SuppressWarnings("unchecked")
											ArrayList<Category> categories = (ArrayList<Category>) request.getAttribute("categories");
											for (Category c : categories) {
										%>
										<option <%=c.getId().equals(product.getCategory().getId()) ? "selected" : ""%>
											value="<%=c.getId()%>">
											<%=c.getName()%>
										</option>
										<%
											}
										%>
									</select>
								</div>

								<!-- forCat -->
								<%
									if (cat != null) {
								%>
								<div class="form-group">
									<div class="form-group">
										<label class="d-block">Sex</label>
										<div class="form-control border-0">
											<div class="custom-control custom-radio custom-control-inline">
												<input type="radio" class="custom-control-input" id="male" name="sex"
													value="true" <%=cat.isSex() ? "checked" : ""%> required /> <label
													class="custom-control-label" for="male">Male</label>
											</div>
											<div class="custom-control custom-radio custom-control-inline">
												<input type="radio" class="custom-control-input" id="female" name="sex"
													value="false" <%=cat.isSex() ? "" : "checked"%> required /> <label
													class="custom-control-label" for="female">Female</label>
											</div>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label>Age</label> <input type="number" class="form-control" min="1" required
										name="age" value="<%=cat.getAge()%>">
								</div>
								<div class="form-group">
									<label>Color</label> <input type="text" class="form-control" required name="color"
										value="<%=cat.getColor()%>">
								</div>
								<%
									}
								%>

								<!-- forClothes-->
								<%
									if (clothes != null) {
								%>
								<div class="form-group">
									<label>Color</label> <input type="text" class="form-control" required name="color"
										value="<%=clothes.getColor()%>">
								</div>
								<div class="form-group">
									<label>Size</label> <input type="text" class="form-control" required name="size"
										value="<%=clothes.getSize()%>">
								</div>
								<div class="form-group">
									<label>Material</label> <input type="text" class="form-control" required
										name="material" value="<%=clothes.getMaterial()%>">
								</div>
								<%
									}
								%>

								<!-- forFood -->
								<%
									if (food != null) {
								%>
								<div class="form-group">
									<label>D.O.M</label> <input type="date" class="form-control" required name="dom"
										value="<%=food.getDom()%>">
								</div>
								<div class="form-group">
									<label>Exp.</label> <input type="date" class="form-control" required name="exp"
										value="<%=food.getExp()%>">
								</div>
								<div class="form-group">
									<label>Weight</label> <input type="number" class="form-control" min="1" required
										name="weight" value="<%=food.getWeight()%>">
								</div>
								<%
									}
								%>

								<div class="form-group">
									<label>Image</label> <input type="file" name="image" class="form-control-file"
										accept="image/*" />
								</div>
								<div class="form-group">
									<button type="submit" class="btn btn-success">Update</button>
									<button type="reset" class="btn btn-secondary">Reset</button>
									<a href="<%=root%>/admin/products" class="btn btn-secondary">Back
										to list</a>
								</div>
							</div>
						</div>
					</form>
				</div>

			</div>
			<!-- End Page Content -->

			<!-- Footer -->
			<%@ include file="../../layouts/footer.jsp"%>
			<!-- End of Footer -->

			<!-- End of Main Content -->

		</div>
		<!-- End of Content Wrapper -->

		<!-- Logout Modal-->
		<%@ include file="../../layouts/logoutModal.jsp"%>

	</div>
	<!-- End of Page Wrapper -->


	<!-- Bootstrap core JavaScript-->
	<script src="/CatStore/view/admin/static/vendor/jquery/jquery.min.js"></script>
	<script src="/CatStore/view/admin/static/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="/CatStore/view/admin/static/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="/CatStore/view/admin/static/js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script src="/CatStore/view/admin/static/vendor/datatables/jquery.dataTables.min.js"></script>
	<script src="/CatStore/view/admin/static/vendor/datatables/dataTables.bootstrap4.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="/CatStore/view/admin/static/js/demo/datatables-demo.js"></script>

	<script>
		(function () {
			'use strict';
			window.addEventListener('load',
				function () {
					// Fetch all the forms we want to apply custom Bootstrap validation styles to
					var forms = document
						.getElementsByClassName('needs-validation');
					// Loop over them and prevent submission
					var validation = Array.prototype.filter.call(forms,
						function (form) {
							form.addEventListener('submit', function (
								event) {
								if (form.checkValidity() === false) {
									event.preventDefault();
									event.stopPropagation();
								} else {
									form.submit();
								}
								form.classList.add('was-validated');
							}, false);
						});
				}, false);
		})();
	</script>

	<!-- Custome Script -->
	<script src="/CatStore/view/admin/static/js/custom.js"></script>
</body>

</html>