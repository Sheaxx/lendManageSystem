package servlet;



import dao.ProjectDao;
import dao.ProjectDaoImpl;
import entity.Project;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class updateProjectServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int p_id = Integer.parseInt(request.getParameter("p_id"));

        String p_name = request.getParameter("p_name"); //获取jsp页面传过来的参数

        String p_type = request.getParameter("p_type");

        String p_content = request.getParameter("p_content");

        ProjectDao projectDao = new ProjectDaoImpl();

        if(projectDao.update(p_id,p_name,p_type,p_content)){
            request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
        }else{
            response.sendRedirect("jsp/updateFail.jsp");
        }
    }
}
