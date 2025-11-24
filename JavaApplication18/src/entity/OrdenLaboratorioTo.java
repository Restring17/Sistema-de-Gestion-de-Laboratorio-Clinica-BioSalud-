/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 * Transfer Object (TO) para Orden de Laboratorio.
 *
 * PATRONES Y PRINCIPIOS:
 *  - DTO / TRANSFER OBJECT: Envía datos del DAO ↑ hacia la Vista JFrame.
 *  - SRP: Solo representa los datos de la orden.
 *  - OCP: Puede extenderse (agregar campos) sin modificar otras capas.
 *  - PROTOTYPE: Permite duplicar la orden si necesitas versiones temporales.
 *  - COMPOSITE: La orden se relaciona con múltiples resultados/operaciones (a nivel de dominio).
 */
public class OrdenLaboratorioTo {

    // Atributos
    private int idOrden;
    private int idPaciente;
    private int idMedico;
    private Date fechaEmision;
    private String tipoExamen;      // Ej: Hemograma, Perfil Lipídico
    private String prioridad;       // Normal / Urgente
    private String estado;          // Registrada / En proceso / Finalizada / Cancelada

    // Constructor vacío
    public OrdenLaboratorioTo() {
    }

    // Constructor completo
    public OrdenLaboratorioTo(int idOrden, int idPaciente, int idMedico, Date fechaEmision,
                              String tipoExamen, String prioridad, String estado) {
        this.idOrden = idOrden;
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
        this.fechaEmision = fechaEmision;
        this.tipoExamen = tipoExamen;
        this.prioridad = prioridad;
        this.estado = estado;
    }

    // Getters y Setters

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getTipoExamen() {
        return tipoExamen;
    }

    public void setTipoExamen(String tipoExamen) {
        this.tipoExamen = tipoExamen;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
