/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biosalud.lis.patterns.memento;


import java.util.ArrayList;

import java.util.List;

public class ResultadoCareTaker {

    private final List<ResultadoMemento> historial = new ArrayList<>();

    public void agregarMemento(ResultadoMemento m) {
        historial.add(m);
    }

    public ResultadoMemento obtenerMemento(int index) {
        if (index >= 0 && index < historial.size()) {
            return historial.get(index);
        }
        return null;
    }

    public int totalEstados() {
        return historial.size();
    }
}
