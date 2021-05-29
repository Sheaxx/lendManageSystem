package dao;

import entity.Project;

import java.util.List;

public interface ProjectDao {
    /**
     * ����������Ŀ
     * @return
     */
    List<Project> getProjectAll();

    /**
     * ѡ��ĳһ��Ŀ
     * @param p_id
     * @return
     */
    List<Project> select(int p_id);

    /**
     * ɾ����Ŀ
     * @param p_id
     * @return
     */
    boolean delete(int p_id);

    /**
     * ������Ŀ��Ϣ
     * @param p_id
     * @param p_name
     * @param p_type
     * @param p_content
     * @return
     */
    boolean update(int p_id,String p_name,String p_type,String p_content);

    /**
     * �����Ŀ��Ϣ
     * @param p_name
     * @param p_type
     * @param p_content
     * @return
     */
    boolean add(String p_name,String p_type,String p_content);
}
