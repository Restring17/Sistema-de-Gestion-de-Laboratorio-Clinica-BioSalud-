/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import dao.TecnicoLaboratorioDao;
import entity.TecnicoLaboratorioTo;

/**
 * Controller para TecnicoLaboratorio.
 *
 * PATRONES Y PRINCIPIOS:
 *  - SRP: Responsabilidad única: mediar entre vista y DAO de técnicos.
 *  - OCP, LSP, ISP, DIP: aplican.
 *  - FACTORY METHOD: creación del DAO puede centralizarse.
 *  - FACADE: Simplifica la interacción para la UI.
 *  - ADAPTER: Donde adaptar información de RRHH u otros sistemas.
 */
public class TecnicoLaboratorioController {

    private TecnicoLaboratorioDao dao;

    public TecnicoLaboratorioController() {
        dao = new TecnicoLaboratorioDao();
    }

    public List<TecnicoLaboratorioTo> TecnicoListar() throws Exception {
        return dao.readAll();
    }

    public TecnicoLaboratorioTo TecnicoBuscar(Object o) throws Exception {
        return dao.find(o);
    }

    public void TecnicoAdicionar(TecnicoLaboratorioTo o) throws Exception {
        dao.create(o);
    }

    public void TecnicoActualizar(TecnicoLaboratorioTo o) throws Exception {
        dao.update(o);
    }

    public void TecnicoEliminar(TecnicoLaboratorioTo o) throws Exception {
        dao.delete(o);
    }
}
