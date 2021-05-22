package dao;

import entity.Project;

import java.util.List;

public interface ProjectDao {
    /**
     * 返回所有项目
     * @return
     */
    List<Project> getProjectAll();

    /**
     * 选择某一项目
     * @param p_id
     * @return
     */
    List<Project> select(int p_id);

    /**
     * 删除项目
     * @param p_id
     * @return
     */
    boolean delete(int p_id);

    /**
     * 更新项目信息
     * @param p_id
     * @param p_name
     * @param p_type
     * @param p_content
     * @return
     */
    boolean update(int p_id,String p_name,String p_type,String p_content);

    /**
     * 添加项目信息
     * @param p_name
     * @param p_type
     * @param p_content
     * @return
     */
    boolean add(String p_name,String p_type,String p_content);
}
