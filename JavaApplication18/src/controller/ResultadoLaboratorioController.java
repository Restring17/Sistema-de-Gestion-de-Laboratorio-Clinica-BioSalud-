/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import java.util.List;
import dao.ResultadoLaboratorioDao;
import entity.ResultadoLaboratorioTo;

/**
 * Controller para ResultadoLaboratorio.
 *
 * PATRONES Y PRINCIPIOS:
 *  - SRP: Intermediario entre UI y DAO de resultados.
 *  - OCP, LSP, ISP, DIP: aplican.
 *  - FACTORY METHOD: creación del DAO puede delegarse a una fábrica.
 *  - FACADE: Provee una interfaz simple para la vista (ej. validar+guardar).
 *  - STRATEGY: Lugar para aplicar estrategias de validación/normalización según examen.
 *  - ADAPTER: Punto de adaptación de datos crudos de máquinas de laboratorio.
 */
public class ResultadoLaboratorioController {

    private ResultadoLaboratorioDao dao;

    public ResultadoLaboratorioController() {
        dao = new ResultadoLaboratorioDao();
    }

    public List<ResultadoLaboratorioTo> ResultadoListar() throws Exception {
        return dao.readAll();
    }

    public List<ResultadoLaboratorioTo> ResultadoListarPorOrden(int idOrden) throws Exception {
        return dao.readAllByOrden(idOrden);
    }

    public ResultadoLaboratorioTo ResultadoBuscar(Object o) throws Exception {
        return dao.find(o);
    }

    public void ResultadoAdicionar(ResultadoLaboratorioTo o) throws Exception {
        dao.create(o);
    }

    public void ResultadoActualizar(ResultadoLaboratorioTo o) throws Exception {
        dao.update(o);
    }

    public void ResultadoEliminar(ResultadoLaboratorioTo o) throws Exception {
        dao.delete(o);
    }
}

