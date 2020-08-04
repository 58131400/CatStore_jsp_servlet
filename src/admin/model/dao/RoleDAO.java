/*
 * @author hoangnguyen
 * @date Apr 23, 2020
 * @version 1.0
 */

package admin.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import admin.model.bean.Role;
import catStore.util.DBConnectUtil;

public class RoleDAO {
	
	
	public ArrayList<Role> getRolesByUserId(String userId) {
		Connection conn = DBConnectUtil.ConnectDB();
		
		String sql = ""
			+ "select roleId, name, description "
			+ "from user_role left join roles "
			+ "on user_role.roleId = roles.id "
			+ "where userId = ?";
		
		ResultSet rs = null;
		ArrayList<Role> roles = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Role role = new Role(
					rs.getString("roleId"),
					rs.getString("name"),
					rs.getString("description")
				);
				
				roles.add(role);
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
		
		return roles;
	}
	public ArrayList<Role> getAllRoles() {
        Connection conn = DBConnectUtil.ConnectDB();
        
        String sql = "select id, name, description from roles";
        ArrayList<Role> roles = new ArrayList<>(); 
        
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
                Role role = new Role(
                    rs.getString("id"),
                    rs.getString("name"),
                    rs.getString("description")
                );
                
                roles.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return roles;
    }
}
