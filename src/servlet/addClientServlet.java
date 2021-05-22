package servlet;

import dao.ClientDao;
import dao.ClientDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class addClientServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String c_name = request.getParameter("c_name"); //得到jsp页面传过来的参数
        System.out.println(c_name);

        String c_type = request.getParameter("c_type");
        String c_contact = request.getParameter("c_contact");
        System.out.println(c_type);

        ClientDao clientDao = new ClientDaoImpl();

        if (clientDao.add(c_name,c_type,c_contact)) {
            //request.setAttribute("hello", "欢迎用户" + name); //向request域中放置信息
            request.getRequestDispatcher("/index.jsp").forward(request, response);//转发到成功页面
        } else {
            response.sendRedirect("addFail.jsp"); //重定向到首页
        }
    }
}
