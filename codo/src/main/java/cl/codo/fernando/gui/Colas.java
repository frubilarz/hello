package cl.codo.fernando.gui;

import cl.codo.fernando.modelo.Empresa;
import cl.codo.fernando.servicio.ServicioDB;
import cl.codo.fernando.utils.FechaUtils;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Colas extends javax.swing.JFrame {

    int reseto(int aux, int tiempo) {
        int resultado = 0;
        resultado = aux + tiempo;
        if (resultado > 12) {
            resultado = resultado - 12;
        }
        return resultado;
    }

    int factor(String fac)
{
	if("BCI".equals(fac))
            return 1;
	if("Yakora".equals(fac))
            return 2;
	if("LYM".equals(fac))
            return 3;
        return 0;
}

                
    int tiene(int aux) {
        if (aux == 30) {
            return 1;
        }
        if (aux == 45) {
            return 2;
        }
        if (aux == 60) {
            return 3;
        }
        if (aux == 90) {
            return 4;
        }
        if (aux == 120) {
            return 5;
        }
        return 0;
    }

    String fechas(int mes) {
        if (mes == 1) {
            return "enero";
        }
        if (mes == 2) {
            return "febrero";
        }
        if (mes == 3) {
            return "marzo";
        }
        if (mes == 4) {
            return "abril";
        }
        if (mes == 5) {
            return "mayo";
        }
        if (mes == 6) {
            return "junio";
        }
        if (mes == 7) {
            return "julio";
        }
        if (mes == 8) {
            return "agosto";
        }
        if (mes == 9) {
            return "septiembre";
        }
        if (mes == 10) {
            return "octubre";
        }
        if (mes == 11) {
            return "noviembre";
        }
        if (mes == 12) {
            return "diciembre";
        }
        return null;

    }

  String fecha(String mes) {
        if ("Enero".equals(mes)) {
            return "1";
        }
        if ("Febrero".equals(mes)) {
            return "2";
        }
        if ("Marzo".equals(mes)) {
            return "3";
        }
        if ("Abril".equals(mes)) {
            return "4";
        }
        if ("Mayo".equals(mes)) {
            return "5";
        }
        if ("Junio".equals(mes)) {
            return "6";
        }
        if ("Julio".equals(mes)) {
            return "7";
        }
        if ("Agosto".equals(mes)) {
            return "8";
        }
        if ("Octubre".equals(mes)) {
            return "10";
        }
        if ("Septiembre".equals(mes)) {
            return "9";
        }
        if ("Noviembre".equals(mes)) {
            return "11";
        }
        if ("Diciembre".equals(mes)) {
            return "12";
        }
        return "0";
    }

    public Colas() {
        initComponents();
        Sletras(nombre_text);
        Nletras(monto_text);
        Nletras(factura_text);
        
       

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        factura_text = new javax.swing.JTextField();
        rut_text = new javax.swing.JTextField();
        nombre_text = new javax.swing.JTextField();
        guardar_boton = new javax.swing.JButton();
        limpiar_boton = new javax.swing.JButton();
        cancelar_boton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        contacto_text = new javax.swing.JTextField();
        consulta = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        monto_text = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        dias_pago = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        venta_boton = new javax.swing.JButton();
        mantencion_boton = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        direccion_text = new javax.swing.JTextField();
        mes_text = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        factorin_text = new javax.swing.JComboBox();
        dia_text = new javax.swing.JComboBox();
        anio_text = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("N° de factura");

        jLabel4.setText("RUT");

        jLabel5.setText("Nombre");

        jLabel6.setText("Fecha De emicion");

        jLabel7.setText("Factoring ");

        rut_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                rut_textKeyTyped(evt);
            }
        });

        nombre_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre_textActionPerformed(evt);
            }
        });

        guardar_boton.setText("Guardar");
        guardar_boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardar_botonActionPerformed(evt);
            }
        });

        limpiar_boton.setText("Limpiar");
        limpiar_boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiar_botonActionPerformed(evt);
            }
        });

        cancelar_boton.setText("Cancelar");
        cancelar_boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar_botonActionPerformed(evt);
            }
        });

        jLabel1.setText("Contacto");

        contacto_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contacto_textActionPerformed(evt);
            }
        });
        contacto_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                contacto_textKeyTyped(evt);
            }
        });

        consulta.setText("Consultar");
        consulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                consultaMouseClicked(evt);
            }
        });
        consulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaActionPerformed(evt);
            }
        });
        consulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                consultaKeyPressed(evt);
            }
        });

        jLabel11.setText("Monto");

        jLabel2.setText("Dias");

        dias_pago.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Al contado", "30", "45", "60", "90", "120" }));
        dias_pago.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                dias_pagoItemStateChanged(evt);
            }
        });
        dias_pago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dias_pagoActionPerformed(evt);
            }
        });

        jLabel8.setText("Detalles");

        venta_boton.setText("venta");
        venta_boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                venta_botonActionPerformed(evt);
            }
        });

        mantencion_boton.setText("Mantención");
        mantencion_boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mantencion_botonActionPerformed(evt);
            }
        });

        jLabel12.setText("Dirección");

        direccion_text.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                direccion_textMouseClicked(evt);
            }
        });
        direccion_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                direccion_textKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                direccion_textKeyPressed(evt);
            }
        });

        mes_text.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        jLabel13.setText("-");

        jLabel14.setText("-");

        factorin_text.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "BCI", "Yakora", "LYM" }));
        factorin_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                factorin_textActionPerformed(evt);
            }
        });

        dia_text.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        anio_text.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(34, 34, 34))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(24, 24, 24)))
                            .addComponent(jLabel11)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(venta_boton, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(mantencion_boton, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rut_text, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(consulta)))
                                .addGap(0, 142, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(monto_text)
                                    .addComponent(contacto_text)
                                    .addComponent(nombre_text, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(factura_text, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(direccion_text)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(dias_pago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(dia_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel13)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(mes_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel14)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(anio_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(guardar_boton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(limpiar_boton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancelar_boton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel6))
                                .addGap(37, 37, 37)
                                .addComponent(factorin_text, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(mes_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(dia_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(anio_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(factura_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rut_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(nombre_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(direccion_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(contacto_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(factorin_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(monto_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(dias_pago, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(venta_boton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(mantencion_boton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelar_boton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(guardar_boton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limpiar_boton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void Sletras(JTextField a) {
        a.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
    }

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
    private void nombre_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombre_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombre_textActionPerformed

    private void guardar_botonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardar_botonActionPerformed
        ServicioDB servicio = new ServicioDB();

        String rut = null, verificacion = null, nombre = null, direccion = null, contacto = null;
        String   mes = null, monto = null, factoring = null;
        String estado = "0";
        Integer pregunta = 0,nboleta = 0;
        String mm=null;

        //String mensaje = "";
        rut = this.rut_text.getText();
        nombre = this.nombre_text.getText();
        direccion = this.direccion_text.getText();
        contacto = this.contacto_text.getText();

     
        Empresa empresa = servicio.getEmpresaPorRut(rut);
        if (empresa != null) {
           
            pregunta = empresa.getIdempresa();
            rut = empresa.getRut();
            verificacion = "";
            nombre = empresa.getNombre();
            direccion = empresa.getDireccion();
            contacto = empresa.getContacto();
        }
        if (pregunta == null) {
            Empresa nuevaEmpresa = new Empresa();     
            nuevaEmpresa.setIdempresa(null);
            nuevaEmpresa.setRut(this.rut_text.getText());
            nuevaEmpresa.setNombre(this.nombre_text.getText());
            nuevaEmpresa.setDireccion(this.direccion_text.getText());
            nuevaEmpresa.setContacto(this.contacto_text.getText());
            servicio.guardar(nuevaEmpresa);
        }
        Empresa empresa1 = servicio.getEmpresaPorRut(this.rut_text.getText());
        pregunta = empresa1.getIdempresa();
        
        nboleta = Integer.parseInt(this.factura_text.getText());
        String dia = this.dia_text.getSelectedItem().toString();
        mes = this.mes_text.getSelectedItem().toString();
        String anio = this.anio_text.getSelectedItem().toString();
        mm=fecha(mes);
        cl.codo.fernando.modelo.Boleta boleta = new cl.codo.fernando.modelo.Boleta();
        String fecha = dia + "/" + mm + "/" + anio;
        boleta.setFecha(FechaUtils.getFecha(Integer.parseInt(anio), Integer.parseInt(mm)-1,Integer.parseInt(dia)));
        boleta.setDia(Integer.parseInt(dia));
        boleta.setAnio(Integer.parseInt(anio));
        boleta.setMes(Integer.parseInt(mm)-1);
        boleta.setIdempresa(pregunta);
        boleta.setIdboleta(nboleta);
        servicio.guardar(boleta);

        monto = this.monto_text.getText();
        factoring = this.factorin_text.getSelectedItem().toString();
        int fact = factor(factoring);
        String aux = this.dias_pago.getSelectedItem().toString();
        Integer aux2=0;
        if(!"Al contado".equals(aux))
        {
            aux2 = Integer.parseInt(aux);
        }
        Date fec ;
        fec=FechaUtils.getFecha(Integer.parseInt(anio), Integer.parseInt(mm)-1,Integer.parseInt(dia));

        fec=FechaUtils.sumarDia(fec, aux2);
  
         cl.codo.fernando.modelo.Pago pago =new  cl.codo.fernando.modelo.Pago();
         pago.setFechaVencimiento(fec);
         pago.setIdboleta(nboleta);
         Float monto1= Float.parseFloat(monto);
         pago.setMonto(monto1);
         pago.setEstado(estado);
         pago.setIdfactoring(fact);
         servicio.guardar(pago);
        
        
        // En este punto me aburrí XD pero deberías cachar la idea
        

       
        Principal form = new Principal();
        form.setVisible(true);
        form.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_guardar_botonActionPerformed

    private void limpiar_botonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiar_botonActionPerformed

        
        this.contacto_text.setText(" ");
        this.rut_text.setText("");
        this.nombre_text.setText("");

        this.monto_text.setText("");
        this.direccion_text.setText("");
        this.factura_text.setText("");

        // TODO add your handling code here:
    }//GEN-LAST:event_limpiar_botonActionPerformed

    private void contacto_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contacto_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contacto_textActionPerformed

    private void cancelar_botonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelar_botonActionPerformed

        Principal form = new Principal();
        form.setVisible(true);
        form.setLocationRelativeTo(null);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelar_botonActionPerformed

    private void dias_pagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dias_pagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dias_pagoActionPerformed

    private void dias_pagoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_dias_pagoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_dias_pagoItemStateChanged

    private void consultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaActionPerformed

        
        ServicioDB servicio = new ServicioDB();

        String rut = "", verificacion = "", nombre = "", direccion = "", contacto = "";
        int pregunta = 0;

        rut = this.rut_text.getText();
        Empresa empresa = servicio.getEmpresaPorRut(rut);
        
        if (empresa == null) { // si no tiene nada implica que no ingreso rut para la consulta
            JOptionPane.showMessageDialog(null, "Cliente nuevo"); // si no tiene nada es cliente nuevo
        } else {
            pregunta = empresa.getIdempresa();
            rut = empresa.getRut();
            nombre = empresa.getNombre();
            direccion = empresa.getDireccion();
            contacto = empresa.getContacto();
               
            this.nombre_text.setText(nombre);
            this.direccion_text.setText(direccion);
            this.contacto_text.setText(contacto);
        }



        this.nombre_text.setToolTipText(nombre);// TODO add your handling code here:
    }//GEN-LAST:event_consultaActionPerformed

    private void consultaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_consultaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_consultaKeyPressed

    private void consultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_consultaMouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_consultaMouseClicked

    private void mantencion_botonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mantencion_botonActionPerformed

        Mantencion form = new Mantencion();
        form.setVisible(true);
        form.setLocationRelativeTo(null);

        // TODO add your handling code here:
    }//GEN-LAST:event_mantencion_botonActionPerformed

    private void venta_botonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_venta_botonActionPerformed

        Venta form = new Venta();
        form.setVisible(true);
        form.setLocationRelativeTo(null);
        //this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_venta_botonActionPerformed

    private void factorin_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_factorin_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_factorin_textActionPerformed

    private void direccion_textMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_direccion_textMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_direccion_textMouseClicked

    private void direccion_textKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_direccion_textKeyTyped
                // TODO add your handling code here:
    }//GEN-LAST:event_direccion_textKeyTyped

    private void contacto_textKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contacto_textKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_contacto_textKeyTyped

    private void direccion_textKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_direccion_textKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_direccion_textKeyPressed

    private void rut_textKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rut_textKeyTyped
//validar que solo sean numeros y no mas de 8
        char car = evt.getKeyChar();
        if (rut_text.getText().length() >= 8) {
            evt.consume();
        }
        if ((car < '0' || car > '9')) {
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_rut_textKeyTyped

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
            java.util.logging.Logger.getLogger(Colas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Colas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Colas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Colas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Colas().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox anio_text;
    private javax.swing.JButton cancelar_boton;
    private javax.swing.JButton consulta;
    private javax.swing.JTextField contacto_text;
    private javax.swing.JComboBox dia_text;
    private javax.swing.JComboBox dias_pago;
    private javax.swing.JTextField direccion_text;
    private javax.swing.JComboBox factorin_text;
    private javax.swing.JTextField factura_text;
    private javax.swing.JButton guardar_boton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton limpiar_boton;
    private javax.swing.JButton mantencion_boton;
    private javax.swing.JComboBox mes_text;
    private javax.swing.JTextField monto_text;
    private javax.swing.JTextField nombre_text;
    private javax.swing.JTextField rut_text;
    private javax.swing.JButton venta_boton;
    // End of variables declaration//GEN-END:variables

    private int resto(String aux, int help) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
