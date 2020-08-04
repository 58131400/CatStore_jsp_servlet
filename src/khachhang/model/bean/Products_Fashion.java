package khachhang.model.bean;

import java.time.LocalDate;

public class Products_Fashion extends Product{

	private String color;
	private char size;
	private String material;
	
	
	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public char getSize() {
		return size;
	}


	public void setSize(char size) {
		this.size = size;
	}


	public String getMaterial() {
		return material;
	}


	public void setMaterial(String material) {
		this.material = material;
	}


	public Products_Fashion(String id, String name, String image, String description, String original,
			String categoryid, int amount, double price, LocalDate dateAdded, String color, char size, String material) {
		super(id, name, image, description, original, categoryid, amount, price, dateAdded);
		this.color = color;
		this.size = size;
		this.material = material;
	}
	
	
}
