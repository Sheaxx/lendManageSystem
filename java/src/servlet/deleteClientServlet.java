package servlet;

import dao.ClientDao;
import dao.ClientDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class deleteClientServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int c_id = Integer.parseInt(request.getParameter("c_id"));

        ClientDao clientDao = new ClientDaoImpl();

        if (clientDao.delete(c_id)) {
            request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
        } else {
            response.sendRedirect("jsp/deletePartFail.jsp");
        }
    }
}
