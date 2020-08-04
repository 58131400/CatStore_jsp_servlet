<%@ page import = "admin.model.bean.User" %>
<%@ page import = "admin.model.bean.Role" %>
<%@ page import = "catStore.util.Utils" %>

<%@ page import = "java.util.ArrayList" %>
<% String root = request.getContextPath(); %>

<%
	User userInfo = (User)request.getAttribute("userInfo");
	@SuppressWarnings("unchecked")
	ArrayList<Role> roles = (ArrayList<Role>)request.getAttribute("roles"); 
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

	<title>Authorization - Meow</title>
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
					<h1 class="h3 mb-0 text-gray-800">User management</h1>
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
						<h6 class="m-0 font-weight-bold text-primary">Authorization - <%= userInfo.getFullname() %></h6>
					</div>
					<div class="card-body">
						<form class="row" method="post">
							<div class="col-12">
								<div class="form-check">
									<input class="form-check-input" type="checkbox" name="fullRole" value="fullRole" id="fullRole">
									<label class="form-check-label" for="fullRole">Full</label>
								</div>
								<%
									for(Role role: roles) {
								%>
								<div class="form-check my-2">
									<input
										class="form-check-input" type="checkbox" name="role"
										<%=Utils.isInList(userInfo.getRoles(), role) ? "checked" : "" %>
										value="<%=role.getId() %>" id="<%=role.getId() %>">
									<label class="form-check-label" for="<%=role.getId() %>"><%=role.getName() %></label>
								</div>
								<%
									}
								%>
							</div>
							<div class="form-group">
								<button type="submit" class="btn btn-primary">Update</button>
								<button type="reset" class="btn btn-secondary">Reset</button>
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