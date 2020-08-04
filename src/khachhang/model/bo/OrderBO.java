package khachhang.model.bo;

import khachhang.model.bean.Order;
import khachhang.model.dao.OrderDAO;
import khachhang.model.dao.OrderDetailDAO;

public class OrderBO {
private OrderDAO orderDAO  = new OrderDAO();
private OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
    public String getIdOrderAuto() {
        // TODO Auto-generated method stub
        return orderDAO.getIdOrderAuto();
    }
    public void insertOrder(Order o) {
        // TODO Auto-generated method stub
        orderDAO.insertOrder(o);
        orderDetailDAO .insertOrderDetail(o.getListChiTiet(),o);
    }

}
