<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css"
	href="css/style_chitiet_khachhang.css">
<div class="container emp-profile">
	<form method="post" action="myaccount" enctype="multipart/form-data">
		<div class="row">
			<div class="col-md-4">
				<div class="profile-img">
					<img
						src="<%=request.getContextPath() %>/image/User/${user.getAvatar()}"
						alt="" id="photo_img">
					<div class="file btn btn-lg btn-primary">
						Change Photo <input id="input_img" type="file" name="hinh"
							required="required" onchange="readURL(this)" />
					</div>
				</div>
			</div>
			<div class="col-md-8">
				<div class="profile-head">
					<h5>Mã User :</h5>
					<input type="text" name="id" value="${user.getId() }"
						readonly="readonly">
					<ul class="nav nav-tabs" id="myTab" role="tablist">
						<li class="nav-item"><a class="nav-link active" id="home-tab"
							data-toggle="tab" href="#home" role="tab" aria-controls="home"
							aria-selected="true">About</a></li>
					</ul>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-4">
				<div class="profile-work">
					<p>WORK LINK</p>

					<p>LỊCH SỬ GIAO DỊCH</p>
					<a href="?makh=${user.getId() }&paid=1" id="da_mua">Đã thanh
						toán</a><br /> <a href="?makh=${user.getId() }&paid=0" id="chua_mua">chưa
						thanh toán</a><br />

				</div>
			</div>
			<div class="col-md-8">
				<c:if test="${paid == null}"></c:if>
				<div class="tab-content profile-tab" id="myTabContent">
					<div class="tab-pane show active" id="home" role="tabpanel"
						aria-labelledby="home-tab">
						<div class="row">
							<div class="col-md-4">
								<label>Tên khách hàng </label>
							</div>
							<div class="col-md-6">
								<input type="text" name="hoten" value="${user.getFullname() }" required="required" />

							</div>
						</div>
						<div class="row">
							<div class="col-md-4">
								<label>Điện thoại </label>
							</div>
							<div class="col-md-6">
								<input type="text" name="dienthoai" value="${user.getPhone() }" required="required" />

							</div>
						</div>
						<div class="row">
							<div class="col-md-4">
								<label>Địa chỉ</label>
							</div>
							<div class="col-md-6">
								<input type="text" name="diachi" value="${user.getAddress() } " />

							</div>
						</div>
						<div class="row">
							<div class="col-md-4">
								<label>User name</label>
							</div>
							<div class="col-md-6">
								<input type="text" name="username"
									value="${user.getUsername() } " required="required" />

							</div>
						</div>
						<div class="row">
							<div class="col-md-4">
								<label>Password</label>
							</div>
							<div class="col-md-6">
								<input name="password" type="password"
									value="${user.getPassword() } " required="required" />

							</div>
						</div>

					</div>
				</div>
				<div class="form-group">
					<div class="col-xs-12">
						<br>
						<button class="btn btn-lg btn-success pull-center" type="submit"
							name="capnhat">
							<i class="fas fa-check-circle"></i> Cập Nhật
						</button>

					</div>
				</div>
			</div>

			<c:choose>
				<c:when test="${paid==1 }">

					<jsp:include page="/view/fragment/donhang_dathanhtoan.jsp"></jsp:include>

				</c:when>
				<c:otherwise>

					<jsp:include page="/view/fragment/donhang_chuathanhtoan.jsp"></jsp:include>

				</c:otherwise>
			</c:choose>
		</div>
	</form>
</div>
<script type="text/javascript">
	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();

			reader.onload = function(e) {
				$('#photo_img').attr('src', e.target.result)

			};

			reader.readAsDataURL(input.files[0]);
		}
	}
</script>