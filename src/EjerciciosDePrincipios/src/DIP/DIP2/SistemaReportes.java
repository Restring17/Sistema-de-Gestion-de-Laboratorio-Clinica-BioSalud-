/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DIP2;

/**
 *
 * @author KEVIN
 */
public class SistemaReportes {
    private GeneradorReporte generador;

    // Depende de la abstracción
    public SistemaReportes(GeneradorReporte generador) {
        this.generador = generador;
    }

    public void exportarReporte(String datos) {
        generador.generar(datos);
    }
}

