package khachhang.model.bo;

import java.util.ArrayList;
import java.util.List;

import khachhang.model.bean.Role;
import khachhang.model.bean.User;
import khachhang.model.dao.UserDAO;
import khachhang.model.dao.RoleDAO;

public class UserBO {

	private UserDAO userDAO = new UserDAO();
	private RoleDAO roleDAO = new RoleDAO();
	
	public User findUserByUserName(String userName) {
		
		return userDAO.findUserByUserName(userName);
	}
	public User isValidUser(String username, String password) {
		// TODO Auto-generated method stub
		return userDAO.isValidUser(username,password);
	}
	public List<Role> getRoles(String username) {
		String id = userDAO.findUserByUserName(username).getId();
		return roleDAO.getRoles(id);
	}
	public void updateUser(User user) {
		
		userDAO.updateUser(user);
	}
    public String getIdUserAuto() {
        // TODO Auto-generated method stub
        return userDAO.getIdUserAuto();
    }
    public void createUser(User user) {
      userDAO.createUser(user);
        
    }
    public Boolean isValidUserName(String username) {
        
        return userDAO.isValidUserName(username);
    }
   

}
