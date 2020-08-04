package admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.bean.User;
import admin.model.bo.UserBO;

/**
 * Servlet implementation class CustomersController
 */
public class CustomersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomersController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBO userBO = new UserBO();
		ArrayList<User> users = userBO.getAllUsers();
		
		request.setAttribute("users", users);
		request.getRequestDispatcher("/view/admin/views/admin/customers/index.jsp").forward(request, response);
	}

}
