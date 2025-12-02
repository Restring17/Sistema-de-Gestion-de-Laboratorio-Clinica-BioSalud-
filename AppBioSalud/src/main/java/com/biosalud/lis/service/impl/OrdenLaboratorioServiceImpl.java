package com.biosalud.lis.service.impl;

import com.biosalud.lis.dao.impl.OrdenLaboratorioDAOImpl;
import com.biosalud.lis.dao.interfaces.OrdenLaboratorioDAO;
import com.biosalud.lis.model.OrdenLaboratorio;
import com.biosalud.lis.service.interfaces.OrdenLaboratorioService;
import java.util.List;
import java.util.Optional;

public class OrdenLaboratorioServiceImpl implements OrdenLaboratorioService {

    private final OrdenLaboratorioDAO dao = new OrdenLaboratorioDAOImpl();

    @Override
    public int crearOrden(OrdenLaboratorio orden) throws Exception {
// validaciones de negocio
        if (orden == null) {
            throw new IllegalArgumentException("Orden nula");
        }
        if (orden.getIdPaciente() <= 0) {
            throw new IllegalArgumentException("Paciente inválido");
        }
        if (orden.getIdMedico() <= 0) {
            throw new IllegalArgumentException("Médico inválido");
        }
        if (orden.getTipoExamen() == null
                || orden.getTipoExamen().isEmpty()) {
            throw new IllegalArgumentException("Tipo deexamen requerido");
        }

        return dao.save(orden);
    }

    @Override
    public Optional<OrdenLaboratorio> obtenerPorId(int id) throws Exception {
        return dao.findById(id);
    }

    @Override
    public boolean actualizarOrden(OrdenLaboratorio orden) throws Exception {
        if (orden == null || orden.getIdOrden() <= 0) {
            throw new IllegalArgumentException("Orden inválida");
        }
        return dao.update(orden);
    }

    @Override
    public boolean eliminarOrden(int id) throws Exception {
        return dao.delete(id);
    }

    @Override
    public List<OrdenLaboratorio> listarOrdenes() throws Exception {
        return dao.listAll();
    }

    @Override
    public List<OrdenLaboratorio> listarPorRango(java.sql.Date inicio,
            java.sql.Date fin) throws Exception {
        return dao.listByDateRange(inicio, fin);
    }

    @Override
    public boolean cambiarEstado(int idOrden, String estado) throws
            Exception {
        return dao.changeState(idOrden, estado);
    }

}
