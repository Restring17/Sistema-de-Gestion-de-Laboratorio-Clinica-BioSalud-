/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DIP2;

/**
 *
 * @author KEVIN
 */
public class Main {
    public static void main(String[] args) {
        SistemaReportes sistemaPDF = new SistemaReportes(new GeneradorReportePDF());
        sistemaPDF.exportarReporte("Resultados de laboratorio de Septiembre");

        SistemaReportes sistemaExcel = new SistemaReportes(new GeneradorReporteExcel());
        sistemaExcel.exportarReporte("Resultados de laboratorio de Septiembre");
    }
}

