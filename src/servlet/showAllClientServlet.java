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

@WebServlet(name = "showAllClientServlet")
public class showAllClientServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        ClientDao clientDao = new ClientDaoImpl();
        List<Client> all = clientDao.getClientAll();
        request.setAttribute("all",all);
//        System.out.println(all);
        request.getRequestDispatcher("showAllClient.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
