<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="/common/taglib.jsp" %>


        <!doctype html>
        <html lang="en">
        <meta charset="UTF-8">

        <head>
            <title>Trang chủ</title>
            <!-- Required meta tags -->
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

            <!-- Bootstrap CSS v5.2.1 -->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
                crossorigin="anonymous">

        </head>

        <style>
            img {
                max-width: 420px;
                max-height: 450px;
            }

            .product-title {
                font-size: 24px;
                font-weight: bold;
                color: #333;
                margin-bottom: 10px;
            }

            .product-price {
                font-size: 24px;
                font-weight: bold;
                color: #ff3366;
                position: relative;
                display: inline-block;
            }

            .product-price::before {
                content: '';
                position: absolute;
                width: 100%;
                height: 2px;
                bottom: 0;
                left: 0;
                background-color: #ff3366;
                transform: scaleX(0);
                transform-origin: left;
                transition: transform 0.3s ease;
            }

            .product-price:hover::before {
                transform: scaleX(1);
            }

            .content-list {
                list-style: none;
                padding: 0;
            }

            .content-list li {
                display: inline-block;
                margin-right: 10px;
            }

            .content-list a {
                text-decoration: none;
                margin-right: 10px;
            }

            .gray-text {
                color: #999;
            }

            .btn:hover {
                transform: translateY(-2px);
            }

            .btn:active {
                transform: translateY(2px);
            }
        </style>

        <%@ include file="/common/style1.jsp" %>

            <body>
                <div class="container-fluid">
                    <%@ include file="/common/header1.jsp" %>

                        <div class="d-flex justify-content-center align-items-center vh-100" style="margin-top: 80px;">
                            <div class="row">
                                <div class="col-md-6">
                                    <!-- Hiển thị ảnh sản phẩm -->
                                    <img src="getImage?id=${sanPham.maSanPham}" alt="Hình ảnh sản phẩm"
                                        class="img-fluid">
                                </div>
                                <div class="col-md-6">
                                    <h2 class="product-title">${sanPham.tenSanPham}</h2>

                                    <h4 class="product-price" id="formatted-price">${sanPham.gia} VND</h4>

                                    <div class="container mt-4">
                                        <div class="row">
                                            <ul class="content-list">
                                                <li class="gray-text">Bảo Hiểm</li>
                                                <li class="">Quyền lợi tiêu dùng</li>
                                            </ul>
                                        </div>

                                        <div class="row">
                                            <ul class="content-list">
                                                <li class="gray-text">Vận Chuyển</li>
                                                <li class="gray-text">Không có đơn vị vận chuyển hỗ trợ, vui lòng liên
                                                    hệ Người bán</li>
                                            </ul>
                                        </div>
                                    </div>

                                    <div class="container mt-4">
                                        <div class="row">
                                            <ul class="content-list">
                                                <a href="#">Tìm hiểu thêm</a>
                                            </ul>
                                        </div>
                                    </div>

                                    <p class="mt-4">Mô tả: ${sanPham.moTa}</p>

                                    <div class="mt-4">
                                        <button type="button" class="btn btn-warning btn-lg">Mua ngay</button>
                                        <button type="button" class="btn btn-danger btn-lg">Thêm vào giỏ hàng</button>
                                    </div>

                                    <div class="container mt-4">
                                        <div class="row">
                                            <div class="col-md-4">
                                                <ul class="content-list">
                                                    <li class="gray-text">7 ngày miễn phí trả hàng</li>
                                                </ul>
                                            </div>

                                            <div class="col-md-4">
                                                <ul class="content-list">
                                                    <li class="gray-text">Hàng chính hãng 100%</li>
                                                </ul>
                                            </div>

                                            <div class="col-md-4">
                                                <ul class="content-list">
                                                    <li class="gray-text">Miễn phí vận chuyển</li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                </div>

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

                
                <%@ include file="/common/footer.jsp" %>
                    <!-- Bootstrap JavaScript Libraries -->
                    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
                        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
                        crossorigin="anonymous">
                        </script>

                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
                        integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
                        crossorigin="anonymous">
                        </script>
            </body>

        </html>