/*
 * @author hoangnguyen
 * @date Apr 23, 2020
 * @version 1.0
 */

package admin.model.bo;

import java.util.ArrayList;

import admin.model.bean.Role;
import admin.model.dao.RoleDAO;
import admin.model.dao.UserDAO;

public class RoleBO {
	RoleDAO roleDAO = new RoleDAO();
	
	public ArrayList<Role> getRolesByUserId(String userId) {
		return roleDAO.getRolesByUserId(userId);
	}

    public ArrayList<Role> getAllRoles() {
        // TODO Auto-generated method stub
        return roleDAO.getAllRoles();
    }
}
