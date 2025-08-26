/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package SRP.Ejercicio2;

/**
 *
 * @author KEVIN
 */
public class Main {
    public static void main(String[] args) {
        // Paciente y Médico (heredan de Persona)
        Paciente paciente = new Paciente("P001", "Juan", "Perez", "juan.perez@email.com");
        Medico medico = new Medico("M001", "Ana", "García", "Cardiología");

        // Orden de laboratorio
        OrdenLaboratorio orden = new OrdenLaboratorio("O001", "Examen de Sangre", paciente, medico);
        System.out.println("Orden creada para " + orden.getPaciente().getNombreCompleto() +
                           " solicitada por " + orden.getMedico().getNombreCompleto());

        // Resultado implementa Validable
        ResultadoLaboratorio resultado = new ResultadoLaboratorio("R001", "Glucosa: 95 mg/dl");
        System.out.println("\n--- Resultado antes de validación ---");
        System.out.println(resultado.getReporte());

        resultado.validar();
        System.out.println("\n--- Resultado después de validación ---");
        System.out.println(resultado.getReporte());

        // Factura
        Factura factura = new Factura("F001", 120.50, paciente);
        System.out.println("\n--- Factura ---");
        System.out.println(factura.generarFactura());
    }
}

