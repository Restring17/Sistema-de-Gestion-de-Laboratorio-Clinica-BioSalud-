/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import dao.TomaMuestraDao;
import entity.TomaMuestraTo;

/**
 * Controller para TomaMuestra.
 *
 * PATRONES Y PRINCIPIOS:
 *  - SRP: Maneja solo la comunicación con el DAO de toma de muestra.
 *  - OCP, LSP, ISP, DIP: aplican.
 *  - FACTORY METHOD y FACADE: aplicables según arquitectura.
 *  - ADAPTER: útil para adaptar datos de equipos/laboratorio que exporten registros.
 *  - STRATEGY: puede coordinar estrategias de validación según tipo de muestra.
 */
public class TomaMuestraController {

    private TomaMuestraDao dao;

    public TomaMuestraController() {
        dao = new TomaMuestraDao();
    }

    public List<TomaMuestraTo> TomaListar() throws Exception {
        return dao.readAll();
    }

    public TomaMuestraTo TomaBuscar(Object o) throws Exception {
        return dao.find(o);
    }

    public void TomaAdicionar(TomaMuestraTo o) throws Exception {
        dao.create(o);
    }

    public void TomaActualizar(TomaMuestraTo o) throws Exception {
        dao.update(o);
    }

    public void TomaEliminar(TomaMuestraTo o) throws Exception {
        dao.delete(o);
    }
}
