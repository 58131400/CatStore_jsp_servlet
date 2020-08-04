/*
 * @author hoangnguyen
 * @date Apr 23, 2020
 * @version 1.0
 */

package admin.model.bean;

import java.time.LocalDate;

public class Product {
	private String id;
	private String name;
	private double price;
	private int amount;
	private String image;
	private LocalDate dateAdded;
	private String description;
	private String original;
	private Category category;
	
	public Product(String id, String name, double price, int amount, String image, LocalDate dateAdded, String description,
			String original, Category category) {
		super();
		this.setId(id);
		this.setName(name);
		this.setPrice(price);
		this.setAmount(amount);
		this.setImage(image);
		this.setDateAdded(dateAdded);
		this.setDescription(description);
		this.setOriginal(original);
		this.setCategory(category);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public LocalDate getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(LocalDate dateAdded) {
		this.dateAdded = dateAdded;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOriginal() {
		return original;
	}
	public void setOriginal(String original) {
		this.original = original;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
}
