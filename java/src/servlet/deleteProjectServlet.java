package servlet;



import dao.ProjectDao;
import dao.ProjectDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class deleteProjectServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int p_id = Integer.parseInt(request.getParameter("p_id"));

        ProjectDao projectDao = new ProjectDaoImpl();

        if (projectDao.delete(p_id)) {
            request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
        } else {
            response.sendRedirect("jsp/deletePartFail.jsp");
        }
    }
}
