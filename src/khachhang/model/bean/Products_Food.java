package khachhang.model.bean;

import java.time.LocalDate;

public class Products_Food extends Product {
LocalDate dom;
LocalDate exp;
int weight;
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
public Products_Food(String id, String name, String image, String description, String original, String categoryid,
		int amount, double price, LocalDate dateAdded, LocalDate dom, LocalDate exp, int weight) {
	super(id, name, image, description, original, categoryid, amount, price, dateAdded);
	this.dom = dom;
	this.exp = exp;
	this.weight = weight;
}


}
