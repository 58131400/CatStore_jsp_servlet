package khachhang.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import khachhang.model.bean.Cart;
import khachhang.model.bean.Item;
import khachhang.model.bean.Product;
import khachhang.model.bean.Products_Cat;
import khachhang.model.bean.Products_Fashion;
import khachhang.model.bean.Products_Food;
import khachhang.model.bo.ProductBO;

/**
 * Servlet implementation class SingleproductServlet
 */
@WebServlet("/singleproduct")
public class SingleProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductBO productBO = new ProductBO();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SingleProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setAttribute("title", "singleProduct");
            // LAY ID TU DUONG DAN
            if (request.getParameter("id") != null) {
                String id = request.getParameter("id");
                System.out.println("id serv " + id);
                Product pd = productBO.findProductById(id);
                if (pd instanceof Products_Cat) {
                    pd = (Products_Cat) pd;

                }
                if (pd instanceof Products_Food) {
                    pd = (Products_Food) pd;

                }
                if (pd instanceof Products_Fashion) {
                    pd = (Products_Fashion) pd;

                }
                request.setAttribute("product", pd);
                request.getRequestDispatcher("/view/template.jsp").forward(request, response);
            } else {
                PrintWriter out = response.getWriter();
                out.println("You haven't entered ID yet");
            }
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
        // TODO Auto-generated method stub
        try {
            String id = request.getParameter("id");
            String quantity = request.getParameter("quantity");
            response.sendRedirect("/CatStore/cart?action=add&id=" + id + "&quantity=" + quantity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
