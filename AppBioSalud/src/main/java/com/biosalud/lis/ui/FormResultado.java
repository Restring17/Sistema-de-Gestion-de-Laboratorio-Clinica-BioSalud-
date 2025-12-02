/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.biosalud.lis.ui;

import com.biosalud.lis.controller.ResultadoController;
import com.biosalud.lis.model.ResultadoLaboratorio;
import java.time.LocalDateTime;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author folli
 */
public class FormResultado extends javax.swing.JPanel {

    /**
     * Creates new form FormResultado
     */
    private final DefaultTableModel mDefaultTableModel;
    private ResultadoController controller = new ResultadoController();

    public FormResultado() {
        initComponents();

        mDefaultTableModel = new DefaultTableModel();
        mDefaultTableModel.addColumn("ID RESULTADO");
        mDefaultTableModel.addColumn("ID ORDEN");
        mDefaultTableModel.addColumn("ESTADO");
        mDefaultTableModel.addColumn("FECHA_HORA");
        mDefaultTableModel.addColumn("DESCRIPCION");
        mDefaultTableModel.addColumn("VALORES");
        mDefaultTableModel.addColumn("CONCLUSIONES");
    }

    private void limpiarResultado() {
        IDResultado.setText("");
        idOrden.setText("");
        FechaResultado.setText("");
        AreaDescripcion.setText("");
        AreaValoresResultado.setText("");
        Conclusiones.setText("");
    }

    private ResultadoLaboratorio obtenerResultadoDesdeFormulario() {
        ResultadoLaboratorio r = new ResultadoLaboratorio();

        if (!IDResultado.getText().isEmpty()) {
            r.setIdResultado(Integer.parseInt(IDResultado.getText()));
        }

        r.setIdOrden(Integer.parseInt(idOrden.getText()));
        r.setFechaResultado(LocalDateTime.parse(FechaResultado.getText()));
        r.setDescripcion(AreaDescripcion.getText());
        r.setValoresJson(AreaValoresResultado.getText());
        r.setConclusiones(Conclusiones.getText());
        r.setValidado(false);

        return r;
    }

    private void cargarResultadoEnFormulario(ResultadoLaboratorio r) {
        IDResultado.setText(String.valueOf(r.getIdResultado()));
        idOrden.setText(String.valueOf(r.getIdOrden()));
        FechaResultado.setText(String.valueOf(r.getFechaResultado()));
        AreaDescripcion.setText(r.getDescripcion());
        AreaValoresResultado.setText(r.getValoresJson());
        Conclusiones.setText(r.getConclusiones());
    }

    private void registrarResultado() {
        try {
            ResultadoLaboratorio r = obtenerResultadoDesdeFormulario();

            boolean ok = controller.registrar(r);

            if (ok) {
                JOptionPane.showMessageDialog(this, "Resultado registrado correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Datos inválidos: " + e.getMessage());
        }
    }

    private void actualizarResultado() {
        ResultadoLaboratorio r = obtenerResultadoDesdeFormulario();

        boolean ok = controller.actualizar(r);

        if (ok) {
            JOptionPane.showMessageDialog(this, "Resultado actualizado.");
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo actualizar.");
        }
    }

    private void eliminarResultado() {
        if (IDResultado.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un ID primero.");
            return;
        }

        int id = Integer.parseInt(IDResultado.getText());

        boolean ok = controller.eliminar(id);

        if (ok) {
            JOptionPane.showMessageDialog(this, "Resultado eliminado.");
            limpiarResultado();
        } else {
            JOptionPane.showMessageDialog(this, "Error al eliminar.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscarResultado() {
        if (IDResultado.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un ID.");
            return;
        }

        int id = Integer.parseInt(IDResultado.getText());

        ResultadoLaboratorio r = controller.buscarPorId(id);

        if (r != null) {
            cargarResultadoEnFormulario(r);
            JOptionPane.showMessageDialog(this, "Resultado encontrado.");
        } else {
            JOptionPane.showMessageDialog(this, "No existe este resultado.");
        }
    }

    private void cargarResultados() {
        ResultadoController controller = new ResultadoController();
        List<ResultadoLaboratorio> lista = controller.listar();

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{
            "ID Resultado", "ID Orden", "Fecha", "Descripción", "Valores", "Conclusiones", "Validado"
        });

        for (ResultadoLaboratorio r : lista) {
            model.addRow(new Object[]{
                r.getIdResultado(),
                r.getIdOrden(),
                r.getFechaResultado(),
                r.getDescripcion(),
                r.getValoresJson(),
                r.getConclusiones(),
                r.isValidado() ? "Sí" : "No"
            });
        }

        TablaResultados.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnIngresarMuestra = new javax.swing.JButton();
        btnBuscarMuestra = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
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
        btnImprimir = new javax.swing.JButton();
        jDialog1 = new javax.swing.JDialog();
        jMenu1 = new javax.swing.JMenu();
        jOptionPane1 = new javax.swing.JOptionPane();
        jScrollPane9 = new javax.swing.JScrollPane();
        tbOrdenes = new javax.swing.JTextArea();
        jScrollPane10 = new javax.swing.JScrollPane();
        tbOrdenes1 = new javax.swing.JTextArea();
        btnOrdenesRegistradas = new javax.swing.JButton();
        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        btnRegistrarResultado = new javax.swing.JButton();
        btnBuscarResultado = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        FechaResultado = new javax.swing.JTextPane();
        btnActualizarResultado = new javax.swing.JButton();
        jScrollPane18 = new javax.swing.JScrollPane();
        IDResultado = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        AreaDescripcion = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        AreaValoresResultado = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        btnImprimirResultado = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane20 = new javax.swing.JScrollPane();
        Conclusiones = new javax.swing.JTextPane();
        idOrden = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaResultados = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        btnBuscarResultado1 = new javax.swing.JButton();
        btnListarResultados = new javax.swing.JButton();
        limpiar = new javax.swing.JButton();

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("Modulo de Medicos");

        btnIngresarMuestra.setText("Ingresar ");

        btnBuscarMuestra.setText("Buscar ");
        btnBuscarMuestra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarMuestraActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
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

        jLabel11.setText("Orden:");

        jLabel13.setText("Tecnico responsable:");

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

        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(15, 15, 15))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                            .addComponent(jScrollPane14))
                        .addGap(61, 61, 61)
                        .addComponent(btnBuscarMuestra)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarMuestra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(68, 68, 68))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ComboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OrdenMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnLimpiar)
                                .addGap(24, 24, 24))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnIngresarMuestra)
                                .addGap(19, 19, 19)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnImprimir)
                            .addComponent(btnActualizarMuestra1))
                        .addGap(62, 62, 62))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(217, 217, 217))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminarMuestra)
                            .addComponent(btnBuscarMuestra))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnIngresarMuestra)
                            .addComponent(btnActualizarMuestra1))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLimpiar)
                            .addComponent(btnImprimir))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OrdenMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

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

        jMenu1.setText("jMenu1");

        tbOrdenes.setColumns(20);
        tbOrdenes.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        tbOrdenes.setRows(5);
        jScrollPane9.setViewportView(tbOrdenes);

        tbOrdenes1.setColumns(20);
        tbOrdenes1.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        tbOrdenes1.setRows(5);
        jScrollPane10.setViewportView(tbOrdenes1);

        btnOrdenesRegistradas.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        btnOrdenesRegistradas.setText("Lista de Medicos actuales");
        btnOrdenesRegistradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenesRegistradasActionPerformed(evt);
            }
        });

        jMenuItem1.setText("jMenuItem1");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setText("Modulo de Resultados");

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        btnRegistrarResultado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRegistrarResultado.setText("Registrar Resultado");
        btnRegistrarResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarResultadoActionPerformed(evt);
            }
        });

        btnBuscarResultado.setText("Buscar ");
        btnBuscarResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarResultadoActionPerformed(evt);
            }
        });

        jLabel12.setText("ID Orden:");

        jLabel4.setText("ID Resultado :");

        jLabel14.setText("Fecha:");

        jLabel16.setText("Conclusiones:");

        jScrollPane17.setViewportView(FechaResultado);

        btnActualizarResultado.setText("Actualizar");
        btnActualizarResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarResultadoActionPerformed(evt);
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

        btnImprimirResultado.setText("Imprimir");
        btnImprimirResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirResultadoActionPerformed(evt);
            }
        });

        jLabel17.setText("Valores del resultado:");

        jScrollPane20.setViewportView(Conclusiones);

        jLabel7.setText("Lista de Resultados:");

        TablaResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Orden", "Fecha", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TablaResultados.setToolTipText("");
        jScrollPane3.setViewportView(TablaResultados);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Gestor de resultados");

        btnBuscarResultado1.setText("Eliminar");
        btnBuscarResultado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarResultado1ActionPerformed(evt);
            }
        });

        btnListarResultados.setText("Listar");
        btnListarResultados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarResultadosActionPerformed(evt);
            }
        });

        limpiar.setText("Limpiar");
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel14))
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBuscarResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(idOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnActualizarResultado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnBuscarResultado1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jScrollPane20)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel15)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnRegistrarResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnListarResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnImprimirResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)))))
                .addGap(274, 274, 274))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnBuscarResultado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnActualizarResultado)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(limpiar)
                                    .addComponent(btnRegistrarResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscarResultado1)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnImprimirResultado))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(btnListarResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jScrollPane4.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarMuestraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarMuestraActionPerformed
    }//GEN-LAST:event_btnBuscarMuestraActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEliminarMuestraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarMuestraActionPerformed
    }//GEN-LAST:event_btnEliminarMuestraActionPerformed

    private void ComboTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboTipoActionPerformed

    }//GEN-LAST:event_ComboTipoActionPerformed

    private void btnActualizarMuestra1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarMuestra1ActionPerformed
    }//GEN-LAST:event_btnActualizarMuestra1ActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnBuscarResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarResultadoActionPerformed
        buscarResultado();
    }//GEN-LAST:event_btnBuscarResultadoActionPerformed

    private void btnActualizarResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarResultadoActionPerformed
        actualizarResultado();
    }//GEN-LAST:event_btnActualizarResultadoActionPerformed

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

            // Títulos
            com.lowagie.text.Font titleFont = new com.lowagie.text.Font(com.lowagie.text.Font.HELVETICA, 20, com.lowagie.text.Font.BOLD);
            com.lowagie.text.Font normalFont = new com.lowagie.text.Font(com.lowagie.text.Font.HELVETICA, 12);

            pdf.add(new com.lowagie.text.Paragraph("REPORTE DE RESULTADO DE LABORATORIO", titleFont));
            pdf.add(new com.lowagie.text.Paragraph(" "));

            // Datos principales
            pdf.add(new com.lowagie.text.Paragraph("ID Resultado: " + r.getIdResultado(), normalFont));
            pdf.add(new com.lowagie.text.Paragraph("Fecha: " + r.getFechaResultado().toString(), normalFont));
            pdf.add(new com.lowagie.text.Paragraph("ID Orden: " + r.getIdOrden(), normalFont));
            pdf.add(new com.lowagie.text.Paragraph("Validado: " + (r.isValidado() ? "Sí" : "No"), normalFont));
            pdf.add(new com.lowagie.text.Paragraph(" "));

            // Descripción
            pdf.add(new com.lowagie.text.Paragraph("Descripción:", titleFont));
            pdf.add(new com.lowagie.text.Paragraph(r.getDescripcion(), normalFont));
            pdf.add(new com.lowagie.text.Paragraph(" "));

            // Valores (JSON)
            pdf.add(new com.lowagie.text.Paragraph("Valores:", titleFont));
            pdf.add(new com.lowagie.text.Paragraph(r.getValoresJson(), normalFont));
            pdf.add(new com.lowagie.text.Paragraph(" "));

            // Conclusiones
            pdf.add(new com.lowagie.text.Paragraph("Conclusiones:", titleFont));
            pdf.add(new com.lowagie.text.Paragraph(r.getConclusiones(), normalFont));
            pdf.add(new com.lowagie.text.Paragraph(" "));

            pdf.close();

            JOptionPane.showMessageDialog(this, "PDF generado:\n" + fileName);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ERROR al generar PDF: " + e.getMessage());
        }
    }//GEN-LAST:event_btnImprimirResultadoActionPerformed

    private void btnOrdenesRegistradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenesRegistradasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOrdenesRegistradasActionPerformed

    private void btnBuscarResultado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarResultado1ActionPerformed
        eliminarResultado();
    }//GEN-LAST:event_btnBuscarResultado1ActionPerformed

    private void btnRegistrarResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarResultadoActionPerformed
        registrarResultado();
    }//GEN-LAST:event_btnRegistrarResultadoActionPerformed

    private void btnListarResultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarResultadosActionPerformed
       cargarResultados();
    }//GEN-LAST:event_btnListarResultadosActionPerformed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        limpiarResultado();
    }//GEN-LAST:event_limpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AreaDescripcion;
    private javax.swing.JTextArea AreaValoresResultado;
    private javax.swing.JComboBox<String> ComboTipo;
    private javax.swing.JTextPane Conclusiones;
    private javax.swing.JTextPane FechaMuestra;
    private javax.swing.JTextPane FechaResultado;
    private javax.swing.JTextPane IDMuestra;
    private javax.swing.JTextPane IDResultado;
    private javax.swing.JScrollPane OrdenMedico;
    private javax.swing.JTextPane OrdenMuestra;
    private javax.swing.JTextPane OrdenTecnico;
    private javax.swing.JTable TablaResultados;
    private javax.swing.JButton btnActualizarMuestra1;
    private javax.swing.JButton btnActualizarResultado;
    private javax.swing.JButton btnBuscarMuestra;
    private javax.swing.JButton btnBuscarResultado;
    private javax.swing.JButton btnBuscarResultado1;
    private javax.swing.JButton btnEliminarMuestra;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnImprimirResultado;
    private javax.swing.JButton btnIngresarMuestra;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnListarResultados;
    private javax.swing.JButton btnOrdenesRegistradas;
    private javax.swing.JButton btnRegistrarResultado;
    private javax.swing.JTextField idOrden;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JButton limpiar;
    private javax.swing.JTextArea tbOrdenes;
    private javax.swing.JTextArea tbOrdenes1;
    // End of variables declaration//GEN-END:variables
}
