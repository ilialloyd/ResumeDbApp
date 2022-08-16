package com.company.dao.impl;

import com.company.bean.User;
import com.company.dao.inter.AbstactDAO;
import com.company.dao.inter.UserDaoInter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ilialloyd
 * Date: 8/15/2022
 * Leave your comment below if you have
 * --------------------------------------------------------
 */
public class UserDaoImpl extends AbstactDAO implements UserDaoInter {
    @Override
    public List<User> getAll() {
        List<User> result = new ArrayList<>();

        //try with resources da connectionu yazdiqimizda onu daha close elemeye
        //ehtiyac qalmir
        try (Connection c = connect()) {


            Statement stmt = c.createStatement();
            stmt.execute("Select * from user");

            //ResultSeti adla caqirmaq daha yaxsidir.
            // cunki sabah setirlerin sirasi deyisse de seni castirmir
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String phone = rs.getString("phone");
                String email = rs.getString("email");

                //collecting data
                result.add(new User(id, name, surname, phone, email));
            }

            rs.close();
            stmt.close();
            c.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateUser(User u) {

        try (Connection c = connect()) {//try with resources
            Statement stmt = c.createStatement();
            return stmt.execute("update user set name='Javid' where id=3");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean addUser(User u) {
        try (Connection c = connect()) {//try with resources
            PreparedStatement prepared = c.prepareStatement("insert into user (name, surname, phone,email) values(?,?,?,?)");
         prepared.setString(1,u.getName());
         prepared.setString(2,u.getSurname());
         prepared.setString(3,u.getPhone());
         prepared.setString(4,u.getEmail());
         return prepared.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeUser(int id) {
        try (Connection c = connect()) {

            Statement stmt = c.createStatement();
            return stmt.execute("delete from user  where id=1");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



    @Override
    public User getById(int userId) {
        User result = null;

        //try with resources da connectionu yazdiqimizda onu daha close elemeye
        //ehtiyac qalmir
        try (Connection c = connect()) {


            Statement stmt = c.createStatement();
            stmt.execute("Select * from user where id="+userId);

            //ResultSeti adla caqirmaq daha yaxsidir.
            // cunki sabah setirlerin sirasi deyisse de seni castirmir
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String phone = rs.getString("phone");
                String email = rs.getString("email");

                //collecting data
                result=new User(id, name, surname, phone, email);
            }

            rs.close();
            stmt.close();
            c.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
