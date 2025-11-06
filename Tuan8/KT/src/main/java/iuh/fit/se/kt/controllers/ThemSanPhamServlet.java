package iuh.fit.se.kt.controllers;

import iuh.fit.se.kt.entities.DienThoai;
import iuh.fit.se.kt.entities.NhaCungCap;
import iuh.fit.se.kt.repositories.DienThoaiDao;
import iuh.fit.se.kt.services.DienThoaiImpl;
import iuh.fit.se.kt.services.NhaCungCapImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet("/ThemSanPhamServlet")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024, // 1MB
        maxFileSize = 5 * 1024 * 1024,   // 5MB
        maxRequestSize = 10 * 1024 * 1024 // 10MB
)
public class ThemSanPhamServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final DienThoaiDao dienThoaiDao = new DienThoaiImpl();
    private final NhaCungCapImpl nhaCungCapService = new NhaCungCapImpl();

    // Hiển thị form thêm sản phẩm + danh sách NCC
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<NhaCungCap> nhaCungCapList = nhaCungCapService.getAllNhaCungCap();
        request.setAttribute("nhaCungCapList", nhaCungCapList);
        request.getRequestDispatcher("/ThemSanPham.jsp").forward(request, response);
    }

    // Xử lý khi người dùng ấn "Thêm sản phẩm"
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        try {
            String tenDT = request.getParameter("tenDT");
            int namSanXuat = Integer.parseInt(request.getParameter("namSanXuat"));
            String cauHinh = request.getParameter("cauHinh");
            int maNCC = Integer.parseInt(request.getParameter("nhaCungCap"));

            // Upload hình ảnh
            Part filePart = request.getPart("hinhAnh");
            String fileName = filePart != null ? filePart.getSubmittedFileName() : "";

            String uploadPath = getServletContext().getRealPath("") + File.separator + "images";
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) uploadDir.mkdirs();

            if (fileName != null && !fileName.isEmpty()) {
                filePart.write(uploadPath + File.separator + fileName);
            }

            // ✅ Lấy NhaCungCap trong cùng EntityManager của DienThoaiImpl
            NhaCungCap ncc = dienThoaiDao.getEntityManager().find(NhaCungCap.class, maNCC);

            // Tạo đối tượng điện thoại
            DienThoai dt = new DienThoai();
            dt.setTenDT(tenDT);
            dt.setNamSanXuat(namSanXuat);
            dt.setCauHinh(cauHinh);
            dt.setNhaCungCap(ncc);
            dt.setHinhAnh(fileName);

            // ✅ Lưu vào DB
            dienThoaiDao.saveDienThoai(dt);

            // Chuyển hướng về danh sách
            response.sendRedirect(request.getContextPath() + "/dien-thoai");

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("❌ Lỗi khi thêm sản phẩm: " + e.getMessage());
        }
    }
}
