package servlet;

import dao.UserDao;
import dao.UserDaoImpl;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "registerServlet")
public class registerServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("user_name"); //获取jsp页面传过来的参数
        String userpassword = request.getParameter("user_password");

        User user = new User(); //实例化一个对象，组装属性
        user.setUsername(username);
        user.setPassword(userpassword);

        UserDao ud = new UserDaoImpl();

        if(ud.register(user)){
//            request.setAttribute("user_name", user_name);  //向request域中放置参数
//            request.getRequestDispatcher("/login.jsp").forward(request, response);  //转发到登录页面
            response.sendRedirect("jsp/login.jsp");
        }else{
            response.sendRedirect("jsp/register.jsp");//注册失败则返回注册页面，但是缺少提示"注册失败"
        }
    }
}
