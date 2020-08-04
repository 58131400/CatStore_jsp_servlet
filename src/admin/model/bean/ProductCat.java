/*
 * @author hoangnguyen
 * @date Apr 23, 2020
 * @version 1.0
 */

package admin.model.bean;

import java.time.LocalDate;

public class ProductCat extends Product {
	private boolean sex;
	private int age;
	private String color;
	public ProductCat(String id, String name, double price, int amount, String image, LocalDate dateAdded, String description,
			String original, Category category, boolean sex, int age, String color) {
		super(id, name, price, amount, image, dateAdded, description, original, category);
		this.setSex(sex);
		this.setAge(age);
		this.setColor(color);
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
}
