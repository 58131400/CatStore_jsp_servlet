package khachhang.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import khachhang.model.bean.Role;
import khachhang.model.bean.User;
import khachhang.model.bo.UserBO;

/**
 * Servlet implementation class SignIn
 */
@WebServlet("/signin")
public class SignIn extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserBO userBO = new UserBO();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignIn() {
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
        HttpSession session = request.getSession();
        session.removeAttribute("cart");
        session.removeAttribute("user");
        request.setAttribute("title", "signin");
        request.getRequestDispatcher("/view/template.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        try {
            if (request.getParameter("username") != null && request.getParameter("password") != null) {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                User user = userBO.isValidUser(username, password);
                if (user != null) {
                    List<Role> roles = userBO.getRoles(username);
                    System.out.println("size role list" + roles.size());
                    for (Role role : roles) {
                        System.out.println(role.getId());
                    }
                    HttpSession session = request.getSession();
                    session.setAttribute("user", user);
                    for (Role role : roles) {
                        if (role.getId().equals("R0024")) {
                            ArrayList<admin.model.bean.Role> arrayRoles = new ArrayList<>();
                            for (Role role2 : roles) {
                                admin.model.bean.Role role3 = new admin.model.bean.Role(role2.getId(), role2.getName(),
                                        role2.getDescription());
                                arrayRoles.add(role3);
                            }

                            admin.model.bean.User userAdmin = new admin.model.bean.User(user.getId(),
                                    user.getUsername(), user.getPassword(), user.getFullname(), user.getAddress(),
                                    user.getPhone(), arrayRoles);
                            session.setAttribute("user", userAdmin);

                            // request.getRequestDispatcher("/view/admin/views/admin/dashboard.jsp").forward(request,
                            // response);
                            response.sendRedirect("/CatStore/admin/");

                            return;
                        }
                    }
                    response.sendRedirect("/CatStore/home");
                } else {
                    PrintWriter out = response.getWriter();
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Dang nhap khong thanh cong');");
                    out.println("window.location.href='http://localhost:84/CatStore/signin';");
                    out.println("</script>");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
