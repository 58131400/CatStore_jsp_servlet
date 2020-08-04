package khachhang.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import catStore.util.DBConnectUtil;
import catStore.util.LogFactory;
import khachhang.model.bean.Order;
import khachhang.model.bean.Orders_Detail;

public class OrderDetailDAO {

    public void insertOrderDetail(List<Orders_Detail> listChiTiet, Order o) {
       Connection connection= DBConnectUtil.ConnectDB();
       String sql = "insert into Orders_detail(ordersId,productId,amount,price) values(?,?,?,?)";
       try {
        PreparedStatement ps = connection.prepareStatement(sql);
        for (Orders_Detail od : listChiTiet) {
            ps.setString(1, o.getId());
            ps.setString(2, od.getProduct().getId());
            ps.setInt(3, od.getAmount());
            ps.setDouble(4, od.getPrice());
            int row = ps.executeUpdate();
            LogFactory.getLogger().info(String.valueOf(row));
        }
    } catch (Exception e) {
        // TODO: handle exception
    } finally {
        if (connection != null)
            try {
                connection.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
    }
        
    }

}
