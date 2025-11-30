package com.biosalud.lis.dao.interfaces;

import com.biosalud.lis.model.Medico;
import java.util.List;

public interface MedicoDAO {

    boolean insertar(Medico medico);

    boolean actualizar(Medico medico);

    boolean eliminar(int idMedico);

    Medico buscarPorId(int idMedico);

    List<Medico> listarTodos();

    int contarMedicos();
}
