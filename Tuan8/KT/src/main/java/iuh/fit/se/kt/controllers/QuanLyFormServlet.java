package iuh.fit.se.kt.controllers;

import iuh.fit.se.kt.entities.DienThoai;
import iuh.fit.se.kt.services.DienThoaiImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/quan-ly-dien-thoai")
public class QuanLyFormServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final DienThoaiImpl dienThoaiService = new DienThoaiImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // ✅ Nếu có tham số "delete", thực hiện xóa trước
        String deleteId = request.getParameter("delete");
        if (deleteId != null) {
            try {
                int maDT = Integer.parseInt(deleteId);
                dienThoaiService.deleteDienThoai(maDT);
                request.setAttribute("message", "✅ Đã xóa sản phẩm có mã: " + maDT);
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("message", "❌ Lỗi khi xóa sản phẩm: " + e.getMessage());
            }
        }

        // ✅ Lấy danh sách điện thoại
        List<DienThoai> dienThoaiList = dienThoaiService.getAllDienThoai();
        request.setAttribute("dienThoaiList", dienThoaiList);

        // ✅ Chuyển sang trang JSP
        request.getRequestDispatcher("/QuanLyForm.jsp").forward(request, response);
    }
}
