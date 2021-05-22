package dao;

import entity.User;

public interface UserDao {

    /**
     * µÇÂ¼
     * @param username
     * @param password
     * @return
     */
    public boolean login(String username,String password);

    /**
     * ×¢²á
     * @param user
     * @return
     */
    public boolean register(User user);

    /**
     * ÐÞ¸ÄÐÅÏ¢
     * @param username
     * @param password
     * @return
     */
    boolean update(String username,String password);
}
