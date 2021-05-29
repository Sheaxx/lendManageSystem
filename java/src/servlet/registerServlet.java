package servlet;

import dao.UserDao;
import dao.UserDaoImpl;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "registerServlet")
public class registerServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("user_name"); //��ȡjspҳ�洫�����Ĳ���
        String userpassword = request.getParameter("user_password");

        User user = new User(); //ʵ����һ��������װ����
        user.setUsername(username);
        user.setPassword(userpassword);

        UserDao ud = new UserDaoImpl();

        if(ud.register(user)){
//            request.setAttribute("user_name", user_name);  //��request���з��ò���
//            request.getRequestDispatcher("/login.jsp").forward(request, response);  //ת������¼ҳ��
            response.sendRedirect("jsp/login.jsp");
        }else{
            response.sendRedirect("jsp/register.jsp");//ע��ʧ���򷵻�ע��ҳ�棬����ȱ����ʾ"ע��ʧ��"
        }
    }
}
