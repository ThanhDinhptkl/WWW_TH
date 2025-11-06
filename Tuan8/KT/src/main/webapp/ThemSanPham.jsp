<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8" />
    <title>Thêm sản phẩm mới</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 30px;
        }
        label {
            display: inline-block;
            width: 150px;
            margin-bottom: 8px;
        }
        input, select {
            width: 250px;
            padding: 6px;
        }
        .content {
            border: 1px solid #ccc;
            padding: 20px;
            border-radius: 8px;
            width: 500px;
            margin: 0 auto;
        }
        h2 {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="content">
    <h2>Thêm sản phẩm điện thoại mới</h2>

    <form action="${pageContext.request.contextPath}/ThemSanPhamServlet" method="POST" enctype="multipart/form-data">

        <label for="tenDT">Tên điện thoại:</label>
        <input type="text" id="tenDT" name="tenDT" required /><br /><br />

        <label for="namSanXuat">Năm sản xuất:</label>
        <input type="number" id="namSanXuat" name="namSanXuat" min="2000" max="2025" required /><br /><br />

        <label for="cauHinh">Cấu hình:</label>
        <input type="text" id="cauHinh" name="cauHinh" maxlength="255" required /><br /><br />

        <label for="nhaCungCap">Nhà cung cấp:</label>
        <select id="nhaCungCap" name="nhaCungCap" required>
            <option value="">-- Chọn nhà cung cấp --</option>
            <c:forEach var="ncc" items="${nhaCungCapList}">
                <option value="${ncc.maNCC}">${ncc.tenNCC}</option>
            </c:forEach>
        </select><br /><br />

        <label for="hinhAnh">Hình ảnh (png, jpg, jpeg):</label>
        <input type="file" id="hinhAnh" name="hinhAnh" accept=".png,.jpg,.jpeg" /><br /><br />

        <input type="submit" value="Thêm sản phẩm" />
    </form>
</div>
</body>
</html>
