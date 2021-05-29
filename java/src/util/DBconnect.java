package util;

import java.sql.*;

public class DBconnect {
    static String url="jdbc:mysql://localhost:3306/rental_system?useSSL=false";
    static String user = "root";
    static String pw = "password";
    static Connection conn = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;
    static Statement st = null;

    public static void init()  {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,pw);
        }catch (Exception e){
            System.out.println("��ʼ��ʧ��");
            e.printStackTrace();
        }
    }

    public static int addUpdateDelete(String sql){
        int i=0;
        try{
            ps = conn.prepareStatement(sql);
            boolean flag = ps.execute();

            if (flag == false){
                i++;
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return i;
    }

    public static ResultSet selectSql(String sql){
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
        }catch (Exception e){
            System.out.println("���ݿ��ѯ�쳣");
            e.printStackTrace();
        }
        return rs;
    }

    public static void closeConn(){
        try {
            conn.close();
        }catch (Exception e){
            System.out.println("���ݿ�ر��쳣");
            e.printStackTrace();
        }
    }
}
