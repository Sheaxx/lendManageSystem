package dao;

import entity.Client;
import entity.Freelance;
import entity.Timetable;
import util.DBconnect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TimetableDaoImpl implements TimetableDao{
    @Override
    public List<Timetable> getTimetableAll() {
        List<Timetable> list = new ArrayList<>();

        try {
            try {
                DBconnect.init();
            }catch (Exception e){
                e.printStackTrace();
            }
            ResultSet rs = DBconnect.selectSql("select * from timetable");
            while(rs.next()){
                int t_id1 = Integer.parseInt(rs.getString("t_id"));
                String t_fid1 = rs.getString("t_fid");
                String t_content1 = rs.getString("t_content");

                Timetable timetable = new Timetable(t_id1,t_fid1,t_content1);
                list.add(timetable);
            }
            DBconnect.closeConn();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Timetable> select(int t_id) {
        List<Timetable> list = new ArrayList<>();

        try {
            try {
                DBconnect.init();
            }catch (Exception e){
                e.printStackTrace();
            }
            ResultSet rs = DBconnect.selectSql("select * from timetable where t_id = '" + t_id + "'");
            while(rs.next()){
                int t_id1 = Integer.parseInt(rs.getString("t_id"));
                String t_fid1 = rs.getString("t_fid");
                String t_content1 = rs.getString("t_content");

                Timetable timetable = new Timetable(t_id1,t_fid1,t_content1);
                list.add(timetable);
            }
            DBconnect.closeConn();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean delete(int t_id) {
        boolean flag = false;

        try {
            DBconnect.init();
        }catch (Exception e){
            e.printStackTrace();
        }
        String sql = "delete from timetable where t_id='" + t_id + "'";
        int i = DBconnect.addUpdateDelete(sql);//iµÄÒâÒå£º
        if (i > 0) {
            flag = true;
        }
        DBconnect.closeConn();
        return flag;
    }

    @Override
    public boolean update(int t_id, int t_fid, String t_content) {
        boolean flag = false;
        try {
            DBconnect.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql = "update timetable set t_fid ='" + t_fid

                + "',t_content = '" + t_content + "' where t_id = '"+t_id+"'";

        int i = DBconnect.addUpdateDelete(sql);
        System.out.println("1" + " " + i);
        if (i > 0) {
            flag = true;
        }
        DBconnect.closeConn();
        return flag;
    }

    @Override
    public boolean add(int t_fid, String t_content) {
        boolean flag = false;
        try{
            DBconnect.init();
        }catch (Exception e){
            e.printStackTrace();
        }
        int i = DBconnect.addUpdateDelete("insert into timetable(t_fid,t_content) " +
                "values('" + t_fid + "','"+t_content+" ' )");

        System.out.println("1"+" "+i);
        if (i > 0) {
            flag = true;
        }
        DBconnect.closeConn();
        return flag;
    }
}
