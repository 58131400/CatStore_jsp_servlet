<%@ page import = "admin.model.bean.Orders" %>
<%@ page import = "admin.model.bean.OrdersDetail" %>
<%@ page import = "admin.model.bean.User" %>
<%@ page import = "java.util.ArrayList" %>
<% String root = request.getContextPath(); %>

<%
	@SuppressWarnings("unchecked")
	ArrayList<User> users = (ArrayList<User>)request.getAttribute("users");
	Orders orders = (Orders)request.getAttribute("orders"); 
	ArrayList<OrdersDetail> ordersDetail = orders.getOrdersDetail();
%>

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

	<title>Edit orders - Meow</title>
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
					<h1 class="h3 mb-0 text-gray-800">Order management</h1>
				</div>
				
				<%
					String message = (String)session.getAttribute("message");
					if(message != null) {
				%>
					<div class="alert alert-success" role="alert">
						<%= message %>
					</div>
				<%
					}
				%>
				
				<%
					String error = (String)session.getAttribute("error");
					if(error != null) {
				%>
					<div class="alert alert-danger" role="alert">
						<%= error %>
					</div>
				<%
					}
				%>
				

				<!-- DataTales Example -->
				<div class="card shadow mb-4">
					<div class="card-header py-3">
						<h6 class="m-0 font-weight-bold text-primary">Edit Order</h6>
					</div>
					<div class="card-body">
						<form class="row needs-validation" novalidate method="post">
							<div class="col-12 col-md-6">
								<div class="form-group">
									<label>Customer</label>
									<select class="form-control" name="userId" required>
										<%
											for(int i = 0; i < users.size(); i++) {
										%>
										<option value="<%= users.get(i).getId() %>"
											<%= users.get(i).getId().equals(orders.getUser().getId()) ? "selected" : "" %>>
											<%= users.get(i).getFullname() %></option>
										<%
											}
										%>
									</select>
								</div>
								<div class="form-group">
									<label>Order Date</label>
									<input
										type="date"
										class="form-control"
										name="orderDate"
										value="<%= orders.getOrderDate() %>"
										required
									/>
								</div>
								<div class="form-group">
									<label>Status</label>
									<select class="form-control" name="status" required>
										<option value="true" <%= orders.getStatus() ? "selected" : "" %>>Đã giao</option>
										<option value="false" <%= orders.getStatus() ? "" : "selected" %>>Chưa giao</option>
									</select>
								</div>
							</div>

							<!-- Order Items -->
							<div class="table-responsive col-12">
								<div class="form-group">
									<div class="form-group d-flex justify-content-between align-item-center mb-2 mt-1">
										<label class="m-0 align-self-center">Items Ordered</label>
										<button type="button" class="btn btn-primary btnCreateProduct">Add product</button>
									</div>
									<table class="table table-bordered" id="dataTable">
										<thead>
											<tr>
												<th>Product Id</th>
												<th>Amount</th>
												<th></th>
											</tr>
										</thead>
										<tbody id="product-list">
											<%
											for(int i = 0; ordersDetail != null && i < ordersDetail.size(); i++) {
										%>
											<tr class="item">
												<td>
													<input
														type="text"
														class="form-control"
														name="productId"
														required
														value="<%= ordersDetail.get(i).getProduct().getId() %>"
													/>
												</td>
												<td>
													<input
														type="number"
														class="form-control"
														name="amount"
														required
														min="1"
														value="<%= ordersDetail.get(i).getAmount() %>"
													/>
												</td>
												<td>
													<button
														type="button" class="btn btn-danger btn-circle deleteOrdersDetailBtn">
														<i class="fas fa-trash"></i>
													</button>
												</td>
											</tr>
											<%
											}
										%>
										</tbody>
									</table>

								</div>

							</div>

							<div class="col-12">
								<div class="form-group">
									<button type="submit" class="btn btn-success">Update</button>
									<button type="reset" class="btn btn-secondary">Reset</button>
									<a href="<%= root %>/admin/orders" class="btn btn-secondary">Cancel</a>
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

	<!-- Axios -->
	<script src="https://unpkg.com/axios/dist/axios.min.js"></script>

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

	<!-- Custome Script -->
	<script src="/CatStore/view/admin/static/js/custom.js"></script>
</body>

</html>