/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 * Transfer Object (TO) para Detalle de Factura.
 *
 * PATRONES Y PRINCIPIOS:
 *  - DTO / TRANSFER OBJECT: Transporta los datos entre DAO ↔ Controller ↔ Vista.
 *  - SRP: Solo representa un ítem de facturación.
 *  - OCP: Se puede extender sin afectar otras capas.
 *  - COMPOSITE: Parte del patrón Composite dentro de la Factura (Factura = Compuesto / Detalles = Hojas).
 *  - PROTOTYPE: Se puede clonar para recalcular o emitir copias.
 */
public class DetalleFacturaTo {

    // Atributos
    private int idDetalle;
    private int idFactura;      // Relación con Factura
    private String descripcion; // Ej: "Hemograma Completo", "Glucosa en sangre"
    private int cantidad;
    private double precioUnitario;
    private double subtotal;

    // Constructor vacío
    public DetalleFacturaTo() {
    }

    // Constructor completo
    public DetalleFacturaTo(int idDetalle, int idFactura, String descripcion,
                            int cantidad, double precioUnitario, double subtotal) {
        this.idDetalle = idDetalle;
        this.idFactura = idFactura;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
    }

    // Getters y Setters

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
