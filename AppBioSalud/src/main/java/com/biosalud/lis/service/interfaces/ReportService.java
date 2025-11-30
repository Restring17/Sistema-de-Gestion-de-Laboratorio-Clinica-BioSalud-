/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biosalud.lis.service.interfaces;

import com.biosalud.lis.model.Reporte;
import java.time.LocalDate;
import java.util.List;


public interface ReportService {

    List<Reporte> generarReporte(String tipoExamen, LocalDate inicio, LocalDate fin);

    List<String> obtenerTiposExamen();   // ← AGREGADO
}


