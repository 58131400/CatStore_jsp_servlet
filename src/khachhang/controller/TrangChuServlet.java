package khachhang.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import catStore.util.LogFactory;
import khachhang.model.bean.Cart;
import khachhang.model.bean.Product;
import khachhang.model.bean.Products_Cat;
import khachhang.model.bean.Products_Fashion;
import khachhang.model.bean.Products_Food;
import khachhang.model.bean.User;
import khachhang.model.bo.CatBO;
import khachhang.model.bo.FashionBO;
import khachhang.model.bo.FoodBO;
import khachhang.model.bo.ProductBO;
import khachhang.model.bo.UserBO;
import sun.rmi.runtime.Log;

/**
 * Servlet implementation class TrangChuServlet
 */
@WebServlet({ "/home", "/" })
public class TrangChuServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserBO userBO = new UserBO();
    private CatBO catBO = new CatBO();
    private ProductBO productBO = new ProductBO();
    private FashionBO fashionBO = new FashionBO();
    private FoodBO foodBO = new FoodBO();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrangChuServlet() {
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
        request.setAttribute("title", "home");
        HttpSession session = request.getSession();

        if (session.getAttribute("username") != null) {
            String userName = session.getAttribute("username").toString();
            User user = userBO.findUserByUserName(userName);
            request.setAttribute("user", user);
        }
        if (session.getAttribute("cart") != null) {
            Cart cart = (Cart) session.getAttribute("cart");
            request.setAttribute("cart", cart);
        }
        List<Product> listCommingSoon = productBO.getListCommingSoon();
        request.setAttribute("listCommingSoon", listCommingSoon);
        List<Product> listBestSale = productBO.getListBestSale();
        request.setAttribute("listBestSale", listBestSale);
        request.getRequestDispatcher("/view/template.jsp").forward(request, response);
        }catch (Exception e) {
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
            if (request.getParameter("catPage") != null) {
                int page = Integer.parseInt(request.getParameter("catPage"));
                int record_per_page = 4;
                int offset = (page - 1) * record_per_page;

                List<Products_Cat> list = catBO.getAllProduct();
                List<Products_Cat> list_pagin = catBO.getAllProductPagin(offset, record_per_page);
                int total_record = list.size();
                int total_page = 0;
                if (total_record % record_per_page == 0)
                    total_page = total_record / record_per_page;
                else {
                    total_page = (total_record / record_per_page) + 1;
                }

                LogFactory.getLogger().info("============List cat=============");
                LogFactory.getLogger().info("Page: " + String.valueOf(page));
                LogFactory.getLogger().info("total page: " + String.valueOf(total_page));
                LogFactory.getLogger().info("listpagin: " + String.valueOf(list_pagin.size()));

                request.setAttribute("pageIndex", page);
                request.setAttribute("totalPage", total_page);
                request.setAttribute("listCatPagin", list_pagin);
                request.getRequestDispatcher("/view/fragment/ListMeo.jsp").forward(request, response);

            }
            if (request.getParameter("foodPage") != null) {
                int page = Integer.parseInt(request.getParameter("foodPage"));
                int record_per_page = 4;
                int offset = (page - 1) * record_per_page;

                List<Products_Food> list = foodBO.getAllProduct();
                List<Products_Food> list_pagin = foodBO.getAllProductPagin(offset, record_per_page);
                int total_record = list.size();
                int total_page = 0;
                if (total_record % record_per_page == 0)
                    total_page = total_record / record_per_page;
                else {
                    total_page = (total_record / record_per_page) + 1;
                }

                LogFactory.getLogger().info("============List food=============");
                LogFactory.getLogger().info("Page: " + String.valueOf(page));
                LogFactory.getLogger().info("total page: " + String.valueOf(total_page));
                LogFactory.getLogger().info("listpagin: " + String.valueOf(list_pagin.size()));

                request.setAttribute("pageFoodIndex", page);
                request.setAttribute("totalFoodPage", total_page);
                request.setAttribute("listFoodPagin", list_pagin);
                request.getRequestDispatcher("/view/fragment/ListFood.jsp").forward(request, response);

            }
            if (request.getParameter("fashionPage") != null) {
                int page = Integer.parseInt(request.getParameter("fashionPage"));
                int record_per_page = 4;
                int offset = (page - 1) * record_per_page;

                List<Products_Fashion> list = fashionBO.getAllProduct();
                List<Products_Fashion> list_pagin = fashionBO.getAllProductPagin(offset, record_per_page);
                int total_record = list.size();
                int total_page = 0;
                if (total_record % record_per_page == 0)
                    total_page = total_record / record_per_page;
                else {
                    total_page = (total_record / record_per_page) + 1;
                }

                LogFactory.getLogger().info("============List fashion=============");
                LogFactory.getLogger().info("Page: " + String.valueOf(page));
                LogFactory.getLogger().info("total page: " + String.valueOf(total_page));
                LogFactory.getLogger().info("listFashionPagin: " + String.valueOf(list_pagin.size()));

                request.setAttribute("pageFashionIndex", page);
                request.setAttribute("totalFashionPage", total_page);
                request.setAttribute("listFashionPagin", list_pagin);
                request.getRequestDispatcher("/view/fragment/ListFashion.jsp").forward(request, response);

                // List<Product> listCommingSoon = productBO.getListCommingSoon();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
