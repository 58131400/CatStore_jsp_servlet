package khachhang.model.bo;

import java.util.List;

import khachhang.model.bean.Products_Fashion;
import khachhang.model.dao.FashionDAO;

public class FashionBO {
private FashionDAO fashionDAO = new FashionDAO();
	public List<Products_Fashion> getAllProduct() {
		// TODO Auto-generated method stub
		return fashionDAO.getAllProduct();
	}
	public List<Products_Fashion> getAllProductPagin(int offset, int record_per_page) {
		// TODO Auto-generated method stub
		return fashionDAO.getAllProductPagin(offset, record_per_page);
	}

}
