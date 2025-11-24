/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;

/**
 * Controller para la entidad Paciente.
 *
 * PATRONES Y PRINCIPIOS:
 *  - SRP: Responsable sólo de la comunicación Vista <-> DAO.
 *  - OCP: Se puede extender (añadir nuevas consultas en el DAO) sin modificar este controller.
 *  - LSP: Cualquier implementación compatible de PacienteDao puede sustituir a la actual.
 *  - ISP: Usa solo los métodos necesarios del DAO.
 *  - DIP: Depende de la abstracción PacienteDao.
 *  - FACTORY METHOD: La construcción "new PacienteDao()" puede sustituirse por una fábrica.
 *  - FACADE: Actúa como fachada simple para la vista, ocultando la complejidad del DAO.
 *  - ADAPTER: Punto natural donde adaptar datos externos (por ejemplo, desde un HCE).
 */
public class PacienteController {

    private PacienteDao dao;

    public PacienteController() {
        // Creación directa: puede externalizarse a DaoFactory (Factory Method).
        dao = new PacienteDao();
    }

    public List<PacienteTo> PacienteListar() throws Exception {
        return dao.readAll();
    }

    public PacienteTo PacienteBuscar(Object o) throws Exception {
        return dao.find(o);
    }

    public void PacienteAdicionar(PacienteTo o) throws Exception {
        dao.create(o);
    }

    public void PacienteActualizar(PacienteTo o) throws Exception {
        dao.update(o);
    }

    public void PacienteEliminar(PacienteTo o) throws Exception {
        dao.delete(o);
    }
}
