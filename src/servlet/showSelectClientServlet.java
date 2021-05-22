package servlet;

import dao.ClientDao;
import dao.ClientDaoImpl;
import entity.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "showSelectClientServlet")
public class showSelectClientServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        int c_id = Integer.parseInt(request.getParameter("c_id"));
        ClientDao clientDao = new ClientDaoImpl();
        List<Client> select = clientDao.select(c_id);
        request.setAttribute("select", select);
        request.getRequestDispatcher("showSelectClient.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
