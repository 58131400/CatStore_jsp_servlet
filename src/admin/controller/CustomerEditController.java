package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.bean.User;
import admin.model.bo.UserBO;

/**
 * Servlet implementation class CustomerEditController
 */
public class CustomerEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerEditController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String userId = request.getParameter("id");
			UserBO userBO = new UserBO();
			
			User user = userBO.getUserById(userId);
			
			request.setAttribute("user", user);
			request.getRequestDispatcher("/view/admin/views/admin/customers/edit.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			String fullname = request.getParameter("fullnane");
			String address = request.getParameter("address");
			String phone = request.getParameter("phone");
			
			UserBO userBO = new UserBO();
			User user = new User(id, null, null, fullname, address, phone, null);
			
			boolean result = userBO.updateUser(user);
			if(result == true) {
				request.getSession().setAttribute("message", "Update successful");
			} else {
				request.getSession().setAttribute("error", "Update failed");
			}
			response.sendRedirect("/CatStore/admin/customers/edit?id=" + id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
