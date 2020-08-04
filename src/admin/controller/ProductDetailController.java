package admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.bean.Product;
import admin.model.bo.ProductBO;

/**
 * Servlet implementation class ProductDetail
 */
public class ProductDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetailController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Product product = null;
		ProductBO productBO = new ProductBO();
		
		if(id.contains("CA")) {
			// cat
			product = productBO.getProductCatById(id);
		} else if(id.contains("CL")) {
			// clothes
			product = productBO.getProductClothesById(id);
		} else if(id.contains("FD")) {
			// food
			product = productBO.getProductFoodById(id);
		}
		
		request.setAttribute("product", product);
		request.getRequestDispatcher("/view/admin/views/admin/products/detail.jsp").forward(request, response);
	}

}
