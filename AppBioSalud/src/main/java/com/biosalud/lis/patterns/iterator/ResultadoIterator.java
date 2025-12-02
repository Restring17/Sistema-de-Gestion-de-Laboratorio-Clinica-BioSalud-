/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biosalud.lis.patterns.iterator;

import com.biosalud.lis.model.ResultadoLaboratorio;
import java.util.Iterator;
import java.util.List;

public class ResultadoIterator implements Iterator<ResultadoLaboratorio> {

    private final List<ResultadoLaboratorio> lista;
    private int posicion = 0;

    public ResultadoIterator(List<ResultadoLaboratorio> lista) {
        this.lista = lista;
    }

    @Override
    public boolean hasNext() {
        return posicion < lista.size();
    }

    @Override
    public ResultadoLaboratorio next() {
        return lista.get(posicion++);
    }
}
