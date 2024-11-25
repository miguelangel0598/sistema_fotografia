/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Formularios;

import Controlador.ControladorCliente;

/**
 *
 * @author Angel
 */
public class FormularioClientes extends javax.swing.JInternalFrame {

    /**
     * Creates new form FormularioClientes
     */
    public FormularioClientes() {
        initComponents();
        Controlador.ControladorCliente objetoCliente = new Controlador.ControladorCliente();
        objetoCliente.MostrarClientes(tbclientes);
        objetoCliente.configurarCabeceraTablaClientes(tbclientes);
        txtidcliente.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnmodificarcliente = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtidcliente = new javax.swing.JTextField();
        txtnombrescliente = new javax.swing.JTextField();
        txtapellidoscliente = new javax.swing.JTextField();
        tbnlimpiarcampos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbclientes = new javax.swing.JTable();
        btnguardarcliente = new javax.swing.JButton();
        btneliminarcliente = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(179, 205, 232));
        setClosable(true);
        setIconifiable(true);
        setTitle("Clientes");

        btnmodificarcliente.setBackground(new java.awt.Color(167, 233, 255));
        btnmodificarcliente.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnmodificarcliente.setForeground(new java.awt.Color(26, 62, 89));
        btnmodificarcliente.setText("Modificar");
        btnmodificarcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarclienteActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(217, 230, 242));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 25), new java.awt.Color(26, 62, 89))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(26, 62, 89));
        jLabel1.setText("ID");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(26, 62, 89));
        jLabel2.setText("Nombres");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(26, 62, 89));
        jLabel3.setText("Apellidos");

        tbnlimpiarcampos.setBackground(new java.awt.Color(167, 233, 255));
        tbnlimpiarcampos.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        tbnlimpiarcampos.setForeground(new java.awt.Color(26, 62, 89));
        tbnlimpiarcampos.setText("Limpiar Campos");
        tbnlimpiarcampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnlimpiarcamposActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tbnlimpiarcampos)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtnombrescliente, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtapellidoscliente, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(184, 184, 184)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnombrescliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtapellidoscliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(tbnlimpiarcampos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbclientes.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        tbclientes.setForeground(new java.awt.Color(26, 62, 89));
        tbclientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbclientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbclientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbclientes);

        btnguardarcliente.setBackground(new java.awt.Color(167, 233, 255));
        btnguardarcliente.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnguardarcliente.setForeground(new java.awt.Color(26, 62, 89));
        btnguardarcliente.setText("Guardar");
        btnguardarcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarclienteActionPerformed(evt);
            }
        });

        btneliminarcliente.setBackground(new java.awt.Color(255, 152, 152));
        btneliminarcliente.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btneliminarcliente.setForeground(new java.awt.Color(26, 62, 89));
        btneliminarcliente.setText("Eliminar");
        btneliminarcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarclienteActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(26, 62, 89));
        jLabel4.setText("Seleccionar para modificar o eliminar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnguardarcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(188, 188, 188)
                        .addComponent(btnmodificarcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 236, Short.MAX_VALUE)
                        .addComponent(btneliminarcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(28, 28, 28))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(132, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnmodificarcliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnguardarcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btneliminarcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(108, 108, 108))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(469, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarclienteActionPerformed
Controlador.ControladorCliente objetoCliente = new ControladorCliente();
objetoCliente.AgregarCliente(txtnombrescliente, txtapellidoscliente);
objetoCliente.MostrarClientes(tbclientes);
objetoCliente.limpiarCamposClientes(txtidcliente, txtnombrescliente, txtapellidoscliente);// TODO add your handling code here:
    }//GEN-LAST:event_btnguardarclienteActionPerformed

    private void tbclientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbclientesMouseClicked
      Controlador.ControladorCliente objetoCliente = new ControladorCliente();
      objetoCliente.Seleccionar(tbclientes, txtidcliente, txtnombrescliente, txtapellidoscliente);// TODO add your handling code here:
    }//GEN-LAST:event_tbclientesMouseClicked

    private void btnmodificarclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarclienteActionPerformed
     Controlador.ControladorCliente objetoCliente = new ControladorCliente();
     objetoCliente.ModificarCliente(txtidcliente, txtnombrescliente, txtapellidoscliente);
    objetoCliente.MostrarClientes(tbclientes);
objetoCliente.limpiarCamposClientes(txtidcliente, txtnombrescliente, txtapellidoscliente);// TODO add your handling code here:
    }//GEN-LAST:event_btnmodificarclienteActionPerformed

    private void tbnlimpiarcamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnlimpiarcamposActionPerformed
        Controlador.ControladorCliente objetoCliente = new ControladorCliente();
        objetoCliente.limpiarCamposClientes(txtidcliente, txtnombrescliente, txtapellidoscliente);        // TODO add your handling code here:
    }//GEN-LAST:event_tbnlimpiarcamposActionPerformed

    private void btneliminarclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarclienteActionPerformed
      Controlador.ControladorCliente objetoCliente = new ControladorCliente();
     objetoCliente.EliminarClientes(txtidcliente);
    objetoCliente.MostrarClientes(tbclientes);
objetoCliente.limpiarCamposClientes(txtidcliente, txtnombrescliente, txtapellidoscliente);  // TODO add your handling code here:
    }//GEN-LAST:event_btneliminarclienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btneliminarcliente;
    private javax.swing.JButton btnguardarcliente;
    private javax.swing.JButton btnmodificarcliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbclientes;
    private javax.swing.JButton tbnlimpiarcampos;
    private javax.swing.JTextField txtapellidoscliente;
    private javax.swing.JTextField txtidcliente;
    private javax.swing.JTextField txtnombrescliente;
    // End of variables declaration//GEN-END:variables
}
