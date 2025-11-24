/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 * Transfer Object (TO) para Toma de Muestra.
 *
 * PATRONES Y PRINCIPIOS:
 *  - DTO / TRANSFER OBJECT: Envía y recibe datos entre DAO ↔ Controller ↔ Vista.
 *  - SRP: Solo representa los datos asociados a una toma de muestra.
 *  - OCP: Permite agregar más atributos sin modificar otras capas.
 *  - PROTOTYPE: Se puede clonar para auditorías o versiones temporales del registro.
 *  - MEDIATOR (indirectamente): La toma de muestra media entre Orden, Técnico y Resultado.
 */
public class TomaMuestraTo {

    // Atributos
    private int idToma;
    private int idOrden;           // Relación con OrdenLaboratorio
    private int idTecnico;         // Quién toma la muestra
    private Date fechaToma;
    private String tipoMuestra;    // Sangre, Orina, Heces, etc.
    private String observaciones;
    private String estado;         // Pendiente / Tomada / Rechazada

    // Constructor vacío
    public TomaMuestraTo() {
    }

    // Constructor completo
    public TomaMuestraTo(int idToma, int idOrden, int idTecnico, Date fechaToma,
                         String tipoMuestra, String observaciones, String estado) {
        this.idToma = idToma;
        this.idOrden = idOrden;
        this.idTecnico = idTecnico;
        this.fechaToma = fechaToma;
        this.tipoMuestra = tipoMuestra;
        this.observaciones = observaciones;
        this.estado = estado;
    }

    // Getters y Setters

    public int getIdToma() {
        return idToma;
    }

    public void setIdToma(int idToma) {
        this.idToma = idToma;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public int getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(int idTecnico) {
        this.idTecnico = idTecnico;
    }

    public Date getFechaToma() {
        return fechaToma;
    }

    public void setFechaToma(Date fechaToma) {
        this.fechaToma = fechaToma;
    }

    public String getTipoMuestra() {
        return tipoMuestra;
    }

    public void setTipoMuestra(String tipoMuestra) {
        this.tipoMuestra = tipoMuestra;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
