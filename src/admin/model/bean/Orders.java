/*
 * @author hoangnguyen
 * @date Apr 24, 2020
 * @version 1.0
 */

package admin.model.bean;

import java.time.LocalDate;
import java.util.ArrayList;

public class Orders {
	private String id;
	private User user;
	private LocalDate orderDate;
	private double total;
	private boolean status;
	private ArrayList<OrdersDetail> ordersDetail;

	public Orders(String id, User user, LocalDate orderDate, double total, boolean status,
			ArrayList<OrdersDetail> ordersDetail) {
		super();
		this.setId(id);
		this.setUser(user);
		this.setOrderDate(orderDate);
		this.setTotal(total);
		this.setStatus(status);
		this.setOrdersDetail(ordersDetail);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public ArrayList<OrdersDetail> getOrdersDetail() {
		return ordersDetail;
	}

	public void setOrdersDetail(ArrayList<OrdersDetail> ordersDetail) {
		this.ordersDetail = ordersDetail;
	}
}
