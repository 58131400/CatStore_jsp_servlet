/*
 * @author hoangnguyen
 * @date Apr 23, 2020
 * @version 1.0
 */

package admin.model.bo;

import java.util.ArrayList;

import admin.model.bean.Product;
import admin.model.bean.ProductCat;
import admin.model.bean.ProductClothes;
import admin.model.bean.ProductFood;
import admin.model.dao.ProductDAO;

public class ProductBO {
	ProductDAO productDAO = new ProductDAO();

	public ArrayList<Product> getAllProducts() {
		return productDAO.getAllProducts();
	}
	
	public ArrayList<Product> getAllProductCats() {
		return productDAO.getAllProductCats();
	}
	
	public ArrayList<Product> getAllProductClothes() {
		return productDAO.getAllProductClothes();
	}
	
	public ArrayList<Product> getAllProductFoods() {
		return productDAO.getAllProductFoods();
	}

	public ProductCat getProductCatById(String id) {
		return productDAO.getProductCatById(id);
	}

	public ProductClothes getProductClothesById(String id) {
		return productDAO.getProductClothesById(id);
	}
	
	public ProductFood getProductFoodById(String id) {
		return productDAO.getProductFoodById(id);
	}
	
	public boolean updateProductCat(ProductCat cat) {
		return productDAO.updateProductCat(cat);
	}
	
	public boolean updateProductClothes(ProductClothes clothes) {
		return productDAO.updateProductClothes(clothes);
	}
	
	public boolean updateProductFood(ProductFood food) {
		return productDAO.updateProductFood(food);
	}
	
	public boolean deleteProduct(String id) {
		return productDAO.deleteProduct(id);
	}
	
	public boolean createProductCat(ProductCat cat) {
		return productDAO.createProductCat(cat);
	}
	
	public boolean createProductClothes(ProductClothes clothes) {
		return productDAO.createProductClothes(clothes);
	}
	
	public boolean createProductFood(ProductFood food) {
		return productDAO.createProductFood(food);
	}
	
	public Product getProductById(String id) {
		return productDAO.getProductById(id);
	}
}
