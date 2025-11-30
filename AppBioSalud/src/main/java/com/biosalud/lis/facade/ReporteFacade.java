/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biosalud.lis.facade;

import com.biosalud.lis.model.Reporte;
import com.biosalud.lis.patterns.command.GenerarReporteCommand;
import com.biosalud.lis.patterns.factory.ReporteFactory;
import com.biosalud.lis.util.ExcelGenerator;
import com.biosalud.lis.util.PdfGenerator;
import com.lowagie.text.DocumentException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JTable;


public class ReporteFacade {
    private final GenerarReporteCommand command = ReporteFactory.createGenerarReporteCommand();
    private final ExcelGenerator excel = new ExcelGenerator();
    private final PdfGenerator pdf = new PdfGenerator();

    // Genera los datos del reporte
    public List<Reporte> generarReporte(String tipoExamen, LocalDate inicio, LocalDate fin) {
        return command.ejecutar(tipoExamen, inicio, fin);
    }

    // Calcula total de examenes
    public int totalExamenes(String tipoExamen, LocalDate inicio, LocalDate fin) {
        return command.totalExamenes(tipoExamen, inicio, fin);
    }

    // Calcula tiempo promedio
    public double tiempoPromedio(String tipoExamen, LocalDate inicio, LocalDate fin) {
        return command.tiempoPromedio(tipoExamen, inicio, fin);
    }

    // Exportar Excel, propaga IOException
    public void exportarExcel(JTable tabla1, JTable tabla2) throws IOException {
        excel.exportarExcelDosTablas(tabla1, tabla2);
    }

    // Exportar PDF, propaga IOException y DocumentException
    public void exportarPDF(JTable tabla1, JTable tabla2) throws IOException, DocumentException {
        pdf.exportarPDFDosTablas(tabla1, tabla2);
    }

    public List<String> obtenerTiposExamen() {
        return command.obtenerTiposExamen();
    }
}


