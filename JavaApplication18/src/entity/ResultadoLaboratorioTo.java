/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 * Transfer Object (TO) para Resultado de Laboratorio.
 *
 * PATRONES Y PRINCIPIOS:
 *  - DTO / TRANSFER OBJECT: Mueve información desde la BD hacia el Controller y la Vista.
 *  - SRP: Solo representa datos del resultado de un examen.
 *  - OCP: Si mañana se agregan rangos de referencia, unidades u otros datos,
 *         el TO puede extenderse sin afectar otras capas.
 *  - PROTOTYPE: Se puede clonar para manejar revisiones o resultados temporales.
 *  - STRATEGY (concepto aplicado externamente): Permite estrategias diferentes de validación 
 *    según el tipo de examen (hemograma, glucosa, etc.).
 */
public class ResultadoLaboratorioTo {

    // Atributos
    private int idResultado;
    private int idOrden;           // Relación con la orden de laboratorio
    private String parametro;      // Ej: "Glucosa", "Hemoglobina"
    private String valor;          // Valor medido
    private String unidad;         // mg/dL, g/dL, %, UI/L, etc.
    private String referencia;     // Valores normales
    private Date fechaResultado;
    private String estado;         // Pendiente / Procesado / Validado

    // Constructor vacío
    public ResultadoLaboratorioTo() {
    }

    // Constructor completo
    public ResultadoLaboratorioTo(int idResultado, int idOrden, String parametro,
                                  String valor, String unidad, String referencia,
                                  Date fechaResultado, String estado) {
        this.idResultado = idResultado;
        this.idOrden = idOrden;
        this.parametro = parametro;
        this.valor = valor;
        this.unidad = unidad;
        this.referencia = referencia;
        this.fechaResultado = fechaResultado;
        this.estado = estado;
    }

    // Getters y Setters

    public int getIdResultado() {
        return idResultado;
    }

    public void setIdResultado(int idResultado) {
        this.idResultado = idResultado;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Date getFechaResultado() {
        return fechaResultado;
    }

    public void setFechaResultado(Date fechaResultado) {
        this.fechaResultado = fechaResultado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

