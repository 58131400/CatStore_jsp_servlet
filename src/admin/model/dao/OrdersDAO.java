/*
 * @author hoangnguyen
 * @date Apr 24, 2020
 * @version 1.0
 */

package admin.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import admin.model.bean.Orders;
import admin.model.bean.OrdersDetail;
import admin.model.bean.Product;
import admin.model.bean.User;
import catStore.util.DBConnectUtil;

public class OrdersDAO {
	

	public ArrayList<Orders> getAllOrders() {
		Connection conn = DBConnectUtil.ConnectDB();

		String sql = "" + "select id, userId, ordersDate, total, status " + "from orders";

		ResultSet rs = null;
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ArrayList<Orders> orders = new ArrayList<>();

		try {
			while (rs.next()) {
				Orders order = new Orders(rs.getString("id"),
						new User(rs.getString("userId"), null, null, null, null, null, null),
						rs.getDate("ordersDate").toLocalDate(), rs.getDouble("total"), rs.getBoolean("status"), null);

				orders.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    if(conn != null)
            {
                try {
                    conn.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
		}

		return orders;
	}

	public Orders getOrdersById(String id) {
	    Connection conn = DBConnectUtil.ConnectDB();

		String sql = "" + "select id, userId, ordersDate, total, status " + "from orders " + "where id = ?";

		ResultSet rs = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (rs.next()) {
				return new Orders(rs.getString("id"),
						new User(rs.getString("userId"), null, null, null, null, null, null),
						rs.getDate("ordersDate").toLocalDate(), rs.getDouble("total"), rs.getBoolean("status"), null);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null)
			{
			    try {
                    conn.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
			}
		}

		return null;
	}

	public boolean deleteOrders(String id) {
	    Connection conn = DBConnectUtil.ConnectDB();

		String sql = "delete from orders where id = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);

			int rowEffect = ps.executeUpdate();

			return rowEffect != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    if(conn != null)
            {
                try {
                    conn.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
		}

		return false;
	}

	public ArrayList<OrdersDetail> getOrdersDetailByOrdersId(String id) {
	    Connection conn = DBConnectUtil.ConnectDB();

		String sql = ""
				+ "select productId, orders_detail.amount as amount,"
				+ "orders_detail.price as price, name "
				+ "from orders_detail left join products "
				+ "on orders_detail.productId = products.id "
				+ "where ordersId = ?";

		ResultSet rs = null;

		PreparedStatement ps;
		ArrayList<OrdersDetail> ordersDetail = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);

			rs = ps.executeQuery();
			while (rs.next()) {
				OrdersDetail item = new OrdersDetail(
					new Product(
						rs.getString("productId"),
						rs.getString("name"), 0, 0, null, null, null, null, null
					),
					rs.getInt("amount"),
					rs.getDouble("price")
				);

				ordersDetail.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ordersDetail;
	}
	
	public boolean updateOrders(Orders orders) {
	    Connection conn = DBConnectUtil.ConnectDB();
		
		String sql = ""
			+ "delete from orders_detail "
			+ "where ordersId = ?;"
			+ "update orders "
			+ "set userId = ?, ordersDate = ?, total = ?, status = ? "
			+ "where id = ?";
		String sql2 = ""
			+ "insert into orders_detail "
			+ "(ordersId, productId, amount, price)"
			+ "values"
			+ "(?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, orders.getId());
			ps.setString(2, orders.getUser().getId());
			ps.setDate(3, Date.valueOf(orders.getOrderDate()));
			ps.setDouble(4, orders.getTotal());
			ps.setBoolean(5, orders.getStatus());
			ps.setString(6, orders.getId());
			
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ArrayList<OrdersDetail> ordersDetail = orders.getOrdersDetail();
			
			for(int i = 0; i < ordersDetail.size(); i++) {
				ps2.setString(1, orders.getId());
				ps2.setString(2, ordersDetail.get(i).getProduct().getId());
				ps2.setInt(3, ordersDetail.get(i).getAmount());
				ps2.setDouble(4, ordersDetail.get(i).getProduct().getPrice());
				ps2.addBatch();
			}
			
			int rowsEffect = ps.executeUpdate();
			int[] rowsEffects = ps2.executeBatch();
			
			for(int i = 0; i < rowsEffects.length; i++) {
				if(rowsEffects[i] == 0) return false;
			}
			
			return rowsEffect != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    if(conn != null)
            {
                try {
                    conn.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
		}
		
		
		return false;
	}
	
	public boolean createOrders(Orders orders) {
	    Connection conn = DBConnectUtil.ConnectDB();
		
		String sql = ""
			+ "insert into orders"
			+ "(id, userId, ordersDate, total, status) "
			+ "values"
			+ "(?, ?, ?, ?, ?)";
		String sql2 = ""
			+ "insert into orders_detail "
			+ "(ordersId, productId, amount, price)"
			+ "values"
			+ "(?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, orders.getId());
			ps.setString(2, orders.getUser().getId());
			ps.setDate(3, Date.valueOf(orders.getOrderDate()));
			ps.setDouble(4, orders.getTotal());
			ps.setBoolean(5, orders.getStatus());
			
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ArrayList<OrdersDetail> ordersDetail = orders.getOrdersDetail();
			
			for(int i = 0; i < ordersDetail.size(); i++) {
				ps2.setString(1, orders.getId());
				ps2.setString(2, ordersDetail.get(i).getProduct().getId());
				ps2.setInt(3, ordersDetail.get(i).getAmount());
				ps2.setDouble(4, ordersDetail.get(i).getProduct().getPrice());
				ps2.addBatch();
			}
			
			int rowsEffect = ps.executeUpdate();
			int[] rowsEffects = ps2.executeBatch();
			
			for(int i = 0; i < rowsEffects.length; i++) {
				if(rowsEffects[i] == 0) return false;
			}
			
			return rowsEffect != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    if(conn != null)
            {
                try {
                    conn.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
		}
		
		
		return false;
	}
}

