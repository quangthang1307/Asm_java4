package poly.edu.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Base64;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import javassist.bytecode.ByteArray;
import poly.edu.dao.sanPhamDAO;
import poly.edu.entity.SanPham;

import java.io.File;

/**
 * Servlet implementation class SanPhamController
 */
@WebServlet(urlPatterns = { "/sanpham", "/getImage", "/themsanpham", "/thongtinsp", "/xoaSanPham", "/chinhsuaSanPham",
		"/capnhatSanPham" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)
public class SanPhamController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private sanPhamDAO sanPhamDAO = new sanPhamDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SanPhamController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		switch (path) {
		case "/sanpham":
			doGetSanpham(request, response);
			break;
		case "/getImage":
			doGetAnhSanpham(request, response);
			break;
		case "/themsanpham":
			doGetThemSanpham(request, response);
			break;
		case "/thongtinsp":
			doGetThongTinSanpham(request, response);
			break;
		case "/xoaSanPham":
			doGetXoaSanPham(request, response);
			break;
		case "/chinhsuaSanPham":
			doChinhSuaSanPham(request, response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		switch (path) {
		case "/themsanpham":
			doPostThemSanpham(request, response);
			break;
		case "/capnhatSanPham":
			doCapNhatSanPham(request, response);
			break;
		}
	}

	protected void doGetThemSanpham(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("views/user/themsanpham.jsp").forward(request, response);
	}

	protected void doChinhSuaSanPham(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idStr = request.getParameter("id");
		if (idStr != null && !idStr.isEmpty()) {
			try {
				int id = Integer.parseInt(idStr);
				SanPham sp = sanPhamDAO.findbyID(id);
				if (sp != null) {
					// Truyền thông tin sản phẩm cần chỉnh sửa qua request attribute
					request.setAttribute("sanPham", sp);
					request.getRequestDispatcher("views/user/edit.jsp").forward(request, response);
				} else {
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
		}
	}

	protected void doGetThongTinSanpham(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String maSanPhamStr = request.getParameter("id");
		int maSanPham = 0;

		if (maSanPhamStr != null && !maSanPhamStr.isEmpty()) {
			try {
				maSanPham = Integer.parseInt(maSanPhamStr);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		} else {
		}

		try {
			SanPham sanPham = sanPhamDAO.findbyID(maSanPham);
			if (sanPham != null) {
				request.setAttribute("sanPham", sanPham);
			} else {
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("views/user/thongtinsp.jsp").forward(request, response);
	}

	protected void doGetSanpham(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			sanPhamDAO dao = new sanPhamDAO();
			List<SanPham> sp = dao.findAll();
			request.setAttribute("listSanPham", sp);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		request.getRequestDispatcher("views/user/sanpham.jsp").forward(request, response);
	}

	protected void doGetAnhSanpham(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idStr = request.getParameter("id");
		if (idStr != null && !idStr.isEmpty()) {
			try {
				int id = Integer.parseInt(idStr);
				SanPham sp = sanPhamDAO.findbyID(id);
				if (sp != null && sp.getDuongDanHinhAnh() != null) {
					byte[] imageData = sp.getDuongDanHinhAnh();

					response.setContentType("image/jpeg");
					response.setContentLength(imageData.length);
					response.getOutputStream().write(imageData);
				} else {
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
				// Xử lý lỗi nếu id không hợp lệ
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
		}
	}

	protected void doGetXoaSanPham(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idStr = request.getParameter("id");
		if (idStr != null && !idStr.isEmpty()) {
			try {
				int id = Integer.parseInt(idStr);
				sanPhamDAO.delete(id);
				// Điều hướng người dùng trở lại trang hiển thị sản phẩm sau khi xóa thành công
				response.sendRedirect(request.getContextPath() + "/sanpham");
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
		}
	}

	protected void doPostThemSanpham(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// Lấy dữ liệu từ form
		int masanpham = Integer.parseInt(request.getParameter("maSanPham"));
		String tenSanPham = request.getParameter("tenSanPham");
		BigDecimal gia = new BigDecimal(request.getParameter("gia"));
		String moTa = request.getParameter("moTa");
		Part filePart = request.getPart("file");

		// Đọc dữ liệu từ InputStream và chuyển thành mảng bytes
		byte[] imageData = filePart.getInputStream().readAllBytes();

		// Tạo đối tượng SanPham với dữ liệu nhận được
		SanPham sanPham = new SanPham();
		sanPham.setMaSanPham(masanpham);
		sanPham.setTenSanPham(tenSanPham);
		sanPham.setGia(gia);
		sanPham.setMoTa(moTa);
		sanPham.setDuongDanHinhAnh(imageData);

		// Lưu đối tượng SanPham vào cơ sở dữ liệu
		sanPhamDAO sanPhamDAO = new sanPhamDAO();
		sanPhamDAO.insert(sanPham);
		response.sendRedirect(request.getContextPath() + "/sanpham");
	}

	protected void doCapNhatSanPham(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String maSanPhamStr = request.getParameter("maSanPham");
		String tenSanPham = request.getParameter("tenSanPham");
		String giaStr = request.getParameter("gia");
		String moTa = request.getParameter("moTa");

		int maSanPham = -1;
		BigDecimal gia = null;

		if (maSanPhamStr != null && !maSanPhamStr.isEmpty()) {
			maSanPham = Integer.parseInt(maSanPhamStr);
		}
		if (giaStr != null && !giaStr.isEmpty()) {
			gia = new BigDecimal(giaStr);
		}

		SanPham sanPham = new SanPham();
		sanPham.setMaSanPham(maSanPham);
		sanPham.setTenSanPham(tenSanPham);
		sanPham.setGia(gia);
		sanPham.setMoTa(moTa);

		sanPhamDAO.update(sanPham);

		response.sendRedirect(request.getContextPath() + "/sanpham");
	}

}
