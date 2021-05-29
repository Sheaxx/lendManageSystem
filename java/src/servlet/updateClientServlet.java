package servlet;

import dao.ClientDao;
import dao.ClientDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class updateClientServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int c_id = Integer.parseInt(request.getParameter("c_id"));

        String c_name = request.getParameter("c_name"); //获取jsp页面传过来的参数

        String c_type = request.getParameter("c_type");

        String c_contact = request.getParameter("c_contact");

        ClientDao clientDao = new ClientDaoImpl();

        if(clientDao.update(c_id,c_name,c_type,c_contact)){
            request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
        }else{
            response.sendRedirect("jsp/updateFail.jsp");
        }
    }
}
