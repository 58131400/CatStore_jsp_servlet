<%@ page import = "admin.model.bean.Category" %>
<%@ page import = "java.util.ArrayList" %>
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

	<title>Create new product - Meow</title>
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

				<%
					String message = (String)session.getAttribute("message");
					if(message != null && message != "") {
				%>
				<!-- Message -->
				<div class="alert alert-success" role="alert"><%= message %></div>
				<%
					}
				%>
				<%
					String error = (String)session.getAttribute("error");
					if(error != null && error != "") {
				%>
				<!-- Message -->
				<div class="alert alert-danger" role="alert"><%= error %></div>
				<%
					}
				%>

				<!-- DataTales Example -->
				<div class="card shadow mb-4">
					<div class="card-header py-3">
						<h6 class="m-0 font-weight-bold text-primary">Create Product</h6>
					</div>
					<div class="card-body">
						<form class="row needs-validation" novalidate method="post" enctype="multipart/form-data">
							<div class="col-12 col-md-6">
								<div class="form-group">
									<label>Category</label>
									<select id="category" name="type" class="form-control" required>
										<option value="" disabled selected hidden="true">Select</option>
										<option value="CA">Mèo</option>
										<option value="FD">Thức ăn</option>
										<option value="CL">Quần áo</option>
									</select>
								</div>
								<div class="form-group">
									<label>Product name</label>
									<input type="text" class="form-control" placeholder="Enter product name" name="name"
										required />
								</div>
								<div class="form-group">
									<label>Price</label>
									<input type="text" class="form-control" placeholder="Enter product price"
										pattern="[1-9]\d*(\.\d+)?" name="price" required />
								</div>
								<div class="form-group">
									<label>Amount</label>
									<input type="number" class="form-control" placeholder="Enter product amount"
										required name="amount" min="1" />
								</div>
								<div class="form-group">
									<label>Original</label>
									<input type="text" class="form-control" placeholder="Enter product original"
										name="original" required />
								</div>
								<div class="form-group">
									<label>Description</label>
									<textarea class="form-control" placeholder="Enter product description"
										name="description"></textarea>
								</div>
							</div>
							<div class="user col-12 col-md-6">
								<div class="form-group">
									<label>Sub Category</label>
									<select name="category" class="form-control" required>
										<option value="" disabled selected hidden="true">Select</option>
										<%
											@SuppressWarnings("unchecked")
											ArrayList<Category> categories = (ArrayList<Category>)request.getAttribute("categories");
											for(int i = 0; i < categories.size(); i++) {
										%>
										<option value="<%= categories.get(i).getId() %>">
											<%= categories.get(i).getName() %>
										</option>
										<%
											}
										%>
									</select>
								</div>
								<div id="productMoreInfo"></div>
								<div class="form-group">
									<label>Image</label>
									<input type="file" class="form-control-file" name="image" accept="image/*" />
								</div>
							</div>
							<div class="user col-12 col-md-6">
								<div class="form-group">
									<button type="submit" class="btn btn-primary">Create</button>
									<button type="reset" class="btn btn-secondary">Reset</button>
									<a href="<%= root %>/admin/products" class="btn btn-secondary">Back to list</a>
								</div>
							</div>
						</form>
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

	<script>
		(function () {
			'use strict';
			window.addEventListener('load', function () {
				// Fetch all the forms we want to apply custom Bootstrap validation styles to
				var forms = document.getElementsByClassName('needs-validation');
				// Loop over them and prevent submission
				var validation = Array.prototype.filter.call(forms, function (form) {
					form.addEventListener('submit', function (event) {
						if (form.checkValidity() === false) {
							console.log(1);
							event.preventDefault();
							event.stopPropagation();
						} else {
							console.log(2);
							form.submit();
						}
						form.classList.add('was-validated');
					}, false);
				});
			}, false);
		})();
	</script>
	<!-- End of Scripts -->

	<script src="/CatStore/view/admin/static/js/productCreate.js"></script>
	<!-- End of Scripts -->
</body>

</html>