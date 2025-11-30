
package com.biosalud.lis.ui;

import com.biosalud.lis.controller.ReporteController;
import com.biosalud.lis.facade.ReporteFacade;
import com.biosalud.lis.util.ExcelGenerator;
import com.biosalud.lis.util.PdfGenerator;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.table.DefaultTableModel;


public class FormReportes extends javax.swing.JPanel {

    public FormReportes() {
        initComponents();
        cargarTiposExamen();  // <<<<<<

    }

    private void cargarTiposExamen() {
        ReporteFacade facade = new ReporteFacade();

        cbcTipoExamen.removeAllItems();

        for (String tipo : facade.obtenerTiposExamen()) {
            cbcTipoExamen.addItem(tipo);
        }
    }

    private void limpiarFormulario() {
        // 1. Limpiar campos de texto de filtros (Fechas)
        txtFechaInicio.setText("");
        txtFechaFin.setText("");

        // 2. Restablecer el ComboBox (seleccionar "Todos" o el primer elemento)
        // Asumiendo que "Todos" es el primer ítem, o simplemente selecciona el índice 0.
        if (cbcTipoExamen.getItemCount() > 0) {
            cbcTipoExamen.setSelectedIndex(0);
        }

        // 3. Vaciar la Tabla de Resumen (TablaReportes1)
        // El modelo de datos de la tabla pequeña.
        DefaultTableModel modelResumen = (DefaultTableModel) TablaReportes1.getModel();

        // Elimina todas las filas existentes (si ya tenía datos, como 0 y 0.0)
        // NOTA: Si inicialmente la tabla Resumen solo tiene los encabezados, no se borra.
        if (modelResumen.getRowCount() > 0) {
            modelResumen.setRowCount(0);
        }

        // Opcional: Si quieres que siempre tenga una fila inicial con 0 y 0.0, 
        // puedes dejar este código comentado y añadir la fila manualmente:
        // modelResumen.addRow(new Object[]{0, 0.0}); 
        // 4. Vaciar la Tabla de Detalles (TablaReportes)
        // El modelo de datos de la tabla grande.
        DefaultTableModel modelDetalles = (DefaultTableModel) TablaReportes.getModel();
        modelDetalles.setRowCount(0); // Esto elimina todas las filas de la tabla de detalles

        // 5. Devolver el foco al primer campo
        txtFechaInicio.requestFocus();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTituloReportes = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblFechaInicio = new javax.swing.JLabel();
        txtFechaInicio = new javax.swing.JTextField();
        lblFechaFin = new javax.swing.JLabel();
        txtFechaFin = new javax.swing.JTextField();
        lblTipoExamen = new javax.swing.JLabel();
        cbcTipoExamen = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaReportes1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaReportes = new javax.swing.JTable();
        btnExportarExcel = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnGenerar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(680, 680));

        lblTituloReportes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTituloReportes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloReportes.setText("REPORTES DE LABORATORIO ");

        lblFechaInicio.setText("Fecha de Inicio:");

        lblFechaFin.setText("Fecha de fin:");

        txtFechaFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaFinActionPerformed(evt);
            }
        });

        lblTipoExamen.setText("Tipo de examen:");

        cbcTipoExamen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbcTipoExamenActionPerformed(evt);
            }
        });

        TablaReportes1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Total de Examenes", "Tiempo Promedio"
            }
        ));
        jScrollPane2.setViewportView(TablaReportes1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTipoExamen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbcTipoExamen, 0, 176, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFechaInicio)
                            .addComponent(lblFechaFin))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFechaFin, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                            .addComponent(txtFechaInicio))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbcTipoExamen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTipoExamen))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFechaInicio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFechaFin))))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        TablaReportes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Orden", "Tipo de Examen", "Fecha de Orden", "Tiempo de Entrega"
            }
        ));
        jScrollPane1.setViewportView(TablaReportes);

        btnExportarExcel.setText("Exportar Excel");
        btnExportarExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarExcelActionPerformed(evt);
            }
        });

        jButton1.setText("Exportar PDF");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnGenerar.setText("Generar");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jButton1)
                        .addGap(40, 40, 40)
                        .addComponent(btnExportarExcel)
                        .addGap(54, 54, 54)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblTituloReportes)
                        .addGap(206, 206, 206))))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTituloReportes)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExportarExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtFechaFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaFinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaFinActionPerformed

    private void cbcTipoExamenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbcTipoExamenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbcTipoExamenActionPerformed

    private void btnExportarExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarExcelActionPerformed
       ExcelGenerator generator = new ExcelGenerator();
        try {
            generator.exportarExcelDosTablas(TablaReportes, TablaReportes1);
        } catch (IOException ex) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Error al exportar Excel: " + ex.getMessage(),
                    "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnExportarExcelActionPerformed

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
          try {
            // Leer las fechas desde los JTextField
            String inicioStr = txtFechaInicio.getText();
            String finStr = txtFechaFin.getText();

            // Convertir String a LocalDate
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate inicio = LocalDate.parse(inicioStr, formatter);
            LocalDate fin = LocalDate.parse(finStr, formatter);

            // Leer el tipo de examen del combo
            String tipo = cbcTipoExamen.getSelectedItem().toString();

            // Llamar al controller para llenar las tablas
            ReporteController controller = new ReporteController();
            controller.llenarTabla(TablaReportes, TablaReportes1, tipo, inicio, fin);

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Error al leer las fechas: " + e.getMessage(),
                    "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
                                          

    }//GEN-LAST:event_btnGenerarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PdfGenerator generator = new PdfGenerator();
        try {
            generator.exportarPDFDosTablas(TablaReportes, TablaReportes1);
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Error al exportar PDF: " + ex.getMessage(),
                    "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
       limpiarFormulario();
    }//GEN-LAST:event_btnLimpiarActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaReportes;
    private javax.swing.JTable TablaReportes1;
    private javax.swing.JButton btnExportarExcel;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cbcTipoExamen;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFechaFin;
    private javax.swing.JLabel lblFechaInicio;
    private javax.swing.JLabel lblTipoExamen;
    private javax.swing.JLabel lblTituloReportes;
    private javax.swing.JTextField txtFechaFin;
    private javax.swing.JTextField txtFechaInicio;
    // End of variables declaration//GEN-END:variables
}

