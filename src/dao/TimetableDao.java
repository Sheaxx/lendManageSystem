package dao;


import entity.Timetable;

import java.util.List;

public interface TimetableDao {
    /**
     * ��������ʱ���
     * @return
     */
    List<Timetable> getTimetableAll();

    /**
     * ѡ��ĳһʱ���
     * @param t_id
     * @return
     */
    List<Timetable> select(int t_id);

    /**
     * ɾ��ʱ���
     * @param t_id
     * @return
     */
    boolean delete(int t_id);

    /**
     * ����ʱ�����Ϣ
     * @param t_id
     * @param t_fid
     * @param t_content
     * @return
     */
    boolean update(int t_id,int t_fid,String t_content);

    /**
     * ���ʱ�����Ϣ
     * @param t_fid
     * @param t_content
     * @return
     */
    boolean add(int t_fid,String t_content);
}
