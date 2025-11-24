/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import dao.FacturaDao;
import entity.FacturaTo;

/**
 * Controller para Factura.
 *
 * PATRONES Y PRINCIPIOS:
 *  - SRP: Gestiona interacción vista ↔ DAO de facturas.
 *  - COMPOSITE: Factura actúa como composite conteniendo DetalleFactura.
 *  - OCP, LSP, ISP, DIP: aplican.
 *  - FACADE: Aquí se puede ofrecer un método "emitirFactura" que coordine creación de factura
 *    y detalles (oculta la complejidad a la vista).
 *  - FACTORY METHOD: Creación de DAO puede externalizarse.
 */
public class FacturaController {

    private FacturaDao dao;

    public FacturaController() {
        dao = new FacturaDao();
    }

    public List<FacturaTo> FacturaListar() throws Exception {
        return dao.readAll();
    }

    public FacturaTo FacturaBuscar(Object o) throws Exception {
        return dao.find(o);
    }

    public void FacturaAdicionar(FacturaTo o) throws Exception {
        dao.create(o);
    }

    public void FacturaActualizar(FacturaTo o) throws Exception {
        dao.update(o);
    }

    public void FacturaEliminar(FacturaTo o) throws Exception {
        dao.delete(o);
    }

    /**
     * Ejemplo de método tipo fachada: emitirFactura podría coordinar creación de factura
     * y detalles en una sola operación transaccional (idealmente en un Service o Facade).
     */
    public void emitirFactura(FacturaTo factura) throws Exception {
        // Nota: la lógica transaccional real debe implementarse en capas de servicio o DAO
        dao.create(factura);
    }
}
