/*
 * @author hoangnguyen
 * @date Apr 23, 2020
 * @version 1.0
 */
package admin.model.bean;

import java.time.LocalDate;

public class ProductFood extends Product {
	private LocalDate dom;
	private LocalDate exp;
	private int weight;
	public ProductFood(String id, String name, double price, int amount, String image, LocalDate dateAdded, String description,
			String original, Category category, LocalDate dom, LocalDate exp, int weight) {
		super(id, name, price, amount, image, dateAdded, description, original, category);
		this.setDom(dom);
		this.setExp(exp);
		this.setWeight(weight);
	}
	public LocalDate getDom() {
		return dom;
	}
	public void setDom(LocalDate dom) {
		this.dom = dom;
	}
	public LocalDate getExp() {
		return exp;
	}
	public void setExp(LocalDate exp) {
		this.exp = exp;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
}
