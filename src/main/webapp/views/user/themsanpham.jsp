<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="/common/taglib.jsp" %>


        <!doctype html>
        <html lang="en">
        <meta charset="UTF-8">

        <head>
            <title>Thêm sản phẩm</title>
            <!-- Required meta tags -->
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

            <!-- Bootstrap CSS v5.2.1 -->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
                crossorigin="anonymous">

        </head>

        <%@ include file="/common/style1.jsp" %>

            <body>
                <div class="container-fluid">
                    <%@ include file="/common/header1.jsp" %>
                        <div class="container">
                            <div class="d-flex flex-column justify-content-center vh-100" >
                                <h2 class="mb-4" style="margin-top: 60px;">Thêm sản phẩm</h2>
                                <form action="./themsanpham" method="post" enctype="multipart/form-data" >
                                    <div class="row mb-3">
                                        <label for="maSanPham" class="col-sm-2 col-form-label">Mã sản phẩm:</label>
                                        <div class="col-sm-10">
                                            <input type="number" id="maSanPham" name="maSanPham" class="form-control"
                                                required>
                                        </div>
                                    </div>

                                    <div class="row mb-3">
                                        <label for="tenSanPham" class="col-sm-2 col-form-label">Tên sản phẩm:</label>
                                        <div class="col-sm-10">
                                            <input type="text" id="tenSanPham" name="tenSanPham" class="form-control"
                                                required>
                                        </div>
                                    </div>

                                    <div class="row mb-3">
                                        <label for="gia" class="col-sm-2 col-form-label">Giá:</label>
                                        <div class="col-sm-10">
                                            <input type="number" id="gia" name="gia" class="form-control" required>
                                        </div>
                                    </div>

                                    <div class="row mb-3">
                                        <label for="moTa" class="col-sm-2 col-form-label">Mô tả:</label>
                                        <div class="col-sm-10">
                                            <input type="text" id="moTa" name="moTa" class="form-control" required>
                                        </div>
                                    </div>

                                    <div class="row mb-3">
                                        <label for="file" class="col-sm-2 col-form-label">Ảnh:</label>
                                        <div class="col-sm-10">
                                            <input type="file" id="file" name="file" class="form-control" required>
                                        </div>
                                    </div>

                                    <div class="text-center">
                                        <input type="submit" value="Upload" class="btn btn-primary">
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