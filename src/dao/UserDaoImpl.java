package dao;


import entity.User;
import util.DBconnect;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean login(String username, String password) {
        boolean flag = false;

        try {
            try {
                DBconnect.init();
            }catch (Exception e){
                e.printStackTrace();
            }
            ResultSet rs = DBconnect.selectSql("select * from user where userName='" + username + " 'and password='" + password + "';");
            while(rs.next()){
                if (rs.getString("username").equals(username)&&rs.getString("password").equals(password)){
                    flag = true;
                }
            }
            DBconnect.closeConn();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean register(User user) {
        boolean flag = false;

        try {
            DBconnect.init();
        }catch (Exception e){
            e.printStackTrace();
        }
        int i = DBconnect.addUpdateDelete("insert into user(username,password)"+
                "values('"+user.getUsername()+"','"+user.getPassword()+"')");

        if (i > 0){
            flag = true;
        }
        DBconnect.closeConn();
        return flag;
    }

    @Override
    public boolean update(String username, String password) {
        boolean flag = false;
        try {
            DBconnect.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql = "update user set username ='" + username

                +"',password = '" + password + "'";

        int i = DBconnect.addUpdateDelete(sql);
        System.out.println("1" + " " + i);
        if (i > 0) {
            flag = true;
        }
        DBconnect.closeConn();
        return flag;
    }
}
