/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Formularios;

/**
 *
 * @author Angel
 */
public class FormularioServicios extends javax.swing.JInternalFrame {

    /**
     * Creates new form FormularioProducto
     */
    public FormularioServicios() {
        initComponents();
        Controlador .ControladorServicios objetoServicios= new Controlador.ControladorServicios();
        objetoServicios.MostrarServicios(tbservicios); 
        objetoServicios.ajustarAnchoColumnasServicios(tbservicios);
        objetoServicios.configurarCabeceraTablaServicios(tbservicios);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtidservicio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtservicio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtplan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtprecioservicio = new javax.swing.JTextField();
        tbnlimpiarcamposservicios = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbservicios = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        btnguardarservicios = new javax.swing.JButton();
        btnmodificarservicios = new javax.swing.JButton();
        btneliminarservicios = new javax.swing.JButton();

        setBackground(new java.awt.Color(179, 205, 232));
        setClosable(true);
        setIconifiable(true);
        setTitle("Planes");

        jPanel1.setBackground(new java.awt.Color(179, 205, 232));

        jPanel2.setBackground(new java.awt.Color(217, 230, 242));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos servicios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18), new java.awt.Color(26, 62, 89))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(26, 62, 89));
        jLabel1.setText("ID Servicio");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(26, 62, 89));
        jLabel2.setText("Servicio");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(26, 62, 89));
        jLabel3.setText("Plan");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(26, 62, 89));
        jLabel4.setText("Precio");

        tbnlimpiarcamposservicios.setBackground(new java.awt.Color(255, 152, 152));
        tbnlimpiarcamposservicios.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        tbnlimpiarcamposservicios.setForeground(new java.awt.Color(26, 62, 89));
        tbnlimpiarcamposservicios.setText("Limpiar Campos");
        tbnlimpiarcamposservicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnlimpiarcamposserviciosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tbnlimpiarcamposservicios)
                        .addGap(688, 688, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtidservicio, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtservicio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtplan, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtprecioservicio, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtidservicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtservicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtplan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtprecioservicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(tbnlimpiarcamposservicios)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbservicios.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        tbservicios.setForeground(new java.awt.Color(26, 62, 89));
        tbservicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbservicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbserviciosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbservicios);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(26, 62, 89));
        jLabel5.setText("CLICK PARA SELECCIONAR");

        btnguardarservicios.setBackground(new java.awt.Color(167, 233, 255));
        btnguardarservicios.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnguardarservicios.setForeground(new java.awt.Color(26, 62, 89));
        btnguardarservicios.setText("Guardar");
        btnguardarservicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarserviciosActionPerformed(evt);
            }
        });

        btnmodificarservicios.setBackground(new java.awt.Color(167, 233, 255));
        btnmodificarservicios.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnmodificarservicios.setForeground(new java.awt.Color(26, 62, 89));
        btnmodificarservicios.setText("Modificar");
        btnmodificarservicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarserviciosActionPerformed(evt);
            }
        });

        btneliminarservicios.setBackground(new java.awt.Color(255, 152, 152));
        btneliminarservicios.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btneliminarservicios.setForeground(new java.awt.Color(26, 62, 89));
        btneliminarservicios.setText("Eliminar");
        btneliminarservicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarserviciosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(33, 33, 33))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnguardarservicios, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(198, 198, 198)
                                .addComponent(btnmodificarservicios, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(211, 211, 211)
                                .addComponent(btneliminarservicios, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 859, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(15, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnguardarservicios, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnmodificarservicios, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btneliminarservicios, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarserviciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarserviciosActionPerformed
Controlador.ControladorServicios objetoServicios = new Controlador.ControladorServicios();
        objetoServicios.AgregarServicio(txtservicio, txtplan, txtprecioservicio);
        objetoServicios.MostrarServicios(tbservicios);  
        objetoServicios.limpiarCamposServicios(txtidservicio, txtservicio, txtplan, txtprecioservicio);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnguardarserviciosActionPerformed

    private void tbserviciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbserviciosMouseClicked
Controlador.ControladorServicios objetoServicios = new Controlador.ControladorServicios();
objetoServicios.SeleccionarServicio(tbservicios, txtidservicio, txtservicio, txtplan, txtprecioservicio);        // TODO add your handling code here:
    }//GEN-LAST:event_tbserviciosMouseClicked

    private void btnmodificarserviciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarserviciosActionPerformed
Controlador.ControladorServicios objetoServicios = new Controlador.ControladorServicios();
        objetoServicios.ModificarServicio(txtidservicio,txtservicio, txtplan, txtprecioservicio);
        objetoServicios.MostrarServicios(tbservicios);    
        objetoServicios.limpiarCamposServicios(txtidservicio, txtservicio, txtplan, txtprecioservicio);// TODO add your handling code here:
    }//GEN-LAST:event_btnmodificarserviciosActionPerformed

    private void tbnlimpiarcamposserviciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnlimpiarcamposserviciosActionPerformed
    Controlador.ControladorServicios objetoServicios = new Controlador.ControladorServicios();
        objetoServicios.limpiarCamposServicios(txtidservicio, txtservicio, txtplan, txtprecioservicio);        // TODO add your handling code here:
    }//GEN-LAST:event_tbnlimpiarcamposserviciosActionPerformed

    private void btneliminarserviciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarserviciosActionPerformed
Controlador.ControladorServicios objetoServicios = new Controlador.ControladorServicios();
        objetoServicios.EliminarServicios(txtidservicio);
        objetoServicios.MostrarServicios(tbservicios);
        objetoServicios.limpiarCamposServicios(txtidservicio, txtservicio, txtplan, txtprecioservicio);        // TODO add your handling code here:
    }//GEN-LAST:event_btneliminarserviciosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btneliminarservicios;
    private javax.swing.JButton btnguardarservicios;
    private javax.swing.JButton btnmodificarservicios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton tbnlimpiarcamposservicios;
    private javax.swing.JTable tbservicios;
    private javax.swing.JTextField txtidservicio;
    private javax.swing.JTextField txtplan;
    private javax.swing.JTextField txtprecioservicio;
    private javax.swing.JTextField txtservicio;
    // End of variables declaration//GEN-END:variables
}
