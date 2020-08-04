<%@ page import = "java.util.ArrayList" %>

<%@ page import = "admin.model.bean.Orders" %>
<%@ page import = "admin.model.bean.OrdersDetail" %>
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

	<title>Orders Detail - Meow</title>
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

				<!-- DataTales Example -->
				<div class="card shadow mb-4">
					<div class="card-header py-3">
						<h6 class="m-0 font-weight-bold text-primary">Order detail</h6>
					</div>
					<div class="card-body">
						<div class="row">
							<%
								Orders orders = (Orders)request.getAttribute("orders");
							%>
							<div class="col-12 col-md-6">
								<div class="form-group">
									<label>Customer</label>
									<input class="form-control" value="<%= orders.getUser().getId() %>" disabled />
								</div>
								<div class="form-group">
									<label>Order Date</label>
									<input class="form-control" value="<%= orders.getOrderDate() %>" disabled />
								</div>
								<div class="form-group">
									<label>Status</label>
									<input class="form-control"
										value="<%= orders.getStatus() ? "Đã giao" : "Chưa giao" %>" disabled />
								</div>
							</div>

							<!-- Order Items -->
							<div class="table-responsive col-12">
								<div class="form-group">
									<div class="form-group d-flex justify-content-between align-item-center mb-2 mt-1">
										<label class="m-0 align-self-center">Items Ordered</label>
									</div>
									<table class="table table-bordered" id="dataTable">
										<thead>
											<tr>
												<th>Product Name</th>
												<th>Price</th>
												<th>Amount</th>
												<th>Discount</th>
												<th>Subtotal</th>
											</tr>
										</thead>
										<tbody>
											<%
											ArrayList<OrdersDetail> ordersDetail = orders.getOrdersDetail();
											for(int i = 0; ordersDetail != null && i < ordersDetail.size(); i++) {
										%>
											<tr>
												<td><%= ordersDetail.get(i).getProduct().getName() %></td>
												<td><%= ordersDetail.get(i).getPrice() %></td>
												<td><%= ordersDetail.get(i).getAmount() %></td>
												<td><%= 0 %></td>
												<td><%= ordersDetail.get(i).getPrice() * ordersDetail.get(i).getAmount() %>
												</td>
											</tr>
											<%
											}
										%>
											<tr>
												<th colspan="4" class="text-right">Total:</th>
												<td><%= orders.getTotal() %></td>
											</tr>
										</tbody>
									</table>
								</div>

							</div>

							<div class="col-12">
								<div class="form-group">
									<a href="<%= root %>/admin/orders/edit?id=<%= orders.getId() %>"
										class="btn btn-success">Update</a>
									<a href="<%= root %>/admin/orders" class="btn btn-secondary">Cancel</a>
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

</body>

</html>