<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Trang quản lý sản phẩm điện thoại</title>
    <style>
      body {
        font-family: Arial, sans-serif;
        text-align: center;
      }
      .header {
        background-color: #f0f0f0;
        padding: 10px;
      }
      .header img {
        max-width: 150px;
      }
      .navbar {
        margin: 10px 0;
      }
      .navbar a {
        margin: 0 15px;
        text-decoration: none;
        color: #0073e6;
      }
      .navbar a:hover {
        text-decoration: underline;
      }
      .content {
        margin: 20px auto;
        width: 80%;
        min-height: 400px;
        border: 1px solid #ccc;
        padding: 10px;
      }
      .footer {
        margin-top: 20px;
        padding: 10px;
        background-color: #f0f0f0;
      }
    </style>
  </head>
  <body>
    <!-- Header Section -->
    <div class="header">
      <img src="fongo_logo.png" alt="Fongo HomePhone Logo" />
    </div>
    <div class="navbar">
      <a href="DanhSachDienThoai.jsp">Danh sách sản phẩm</a>
      <a href="ThemSanPham.jsp">Thêm mới sản phẩm</a>
      <a href="ChucNangQuanLy.jsp">Chức năng quản lý</a>
    </div>
    <div class="content"></div>
    <div class="footer">Họ tên sinh viên - Mã sinh viên - Lớp</div>
  </body>
</html>
