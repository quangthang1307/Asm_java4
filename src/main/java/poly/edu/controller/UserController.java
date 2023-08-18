package poly.edu.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import poly.edu.dao.nguoiDungDAO;
import poly.edu.entity.NguoiDung;

import java.io.IOException;

/**
 * Servlet implementation class UserController
 */
@WebServlet(urlPatterns = { "/login", "/logout", "/register" })
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserController() {
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
		HttpSession session = request.getSession();
		String path = request.getServletPath();
		switch (path) {
		case "/login":
			doGetLogin(request, response);
			break;
		case "/register":
			doGetRegister(request, response);
			break;
		case "/logout":
			doGetLogout(request, response);
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = req.getServletPath();
		switch (path) {
		case "/login":
			doPostLogin(req, resp);
			break;
		case "/register":
			doPostRegister(req, resp);
			break;
		}
	}

	protected void doGetLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("views/user/login.jsp").forward(request, response);
	}

	protected void doGetRegister(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("views/user/register.jsp").forward(request, response);
	}
	
	protected void doGetLogout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
        }

        response.sendRedirect(request.getContextPath() + "/login");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPostLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		nguoiDungDAO nguoiDungDAO = new nguoiDungDAO();
		NguoiDung nguoiDung = nguoiDungDAO.findByEmail(email);

		if (nguoiDung != null && nguoiDung.getMatKhau().equals(password)) {
			request.getSession().setAttribute("user", nguoiDung);

			request.setAttribute("message", "Đăng nhập thành công!!!");

			response.sendRedirect(request.getContextPath() + "/index");
		} else {
			request.setAttribute("error", "Email hoặc mật khẩu không đúng");
			request.getRequestDispatcher("/views/user/login.jsp").forward(request, response);
		}
	}

	protected void doPostRegister(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("cfmpassword");

		if (!password.equals(confirmPassword)) {
			request.setAttribute("error", "Mật khẩu và mật khẩu xác nhận không trùng khớp");
			request.getRequestDispatcher("/views/user/register.jsp").forward(request, response);
			return;
		}

		nguoiDungDAO nguoiDungDAO = new nguoiDungDAO();
		NguoiDung existingUser = nguoiDungDAO.findByEmail(email);
		if (existingUser != null) {
			request.setAttribute("error", "Email đã được sử dụng, vui lòng chọn email khác");
			request.getRequestDispatcher("/views/user/register.jsp").forward(request, response);
			return;
		}

		NguoiDung newUser = new NguoiDung();
		newUser.setHoTen(username);
		newUser.setEmail(email);
		newUser.setMatKhau(password);
		newUser.setQuyenHan("USER"); // Đặt quyền hạn mặc định là "USER"

		nguoiDungDAO.insert(newUser);

		// Chuyển hướng người dùng về trang chủ sau khi đăng ký thành công
		response.sendRedirect(request.getContextPath() + "/index");
	}
}
