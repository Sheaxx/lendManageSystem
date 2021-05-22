package servlet;

import dao.UserDao;
import dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "loginServlet")
public class loginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("user_name"); //得到jsp页面传过来的参数
        String userpassword = request.getParameter("user_password");

        UserDao ud = new UserDaoImpl();

        if (ud.login(username, userpassword)) {
            //request.setAttribute("hello", "欢迎用户" + name); //向request域中放置信息
            request.getRequestDispatcher("/index.jsp").forward(request, response);//转发到成功页面
        } else {
            response.sendRedirect("login.jsp"); //重定向到首页
        }
    }
}
