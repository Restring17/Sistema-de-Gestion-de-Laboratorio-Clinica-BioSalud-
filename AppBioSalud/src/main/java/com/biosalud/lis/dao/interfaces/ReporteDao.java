/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.biosalud.lis.dao.interfaces;

import com.biosalud.lis.model.Reporte;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author LETICIA
 */
public interface ReporteDao {
    List<Reporte> obtenerReporte(String tipoExamen, LocalDate inicio, LocalDate fin);

    List<String> obtenerTiposExamen();

    int totalExamenes(String tipoExamen, LocalDate inicio, LocalDate fin);

    double tiempoPromedio(String tipoExamen, LocalDate inicio, LocalDate fin);
}

