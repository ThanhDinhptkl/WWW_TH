<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8" />
    <title>Quản lý điện thoại</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 30px; }
        h2 { text-align: center; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { border: 1px solid #ccc; padding: 8px; text-align: center; }
        th { background-color: #f2f2f2; }
        a.delete-btn {
            background-color: #e74c3c;
            color: white;
            padding: 6px 10px;
            border-radius: 4px;
            text-decoration: none;
        }
        a.delete-btn:hover {
            background-color: #c0392b;
        }
        .message {
            text-align: center;
            color: green;
            font-weight: bold;
        }
    </style>
</head>
<body>
<h2>Quản lý danh sách điện thoại</h2>

<c:if test="${not empty message}">
    <div class="message">${message}</div>
</c:if>

<table>
    <tr>
        <th>Mã ĐT</th>
        <th>Tên ĐT</th>
        <th>Năm SX</th>
        <th>Cấu hình</th>
        <th>Nhà cung cấp</th>
        <th>Hình ảnh</th>
        <th>Thao tác</th>
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
                    <img src="${pageContext.request.contextPath}/images/${dt.hinhAnh}" width="100" />
                </c:if>
            </td>
            <td>
                <a class="delete-btn"
                   href="${pageContext.request.contextPath}/quan-ly-dien-thoai?delete=${dt.maDT}"
                   onclick="return confirm('Bạn có chắc muốn xóa sản phẩm này không?')">
                    Xóa
                </a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
