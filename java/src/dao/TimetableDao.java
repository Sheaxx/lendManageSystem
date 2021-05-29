package dao;


import entity.Timetable;

import java.util.List;

public interface TimetableDao {
    /**
     * 返回所有时间表
     * @return
     */
    List<Timetable> getTimetableAll();

    /**
     * 选择某一时间表
     * @param t_id
     * @return
     */
    List<Timetable> select(int t_id);

    /**
     * 删除时间表
     * @param t_id
     * @return
     */
    boolean delete(int t_id);

    /**
     * 更新时间表信息
     * @param t_id
     * @param t_fid
     * @param t_content
     * @return
     */
    boolean update(int t_id,int t_fid,String t_content);

    /**
     * 添加时间表信息
     * @param t_fid
     * @param t_content
     * @return
     */
    boolean add(int t_fid,String t_content);
}
