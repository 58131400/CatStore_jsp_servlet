package khachhang.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import catStore.util.DBConnectUtil;
import khachhang.model.bean.Products_Fashion;

public class FashionDAO {
	public List<Products_Fashion> getAllProduct() {
		Connection connection = DBConnectUtil.ConnectDB();
		String sql = "Select * from Products_clothes  c join Products p on p.id = c.productid ";
		List<Products_Fashion> listProducts = new ArrayList<>();
		try {
			PreparedStatement pStatement = connection.prepareStatement(sql);
			
			ResultSet rs = pStatement.executeQuery();
			while(rs.next()){
				Products_Fashion p = new Products_Fashion(rs.getString("id"), rs.getNString("name"), rs.getNString("image"), rs.getNString("description"), rs.getNString("original"), rs.getString("categoryid"), rs.getInt("amount"), rs.getInt("price"),rs.getDate("dateAdded").toLocalDate(),
						rs.getNString("color"),rs.getString("size").charAt(0),rs.getNString("material"));
				listProducts.add(p);
			}
			
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
		
		return listProducts;
	}
	public List<Products_Fashion> getAllProductPagin(int offset, int fetchNext) {
		Connection connection = DBConnectUtil.ConnectDB();
		String sql = "Select * from Products_clothes c join products p on c.productid = p.id order by id Offset ? rows Fetch Next ? rows only";
		List<Products_Fashion> listProducts = new ArrayList<>();
		try {
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, offset);
			pStatement.setInt(2, fetchNext);
			ResultSet rs = pStatement.executeQuery();
			while(rs.next()){
				Products_Fashion p = new Products_Fashion(rs.getString("id"), rs.getNString("name"), rs.getNString("image"),
						rs.getNString("description"), rs.getNString("original"), rs.getString("categoryid"), rs.getInt("amount"),
						rs.getInt("price"),rs.getDate("dateAdded").toLocalDate(),rs.getNString("color"),rs.getString("size").charAt(0),
						rs.getNString("material"));
				listProducts.add(p);
			}
			connection.close();
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
		
		return listProducts;
	}
}
