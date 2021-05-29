package servlet;

import dao.ClientDao;

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

@WebServlet(name = "showAllFreelanceServlet")
public class showAllFreelanceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        FreelanceDao freelanceDao = new FreelanceDaoImpl();
        List<Freelance> all = freelanceDao.getFreelanceAll();
        request.setAttribute("all",all);
//        System.out.println(all);
        request.getRequestDispatcher("jsp/showAllFreelance.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
