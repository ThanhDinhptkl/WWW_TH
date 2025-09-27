<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ page import="DAO_IMP.DAOIMPDienThoai" %> <%@ page
import="java.util.List" %> <%@ page import="Entity.DienThoai" %> <%@ page
import="DAO.DAODienThoai" %> <% // Tạo đối tượng DAO và lấy danh sách điện thoại
DAODienThoai dienThoaiDAO = new DAOIMPDienThoai(); List<DienThoai>
  dienThoaiList = dienThoaiDAO.getAllDienThoai(); %>

  <!DOCTYPE html>
  <html lang="vi">
    <head>
      <meta charset="UTF-8" />
      <title>Danh sách điện thoại</title>
    </head>
    <body>
      <div class="content">
        <h2>Danh sách sản phẩm điện thoại</h2>

        <table border="1" cellpadding="8" cellspacing="0" width="100%">
          <tr>
            <th>Mã ĐT</th>
            <th>Tên ĐT</th>
            <th>Năm sản xuất</th>
            <th>Cấu hình</th>
            <th>Nhà cung cấp</th>
          </tr>
          <c:forEach var="dt" items="${dienThoaiList}">
            <tr>
              <td>${dt.maDT}</td>
              <td>${dt.tenDT}</td>
              <td>${dt.namSanXuat}</td>
              <td>${dt.cauHinh}</td>
              <td>${dt.nhaCungCap.tenNCC}</td>
            </tr>
          </c:forEach>
        </table>
      </div>
    </body>
  </html>
</DienThoai>
