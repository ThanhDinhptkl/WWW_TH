<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh sách nhà cung cấp</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 30px; background-color: #f9f9f9; }
        h2 { text-align: center; color: #333; }
        form { text-align: center; margin-bottom: 20px; }
        input[type="text"] { width: 300px; padding: 6px; border-radius: 4px; border: 1px solid #ccc; }
        input[type="submit"] {
            padding: 6px 12px;
            background-color: #007bff;
            color: white;
            border: none;
            cursor: pointer;
            border-radius: 4px;
        }
        input[type="submit"]:hover { background-color: #0056b3; }
        table { width: 100%; border-collapse: collapse; background: white; box-shadow: 0 2px 5px rgba(0,0,0,0.1); }
        th, td { border: 1px solid #ccc; padding: 8px; text-align: center; }
        th { background-color: #007bff; color: white; }
        a { color: #007bff; text-decoration: none; }
        a:hover { text-decoration: underline; }
        .back-button {
            display: inline-block;
            margin: 20px 0;
            padding: 6px 12px;
            background-color: #28a745;
            color: white;
            border-radius: 4px;
            text-decoration: none;
        }
        .back-button:hover { background-color: #218838; }
    </style>
</head>
<body>
<h2>Danh sách nhà cung cấp</h2>

<!-- 🔍 Thanh tìm kiếm -->
<form action="${pageContext.request.contextPath}/nha-cung-cap" method="get">
    <input type="text" name="keyword" placeholder="Nhập mã, tên, địa chỉ hoặc SĐT..." value="${param.keyword}">
    <input type="submit" value="Tìm kiếm">
</form>

<!-- 🧾 Bảng hiển thị danh sách NCC -->
<table>
    <tr>
        <th>Mã NCC</th>
        <th>Tên NCC</th>
        <th>Địa chỉ</th>
        <th>Số điện thoại</th>
        <th>Danh sách sản phẩm</th>
    </tr>
    <c:forEach var="ncc" items="${nhaCungCapList}">
        <tr>
            <td>${ncc.maNCC}</td>
            <td>${ncc.tenNCC}</td>
            <td>${ncc.diaChi}</td>
            <td>${ncc.soDienThoai}</td>
            <td>
                <a href="${pageContext.request.contextPath}/dien-thoai-theo-ncc?maNCC=${ncc.maNCC}">
                    Xem sản phẩm
                </a>
            </td>
        </tr>
    </c:forEach>
</table>

<c:if test="${empty nhaCungCapList}">
    <p style="text-align:center; color:gray;">Không tìm thấy nhà cung cấp phù hợp.</p>
</c:if>
</body>
</html>
