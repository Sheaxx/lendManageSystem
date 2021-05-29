package servlet;



import dao.ProjectDao;
import dao.ProjectDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class addProjectServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String p_name = request.getParameter("p_name"); //得到jsp页面传过来的参数
        String p_type = request.getParameter("p_type");
        String p_content = request.getParameter("p_content");

        ProjectDao projectDao = new ProjectDaoImpl();

        if (projectDao.add(p_name,p_type,p_content)) {
            //request.setAttribute("hello", "欢迎用户" + name); //向request域中放置信息
            request.getRequestDispatcher("jsp/index.jsp").forward(request, response);//转发到成功页面
        } else {
            response.sendRedirect("jsp/addFail.jsp"); //重定向到首页
        }
    }
}
