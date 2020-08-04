package admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import catStore.util.Authentication;
import admin.model.bean.Orders;
import admin.model.bo.OrdersBO;

/**
 * Servlet implementation class Orders
 */
public class OrdersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdersController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!Authentication.isLogin(request)) {
			response.sendRedirect("/CatStore/signin");
			return;
		}
		
		if(!Authentication.canViewOrderList(request)) {
			response.sendRedirect("/CatStore/no-permission");
			return;
		}
		
		OrdersBO ordersBO = new OrdersBO();
		
		ArrayList<Orders> orders = ordersBO.getAllOrders();
		request.setAttribute("orders", orders);
		request.getRequestDispatcher("/view/admin/views/admin/orders/index.jsp").forward(request, response);
	}

}
