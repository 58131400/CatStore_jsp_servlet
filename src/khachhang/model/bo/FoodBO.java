package khachhang.model.bo;

import java.util.List;

import khachhang.model.bean.Products_Food;
import khachhang.model.dao.FoodDAO;

public class FoodBO {
	private FoodDAO foodDAO  = new FoodDAO();
	public List<Products_Food> getAllProduct() {
		// TODO Auto-generated method stub
		return foodDAO.getAllProduct();
	}
	public List<Products_Food> getAllProductPagin(int offset, int record_per_page) {
		// TODO Auto-generated method stub
		return foodDAO.getAllProductPagin(offset, record_per_page);
	}

}
