<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ include file="/common/taglib.jsp" %>


    <!doctype html>
    <html lang="en">
    <meta charset="UTF-8">

    <head>
      <title>Quản lý khách hàng</title>
      <!-- Required meta tags -->
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

      <!-- Bootstrap CSS v5.2.1 -->
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">

    </head>

    <%@ include file="/common/style.jsp" %>

      <body>
        <div class="container-fluid">

          <%@ include file="/common/header.jsp" %>

            <table class="table table-striped table-bordered" style="margin-top: 70px;">
              <thead class="table-dark">
                <tr>
                  <th scope="col">Mã khách hàng</th>
                  <th scope="col">Tên khách hàng</th>
                  <th scope="col">Địa chỉ</th>
                  <th scope="col">Email</th>
                  <th scope="col">Số điện thoại</th>
                </tr>
              </thead>
              <tbody>
                <!-- Thêm các dòng dữ liệu khác vào đây -->
                <c:forEach var="item" items="${ khachhang }">
                  <tr>
                    <td>${ item.maKhachHang }</td>
                    <td>${ item.tenKhachHang }</td>
                    <td>${ item.diaChi }</td>
                    <td>${ item.email }</td>
                    <td>${ item.soDienThoai }</td>
                  </tr>
                </c:forEach>
              </tbody>
            </table>

            <%@ include file="/common/footer.jsp" %>
        </div>

        <!-- Bootstrap JavaScript Libraries -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
          integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous">
          </script>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
          integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz" crossorigin="anonymous">
          </script>
      </body>

    </html>