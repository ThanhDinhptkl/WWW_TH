package iuh.fit.se.tuan4.servlet;

import iuh.fit.se.tuan4.entity.TINTUC;             // đúng tên class entity của bạn
import iuh.fit.se.tuan4.util.EntityManagerFactoryUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/quanly")
public class QuanLyFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        EntityManager em = null;
        try {
            em = EntityManagerFactoryUtil.getEntityManager(); // đảm bảo method này tồn tại và là static
            TypedQuery<TINTUC> query = em.createQuery("SELECT t FROM TINTUC t", TINTUC.class);
            List<TINTUC> list = query.getResultList();

            req.setAttribute("listTinTuc", list);
            req.setAttribute("contentPage", "QuanLy.jsp");
            req.getRequestDispatcher("layout.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException("Lỗi khi load danh sách tin tức", e);
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
    }
}
