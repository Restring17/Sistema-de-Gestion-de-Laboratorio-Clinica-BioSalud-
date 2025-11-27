
package com.biosalud.lis.model;

import java.sql.Date;


public class OrdenLaboratorio {
    
    private int idOrden;
    private int idPaciente;
    private int idMedico;
    private Date fechaEmision;
    private String tipoExamen;
    private String prioridad;
    private String estado;

    public OrdenLaboratorio() { }

    public OrdenLaboratorio(int idOrden, int idPaciente, int idMedico, Date fechaEmision, String tipoExamen, String prioridad, String estado) {
        this.idOrden = idOrden;
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
        this.fechaEmision = fechaEmision;
        this.tipoExamen = tipoExamen;
        this.prioridad = prioridad;
        this.estado = estado;
    }

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
