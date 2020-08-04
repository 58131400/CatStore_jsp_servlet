package admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import admin.model.bo.ProductBO;
import catStore.util.Authentication;

/**
 * Servlet implementation class ProductDelete
 */
public class ProductDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductDeleteController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		
		if (!Authentication.isLogin(request)) {
			writer.print("Failed");
			return;
		}

		if (!Authentication.canDeleteProduct(request)) {
			writer.print("Failed");
			return;
		}

		String id = request.getParameter("id");

		ProductBO productBO = new ProductBO();
		boolean result = productBO.deleteProduct(id);

		if (result) {
			writer.print("OK");
		} else {
			writer.print("Failed");
		}
	}

}
