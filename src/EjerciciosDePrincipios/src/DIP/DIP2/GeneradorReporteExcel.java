/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DIP2;

/**
 *
 * @author KEVIN
 */
public class GeneradorReporteExcel implements GeneradorReporte {
    @Override
    public void generar(String datos) {
        System.out.println("Reporte en Excel generado con datos: " + datos);
    }
}

