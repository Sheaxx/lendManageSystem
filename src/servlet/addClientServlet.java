package servlet;

import dao.ClientDao;
import dao.ClientDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class addClientServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);  //����Ϣʹ��doPost����ִ��   ��Ӧjspҳ���е�form���е�method
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String c_name = request.getParameter("c_name"); //�õ�jspҳ�洫�����Ĳ���
        System.out.println(c_name);

        String c_type = request.getParameter("c_type");
        String c_contact = request.getParameter("c_contact");
        System.out.println(c_type);

        ClientDao clientDao = new ClientDaoImpl();

        if (clientDao.add(c_name,c_type,c_contact)) {
            //request.setAttribute("hello", "��ӭ�û�" + name); //��request���з�����Ϣ
            request.getRequestDispatcher("/index.jsp").forward(request, response);//ת�����ɹ�ҳ��
        } else {
            response.sendRedirect("addFail.jsp"); //�ض�����ҳ
        }
    }
}
