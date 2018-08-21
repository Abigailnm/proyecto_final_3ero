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
 
public class JFProveedores extends javax.swing.JFrame {
private Connection conexion;
    private Statement st;
    private ResultSet rs;
    
 public void Conectar() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/la_jirafa", "root", "");
            st = conexion.createStatement();
            rs = st.executeQuery("Select * from proveedor;");
            this.deshabilitarBotonCambio();
            this.deshabilitarag();
            this.deshabilitarCancelarN();
            moverPrimerRegistro();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos" + ex.getMessage());
        }
    }

    public void moverPrimerRegistro() {
        try {
            rs.first();
            llenarDatos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 001" + ex.getMessage());
        }
    }

    public void moverRegistroSiguiente() {
        try {
            if (!rs.isLast()) {
                rs.next();
                llenarDatos();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 001" + ex.getMessage());
        }
    }
    
    public void moverRegistroAnterior() {
        try {
            if (!rs.isFirst()) {
                rs.previous();
                llenarDatos();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 001" + ex.getMessage());
        }
    }
    
    public void moverUltimoRegistro() {
        try {
            rs.last();
            llenarDatos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error mover ultimo registro" + ex.getMessage());
        }
    }

    public void llenarDatos() {
        try {
            this.jtf_rfc.setText(rs.getString("rfc"));
            this.jtf_nombre.setText(rs.getString("nombre_comp"));
            this.jtf_telefono.setText(rs.getString("no_tel"));
            deshabilitarEdicion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error llenar datos" + ex.getMessage());
        }
    }
        
    private void guardarRegistro() {        
       try{ 
            String rfc=this.jtf_rfc.getText(); 
            String nombre_comp=this.jtf_nombre.getText(); 
            String telefono=this.jtf_telefono.getText(); 
            if (rfc == " " || nombre_comp == " " || telefono == " "){
                JOptionPane.showMessageDialog(this,"Debes LLenar todos los campos" );
            }else{
                st.executeUpdate("Insert into proveedor (rfc,nombre_comp,no_tel)"+" values ('"+ rfc +"','"+nombre_comp+"','"+telefono+"');"); 
                JOptionPane.showMessageDialog(this,"Datos Correctamente agregados" );
                cancelarNuevo();
            }
        } catch(SQLException err)         { 
            JOptionPane.showMessageDialog(null,"Error guardar registro "+err.getMessage()); 
        } 

    } 
        public void nuevo(){
            this.jtf_rfc.setText(String.valueOf(""));
            this.jtf_nombre.setText(String.valueOf(""));
            this.jtf_telefono.setText(String.valueOf(""));
            habilitarCancelarN();
            habilitarEdicion();
            habilitarPan();
            habilitarag();
            deshabilitarPanel();
            deshabilitarPanel1();
            deshabilitareliminar();
            deahabilitarCancelar();
            deshabilitarNuevo();
        }
        public void habilitarCancelar(){
    jb_cancelar.setVisible(true);
}
        public void deahabilitarCancelar(){
    jb_cancelar.setVisible(false);
}
        public void habilitarnuevo(){
            jp_na.setVisible(true);   
        }
        public void deshabilitarnuevo(){
            jp_na.setVisible(false);
        }
        public void habilitarPanel(){
            jp_botonesn.setVisible(true);
              
        }
        public void deshabilitarPanel(){
            jp_botonesn.setVisible(false);
        }
         public void habilitarag(){
            jp_agregar.setVisible(true);  
        }
        public void deshabilitarag(){
            jp_agregar.setVisible(false);
        }
        
        public void habilitarNuevo(){
            jp_na.setVisible(true);
              
         }
        public void deshabilitarNuevo(){
            jp_na.setVisible(false);
        }
        public void habilitarPanel1(){
            jp_mode.setVisible(true);
        }
        public void deshabilitarPanel1(){
            jp_mode.setVisible(false);
        }
        
        public void habilitarPan(){
            jp_rnt.setVisible(true);
            
        }
        public void deshabilitarPan(){
            jp_rnt.setVisible(false);
        }
        
        public void habilitarAg(){
            jp_agregar.setVisible(true);
            
        }
        public void deshabilitArag(){
            jp_agregar.setVisible(false);
        }
        public void habilitarBotonCambio(){
            jP_guardar_cambios.setVisible(true);
        }
        public void deshabilitarBotonCambio(){
            jP_guardar_cambios.setVisible(false);
        }
     
        public void deshabilitarEdicion(){
        jtf_rfc.setEditable(false);
        jtf_nombre.setEditable(false);
        jtf_telefono.setEditable(false);
        }
        public void habilitarEdicion(){
        jtf_rfc.setEditable(true);
        jtf_nombre.setEditable(true);
        jtf_telefono.setEditable(true);
        }
        
        public void habilitareliminar(){
            jb_eli.setVisible(true);    
        }
        public void deshabilitareliminar(){
            jb_eli.setVisible(false);
        }
        public void habilitarCancelarN(){
            jb_cancelar_nuevo.setVisible(true);    
        }
        public void deshabilitarCancelarN(){
            jb_cancelar_nuevo.setVisible(false);
        }
        
        public void modificar(){ 
            habilitarCancelarN();
            deahabilitarCancelar();
            this.deshabilitarPanel1();
            this.habilitarEdicion();
            this.jtf_rfc.setEditable(false);
            this.deshabilitarnuevo();
            this.deshabilitarPanel();
            this.deshabilitareliminar();
            this.habilitarBotonCambio();
            
        }
        public void activarMenu(){
        JFMenu jfmenu=new JFMenu();
        jfmenu.setVisible(true);
        this.setVisible(false);
        }
        public void desactivarProveedores(){
        JFProveedores jfproveedores=new JFProveedores();
        jfproveedores.setVisible(false);
        }
        public void cancelarNuevo(){
            Conectar();
            deshabilitarCancelarN();
            deshabilitarEdicion();
            habilitarPan();
            deshabilitarag();
            habilitarPanel();
            habilitarPanel1();
            habilitareliminar();
            habilitarCancelar();
            habilitarNuevo();
        }
        public void guardarCambios(){
            try{
                String rfc=this.jtf_rfc.getText();
                String nombre=this.jtf_nombre.getText(); 
                String telefono=this.jtf_telefono.getText();
            st.executeUpdate("update proveedor set nombre_comp='"+nombre+"',no_tel='"+telefono+"' where rfc='"+rfc+"';");
            
            JOptionPane.showMessageDialog(this,"Datos Correctamente Modificados" );
            Conectar();
            habilitarCancelar();
            this.habilitarnuevo();
            this.deshabilitarBotonCambio();
            this.deshabilitarEdicion(); 
            this.habilitarPanel();
            this.habilitareliminar();
            habilitarPanel1();
                    
            }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: No se puede modificar datos" + ex.getMessage());
            }
        }
        private void borrarRegistro(){
        try{ 
            String rfc=this.jtf_rfc.getText();
            int resp=JOptionPane.showConfirmDialog(null,"Esta seguro de que desea eliminar el registro actual?");
            if (JOptionPane.OK_OPTION == resp){
                st.executeUpdate("delete from proveedor where rfc='"+rfc+"';");
                JOptionPane.showMessageDialog(this,"Datos Eliminados" );
                Conectar();
            }
        } catch(SQLException err){ 
             JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
         } 
    } 

    /**
     * Creates new form proveedores
     */
    public JFProveedores() {
        initComponents();
        Conectar();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_proveedores = new javax.swing.JLabel();
        jl_rfc = new javax.swing.JLabel();
        jl_nombre = new javax.swing.JLabel();
        jl_telefono = new javax.swing.JLabel();
        jb_cancelar_nuevo = new javax.swing.JButton();
        jp_botonesn = new javax.swing.JPanel();
        jb_registro_anterior = new javax.swing.JButton();
        jb_primer_registro = new javax.swing.JButton();
        jb_registro_siguiente = new javax.swing.JButton();
        jb_ultimo_registro = new javax.swing.JButton();
        jp_mode = new javax.swing.JPanel();
        jb_modificar = new javax.swing.JButton();
        jp_rnt = new javax.swing.JPanel();
        jtf_rfc = new javax.swing.JTextField();
        jtf_nombre = new javax.swing.JTextField();
        jtf_telefono = new javax.swing.JTextField();
        jp_na = new javax.swing.JPanel();
        jb_nuevo = new javax.swing.JButton();
        jp_agregar = new javax.swing.JPanel();
        jb_agregar = new javax.swing.JButton();
        jp_can = new javax.swing.JPanel();
        jb_cancelar = new javax.swing.JButton();
        jP_guardar_cambios = new javax.swing.JPanel();
        jb_guardar_cambio = new javax.swing.JButton();
        jb_eli = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jl_proveedores.setBackground(new java.awt.Color(51, 255, 204));
        jl_proveedores.setFont(new java.awt.Font("Papyrus", 0, 24)); // NOI18N
        jl_proveedores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_proveedores.setText("PROVEEDORES");
        jl_proveedores.setOpaque(true);

        jl_rfc.setText("RFC");

        jl_nombre.setText("NOMBRE");

        jl_telefono.setText("TELEFONO");

        jb_cancelar_nuevo.setFont(new java.awt.Font("Viner Hand ITC", 0, 18)); // NOI18N
        jb_cancelar_nuevo.setForeground(new java.awt.Color(255, 0, 0));
        jb_cancelar_nuevo.setText("CANCELAR");
        jb_cancelar_nuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_cancelar_nuevoMouseClicked(evt);
            }
        });
        jb_cancelar_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelar_nuevoActionPerformed(evt);
            }
        });

        jb_registro_anterior.setText("<<");
        jb_registro_anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_registro_anteriorActionPerformed(evt);
            }
        });

        jb_primer_registro.setBackground(new java.awt.Color(255, 255, 255));
        jb_primer_registro.setText("|<");
        jb_primer_registro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_primer_registroActionPerformed(evt);
            }
        });

        jb_registro_siguiente.setText(">>");
        jb_registro_siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_registro_siguienteActionPerformed(evt);
            }
        });

        jb_ultimo_registro.setText(">|");
        jb_ultimo_registro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_ultimo_registroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_botonesnLayout = new javax.swing.GroupLayout(jp_botonesn);
        jp_botonesn.setLayout(jp_botonesnLayout);
        jp_botonesnLayout.setHorizontalGroup(
            jp_botonesnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_botonesnLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jb_primer_registro)
                .addGap(78, 78, 78)
                .addComponent(jb_registro_anterior)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jb_registro_siguiente)
                .addGap(126, 126, 126)
                .addComponent(jb_ultimo_registro)
                .addGap(71, 71, 71))
        );
        jp_botonesnLayout.setVerticalGroup(
            jp_botonesnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_botonesnLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jp_botonesnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_registro_anterior)
                    .addComponent(jb_primer_registro)
                    .addComponent(jb_registro_siguiente)
                    .addComponent(jb_ultimo_registro))
                .addContainerGap())
        );

        jb_modificar.setFont(new java.awt.Font("Viner Hand ITC", 0, 18)); // NOI18N
        jb_modificar.setForeground(new java.awt.Color(0, 204, 255));
        jb_modificar.setText("MODIFICAR");
        jb_modificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_modificarMouseClicked(evt);
            }
        });
        jb_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_modificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_modeLayout = new javax.swing.GroupLayout(jp_mode);
        jp_mode.setLayout(jp_modeLayout);
        jp_modeLayout.setHorizontalGroup(
            jp_modeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_modeLayout.createSequentialGroup()
                .addComponent(jb_modificar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jp_modeLayout.setVerticalGroup(
            jp_modeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jb_modificar)
        );

        jtf_rfc.setBackground(new java.awt.Color(204, 255, 204));
        jtf_rfc.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jtf_rfc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_rfcActionPerformed(evt);
            }
        });

        jtf_nombre.setBackground(new java.awt.Color(204, 255, 204));
        jtf_nombre.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jtf_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_nombreActionPerformed(evt);
            }
        });

        jtf_telefono.setBackground(new java.awt.Color(204, 255, 204));
        jtf_telefono.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jtf_telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_telefonoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_rntLayout = new javax.swing.GroupLayout(jp_rnt);
        jp_rnt.setLayout(jp_rntLayout);
        jp_rntLayout.setHorizontalGroup(
            jp_rntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtf_telefono, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jtf_nombre, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jtf_rfc)
        );
        jp_rntLayout.setVerticalGroup(
            jp_rntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_rntLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtf_rfc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jtf_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jb_nuevo.setFont(new java.awt.Font("Viner Hand ITC", 0, 18)); // NOI18N
        jb_nuevo.setText("NUEVO");
        jb_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_nuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_naLayout = new javax.swing.GroupLayout(jp_na);
        jp_na.setLayout(jp_naLayout);
        jp_naLayout.setHorizontalGroup(
            jp_naLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_naLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jb_nuevo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jp_naLayout.setVerticalGroup(
            jp_naLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_naLayout.createSequentialGroup()
                .addComponent(jb_nuevo)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jb_agregar.setFont(new java.awt.Font("Viner Hand ITC", 0, 18)); // NOI18N
        jb_agregar.setForeground(new java.awt.Color(102, 204, 0));
        jb_agregar.setText("AGREGAR");
        jb_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_agregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_agregarLayout = new javax.swing.GroupLayout(jp_agregar);
        jp_agregar.setLayout(jp_agregarLayout);
        jp_agregarLayout.setHorizontalGroup(
            jp_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_agregarLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jb_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jp_agregarLayout.setVerticalGroup(
            jp_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_agregarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jb_agregar))
        );

        jb_cancelar.setFont(new java.awt.Font("Viner Hand ITC", 0, 18)); // NOI18N
        jb_cancelar.setForeground(new java.awt.Color(255, 0, 0));
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

        javax.swing.GroupLayout jp_canLayout = new javax.swing.GroupLayout(jp_can);
        jp_can.setLayout(jp_canLayout);
        jp_canLayout.setHorizontalGroup(
            jp_canLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_canLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jb_cancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jp_canLayout.setVerticalGroup(
            jp_canLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jb_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jb_guardar_cambio.setFont(new java.awt.Font("Viner Hand ITC", 0, 18)); // NOI18N
        jb_guardar_cambio.setForeground(new java.awt.Color(102, 204, 0));
        jb_guardar_cambio.setText("AGREGAR");
        jb_guardar_cambio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_guardar_cambioMouseClicked(evt);
            }
        });
        jb_guardar_cambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_guardar_cambioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jP_guardar_cambiosLayout = new javax.swing.GroupLayout(jP_guardar_cambios);
        jP_guardar_cambios.setLayout(jP_guardar_cambiosLayout);
        jP_guardar_cambiosLayout.setHorizontalGroup(
            jP_guardar_cambiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_guardar_cambiosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jb_guardar_cambio, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jP_guardar_cambiosLayout.setVerticalGroup(
            jP_guardar_cambiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_guardar_cambiosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jb_guardar_cambio))
        );

        jb_eli.setFont(new java.awt.Font("Viner Hand ITC", 0, 18)); // NOI18N
        jb_eli.setForeground(new java.awt.Color(255, 0, 0));
        jb_eli.setText("ELIMINAR");
        jb_eli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_eliMouseClicked(evt);
            }
        });
        jb_eli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_eliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_proveedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jl_rfc, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jl_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jl_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jp_rnt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jp_botonesn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jp_na, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jp_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jP_guardar_cambios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jp_mode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jb_eli)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jp_can, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jb_cancelar_nuevo)
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_proveedores)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jl_rfc)
                        .addGap(37, 37, 37)
                        .addComponent(jl_nombre)
                        .addGap(27, 27, 27)
                        .addComponent(jl_telefono))
                    .addComponent(jp_rnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jp_botonesn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jb_cancelar_nuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jp_mode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jp_na, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jp_agregar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jp_can, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jP_guardar_cambios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jb_eli, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                .addGap(92, 92, 92))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtf_rfcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_rfcActionPerformed
    }//GEN-LAST:event_jtf_rfcActionPerformed
    private void jtf_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_nombreActionPerformed
    }//GEN-LAST:event_jtf_nombreActionPerformed
    private void jtf_telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_telefonoActionPerformed
    }//GEN-LAST:event_jtf_telefonoActionPerformed
    private void jb_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_agregarActionPerformed
        guardarRegistro();
    }//GEN-LAST:event_jb_agregarActionPerformed
    private void jb_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_modificarActionPerformed
        modificar();
    }//GEN-LAST:event_jb_modificarActionPerformed
    private void jb_eliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_eliActionPerformed
        borrarRegistro();
    }//GEN-LAST:event_jb_eliActionPerformed

    private void jb_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_nuevoActionPerformed
        nuevo();
    }//GEN-LAST:event_jb_nuevoActionPerformed

    private void jb_primer_registroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_primer_registroActionPerformed
        moverPrimerRegistro();
    }//GEN-LAST:event_jb_primer_registroActionPerformed

    private void jb_registro_anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_registro_anteriorActionPerformed
        moverRegistroAnterior();
    }//GEN-LAST:event_jb_registro_anteriorActionPerformed

    private void jb_registro_siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_registro_siguienteActionPerformed
        moverRegistroSiguiente();
    }//GEN-LAST:event_jb_registro_siguienteActionPerformed

    private void jb_ultimo_registroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_ultimo_registroActionPerformed
        moverUltimoRegistro();
    }//GEN-LAST:event_jb_ultimo_registroActionPerformed

    private void jb_eliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_eliMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_eliMouseClicked

    private void jb_cancelar_nuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_cancelar_nuevoMouseClicked
        cancelarNuevo();
    }//GEN-LAST:event_jb_cancelar_nuevoMouseClicked

    private void jb_cancelar_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelar_nuevoActionPerformed
    }//GEN-LAST:event_jb_cancelar_nuevoActionPerformed

    private void jb_modificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_modificarMouseClicked
     // TODO add your handling code here:
    }//GEN-LAST:event_jb_modificarMouseClicked

    private void jb_guardar_cambioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_guardar_cambioMouseClicked
        guardarCambios();
    }//GEN-LAST:event_jb_guardar_cambioMouseClicked

    private void jb_guardar_cambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_guardar_cambioActionPerformed
        guardarCambios();
    }//GEN-LAST:event_jb_guardar_cambioActionPerformed

    private void jb_cancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_cancelarMouseClicked
        activarMenu();
        desactivarProveedores();
    }//GEN-LAST:event_jb_cancelarMouseClicked

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_cancelarActionPerformed

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
            java.util.logging.Logger.getLogger(JFProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFProveedores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jP_guardar_cambios;
    private javax.swing.JButton jb_agregar;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_cancelar_nuevo;
    private javax.swing.JButton jb_eli;
    private javax.swing.JButton jb_guardar_cambio;
    private javax.swing.JButton jb_modificar;
    private javax.swing.JButton jb_nuevo;
    private javax.swing.JButton jb_primer_registro;
    private javax.swing.JButton jb_registro_anterior;
    private javax.swing.JButton jb_registro_siguiente;
    private javax.swing.JButton jb_ultimo_registro;
    private javax.swing.JLabel jl_nombre;
    private javax.swing.JLabel jl_proveedores;
    private javax.swing.JLabel jl_rfc;
    private javax.swing.JLabel jl_telefono;
    private javax.swing.JPanel jp_agregar;
    private javax.swing.JPanel jp_botonesn;
    private javax.swing.JPanel jp_can;
    private javax.swing.JPanel jp_mode;
    private javax.swing.JPanel jp_na;
    private javax.swing.JPanel jp_rnt;
    private javax.swing.JTextField jtf_nombre;
    private javax.swing.JTextField jtf_rfc;
    private javax.swing.JTextField jtf_telefono;
    // End of variables declaration//GEN-END:variables

    private void exit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setVisisble(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
