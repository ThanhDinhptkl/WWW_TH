package iuh.fit.se.kt.controllers;

import iuh.fit.se.kt.entities.DienThoai;
import iuh.fit.se.kt.repositories.DienThoaiDao;
import iuh.fit.se.kt.services.DienThoaiImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/dien-thoai")
public class DienThoaiFormServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DienThoaiDao dienThoaiDao = new DienThoaiImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<DienThoai> dienthoaiList = dienThoaiDao.getAllDienThoai();
        request.setAttribute("dienThoaiList", dienthoaiList);
        request.getRequestDispatcher("/DanhSachDienThoai.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String tenDT = request.getParameter("tenDT");
        int namSanXuat = Integer.parseInt(request.getParameter("namSanXuat"));
        String cauHinh = request.getParameter("cauHinh");

        DienThoai dienThoai = new DienThoai();
        dienThoai.setTenDT(tenDT);
        dienThoai.setNamSanXuat(namSanXuat);
        dienThoai.setCauHinh(cauHinh);

        // Gọi DAO để lưu dữ liệu
        dienThoaiDao.saveDienThoai(dienThoai);

        response.sendRedirect(request.getContextPath() + "/dien-thoai");
    }
}
