package admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.bean.User;
import admin.model.bo.UserBO;

@WebServlet("/usercreate")
public class UserCreate extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCreate() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
        
        request.getRequestDispatcher("/view/admin/views/admin/user-create.jsp").forward(request, response);
        request.getSession().removeAttribute("message");
        request.getSession().removeAttribute("error");
        
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean result = false;
        request.setCharacterEncoding("utf-8");
        UserBO userBO = new UserBO();
        String id = userBO.getIdUserAuto();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullname = request.getParameter("fullname");
        String address = request.getParameter("address");
        String phonenumber = request.getParameter("phonenumber");
        
        User user = new User(id,username,password,fullname, address,phonenumber,null);
        result = userBO.createUser(user);
        if (result) {
            request.getSession().setAttribute("message", "Create successful");
        }else {
            request.getSession().setAttribute("error", "Create failed");
        }
        response.sendRedirect("/CatStore/usercreate");
    }

}
