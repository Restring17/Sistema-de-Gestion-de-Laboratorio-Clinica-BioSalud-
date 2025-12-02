
package com.biosalud.lis.dao.interfaces;

import com.biosalud.lis.model.TomaMuestra;
import java.util.List;

/**
 * PATRÓN UTILIZADO: DAO (Data Access Object)
 * ------------------------------------------ Define un contrato de acceso a
 * datos para TomaMuestra. Esta interfaz NO sabe cómo se implementa la
 * comunicación con la base de datos.
 *
 * Su responsabilidad: declarar métodos CRUD estándar.
 */
public interface TomaMuestraDAO {

    boolean registrar(TomaMuestra muestra);

    boolean actualizar(TomaMuestra muestra);

    boolean eliminar(int idMuestra);

    TomaMuestra buscarPorId(int id);
    
    TomaMuestra buscarPorIdOrden(int idOrden);

    List<TomaMuestra> listar();
}
