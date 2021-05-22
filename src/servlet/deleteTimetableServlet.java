package servlet;



import dao.TimetableDao;
import dao.TimetableDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteTimetableServlet")
public class deleteTimetableServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int t_id = Integer.parseInt(request.getParameter("t_id"));

        TimetableDao timetableDao = new TimetableDaoImpl();

        if (timetableDao.delete(t_id)) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            response.sendRedirect("deletePartFail.jsp");
        }
    }
}
