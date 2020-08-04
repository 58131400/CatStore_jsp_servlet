package admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.bean.User;
import admin.model.bo.UserBO;
import catStore.util.Authentication;

/**
 * Servlet implementation class UserList
 */
@WebServlet("/UserList")
public class UserList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    if(!Authentication.isLogin(request)) {
            response.sendRedirect("/CatStore/signin");
            return;
        }
	    UserBO userBO = new UserBO();
        if(request.getParameter("action") != null && request.getParameter("id") != null ) {
            if(request.getParameter("action").equals("delete")) {
                
            
                String id = request.getParameter("id");
                userBO.deleteUser(id);
                response.sendRedirect("/CatStore/UserList");
                
                return;
            }
        }
        ArrayList<User> userList = userBO.getAllUsers();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("/view/admin/views/admin/user-list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
