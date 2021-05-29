package servlet;


import dao.FreelanceDao;
import dao.FreelanceDaoImpl;
import entity.Freelance;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "selectFreelanceServlet")
public class selectFreelanceServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        int f_id = Integer.parseInt(request.getParameter("f_id"));
        FreelanceDao freelanceDao = new FreelanceDaoImpl();
        List<Freelance> select = freelanceDao.select(f_id);
        request.setAttribute("select", select);
        request.getRequestDispatcher("jsp/showSelectFreelance.jsp").forward(request, response);
    }
}
