
package com.biosalud.lis.controller;

import com.biosalud.lis.facade.ReporteFacade;
import com.biosalud.lis.model.Reporte;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Clase que actúa como el controlador entre la Vista (el formulario) y la
 * lógica de negocio (el Facade/Servicio). Es responsable de recibir peticiones
 * de la UI y actualizarla.
 */
public class ReporteController {
    private final ReporteFacade facade = new ReporteFacade();

    public void llenarTabla(JTable tabla1, JTable tabla2, String tipoExamen, LocalDate inicio, LocalDate fin) {

        // --- PARTE 1: LLENAR TABLA DE DETALLES (tabla1) ---
        // 1. Obtener la lista de objetos Reporte (Detalle)
        // Llama al Facade, que a su vez llama al DAO para obtener la lista de filas.
        List<Reporte> lista = facade.generarReporte(tipoExamen, inicio, fin);

        // 2. Crear el Modelo para la tabla de Detalles
        DefaultTableModel model1 = new DefaultTableModel();
        // 3. Establecer los encabezados de las columnas (Nombres que se verán en la UI)
        model1.setColumnIdentifiers(new String[]{"ID Orden", "Tipo Examen", "Fecha Orden", "Tiempo Entrega"});
        // 4. Llenar el modelo con los datos de la lista
        // Itera sobre la lista recibida y añade cada objeto 'Reporte' como una nueva fila (Object[])
        lista.forEach(r -> model1.addRow(new Object[]{
            r.getIdOrden(), r.getTipoExamen(), r.getFechaOrden(), r.getTiempoEntrega()
        }));
        tabla1.setModel(model1);

        // Tabla 2 con totales y promedio
        DefaultTableModel model2 = new DefaultTableModel();
        model2.setColumnIdentifiers(new String[]{"Total Examenes", "Tiempo Promedio"});
        model2.addRow(new Object[]{facade.totalExamenes(tipoExamen, inicio, fin),
            facade.tiempoPromedio(tipoExamen, inicio, fin)});
        tabla2.setModel(model2);
    }

    public void cargarTiposExamen(JComboBox<String> combo) {
        ReporteFacade facade = new ReporteFacade();
        List<String> tipos = facade.obtenerTiposExamen();

        combo.removeAllItems();
        combo.addItem("Todos"); // opción general

        for (String t : tipos) {
            combo.addItem(t);
        }
    }

}
 

