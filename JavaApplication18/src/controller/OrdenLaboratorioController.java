/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;


/**
 * Controller para OrdenLaboratorio.
 *
 * PATRONES Y PRINCIPIOS:
 *  - SRP: Conecta vista y DAO de órdenes.
 *  - OCP, LSP, ISP, DIP: aplican normalmente.
 *  - FACTORY METHOD: creación del DAO puede delegarse.
 *  - FACADE: Sirve como interfaz simple para la vista (ej. crear+agendar).
 *  - ADAPTER: Aquí se pueden adaptar órdenes entrantes de sistemas externos.
 *  - STRATEGY: Lugar natural para aplicar estrategias de priorización/proceso de órdenes.
 */
public class OrdenLaboratorioController {

    private OrdenLaboratorioDao dao;

    public OrdenLaboratorioController() {
        dao = new OrdenLaboratorioDao();
    }

    public List<OrdenLaboratorioTo> OrdenListar() throws Exception {
        return dao.readAll();
    }

    public List<OrdenLaboratorioTo> OrdenListarPorPaciente(int idPaciente) throws Exception {
        return dao.readAllByPaciente(idPaciente);
    }

    public OrdenLaboratorioTo OrdenBuscar(Object o) throws Exception {
        return dao.find(o);
    }

    public void OrdenAdicionar(OrdenLaboratorioTo o) throws Exception {
        dao.create(o);
    }

    public void OrdenActualizar(OrdenLaboratorioTo o) throws Exception {
        dao.update(o);
    }

    public void OrdenEliminar(OrdenLaboratorioTo o) throws Exception {
        dao.delete(o);
    }
}

