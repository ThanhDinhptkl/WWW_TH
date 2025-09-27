package Controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.io.IOException;
import java.util.List;

import DAO.DAODienThoai;
import DAO_IMP.DAOIMPDienThoai;
import Entity.DienThoai;

/**
 * Servlet implementation class DienThoaiServlet
 */
@WebServlet("/dien-thoai")
public class DienThoaiServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    private DAODienThoai daoDienThoai = new DAOIMPDienThoai();
    

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DienThoaiServlet() {
        super();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DienThoai> dienthoaiList = daoDienThoai.getAllDienThoai();
        request.setAttribute("listDienThoai", dienthoaiList);
        request.getRequestDispatcher("views/dien-thoai/list.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tenDT = request.getParameter("tenDT");
        int namSanXuat = Integer.parseInt(request.getParameter("namSanXuat"));
        String cauHinh = request.getParameter("cauHinh");

        DienThoai dienThoai = new DienThoai();
        dienThoai.setTenDT(tenDT);
        dienThoai.setNamSX(namSanXuat);
        dienThoai.setCauHinh(cauHinh);

        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            daoDienThoai.saveDienThoai(dienThoai);
            transaction.commit();
            response.sendRedirect("/dien-thoai");
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            request.setAttribute("error", "An error occurred while saving the phone. Please try again.");
            request.getRequestDispatcher("views/dien-thoai/add.jsp").forward(request, response);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close(); 
            }
        }
    }
}
