/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biosalud.lis.patterns.memento;


import com.biosalud.lis.model.ResultadoLaboratorio;


public class ResultadoOriginator {

    private ResultadoLaboratorio estadoActual;

    public void setEstado(ResultadoLaboratorio estado) {
        this.estadoActual = estado;
    }

    public ResultadoMemento guardarEnMemento() {
        return new ResultadoMemento(clonar(estadoActual));
    }

    public ResultadoLaboratorio restaurarDeMemento(ResultadoMemento m) {
        this.estadoActual = clonar(m.getEstado());
        return this.estadoActual;
    }

    private ResultadoLaboratorio clonar(ResultadoLaboratorio r) {
        ResultadoLaboratorio c = new ResultadoLaboratorio();
        c.setIdResultado(r.getIdResultado());
        c.setFechaResultado(r.getFechaResultado());
        c.setDescripcion(r.getDescripcion());
        c.setValoresJson(r.getValoresJson());
        c.setConclusiones(r.getConclusiones());
        c.setIdOrden(r.getIdOrden());
        c.setValidado(r.isValidado());
        return c;
    }
}
