<%@page import="admin.model.bean.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Meta -->
<%@ include file = "../layouts/meta.jsp" %>
<!-- End of Meta -->

<!-- Link -->
<%@ include file = "../layouts/links.jsp" %>
<!-- Custom styles for this page -->
<link href="../../static/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
<!-- End of Link -->


<title>Meow</title>
</head>
<body>

<!-- Page Wrapper  -->
<div id="wrapper">

	<!-- Sidebar -->
	<%@ include file = "../layouts/sidebar.jsp" %>
	<!-- End of Sidebar -->

	<!-- Content Wrapper -->
	<div id="content-wrapper" class="d-flex flex-column">
	
		<!-- Main Content -->
		
			<!-- Topbar -->
			<%@ include file = "../layouts/topbar.jsp" %>
			<!-- End of Topbar -->
			
			<!-- Begin Page Content -->
			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="d-sm-flex align-items-center justify-content-between mb-4">
					<h1 class="h3 mb-0 text-gray-800">User management</h1>
				</div>
			
				<!-- DataTales Example -->
				<div class="card shadow mb-4">
					<div class="card-header py-3">
						<h6 class="m-0 font-weight-bold text-primary">Create User</h6>
					</div>
					<div class="card-body">
						<form class="row needs-validation" novalidate action="/CatStore/usercreate" method="post">
							<div class="col-12 col-md-6">
								
								<div class="form-group">
									<label>Username</label>
									<input type="text" name="username" class="form-control" placeholder="Enter fullname" 
									 required> 
								</div>
								<div class="form-group">
									<label>Password</label>
									<input type="text" name="password" class="form-control"  placeholder="Enter address" 
									 required>
								</div>
								<div class="form-group">
									<label>Fullname</label>
									<input type="text" name="fullname" class="form-control" placeholder="Enter fullname" 
									 required> 
								</div>
								<div class="form-group">
									<label>Address</label>
									<input type="text" name="address" class="form-control"  placeholder="Enter address" 
									 required>
								</div>
								<div class="form-group">
									<label>Phone</label>
									<input type="text" name="phonenumber" class="form-control"  placeholder="Enter phone" 
								 required>
								</div>
								<div class="form-group">
									<button type="submit" name="submit" class="btn btn-primary">Create</button>
									<button type="reset" class="btn btn-secondary">Reset</button>
									<button class="btn btn-info">Cancel</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			
			</div>			
			<!-- End Page Content -->
			
			<!-- Footer -->
				<%@ include file = "../layouts/footer.jsp" %>
			<!-- End of Footer -->
		
		<!-- End of Main Content -->
	
	</div>
	<!-- End of Content Wrapper -->
	
	<!-- Back to top -->
	<%@ include file = "../layouts/backToTop.jsp" %>
	
	<!-- Logout Modal-->
	<%@ include file = "../layouts/logoutModal.jsp" %>

</div>
<!-- End of Page Wrapper -->


<!-- Scripts -->
<%@ include file = "../layouts/scripts.jsp" %>
<!-- End of Scripts -->
</body>
</html>