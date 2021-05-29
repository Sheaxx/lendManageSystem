package servlet;



import dao.TimetableDao;
import dao.TimetableDaoImpl;
import entity.Timetable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "selectTimetableServlet")
public class selectTimetableServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        int t_id = Integer.parseInt(request.getParameter("t_id"));
        TimetableDao projectDao = new TimetableDaoImpl();
        List<Timetable> select = projectDao.select(t_id);
        request.setAttribute("select", select);
        request.getRequestDispatcher("jsp/showSelectTimetable.jsp").forward(request, response);
    }
}
