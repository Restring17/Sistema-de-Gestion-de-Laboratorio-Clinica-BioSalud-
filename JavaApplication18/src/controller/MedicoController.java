/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author KEVIN
 */
/**
 * Controller para Medico.
 *
 * PATRONES Y PRINCIPIOS:
 *  - SRP: Solo maneja la interacción Vista <-> DAO de médicos.
 *  - OCP, LSP, ISP, DIP: aplican como en la arquitectura MVC/DAO.
 *  - FACTORY METHOD: new MedicoDao() puede delegarse.
 *  - FACADE: Simplifica operaciones para la vista.
 *  - ADAPTER: Punto donde adaptar datos de sistemas externos.
 */
public class MedicoController {

    private MedicoDao dao;

    public MedicoController() {
        dao = new MedicoDao();
    }

    public List<MedicoTo> MedicoListar() throws Exception {
        return dao.readAll();
    }

    public MedicoTo MedicoBuscar(Object o) throws Exception {
        return dao.find(o);
    }

    public void MedicoAdicionar(MedicoTo o) throws Exception {
        dao.create(o);
    }

    public void MedicoActualizar(MedicoTo o) throws Exception {
        dao.update(o);
    }

    public void MedicoEliminar(MedicoTo o) throws Exception {
        dao.delete(o);
    }
}
