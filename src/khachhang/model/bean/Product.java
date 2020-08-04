package khachhang.model.bean;

import java.time.LocalDate;

public class Product {
private String id, name,image,description,original,categoryid;
private int amount;
private double price;
private LocalDate dateAdded;
public LocalDate getDateAdded() {
	return dateAdded;
}
public void setDateAdded(LocalDate dateAdded) {
	this.dateAdded = dateAdded;
}


public Product(String id, String name, String image, String description, String original, String categoryid, int amount,
        double price, LocalDate dateAdded) {
    super();
    this.id = id;
    this.name = name;
    this.image = image;
    this.description = description;
    this.original = original;
    this.categoryid = categoryid;
    this.amount = amount;
    this.price = price;
    this.dateAdded = dateAdded;
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
public String getImage() {
    return image;
}
public void setImage(String image) {
    this.image = image;
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
public String getCategoryid() {
    return categoryid;
}
public void setCategoryid(String categoryid) {
    this.categoryid = categoryid;
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
