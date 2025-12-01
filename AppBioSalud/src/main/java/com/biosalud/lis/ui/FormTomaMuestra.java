/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.biosalud.lis.ui;

import javax.swing.table.DefaultTableModel;
import com.biosalud.lis.controller.TomaMuestraController;
import com.biosalud.lis.model.TomaMuestra;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.PdfPTable;
import java.io.FileOutputStream;
import java.io.File;
import java.awt.Desktop;

/**
 *
 * @author folli
 */
public class FormTomaMuestra extends javax.swing.JPanel {

    /**
     * Creates new form FormTomaMuestra
     */
    private final DefaultTableModel mDefaultTableModel;
    private final TomaMuestraController controller = new TomaMuestraController();
    private final DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private void cargarTabla() {
        try {
            // Limpiar tabla
            mDefaultTableModel.setRowCount(0);

            // Obtener lista
            List<TomaMuestra> lista = controller.listar();

            if (lista == null) {
                System.err.println("controller.listar() devolvió NULL");
                return;
            }

            // Llenar tabla
            for (TomaMuestra m : lista) {
                mDefaultTableModel.addRow(new Object[]{
                    m.getIdMuestra(),
                    (m.getFechaHora() != null ? m.getFechaHora().format(formato) : ""),
                    m.getTipoMuestra(),
                    m.getIdOrden(),
                    m.getIdTecnico()
                });
            }

            // Asignar modelo por seguridad
            jTable1.setModel(mDefaultTableModel);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Error cargando tabla: " + e.getMessage());
        }
    }

    private void registrarMuestra() {

        try {
            TomaMuestra m = new TomaMuestra();

            m.setFechaHora(LocalDateTime.parse(FechaMuestra.getText(), formato));
            m.setTipoMuestra(ComboTipo.getSelectedItem().toString());
            m.setIdOrden(Integer.parseInt(OrdenMuestra.getText()));
            m.setIdTecnico(Integer.parseInt(OrdenTecnico.getText()));

            if (controller.registrar(m)) {
                JOptionPane.showMessageDialog(this, "Muestra registrada correctamente.");
                cargarTabla();
            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Datos inválidos: " + e.getMessage());
        }
    }

    private void actualizarMuestra() {

        try {
            TomaMuestra m = new TomaMuestra();

            m.setIdMuestra(Integer.parseInt(IDMuestra.getText()));
            m.setFechaHora(LocalDateTime.parse(FechaMuestra.getText(), formato));
            m.setTipoMuestra(ComboTipo.getSelectedItem().toString());
            m.setIdOrden(Integer.parseInt(OrdenMuestra.getText()));
            m.setIdTecnico(Integer.parseInt(OrdenTecnico.getText()));

            if (controller.actualizar(m)) {
                JOptionPane.showMessageDialog(this, "Muestra actualizada.");
                cargarTabla();
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Datos inválidos.");
        }
    }

    private void eliminarMuestra() {
        try {
            int id = Integer.parseInt(IDMuestra.getText());

            if (controller.eliminar(id)) {
                JOptionPane.showMessageDialog(this, "Muestra eliminada.");
                cargarTabla();
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ID inválido.");
        }
    }

    private void imprimirPDF() {
        try {
            Document doc = new Document();
            String ruta = "muestras_lista.pdf";
            PdfWriter.getInstance(doc, new FileOutputStream(ruta));
            doc.open();

            doc.add(new Paragraph("LISTA DE MUESTRAS"));
            doc.add(new Paragraph(" "));

            PdfPTable pdfTable = new PdfPTable(jTable1.getColumnCount());

            // Encabezados
            for (int i = 0; i < jTable1.getColumnCount(); i++) {
                pdfTable.addCell(jTable1.getColumnName(i));
            }

            // Filas
            for (int r = 0; r < jTable1.getRowCount(); r++) {
                for (int c = 0; c < jTable1.getColumnCount(); c++) {
                    pdfTable.addCell(jTable1.getValueAt(r, c).toString());
                }
            }

            doc.add(pdfTable);
            doc.close();

            Desktop.getDesktop().open(new File(ruta));
            JOptionPane.showMessageDialog(this, "PDF generado correctamente.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error generando PDF: " + e.getMessage());
        }
    }

    private void buscarMuestra() {
        try {
            int id = Integer.parseInt(IDMuestra.getText().trim());

            TomaMuestra m = controller.buscarPorId(id);

            if (m == null) {
                JOptionPane.showMessageDialog(this, "No encontrado");
                return;
            }

            OrdenMuestra.setText(String.valueOf(m.getIdOrden()));
            OrdenTecnico.setText(String.valueOf(m.getIdTecnico()));
            ComboTipo.setSelectedItem(m.getTipoMuestra());
            FechaMuestra.setText(m.getFechaHora().format(formato));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    public FormTomaMuestra() {
        initComponents();

        mDefaultTableModel = new DefaultTableModel();
        mDefaultTableModel.addColumn("ID MUESTRA");
        mDefaultTableModel.addColumn("FECHA/HORA");
        mDefaultTableModel.addColumn("TIPO EXAMEN");
        mDefaultTableModel.addColumn("ID ORDEN");
        mDefaultTableModel.addColumn("ID TECNICO");

        jTable1.setModel(mDefaultTableModel);
        cargarTabla();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        IDMed = new javax.swing.JTextPane();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextNombreApellidoMed = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextEspecialidad = new javax.swing.JTextPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextTelf = new javax.swing.JTextPane();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextCorreoMed = new javax.swing.JTextPane();
        jScrollPane16 = new javax.swing.JScrollPane();
        jTextCMP = new javax.swing.JTextPane();
        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jDialog3 = new javax.swing.JDialog();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jScrollPane13 = new javax.swing.JScrollPane();
        IDMedNew = new javax.swing.JTextPane();
        jScrollPane9 = new javax.swing.JScrollPane();
        tbOrdenes = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnIngresarMuestra = new javax.swing.JButton();
        btnBuscarMuestra = new javax.swing.JButton();
        btnEliminarMuestra = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        IDMuestra = new javax.swing.JTextPane();
        jScrollPane15 = new javax.swing.JScrollPane();
        FechaMuestra = new javax.swing.JTextPane();
        OrdenMedico = new javax.swing.JScrollPane();
        OrdenMuestra = new javax.swing.JTextPane();
        jScrollPane19 = new javax.swing.JScrollPane();
        OrdenTecnico = new javax.swing.JTextPane();
        ComboTipo = new javax.swing.JComboBox<>();
        btnActualizarMuestra1 = new javax.swing.JButton();
        btnMuestrasRegistradas1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jScrollPane2.setViewportView(IDMed);

        jLabel4.setText("Nombre y Apellido:");

        jScrollPane3.setViewportView(jTextNombreApellidoMed);

        jScrollPane5.setViewportView(jTextEspecialidad);

        jScrollPane6.setViewportView(jTextTelf);

        jScrollPane8.setViewportView(jTextCorreoMed);

        jScrollPane16.setViewportView(jTextCMP);

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog3Layout = new javax.swing.GroupLayout(jDialog3.getContentPane());
        jDialog3.getContentPane().setLayout(jDialog3Layout);
        jDialog3Layout.setHorizontalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog3Layout.setVerticalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jScrollPane13.setViewportView(IDMedNew);

        tbOrdenes.setColumns(20);
        tbOrdenes.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        tbOrdenes.setRows(5);
        jScrollPane9.setViewportView(tbOrdenes);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setText("Modulo de muestras");

        btnIngresarMuestra.setBackground(new java.awt.Color(0, 153, 204));
        btnIngresarMuestra.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        btnIngresarMuestra.setText("Registrar Muestra");
        btnIngresarMuestra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarMuestraActionPerformed(evt);
            }
        });

        btnBuscarMuestra.setText("Buscar ");
        btnBuscarMuestra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarMuestraActionPerformed(evt);
            }
        });

        btnEliminarMuestra.setText("Eliminar");
        btnEliminarMuestra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarMuestraActionPerformed(evt);
            }
        });

        jLabel9.setText("Fecha/hora:");

        jLabel3.setText("ID Paciente :");

        jLabel10.setText("Tipo de examen:");

        jLabel11.setText("Id Orden:");

        jLabel13.setText("ID del tecnico:");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Gestion de muestras");

        jScrollPane14.setViewportView(IDMuestra);

        jScrollPane15.setViewportView(FechaMuestra);

        OrdenMedico.setViewportView(OrdenMuestra);

        jScrollPane19.setViewportView(OrdenTecnico);

        ComboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sangre", "Orina", "otros" }));
        ComboTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboTipoActionPerformed(evt);
            }
        });

        btnActualizarMuestra1.setText("Actualizar");
        btnActualizarMuestra1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarMuestra1ActionPerformed(evt);
            }
        });

        btnMuestrasRegistradas1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnMuestrasRegistradas1.setText("Imprimir Lista");
        btnMuestrasRegistradas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMuestrasRegistradas1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel10))
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(103, 103, 103)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminarMuestra, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIngresarMuestra, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel11))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OrdenMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscarMuestra, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizarMuestra1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnMuestrasRegistradas1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(239, 239, 239))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel3)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OrdenMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(btnIngresarMuestra, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarMuestra))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnActualizarMuestra1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminarMuestra)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(btnMuestrasRegistradas1))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(220, 220, 220))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarMuestraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarMuestraActionPerformed
        buscarMuestra();
    }//GEN-LAST:event_btnBuscarMuestraActionPerformed

    private void btnEliminarMuestraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarMuestraActionPerformed
        eliminarMuestra();
    }//GEN-LAST:event_btnEliminarMuestraActionPerformed

    private void ComboTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboTipoActionPerformed

    private void btnActualizarMuestra1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarMuestra1ActionPerformed
        actualizarMuestra();
    }//GEN-LAST:event_btnActualizarMuestra1ActionPerformed

    private void btnMuestrasRegistradas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuestrasRegistradas1ActionPerformed
        imprimirPDF();
    }//GEN-LAST:event_btnMuestrasRegistradas1ActionPerformed

    private void btnIngresarMuestraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarMuestraActionPerformed
        registrarMuestra();
    }//GEN-LAST:event_btnIngresarMuestraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboTipo;
    private javax.swing.JTextPane FechaMuestra;
    private javax.swing.JTextPane IDMed;
    private javax.swing.JTextPane IDMedNew;
    private javax.swing.JTextPane IDMuestra;
    private javax.swing.JScrollPane OrdenMedico;
    private javax.swing.JTextPane OrdenMuestra;
    private javax.swing.JTextPane OrdenTecnico;
    private javax.swing.JButton btnActualizarMuestra1;
    private javax.swing.JButton btnBuscarMuestra;
    private javax.swing.JButton btnEliminarMuestra;
    private javax.swing.JButton btnIngresarMuestra;
    private javax.swing.JButton btnMuestrasRegistradas1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextPane jTextCMP;
    private javax.swing.JTextPane jTextCorreoMed;
    private javax.swing.JTextPane jTextEspecialidad;
    private javax.swing.JTextPane jTextNombreApellidoMed;
    private javax.swing.JTextPane jTextTelf;
    private javax.swing.JTextArea tbOrdenes;
    // End of variables declaration//GEN-END:variables
}
