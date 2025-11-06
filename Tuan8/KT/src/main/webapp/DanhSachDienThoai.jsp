<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8" />
    <title>Danh sách điện thoại</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 30px;
        }
        h2 {
            text-align: center;
        }
        form {
            text-align: center;
            margin-bottom: 20px;
        }
        input[type="text"] {
            width: 300px;
            padding: 6px;
        }
        input[type="submit"] {
            padding: 6px 12px;
            background-color: #007bff;
            color: white;
            border: none;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        table {
            border-collapse: collapse;
            width: 100%;
            text-align: center;
        }
        th, td {
            padding: 8px;
            border: 1px solid #ccc;
        }
        img {
            max-width: 100px;
            max-height: 100px;
            border-radius: 6px;
        }
    </style>
</head>
<body>
<div class="content">
    <h2>Danh sách sản phẩm điện thoại</h2>

    <!-- 🧾 Bảng danh sách -->
    <table>
        <tr>
            <th>Mã ĐT</th>
            <th>Tên ĐT</th>
            <th>Năm sản xuất</th>
            <th>Cấu hình</th>
            <th>Nhà cung cấp</th>
            <th>Hình ảnh</th>
        </tr>

        <c:forEach var="dt" items="${dienThoaiList}">
            <tr>
                <td>${dt.maDT}</td>
                <td>${dt.tenDT}</td>
                <td>${dt.namSanXuat}</td>
                <td>${dt.cauHinh}</td>
                <td>${dt.nhaCungCap.tenNCC}</td>
                <td>
                    <c:if test="${not empty dt.hinhAnh}">
                        <img src="${pageContext.request.contextPath}/images/${dt.hinhAnh}" alt="${dt.tenDT}" />
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>

    <c:if test="${empty dienThoaiList}">
        <p style="text-align:center; color:gray;">Không tìm thấy sản phẩm nào phù hợp.</p>
    </c:if>
</div>
</body>
</html>
