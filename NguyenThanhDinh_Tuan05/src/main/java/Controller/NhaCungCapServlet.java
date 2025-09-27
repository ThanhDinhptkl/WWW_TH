package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.io.IOException;
import java.util.List;

import DAO.DAONhaCungCap;
import DAO_IMP.DAOIMPNhaCungCap;
import Entity.NhaCungCap;

/**
 * Servlet implementation class NhaCungCapServlet
 */
@WebServlet("/nha-cung-cap")
public class NhaCungCapServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DAONhaCungCap daoNhaCungCap;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NhaCungCapServlet() {
        super();
    }

    @Override
    public void init() throws ServletException {
        super.init();
        daoNhaCungCap = new DAOIMPNhaCungCap();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<NhaCungCap> nhaCungCapList = daoNhaCungCap.getAllNhaCungCap();
        request.setAttribute("nhaCungCapList", nhaCungCapList);
        request.getRequestDispatcher("/DanhSachNhaCungCap.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tenNCC = request.getParameter("tenNCC");
        String diaChi = request.getParameter("diaChi");
        String soDienThoai = request.getParameter("soDienThoai");

        NhaCungCap nhaCungCap = new NhaCungCap();
        nhaCungCap.setTenNCC(tenNCC);
        nhaCungCap.setDiaChi(diaChi);
        nhaCungCap.setSoDienThoai(soDienThoai);

        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            daoNhaCungCap.saveNhaCungCap(nhaCungCap);
            transaction.commit();
            response.sendRedirect("/nha-cung-cap");
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            request.setAttribute("error", "An error occurred while saving the supplier. Please try again.");
            request.getRequestDispatcher("/DanhSachNhaCungCap.jsp").forward(request, response);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
}
