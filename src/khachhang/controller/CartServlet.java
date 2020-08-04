/*
 * CartServlet.java
 * 
 * Version
 * 
 * 27-04-2020
 * 
 * Copyright
 * 
 * Modification Logs:
 * DATE      	AUTHOR		DESCRIPTION
 * ----------------------------------------
 * 27-04-2020	ThaiND3			
 */
package khachhang.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import catStore.util.LogFactory;
import khachhang.model.bean.Cart;
import khachhang.model.bean.Item;
import khachhang.model.bean.Order;
import khachhang.model.bean.Orders_Detail;
import khachhang.model.bean.Product;
import khachhang.model.bean.User;
import khachhang.model.bo.OrderBO;
import khachhang.model.bo.ProductBO;
import khachhang.model.bo.UserBO;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductBO productBO = new ProductBO();
    private UserBO userBO = new UserBO();
    private OrderBO orderBO = new OrderBO();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        try {
            HttpSession session = request.getSession();
            if (request.getParameter("action") != null) {
                if (request.getParameter("action").equals("add") && request.getParameter("id") != null) {
                    String id = request.getParameter("id");
                    Product product = productBO.findProductById(id);
                    double price = productBO.getPriceAfterDiscount(product);
                    System.out.println("price servlet: " + price);
                    int quantity = 1;
                    if (request.getParameter("quantity") != null) {
                        quantity = Integer.parseInt(request.getParameter("quantity"));
                    }
                    if (session.getAttribute("cart") == null) {
                        Cart cart = new Cart();
                        HashMap<String, Item> mapItems = new HashMap<>();

                        Item item = new Item(product, quantity, price);
                        mapItems.put(product.getId(), item);
                        cart.setCartItems(mapItems);
                        session.setAttribute("cart", cart);
                    } else {
                        Cart cart = (Cart) session.getAttribute("cart");
                        HashMap<String, Item> mapItems = cart.getCartItems();
                        boolean check = false;
                        for (Map.Entry<String, Item> itemMap : mapItems.entrySet()) {
                            if (itemMap.getKey().equals(product.getId())) {
                                itemMap.getValue().setQuantity(itemMap.getValue().getQuantity() + quantity);
                                check = true;
                            }
                        }
                        if (check == false) {
                            Item item = new Item(product, quantity, price);
                            cart.insertToCart(product.getId(), item);
                        }
                        session.setAttribute("cart", cart);
                    }

                }
                if (request.getParameter("action").equals("remove") && request.getParameter("id") != null) {
                    Cart cart = (Cart) session.getAttribute("cart");
                    cart.removeToCart(request.getParameter("id"));
                    response.sendRedirect("/CatStore/cart");
                    return;
                }
                if (request.getParameter("action").equals("process")) {
                    if (session.getAttribute("user") == null) {
                        response.sendRedirect("/CatStore/signin");
                        return;
                    } else {
                        Cart cart = (Cart) session.getAttribute("cart");
                        HashMap<String, Item> mapItem = cart.getCartItems();
                        List<Orders_Detail> listOrderDetail = new ArrayList<>();
                        for (Map.Entry<String, Item> item : mapItem.entrySet()) {
                            Orders_Detail od = new Orders_Detail(item.getValue().getQuantity(),
                                    item.getValue().getPrice(), item.getValue().getProduct());
                            System.out.println(item.getValue().getPrice());
                            listOrderDetail.add(od);
                        }
                        String id = orderBO.getIdOrderAuto();
                        LogFactory.getLogger().info(id);
                        String userId = ((User) session.getAttribute("user")).getId();
                        Order o = new Order(id, userId, LocalDate.now(), cart.total(), false, listOrderDetail);
                        orderBO.insertOrder(o);
                        session.removeAttribute("cart");
                        response.sendRedirect("/CatStore/home");
                        return;
                    }

                }
            }
            request.setAttribute("title", "cart");
            request.getRequestDispatcher("/view/template.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String[] listQuantity = request.getParameterValues("quantity");
            HttpSession session = request.getSession();
            if (session.getAttribute("cart") != null) {
                Cart cart = (Cart) session.getAttribute("cart");
                int i = 0;
                for (Map.Entry<String, Item> entry : cart.getCartItems().entrySet()) {
                    entry.getValue().setQuantity(Integer.parseInt(listQuantity[i]));
                    i++;
                }
                session.setAttribute("cart", cart);
            }
            response.sendRedirect("/CatStore/cart");
        } catch (Exception e) {
            System.out.println("Sorry, something went wrong");
        }
    }

}
