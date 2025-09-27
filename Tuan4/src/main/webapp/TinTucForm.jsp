<%--
  Created by IntelliJ IDEA.
  User: ThanhDinh
  Date: 9/28/2025
  Time: 1:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<h2>Thêm tin tức mới</h2>

<form action="themtintuc" method="post">
    <table>
        <tr>
            <td>Tiêu đề:</td>
            <td><input type="text" name="tieude" required></td>
        </tr>
        <tr>
            <td>Nội dung:</td>
            <td><textarea name="noidung" maxlength="255" required></textarea></td>
        </tr>
        <tr>
            <td>Liên kết:</td>
            <td><input type="url" name="lienket" placeholder="http://..." required></td>
        </tr>
        <tr>
            <td>Mã danh mục:</td>
            <td><input type="number" name="madm" required></td>
        </tr>
        <tr>
            <td colspan="2" style="text-align:center">
                <button type="submit">Thêm tin tức</button>
            </td>
        </tr>
    </table>
</form>

<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>
