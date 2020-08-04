package khachhang.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import catStore.util.LogFactory;
import khachhang.model.bean.Products_Cat;
import khachhang.model.bean.Products_Fashion;
import khachhang.model.bo.FashionBO;

/**
 * Servlet implementation class FashionPageServlet
 */
@WebServlet("/fashion")
public class FashionPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private FashionBO fashionBO = new FashionBO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FashionPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    try {
	    request.setAttribute("title", "fashions");
        int page = 1;
        if (request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));
        int record_per_page = 8;
        int offset = (page - 1) * record_per_page;

        List<Products_Fashion> list = fashionBO.getAllProduct();
        List<Products_Fashion> list_pagin = fashionBO.getAllProductPagin(offset, record_per_page);
        int total_record = list.size();
        int total_page= 0;
        if(total_record % record_per_page ==0)
            total_page = total_record / record_per_page;
        else{
            total_page = (total_record  / record_per_page)+1;
        }
        
        LogFactory.getLogger().info("============ Fashion Page=============");
        LogFactory.getLogger().info("total record: " + String.valueOf(total_record));
        LogFactory.getLogger().info("Page: " + String.valueOf(page));
        LogFactory.getLogger().info("total page: " + String.valueOf(total_page));
        LogFactory.getLogger().info("listpagin: " + String.valueOf(list_pagin.size()));

        request.setAttribute("pageIndex", page);
        request.setAttribute("totalPage", total_page);
        request.setAttribute("listFashionPagin", list_pagin);

        request.getRequestDispatcher("/view/template.jsp").forward(request, response);
	    }catch (Exception e) {
	        e.printStackTrace();
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
