package dao;

import entity.Client;

import java.util.List;

public interface ClientDao {

    /**
     * 返回所有客户
     * @return
     */
    List<Client> getClientAll();

    /**
     * 选择某一客户
     * @param c_id
     * @return
     */
    List<Client> select(int c_id);

    /**
     * 删除客户
     * @param c_id
     * @return
     */
    boolean delete(int c_id);

    /**
     * 更新客户信息
     * @param c_id
     * @param c_name
     * @param c_type
     * @param c_contact
     * @return
     */
    boolean update(int c_id,String c_name,String c_type,String c_contact);

    /**
     * 添加客户信息
     * @param c_name
     * @param c_type
     * @param c_contact
     * @return
     */
    boolean add(String c_name,String c_type,String c_contact);

}
