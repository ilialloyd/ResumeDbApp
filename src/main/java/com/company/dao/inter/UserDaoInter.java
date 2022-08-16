package com.company.dao.inter;

import com.company.bean.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ilialloyd
 * Date: 8/15/2022
 * Leave your comment below if you have
 * --------------------------------------------------------
 */
public interface UserDaoInter {
    public List<User> getAll() throws SQLException;
    public User getById(int id);

    public boolean updateUser(User u);

    public boolean removeUser(int id);


}
