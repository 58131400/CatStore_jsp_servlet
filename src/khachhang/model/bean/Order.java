package khachhang.model.bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
private String id,userId;
private LocalDate ordersDate;
private double total;
private boolean status;
private List<Orders_Detail> listChiTiet;
public String getId() {
    return id;
}
public void setId(String id) {
    this.id = id;
}
public String getUserId() {
    return userId;
}
public void setUserId(String userId) {
    this.userId = userId;
}
public LocalDate getOrdersDate() {
    return ordersDate;
}
public void setOrdersDate(LocalDate ordersDate) {
    this.ordersDate = ordersDate;
}
public double getTotal() {
    return total;
}
public void setTotal(double total) {
    this.total = total;
}
public boolean isStatus() {
    return status;
}
public void setStatus(boolean status) {
    this.status = status;
}
public List<Orders_Detail> getListChiTiet() {
    return listChiTiet;
}
public void setListChiTiet(List<Orders_Detail> listChiTiet) {
    this.listChiTiet = listChiTiet;
}
public Order(String id, String userId, LocalDate ordersDate, double total, boolean status,
        List<Orders_Detail> listChiTiet) {
    super();
    this.id = id;
    this.userId = userId;
    this.ordersDate = ordersDate;
    this.total = total;
    this.status = status;
    this.listChiTiet = listChiTiet;
}


}
