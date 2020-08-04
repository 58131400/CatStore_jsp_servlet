package admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import admin.model.bean.Product;
import admin.model.bo.ProductBO;
import catStore.util.Authentication;

/**
 * Servlet implementation class ProductsIndex
 */
public class ProductsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductsController() {
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
		
		if(!Authentication.canViewProductList(request)) {
			response.sendRedirect("/CatStore/no-permission");
			return;
		}
		
		ProductBO productBO = new ProductBO();
		ArrayList<Product> products = productBO.getAllProducts();

		request.setAttribute("products", products);
		request.getRequestDispatcher("/view/admin/views/admin/products/index.jsp").forward(request, response);
	}

}
