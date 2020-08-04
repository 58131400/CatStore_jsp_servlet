package khachhang.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import catStore.util.DBConnectUtil;
import catStore.util.LogFactory;
import khachhang.model.bean.Product;
import khachhang.model.bean.Products_Cat;
import khachhang.model.bean.Products_Fashion;
import khachhang.model.bean.Products_Food;


public class ProductDAO {
	public List<Product> getListCommingSoon() {
		Connection connection = DBConnectUtil.ConnectDB();
		String sql = "select top 4 * from products where DATEDIFF(DAY,GETDATE(),dateadded) > 0 ";
		List<Product> listProducts = new ArrayList<>();
		try {
			PreparedStatement pStatement = connection.prepareStatement(sql);
			
			ResultSet rs = pStatement.executeQuery();
			while(rs.next()){
				Product p = new Product(rs.getString("id"), rs.getNString("name"), rs.getNString("image"), rs.getNString("description"), rs.getNString("original"), rs.getString("categoryid"), rs.getInt("amount"), rs.getInt("price"),rs.getDate("dateAdded").toLocalDate());
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

	public List<Product> getListBestSale() {
		// TODO Auto-generated method stub
		Connection connection = DBConnectUtil.ConnectDB();
		String sql = "select top 3 * from products p join (select p.id,COUNT(p.id) as count from products p \r\n" + 
				"							join orders_detail od on p.id = od.productid  \r\n" + 
				"							join orders o on od.ordersid = o.id\r\n" + 
				"							group by p.id) e on p.id = e.id\r\n" + 
				"order by p.id";
		List<Product> listProducts = new ArrayList<>();
		try {
			PreparedStatement pStatement = connection.prepareStatement(sql);
			
			ResultSet rs = pStatement.executeQuery();
			while(rs.next()){
				Product p = new Product(rs.getString("id"), rs.getNString("name"), rs.getNString("image"), rs.getNString("description"), rs.getNString("original"), rs.getString("categoryid"), rs.getInt("amount"), rs.getInt("price"),rs.getDate("dateAdded").toLocalDate());
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

    public Product findProductById(String id) {
        // TODO Auto-generated method stub
        Connection connection = DBConnectUtil.ConnectDB();
        String sql = "SELECT * FROM products p left join products_cats c ON p.id = c.productId "
                + " left join products_food f ON p.id=f.productId "
                + " left join products_clothes cl ON p.id = cl.productId WHERE id = ?";
        Product pd = null;
        try {
            PreparedStatement prs = connection.prepareStatement(sql);
            prs.setString(1,id);
            ResultSet rs = prs.executeQuery();
            while(rs.next())
            {
                //lay loai san pham theo chu cai dau
                String id1 = rs.getString("id");
                System.out.println("DAO: "+id1);
                System.out.println("DAO: "+id1.substring(0, 2));
                if(id1.substring(0, 2).equals("CA")) {
                     pd = new Products_Cat(rs.getString("id"),  rs.getString("name"), rs.getString("image"), rs.getString("description"), rs.getString("original"),rs.getString("categoryId"),
                              rs.getInt("amount"),rs.getDouble("price"), rs.getDate("dateadded").toLocalDate(),rs.getString("color"),rs.getBoolean("sex"),rs.getInt("age"));
                     System.out.println("DAO: CA"+ pd.getName());
                }
                else if(id1.substring(0, 2).equals("FD")) {
                    
                     pd = new Products_Food(rs.getString("id"),  rs.getString("name"), rs.getString("image"), rs.getString("description"), rs.getString("original"),rs.getString("categoryId"),
                             rs.getInt("amount"),rs.getDouble("price"), rs.getDate("dateadded").toLocalDate(),rs.getDate("dom").toLocalDate(),
                            rs.getDate("exp").toLocalDate(),rs.getInt("weight"));
                     System.out.println("DAO: FD"+ pd.getName());
                }
                else {
                     pd = new Products_Fashion(rs.getString("id"),  rs.getString("name"), rs.getString("image"), rs.getString("description"), rs.getString("original"),rs.getString("categoryId"),
                             rs.getInt("amount"),rs.getDouble("price"), rs.getDate("dateadded").toLocalDate(),rs.getString("color"),rs.getString("size").charAt(0),rs.getString("material"));
                }
                
            }
            } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //
        finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        
        return pd;
    }

    public double getPriceAfterDiscount(Product product) {
        // TODO Auto-generated method stub
        Connection connection = DBConnectUtil.ConnectDB();
        String sql = "select  price * (100- p2.promotion)/100 as newPrice \r\n" + 
                " from products p1 join products_promotion pp on p1.id = pp.productId join promotion p2 on p2.id = pp.promotionId where p1.id = ? ";
        double price = product.getPrice();
        try {
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, product.getId());
            ResultSet rs = pStatement.executeQuery();
            while (rs.next()) {
                price = rs.getDouble("newPrice"); 
                LogFactory.getLogger().info(String.valueOf(price));
            }
        }catch (Exception e) {
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
        return price;
    }

 
}