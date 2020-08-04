package khachhang.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import catStore.util.DBConnectUtil;
import catStore.util.LogFactory;
import khachhang.model.bean.Order;

public class OrderDAO {

    public String getIdOrderAuto() {
        Connection connection = DBConnectUtil.ConnectDB();
        String sql = "select id from orders";
        int mamax = 0;
        String id = null;
        try {
            PreparedStatement pStatement = connection.prepareStatement(sql);
            ResultSet rs = pStatement.executeQuery();
            while (rs.next()) {
                int ma = Integer.parseInt(rs.getString("id").substring(2));
                if (mamax < ma) {
                    mamax = ma;
                }
            }
            mamax++;
            String maNumber = "00" + mamax;
            id = "OD" + maNumber.substring(String.valueOf(mamax).length() - 1);
            LogFactory.getLogger().info(id);
        } catch (SQLException e) {
            // TODO Auto-generated catch blocks
            e.printStackTrace();
        }finally {
            
                try {
                    connection.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
        return id;
    }

    public void insertOrder(Order o) {
        // TODO Auto-generated method stub
        Connection connection = DBConnectUtil.ConnectDB();
        String sql = "insert into Orders(id,userId,ordersDate,total,status) values(?,?,?,?,?)";
       
        try {
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, o.getId());
            pStatement.setString(2, o.getUserId());
            pStatement.setDate(3, Date.valueOf(o.getOrdersDate()));
            pStatement.setDouble(4, o.getTotal());
            pStatement.setBoolean(5, o.isStatus());
            int row = pStatement.executeUpdate();
            LogFactory.getLogger().info(String.valueOf(row));
        } catch (SQLException e) {
            // TODO Auto-generated catch blocks
            e.printStackTrace();
        }finally {
            
                try {
                    connection.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
        
    }

}
