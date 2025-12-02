/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.biosalud.lis.ui;

import com.biosalud.lis.controller.ResultadoController;
import com.biosalud.lis.model.ResultadoLaboratorio;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

/**
 *
 * @author folli
 */
public class FormValidacionResultado extends javax.swing.JPanel {

    private final ResultadoController controller = new ResultadoController();

    public FormValidacionResultado() {
        initComponents();
    }

    private void limpiarResultado() {
        IDResultado.setText("");
        IDOrden.setText("");
        FechaResultado.setText("");
        AreaDescripcion.setText("");
        AreaValoresResultado.setText("");
        Conclusiones.setText("");
    }

    private ResultadoLaboratorio obtenerResultadoDesdeFormulario() {
        try {
            ResultadoLaboratorio r = new ResultadoLaboratorio();

            if (!IDResultado.getText().trim().isEmpty()) {
                r.setIdResultado(Integer.parseInt(IDResultado.getText().trim()));
            }

            r.setIdOrden(Integer.parseInt(IDOrden.getText().trim()));

            // Convertir fecha
            r.setFechaResultado(LocalDateTime.parse(FechaResultado.getText().trim()));

            r.setDescripcion(AreaDescripcion.getText());
            r.setValoresJson(AreaValoresResultado.getText());
            r.setConclusiones(Conclusiones.getText());
            r.setValidado(false);

            return r;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Datos inválidos: " + e.getMessage());
            return null;
        }
    }

    private void cargarResultadoEnFormulario(ResultadoLaboratorio r) {
        IDResultado.setText(String.valueOf(r.getIdResultado()));
        IDOrden.setText(String.valueOf(r.getIdOrden()));
        FechaResultado.setText(r.getFechaResultado().toString());
        AreaDescripcion.setText(r.getDescripcion());
        AreaValoresResultado.setText(r.getValoresJson());
        Conclusiones.setText(r.getConclusiones());
    }

    private void registrarResultado() {
        ResultadoLaboratorio r = obtenerResultadoDesdeFormulario();
        if (r == null) {
            return;
        }

        boolean ok = controller.registrar(r);

        if (ok) {
            JOptionPane.showMessageDialog(this, "Resultado registrado correctamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarResultado() {
        ResultadoLaboratorio r = obtenerResultadoDesdeFormulario();
        if (r == null) {
            return;
        }

        boolean ok = controller.actualizar(r);

        if (ok) {
            JOptionPane.showMessageDialog(this, "Resultado actualizado.");
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo actualizar.");
        }
    }

    private void eliminarResultado() {
        if (IDResultado.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un ID primero.");
            return;
        }

        int id = Integer.parseInt(IDResultado.getText().trim());

        boolean ok = controller.eliminar(id);

        if (ok) {
            JOptionPane.showMessageDialog(this, "Resultado eliminado.");
            limpiarResultado();
        } else {
            JOptionPane.showMessageDialog(this, "Error al eliminar.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscarResultado() {
        if (IDResultado.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un ID.");
            return;
        }

        int id = Integer.parseInt(IDResultado.getText().trim());

        ResultadoLaboratorio r = controller.buscarPorId(id);

        if (r != null) {
            cargarResultadoEnFormulario(r);
        } else {
            JOptionPane.showMessageDialog(this, "No existe este resultado.");
        }
    }

    private void validarResultado() {
        ResultadoLaboratorio r = obtenerResultadoDesdeFormulario();
        if (r == null) {
            return;
        }

        boolean ok = controller.validarResultado(r);

        if (ok) {
            JOptionPane.showMessageDialog(this, "Resultado VALIDADO.");
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo validar.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnbuscarResultado = new javax.swing.JButton();
        btnLimpiarResultado = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        IDOrden = new javax.swing.JTextPane();
        btnImprimirResultado = new javax.swing.JButton();
        jScrollPane18 = new javax.swing.JScrollPane();
        IDResultado = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        AreaDescripcion = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        AreaValoresResultado = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane20 = new javax.swing.JScrollPane();
        Conclusiones = new javax.swing.JTextPane();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        FechaResultado = new javax.swing.JTextPane();

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setText("Modulo de Validacion de resultado");

        btnbuscarResultado.setText("Buscar Resultado");
        btnbuscarResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarResultadoActionPerformed(evt);
            }
        });

        btnLimpiarResultado.setText("Limpiar");
        btnLimpiarResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarResultadoActionPerformed(evt);
            }
        });

        jLabel12.setText("ID Orden:");

        jLabel4.setText("ID Resultado :");

        jLabel16.setText("Conclusiones:");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Gestor de validacion");

        jScrollPane17.setViewportView(IDOrden);

        btnImprimirResultado.setBackground(new java.awt.Color(0, 102, 153));
        btnImprimirResultado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnImprimirResultado.setText("Validar");
        btnImprimirResultado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnImprimirResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirResultadoActionPerformed(evt);
            }
        });

        jScrollPane18.setViewportView(IDResultado);

        AreaDescripcion.setColumns(20);
        AreaDescripcion.setRows(5);
        jScrollPane1.setViewportView(AreaDescripcion);

        AreaValoresResultado.setColumns(20);
        AreaValoresResultado.setRows(5);
        jScrollPane2.setViewportView(AreaValoresResultado);

        jLabel15.setText("Descripcion del resultado :");

        jLabel17.setText("Valores del resultado:");

        jScrollPane20.setViewportView(Conclusiones);

        jLabel18.setText("Fecha:");

        jScrollPane19.setViewportView(FechaResultado);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addComponent(jScrollPane19))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel18))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnLimpiarResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnbuscarResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10))
                            .addComponent(btnImprimirResultado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane20)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel15)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2))))))
                .addGap(133, 133, 133))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel16))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(btnbuscarResultado)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpiarResultado))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(btnImprimirResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(164, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(115, 115, 115))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarResultadoActionPerformed
        limpiarResultado();
    }//GEN-LAST:event_btnLimpiarResultadoActionPerformed

    private void btnImprimirResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirResultadoActionPerformed
        try {
            int id = Integer.parseInt(IDResultado.getText().trim());
            ResultadoLaboratorio r = controller.buscarPorId(id);

            if (r == null) {
                JOptionPane.showMessageDialog(this, "No se encontró el resultado.");
                return;
            }

            String fileName = "Resultado_" + r.getIdResultado() + ".pdf";

            com.lowagie.text.Document pdf = new com.lowagie.text.Document();
            com.lowagie.text.pdf.PdfWriter.getInstance(pdf, new java.io.FileOutputStream(fileName));

            pdf.open();

            com.lowagie.text.Font titleFont = new com.lowagie.text.Font(com.lowagie.text.Font.HELVETICA, 20, com.lowagie.text.Font.BOLD);
            com.lowagie.text.Font normalFont = new com.lowagie.text.Font(com.lowagie.text.Font.HELVETICA, 12);

            pdf.add(new com.lowagie.text.Paragraph("REPORTE DE RESULTADO DE LABORATORIO", titleFont));
            pdf.add(new com.lowagie.text.Paragraph(" "));

            pdf.add(new com.lowagie.text.Paragraph("ID Resultado: " + r.getIdResultado(), normalFont));
            pdf.add(new com.lowagie.text.Paragraph("Fecha: " + r.getFechaResultado(), normalFont));
            pdf.add(new com.lowagie.text.Paragraph("ID Orden: " + r.getIdOrden(), normalFont));
            pdf.add(new com.lowagie.text.Paragraph("Validado: " + (r.isValidado() ? "Sí" : "No"), normalFont));
            pdf.add(new com.lowagie.text.Paragraph(" "));

            pdf.add(new com.lowagie.text.Paragraph("Descripción:", titleFont));
            pdf.add(new com.lowagie.text.Paragraph(r.getDescripcion(), normalFont));
            pdf.add(new com.lowagie.text.Paragraph(" "));

            pdf.add(new com.lowagie.text.Paragraph("Valores:", titleFont));
            pdf.add(new com.lowagie.text.Paragraph(r.getValoresJson(), normalFont));
            pdf.add(new com.lowagie.text.Paragraph(" "));

            pdf.add(new com.lowagie.text.Paragraph("Conclusiones:", titleFont));
            pdf.add(new com.lowagie.text.Paragraph(r.getConclusiones(), normalFont));
            pdf.add(new com.lowagie.text.Paragraph(" "));

            pdf.close();

            JOptionPane.showMessageDialog(this, "PDF generado:\n" + fileName);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ERROR al generar PDF: " + e.getMessage());
        }
    }//GEN-LAST:event_btnImprimirResultadoActionPerformed

    private void btnbuscarResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarResultadoActionPerformed
        buscarResultado();
    }//GEN-LAST:event_btnbuscarResultadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AreaDescripcion;
    private javax.swing.JTextArea AreaValoresResultado;
    private javax.swing.JTextPane Conclusiones;
    private javax.swing.JTextPane FechaResultado;
    private javax.swing.JTextPane IDOrden;
    private javax.swing.JTextPane IDResultado;
    private javax.swing.JButton btnImprimirResultado;
    private javax.swing.JButton btnLimpiarResultado;
    private javax.swing.JButton btnbuscarResultado;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    // End of variables declaration//GEN-END:variables
}
