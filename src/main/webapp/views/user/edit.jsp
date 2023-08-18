<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="/common/taglib.jsp" %>


        <!doctype html>
        <html lang="en">
        <meta charset="UTF-8">

        <head>
            <title>Chỉnh sửa sản phẩm</title>
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
                max-width: 200px;
                max-height: 200px;
            }
        </style>

        <%@ include file="/common/style1.jsp" %>

            <body>
                <div class="container-fluid">
                    <%@ include file="/common/header1.jsp" %>
                        <div class="container">
                            <div class="d-flex flex-column justify-content-center vh-100">
                            <h2 class="mb-4" style="margin-top: 300px;">Chỉnh sửa sản phẩm</h2>
                                <form action="./capnhatSanPham" method="post" enctype="multipart/form-data">
                                    <div class="row mb-3">
                                        <div class="col-sm-6">
                                        <label for="maSanPham" class=" col-form-label">Mã sản phẩm:</label>
                                            <input disabled name="maSanPham" value="${sanPham.maSanPham}" class="form-control">
                                        </div>
                                        <div class="col-sm-6">
                                        <label for="tenSanPham" class=" col-form-label">Tên sản phẩm:</label>
                                            <input type="text" name="tenSanPham" id="tenSanPham"
                                                value="${sanPham.tenSanPham}" class="form-control">
                                        </div>
                                    </div>

                                    <div class="row mb-3">
                                        <div class="col-sm-6">
                                         <label for="gia" class="col-sm-2 col-form-label">Giá:</label>
                                            <input type="text" name="gia" value="${sanPham.gia}" id="gia"
                                                class="form-control">
                                        </div>
                                        
                                        
                                    </div>

                                    <div class="row mb-3">
                                        <div class="col-sm-8">
                                        <label for="moTa" class="col-sm-2 col-form-label">Mô tả:</label>
                                            <textarea name="moTa" id="moTa" cols="30"
                                                rows="10">${sanPham.moTa}</textarea>
                                        </div>
                                    </div>

                                    <div class="text-center">
                                        <input type="submit" value="Cập nhật" class="btn btn-primary mb-4">
                                    </div>
                                </form>
                            </div>
                        </div>
                </div>
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