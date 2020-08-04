<%@ page import = "admin.model.bean.User" %>
<%@ page import = "java.util.ArrayList" %>
<% String root = request.getContextPath(); %>

<%
	User user = (User)request.getAttribute("user");
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

	<title>Customer Detail - Meow</title>
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
					<h1 class="h3 mb-0 text-gray-800">Customer Management</h1>
				</div>

				<!-- DataTales Example -->
				<div class="card shadow mb-4">
					<div class="card-header py-3">
						<h6 class="m-0 font-weight-bold text-primary">Customer Detail</h6>
					</div>
					<div class="card-body">
						<div class="row">
							<div class="col-12 col-md-6">
								<div class="form-group">
									<label>CustomerId</label>
									<input type="text" class="form-control" disabled value="<%= user.getId() %>">
								</div>
								<div class="form-group">
									<label>Fullname</label>
									<input type="text" class="form-control" disabled value="<%= user.getFullname() %>">
								</div>
								<div class="form-group">
									<label>Address</label>
									<input type="text" class="form-control" disabled value="<%= user.getAddress() %>">
								</div>
								<div class="form-group">
									<label>Phone</label>
									<input type="text" class="form-control" disabled
										value="<%= user.getPhonenumber() %>">
								</div>
								<div class="form-group">
									<label>Username</label>
									<input type="text" class="form-control" disabled value="<%= user.getUsername() %>">
								</div>
								<div class="form-group">
									<label>Password</label>
									<input type="text" class="form-control" disabled value="<%= user.getPassword() %>">
								</div>
								<div class="form-group">
									<a href="<%= root %>/admin/customers/edit?id=<%= user.getId() %>"
										class="btn btn-success">Edit</a>
									<a href="<%= root %>/admin/customers" class="btn btn-info">Back to list</a>
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

	<!-- Axios -->
	<script src="https://unpkg.com/axios/dist/axios.min.js"></script>

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