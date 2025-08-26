/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SRP.Ejercicio2;

/**
 *
 * @author KEVIN
 */
public class Factura {
    private String idFactura;
    private double monto;
    private Paciente paciente;

    public Factura(String idFactura, double monto, Paciente paciente) {
        this.idFactura = idFactura;
        this.monto = monto;
        this.paciente = paciente;
    }

    public String generarFactura() {
        return "Factura ID: " + idFactura +
               "\nPaciente: " + paciente.getNombreCompleto() +
               "\nMonto: $" + monto;
    }
}

