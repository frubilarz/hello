package cl.codo.fernando.gui;


import cl.codo.fernando.modelo.Empresa;
import cl.codo.fernando.modelo.Pago;
import cl.codo.fernando.servicio.ServicioDB;
import cl.codo.fernando.utils.FechaUtils;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.List;
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
public class Fecha extends javax.swing.JFrame {

    /**
     * Creates new form Fecha
     */
    public Fecha() {
        initComponents();
       Nletras(rut_text);
    }
    String factoring(int factor)
    {
        String fac=null;
        if(factor==1)
            return "BCI";
        if(factor == 2)
            return "Yakora";
        if(factor==3)
            return "LYM";
        return fac;
    }

    @SuppressWarnings("unchecked")
    public void Sletras(JTextField a){
        a.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c= e.getKeyChar();
                if(Character.isDigit(c))
                    e.consume();
            }
        });
    }
    String fecha(String mes) {
        if ("enero".equals(mes)) {
            return "1";
        }
        if ("febrero".equals(mes)) {
            return "2";
        }
        if ("marzo".equals(mes)) {
            return "3";
        }
        if ("abril".equals(mes)) {
            return "4";
        }
        if ("mayo".equals(mes)) {
            return "5";
        }
        if ("junio".equals(mes)) {
            return "6";
        }
        if ("julio".equals(mes)) {
            return "7";
        }
        if ("agosto".equals(mes)) {
            return "8";
        }
        if ("octubre".equals(mes)) {
            return "10";
        }
        if ("spetiembre".equals(mes)) {
            return "9";
        }
        if ("noviembre".equals(mes)) {
            return "11";
        }
        if ("diciembre".equals(mes)) {
            return "12";
        }
        return "0";
    }
       public void Nletras(JTextField a){
        a.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c= e.getKeyChar();
                if(!Character.isDigit(c))
                    e.consume();
            }
        });
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        rut_text = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        mes_text = new javax.swing.JComboBox();
        mes_text1 = new javax.swing.JComboBox();
        dia_text = new javax.swing.JComboBox();
        anio_text = new javax.swing.JComboBox();
        dia_text1 = new javax.swing.JComboBox();
        anio_text1 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Fecha");

        jLabel3.setText("-");

        jLabel4.setText("-");

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel5.setText("BUSQUEDA");

        jLabel7.setText("RUT");

        rut_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rut_textActionPerformed(evt);
            }
        });

        jLabel1.setText("Hasta");

        jLabel8.setText("-");

        jLabel9.setText("-");

        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "rut", "Nombre", "N° fact", "Fecha Emicion", "Monto", "Fecha Vencimiento", "Contacto", "Factoring", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla1);

        mes_text.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "*", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        mes_text1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "*", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        dia_text.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "*", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        anio_text.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "*", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020" }));

        dia_text1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "*", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        anio_text1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "*", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(133, 133, 133)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(dia_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(mes_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4))
                                    .addComponent(rut_text))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(anio_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dia_text1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mes_text1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addGap(11, 11, 11)
                                .addComponent(anio_text1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 121, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 923, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(rut_text))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mes_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mes_text1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anio_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dia_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anio_text1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dia_text1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        Principal form= new Principal();
        form.setVisible(true);
        form.setLocationRelativeTo(null);
        this.dispose();
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void rut_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rut_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rut_textActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

         ServicioDB servicio = new ServicioDB();
         DefaultTableModel modelo = new DefaultTableModel();
        JTable tabla = new JTable(modelo);
        modelo.addColumn("RUT");
        modelo.addColumn("Nombre");
        modelo.addColumn("N° factura");
        modelo.addColumn("Fecha emicion");
        modelo.addColumn("Monto");
        modelo.addColumn("Fecha vencimiento");
        modelo.addColumn("Contacto");
        modelo.addColumn("Factoring");
        modelo.addColumn("Estado");
        String rutStr = this.rut_text.getText() ;
        
        if("*".equals(this.anio_text1.getSelectedItem().toString())||"*".equals(this.anio_text.getSelectedItem().toString())||"*".equals(this.mes_text.getSelectedItem().toString())|| "*".equals(this.mes_text1.getSelectedItem().toString())||"*".equals(this.dia_text.getSelectedItem().toString())||"*".equals(this.dia_text1.getSelectedItem().toString())){

                    Integer rut= Integer.parseInt(rutStr);
                    Object[] fila = new Object[20];
                    List<cl.codo.fernando.modelo.vista> vistas = servicio.getdatos(rut);
                    if(!vistas.isEmpty()){
                    for (cl.codo.fernando.modelo.vista visstas: vistas)
                    {
                        fila[0]=visstas.getRut();
                        fila[1]=visstas.getNombre();
                        Pago pago= servicio.getpago(visstas.getMonto(), visstas.getEstado(),visstas.getFechavencimiento());
                        fila[2]=pago.getIdboleta();
                        fila[3]=visstas.getFechaemicion();
                        fila[4]=visstas.getMonto();
                        fila[5]=visstas.getFechavencimiento();
                        fila[6]=visstas.getNumero();
                        fila[7]=visstas.getFactoring();
                        fila[8]=visstas.getEstado();
                        modelo.addRow(fila);
                    }
                    }else
                        JOptionPane.showMessageDialog(anio_text,"no existen datos en ese rut");

        }
        if(!"*".equals(this.anio_text1.getSelectedItem().toString()) &&!"*".equals(this.anio_text.getSelectedItem().toString())&&!"*".equals(this.mes_text.getSelectedItem().toString())&& !"*".equals(this.mes_text1.getSelectedItem().toString())&&
                !"*".equals(this.dia_text.getSelectedItem().toString())&& !"*".equals(this.dia_text1.getSelectedItem().toString()))
        {
            if("".equals(rutStr)){
                    Integer d1= Integer.parseInt(this.dia_text.getSelectedItem().toString());
                    Integer d2= Integer.parseInt(this.dia_text1.getSelectedItem().toString());
                    Integer m1= Integer.parseInt(fecha(this.mes_text.getSelectedItem().toString()));
                    Integer m2= Integer.parseInt(fecha(this.mes_text1.getSelectedItem().toString()));
                    Integer a1= Integer.parseInt(this.anio_text.getSelectedItem().toString());
                    Integer a2= Integer.parseInt(this.anio_text1.getSelectedItem().toString());
                    Date fecha=null;
                    Date fecha2 = null;
                    fecha=FechaUtils.getFecha(a1, (m1)-1, d1);
                    fecha2=FechaUtils.getFecha(a2, (m2)-1, d2);
                    Object[] fila = new Object[20];
                    List<cl.codo.fernando.modelo.vista> vistas = servicio.getdatos(fecha, fecha2);
                    if(!vistas.isEmpty()){
                        for (cl.codo.fernando.modelo.vista visstas: vistas)
                            {
                        fila[0]=visstas.getRut();
                        fila[1]=visstas.getNombre();
                        Pago pago= servicio.getpago(visstas.getMonto(), visstas.getEstado(),visstas.getFechavencimiento());
                        fila[2]=pago.getIdboleta();
                        fila[3]=visstas.getFechaemicion();
                        fila[4]=visstas.getMonto();
                        fila[5]=visstas.getFechavencimiento();
                        fila[6]=visstas.getNumero();
                        fila[7]=visstas.getFactoring();
                        fila[8]=visstas.getEstado();
                        modelo.addRow(fila);
                            }
                        }else{
                            JOptionPane.showMessageDialog(anio_text,"no existen datos entre esas fechas");
                    }
            }
                    if(!"*".equals(this.anio_text1.getSelectedItem().toString()) &&!"*".equals(this.anio_text.getSelectedItem().toString())&&!"*".equals(this.mes_text.getSelectedItem().toString())&& !"*".equals(this.mes_text1.getSelectedItem().toString())&&
                !"*".equals(this.dia_text.getSelectedItem().toString())&& !"*".equals(this.dia_text1.getSelectedItem().toString()))
        {
            if(!"".equals(rutStr)){
               
                    Integer d1= Integer.parseInt(this.dia_text.getSelectedItem().toString());
                    Integer d2= Integer.parseInt(this.dia_text1.getSelectedItem().toString());
                    Integer m1= Integer.parseInt(fecha(this.mes_text.getSelectedItem().toString()));
                    Integer m2= Integer.parseInt(fecha(this.mes_text1.getSelectedItem().toString()));
                    Integer a1= Integer.parseInt(this.anio_text.getSelectedItem().toString());
                    Integer a2= Integer.parseInt(this.anio_text1.getSelectedItem().toString());
                    Date fecha=null;
                    Date fecha2 = null;
                    fecha=FechaUtils.getFecha(a1, (m1)-1, d1);
                    fecha2=FechaUtils.getFecha(a2, (m2)-1, d2);
                    Integer rut = Integer.parseInt(rutStr);
                    Object[] fila = new Object[20];
                    List<cl.codo.fernando.modelo.vista> vistas = servicio.getdatos(fecha, fecha2,rut);
                    if(!vistas.isEmpty()){
                        for (cl.codo.fernando.modelo.vista visstas: vistas)
                            {
                        fila[0]=visstas.getRut();
                        fila[1]=visstas.getNombre();
                        Pago pago= servicio.getpago(visstas.getMonto(), visstas.getEstado(),visstas.getFechavencimiento());
                        fila[2]=pago.getIdboleta();
                        fila[3]=visstas.getFechaemicion();
                        fila[4]=visstas.getMonto();
                        fila[5]=visstas.getFechavencimiento();
                        fila[6]=visstas.getNumero();
                        fila[7]=visstas.getFactoring();
                        fila[8]=visstas.getEstado();
                        modelo.addRow(fila);
                            }
                        }else{
                            JOptionPane.showMessageDialog(anio_text,"no existen datos entre esas fechas con el rut   "  + rutStr);
                    }
            }
        }
            

        }
        
        
        tabla1.setModel(modelo);
         
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Fecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fecha().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox anio_text;
    private javax.swing.JComboBox anio_text1;
    private javax.swing.JComboBox dia_text;
    private javax.swing.JComboBox dia_text1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox mes_text;
    private javax.swing.JComboBox mes_text1;
    private javax.swing.JTextField rut_text;
    private javax.swing.JTable tabla1;
    // End of variables declaration//GEN-END:variables
}
