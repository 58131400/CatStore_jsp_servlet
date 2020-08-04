/*
 * @author hoangnguyen
 * @date Apr 23, 2020
 * @version 1.0
 */

package admin.model.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import admin.model.bean.User;
import catStore.util.DBConnectUtil;
import catStore.util.LogFactory;

public class UserDAO {
	
	
	public ArrayList<User> getAllUsers() {
		Connection conn = DBConnectUtil.ConnectDB();
		
		String sql = ""
			+ "select id, username, password, fullname, address, phonenumber "
			+ "from users";
		
		ResultSet rs = null;
		ArrayList<User> users = new ArrayList<>();
		try {
			Statement stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				User user = new User(
					rs.getString("id"),
					rs.getString("username"),
					rs.getString("password"),
					rs.getString("fullname"),
					rs.getString("address"),
					rs.getString("phonenumber"),
					null
				);
				
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
	        if (conn != null)
	            try {
	                conn.close();
	            } catch (Exception e2) {
	                e2.printStackTrace();
	            }
	    }
		
		return users;
	}
	
	public User getUserByUsername(String username) {
	    Connection conn = DBConnectUtil.ConnectDB();
		
		String sql = ""
			+ "select id, username, password, fullname, address, phonenumber "
			+ "from users where username = ?";
		
		ResultSet rs = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				return new User(
					rs.getString("id"),
					rs.getString("username"),
					rs.getString("password"),
					rs.getString("fullname"),
					rs.getString("address"),
					rs.getString("phonenumber"),
					null
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
	        if (conn != null)
	            try {
	                conn.close();
	            } catch (Exception e2) {
	                e2.printStackTrace();
	            }
	    }
		
		return null;
	}
	
	public User getUserById(String id) {
	    Connection conn = DBConnectUtil.ConnectDB();
		
		String sql = "select * from users where id = ?";
		
		ResultSet rs = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				return new User(
					rs.getString("id"),
					rs.getString("username"),
					rs.getString("password"),
					rs.getString("fullname"),
					rs.getString("address"),
					rs.getString("phonenumber"),
					null
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
	        if (conn != null)
	            try {
	                conn.close();
	            } catch (Exception e2) {
	                e2.printStackTrace();
	            }
	    }
		
		
		return null;
	}

	public boolean updateUser(User user) {
	    Connection conn = DBConnectUtil.ConnectDB();
		
		String sql = "update users "
			+ "set fullname = ?, address = ?, phonenumber = ? "
			+ "where id = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getFullname());
			ps.setString(2, user.getAddress());
			ps.setString(3, user.getPhonenumber());
			ps.setString(4, user.getId());
			
			int rowsEffect = ps.executeUpdate();
			return rowsEffect != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
	        if (conn != null)
	            try {
	                conn.close();
	            } catch (Exception e2) {
	                e2.printStackTrace();
	            }
	    }
		
		return false;
	}

	 public boolean deleteUser(String id) {
	        String sql = "delete from users where id = ?";
	        Connection conn = DBConnectUtil.ConnectDB();
	        try {
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, id);
	            int rowEffect = ps.executeUpdate();

	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            if (conn != null)
	                try {
	                    conn.close();
	                } catch (Exception e2) {
	                    e2.printStackTrace();
	                }
	        }
	        return false;
	    }
	 public boolean updateUserRoles(User user) {
	        Connection conn = DBConnectUtil.ConnectDB();
	        
	        String sql = "delete from user_role where userId = ?";
	        String sql2 = "insert into user_role "
	            + "(userId, roleId)"
	            + "values"
	            + "(?, ?)";
	        
	        try {
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, user.getId());
	            
	            PreparedStatement ps2 = conn.prepareStatement(sql2);
	            for(int i = 0; i < user.getRoles().size(); i++) {
	                ps2.setString(1, user.getId());
	                ps2.setString(2, user.getRoles().get(i).getId());
	                
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
	            if(conn!=null)
	            {
	                try {
                        conn.close();
                    } catch (Exception e2) {
                        // TODO: handle exception
                    }
	            }
	        }
	        
	        
	        return false;
	    }

	 public boolean createUser(User user) {
	        Connection conn = DBConnectUtil.ConnectDB();
	        String sql = "insert into users (id, username, password, fullname, address, phonenumber) values (?, ?, ?, ?, ?, ?)";
	        try {
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, user.getId());
	            ps.setString(2, user.getUsername());
	            ps.setString(3, user.getPassword());
	            ps.setString(4, user.getFullname());
	            ps.setString(5, user.getAddress());
	            ps.setString(6, user.getPhonenumber());
	            int row =ps.executeUpdate(); 
	            System.out.println(row);
	        } catch(Exception e) {
	            e.printStackTrace();
	        } finally {
	            if(conn!=null)
	                try {
	                    conn.close();
	                }catch (Exception e2) {
                        e2.printStackTrace();
                    }
	        }       
	        return false;
	    
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
}
