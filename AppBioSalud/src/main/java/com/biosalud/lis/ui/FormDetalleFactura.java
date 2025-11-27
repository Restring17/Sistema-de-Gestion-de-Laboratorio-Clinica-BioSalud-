package com.biosalud.lis.ui;

public class FormDetalleFactura extends javax.swing.JPanel{

    public FormDetalleFactura() {
        initComponents();
        
        
    }
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Btn_Regresar = new javax.swing.JButton();
        Btn_DescargarFactura = new javax.swing.JButton();
        Titulo_Factura2 = new javax.swing.JLabel();
        Facturas = new javax.swing.JScrollPane();
        Tabla_Facturas2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        DNIinfo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        IDFacturainfo = new javax.swing.JTextField();
        Btn_Buscar = new javax.swing.JToggleButton();

        Btn_Regresar.setText("Regresar");
        Btn_Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_RegresarActionPerformed(evt);
            }
        });

        Btn_DescargarFactura.setText("Descargar PDF");
        Btn_DescargarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_DescargarFacturaActionPerformed(evt);
            }
        });

        Titulo_Factura2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Titulo_Factura2.setText("Modulo Detalle Factura");

        Tabla_Facturas2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID_Factura", "DNI", "Fecha", "Metodo De Pago", "MontoTotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Facturas.setViewportView(Tabla_Facturas2);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Factura"));

        jLabel1.setText("Ingrese DNI:");

        DNIinfo.setText("DNI del Paciente");

        jLabel2.setText("Ingrese ID Factura:");

        IDFacturainfo.setText("ID Factura");

        Btn_Buscar.setText("Buscar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DNIinfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(IDFacturainfo, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(Btn_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DNIinfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(IDFacturainfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_Buscar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Facturas)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(Titulo_Factura2)))
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Btn_Regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(Btn_DescargarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(Titulo_Factura2)
                .addGap(35, 35, 35)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(Facturas, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_Regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_DescargarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_DescargarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_DescargarFacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_DescargarFacturaActionPerformed

    private void Btn_RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_RegresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_RegresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Btn_Buscar;
    public javax.swing.JButton Btn_DescargarFactura;
    public javax.swing.JButton Btn_Regresar;
    private javax.swing.JTextField DNIinfo;
    public javax.swing.JScrollPane Facturas;
    private javax.swing.JTextField IDFacturainfo;
    public javax.swing.JTable Tabla_Facturas2;
    public javax.swing.JLabel Titulo_Factura2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
