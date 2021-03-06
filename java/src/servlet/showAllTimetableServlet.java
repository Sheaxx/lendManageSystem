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

@WebServlet(name = "showAllTimetableServlet")
public class showAllTimetableServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        TimetableDao timetableDao = new TimetableDaoImpl();
        List<Timetable> all = timetableDao.getTimetableAll();
        request.setAttribute("all",all);
//        System.out.println(all);
        request.getRequestDispatcher("jsp/showAllTimetable.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
