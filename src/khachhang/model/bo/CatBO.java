package khachhang.model.bo;

import java.util.List;

import khachhang.model.bean.Product;
import khachhang.model.bean.Products_Cat;
import khachhang.model.dao.CatDAO;

public class CatBO {
private CatDAO catDAO = new CatDAO();

public List<Products_Cat> getAllProduct() {
	// TODO Auto-generated method stub
	return catDAO.getAllProduct();
}

public List<Products_Cat> getAllProductPagin(int offset, int record_per_page) {
	// TODO Auto-generated method stub
	return catDAO.getAllProductPagin(offset, record_per_page);
}

}
