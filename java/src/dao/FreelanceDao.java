package dao;


import entity.Freelance;

import java.util.List;

public interface FreelanceDao {
    /**
     * 返回所有自由职业者
     * @return
     */
    List<Freelance> getFreelanceAll();

    /**
     * 选择某一自由职业者
     * @param f_id
     * @return
     */
    List<Freelance> select(int f_id);

    /**
     * 删除自由职业者
     * @param f_id
     * @return
     */
    boolean delete(int f_id);

    /**
     * 更新自由职业者信息
     * @param f_id
     * @param f_name
     * @param f_type
     * @param f_contact
     * @return
     */
    boolean update(int f_id,String f_name,String f_type,String f_contact);

    /**
     * 添加自由职业者信息
     * @param f_name
     * @param f_type
     * @param f_contact
     * @return
     */
    boolean add(String f_name,String f_type,String f_contact);
}
