package com.biosalud.lis.ui;

import com.biosalud.lis.controller.MedicoController;
import com.biosalud.lis.dto.MedicoDTO;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.PdfPTable;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;

public class FormMedicoCRUD extends javax.swing.JPanel {

    private final MedicoController controller;
    private DefaultTableModel modeloTablaMedicos;

    public FormMedicoCRUD() {
        initComponents();
        controller = new MedicoController();
        configurarTabla();
        cargarMedicos();
        actualizarContadorMedicos();
    }

    private void configurarTabla() {
        modeloTablaMedicos = new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Nombre y Apellidos", "Especialidad", "Teléfono", "CMP"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        TablaMedicos.setModel(modeloTablaMedicos);
    }

    private void actualizarContadorMedicos() {
        int total = controller.contarMedicos();
        lblContadorMedicos.setText("Doctores: " + total);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        button1 = new java.awt.Button();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jFrame1 = new javax.swing.JFrame();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        menuBar2 = new java.awt.MenuBar();
        menu3 = new java.awt.Menu();
        menu4 = new java.awt.Menu();
        label1 = new java.awt.Label();
        jMenu5 = new javax.swing.JMenu();
        btnRegistrarOrden = new javax.swing.JButton();
        btnBuscarOrden = new javax.swing.JButton();
        btnOrdenesRegistradas = new javax.swing.JButton();
        btnImprimirRegistros = new javax.swing.JButton();
        btnLimpiarCasillasBuscarMed = new javax.swing.JButton();
        btnLimpiarCasillasRegistrar = new javax.swing.JButton();
        btnActualizarMedico = new javax.swing.JButton();
        btnEliminarMedico = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        IDMed = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextNombreApellidoMed = new javax.swing.JTextPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextEspeciallidadMed = new javax.swing.JTextPane();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTextTelfNew = new javax.swing.JTextPane();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextNombreApellidoMedNew = new javax.swing.JTextPane();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTextEspecialidadNew = new javax.swing.JTextPane();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTextCMPNew = new javax.swing.JTextPane();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        jTextTelef = new javax.swing.JTextPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        TablaMedicos = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextCMP = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        lblContadorMedicos = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        button1.setLabel("button1");

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jScrollPane10.setViewportView(jTextPane1);

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        menu3.setLabel("File");
        menuBar2.add(menu3);

        menu4.setLabel("Edit");
        menuBar2.add(menu4);

        label1.setText("label1");

        jMenu5.setText("jMenu5");

        btnRegistrarOrden.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        btnRegistrarOrden.setText("Registrar Nuevo Medico");
        btnRegistrarOrden.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegistrarOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarOrdenActionPerformed(evt);
            }
        });

        btnBuscarOrden.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 18)); // NOI18N
        btnBuscarOrden.setText("Buscar Medico");
        btnBuscarOrden.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBuscarOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarOrdenActionPerformed(evt);
            }
        });

        btnOrdenesRegistradas.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        btnOrdenesRegistradas.setText("Lista de Medicos actuales");
        btnOrdenesRegistradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenesRegistradasActionPerformed(evt);
            }
        });

        btnImprimirRegistros.setBackground(new java.awt.Color(204, 255, 255));
        btnImprimirRegistros.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnImprimirRegistros.setText("Imprimir Lista");
        btnImprimirRegistros.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnImprimirRegistros.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnImprimirRegistros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirRegistrosActionPerformed(evt);
            }
        });

        btnLimpiarCasillasBuscarMed.setText("Limpiar");
        btnLimpiarCasillasBuscarMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarCasillasBuscarMedActionPerformed(evt);
            }
        });

        btnLimpiarCasillasRegistrar.setText("Limpiar");
        btnLimpiarCasillasRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarCasillasRegistrarActionPerformed(evt);
            }
        });

        btnActualizarMedico.setText("Actualizar");
        btnActualizarMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarMedicoActionPerformed(evt);
            }
        });

        btnEliminarMedico.setText("Eliminar");
        btnEliminarMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarMedicoActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(IDMed);

        jLabel2.setText("ID :");

        jLabel4.setText("Nombre y Apellido:");

        jLabel5.setText("Especialidad :");

        jLabel6.setText("Telefono:");

        jScrollPane3.setViewportView(jTextNombreApellidoMed);

        jScrollPane6.setViewportView(jTextEspeciallidadMed);

        jScrollPane11.setViewportView(jTextTelfNew);

        jLabel9.setText("Nombre y Apellido:");

        jLabel10.setText("Especialidad :");

        jLabel11.setText("Telefono:");

        jScrollPane4.setViewportView(jTextNombreApellidoMedNew);

        jScrollPane14.setViewportView(jTextEspecialidadNew);

        jScrollPane15.setViewportView(jTextCMPNew);

        jLabel13.setText("CMP:");

        jLabel14.setText("CMP:");

        jScrollPane16.setViewportView(jTextTelef);

        TablaMedicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre y Apellidos", "Especialidad", "Telefono", "CMP"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane7.setViewportView(TablaMedicos);

        jScrollPane8.setViewportView(jTextCMP);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("MODULO MEDICOS");

        lblContadorMedicos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblContadorMedicos.setText("Medicos: 0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btnOrdenesRegistradas, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnImprimirRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(btnRegistrarOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel10))
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jLabel13)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(btnLimpiarCasillasRegistrar))
                                            .addComponent(lblContadorMedicos))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(6, 6, 6))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(jScrollPane16)
                                    .addComponent(jScrollPane8)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnLimpiarCasillasBuscarMed)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminarMedico)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnActualizarMedico))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBuscarOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegistrarOrden)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnActualizarMedico)
                            .addComponent(btnEliminarMedico)
                            .addComponent(btnLimpiarCasillasBuscarMed))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4))
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiarCasillasRegistrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblContadorMedicos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOrdenesRegistradas)
                    .addComponent(btnImprimirRegistros))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnOrdenesRegistradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenesRegistradasActionPerformed
        cargarMedicos();
    }//GEN-LAST:event_btnOrdenesRegistradasActionPerformed

    private void cargarMedicos() {
        modeloTablaMedicos.setRowCount(0);
        List<MedicoDTO> medicos = controller.listarTodos();
        for (MedicoDTO medico : medicos) {
            Object[] fila = {
                medico.getId_medico(),
                medico.getNombres() + " " + medico.getApellidos(),
                medico.getEspecialidad(),
                medico.getTelefono(),
                medico.getCmp()
            };
            modeloTablaMedicos.addRow(fila);
        }
    }

    private void btnImprimirRegistrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirRegistrosActionPerformed
        exportarMedicosPDF();
    }//GEN-LAST:event_btnImprimirRegistrosActionPerformed

    private void exportarMedicosPDF() {
        try {
            String nombreArchivo = "Medicos.pdf";
            File archivoPDF = new File(nombreArchivo);

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(archivoPDF));
            document.open();

            document.add(new Paragraph("Lista de Médicos actuales"));
            document.add(new Paragraph(" "));

            PdfPTable pdfTable = new PdfPTable(TablaMedicos.getColumnCount());

            for (int i = 0; i < TablaMedicos.getColumnCount(); i++) {
                pdfTable.addCell(TablaMedicos.getColumnName(i));
            }

            for (int rows = 0; rows < TablaMedicos.getRowCount(); rows++) {
                for (int cols = 0; cols < TablaMedicos.getColumnCount(); cols++) {
                    Object value = TablaMedicos.getValueAt(rows, cols);
                    pdfTable.addCell(value != null ? value.toString() : "");
                }
            }

            document.add(pdfTable);
            document.close();

            JOptionPane.showMessageDialog(this, "PDF generado exitosamente: " + nombreArchivo);

            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(archivoPDF);
            } else {
                JOptionPane.showMessageDialog(this, "No se puede abrir el PDF automáticamente en este sistema.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al generar PDF: " + e.getMessage());
        }
    }

    private void btnEliminarMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarMedicoActionPerformed
        eliminarMedico();
    }//GEN-LAST:event_btnEliminarMedicoActionPerformed

    private void eliminarMedico() {
        try {
            int id = Integer.parseInt(IDMed.getText().trim());
            if (controller.eliminarMedico(id)) {
                JOptionPane.showMessageDialog(this, "Médico eliminado exitosamente");
                limpiarCamposBuscar();
                cargarMedicos();
                actualizarContadorMedicos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar médico");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private void btnActualizarMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarMedicoActionPerformed
        actualizarMedico();
    }//GEN-LAST:event_btnActualizarMedicoActionPerformed

    private void actualizarMedico() {
        try {
            int id = Integer.parseInt(IDMed.getText().trim());
            String[] nombreApellido = jTextNombreApellidoMed.getText().trim().split(" ", 2);
            if (nombreApellido.length < 2) {
                throw new IllegalArgumentException("Debe ingresar nombre y apellido");
            }

            MedicoDTO dto = new MedicoDTO();
            dto.setId_medico(id);
            dto.setNombres(nombreApellido[0]);
            dto.setApellidos(nombreApellido[1]);
            dto.setEspecialidad(jTextEspeciallidadMed.getText().trim());
            dto.setTelefono(jTextTelef.getText().trim());
            dto.setCmp(jTextCMP.getText().trim());

            if (controller.actualizarMedico(dto)) {
                JOptionPane.showMessageDialog(this, "Médico actualizado exitosamente");
                limpiarCamposBuscar();
                cargarMedicos();
                actualizarContadorMedicos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar médico");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private void btnRegistrarOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarOrdenActionPerformed
        registrarMedico();
    }//GEN-LAST:event_btnRegistrarOrdenActionPerformed

    private void registrarMedico() {
        try {
            String[] nombreApellido = jTextNombreApellidoMedNew.getText().trim().split(" ", 2);
            if (nombreApellido.length < 2) {
                JOptionPane.showMessageDialog(this, "Debe ingresar nombre y apellido");
                return;
            }

            MedicoDTO dto = new MedicoDTO();
            dto.setNombres(nombreApellido[0]);
            dto.setApellidos(nombreApellido[1]);
            dto.setEspecialidad(jTextEspecialidadNew.getText().trim());
            dto.setTelefono(jTextTelfNew.getText().trim());
            dto.setCmp(jTextCMPNew.getText().trim());

            if (controller.registrarMedico(dto)) {
                JOptionPane.showMessageDialog(this, "Médico registrado exitosamente");
                cargarMedicos();
                limpiarCamposRegistrar();
                actualizarContadorMedicos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar médico");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private void btnBuscarOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarOrdenActionPerformed
        buscarMedicoPorId();
    }//GEN-LAST:event_btnBuscarOrdenActionPerformed

    private void buscarMedicoPorId() {
        try {
            int id = Integer.parseInt(IDMed.getText().trim());
            MedicoDTO medico = controller.buscarPorId(id);
            if (medico != null) {
                jTextNombreApellidoMed.setText(medico.getNombres() + " " + medico.getApellidos());
                jTextEspeciallidadMed.setText(medico.getEspecialidad());
                jTextTelef.setText(medico.getTelefono());
                jTextCMP.setText(medico.getCmp());
                JOptionPane.showMessageDialog(this, "Médico encontrado");
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró médico con ese ID");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private void btnLimpiarCasillasRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCasillasRegistrarActionPerformed
        limpiarCamposRegistrar();
    }//GEN-LAST:event_btnLimpiarCasillasRegistrarActionPerformed

    private void limpiarCamposRegistrar() {
        jTextNombreApellidoMedNew.setText("");
        jTextEspecialidadNew.setText("");
        jTextTelfNew.setText("");
        jTextCMPNew.setText("");
    }

    private void btnLimpiarCasillasBuscarMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCasillasBuscarMedActionPerformed
        limpiarCamposBuscar();
    }//GEN-LAST:event_btnLimpiarCasillasBuscarMedActionPerformed

    private void limpiarCamposBuscar() {
        IDMed.setText("");
        jTextNombreApellidoMed.setText("");
        jTextEspeciallidadMed.setText("");
        jTextTelef.setText("");
        jTextCMP.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane IDMed;
    private javax.swing.JTable TablaMedicos;
    private javax.swing.JButton btnActualizarMedico;
    private javax.swing.JButton btnBuscarOrden;
    private javax.swing.JButton btnEliminarMedico;
    private javax.swing.JButton btnImprimirRegistros;
    private javax.swing.JButton btnLimpiarCasillasBuscarMed;
    private javax.swing.JButton btnLimpiarCasillasRegistrar;
    private javax.swing.JButton btnOrdenesRegistradas;
    private javax.swing.JButton btnRegistrarOrden;
    private java.awt.Button button1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextPane jTextCMP;
    private javax.swing.JTextPane jTextCMPNew;
    private javax.swing.JTextPane jTextEspecialidadNew;
    private javax.swing.JTextPane jTextEspeciallidadMed;
    private javax.swing.JTextPane jTextNombreApellidoMed;
    private javax.swing.JTextPane jTextNombreApellidoMedNew;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextTelef;
    private javax.swing.JTextPane jTextTelfNew;
    private java.awt.Label label1;
    private javax.swing.JLabel lblContadorMedicos;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.Menu menu3;
    private java.awt.Menu menu4;
    private java.awt.MenuBar menuBar1;
    private java.awt.MenuBar menuBar2;
    // End of variables declaration//GEN-END:variables
}
