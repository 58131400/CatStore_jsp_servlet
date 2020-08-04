package khachhang.model.bo;

import java.util.ArrayList;
import java.util.List;

import khachhang.model.bean.Product;
import khachhang.model.dao.ProductDAO;


public class ProductBO {
private ProductDAO productDAO = new ProductDAO();
	public List<Product> getListCommingSoon() {
		
		return productDAO.getListCommingSoon();
	}
	public List<Product> getListBestSale() {
		// TODO Auto-generated method stub
		return productDAO.getListBestSale();
	}
    public Product findProductById(String id) {
        // TODO Auto-generated method stub
        return productDAO.findProductById(id);
    }
    public double getPriceAfterDiscount(Product product) {
        // TODO Auto-generated method stub
        return productDAO.getPriceAfterDiscount(product);
    }
   

}
