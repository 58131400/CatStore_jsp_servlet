package khachhang.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import catStore.util.CatStoreException;
import khachhang.model.bean.User;
import khachhang.model.bo.UserBO;

/**
 * Servlet implementation class UserInfoServlet
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024
        * 100)
@WebServlet("/myaccount")
public class UserInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserBO userBO = new UserBO();
    private static final String UPLOAD_DIR = "image/User";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoServlet() {
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
        try {
            request.setAttribute("title", "account");
            HttpSession session = request.getSession();
            if (session.getAttribute("user") != null) {
                User user = (User) session.getAttribute("user");
                System.out.println("usser: " + user.getUsername());
                request.setAttribute("user", user);
                request.getRequestDispatcher("/view/template.jsp").forward(request, response);
            } else {
                response.setContentType("text/html");
                PrintWriter pw = response.getWriter();
                pw.write("Ban chua dang nhap");
                response.sendRedirect("/CatStore/signin");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            request.setCharacterEncoding("utf-8");
            String id = request.getParameter("id");
            String fullname = request.getParameter("hoten");
            System.out.println(fullname);
            String phone = request.getParameter("dienthoai");
            String address = request.getParameter("diachi");
            String username = request.getParameter("username");

            String password = request.getParameter("password");

            String avatar = uploadFile(request);
            User user = new User(id, username, password, fullname, address, phone, avatar);
            userBO.updateUser(user);
            request.setAttribute("title", "account");
            request.setAttribute("user", user);
            request.getRequestDispatcher("/view/template.jsp").forward(request, response);
        } catch (CatStoreException e) {

            e.getMessage();
            PrintWriter out = response.getWriter();
            response.setContentType("text/html;charset=UTF-8");

            out.println("<script type=\"text/javascript\">");
            out.println("alert('sua khong thanh cong');");
            out.println("alert('" + e.getMessage() + "');");
            out.println("window.location.href='http://localhost:84/CatStore/myaccount';");
            out.println("</script>");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private String uploadFile(HttpServletRequest request) throws IOException, ServletException {
        String fileName = "";
        try {
            Part filePart = request.getPart("hinh");
            fileName = (String) getFileName(filePart);
            String applicationPath = request.getServletContext().getRealPath("");
            System.out.println(applicationPath);
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
        final String partHeader = part.getHeader("content-disposition");
        System.out.println("*****partHeader :" + partHeader);
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }

        return null;
    }
}
