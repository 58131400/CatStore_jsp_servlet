<%@page import="admin.model.bean.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Meta -->

<!-- End of Meta -->

<!-- Link -->
<%@ include file = "../layouts/links.jsp" %>
<!-- Custom styles for this page -->
<link href="/CatStore/view/admin/static/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
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
						<h6 class="m-0 font-weight-bold text-primary">Edit User</h6>
					</div>					
					<div class="card-body">
						<form class="row"  action="" method="post" enctype="multipart/form-data">
							<div class="col-12 col-md-6">
								
								<div class="form-group">
									<label>Id</label>
									<input type="text" name="id" class="form-control"  placeholder="U0001" value="<%=((User)request.getAttribute("user")).getId() %>" readonly="readonly">
								</div>
								<div class="form-group">
									<label>UserName</label>
									<input type="text" name="username" class="form-control" placeholder="Nguyễn Văn Hoàng" value="<%=((User)request.getAttribute("user")).getUsername() %>">
								</div>
								<div class="form-group">
									<label>PassWord</label>
									<input type="password" name="password" class="form-control"  placeholder="Phú Yên" value="P<%=((User)request.getAttribute("user")).getPassword() %>">
								</div>
								<div class="form-group">
									<label>FullName</label>
									<input type="text" name="fullname" class="form-control"  placeholder="0987654321" value="<%=((User)request.getAttribute("user")).getFullname() %>">
								</div>
								<div class="form-group">
									<label>Address</label>
									<input type="text" name="address" class="form-control"  placeholder="0987654321" value="<%=((User)request.getAttribute("user")).getAddress() %>">
								</div>
								<div class="form-group">
									<label>PhoneNumber</label>
									<input type="text" name="phonenumber" class="form-control"  placeholder="0987654321" value="<%=((User)request.getAttribute("user")).getPhonenumber() %>">
								</div>
								<div class="form-group">
									<button class="btn btn-success">Update</button>
									<button type="reset" class="btn btn-secondary">Reset</button>
									<a type="button" class="btn btn-info" href="/CatStore/UserList">Cancel</a>
									
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