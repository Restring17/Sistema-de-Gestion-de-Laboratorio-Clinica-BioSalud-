/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biosalud.lis.model;
import java.time.LocalDateTime;

/**
 * PATRÓN UTILIZADO: MVC (Modelo) ------------------------------- Esta clase
 * representa la entidad TomaMuestra. - Solo contiene atributos y
 * getters/setters. - No realiza acceso a datos. - No contiene lógica de
 * negocio.
 *
 * Su única responsabilidad: representar la estructura del dato.
 */

/**
 * MODELO: TomaMuestra
 * Representa la tabla toma_muestra de la base de datos.
 */
public class TomaMuestra {

    private int idMuestra;
    private LocalDateTime fechaHora;
    private String tipoMuestra;
    private int idOrden;
    private int idTecnico;

    // ===== CONSTRUCTORES =====

    public TomaMuestra() {
    }

    public TomaMuestra(int idMuestra, LocalDateTime fechaHora, String tipoMuestra, int idOrden, int idTecnico) {
        this.idMuestra = idMuestra;
        this.fechaHora = fechaHora;
        this.tipoMuestra = tipoMuestra;
        this.idOrden = idOrden;
        this.idTecnico = idTecnico;
    }

    // ===== GETTERS & SETTERS =====

    public int getIdMuestra() {
        return idMuestra;
    }

    public void setIdMuestra(int idMuestra) {
        this.idMuestra = idMuestra;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getTipoMuestra() {
        return tipoMuestra;
    }

    public void setTipoMuestra(String tipoMuestra) {
        this.tipoMuestra = tipoMuestra;
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

}


