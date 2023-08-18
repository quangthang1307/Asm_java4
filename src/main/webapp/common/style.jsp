<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <style>
    * {
      font-family: Quicksand, Helvetica, Arial;
    }

    body {
      background: f1fbff;
    }

    /* khoảnh cách */
    .section-padding {
      padding: 100px;
    }

    /* kích thước ảnh */
    .carousel-item {
      height: 100vh;
      min-height: 300px;
    }

    /* cách chữ, nổi chữ */
    .carousel-caption {
      bottom: 220px;
      z-index: 2;
    }

    /* chỉnh font chữ */
    .carousel-caption h5 {
      font-size: 45px;
      text-transform: uppercase;
      letter-spacing: 2px;
      margin-top: 25px;
    }

    .carousel-caption p {
      width: 60%;
      margin: auto;
      font-size: 18px;
      line-height: 1.9;
    }

    /* đổ nền tối */
    .carousel-inner::before {
      content: '';
      position: absolute;
      width: 100%;
      height: 100%;
      top: 0;
      left: 0;
      background: rgba(0, 0, 0, 0.7);
      z-index: 1;
    }

    .navbar-nav a {
      font-size: 15px;
      text-transform: uppercase;
      font-weight: 500;
    }

    .navbar-light .navbar-brand {
      color: #000;
      font-size: 25px;
      text-transform: uppercase;
      font-weight: 700;
      letter-spacing: 2px;
    }

    /* di chuyển chuột đến navbar dổi màu */
    .navbar-light .navbar-brand:focus,
    .navbar-light .navbar-brand:hover {
      color: #000;
    }

    .navbar-light .navbar-nav .navbar-link {
      color: #000;
    }

    article,
    .sheet>aside.col-sm-3 {
      padding: 5px;
    }

    .services .card-body i {
      font-size: 50px;
    }

    .team .card-body i {
      font-size: 20px;
    }

    /* đổ bóng */
    .porfolio .card {
      box-shadow: 15px 15px 40px rgb(0, 0, 0, 0.15);
    }

    .team .card {
      box-shadow: 15px 15px 40px rgb(0, 0, 0, 0.15);
    }

    .image-card {
      transition: transform 0.3s;
    }

    .image-card:hover {
      transform: scale(1.05);
    }
  </style>