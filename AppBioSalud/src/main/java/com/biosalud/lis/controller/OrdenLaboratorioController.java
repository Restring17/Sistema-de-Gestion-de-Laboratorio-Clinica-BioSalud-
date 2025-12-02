package com.biosalud.lis.controller;

import com.biosalud.lis.model.OrdenLaboratorio;
import com.biosalud.lis.service.impl.OrdenLaboratorioServiceImpl;
import com.biosalud.lis.service.interfaces.OrdenLaboratorioService;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

public class OrdenLaboratorioController {

    private final OrdenLaboratorioService service = new OrdenLaboratorioServiceImpl();

    public int guardarOrden(OrdenLaboratorio orden) throws Exception {
        return service.crearOrden(orden);
    }

    public Optional<OrdenLaboratorio> buscarOrden(int id) throws Exception {
        return service.obtenerPorId(id);
    }

    public boolean actualizarOrden(OrdenLaboratorio orden) throws Exception {
        return service.actualizarOrden(orden);
    }

    public boolean eliminarOrden(int id) throws Exception {
        return service.eliminarOrden(id);
    }

    public List<OrdenLaboratorio> listarOrdenes() throws Exception {
        return service.listarOrdenes();
    }

    public List<OrdenLaboratorio> listarPorRango(Date inicio, Date fin)
            throws Exception {
        return service.listarPorRango(inicio, fin);
    }

    public boolean cambiarEstado(int idOrden, String estado) throws
            Exception {
        return service.cambiarEstado(idOrden, estado);
    }
}
