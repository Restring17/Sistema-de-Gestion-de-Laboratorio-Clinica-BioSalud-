package com.biosalud.lis.controller;

import com.biosalud.lis.model.ResultadoLaboratorio;
import com.biosalud.lis.patterns.iterator.ResultadoIterator;
import com.biosalud.lis.patterns.memento.ResultadoCareTaker;
import com.biosalud.lis.patterns.memento.ResultadoMemento;
import com.biosalud.lis.patterns.memento.ResultadoOriginator;
import com.biosalud.lis.service.impl.ResultadoLaboratorioServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class ResultadoController {

    private final ResultadoLaboratorioServiceImpl service = new ResultadoLaboratorioServiceImpl();
    private final ResultadoOriginator originator = new ResultadoOriginator();
    private final ResultadoCareTaker careTaker = new ResultadoCareTaker();

    public boolean registrar(ResultadoLaboratorio r) {
        return service.registrar(r);
    }

    public boolean actualizar(ResultadoLaboratorio r) {
        return service.actualizar(r);
    }

    public boolean eliminar(int idResultado) {
        return service.eliminar(idResultado);
    }

    public ResultadoLaboratorio buscarPorId(int idResultado) {
        return service.buscarPorId(idResultado);
    }

    public List<ResultadoLaboratorio> listar() {
        return service.listar();
    }

    public ResultadoIterator obtenerIterator() {
        List<ResultadoLaboratorio> lista = listar();
        return new ResultadoIterator(lista != null ? lista : new ArrayList<>());
    }

    /**
     * Validar resultado: guarda un memento antes de validar para permitir
     * deshacer.
     */
    public boolean validarResultado(ResultadoLaboratorio r) {
        // guardar estado actual
        originator.setEstado(r);
        ResultadoMemento m = originator.guardarEnMemento();
        careTaker.agregarMemento(m);

        // aplicar validación
        boolean ok = service.validarResultado(r.getIdResultado(), true);
        if (ok) {
            r.setValidado(true);
        }
        return ok;
    }

    /**
     * Deshacer último cambio (restaurar último memento)
     */
    public ResultadoLaboratorio deshacerUltimoCambio() {
        int index = careTaker.totalEstados() - 1;
        if (index < 0) {
            return null;
        }

        ResultadoMemento m = careTaker.obtenerMemento(index);
        ResultadoLaboratorio restaurado = originator.restaurarDeMemento(m);

        // opcional: persistir restauración (si corresponde)
        service.actualizar(restaurado);
        return restaurado;
    }
}
