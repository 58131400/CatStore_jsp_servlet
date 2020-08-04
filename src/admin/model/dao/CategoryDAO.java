/*
 * @author hoangnguyen
 * @date Apr 23, 2020
 * @version 1.0
 */

package admin.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import admin.model.bean.Category;
import catStore.util.DBConnectUtil;

public class CategoryDAO {
	
	
	public ArrayList<Category> getAllCategories() {
		Connection conn = DBConnectUtil.ConnectDB();
		
		String sql = "select id, name from categories";
		
		ResultSet rs = null;
		
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ArrayList<Category> categories = new ArrayList<>();
		
		try {
			while(rs.next()) {
				Category category = new Category(
					rs.getString("id"),
					rs.getString("name")
				);
				
				categories.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return categories;
	}
}
