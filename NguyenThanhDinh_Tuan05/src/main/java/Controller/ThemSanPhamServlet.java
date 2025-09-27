package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;

import DAO.DAODienThoai;
import DAO_IMP.DAOIMPDienThoai;
import Entity.DienThoai;

/**
 * Servlet implementation class ThemSanPhamServlet
 */
public class ThemSanPhamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemSanPhamServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tenDT = request.getParameter("tenDT");
	    String namSanXuatStr = request.getParameter("namSanXuat");
	    String cauHinh = request.getParameter("cauHinh");
	    String nhaCungCapIdStr = request.getParameter("nhaCungCap");
	    Part filePart = request.getPart("hinhAnh");
	    String MaDTStr = request.getParameter("MaDT");

	    int namSanXuat = namSanXuatStr != null ? Integer.parseInt(namSanXuatStr) : 0;
	    int nhaCungCapId = nhaCungCapIdStr != null ? Integer.parseInt(nhaCungCapIdStr) : 0;
	    int MaDT = MaDTStr != null ? Integer.parseInt(MaDTStr) : 0;

	    String fileName = filePart != null ? filePart.getSubmittedFileName() : null;

	    DAODienThoai dienThoaiDAO = new DAOIMPDienThoai();
	    DienThoai dienThoai = new DienThoai(MaDT, tenDT, nhaCungCapId, namSanXuat, cauHinh, fileName);
	    dienThoaiDAO.saveDienThoai(dienThoai);

	    response.sendRedirect("DanhSachDienThoai.jsp");
	}

}
