package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.model.bean.User;
import admin.model.bo.RoleBO;
import admin.model.bo.UserBO;

/**
 * Servlet implementation class Login
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/CatStore/signin");;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		
		UserBO userBO = new UserBO();
		User user = userBO.getUserByUsername(username);
		
		if(user != null && user.getPassword().equals(password)) {
			RoleBO roleBO = new RoleBO();
			user.setRoles(roleBO.getRolesByUserId(user.getId()));
			session.setAttribute("user", user);
			response.sendRedirect("/Admin/admin/dashboard");
		} else {
			session.setAttribute("error", "Username or password was invalid.");
			response.sendRedirect("/Admin/login");
		}
	}

}
