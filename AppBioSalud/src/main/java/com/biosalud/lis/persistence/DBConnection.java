/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biosalud.lis.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection instance;
    private Connection conn;

    private DBConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/appbiosalud?serverTimezone=UTC";
        String user = "root";
        String pass = "admin123"; 
        this.conn = DriverManager.getConnection(url, user, pass);
    }

    public static synchronized DBConnection getInstance() throws SQLException {
        if (instance == null || instance.conn.isClosed()) {
            instance = new DBConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return conn;
    }
}
