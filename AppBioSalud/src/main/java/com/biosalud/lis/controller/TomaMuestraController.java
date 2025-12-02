/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biosalud.lis.controller;

import com.biosalud.lis.model.TomaMuestra;
import com.biosalud.lis.service.impl.TomaMuestraServiceImpl;
import java.util.List;

/**
 * PATRÓN UTILIZADO: MVC (Controlador) -----------------------------------
 * Controla la comunicación entre la vista (JFrame) y la capa de servicio.
 *
 * No contiene lógica pesada ni SQL.
 */
public class TomaMuestraController {

    private final TomaMuestraServiceImpl service = new TomaMuestraServiceImpl();

    public boolean registrar(TomaMuestra m) {
        return service.registrar(m);
    }

    public boolean actualizar(TomaMuestra m) {
        return service.actualizar(m);
    }

    public boolean eliminar(int id) {
        return service.eliminar(id);
    }

    public List<TomaMuestra> listar() {
        return service.listar();
    }

    public TomaMuestra buscarPorId(int id) {
        return service.buscarPorId(id);
    }

    public TomaMuestra buscarPorIdOrden(int idOrden) {
        return service.buscarPorIdOrden(idOrden);
    }
}
