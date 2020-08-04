/*
 * @author hoangnguyen
 * @date Apr 23, 2020
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

import admin.model.bean.Category;
import admin.model.bean.Product;
import admin.model.bean.ProductCat;
import admin.model.bean.ProductClothes;
import admin.model.bean.ProductFood;
import catStore.util.DBConnectUtil;

public class ProductDAO {
	
	public ArrayList<Product> getAllProducts() {
	    Connection conn = DBConnectUtil.ConnectDB();
		
		String sql = ""
			+ "select "
			+ "products.id as id, products.name as name, price, amount, image, dateAdded, description, original, "
			+ "categories.id as categoryId, categories.name as categoryName "
			+ "from products left join categories "
			+ "on products.categoryId = categories.id";
		ResultSet rs = null;
		
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ArrayList<Product> products = new ArrayList<>();
		
		try {
			while(rs.next()) {
				Product product = new Product(
					rs.getString("id"),
					rs.getString("name"),
					rs.getDouble("price"),
					rs.getInt("amount"),
					rs.getString("image"),
					rs.getDate("dateAdded") == null ? null : rs.getDate("dateAdded").toLocalDate(),
					rs.getString("description"),
					rs.getString("original"),
					new Category(
						rs.getString("categoryId"),
						rs.getString("categoryName")
					)
				);
				
				products.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
		}
		
		return products;
	}
	
	public ArrayList<Product> getAllProductCats() {
	    Connection conn = DBConnectUtil.ConnectDB();
		
		String sql = ""
			+ "select "
			+ "products.id as id, products.name as name, price, amount, image, dateAdded, description, original, "
			+ "categories.id as categoryId, categories.name as categoryName "
			+ "from products left join categories "
			+ "on products.categoryId = categories.id "
			+ "where products.id LIKE 'CA%'";
		ResultSet rs = null;
		
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ArrayList<Product> products = new ArrayList<>();
		
		try {
			while(rs.next()) {
				Product product = new Product(
					rs.getString("id"),
					rs.getString("name"),
					rs.getDouble("price"),
					rs.getInt("amount"),
					rs.getString("image"),
					rs.getDate("dateAdded") == null ? null : rs.getDate("dateAdded").toLocalDate(),
					rs.getString("description"),
					rs.getString("original"),
					new Category(
						rs.getString("categoryId"),
						rs.getString("categoryName")
					)
				);
				
				products.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }		}
		
		return products;
	}
	
	public ArrayList<Product> getAllProductClothes() {
	    Connection conn = DBConnectUtil.ConnectDB();
		
		String sql = ""
			+ "select "
			+ "products.id as id, products.name as name, price, amount, image, dateAdded, description, original, "
			+ "categories.id as categoryId, categories.name as categoryName "
			+ "from products left join categories "
			+ "on products.categoryId = categories.id "
			+ "where products.id LIKE 'CL%'";
		ResultSet rs = null;
		
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ArrayList<Product> products = new ArrayList<>();
		
		try {
			while(rs.next()) {
				Product product = new Product(
					rs.getString("id"),
					rs.getString("name"),
					rs.getDouble("price"),
					rs.getInt("amount"),
					rs.getString("image"),
					rs.getDate("dateAdded") == null ? null : rs.getDate("dateAdded").toLocalDate(),
					rs.getString("description"),
					rs.getString("original"),
					new Category(
						rs.getString("categoryId"),
						rs.getString("categoryName")
					)
				);
				
				products.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
		}
		
		return products;
	}
	
	public ArrayList<Product> getAllProductFoods() {
	    Connection conn = DBConnectUtil.ConnectDB();
		
		String sql = ""
			+ "select "
			+ "products.id as id, products.name as name, price, amount, image, dateAdded, description, original, "
			+ "categories.id as categoryId, categories.name as categoryName "
			+ "from products left join categories "
			+ "on products.categoryId = categories.id "
			+ "where products.id LIKE 'FD%'";
		ResultSet rs = null;
		
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ArrayList<Product> products = new ArrayList<>();
		
		try {
			while(rs.next()) {
				Product product = new Product(
					rs.getString("id"),
					rs.getString("name"),
					rs.getDouble("price"),
					rs.getInt("amount"),
					rs.getString("image"),
					rs.getDate("dateAdded") == null ? null : rs.getDate("dateAdded").toLocalDate(),
					rs.getString("description"),
					rs.getString("original"),
					new Category(
						rs.getString("categoryId"),
						rs.getString("categoryName")
					)
				);
				
				products.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
		}
		
		return products;
	}
	
	public Product getProductById(String id) {
	    Connection conn = DBConnectUtil.ConnectDB();
		
		String sql = "select "
			+ "products.id as id, products.name as name, price, amount, image, dateAdded,"
			+ "description, original, "
			+ "categories.id as categoryId, categories.name as categoryName "
			+ "from products left join categories "
			+ "on products.categoryId = categories.id "
			+ "where products.id = ?";
		ResultSet rs = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				return new Product(
					rs.getString("id"),
					rs.getString("name"),
					rs.getDouble("price"),
					rs.getInt("amount"),
					rs.getString("image"),
					rs.getDate("dateAdded") == null ? null : rs.getDate("dateAdded").toLocalDate(),
					rs.getString("description"),
					rs.getString("original"),
					new Category(
						rs.getString("categoryId"),
						rs.getString("categoryName")
					)
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
		
		
		return null;
	}
	
	public ProductCat getProductCatById(String id) {
	    Connection conn = DBConnectUtil.ConnectDB();
		
		String sql = ""
			+ "select "
			+ "products.id as id, products.name as name, price, amount, image, dateAdded,"
			+ "description, original, sex, age, color, "
			+ "categories.id as categoryId, categories.name as categoryName "
			+ "from products right join products_cats "
			+ "on products.id = products_cats.productId "
			+ "left join categories "
			+ "on products.categoryId = categories.id "
			+ "where products.id = ?";
		
		ResultSet rs = null;
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				return new ProductCat(
					rs.getString("id"),
					rs.getString("name"),
					rs.getDouble("price"),
					rs.getInt("amount"),
					rs.getString("image"),
					rs.getDate("dateAdded") == null ? null : rs.getDate("dateAdded").toLocalDate(),
					rs.getString("description"),
					rs.getString("original"),
					new Category(
						rs.getString("categoryId"),
						rs.getString("categoryName")
					),
					rs.getBoolean("sex"),
					rs.getInt("age"),
					rs.getString("color")
				);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
		}
		
		return null;
	}
	
	public ProductClothes getProductClothesById(String id) {
	    Connection conn = DBConnectUtil.ConnectDB();
		
		String sql = ""
			+ "select "
			+ "products.id as id, products.name as name, price, amount, image, dateAdded,"
			+ "description, original, color, size, material, "
			+ "categories.id as categoryId, categories.name as categoryName "
			+ "from products right join products_clothes "
			+ "on products.id = products_clothes.productId "
			+ "left join categories "
			+ "on products.categoryId = categories.id "
			+ "where products.id = ?";
		
		ResultSet rs = null;
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				return new ProductClothes(
					rs.getString("id"),
					rs.getString("name"),
					rs.getDouble("price"),
					rs.getInt("amount"),
					rs.getString("image"),
					rs.getDate("dateAdded") == null ? null : rs.getDate("dateAdded").toLocalDate(),
					rs.getString("description"),
					rs.getString("original"),
					new Category(
						rs.getString("categoryId"),
						rs.getString("categoryName")
					),
					rs.getString("color"),
					rs.getString("size"),
					rs.getString("material")
				);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
		}
		
		return null;
	}
	
	public ProductFood getProductFoodById(String id) {
	    Connection conn = DBConnectUtil.ConnectDB();
		
		String sql = ""
			+ "select "
			+ "products.id as id, products.name as name, price, amount, image, dateAdded,"
			+ "description, original, dom, exp, weight, "
			+ "categories.id as categoryId, categories.name as categoryName "
			+ "from products right join products_food "
			+ "on products.id = products_food.productId "
			+ "left join categories "
			+ "on products.categoryId = categories.id "
			+ "where products.id = ?";
		
		ResultSet rs = null;
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				return new ProductFood(
					rs.getString("id"),
					rs.getString("name"),
					rs.getDouble("price"),
					rs.getInt("amount"),
					rs.getString("image"),
					rs.getDate("dateAdded") == null ? null : rs.getDate("dateAdded").toLocalDate(),
					rs.getString("description"),
					rs.getString("original"),
					new Category(
						rs.getString("categoryId"),
						rs.getString("categoryName")
					),
					rs.getDate("dom").toLocalDate(),
					rs.getDate("exp").toLocalDate(),
					rs.getInt("weight")
				);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
		}
		
		return null;
	}
	
	private boolean updateProduct(Product product) {
	    Connection conn = DBConnectUtil.ConnectDB();
		String sql = ""
			+ "update products set "
			+ "name = ?,"
			+ "price = ?,"
			+ "amount = ?,"
			+ "description = ?,"
			+ "image = ?,"
			+ "dateAdded = ?,"
			+ "original = ?,"
			+ "categoryId = ? "
			+ "where id = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, product.getName());
			ps.setDouble(2, product.getPrice());
			ps.setInt(3, product.getAmount());
			ps.setString(4, product.getDescription());
			ps.setString(5, product.getImage());
			ps.setDate(6, Date.valueOf(product.getDateAdded()));
			ps.setString(7, product.getOriginal());
			ps.setString(8, product.getCategory().getId());
			ps.setString(9, product.getId());
			int rowEffect = ps.executeUpdate();
			
			return rowEffect != 0;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
		}
		
		return false;
	}
	
	public boolean updateProductCat(ProductCat cat) {
	    Connection conn = DBConnectUtil.ConnectDB();
		
		String sql = ""
			+ "update products_cats set "
			+ "sex = ?,"
			+ "age = ?,"
			+ "color = ? "
			+ "where productId = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setBoolean(1, cat.isSex());
			ps.setInt(2, cat.getAge());
			ps.setString(3, cat.getColor());
			ps.setString(4, cat.getId());
			int rowEffect = ps.executeUpdate();
			
			return updateProduct(cat) && rowEffect != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
		}
		
		return false;
	}
	
	public boolean updateProductClothes(ProductClothes clothes) {
	    Connection conn = DBConnectUtil.ConnectDB();
		
		String sql = ""
			+ "update products_clothes set "
			+ "color = ?,"
			+ "size = ?,"
			+ "material = ? "
			+ "where productId = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, clothes.getColor());
			ps.setString(2, clothes.getSize());
			ps.setString(3, clothes.getMaterial());
			ps.setString(4, clothes.getId());
			int rowEffect = ps.executeUpdate();
			
			return updateProduct(clothes) && rowEffect != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
		}
		
		return false;
	}
	
	public boolean updateProductFood(ProductFood food) {
	    Connection conn = DBConnectUtil.ConnectDB();
		
		String sql = ""
			+ "update products_food set "
			+ "dom = ?,"
			+ "exp = ?,"
			+ "weight = ? "
			+ "where productId = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDate(1, Date.valueOf(food.getDom()));
			ps.setDate(2, Date.valueOf(food.getExp()));
			ps.setInt(3, food.getWeight());
			ps.setString(4, food.getId());
			int rowEffect = ps.executeUpdate();
			
			return updateProduct(food) && rowEffect != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
		}
		
		return false;
	}
	
	public boolean deleteProduct(String id) {
	    Connection conn = DBConnectUtil.ConnectDB();
		
		String sql = "delete from products where id = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			int rowEffect = ps.executeUpdate();
			
			return rowEffect != 0;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
		return false;
	}

	private boolean createProduct(Product product) {
	    Connection conn = DBConnectUtil.ConnectDB();
		String sql = ""
			+ "insert into products"
			+ "(id, name, price, amount, image, dateadded, description, original, categoryId)"
			+ "values"
			+ "(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, product.getId());
			ps.setString(2, product.getName());
			ps.setDouble(3, product.getPrice());
			ps.setInt(4, product.getAmount());
			ps.setString(5, product.getImage());
			ps.setString(6, null);
			ps.setString(7, product.getDescription());
			ps.setString(8, product.getOriginal());
			ps.setString(9, product.getCategory().getId());
			int rowEffect = ps.executeUpdate();
			
			return rowEffect != 0;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
		
		return false;
	}
	
	public boolean createProductCat(ProductCat cat) {
	    Connection conn = DBConnectUtil.ConnectDB();
		
		String sql = ""
			+ "insert into products_cats"
			+ "(productId, sex, age, color)"
			+ "values"
			+ "(?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cat.getId());
			ps.setBoolean(2, cat.isSex());
			ps.setInt(3, cat.getAge());
			ps.setString(4, cat.getColor());
			
			return createProduct(cat) && ps.executeUpdate() != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
		
		return false;
	}
	
	public boolean createProductClothes(ProductClothes clothes) {
	    Connection conn = DBConnectUtil.ConnectDB();
		
		String sql = ""
			+ "insert into products_clothes"
			+ "(productId, color, size, material)"
			+ "values"
			+ "(?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, clothes.getId());
			ps.setString(2, clothes.getColor());
			ps.setString(3, clothes.getSize());
			ps.setString(4, clothes.getMaterial());
			
			return createProduct(clothes) && ps.executeUpdate() != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
		
		return false;
	}

	public boolean createProductFood(ProductFood food) {
	    Connection conn = DBConnectUtil.ConnectDB();
		
		String sql = ""
			+ "insert into products_food"
			+ "(productId, dom, exp, weight)"
			+ "values"
			+ "(?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, food.getId());
			ps.setDate(2, Date.valueOf(food.getDom()));
			ps.setDate(3, Date.valueOf(food.getExp()));
			ps.setInt(4, food.getWeight());
			
			return createProduct(food) && ps.executeUpdate() != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
		
		return false;
	}
}
