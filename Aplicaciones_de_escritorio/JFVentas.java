/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package defaultpackage;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
 
/**
 *
 * @author LAB 4
 */
public class JFVentas extends javax.swing.JFrame {
 private Connection conexion;
    private Statement st;
    private ResultSet rs;
    
 public void Conectar() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/la_jirafa", "root", "");
            st = conexion.createStatement();
            rs = st.executeQuery("Select * from inventario inner join detalle_venta;");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos" + ex.getMessage());
        }
    }
 public void vender(){
            float precio= 0.0f;
            float total= 0.0f;
            float cantidad=0.0f;
            float existencias=0.0f;
            String id= this.jtf_id.getText();
            String nombre=this.jtf_cliente.getText(); 
            String direccion=this.jtf_direccion.getText();
            precio= Float.parseFloat(this.jtf_precio.getText()); 
            cantidad= Float.parseFloat(this.jtf_cantidad.getText());
           
            
            total= (float) (precio * cantidad);
            this.jtf_importe.setText(String.valueOf(total));
            int resp=JOptionPane.showConfirmDialog(null,"Esta seguro de que desea vender los productos?");
            if (JOptionPane.OK_OPTION == resp){
                
                JOptionPane.showMessageDialog(this,"Felicidades vendido" );
                }          
 }
 public void llenarDatos(){
      try {
          float precio= 0.0f;
            float total= 0.0f;
            float cantidad=0.0f;
            float existencias=0.0f;
            String id= this.jtf_id.getText();
            String nombre=this.jtf_cliente.getText(); 
            String direccion=this.jtf_direccion.getText();
            precio= Float.parseFloat(this.jtf_precio.getText()); 
            cantidad= Float.parseFloat(this.jtf_cantidad.getText());
            this.jtf_existencias.setText(rs.getString("existencias"));
            st.executeUpdate("Insert into detalle_venta (id_inventario,nombre,direccion,cantidad,precio,total)"+" values ('"+ id +"','"+nombre+"','"+direccion+"','"+cantidad+"','"+precio+"','"+total+"');");
            
            
            st.executeUpdate("update inventario set existencias='"+existencias+"' where id='"+id+"';");
      } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error llenar id" + ex.getMessage());
        }
 }
    public void activarMenu(){
        JFMenu jfmenu=new JFMenu();
        jfmenu.setVisible(true);
        this.setVisible(false);
        }
    public void desactivarVentas(){
        JFVentas jfventas=new JFVentas();
        jfventas.setVisible(false);
        }
    /**
     * Creates new form MUEBLERIA
     */
    public JFVentas() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtf_cliente = new javax.swing.JTextField();
        jl_nombre = new javax.swing.JLabel();
        jtf_nombre = new javax.swing.JTextField();
        jl_precio = new javax.swing.JLabel();
        jtf_cantidad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jl_cantidad = new javax.swing.JLabel();
        jtf_direccion = new javax.swing.JTextField();
        jtf_precio = new javax.swing.JTextField();
        jl_importe = new javax.swing.JLabel();
        jtf_importe = new javax.swing.JTextField();
        jb_cancelar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jl_id = new javax.swing.JLabel();
        jtf_id = new javax.swing.JTextField();
        jl_existencias = new javax.swing.JLabel();
        jtf_existencias = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();

        jButton3.setFont(new java.awt.Font("Viner Hand ITC", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 0, 0));
        jButton3.setText("ELIMINAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Viner Hand ITC", 0, 18)); // NOI18N
        jButton4.setText("CANCELAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Viner Hand ITC", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 204, 0));
        jButton1.setText("AGREGAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(51, 255, 204));
        jLabel1.setFont(new java.awt.Font("Papyrus", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MUEBLERIA");
        jLabel1.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Viner Hand ITC", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CLIENTE");

        jtf_cliente.setBackground(new java.awt.Color(204, 255, 204));
        jtf_cliente.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jtf_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_clienteActionPerformed(evt);
            }
        });

        jl_nombre.setFont(new java.awt.Font("Viner Hand ITC", 0, 14)); // NOI18N
        jl_nombre.setForeground(new java.awt.Color(255, 153, 0));
        jl_nombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_nombre.setText("NOMBRE ");

        jtf_nombre.setBackground(new java.awt.Color(204, 255, 204));
        jtf_nombre.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jl_precio.setFont(new java.awt.Font("Viner Hand ITC", 0, 14)); // NOI18N
        jl_precio.setForeground(new java.awt.Color(255, 153, 0));
        jl_precio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_precio.setText("PRECIO");

        jtf_cantidad.setBackground(new java.awt.Color(204, 255, 204));
        jtf_cantidad.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Viner Hand ITC", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("DIRECCIÓN ");

        jl_cantidad.setFont(new java.awt.Font("Viner Hand ITC", 0, 14)); // NOI18N
        jl_cantidad.setForeground(new java.awt.Color(255, 153, 0));
        jl_cantidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_cantidad.setText("CANTIDAD");

        jtf_direccion.setBackground(new java.awt.Color(204, 255, 204));
        jtf_direccion.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jtf_direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_direccionActionPerformed(evt);
            }
        });

        jtf_precio.setBackground(new java.awt.Color(204, 255, 204));
        jtf_precio.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jtf_precio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_precioActionPerformed(evt);
            }
        });

        jl_importe.setFont(new java.awt.Font("Viner Hand ITC", 0, 14)); // NOI18N
        jl_importe.setForeground(new java.awt.Color(255, 153, 0));
        jl_importe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_importe.setText("IMPORTE TOTAL;");

        jtf_importe.setBackground(new java.awt.Color(204, 255, 204));
        jtf_importe.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jtf_importe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_importeActionPerformed(evt);
            }
        });

        jb_cancelar.setFont(new java.awt.Font("Viner Hand ITC", 0, 18)); // NOI18N
        jb_cancelar.setText("CANCELAR");
        jb_cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_cancelarMouseClicked(evt);
            }
        });
        jb_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelarActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Viner Hand ITC", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(102, 204, 0));
        jButton2.setText("VENDER");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jl_id.setFont(new java.awt.Font("Viner Hand ITC", 0, 11)); // NOI18N
        jl_id.setForeground(new java.awt.Color(255, 153, 0));
        jl_id.setText("ID PRODUCTO");

        jtf_id.setBackground(new java.awt.Color(204, 255, 204));

        jl_existencias.setBackground(new java.awt.Color(255, 153, 0));
        jl_existencias.setForeground(new java.awt.Color(255, 153, 0));
        jl_existencias.setText("Existencias del producto");

        jtf_existencias.setEditable(false);
        jtf_existencias.setBackground(new java.awt.Color(204, 255, 204));

        jButton5.setText("llenar datos ");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
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
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jtf_existencias, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jl_nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                            .addComponent(jl_precio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtf_nombre)
                                .addGap(2, 2, 2))
                            .addComponent(jtf_precio)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                            .addComponent(jl_id, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtf_direccion)
                            .addComponent(jtf_cliente)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtf_id, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5)
                                .addGap(70, 70, 70))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jl_existencias, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jl_importe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(jl_cantidad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtf_importe, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                            .addComponent(jtf_cantidad))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(jb_cancelar)
                .addGap(92, 92, 92))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtf_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jtf_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5))))
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jl_id, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtf_id, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_nombre)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtf_nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                        .addGap(16, 16, 16)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_precio)
                    .addComponent(jtf_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtf_existencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jl_existencias, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_cantidad)
                    .addComponent(jtf_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_importe)
                    .addComponent(jtf_importe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtf_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_clienteActionPerformed

    private void jtf_direccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_direccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_direccionActionPerformed

    private void jtf_importeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_importeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_importeActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_cancelarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jb_cancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_cancelarMouseClicked
        desactivarVentas();
        activarMenu();
    }//GEN-LAST:event_jb_cancelarMouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        vender();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jtf_precioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_precioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_precioActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(JFVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFVentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JLabel jl_cantidad;
    private javax.swing.JLabel jl_existencias;
    private javax.swing.JLabel jl_id;
    private javax.swing.JLabel jl_importe;
    private javax.swing.JLabel jl_nombre;
    private javax.swing.JLabel jl_precio;
    private javax.swing.JTextField jtf_cantidad;
    private javax.swing.JTextField jtf_cliente;
    private javax.swing.JTextField jtf_direccion;
    private javax.swing.JTextField jtf_existencias;
    private javax.swing.JTextField jtf_id;
    private javax.swing.JTextField jtf_importe;
    private javax.swing.JTextField jtf_nombre;
    private javax.swing.JTextField jtf_precio;
    // End of variables declaration//GEN-END:variables
}
