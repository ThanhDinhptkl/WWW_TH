<%--
  Created by IntelliJ IDEA.
  User: ThanhDinh
  Date: 9/28/2025
  Time: 2:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h2>Quản lý tin tức</h2>

<table border="1" width="100%" cellpadding="5" cellspacing="0">
  <tr>
    <th>ID</th>
    <th>Tiêu đề</th>
    <th>Nội dung</th>
    <th>Ngày đăng</th>
    <th>Thao tác</th>
  </tr>
  <c:forEach var="t" items="${listTinTuc}">
    <tr>
      <td>${t.id}</td>
      <td>${t.tieuDe}</td>
      <td>${t.noiDung}</td>
      <td>${t.ngayDang}</td>
      <td>
        <a href="xoa?id=${t.id}">Xóa</a>
      </td>
    </tr>
  </c:forEach>
</table>

