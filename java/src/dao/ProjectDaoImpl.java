package dao;


import entity.Client;
import entity.Project;
import util.DBconnect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectDaoImpl implements ProjectDao{
    @Override
    public List<Project> getProjectAll() {
        List<Project> list = new ArrayList<>();
        try {
            try {
                DBconnect.init();
            }catch (Exception e){
                e.printStackTrace();
            }
            ResultSet rs = DBconnect.selectSql("select * from project");
            if (rs == null){
                return null;
            }
            while(rs.next()){
                int p_id1 = Integer.parseInt(rs.getString("p_id"));
                String p_name1 = rs.getString("p_name");
                String p_type1 = rs.getString("p_type");
                String p_content1 = rs.getString("p_content");

                Project project = new Project(p_id1,p_name1,p_type1,p_content1);
                list.add(project);
            }
            DBconnect.closeConn();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Project> select(int p_id) {
        List<Project> list = new ArrayList<>();

        try {
            try {
                DBconnect.init();
            }catch (Exception e){
                e.printStackTrace();
            }
            ResultSet rs = DBconnect.selectSql("select * from project where p_id = '" + p_id + "'");
            while(rs.next()){
                int p_id1 = Integer.parseInt(rs.getString("p_id"));
                String p_name1 = rs.getString("p_name");
                String p_type1 = rs.getString("p_type");
                String p_content1 = rs.getString("p_content");

                Project project = new Project(p_id1,p_name1,p_type1,p_content1);
                list.add(project);
            }
            DBconnect.closeConn();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean delete(int p_id) {
        boolean flag = false;

        try {
            DBconnect.init();
        }catch (Exception e){
            e.printStackTrace();
        }
        String sql = "delete from project where p_id='" + p_id + "'";
        int i = DBconnect.addUpdateDelete(sql);//iµÄÒâÒå£º
        if (i > 0) {
            flag = true;
        }
        DBconnect.closeConn();
        return flag;
    }

    @Override
    public boolean update(int p_id, String p_name, String p_type, String p_content) {
        boolean flag = false;
        try {
            DBconnect.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql = "update project set p_name ='" + p_name

                + "',p_type = '" + p_type + "',p_content = '" + p_content + "' where p_id = '"+p_id+"'";

        int i = DBconnect.addUpdateDelete(sql);
        System.out.println("1" + " " + i);
        if (i > 0) {
            flag = true;
        }
        DBconnect.closeConn();
        return flag;
    }

    @Override
    public boolean add( String p_name, String p_type, String p_content) {
        boolean flag = false;
        try{
            DBconnect.init();
        }catch (Exception e){
            e.printStackTrace();
        }
        int i = DBconnect.addUpdateDelete("insert into project(p_name,p_type,p_content) " +
                "values('" + p_name + "','" + p_type + "','"+p_content+" ' )");

        System.out.println("1"+" "+i);
        if (i > 0) {
            flag = true;
        }
        DBconnect.closeConn();
        return flag;
    }
}
