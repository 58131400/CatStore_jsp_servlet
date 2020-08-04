/*
 * @author hoangnguyen
 * @date Apr 23, 2020
 * @version 1.0
 */

package admin.model.bo;

import java.util.ArrayList;

import admin.model.bean.User;
import admin.model.dao.UserDAO;

public class UserBO {
	UserDAO userDAO = new UserDAO();
	
	public ArrayList<User> getAllUsers() {
		return userDAO.getAllUsers();
	}
	
	public User getUserByUsername(String username) {
		return userDAO.getUserByUsername(username);
	}
	
	public User getUserById(String id) {
		return userDAO.getUserById(id);
	}
	
	public boolean updateUser(User user) {
		return userDAO.updateUser(user);
	}

    public void deleteUser(String id) {
        userDAO.deleteUser(id);
        
    }

    public boolean updateUserRoles(User user) {
        // TODO Auto-generated method stub
        return userDAO.updateUserRoles(user);
    }

    public boolean createUser(User user) {
        // TODO Auto-generated method stub
        return userDAO.createUser(user);
    }

    public String getIdUserAuto() {
        // TODO Auto-generated method stub
        return userDAO.getIdUserAuto();
    }

   
}
