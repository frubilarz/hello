package cl.codo.fernando.gui;


import cl.codo.fernando.modelo.Empresa;
import cl.codo.fernando.modelo.Boleta;
import cl.codo.fernando.servicio.ServicioDB;
import cl.codo.fernando.utils.FechaUtils;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernando
 */
public class Guardado extends javax.swing.JFrame {
    public void Nletras(JTextField a) {
        a.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
    }
    /**
     * Creates new form Guardado
     */Integer a=0;
    public Guardado() {
        
        initComponents();
        Nletras(idboleta);
    }
    String factoring(int f)
    {
        if(f==1)
            return "BCI";
        if (f==2)
            return "Yakora";
        if(f==3)
            return "LYM";
        return null;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        fecha_emicion = new javax.swing.JLabel();
        n_factura = new javax.swing.JLabel();
        rut_text = new javax.swing.JLabel();
        nombre_text = new javax.swing.JLabel();
        contacto_text = new javax.swing.JLabel();
        monto_text = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        direccion_text = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        idboleta = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        estado = new javax.swing.JComboBox();
        factoring_text = new javax.swing.JLabel();
        estado_text = new javax.swing.JLabel();
        fechav_text = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        detalle_tetx = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Cantidad", "Producto", "Valor unitario compra", "Valor unitario venta", "Proveedor", "Valor venta", "Valor compra"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Fecha de Emicion");

        jLabel2.setText("Numero de Factura");

        jLabel3.setText("RUT");

        jLabel4.setText("Nombre");

        jLabel5.setText("Contacto");

        jLabel6.setText("Factoring");

        jLabel7.setText("Monto");

        jLabel8.setText("Fecha vencimiento");

        jLabel9.setText("Estado");

        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Aceptar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        fecha_emicion.setText(".");

        n_factura.setText(".");

        rut_text.setText(".");

        nombre_text.setText(".");

        contacto_text.setText(".");

        monto_text.setText(".");

        jLabel18.setText("Direccion");

        direccion_text.setText(".");

        jLabel21.setText("BUSCAR FACTURA");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        estado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cero", "Pagado", "Excedente" }));

        factoring_text.setText(".");

        estado_text.setText(".");

        fechav_text.setText(".");

        jLabel10.setText("Detalle");

        detalle_tetx.setText(".");

        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Cantidad", "Producto", "Valor unitario compra", "Valor unitario venta", "Proveedor", "Valor venta", "Valor compra"
            }
        ));
        jScrollPane2.setViewportView(tabla1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idboleta, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 135, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel18)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(detalle_tetx)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(estado, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(estado_text)
                                    .addComponent(direccion_text)
                                    .addComponent(monto_text)
                                    .addComponent(contacto_text)
                                    .addComponent(nombre_text)
                                    .addComponent(rut_text)
                                    .addComponent(n_factura)
                                    .addComponent(fecha_emicion)
                                    .addComponent(factoring_text)
                                    .addComponent(fechav_text))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idboleta, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fecha_emicion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(n_factura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(rut_text))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nombre_text))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(direccion_text))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(contacto_text))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(factoring_text))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(monto_text))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(fechav_text))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(estado_text))
                .addGap(14, 14, 14)
                .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(detalle_tetx))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

            Principal form = new Principal();
            form.setVisible(true);
            form.setLocationRelativeTo(null);
            this.dispose(); 

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        JOptionPane.showMessageDialog(rootPane, "Guardado con exitosamente ");
        ServicioDB servicio = new ServicioDB();
            String fech= null;
            fech = this.fechav_text.getText();
            String estad=null;
            estad=this.estado.getSelectedItem().toString();
            if("Cero".equals(estad))
            {
                estad="0";
            }
            servicio.guardarcambios(a, estad);
            Principal form = new Principal();
            form.setVisible(true);
            form.setLocationRelativeTo(null);
            this.dispose(); 
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        ServicioDB servicio = new ServicioDB();
                    DefaultTableModel modelo = new DefaultTableModel();
        String factura = this.idboleta.getText();
        Integer fac= Integer.parseInt(factura);
        Boleta boleta=servicio.getBoletaPorIdboleta(fac);
        cl.codo.fernando.modelo.Empresa empresa = servicio.getEmpresaPorId(boleta.getIdempresa());
        cl.codo.fernando.modelo.Pago pago = servicio.getpago(boleta.getIdboleta());
        int factor = pago.getIdfactoring();
        String fatoring = factoring(factor);
        this.fecha_emicion.setText(boleta.getFecha().toString());
        this.n_factura.setText(boleta.getIdboleta().toString());
        this.rut_text.setText(empresa.getRut());
        this.nombre_text.setText(empresa.getNombre());
        this.direccion_text.setText(empresa.getDireccion());
        String fact= factoring(pago.getIdfactoring());
        this.factoring_text.setText(fact);
        this.contacto_text.setText(empresa.getContacto());
        this.monto_text.setText(pago.getMonto().toString());
        this.fechav_text.setText(pago.getFechaVencimiento().toString());
        this.estado_text.setText(pago.getEstado());
        a=pago.getIdPago();
        cl.codo.fernando.modelo.Venta venta=servicio.getventa(boleta.getIdboleta());
        cl.codo.fernando.modelo.Mantencion mantencion= servicio.getmantencion(boleta.getIdboleta());
        if(venta!=null)
        {
        this.detalle_tetx.setText("Venta");
        JTable tabla = new JTable(modelo);
        modelo.addColumn("Cantidad");
        modelo.addColumn("Producto");
        modelo.addColumn("Valor unitario compra");
        modelo.addColumn("Valor Unitario venta");
        modelo.addColumn("Proveedor");
        Object[] fila = new Object[20];
        fila[0]=venta.getCantidad();
        fila[1]=venta.getProducto();
        fila[2]=venta.getPreciocompra();
        fila[3]=venta.getPrecioventa();
        fila[4]=venta.getProveedor();
        modelo.addRow(fila);
     
        }
        if(mantencion!=null)
        {
        this.detalle_tetx.setText("Mantencion");
        JTable tabla = new JTable(modelo);
        modelo.addColumn("Fecha inicio");
        modelo.addColumn("Fecha termino");
        modelo.addColumn("Lugar");
        modelo.addColumn("Detalle");
        modelo.addColumn("Comentario");
        Object[] fila = new Object[20];
        fila[0]=mantencion.getFechainicio();
        fila[1]=mantencion.getFechafin();
        fila[2]=mantencion.getLugar();
        fila[3]=mantencion.getDetalle();
        fila[4]=mantencion.getComentario();
        modelo.addRow(fila);
     
        }
        tabla1.setModel(modelo);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Guardado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Guardado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Guardado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Guardado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Guardado().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel contacto_text;
    private javax.swing.JLabel detalle_tetx;
    private javax.swing.JLabel direccion_text;
    private javax.swing.JComboBox estado;
    private javax.swing.JLabel estado_text;
    private javax.swing.JLabel factoring_text;
    private javax.swing.JLabel fecha_emicion;
    private javax.swing.JLabel fechav_text;
    private javax.swing.JTextField idboleta;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel monto_text;
    private javax.swing.JLabel n_factura;
    private javax.swing.JLabel nombre_text;
    private javax.swing.JLabel rut_text;
    private javax.swing.JTable tabla1;
    // End of variables declaration//GEN-END:variables
}
