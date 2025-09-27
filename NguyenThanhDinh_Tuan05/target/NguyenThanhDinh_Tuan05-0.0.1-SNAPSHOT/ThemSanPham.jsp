<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Thêm sản phẩm mới</title>
  </head>
  <body>
    <div class="content">
      <h2>Thêm sản phẩm điện thoại mới</h2>
      <form
        action="ThemSanPhamServlet"
        method="POST"
        enctype="multipart/form-data"
      >
        <label for="tenDT">Tên điện thoại:</label>
        <input type="text" id="tenDT" name="tenDT" required /><br /><br />

        <label for="namSanXuat">Năm sản xuất:</label>
        <input
          type="text"
          id="namSanXuat"
          name="namSanXuat"
          required
        /><br /><br />

        <label for="cauHinh">Cấu hình:</label>
        <input
          type="text"
          id="cauHinh"
          name="cauHinh"
          maxlength="255"
          required
        /><br /><br />

        <label for="nhaCungCap">Nhà cung cấp:</label>
        <select id="nhaCungCap" name="nhaCungCap"></select
        ><br /><br />

        <label for="hinhAnh">Hình ảnh (png, jpg, jpeg):</label>
        <input
          type="file"
          id="hinhAnh"
          name="hinhAnh"
          accept=".png,.jpg,.jpeg"
          required
        /><br /><br />

        <input type="submit" value="Thêm sản phẩm" />
      </form>
    </div>
  </body>
</html>
