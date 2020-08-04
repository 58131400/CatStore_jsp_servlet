<%@ page contentType="text/html; charset=UTF-8" %>
<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

	<!-- Sidebar - Brand -->
	<a class="sidebar-brand d-flex align-items-center justify-content-center" href="/CatStore/admin">
		<div class="sidebar-brand-icon rotate-n-15">
			<i class="fas fa-laugh-wink"></i>
		</div>
		<div class="sidebar-brand-text mx-3">Meow</div>
	</a>

	<!-- Divider -->
	<hr class="sidebar-divider my-0">

	<!-- Nav Item - Dashboard -->
	<li class="nav-item active">
		<a class="nav-link" href="/CatStore/admin">
			<i class="fas fa-fw fa-tachometer-alt"></i>
			<span>Dashboard</span>
		</a>
	</li>

	<!-- Divider -->
	<hr class="sidebar-divider">

	<!-- Nav Item - Pages Collapse Menu -->
	<li class="nav-item">
		<a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#product" aria-expanded="true"
			aria-controls="product">
			<i class="fas fa-archive"></i>
			<span>Product Management</span>
		</a>
		<div id="product" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<a class="collapse-item" href="/CatStore/admin/products">List</a>
				<a class="collapse-item" href="/CatStore/admin/products/create">Create new product</a>
			</div>
		</div>
	</li>
	
	<li class="nav-item">
		<a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#order" aria-expanded="true"
			aria-controls="order">
			<i class="fas fa-briefcase"></i>
			<span>Order Management</span>
		</a>
		<div id="order" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<a class="collapse-item" href="/CatStore/admin/orders">List</a>
				<a class="collapse-item" href="/CatStore/admin/orders/create">Create new order</a>
			</div>
		</div>
	</li>

	

	<li class="nav-item">
		<a class="nav-link collapsed" href="/" data-toggle="collapse" data-target="#employee" aria-expanded="true"
			aria-controls="employee">
			<i class="fas fa-users"></i>
			<span>User Management</span>
		</a>
		<div id="employee" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<a class="collapse-item" href="/CatStore/UserList">List</a>
				
				<a class="collapse-item" href="/CatStore/usercreate">Create new User</a>
			</div>
		</div>
	</li>

	<!-- Divider -->
	<hr class="sidebar-divider">

	<!-- Sidebar Toggler (Sidebar) -->
	<div class="text-center d-none d-md-inline">
		<button class="rounded-circle border-0" id="sidebarToggle"></button>
	</div>

</ul>