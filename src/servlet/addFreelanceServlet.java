package servlet;



import dao.FreelanceDao;
import dao.FreelanceDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addFreelanceServlet")
public class addFreelanceServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);  //����Ϣʹ��doPost����ִ��   ��Ӧjspҳ���е�form���е�method
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String f_name = request.getParameter("f_name"); //�õ�jspҳ�洫�����Ĳ���
        String f_type = request.getParameter("f_type");
        String f_contact = request.getParameter("f_contact");


        FreelanceDao freelanceDao = new FreelanceDaoImpl();

        if (freelanceDao.add(f_name,f_type,f_contact)) {
            //request.setAttribute("hello", "��ӭ�û�" + name); //��request���з�����Ϣ
            request.getRequestDispatcher("/index.jsp").forward(request, response);//ת�����ɹ�ҳ��
        } else {
            response.sendRedirect("showAllFreelance.jsp"); //�ض�����ҳ
        }
    }
}
