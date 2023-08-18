<%@page import="poly.edu.entity.SanPham" %>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <%@ include file="/common/taglib.jsp" %>

            <!doctype html>
            <html lang="en">

            <!-- Head -->

            <head>
                <!-- Page Meta Tags-->
                <meta charset="utf-8">
                <meta http-equiv="x-ua-compatible" content="ie=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <meta name="description" content="">
                <meta name="author" content="">
                <meta name="keywords" content="">

                <%@ include file="/common/style1.jsp" %>
                    <!-- Page Title -->
                    <title>OldSkool | Bootstrap 5 HTML Template</title>

            </head>

            <body class="">

                <%@ include file="/common/header1.jsp" %>

                    <!-- Main Section-->
                    <section class="mt-0 ">
                        <!-- Page Content Goes Here -->

                        <!-- Category Top Banner -->
                        <div class="py-10 bg-img-cover bg-overlay-dark position-relative overflow-hidden bg-pos-center-center rounded-0"
                            style="background-image: url(views/user/assets/images/banners/banner-category-top.jpg);">
                            <div class="container-fluid position-relative z-index-20" data-aos="fade-right"
                                data-aos-delay="300">
                                <h1 class="fw-bold display-6 mb-4 text-white">Latest Arrivals</h1>
                                <div class="col-12 col-md-6">
                                    <p class="text-white mb-0 fs-5">
                                        When it's time to head out and get your Kicks on, have a look at our latest
                                        arrivals. Whether you're into Nike, Adidas, Dunks or New Balance, we really have
                                        something for everyone!
                                    </p>
                                </div>
                            </div>
                        </div>
                        <!-- Category Top Banner -->

                        <div class="container-fluid" data-aos="fade-in">
                            <!-- Category Toolbar-->
                            <div class="d-flex justify-content-between items-center pt-5 pb-4 flex-column flex-lg-row">
                                <div>
                                    <nav aria-label="breadcrumb">
                                        <ol class="breadcrumb">
                                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                                            <li class="breadcrumb-item"><a href="#">Sneakers</a></li>
                                            <li class="breadcrumb-item active" aria-current="page">New Releases</li>
                                        </ol>
                                    </nav>
                                    <h1 class="fw-bold fs-3 mb-2">New Releases (121)</h1>
                                    <p class="m-0 text-muted small">Showing 1 - 9 of 121</p>
                                </div>

                            </div> <!-- /Category Toolbar-->

                            <!-- Products-->
                            <div class="row g-4">

                                <c:choose>
                                    <c:when test="${not empty sessionScope.user}">
                                        <div class="row">
                                            <div class="col">
                                                <a href="themsanpham" class="btn btn-success" id="btnThemSanPham"
                                                    style="float: right; margin: 0px;">Thêm sản phẩm</a>
                                            </div>
                                        </div>

                                        <!-- Sử dụng c:forEach để lặp qua danh sách sản phẩm -->
                                        <c:forEach items="${listSanPham}" var="sanPham">
                                            <div class="col-12 col-sm-6 col-lg-4">
                                                <!-- Card Product-->
                                                <div
                                                    class="card border border-transparent position-relative overflow-hidden h-100 transparent">


                                                    <div class="card-img position-relative">

                                                        <div class="card-badges">
                                                            <span class="badge badge-card"><span
                                                                    class="f-w-2 f-h-2 bg-danger rounded-circle d-block me-1"></span>
                                                                Sale</span>
                                                        </div>
                                                        <span
                                                            class="position-absolute top-0 end-0 p-2 z-index-20 text-muted"><i
                                                                class="ri-heart-line"></i></span>
                                                        <picture
                                                            class="position-relative overflow-hidden d-block bg-light">
                                                            <img class="w-100 img-fluid position-relative z-index-10"
                                                                title="" src="getImage?id=${sanPham.maSanPham}" alt="">
                                                        </picture>
                                                        <div
                                                            class="position-absolute start-0 bottom-0 end-0 z-index-20 p-2">
                                                            <a href="thongtinsp?id=${sanPham.maSanPham}"
                                                                class="btn btn-quick-add"><i
                                                                    class="ri-add-line me-2"></i>Xem
                                                                chi tiết</a>
                                                            <a href="chinhsuaSanPham?id=${sanPham.maSanPham}"
                                                                class="btn btn-quick-add"><i
                                                                    class="ri-add-line me-2"></i>Chỉnh
                                                                sửa</a>
                                                            <a href="xoaSanPham?id=${sanPham.maSanPham}"
                                                                class="btn btn-quick-add"><i
                                                                    class="ri-add-line me-2"></i>Xóa</a>
                                                        </div>
                                                    </div>
                                                    <div class="card-body px-0">
                                                        <a class="text-decoration-none"
                                                            href="#">${sanPham.tenSanPham}</a>
                                                        <small class="text-muted d-block">${sanPham.moTa}</small>
                                                        <p class="mt-2 mb-0 small"><s class="text-muted">$329.99</s>
                                                            <span class="text-danger">Giá:
                                                                ${sanPham.gia} VND</span>
                                                        </p>
                                                    </div>

                                                </div>
                                            </div>
                                        </c:forEach>
                                    </c:when>


                                    <c:otherwise>
                                        <!-- Sử dụng c:forEach để lặp qua danh sách sản phẩm -->
                                        <c:forEach items="${listSanPham}" var="sanPham">
                                            <div class="col-12 col-sm-6 col-lg-4">
                                                <!-- Card Product-->
                                                <div
                                                    class="card border border-transparent position-relative overflow-hidden h-100 transparent">


                                                    <div class="card-img position-relative">

                                                        <div class="card-badges">
                                                            <span class="badge badge-card"><span
                                                                    class="f-w-2 f-h-2 bg-danger rounded-circle d-block me-1"></span>
                                                                Sale</span>
                                                        </div>
                                                        <span
                                                            class="position-absolute top-0 end-0 p-2 z-index-20 text-muted"><i
                                                                class="ri-heart-line"></i></span>
                                                        <picture
                                                            class="position-relative overflow-hidden d-block bg-light">
                                                            <img class="w-100 img-fluid position-relative z-index-10"
                                                                title="" src="getImage?id=${sanPham.maSanPham}" alt="">
                                                        </picture>
                                                        <div
                                                            class="position-absolute start-0 bottom-0 end-0 z-index-20 p-2">
                                                            <a href="thongtinsp?id=${sanPham.maSanPham}"
                                                                class="btn btn-quick-add"><i
                                                                    class="ri-add-line me-2"></i>Xem
                                                                chi tiết</a>
                                                        </div>
                                                    </div>
                                                    <div class="card-body px-0">
                                                        <a class="text-decoration-none"
                                                            href="./product.html">${sanPham.tenSanPham}</a>
                                                        <small class="text-muted d-block">${sanPham.moTa}</small>
                                                        <p class="mt-2 mb-0 small"><s class="text-muted">$329.99</s>
                                                            <span  class="product-price" id="formatted-price">Giá:
                                                                ${sanPham.gia} VND</span>
                                                        </p>
                                                    </div>

                                                </div>
                                            </div>
                                        </c:forEach>
                                    </c:otherwise>
                                </c:choose>

                            </div>
                            <!-- / Products-->
                        </div>

                        <!-- /Page Content -->
                    </section>
                    <!-- / Main Section-->

                    <!-- Footer -->
                    <footer class="border-top py-5 mt-4  ">
                        <div class="container-fluid">
                            <div class="d-flex justify-content-between align-items-center flex-column flex-lg-row">
                                <div>
                                    <ul class="list-unstyled">
                                        <li class="d-inline-block me-1"><a
                                                class="text-decoration-none text-dark-hover transition-all" href="#"><i
                                                    class="ri-instagram-fill"></i></a></li>
                                        <li class="d-inline-block me-1"><a
                                                class="text-decoration-none text-dark-hover transition-all" href="#"><i
                                                    class="ri-facebook-fill"></i></a></li>
                                        <li class="d-inline-block me-1"><a
                                                class="text-decoration-none text-dark-hover transition-all" href="#"><i
                                                    class="ri-twitter-fill"></i></a></li>
                                        <li class="d-inline-block me-1"><a
                                                class="text-decoration-none text-dark-hover transition-all" href="#"><i
                                                    class="ri-snapchat-fill"></i></a></li>
                                    </ul>
                                </div>
                                <div class="d-flex align-items-center justify-content-end flex-column flex-lg-row">
                                    <p class="small m-0 text-center text-lg-start">&copy; 2021 OldSkool All Rights
                                        Reserved. Template by <a href="https://www.pixelrocket.store">Pixel Rocket</a>
                                    </p>
                                    <ul
                                        class="list-unstyled mb-0 ms-lg-4 mt-3 mt-lg-0 d-flex justify-content-end align-items-center">
                                        <li class="bg-light p-2 d-flex align-items-center justify-content-center me-2">
                                            <i class="pi pi-sm pi-paypal"></i>
                                        </li>
                                        <li class="bg-light p-2 d-flex align-items-center justify-content-center me-2">
                                            <i class="pi pi-sm pi-mastercard"></i>
                                        </li>
                                        <li class="bg-light p-2 d-flex align-items-center justify-content-center me-2">
                                            <i class="pi pi-sm pi-american-express"></i>
                                        </li>
                                        <li class="bg-light p-2 d-flex align-items-center justify-content-center"><i
                                                class="pi pi-sm pi-visa"></i>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </footer> <!-- / Footer-->
                    
                    <script>
                    // Hàm định dạng giá tiền
                    function formatPrice(price) {
                        return price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".");
                    }

                    // Lấy giá tiền từ biến "sanPham.gia" và định dạng số
                    var priceElement = document.getElementById("formatted-price");
                    var price = ${ sanPham.gia };
                    var formattedPrice = formatPrice(price);

                    // Gán giá tiền đã định dạng vào thẻ HTML
                    priceElement.textContent = formattedPrice + " VND";
                </script>

                    <!-- Offcanvas Imports-->

                    <!-- Theme JS -->
                    <!-- Vendor JS -->
                    <script src="<c:url value='views/user/assets/js/vendor.bundle.js' />"></script>

                    <!-- Theme JS -->
                    <script src="<c:url value='views/user/assets/js/theme.bundle.js' />"></script>
            </body>

            </html>