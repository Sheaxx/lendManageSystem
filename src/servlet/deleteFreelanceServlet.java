package servlet;


import dao.FreelanceDao;
import dao.FreelanceDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteFreelanceServlet")
public class deleteFreelanceServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int f_id = Integer.parseInt(request.getParameter("f_id"));

        FreelanceDao freelanceDao = new FreelanceDaoImpl();

        if (freelanceDao.delete(f_id)) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            response.sendRedirect("deletePartFail.jsp");
        }
    }
}
