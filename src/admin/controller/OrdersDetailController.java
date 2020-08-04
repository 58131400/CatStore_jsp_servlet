package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.bean.Orders;
import admin.model.bo.OrdersBO;
import catStore.util.Authentication;



/**
 * Servlet implementation class OrdersDetail
 */
public class OrdersDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdersDetailController() {
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
		
		if(!Authentication.canViewOrderDetails(request)) {
			response.sendRedirect("/CatStore/no-permission");
			return;
		}
		
		String id = request.getParameter("id");
		
		OrdersBO ordersBO = new OrdersBO();
		Orders orders = ordersBO.getOrdersById(id);
		orders.setOrdersDetail(ordersBO.getOrdersDetailByOrdersId(id));
		
		request.setAttribute("orders", orders);
		request.getRequestDispatcher("/view/admin/views/admin/orders/detail.jsp").forward(request, response);
	}
}
