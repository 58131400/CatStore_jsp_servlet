package admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.bean.Role;
import admin.model.bean.User;
import admin.model.bo.RoleBO;
import admin.model.bo.UserBO;

/**
 * Servlet implementation class UserAuthorizationController
 */
public class UserAuthorizationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAuthorizationController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		if(id == null) {
			response.getWriter().print("Khong co user id");
			return;
		}
		
		UserBO userBO = new UserBO();
		User user = userBO.getUserById(id);
		
		if(user == null) {
			response.getWriter().print("Khong tim thay user");
			return;
		}
		
		RoleBO roleBO = new RoleBO();
		user.setRoles(roleBO.getRolesByUserId(user.getId()));
		ArrayList<Role> roles = roleBO.getAllRoles();
		
		request.setAttribute("userInfo", user);
		request.setAttribute("roles", roles);
		request.getRequestDispatcher("/view/admin/views/admin/users/authorization.jsp").forward(request, response);
		request.getSession().removeAttribute("message");
		request.getSession().removeAttribute("error");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		if(id == null) {
			response.getWriter().print("Khong co user id");
			return;
		}
		
		String[] roles = request.getParameterValues("role");
		ArrayList<Role> roleList = new ArrayList<>();
		for(String i : roles) {
			roleList.add(new Role(i, null, null));
		}
		
		User user = new User(id, null, null, null, null, null, roleList);
		UserBO userBO = new UserBO();
		boolean result = userBO.updateUserRoles(user);
		
		if(result == true) {
			request.getSession().setAttribute("message", "Update successful");
		} else {
			request.getSession().setAttribute("error", "Update failed");
		}
		
		response.sendRedirect("/CatStore/admin/users/authorization?id=" + id);
	}

}
