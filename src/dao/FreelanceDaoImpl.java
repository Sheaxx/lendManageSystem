package dao;

import entity.Client;
import entity.Freelance;
import util.DBconnect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FreelanceDaoImpl implements FreelanceDao{
    @Override
    public List<Freelance> getFreelanceAll() {
        List<Freelance> list = new ArrayList<>();
        try {
            try {
                DBconnect.init();
            }catch (Exception e){
                e.printStackTrace();
            }
            ResultSet rs = DBconnect.selectSql("select * from freelance");
            if (rs == null){
                return null;
            }
            while(rs.next()){
                int f_id1 = Integer.parseInt(rs.getString("f_id"));
                String f_name1 = rs.getString("f_name");
                String f_type1 = rs.getString("f_type");
                String f_contact1 = rs.getString("f_contact");

                Freelance freelance = new Freelance(f_id1,f_name1,f_type1,f_contact1);
                list.add(freelance);
            }
            DBconnect.closeConn();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Freelance> select(int f_id) {
        List<Freelance> list = new ArrayList<>();
        try {
            try {
                DBconnect.init();
            }catch (Exception e){
                e.printStackTrace();
            }
            ResultSet rs = DBconnect.selectSql("select * from freelance where f_id = '" + f_id + "'");
            if (rs == null){
                return null;
            }
            while(rs.next()){
                int f_id1 = Integer.parseInt(rs.getString("f_id"));
                String f_name1 = rs.getString("f_name");
                String f_type1 = rs.getString("f_type");
                String f_contact1 = rs.getString("f_contact");

                Freelance freelance = new Freelance(f_id1,f_name1,f_type1,f_contact1);
                list.add(freelance);
            }
            DBconnect.closeConn();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean delete(int f_id) {
        boolean flag = false;

        try {
            DBconnect.init();
        }catch (Exception e){
            e.printStackTrace();
        }
        String sql = "delete from freelance where f_id='" + f_id + "'";
        int i = DBconnect.addUpdateDelete(sql);//iµÄÒâÒå£º
        if (i > 0) {
            flag = true;
        }
        DBconnect.closeConn();
        return flag;
    }

    @Override
    public boolean update(int f_id, String f_name, String f_type, String f_contact) {
        boolean flag = false;
        try {
            DBconnect.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql = "update freelance set f_name ='" + f_name

                + "',f_type = '" + f_type + "',f_contact = '" + f_contact + "' where f_id = '"+f_id+"'";

        int i = DBconnect.addUpdateDelete(sql);
        System.out.println("1" + " " + i);
        if (i > 0) {
            flag = true;
        }
        DBconnect.closeConn();
        return flag;
    }

    @Override
    public boolean add(String f_name, String f_type, String f_contact) {
        boolean flag = false;
        try{
            DBconnect.init();
        }catch (Exception e){
            e.printStackTrace();
        }
        int i = DBconnect.addUpdateDelete("insert into freelance(f_name,f_type,f_contact) " +
                "values('" + f_name + "','" + f_type + "','"+f_contact+" ' )");

        System.out.println("1"+" "+i);
        if (i > 0) {
            flag = true;
        }
        DBconnect.closeConn();
        return flag;
    }
}
