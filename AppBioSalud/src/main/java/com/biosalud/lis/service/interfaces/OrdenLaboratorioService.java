package com.biosalud.lis.service.interfaces;

import com.biosalud.lis.model.OrdenLaboratorio;
import java.util.List;
import java.util.Optional;

public interface OrdenLaboratorioService {

    int crearOrden(OrdenLaboratorio orden) throws Exception;

    Optional<OrdenLaboratorio> obtenerPorId(int id) throws Exception;

    boolean actualizarOrden(OrdenLaboratorio orden) throws Exception;

    boolean eliminarOrden(int id) throws Exception;
    
    List<OrdenLaboratorio> listarOrdenes() throws Exception;

    List<OrdenLaboratorio> listarPorRango(java.sql.Date inicio,
            java.sql.Date fin) throws Exception;

    boolean cambiarEstado(int idOrden, String estado) throws Exception;
}
