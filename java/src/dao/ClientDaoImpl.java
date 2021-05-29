package dao;

import entity.Client;
import util.DBconnect;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoImpl implements ClientDao{
    @Override
    public List<Client> getClientAll() {
        List<Client> list = new ArrayList<>();
        try {
            try {
                DBconnect.init();
            }catch (Exception e){
                e.printStackTrace();
            }
            ResultSet rs = DBconnect.selectSql("select * from client");
            if (rs == null){
                return null;
            }

            while(rs.next()){
                int c_id1 = Integer.parseInt(rs.getString("c_id"));
                String c_name1 = rs.getString("c_name");
                String c_type1 = rs.getString("c_type");
                String c_contact1 = rs.getString("c_contact");

                Client client = new Client(c_id1,c_name1,c_type1,c_contact1);
//                System.out.println(client.toString());
                list.add(client);
            }

            DBconnect.closeConn();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Client> select(int c_id) {

        List<Client> list = new ArrayList<>();

        try {
            try {
                DBconnect.init();
            }catch (Exception e){
                e.printStackTrace();
            }
            ResultSet rs = DBconnect.selectSql("select * from client where c_id = '" + c_id + "'");
            while(rs.next()){
                int c_id1 = Integer.parseInt(rs.getString("c_id"));
                String c_name1 = rs.getString("c_name");
                String c_type1 = rs.getString("c_type");
                String c_contact1 = rs.getString("c_contact");

                Client client = new Client(c_id1,c_name1,c_type1,c_contact1);
                list.add(client);
            }
            DBconnect.closeConn();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean delete(int c_id) {
        boolean flag = false;

        try {
            DBconnect.init();
        }catch (Exception e){
            e.printStackTrace();
        }
        String sql = "delete from client where c_id='" + c_id + "'";
        int i = DBconnect.addUpdateDelete(sql);//iµÄÒâÒå£º
        if (i > 0) {
            flag = true;
        }
        DBconnect.closeConn();
        return flag;
    }

    @Override
    public boolean update(int c_id, String c_name, String c_type, String c_contact) {
        boolean flag = false;
        try {
            DBconnect.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql = "update client set c_name ='" + c_name

                + "',c_type = '" + c_type + "',c_contact = '" + c_contact + "' where c_id = '"+c_id+"'";

        int i = DBconnect.addUpdateDelete(sql);
        System.out.println("1" + " " + i);
        if (i > 0) {
            flag = true;
        }
        DBconnect.closeConn();
        return flag;
    }

    @Override
    public boolean add(String c_name, String c_type, String c_contact) {
        boolean flag = false;
        System.out.println(c_name);
        try{
            DBconnect.init();
        }catch (Exception e){
            e.printStackTrace();
        }
        int i = DBconnect.addUpdateDelete("insert into client(c_name,c_type,c_contact) " +
                "values('" + c_name + "','" + c_type + "','"+c_contact+" ' )");

        System.out.println("1"+" "+i);
        if (i > 0) {
            flag = true;
        }
        DBconnect.closeConn();
        return flag;
    }
}
