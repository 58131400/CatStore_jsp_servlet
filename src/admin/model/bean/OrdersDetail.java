/*
 * @author hoangnguyen
 * @date Apr 24, 2020
 * @version 1.0
 */

package admin.model.bean;

public class OrdersDetail {
	private Product product;
	private int amount;
	private double price;
	
	public OrdersDetail(Product product, int amount, double price) {
		super();
		this.setProduct(product);
		this.setAmount(amount);
		this.setPrice(price);
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
