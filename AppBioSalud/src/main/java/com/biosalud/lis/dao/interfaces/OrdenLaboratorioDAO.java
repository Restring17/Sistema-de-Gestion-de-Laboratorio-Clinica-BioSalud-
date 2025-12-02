package com.biosalud.lis.dao.interfaces;

import com.biosalud.lis.model.OrdenLaboratorio;
import java.util.List;
import java.util.Optional;

public interface OrdenLaboratorioDAO {

    int save(OrdenLaboratorio orden) throws Exception; // devuelve id generado 
    
 
    Optional<OrdenLaboratorio> findById (int id) throws Exception;

    boolean update(OrdenLaboratorio orden) throws Exception;

    boolean delete(int id) throws Exception;

    List<OrdenLaboratorio> listAll() throws Exception;

    List<OrdenLaboratorio> listByDateRange(java.sql.Date inicio,
            java.sql.Date fin) throws Exception;

    boolean changeState(int idOrden, String estado) throws Exception;
}
