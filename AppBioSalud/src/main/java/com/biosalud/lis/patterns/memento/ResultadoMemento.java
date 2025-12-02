/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biosalud.lis.patterns.memento;

import com.biosalud.lis.model.ResultadoLaboratorio;

public class ResultadoMemento {

    private final ResultadoLaboratorio estado;

    public ResultadoMemento(ResultadoLaboratorio estado) {
        this.estado = estado;
    }

    public ResultadoLaboratorio getEstado() {
        return estado;
    }
}
