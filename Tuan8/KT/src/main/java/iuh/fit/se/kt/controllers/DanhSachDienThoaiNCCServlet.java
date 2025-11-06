package iuh.fit.se.kt.controllers;

import iuh.fit.se.kt.entities.NhaCungCap;
import iuh.fit.se.kt.services.NhaCungCapImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/nha-cung-cap")
public class DanhSachDienThoaiNCCServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NhaCungCapImpl nhaCungCapService;

    @Override
    public void init() throws ServletException {
        super.init();
        nhaCungCapService = new NhaCungCapImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        // ✅ Nhận tham số tìm kiếm (nếu có)
        String keyword = request.getParameter("keyword");

        List<NhaCungCap> nhaCungCapList;
        if (keyword != null && !keyword.trim().isEmpty()) {
            nhaCungCapList = nhaCungCapService.searchNhaCungCap(keyword);
            request.setAttribute("keyword", keyword);
        } else {
            nhaCungCapList = nhaCungCapService.getAllNhaCungCap();
        }

        request.setAttribute("nhaCungCapList", nhaCungCapList);
        request.getRequestDispatcher("/DanhSachNhaCungCap.jsp").forward(request, response);
    }
}
