/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biosalud.lis.dao.impl;

import com.biosalud.lis.dao.interfaces.ReporteDao;
import com.biosalud.lis.model.Reporte;
import com.biosalud.lis.persistence.DBConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LETICIA
 */
public class ReporteDAOImpl implements ReporteDao{
        @Override
    public List<Reporte> obtenerReporte(String tipoExamen, LocalDate inicio, LocalDate fin) {
        List<Reporte> lista = new ArrayList<>();
        String sql = "{CALL sp_reporte_examenes(?, ?, ?)}";
        try (Connection conn = DBConnection.getInstance().getConnection(); CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setString(1, tipoExamen);
            stmt.setDate(2, Date.valueOf(inicio));
            stmt.setDate(3, Date.valueOf(fin));

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Reporte r = new Reporte();
                r.setIdOrden(rs.getInt("id_orden"));
                r.setTipoExamen(rs.getString("tipo_examen"));
                r.setFechaOrden(rs.getDate("fecha_orden").toLocalDate());
                r.setTiempoEntrega(rs.getInt("tiempo_entrega"));
                lista.add(r);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public List<String> obtenerTiposExamen() {
        List<String> tipos = new ArrayList<>();
        String sql = "{CALL sp_tipos_examen()}";

        try (Connection conn = DBConnection.getInstance().getConnection(); CallableStatement stmt = conn.prepareCall(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                tipos.add(rs.getString("tipo_examen"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tipos;
    }

    @Override
    public int totalExamenes(String tipoExamen, LocalDate inicio, LocalDate fin) {
        String sql = "{CALL sp_reporte_examenes(?, ?, ?)}";
        int total = 0;

        try (Connection conn = DBConnection.getInstance().getConnection(); CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setString(1, tipoExamen);
            stmt.setDate(2, Date.valueOf(inicio));
            stmt.setDate(3, Date.valueOf(fin));

            // Ejecuta el SP
            stmt.execute();

            // CRÍTICO: Avanza al SEGUNDO RESULTADO (el resumen)
            if (stmt.getMoreResults()) {
                try (ResultSet rs = stmt.getResultSet()) {
                    if (rs.next()) {
                        total = rs.getInt("total_examenes");
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

    @Override
    public double tiempoPromedio(String tipoExamen, LocalDate inicio, LocalDate fin) {
        String sql = "{CALL sp_reporte_examenes(?, ?, ?)}";
        double promedio = 0.0;

        try (Connection conn = DBConnection.getInstance().getConnection(); CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setString(1, tipoExamen);
            stmt.setDate(2, Date.valueOf(inicio));
            stmt.setDate(3, Date.valueOf(fin));

            // Ejecuta el SP
            stmt.execute();

            // CRÍTICO: Avanza al SEGUNDO RESULTADO (el resumen)
            if (stmt.getMoreResults()) {
                try (ResultSet rs = stmt.getResultSet()) {
                    if (rs.next()) {
                        promedio = rs.getDouble("tiempo_promedio");
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return promedio;

    }
    
}
