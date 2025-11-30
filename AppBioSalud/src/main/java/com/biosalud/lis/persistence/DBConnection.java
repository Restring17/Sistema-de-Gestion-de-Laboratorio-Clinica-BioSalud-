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
        String url = "jdbc:mysql://localhost:3306/appbiosalud?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
        String user = "root";
        String pass = ""; // XAMPP por defecto no tiene contraseña. Si tienes una, cámbiala aquí
        
        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conn = DriverManager.getConnection(url, user, pass);
            System.out.println("✅ Conexión exitosa a la base de datos appbiosalud");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Error: Driver MySQL no encontrado. Asegúrate de tener mysql-connector-java en tu pom.xml", e);
        } catch (SQLException e) {
            System.err.println("❌ Error al conectar a la base de datos:");
            System.err.println("   URL: " + url);
            System.err.println("   Usuario: " + user);
            System.err.println("   Verifica que MySQL esté corriendo en XAMPP y que la base de datos 'appbiosalud' exista.");
            throw e;
        }
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
