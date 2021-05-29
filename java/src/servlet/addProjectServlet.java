package servlet;



import dao.ProjectDao;
import dao.ProjectDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class addProjectServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);  //����Ϣʹ��doPost����ִ��   ��Ӧjspҳ���е�form���е�method
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String p_name = request.getParameter("p_name"); //�õ�jspҳ�洫�����Ĳ���
        String p_type = request.getParameter("p_type");
        String p_content = request.getParameter("p_content");

        ProjectDao projectDao = new ProjectDaoImpl();

        if (projectDao.add(p_name,p_type,p_content)) {
            //request.setAttribute("hello", "��ӭ�û�" + name); //��request���з�����Ϣ
            request.getRequestDispatcher("jsp/index.jsp").forward(request, response);//ת�����ɹ�ҳ��
        } else {
            response.sendRedirect("jsp/addFail.jsp"); //�ض�����ҳ
        }
    }
}
