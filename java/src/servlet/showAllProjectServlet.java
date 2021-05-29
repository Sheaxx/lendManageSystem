package servlet;



import dao.ProjectDao;
import dao.ProjectDaoImpl;
import entity.Project;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "showAllProjectServlet")
public class showAllProjectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        ProjectDao projectDao = new ProjectDaoImpl();
        List<Project> all = projectDao.getProjectAll();
        request.setAttribute("all",all);
//        System.out.println(all);
        request.getRequestDispatcher("jsp/showAllProject.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
