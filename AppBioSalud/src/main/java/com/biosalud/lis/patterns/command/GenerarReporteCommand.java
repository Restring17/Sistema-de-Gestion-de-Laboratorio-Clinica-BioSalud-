/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biosalud.lis.patterns.command;

import com.biosalud.lis.model.Reporte;
import com.biosalud.lis.service.impl.ReporteServiceImpl;
import com.biosalud.lis.service.interfaces.ReportService;
import java.time.LocalDate;
import java.util.List;


public class GenerarReporteCommand {
    private final ReportService service = new ReporteServiceImpl();

    public List<Reporte> ejecutar(String tipoExamen, LocalDate inicio, LocalDate fin) {
        return service.generarReporte(tipoExamen, inicio, fin);
    }

    public int totalExamenes(String tipoExamen, LocalDate inicio, LocalDate fin) {
        return service.generarReporte(tipoExamen, inicio, fin).size();
    }

    public List<String> obtenerTiposExamen() {
        return service.obtenerTiposExamen();
    }

    public double tiempoPromedio(String tipoExamen, LocalDate inicio, LocalDate fin) {
        List<Reporte> lista = service.generarReporte(tipoExamen, inicio, fin);
        return lista.stream()
                .mapToInt(Reporte::getTiempoEntrega)
                .filter(t -> t >= 0)
                .average()
                .orElse(0);
    }
}

    

