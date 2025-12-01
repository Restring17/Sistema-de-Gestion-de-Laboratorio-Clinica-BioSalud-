package com.biosalud.lis.service.impl;

import com.biosalud.lis.dao.impl.TomaMuestraDAOImpl;
import com.biosalud.lis.model.TomaMuestra;
import com.biosalud.lis.service.interfaces.TomaMuestraService;
import java.util.List;

/**
 * PATRONES UTILIZADOS: -------------------- Service Layer: Implementa la lógica
 * de negocio.
 *
 * Delegación (Delegation Pattern): Delega las operaciones CRUD al DAO.
 */
public class TomaMuestraServiceImpl implements TomaMuestraService {

    private final TomaMuestraDAOImpl dao = new TomaMuestraDAOImpl();


    @Override
    public boolean registrar(TomaMuestra muestra) {
        return dao.registrar(muestra);
    }

    @Override
    public boolean actualizar(TomaMuestra muestra) {
        return dao.actualizar(muestra);
    }

    @Override
    public boolean eliminar(int id) {
        return dao.eliminar(id);
    }

    @Override
    public List<TomaMuestra> listar() {
        return dao.listar();
    }

    @Override
    public TomaMuestra buscarPorId(int id) {
        return dao.buscarPorId(id);
    }

}
