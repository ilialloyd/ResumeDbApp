package com.company.dao.inter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: ilialloyd
 * Date: 8/15/2022
 * Leave your comment below if you have
 * --------------------------------------------------------
 */
public abstract class AbstactDAO {
    public Connection connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/resume";
        String username = "root";
        String password = "*Lenovo2022";
        Connection c = DriverManager.getConnection(url, username, password);
        return c;
    }
}
