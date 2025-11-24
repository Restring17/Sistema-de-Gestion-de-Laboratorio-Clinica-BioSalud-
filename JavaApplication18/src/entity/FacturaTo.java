/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;
import java.util.Date;

/**
 * Transfer Object (TO) para Factura.
 *
 * PATRONES Y PRINCIPIOS:
 *  - DTO / TRANSFER OBJECT: Transporta datos entre el DAO y la capa de presentación.
 *  - SRP: Solo representa la información de la factura.
 *  - OCP: Se puede extender sin modificar otras capas.
 *  - COMPOSITE: La factura contiene múltiples DetalleFactura (relación 1 → N).
 *  - PROTOTYPE: Puede clonarse para versiones temporales o anulaciones.
 */
public class FacturaTo {

    // Atributos
    private int idFactura;
    private int idPaciente; 
    private Date fechaEmision;
    private double total;
    private String medioPago;       // Efectivo / Tarjeta / Transferencia
    private String estado;          // Emitida / Pagada / Anulada

    // Constructor vacío
    public FacturaTo() {
    }

    // Constructor completo
    public FacturaTo(int idFactura, int idPaciente, Date fechaEmision,
                     double total, String medioPago, String estado) {
        this.idFactura = idFactura;
        this.idPaciente = idPaciente;
        this.fechaEmision = fechaEmision;
        this.total = total;
        this.medioPago = medioPago;
        this.estado = estado;
    }

    // Getters y Setters

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

