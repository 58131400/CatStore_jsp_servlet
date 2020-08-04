package admin.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import admin.model.bean.Role;
import admin.model.bean.User;
import admin.model.bo.RoleBO;
import admin.model.bo.UserBO;
import catStore.util.Authentication;

/**
 * Servlet implementation class UserEdit
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024
        * 100)

@WebServlet("/UserEdit")
public class UserEdit extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String UPLOAD_DIR = "image/User";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        if(!Authentication.isLogin(request)) {
            response.sendRedirect("/CatStore/signin");
            return;
        }
        UserBO userBO = new UserBO();
        User user = null;
        System.out.println(request.getParameter("id"));
        if (request.getParameter("id") != null) {
            String id = request.getParameter("id");
            user = userBO.getUserById(id);
            
            if(user == null)
            {
                PrintWriter pw = response.getWriter();

                pw.write("Khong tim thay idr");
                return;
            }
            request.setAttribute("user", user);
            request.getRequestDispatcher("/view/admin/views/admin/user-edit.jsp").forward(request, response);
        } else {
            PrintWriter pw = response.getWriter();

            pw.write("Ban chua nhap id user");

        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullname = request.getParameter("fullname");
        String address = request.getParameter("address");
        String phonenumber = request.getParameter("phonenumber");
       

        UserBO userBO = new UserBO();
        RoleBO roleBO = new RoleBO();
        ArrayList<Role> listRole = roleBO.getRolesByUserId(id);
        userBO.updateUser(new User(id, username, password, fullname, address, phonenumber, listRole));
        response.sendRedirect("/CatStore/UserList");
    }


}
