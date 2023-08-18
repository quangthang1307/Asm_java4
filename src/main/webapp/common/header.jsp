<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
    <div class="container-fluid">
      <a class="navbar-brand" href="#!"><span class="text-warning">Quiz</span>POLY</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
        aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse justify-content-center" id="navbarNavDropdown">
        <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
        <c:choose>
        	<c:when test="${not empty sessionScope.user}">
        		<li class="nav-item"><a class="nav-link" href="index">Trang chủ</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="khachhang">Quản lý
						khách hàng</a></li>
				<li class="nav-item"><a class="nav-link" href="sanpham">Sản phẩm</a>
				</li>
				<li class="nav-item dropdown">
					<div class="dropdown" style="margin-right: 40px;">
						<a class="btn btn-warning dropdown-toggle" href="#"
							role="button" id="dropdownMenuLink" data-bs-toggle="dropdown"
							aria-expanded="false">${sessionScope.user.hoTen}</a>
						<ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
							<li><a class="dropdown-item" href="#">Tài khoản</a></li>
							<li><a class="dropdown-item" href="logout">Đăng xuất</a></li>
						</ul>
					</div>
				</li>
        	</c:when>
        	
        	<c:otherwise>
        		<li class="nav-item"><a class="nav-link" href="index">Trang chủ</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="sanpham">Sản phẩm</a>
				</li>
				<li class="nav-item dropdown">
					<div class="dropdown" style="margin-right: 40px;">
						<a class="btn btn-secondary dropdown-toggle" href="#"
							role="button" id="dropdownMenuLink" data-bs-toggle="dropdown"
							aria-expanded="false">Thông tin</a>
						<ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
							<li><a class="dropdown-item" href="login">Đăng nhập</a></li>
							<li><a class="dropdown-item" href="register">Đăng ký</a></li>
						</ul>
					</div>
				</li>
        	</c:otherwise>
        </c:choose>
			</ul>
      </div>
    </div>
  </nav>