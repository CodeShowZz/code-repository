package com.concurrency;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author junlin_huang
 * @create 2020-09-03 下午9:44
 **/

public class UseThreadLocalToEnsureThreadConfiment {

    private static String DB_URL = "jdbc:mysql://localhost/mydatabase";

    private ThreadLocal<Connection> connectionHolder = new ThreadLocal() {
        public Connection initialValue() {
            try {
                return DriverManager.getConnection(DB_URL);
            } catch (SQLException e) {
                throw new RuntimeException("Unable to acquire Connection, e");
            }
        }
    };

    public Connection getConnection() {
        return connectionHolder.get();
    }
}