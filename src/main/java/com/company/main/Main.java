package com.company.main;

import com.company.bean.User;
import com.company.dao.impl.UserDaoImpl;
import com.company.dao.inter.UserDaoInter;

import java.sql.SQLException;
import java.util.List;


/**
 * Created by IntelliJ IDEA.
 * User: ilialloyd
 * Date: 8/15/2022
 * Leave your comment below if you have
 * --------------------------------------------------------
 * DAO -Data Access Object
 */
public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDaoInter userDao = new UserDaoImpl();
        //we throw the results to List from getAll method
        List<User> list = userDao.getAll();// showing all users from MySQL
        userDao.removeUser(1);// removing particular row
        System.out.println("list="+list);
        List<User>list2 = userDao.getAll();//showing new list after remove the row

        User u = userDao.getById(3);// getting all data from given data
        System.out.println(u);


    }
}
