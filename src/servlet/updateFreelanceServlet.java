package servlet;



import dao.FreelanceDao;
import dao.FreelanceDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updateFreelanceServlet")
public class updateFreelanceServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int f_id = Integer.parseInt(request.getParameter("f_id"));

        String f_name = request.getParameter("f_name"); //获取jsp页面传过来的参数

        String f_type = request.getParameter("f_type");

        String f_contact = request.getParameter("f_contact");

        FreelanceDao freelanceDao = new FreelanceDaoImpl();

        if(freelanceDao.update(f_id,f_name,f_type,f_contact)){
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }else{
            response.sendRedirect("updateFail.jsp");
        }
    }
}
