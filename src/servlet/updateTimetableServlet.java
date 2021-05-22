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

@WebServlet(name = "updateTimetableServlet")
public class updateTimetableServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int t_id = Integer.parseInt(request.getParameter("t_id"));

        int t_fid = Integer.parseInt(request.getParameter("t_fid")); //获取jsp页面传过来的参数

        String t_content = request.getParameter("t_content");

        TimetableDao timetableDao = new TimetableDaoImpl();

        if(timetableDao.update(t_id,t_fid,t_content)){
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }else{
            response.sendRedirect("updateFail.jsp");
        }
    }
}
