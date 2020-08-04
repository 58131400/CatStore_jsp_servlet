/*
 * @author hoangnguyen
 * @date Apr 23, 2020
 * @version 1.0
 */

package admin.model.bean;

import java.time.LocalDate;

public class ProductClothes extends Product {
	private String color;
	private String size;
	private String material;
	
	public ProductClothes(String id, String name, double price, int amount, String image, LocalDate dateAdded, String description,
			String original, Category category, String color, String size, String material) {
		super(id, name, price, amount, image, dateAdded, description, original, category);
		this.setColor(color);
		this.setSize(size);
		this.setMaterial(material);
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
}
