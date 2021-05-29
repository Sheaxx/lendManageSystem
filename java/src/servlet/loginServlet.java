package servlet;

import dao.UserDao;
import dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "loginServlet")
public class loginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);  //����Ϣʹ��doPost����ִ��   ��Ӧjspҳ���е�form���е�method
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("user_name"); //�õ�jspҳ�洫�����Ĳ���
        String userpassword = request.getParameter("user_password");

        UserDao ud = new UserDaoImpl();

        if (ud.login(username, userpassword)) {
            //request.setAttribute("hello", "��ӭ�û�" + name); //��request���з�����Ϣ
            request.getRequestDispatcher("jsp/index.jsp").forward(request, response);//ת�����ɹ�ҳ��
        } else {
            response.sendRedirect("jsp/login.jsp"); //�ض�����ҳ
        }
    }
}
