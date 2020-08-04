package khachhang.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import catStore.util.CatStoreException;
import catStore.util.DBConnectUtil;
import catStore.util.LogFactory;
import khachhang.model.bean.User;

public class UserDAO {

    public User findUserByUserName(String userName) {
        Connection connection = DBConnectUtil.ConnectDB();
        System.out.println("===================username: " + userName);
        String sql = "Select * from Users where username = ?";
        User user = null;
        try {
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setNString(1, userName);
            ResultSet rs = pStatement.executeQuery();
            while (rs.next()) {
                user = new User(rs.getString("id"), rs.getNString("username"), rs.getString("password"),
                        rs.getNString("fullname"), rs.getNString("address"), rs.getString("phonenumber"),
                        rs.getNString("avatar"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch blocks
            e.printStackTrace();
        } catch (CatStoreException e) {
            // TODO Auto-generated catch block
            e.getMessage();
        } finally {
            if (connection != null)
                try {
                    connection.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
        }

        return user;
    }

    public User isValidUser(String username, String password) {
        // TODO Auto-generated method stub
        Connection connection = DBConnectUtil.ConnectDB();
        LogFactory.getLogger().info(username+ " "+ password);
        String sql = "Select * from Users where username = ? and password = ?";
        User user = null;
        try {
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setNString(1, username);
            pStatement.setNString(2, password);
            ResultSet rs = pStatement.executeQuery();
            while (rs.next()) {
                user = new User(rs.getString("id"), 
                        rs.getNString("username"), 
                        rs.getString("password"),
                        rs.getNString("fullname"), 
                        rs.getNString("address"), 
                        rs.getString("phonenumber"),
                        rs.getNString("avatar"));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch blocks
            e.printStackTrace();
        } catch (CatStoreException e) {
            // TODO Auto-generated catch block
            e.getMessage();
        } finally {
            if (connection != null)
                try {
                    connection.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
        }

        return user;
    }

    public void updateUser(User user) {
        Connection connection = DBConnectUtil.ConnectDB();

        String sql = "update Users set username = ? , password = ? , fullname = ? , address = ? , phonenumber = ? , avatar = ? where id = ?";
        try {
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setNString(1, user.getUsername());
            pStatement.setString(2, user.getPassword());
            pStatement.setNString(3, user.getFullname());
            pStatement.setNString(4, user.getAddress());
            pStatement.setString(5, user.getPhone());
            pStatement.setNString(6, user.getAvatar());
            pStatement.setString(7, user.getId());
            pStatement.executeUpdate();

        } catch (Exception e) {
            // TODO Auto-generated catch blocks
            e.printStackTrace();
        } finally {
            if (connection != null)
                try {
                    connection.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
        }

    }

    public String getIdUserAuto() {
        // TODO Auto-generated method stub
        Connection connection = DBConnectUtil.ConnectDB();
        String sql = "select id from users";
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
            String maNumber = "000" + mamax;
            id = "U" + maNumber.substring(String.valueOf(mamax).length() - 1);
            LogFactory.getLogger().info(id);
        } catch (SQLException e) {
            // TODO Auto-generated catch blocks
            e.printStackTrace();
        } finally {

            try {
                connection.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return id;
    }

    public void createUser(User user) {
        Connection connection = DBConnectUtil.ConnectDB();
        String sql = "insert into users(id,username,password,fullname,address,phonenumber,avatar) values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getId());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.setNString(4, user.getFullname());
            ps.setNString(5, user.getAddress());
            ps.setString(6, user.getPhone());
            ps.setNString(7, user.getAvatar());
            int row = ps.executeUpdate();
            LogFactory.getLogger().info(String.valueOf(row));
        } catch (Exception e) {
            // TODO: handle exception
        } finally {

            try {
                connection.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public Boolean isValidUserName(String username) {
        Connection connection = DBConnectUtil.ConnectDB();
        String sql = "select username from users where username = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();
            if (rs.next() == true)
                return false;

            LogFactory.getLogger().info(String.valueOf(rs.first()));
        } catch (Exception e) {
            // TODO: handle exception
        } finally {

            try {
                connection.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return true;

    }

}
