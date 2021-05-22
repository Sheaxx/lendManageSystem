package servlet;



import dao.TimetableDao;
import dao.TimetableDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addTimetableServlet")
public class addTimetableServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);  //����Ϣʹ��doPost����ִ��   ��Ӧjspҳ���е�form���е�method
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int t_fid =Integer.parseInt(request.getParameter("t_fid")); //�õ�jspҳ�洫�����Ĳ���
        String t_content = request.getParameter("t_content");

        TimetableDao timetableDao = new TimetableDaoImpl();

        if (timetableDao.add(t_fid,t_content)){
            //request.setAttribute("hello", "��ӭ�û�" + name); //��request���з�����Ϣ
            request.getRequestDispatcher("/index.jsp").forward(request, response);//ת�����ɹ�ҳ��
        } else {
            response.sendRedirect("addFail.jsp"); //�ض�����ҳ
        }
    }
}
