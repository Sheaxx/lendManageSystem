package dao;

import entity.Client;

import java.util.List;

public interface ClientDao {

    /**
     * �������пͻ�
     * @return
     */
    List<Client> getClientAll();

    /**
     * ѡ��ĳһ�ͻ�
     * @param c_id
     * @return
     */
    List<Client> select(int c_id);

    /**
     * ɾ���ͻ�
     * @param c_id
     * @return
     */
    boolean delete(int c_id);

    /**
     * ���¿ͻ���Ϣ
     * @param c_id
     * @param c_name
     * @param c_type
     * @param c_contact
     * @return
     */
    boolean update(int c_id,String c_name,String c_type,String c_contact);

    /**
     * ��ӿͻ���Ϣ
     * @param c_name
     * @param c_type
     * @param c_contact
     * @return
     */
    boolean add(String c_name,String c_type,String c_contact);

}
