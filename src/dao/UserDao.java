package dao;

import entity.User;

public interface UserDao {

    /**
     * ��¼
     * @param username
     * @param password
     * @return
     */
    public boolean login(String username,String password);

    /**
     * ע��
     * @param user
     * @return
     */
    public boolean register(User user);

    /**
     * �޸���Ϣ
     * @param username
     * @param password
     * @return
     */
    boolean update(String username,String password);
}
