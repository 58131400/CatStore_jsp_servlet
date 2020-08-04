<%@ page import = "admin.model.bean.User" %>
<%@ page import = "java.util.ArrayList" %>
<% String root = request.getContextPath(); %>

<%
	@SuppressWarnings("unchecked")
	ArrayList<User> users = (ArrayList<User>)request.getAttribute("users");
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

	<title>Customer List - Meow</title>
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
						<h6 class="m-0 font-weight-bold text-primary">Customer</h6>
					</div>
					<div class="card-body">
						<div class="table-responsive">
							<table class="table table-bordered" id="dataTable">
								<thead>
									<tr>
										<th>CustomerId</th>
										<th>Fullname</th>
										<th>Address</th>
										<th>Phone number</th>
										<th class="non-sorting"></th>
									</tr>
								</thead>
								<tbody>
									<%
										for(int i = 0; i < users.size(); i++) {
									%>
									<tr>
										<td><%= users.get(i).getId() %></td>
										<td><%= users.get(i).getFullname() %></td>
										<td><%= users.get(i).getAddress() %></td>
										<td><%= users.get(i).getPhonenumber() %></td>
										<td class="p-1 d-flex align-items-center">
											<a href="<%= root %>/admin/customers/detail?id=<%= users.get(i).getId() %>"
												class="btn btn-primary btn-circle mr-2">
												<i class="fas fa-info"></i>
											</a>

											<a href="<%= root %>/admin/customers/edit?id=<%= users.get(i).getId() %>"
												class="btn btn-success btn-circle mr-2">
												<i class="fas fa-pencil-alt"></i>
											</a>

											<button data-id="<%= users.get(i).getId() %>"
												class="btn btn-danger btn-circle btnDeleteCustomer">
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