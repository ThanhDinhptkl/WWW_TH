package iuh.fit.se.tuan4.servlet;

import iuh.fit.se.tuan4.dao.TinTucDAO;
import iuh.fit.se.tuan4.entity.DANHMUC;
import iuh.fit.se.tuan4.entity.TINTUC;
import iuh.fit.se.tuan4.util.EntityManagerFactoryUtil;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/themtintuc")
public class TinTucFormServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String tieude = req.getParameter("tieude");
        String noidung = req.getParameter("noidung");
        String lienket = req.getParameter("lienket");
        int madm = Integer.parseInt(req.getParameter("madm"));

        if (!lienket.startsWith("http://") || noidung.length() > 255) {
            req.setAttribute("error", "Dữ liệu nhập không hợp lệ!");
            req.getRequestDispatcher("TinTucForm.jsp").forward(req, resp);
            return;
        }

        EntityManager em = EntityManagerFactoryUtil.getEntityManager();
        DANHMUC dm = em.find(DANHMUC.class, madm);

        TINTUC tinTuc = new TINTUC();
        tinTuc.setTieude(tieude);
        tinTuc.setNoidungtt(noidung);
        tinTuc.setLienket(lienket);
        tinTuc.setDanhmuc(dm);

        TinTucDAO dao = new TinTucDAO(em);
        dao.addTinTuc(tinTuc);

        resp.sendRedirect("danhsach?madm=" + madm);
    }
}
