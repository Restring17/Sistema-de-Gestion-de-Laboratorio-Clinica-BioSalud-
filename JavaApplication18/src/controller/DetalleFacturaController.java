/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import dao.DetalleFacturaDao;
import entity.DetalleFacturaTo;

/**
 * Controller para DetalleFactura.
 *
 * PATRONES Y PRINCIPIOS:
 *  - SRP: Maneja solo CRUD de detalles de factura.
 *  - COMPOSITE: Parte del composite Factura.
 *  - OCP, LSP, ISP, DIP: aplican.
 *  - FACADE: El conjunto FacturaController + DetalleFacturaController puede actuar como fachada
 *    para la UI cuando se emiten facturas.
 */
public class DetalleFacturaController {

    private DetalleFacturaDao dao;

    public DetalleFacturaController() {
        dao = new DetalleFacturaDao();
    }

    public List<DetalleFacturaTo> DetalleListar() throws Exception {
        return dao.readAll();
    }

    public List<DetalleFacturaTo> DetalleListarPorFactura(int idFactura) throws Exception {
        return dao.readAllByFactura(idFactura);
    }

    public DetalleFacturaTo DetalleBuscar(Object o) throws Exception {
        return dao.find(o);
    }

    public void DetalleAdicionar(DetalleFacturaTo o) throws Exception {
        dao.create(o);
    }

    public void DetalleActualizar(DetalleFacturaTo o) throws Exception {
        dao.update(o);
    }

    public void DetalleEliminar(DetalleFacturaTo o) throws Exception {
        dao.delete(o);
    }
}
