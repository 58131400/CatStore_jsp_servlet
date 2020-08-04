/*
 * @author hoangnguyen
 * @date Apr 24, 2020
 * @version 1.0
 */

package admin.model.bo;

import java.util.ArrayList;

import admin.model.bean.Orders;
import admin.model.bean.OrdersDetail;
import admin.model.dao.OrdersDAO;

public class OrdersBO {
	OrdersDAO ordersDAO = new OrdersDAO();
	
	public ArrayList<Orders> getAllOrders() {
		return ordersDAO.getAllOrders();
	}
	
	public Orders getOrdersById(String id) {
		return ordersDAO.getOrdersById(id);
	}
	
	public ArrayList<OrdersDetail> getOrdersDetailByOrdersId(String id) {
		return ordersDAO.getOrdersDetailByOrdersId(id);
	}
	
	public boolean deleteOrders(String id) {
		return ordersDAO.deleteOrders(id);
	}
	
	public boolean updateOrders(Orders orders) {
		return ordersDAO.updateOrders(orders);
	}
	
	public boolean createOrders(Orders orders) {
		return ordersDAO.createOrders(orders);
	}
}
