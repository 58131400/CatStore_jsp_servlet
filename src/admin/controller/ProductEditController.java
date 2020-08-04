package admin.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


import admin.model.bean.Category;
import admin.model.bean.Product;
import admin.model.bean.ProductCat;
import admin.model.bean.ProductClothes;
import admin.model.bean.ProductFood;
import admin.model.bo.CategoryBO;
import admin.model.bo.ProductBO;
import catStore.util.Authentication;

/**
 * Servlet implementation class ProductEdit
 */

@MultipartConfig
public class ProductEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIR = "image";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductEditController() {
		super();
		File file = new File(UPLOAD_DIR);
		if (!file.exists()) {
			file.mkdirs();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(!Authentication.isLogin(request)) {
			response.sendRedirect("/CatStore/signin");
			return;
		}
		
		if(!Authentication.canUpdateProduct(request)) {
			response.sendRedirect("/CatStore/no-permission");
			return;
		}
		
		ProductBO productBO = new ProductBO();
		CategoryBO categoryBO = new CategoryBO();

		Product product = null;
		ArrayList<Category> categories = categoryBO.getAllCategories();
		String id = request.getParameter("id");

		if (id.contains("CA")) {
			// cat
			product = productBO.getProductCatById(id);
		} else if (id.contains("CL")) {
			// clothes
			product = productBO.getProductClothesById(id);
		} else if (id.contains("FD")) {
			// food
			product = productBO.getProductFoodById(id);
		}

		request.setAttribute("product", product);
		request.setAttribute("categories", categories);
		request.getRequestDispatcher("/view/admin/views/admin/products/edit.jsp").forward(request, response);
		request.getSession().removeAttribute("message");
		request.getSession().removeAttribute("error");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean result = false;

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String original = request.getParameter("original");
		String description = request.getParameter("description");
		String category = request.getParameter("category");
		String dateAddedString = request.getParameter("dateAdded");

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dateAdded = LocalDate.parse(dateAddedString, formatter);

		try {
			String image = uploadFile(request);

			double price = Double.valueOf(request.getParameter("price"));
			int amount = Integer.valueOf(request.getParameter("amount"));
			if (id.contains("CA")) {
				// cat
				boolean sex = Boolean.valueOf(request.getParameter("sex"));
				int age = Integer.valueOf(request.getParameter("age"));
				String color = request.getParameter("color");

				ProductBO productBO = new ProductBO();
				result = productBO.updateProductCat(new ProductCat(id, name, price, amount, image, dateAdded,
						description, original, new Category(category, null), sex, age, color));
			} else if (id.contains("CL")) {
				// clothes
				String color = request.getParameter("color");
				String size = request.getParameter("size");
				String material = request.getParameter("material");

				ProductBO productBO = new ProductBO();
				result = productBO.updateProductClothes(new ProductClothes(id, name, price, amount, image, dateAdded,
						description, original, new Category(category, null), color, size, material));
			} else if (id.contains("FD")) {
				// food
				String dom = request.getParameter("dom");
				String exp = request.getParameter("exp");
				int weight = Integer.valueOf(request.getParameter("weight"));
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate domLD = LocalDate.parse(dom, dtf);
				LocalDate expLD = LocalDate.parse(exp, dtf);

				ProductBO productBO = new ProductBO();
				result = productBO.updateProductFood(new ProductFood(id, name, price, amount, image, dateAdded,
						description, original, new Category(category, null), domLD, expLD, weight));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (result) {
			request.getSession().setAttribute("message", "Update successful");
		} else {
			request.getSession().setAttribute("error", "Update failed");
		}

		response.sendRedirect("/CatStore/admin/products/edit?id=" + id);
	}

	private String uploadFile(HttpServletRequest request) throws IOException, ServletException {
		String fileName = "";
		try {
			Part filePart = request.getPart("image");
			fileName = (String) getFileName(filePart);
			String applicationPath = request.getServletContext().getRealPath("");
			String basePath = applicationPath + File.separator + UPLOAD_DIR + File.separator;
			InputStream inputStream = null;
			OutputStream outputStream = null;

			try {
				File outputFilePath = new File(basePath + fileName);
				inputStream = filePart.getInputStream();
				outputStream = new FileOutputStream(outputFilePath);
				int read = 0;
				final byte[] bytes = new byte[1024];
				while ((read = inputStream.read(bytes)) != -1) {
					outputStream.write(bytes, 0, read);
				}
			} catch (Exception e) {
				e.printStackTrace();
				fileName = "";
			} finally {
				if (inputStream != null) {
					inputStream.close();
				}
				if (outputStream != null) {
					outputStream.close();
				}
			}

		} catch (Exception e) {
			fileName = "";
		}
		return fileName;
	}

	private String getFileName(Part part) {
//		final String partHeader = part.getHeader("content-disposition");
//		System.out.println("*****partHeader :" + partHeader);
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}

		return null;
	}
}
