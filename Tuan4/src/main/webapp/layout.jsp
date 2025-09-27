<%--
  Created by IntelliJ IDEA.
  User: ThanhDinh
  Date: 9/28/2025
  Time: 2:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Quản lý Tin tức</title>
  <style>
    body { font-family: Arial, sans-serif; margin: 0; padding: 0; }
    .menu { background: #f0f0f0; padding: 10px; text-align: center; }
    .menu a { margin: 0 15px; text-decoration: none; font-weight: bold; color: #333; }
    .menu a:hover { color: blue; }
    .content { min-height: 400px; padding: 20px; border: 1px solid #ccc; }
    .footer { background: #f0f0f0; text-align: center; padding: 10px; font-size: 14px; }
  </style>
</head>
<body>

<div class="menu">
  <a href="danhsach?madm=1">Danh sách tin tức</a> |
  <a href="TinTucForm.jsp">Thêm tin tức mới</a> |
  <a href="quanly.jsp">Chức năng quản lý</a>
</div>

<div class="content">
  <jsp:include page="${contentPage}" />
</div>

<div class="footer">
  Họ tên sinh viên – Mã sinh viên – Lớp
</div>

</body>
</html>
