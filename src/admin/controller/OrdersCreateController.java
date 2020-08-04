package admin.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import catStore.util.Authentication;
import catStore.util.Utils;
import admin.model.bean.Orders;
import admin.model.bean.OrdersDetail;
import admin.model.bean.Product;
import admin.model.bean.User;
import admin.model.bo.OrdersBO;
import admin.model.bo.ProductBO;
import admin.model.bo.UserBO;

/**
 * Servlet implementation class OrdersCreateController
 */
public class OrdersCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdersCreateController() {
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
		
		if(!Authentication.canCreateNewOrder(request)) {
			response.sendRedirect("/CatStore/no-permission");
			return;
		}
		
		UserBO userBO = new UserBO();
		
		ArrayList<User> users = userBO.getAllUsers();
		
		request.setAttribute("users", users);
		request.getRequestDispatcher("/view/admin/views/admin/orders/create.jsp").forward(request, response);
		request.getSession().removeAttribute("message");
		request.getSession().removeAttribute("error");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBO userBO = new UserBO();
		ProductBO productBO = new ProductBO();
		OrdersBO ordersBO = new OrdersBO();
		boolean result = false;
		
		String userId = request.getParameter("userId");
		String orderDateString = request.getParameter("orderDate");
		
		try {
			ArrayList<Orders> ordersList = ordersBO.getAllOrders();
			String ordersId = Utils.ordersId(ordersList);
			
			boolean status = Boolean.valueOf(request.getParameter("status"));
			String[] products = request.getParameterValues("productId");
			String[] amounts = request.getParameterValues("amount");
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate orderDate = LocalDate.parse(orderDateString, dtf);
			
			User user = userBO.getUserById(userId);
			ArrayList<OrdersDetail> ordersdetailList = new ArrayList<>();
			double total =0;
			for(int i = 0; products!= null && i < products.length; i++) {
				Product product = productBO.getProductById(products[i]);
				ordersdetailList.add(new OrdersDetail(product, Integer.valueOf(amounts[i]), product.getPrice()));
				total += Integer.valueOf(amounts[i])*product.getPrice();
			}
			
			Orders orders = new Orders(
				ordersId,
				user,
				orderDate,
				total,
				status,
				ordersdetailList
			);
			
			result = ordersBO.createOrders(orders);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		if(result == true) {
			request.getSession().setAttribute("message", "Create successful");
		} else {
			request.getSession().setAttribute("error", "Create failed");
		}
		response.sendRedirect("/CatStore/admin/orders/create");
	}

}
