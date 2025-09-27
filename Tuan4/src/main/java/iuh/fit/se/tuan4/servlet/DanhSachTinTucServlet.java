package iuh.fit.se.tuan4.servlet;

import iuh.fit.se.tuan4.dao.TinTucDAO;
import iuh.fit.se.tuan4.entity.TINTUC;
import iuh.fit.se.tuan4.util.EntityManagerFactoryUtil;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/danhsach")
public class DanhSachTinTucServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int madm = Integer.parseInt(req.getParameter("madm"));

//        EntityManager em = EntityManagerFactoryUtil.getEntityManager();
        EntityManager em = EntityManagerFactoryUtil.getEntityManager();
        TinTucDAO dao = new TinTucDAO(em);
        List<TINTUC> list = dao.getByDanhMuc(madm);

        req.setAttribute("listTinTuc", list);
        req.getRequestDispatcher("DanhSachTinTuc.jsp").forward(req, resp);
    }
}
