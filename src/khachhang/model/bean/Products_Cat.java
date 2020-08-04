package khachhang.model.bean;

import java.time.LocalDate;

public class Products_Cat extends Product {

	private String color;
	private Boolean sex;
	private int age;
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Boolean getSex() {
		return sex;
	}
	public void setSex(Boolean sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Products_Cat(String id, String name, String image, String description, String original, String categoryid,
			int amount, double price, LocalDate dateAdded, String color, Boolean sex, int age) {
		super(id, name, image, description, original, categoryid, amount, price, dateAdded);
		this.color = color;
		this.sex = sex;
		this.age = age;
	}
	
	
}
