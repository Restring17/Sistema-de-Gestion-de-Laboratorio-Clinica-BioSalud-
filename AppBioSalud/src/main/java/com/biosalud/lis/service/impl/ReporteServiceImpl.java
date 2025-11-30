/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biosalud.lis.service.impl;

import com.biosalud.lis.dao.impl.ReporteDAOImpl;
import com.biosalud.lis.model.Reporte;
import com.biosalud.lis.service.interfaces.ReportService;
import java.time.LocalDate;
import java.util.List;


public class ReporteServiceImpl implements ReportService {

    private final ReporteDAOImpl dao = new ReporteDAOImpl();

    @Override
    public List<Reporte> generarReporte(String tipoExamen, LocalDate inicio, LocalDate fin) {
        return dao.obtenerReporte(tipoExamen, inicio, fin);
    }

    @Override
    public List<String> obtenerTiposExamen() {
        return dao.obtenerTiposExamen(); // ← AGREGADO
    }
    
}
