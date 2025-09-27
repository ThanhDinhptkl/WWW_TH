<%--
  Created by IntelliJ IDEA.
  User: ThanhDinh
  Date: 9/28/2025
  Time: 1:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<h2>Danh sách tin tức</h2>
<table border="1" width="100%">
    <tr>
        <th>Mã</th><th>Tiêu đề</th><th>Nội dung</th><th>Liên kết</th><th>Thao tác</th>
    </tr>
    <c:forEach var="tt" items="${listTinTuc}">
        <tr>
            <td>${tt.matt}</td>
            <td>${tt.tieude}</td>
            <td>${tt.noidungtt}</td>
            <td><a href="${tt.lienket}" target="_blank">Xem</a></td>
            <td><a href="xoatintuc?matt=${tt.matt}&madm=${tt.danhMuc.madm}">Xóa</a></td>
        </tr>
    </c:forEach>
</table>
