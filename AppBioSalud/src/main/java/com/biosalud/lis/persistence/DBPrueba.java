/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biosalud.lis.persistence;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBPrueba {

    public static void main(String[] args) {
        try {
            Connection conn = DBConnection.getInstance().getConnection();

            if (conn != null && !conn.isClosed()) {
                System.out.println("✔ Conexión exitosa a la base de datos!");

                // Obtener metadatos
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("Servidor: " + meta.getDatabaseProductName());
                System.out.println("Versión: " + meta.getDatabaseProductVersion());
                System.out.println("Usuario conectado: " + meta.getUserName());
                System.out.println("----------------------------------------");

                // Listar tablas
                String databaseName = "appbiosalud";
                System.out.println("\n--- Tablas en la Base de Datos " + databaseName + " ---");
                ResultSet tables = meta.getTables(databaseName, null, "%", new String[]{"TABLE"});

                int count = 0;
                while (tables.next()) {
                    String tableName = tables.getString("TABLE_NAME");
                    System.out.println("  " + (++count) + ". " + tableName);
                }
                tables.close();

                if (count == 0) {
                    System.out.println("  ⚠️ No se encontraron tablas. Ejecuta el script database_script.sql");
                } else {
                    System.out.println("\n✅ Total de tablas encontradas: " + count);
                }
            }

        } catch (SQLException e) {
            System.out.println("✖ Error al conectar a la base de datos:");
            e.printStackTrace();
        }
    }
}
