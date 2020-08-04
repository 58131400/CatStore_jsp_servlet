
<%@page import="admin.model.bo.UserBO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="admin.model.bean.User"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Meta -->
<%@ include file = "../layouts/meta.jsp" %>
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
						<h6 class="m-0 font-weight-bold text-primary">User</h6>
					</div>
					<div class="card-body">
						<div class="table-responsive">
							<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
								<thead>								
									<tr>
										
										<th>Id</th>
										<th>Username</th>
										<th>Password</th>										
										<th>Fullname</th>
										<th>Address</th>
										<th>Phone</th>	
										<th>Avatar</th>									
										<th class="non-sorting"></th>
									</tr>
								</thead>
								<tbody>
									<%
							            ArrayList<User> userList = (ArrayList<User>)request.getAttribute("userList");
							            for(User lu: userList){
           							 %>
									<tr>
										<th ><%=lu.getId() %></th>
										<td><%=lu.getUsername() %></td>
										<td><%=lu.getPassword() %></td>
										<td><%=lu.getFullname() %></td>
										<td><%=lu.getAddress() %></td>
										<td><%=lu.getPhonenumber() %></td>						
																					
										<td class="p-1 d-flex align-items-center">
											
											<a href="/CatStore/UserEdit?id=<%= lu.getId() %>" class="btn btn-success btn-circle mr-2">
												<i class="fas fa-pencil-alt"></i>
											</a>
											
											<a href="/CatStore/UserList?action=delete&id=<%= lu.getId() %>" class="btn btn-danger btn-circle mr-2"><i class="fas fa-trash"></i></a>
											<a href="/CatStore/admin/users/authorization?id=<%= lu.getId() %>" class="btn btn-danger btn-circle mr-2"><svg class="bi bi-caret-up-fill" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  <path d="M7.247 4.86l-4.796 5.481c-.566.647-.106 1.659.753 1.659h9.592a1 1 0 00.753-1.659l-4.796-5.48a1 1 0 00-1.506 0z"/>
</svg></a>
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

<!-- Page level plugins -->
<script src="/CatStore/view/admin/static/vendor/datatables/jquery.dataTables.min.js"></script>
<script src="/CatStore/view/admin/static/vendor/datatables/dataTables.bootstrap4.min.js"></script>

<script src="https://unpkg.com/axios/dist/axios.min.js"></script>



<!-- Page level custom scripts -->
<script src="/CatStore/view/admin/static/js/demo/datatables-demo.js"></script>
<!-- End of Scripts -->
</body>
</html>