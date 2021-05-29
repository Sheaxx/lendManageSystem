package dao;


import entity.Freelance;

import java.util.List;

public interface FreelanceDao {
    /**
     * ������������ְҵ��
     * @return
     */
    List<Freelance> getFreelanceAll();

    /**
     * ѡ��ĳһ����ְҵ��
     * @param f_id
     * @return
     */
    List<Freelance> select(int f_id);

    /**
     * ɾ������ְҵ��
     * @param f_id
     * @return
     */
    boolean delete(int f_id);

    /**
     * ��������ְҵ����Ϣ
     * @param f_id
     * @param f_name
     * @param f_type
     * @param f_contact
     * @return
     */
    boolean update(int f_id,String f_name,String f_type,String f_contact);

    /**
     * �������ְҵ����Ϣ
     * @param f_name
     * @param f_type
     * @param f_contact
     * @return
     */
    boolean add(String f_name,String f_type,String f_contact);
}
