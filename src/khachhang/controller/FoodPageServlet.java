package khachhang.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import catStore.util.LogFactory;
import khachhang.model.bean.Products_Food;
import khachhang.model.bo.FoodBO;

/**
 * Servlet implementation class FoodPageServlet
 */
@WebServlet("/food")
public class FoodPageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private FoodBO foodBO = new FoodBO();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodPageServlet() {
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
            request.setAttribute("title", "foods");
            int page = 1;
            if (request.getParameter("page") != null)
                page = Integer.parseInt(request.getParameter("page"));
            int record_per_page = 8;
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

            LogFactory.getLogger().info("============ Food Page=============");
            LogFactory.getLogger().info("total record: " + String.valueOf(total_record));
            LogFactory.getLogger().info("Page: " + String.valueOf(page));
            LogFactory.getLogger().info("total page: " + String.valueOf(total_page));
            LogFactory.getLogger().info("listpagin: " + String.valueOf(list_pagin.size()));

            request.setAttribute("pageIndex", page);
            request.setAttribute("totalPage", total_page);
            request.setAttribute("listFoodPagin", list_pagin);

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
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
