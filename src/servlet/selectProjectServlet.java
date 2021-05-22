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

@WebServlet(name = "selectProjectServlet")
public class selectProjectServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        int p_id = Integer.parseInt(request.getParameter("p_id"));
        ProjectDao projectDao = new ProjectDaoImpl();
        List<Project> select = projectDao.select(p_id);
        request.setAttribute("select", select);
        request.getRequestDispatcher("showSelectProject.jsp").forward(request, response);
    }
}
