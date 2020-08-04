package admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import catStore.util.Authentication;
import admin.model.bean.Product;
import admin.model.bo.ProductBO;

/**
 * Servlet implementation class Dashboard
 */
public class DashboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DashboardController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(!Authentication.isLogin(request)) {
			response.sendRedirect("/CatStore/signin");
			return;
		}
		
		if(!Authentication.canViewDashboard(request)) {
			response.sendRedirect("/CatStore/no-permission");
			return;
		}
		
		ProductBO productBO = new ProductBO();
		ArrayList<Product> products = productBO.getAllProducts();
		System.out.println(products.size());
		request.setAttribute("products", products);
		request.getRequestDispatcher("/view/admin/views/admin/dashboard.jsp").forward(request, response);
	}
}
