/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.biosalud.lis.ui;

import com.biosalud.lis.controller.PacienteController;
import com.biosalud.lis.dto.PacienteDTO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author folli
 */
public class FormPacienteCRUD extends javax.swing.JPanel {

    private final PacienteController controller;
    private DefaultTableModel modeloTabla;
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * Creates new form FormPacienteCRUD
     */
    public FormPacienteCRUD() {
        initComponents();
        controller = new PacienteController();
        configurarTabla();
        cargarPacientes();
        actualizarContadorPacientes();
    }

    private void configurarTabla() {
        modeloTabla = new DefaultTableModel(
            new Object[][] {},
            new String[] {"ID", "DNI", "Nombres", "Apellidos", "Fecha Nac.", "Teléfono", "Email"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Tabla de solo lectura
            }
        };
        tblPacientes.setModel(modeloTabla);
        
        // Ajustar ancho de columnas
        tblPacientes.getColumnModel().getColumn(0).setPreferredWidth(40);  // ID
        tblPacientes.getColumnModel().getColumn(1).setPreferredWidth(80);  // DNI
        tblPacientes.getColumnModel().getColumn(2).setPreferredWidth(120); // Nombres
        tblPacientes.getColumnModel().getColumn(3).setPreferredWidth(120); // Apellidos
        tblPacientes.getColumnModel().getColumn(4).setPreferredWidth(90);  // Fecha
        tblPacientes.getColumnModel().getColumn(5).setPreferredWidth(90);  // Teléfono
        tblPacientes.getColumnModel().getColumn(6).setPreferredWidth(150); // Email
        
        // Agregar listener para selección de fila
        tblPacientes.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                cargarDatosFilaSeleccionada();
            }
        });
    }

    private void cargarDatosFilaSeleccionada() {
        int filaSeleccionada = tblPacientes.getSelectedRow();
        if (filaSeleccionada >= 0) {
            txtId.setText(tblPacientes.getValueAt(filaSeleccionada, 0).toString());
            txtDni.setText(tblPacientes.getValueAt(filaSeleccionada, 1).toString());
            txtNombres.setText(tblPacientes.getValueAt(filaSeleccionada, 2).toString());
            txtApellidos.setText(tblPacientes.getValueAt(filaSeleccionada, 3).toString());
            txtFechaNacimiento.setText(tblPacientes.getValueAt(filaSeleccionada, 4).toString());
            txtTelefono.setText(tblPacientes.getValueAt(filaSeleccionada, 5).toString());
            txtEmail.setText(tblPacientes.getValueAt(filaSeleccionada, 6).toString());
        }
    }

    private void cargarPacientes() {
        modeloTabla.setRowCount(0);
        List<PacienteDTO> pacientes = controller.listarTodos();
        
        for (PacienteDTO paciente : pacientes) {
            Object[] fila = {
                paciente.getIdPaciente(),
                paciente.getDni(),
                paciente.getNombres(),
                paciente.getApellidos(),
                paciente.getFechaNacimiento() != null ? 
                    paciente.getFechaNacimiento().format(dateFormatter) : "",
                paciente.getTelefono(),
                paciente.getEmail()
            };
            modeloTabla.addRow(fila);
        }
    }

    private void actualizarContadorPacientes() {
        int total = controller.contarPacientes();
        lblContadorPacientes.setText("Pacientes: " + total);
    }

    private void registrarPaciente() {
        try {
            // Validar campos obligatorios
            if (txtDni.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "El DNI es obligatorio", 
                    "Error de Validación", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txtNombres.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "El nombre es obligatorio", 
                    "Error de Validación", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txtApellidos.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "El apellido es obligatorio", 
                    "Error de Validación", JOptionPane.ERROR_MESSAGE);
                return;
            }

            PacienteDTO dto = new PacienteDTO();
            dto.setDni(txtDni.getText().trim());
            dto.setNombres(txtNombres.getText().trim());
            dto.setApellidos(txtApellidos.getText().trim());
            
            // Parsear fecha
            if (!txtFechaNacimiento.getText().trim().isEmpty()) {
                try {
                    LocalDate fecha = LocalDate.parse(txtFechaNacimiento.getText().trim(), dateFormatter);
                    dto.setFechaNacimiento(fecha);
                } catch (DateTimeParseException e) {
                    JOptionPane.showMessageDialog(this, 
                        "Formato de fecha inválido. Use dd/MM/yyyy", 
                        "Error de Validación", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            
            dto.setTelefono(txtTelefono.getText().trim());
            dto.setEmail(txtEmail.getText().trim());

            if (controller.registrarPaciente(dto)) {
                JOptionPane.showMessageDialog(this, "Paciente registrado exitosamente", 
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
                cargarPacientes();
                actualizarContadorPacientes();
            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar el paciente", 
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarPaciente() {
        try {
            if (txtId.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                    "Seleccione un paciente de la tabla para actualizar", 
                    "Error de Validación", JOptionPane.ERROR_MESSAGE);
                return;
            }

            PacienteDTO dto = new PacienteDTO();
            dto.setIdPaciente(Integer.parseInt(txtId.getText().trim()));
            dto.setDni(txtDni.getText().trim());
            dto.setNombres(txtNombres.getText().trim());
            dto.setApellidos(txtApellidos.getText().trim());
            
            // Parsear fecha
            if (!txtFechaNacimiento.getText().trim().isEmpty()) {
                try {
                    LocalDate fecha = LocalDate.parse(txtFechaNacimiento.getText().trim(), dateFormatter);
                    dto.setFechaNacimiento(fecha);
                } catch (DateTimeParseException e) {
                    JOptionPane.showMessageDialog(this, 
                        "Formato de fecha inválido. Use dd/MM/yyyy", 
                        "Error de Validación", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            
            dto.setTelefono(txtTelefono.getText().trim());
            dto.setEmail(txtEmail.getText().trim());

            if (controller.actualizarPaciente(dto)) {
                JOptionPane.showMessageDialog(this, "Paciente actualizado exitosamente", 
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
                cargarPacientes();
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar el paciente", 
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscarPaciente() {
        String dni = txtDni.getText().trim();
        String apellidos = txtApellidos.getText().trim();

        if (dni.isEmpty() && apellidos.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Ingrese DNI o Apellidos para buscar", 
                "Error de Validación", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Buscar por DNI si está lleno
        if (!dni.isEmpty()) {
            PacienteDTO paciente = controller.buscarPorDni(dni);
            if (paciente != null) {
                txtId.setText(paciente.getIdPaciente().toString());
                txtDni.setText(paciente.getDni());
                txtNombres.setText(paciente.getNombres());
                txtApellidos.setText(paciente.getApellidos());
                txtFechaNacimiento.setText(paciente.getFechaNacimiento() != null ? 
                    paciente.getFechaNacimiento().format(dateFormatter) : "");
                txtTelefono.setText(paciente.getTelefono());
                txtEmail.setText(paciente.getEmail());
                
                JOptionPane.showMessageDialog(this, "Paciente encontrado", 
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró paciente con ese DNI", 
                    "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        } 
        // Buscar por apellidos
        else if (!apellidos.isEmpty()) {
            List<PacienteDTO> pacientes = controller.buscarPorApellidos(apellidos);
            if (!pacientes.isEmpty()) {
                modeloTabla.setRowCount(0);
                for (PacienteDTO paciente : pacientes) {
                    Object[] fila = {
                        paciente.getIdPaciente(),
                        paciente.getDni(),
                        paciente.getNombres(),
                        paciente.getApellidos(),
                        paciente.getFechaNacimiento() != null ? 
                            paciente.getFechaNacimiento().format(dateFormatter) : "",
                        paciente.getTelefono(),
                        paciente.getEmail()
                    };
                    modeloTabla.addRow(fila);
                }
                JOptionPane.showMessageDialog(this, 
                    "Se encontraron " + pacientes.size() + " paciente(s)", 
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, 
                    "No se encontraron pacientes con esos apellidos", 
                    "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private void limpiarCampos() {
        txtId.setText("");
        txtDni.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
        txtFechaNacimiento.setText("");
        txtTelefono.setText("");
        txtEmail.setText("");
        tblPacientes.clearSelection();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtFechaNacimiento = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        lblContadorPacientes = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPacientes = new javax.swing.JTable();

        lblTitulo.setBackground(new java.awt.Color(255, 255, 255));
        lblTitulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblTitulo.setText("Módulo de Pacientes");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Paciente"));

        jLabel2.setText("ID:");

        jLabel3.setText("DNI:");

        jLabel4.setText("Nombres:");

        jLabel5.setText("Apellidos:");

        jLabel6.setText("Fecha Nac. (dd/MM/yyyy):");

        jLabel7.setText("Teléfono:");

        jLabel8.setText("Email:");

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
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
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombres)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTelefono)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnRegistrar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        btnRegistrar.setText("Registrar Paciente");
        btnRegistrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        btnActualizar.setText("Actualizar Datos");
        btnActualizar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        btnBuscar.setText("Buscar Paciente");
        btnBuscar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        btnLimpiar.setText("Limpiar Entradas");
        btnLimpiar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        lblContadorPacientes.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblContadorPacientes.setText("Pacientes: 0");

        tblPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DNI", "Nombres", "Apellidos", "Fecha Nac.", "Teléfono", "Email"
            }
        ));
        jScrollPane1.setViewportView(tblPacientes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(88, 88, 88)
                .addComponent(lblContadorPacientes)
                .addGap(141, 141, 141))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblContadorPacientes))
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        registrarPaciente();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        actualizarPaciente();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarPaciente();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarCampos();
        cargarPacientes();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblContadorPacientes;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblPacientes;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFechaNacimiento;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
