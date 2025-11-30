/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biosalud.lis.util;

import com.biosalud.lis.persistence.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Clase para probar la conexión a la base de datos
 * @author folli
 */
public class TestConexion {
    
    public static void main(String[] args) {
        System.out.println("===========================================");
        System.out.println("  PRUEBA DE CONEXIÓN A BASE DE DATOS");
        System.out.println("===========================================\n");
        
        try {
            // Intentar obtener conexión
            Connection conn = DBConnection.getInstance().getConnection();
            
            if (conn != null && !conn.isClosed()) {
                System.out.println("✅ Conexión establecida correctamente");
                System.out.println("   Base de datos: " + conn.getCatalog());
                System.out.println("   URL: " + conn.getMetaData().getURL());
                
                // Probar una consulta simple
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT COUNT(*) as total FROM paciente");
                
                if (rs.next()) {
                    int total = rs.getInt("total");
                    System.out.println("\n📊 Consulta de prueba exitosa:");
                    System.out.println("   Total de pacientes en BD: " + total);
                }
                
                rs.close();
                stmt.close();
                
                System.out.println("\n✅ ¡TODO FUNCIONA CORRECTAMENTE!");
                System.out.println("   El proyecto está listo para gestionar pacientes.");
                
            } else {
                System.err.println("❌ La conexión está cerrada o es nula");
            }
            
        } catch (Exception e) {
            System.err.println("\n❌ ERROR AL CONECTAR CON LA BASE DE DATOS:");
            System.err.println("   " + e.getMessage());
            System.err.println("\n📋 SOLUCIONES:");
            System.err.println("   1. Verifica que XAMPP esté corriendo (Apache y MySQL)");
            System.err.println("   2. Asegúrate de que la base de datos 'appbiosalud' exista");
            System.err.println("   3. Verifica que hayas ejecutado el script SQL completo");
            System.err.println("   4. Revisa la contraseña en DBConnection.java (por defecto '' en XAMPP)");
            System.err.println("   5. Verifica que el puerto MySQL sea 3306");
            e.printStackTrace();
        }
        
        System.out.println("\n===========================================");
    }
}
