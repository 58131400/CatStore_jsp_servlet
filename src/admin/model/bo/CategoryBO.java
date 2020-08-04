/*
 * @author hoangnguyen
 * @date Apr 23, 2020
 * @version 1.0
 */

package admin.model.bo;

import java.util.ArrayList;

import admin.model.bean.Category;
import admin.model.dao.CategoryDAO;

public class CategoryBO {
	CategoryDAO categoryDAO = new CategoryDAO();
	
	public ArrayList<Category> getAllCategories() {
		return categoryDAO.getAllCategories();
	}
}
