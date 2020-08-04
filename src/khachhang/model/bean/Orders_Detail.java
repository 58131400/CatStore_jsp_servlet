package khachhang.model.bean;

public class Orders_Detail {

private int amount;
private double price;
private Product product;

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
public Product getProduct() {
    return product;
}
public void setProduct(Product product) {
    this.product = product;
}

public Orders_Detail(int amount, double price, Product product) {
    super();
    this.amount = amount;
    this.price = price;
    this.product = product;
   
}


}
