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
 
public class JFJirafita extends javax.swing.JFrame {

    /**
     * Creates new form jirafita
     */
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    
 public void Conectar() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/la_jirafa", "root", "");
            st = conexion.createStatement();
            rs = st.executeQuery("Select * from inventario;");
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
            JOptionPane.showMessageDialog(null, "Error 001" + ex.getMessage());
        }
    }

    public void llenarDatos() {
        try {
            this.jtf_id.setText(rs.getString("id"));
            this.jtf_color.setText(rs.getString("color"));
            this.jtf_marca.setText(rs.getString("marca"));
            this.jtf_modelo.setText(rs.getString("modelo"));
            this.jtf_nombre_descripcion.setText(rs.getString("nomb_desc"));
            this.jtf_existencias.setText(rs.getString("existencias"));
            this.jtf_precio.setText(rs.getString("precio"));
            this.jtf_rfc_proveedor.setText(rs.getString("rfc"));
            deshabilitarEdicion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 002" + ex.getMessage());
        }
    }
        public void nuevo(){
            this.jtf_id.setText(String.valueOf(""));
            this.jtf_color.setText(String.valueOf(""));
            this.jtf_marca.setText(String.valueOf(""));
            this.jtf_modelo.setText(String.valueOf(""));
            this.jtf_nombre_descripcion.setText(String.valueOf(""));
            this.jtf_existencias.setText(String.valueOf(""));
            this.jtf_precio.setText(String.valueOf(""));
            this.jtf_rfc_proveedor.setText(String.valueOf(""));
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
        public void habilitarNuevo(){
            jp_na.setVisible(true);     
         }
        public void deshabilitarNuevo(){
            jp_na.setVisible(false);
        }
        public void habilitarCancelar(){
    jb_cancelar.setVisible(true);
}
        public void deahabilitarCancelar(){
    jb_cancelar.setVisible(false);
        }
        public void habilitarPanel(){
            jp_botonesn.setVisible(true);     
        }
        public void deshabilitarPanel(){
            jp_botonesn.setVisible(false);
        }
        public void habilitarnuevo(){
            jp_na.setVisible(true);   
        }
        public void deshabilitarnuevo(){
            jp_na.setVisible(false);
        }
        public void habilitarPanel1(){
            jp_mode.setVisible(true);
        }
        public void deshabilitarPanel1(){
            jp_mode.setVisible(false);
        }
        public void habilitarag(){
            jp_agregar.setVisible(true);  
        }
        public void deshabilitarag(){
            jp_agregar.setVisible(false);
        }
        public void habilitarBotonCambio(){
            jP_guardar_cambios.setVisible(true);
        }
        public void deshabilitarBotonCambio(){
            jP_guardar_cambios.setVisible(false);
        }
        public void habilitareliminar(){
            jp_eli.setVisible(true);    
        }
        public void deshabilitareliminar(){
            jp_eli.setVisible(false);
        }
        public void habilitarCancelarN(){
            jb_cancelar_nuevo.setVisible(true);    
        }
        public void deshabilitarCancelarN(){
            jb_cancelar_nuevo.setVisible(false);
        }
        public void habilitarPan(){
            jP_llenardatos.setVisible(true);
            
        }
        public void deshabilitarPan(){
            jP_llenardatos.setVisible(false);
        }
        
        public void deshabilitarEdicion(){
        jtf_id.setEditable(false);
        jtf_color.setEditable(false);
        jtf_marca.setEditable(false);
        jtf_modelo.setEditable(false);
        jtf_nombre_descripcion.setEditable(false);
        jtf_existencias.setEditable(false);
        jtf_precio.setEditable(false);
        jtf_rfc_proveedor.setEditable(false);
        }
        public void habilitarEdicion(){
        jtf_id.setEditable(true);
        jtf_color.setEditable(true);
        jtf_marca.setEditable(true);
        jtf_modelo.setEditable(true);
        jtf_nombre_descripcion.setEditable(true);
        jtf_existencias.setEditable(true);
        jtf_precio.setEditable(true);
        jtf_rfc_proveedor.setEditable(true);
        this.deshabilitarnuevo();
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
        public void activarMenu(){
        JFMenu jfmenu=new JFMenu();
        jfmenu.setVisible(true);
        this.setVisible(false);
        }
        public void desactivarInventario(){
        JFJirafita jfjirafita=new JFJirafita();
        jfjirafita.setVisible(false);
        }
       
        public void agregar(){
            try{
                String id=this.jtf_id.getText(); 
                String marca=this.jtf_marca.getText(); 
                String color=this.jtf_color.getText();
                String modelo=this.jtf_modelo.getText();
                String nombre_desc=this.jtf_nombre_descripcion.getText();
                String existencias=this.jtf_existencias.getText();
                String precio=this.jtf_precio.getText();
                String rfc=this.jtf_rfc_proveedor.getText();

            st.executeUpdate("Insert into inventario (id,color,marca, modelo, nomb_desc,existencias, precio,rfc)"+" values ('"+ id +"','"+marca+"','"+color+"','"+modelo+"','"+nombre_desc+"','"+existencias+"','"+precio+"','"+rfc+"');"); 
            JOptionPane.showMessageDialog(this,"Datos insertados Correctamente" );
            cancelarNuevo();
            
            }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: No se puede agregar datos" + ex.getMessage());
            }
        }
        
        public void modificar(){ 
            habilitarCancelarN();
            deahabilitarCancelar();
            this.deshabilitarPanel1();
            this.habilitarEdicion();
            this.jtf_id.setEditable(false);
            this.jtf_existencias.setEditable(false);
            this.deshabilitarnuevo();
            this.deshabilitarPanel();
            this.deshabilitareliminar();
            this.habilitarBotonCambio();
        }
        public void guardarCambios(){
            try{
                String id=this.jtf_id.getText(); 
                String marca=this.jtf_marca.getText(); 
                String color=this.jtf_color.getText();
                String modelo=this.jtf_modelo.getText();
                String nombre_desc=this.jtf_nombre_descripcion.getText();
                String existencias=this.jtf_existencias.getText();
                String precio=this.jtf_precio.getText();
                String rfc=this.jtf_rfc_proveedor.getText();

            st.executeUpdate("update inventario set color='"+color+"',marca='"+marca+"',modelo='"+modelo+"',nomb_desc='"+nombre_desc+"',existencias='"+existencias+"',precio='"+precio+"',rfc='"+rfc+"' where id='"+id+"';");
            JOptionPane.showMessageDialog(this,"Datos Correctamente Modificados" );
            
            cancelarNuevo();
            }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: No se puede modificar datos" + ex.getMessage());
            }
        }
         private void borrarRegistro(){
        try{ 
            int resp=JOptionPane.showConfirmDialog(null,"Esta seguro de que desea eliminar el registro actual?");
            if (JOptionPane.OK_OPTION == resp){
                st.executeUpdate("delete from inventario where id="+this.jtf_id.getText());
                JOptionPane.showMessageDialog(this,"Datos Eliminados" );
                Conectar();
            }
        } catch(SQLException err){ 
             JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
         } 
    } 
        

    
    public JFJirafita() {
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

        jl_inventario = new javax.swing.JLabel();
        jb_cancelar = new javax.swing.JButton();
        jp_botonesn = new javax.swing.JPanel();
        jb_ultimo_registro = new javax.swing.JButton();
        jb_registro_siguiente = new javax.swing.JButton();
        jb_registro_anterior = new javax.swing.JButton();
        jb_primer_registro = new javax.swing.JButton();
        jp_na = new javax.swing.JPanel();
        jb_nuevo = new javax.swing.JButton();
        jp_agregar = new javax.swing.JPanel();
        jb_agregar = new javax.swing.JButton();
        jp_mode = new javax.swing.JPanel();
        jb_modificar = new javax.swing.JButton();
        jp_eli = new javax.swing.JPanel();
        jb_eliminar = new javax.swing.JButton();
        jP_llenardatos = new javax.swing.JPanel();
        jl_id1 = new javax.swing.JLabel();
        jtf_id = new javax.swing.JTextField();
        jl_color1 = new javax.swing.JLabel();
        jtf_color = new javax.swing.JTextField();
        jl_marca1 = new javax.swing.JLabel();
        jtf_marca = new javax.swing.JTextField();
        jl_modelo1 = new javax.swing.JLabel();
        jtf_modelo = new javax.swing.JTextField();
        jl_nombre_descripcion1 = new javax.swing.JLabel();
        jtf_nombre_descripcion = new javax.swing.JTextField();
        jl_existencias1 = new javax.swing.JLabel();
        jtf_existencias = new javax.swing.JTextField();
        jl_precio2 = new javax.swing.JLabel();
        jtf_precio = new javax.swing.JTextField();
        jl_rfc_proveedor1 = new javax.swing.JLabel();
        jtf_rfc_proveedor = new javax.swing.JTextField();
        jP_guardar_cambios = new javax.swing.JPanel();
        jb_guardar_cambio = new javax.swing.JButton();
        jb_cancelar_nuevo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jl_inventario.setBackground(new java.awt.Color(51, 255, 204));
        jl_inventario.setFont(new java.awt.Font("Papyrus", 0, 24)); // NOI18N
        jl_inventario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_inventario.setText("INVENTARIO");
        jl_inventario.setOpaque(true);

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

        jb_ultimo_registro.setText(">|");
        jb_ultimo_registro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_ultimo_registroActionPerformed(evt);
            }
        });

        jb_registro_siguiente.setText(">>");
        jb_registro_siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_registro_siguienteActionPerformed(evt);
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

        javax.swing.GroupLayout jp_botonesnLayout = new javax.swing.GroupLayout(jp_botonesn);
        jp_botonesn.setLayout(jp_botonesnLayout);
        jp_botonesnLayout.setHorizontalGroup(
            jp_botonesnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_botonesnLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jb_primer_registro)
                .addGap(107, 107, 107)
                .addComponent(jb_registro_anterior)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jb_registro_siguiente)
                .addGap(79, 79, 79)
                .addComponent(jb_ultimo_registro)
                .addGap(142, 142, 142))
        );
        jp_botonesnLayout.setVerticalGroup(
            jp_botonesnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_botonesnLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_botonesnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jb_ultimo_registro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jp_botonesnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jb_registro_anterior, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jb_registro_siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jb_primer_registro, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addGap(0, 1, Short.MAX_VALUE))
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

        jb_eliminar.setFont(new java.awt.Font("Viner Hand ITC", 0, 18)); // NOI18N
        jb_eliminar.setForeground(new java.awt.Color(255, 0, 0));
        jb_eliminar.setText("ELIMINAR");
        jb_eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_eliminarMouseClicked(evt);
            }
        });
        jb_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_eliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_eliLayout = new javax.swing.GroupLayout(jp_eli);
        jp_eli.setLayout(jp_eliLayout);
        jp_eliLayout.setHorizontalGroup(
            jp_eliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_eliLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jb_eliminar)
                .addContainerGap())
        );
        jp_eliLayout.setVerticalGroup(
            jp_eliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jb_eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jl_id1.setFont(new java.awt.Font("Viner Hand ITC", 0, 14)); // NOI18N
        jl_id1.setForeground(new java.awt.Color(255, 153, 0));
        jl_id1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_id1.setText("ID");

        jtf_id.setEditable(false);
        jtf_id.setBackground(new java.awt.Color(204, 255, 204));
        jtf_id.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jtf_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_idActionPerformed(evt);
            }
        });

        jl_color1.setFont(new java.awt.Font("Viner Hand ITC", 0, 14)); // NOI18N
        jl_color1.setForeground(new java.awt.Color(255, 153, 0));
        jl_color1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_color1.setText("COLOR");

        jtf_color.setEditable(false);
        jtf_color.setBackground(new java.awt.Color(204, 255, 204));
        jtf_color.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jtf_color.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_colorActionPerformed(evt);
            }
        });

        jl_marca1.setFont(new java.awt.Font("Viner Hand ITC", 0, 14)); // NOI18N
        jl_marca1.setForeground(new java.awt.Color(255, 153, 0));
        jl_marca1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_marca1.setText("MARCA");

        jtf_marca.setEditable(false);
        jtf_marca.setBackground(new java.awt.Color(204, 255, 204));
        jtf_marca.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jtf_marca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_marcaActionPerformed(evt);
            }
        });

        jl_modelo1.setFont(new java.awt.Font("Viner Hand ITC", 0, 14)); // NOI18N
        jl_modelo1.setForeground(new java.awt.Color(255, 153, 0));
        jl_modelo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_modelo1.setText("MODELO");

        jtf_modelo.setEditable(false);
        jtf_modelo.setBackground(new java.awt.Color(204, 255, 204));
        jtf_modelo.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jtf_modelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_modeloActionPerformed(evt);
            }
        });

        jl_nombre_descripcion1.setFont(new java.awt.Font("Viner Hand ITC", 0, 14)); // NOI18N
        jl_nombre_descripcion1.setForeground(new java.awt.Color(255, 153, 0));
        jl_nombre_descripcion1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_nombre_descripcion1.setText("NOMBRE DESCRIPCIÓN");

        jtf_nombre_descripcion.setEditable(false);
        jtf_nombre_descripcion.setBackground(new java.awt.Color(204, 255, 204));
        jtf_nombre_descripcion.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jl_existencias1.setFont(new java.awt.Font("Viner Hand ITC", 0, 14)); // NOI18N
        jl_existencias1.setForeground(new java.awt.Color(255, 153, 0));
        jl_existencias1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_existencias1.setText("EXISTENCIAS");

        jtf_existencias.setEditable(false);
        jtf_existencias.setBackground(new java.awt.Color(204, 255, 204));
        jtf_existencias.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jtf_existencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_existenciasActionPerformed(evt);
            }
        });

        jl_precio2.setFont(new java.awt.Font("Viner Hand ITC", 0, 14)); // NOI18N
        jl_precio2.setForeground(new java.awt.Color(255, 153, 0));
        jl_precio2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_precio2.setText("PRECIO");

        jtf_precio.setEditable(false);
        jtf_precio.setBackground(new java.awt.Color(204, 255, 204));
        jtf_precio.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jl_rfc_proveedor1.setFont(new java.awt.Font("Viner Hand ITC", 0, 14)); // NOI18N
        jl_rfc_proveedor1.setForeground(new java.awt.Color(255, 153, 0));
        jl_rfc_proveedor1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_rfc_proveedor1.setText("RFC-Proveedor");

        jtf_rfc_proveedor.setEditable(false);
        jtf_rfc_proveedor.setBackground(new java.awt.Color(204, 255, 204));
        jtf_rfc_proveedor.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        javax.swing.GroupLayout jP_llenardatosLayout = new javax.swing.GroupLayout(jP_llenardatos);
        jP_llenardatos.setLayout(jP_llenardatosLayout);
        jP_llenardatosLayout.setHorizontalGroup(
            jP_llenardatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_llenardatosLayout.createSequentialGroup()
                .addGroup(jP_llenardatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jl_existencias1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jl_precio2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jl_rfc_proveedor1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jP_llenardatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtf_precio)
                    .addComponent(jtf_rfc_proveedor)
                    .addComponent(jtf_existencias)))
            .addGroup(jP_llenardatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jP_llenardatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jP_llenardatosLayout.createSequentialGroup()
                        .addGroup(jP_llenardatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jP_llenardatosLayout.createSequentialGroup()
                                .addComponent(jl_marca1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtf_marca))
                            .addGroup(jP_llenardatosLayout.createSequentialGroup()
                                .addComponent(jl_id1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtf_id, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jP_llenardatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jP_llenardatosLayout.createSequentialGroup()
                                .addComponent(jl_color1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jtf_color))
                            .addGroup(jP_llenardatosLayout.createSequentialGroup()
                                .addComponent(jl_modelo1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jtf_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jl_nombre_descripcion1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtf_nombre_descripcion))
                .addContainerGap())
        );
        jP_llenardatosLayout.setVerticalGroup(
            jP_llenardatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_llenardatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jP_llenardatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_id1)
                    .addGroup(jP_llenardatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtf_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtf_color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jl_color1))
                .addGap(18, 18, 18)
                .addGroup(jP_llenardatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_marca1)
                    .addGroup(jP_llenardatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtf_marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jl_modelo1)
                        .addComponent(jtf_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jl_nombre_descripcion1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtf_nombre_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jP_llenardatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_existencias1)
                    .addComponent(jtf_existencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jP_llenardatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_precio2)
                    .addComponent(jtf_precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jP_llenardatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_rfc_proveedor1)
                    .addComponent(jtf_rfc_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_guardar_cambiosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jb_guardar_cambio, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jP_guardar_cambiosLayout.setVerticalGroup(
            jP_guardar_cambiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_guardar_cambiosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jb_guardar_cambio))
        );

        jb_cancelar_nuevo.setFont(new java.awt.Font("Viner Hand ITC", 0, 18)); // NOI18N
        jb_cancelar_nuevo.setForeground(new java.awt.Color(255, 0, 0));
        jb_cancelar_nuevo.setText("Cancelar");
        jb_cancelar_nuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_cancelar_nuevoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp_botonesn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jl_inventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jp_na, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jp_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jp_mode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jp_eli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jb_cancelar))
                            .addComponent(jP_llenardatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(335, 335, 335)
                                .addComponent(jP_guardar_cambios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jb_cancelar_nuevo)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jl_inventario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jP_llenardatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jP_guardar_cambios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jb_cancelar_nuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jp_botonesn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jp_na, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jp_agregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jp_mode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jp_eli, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jb_cancelar))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
        
    }//GEN-LAST:event_jb_cancelarActionPerformed

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

    private void jb_cancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_cancelarMouseClicked
        activarMenu();
        desactivarInventario();
    }//GEN-LAST:event_jb_cancelarMouseClicked

    private void jb_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_nuevoActionPerformed
        nuevo();
    }//GEN-LAST:event_jb_nuevoActionPerformed

    private void jb_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_agregarActionPerformed
        agregar();
    }//GEN-LAST:event_jb_agregarActionPerformed

    private void jb_modificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_modificarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_modificarMouseClicked

    private void jb_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_modificarActionPerformed
        modificar();
    }//GEN-LAST:event_jb_modificarActionPerformed

    private void jb_eliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_eliminarMouseClicked
        borrarRegistro();
    }//GEN-LAST:event_jb_eliminarMouseClicked

    private void jb_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_eliminarActionPerformed
        borrarRegistro();
    }//GEN-LAST:event_jb_eliminarActionPerformed

    private void jtf_existenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_existenciasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_existenciasActionPerformed

    private void jtf_modeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_modeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_modeloActionPerformed

    private void jtf_marcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_marcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_marcaActionPerformed

    private void jtf_colorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_colorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_colorActionPerformed

    private void jtf_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_idActionPerformed

    private void jb_guardar_cambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_guardar_cambioActionPerformed
        guardarCambios();
    }//GEN-LAST:event_jb_guardar_cambioActionPerformed

    private void jb_guardar_cambioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_guardar_cambioMouseClicked
        guardarCambios();
    }//GEN-LAST:event_jb_guardar_cambioMouseClicked

    private void jb_cancelar_nuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_cancelar_nuevoMouseClicked
        cancelarNuevo();
    }//GEN-LAST:event_jb_cancelar_nuevoMouseClicked

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
            java.util.logging.Logger.getLogger(JFJirafita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFJirafita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFJirafita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFJirafita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFJirafita().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jP_guardar_cambios;
    private javax.swing.JPanel jP_llenardatos;
    private javax.swing.JButton jb_agregar;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_cancelar_nuevo;
    private javax.swing.JButton jb_eliminar;
    private javax.swing.JButton jb_guardar_cambio;
    private javax.swing.JButton jb_modificar;
    private javax.swing.JButton jb_nuevo;
    private javax.swing.JButton jb_primer_registro;
    private javax.swing.JButton jb_registro_anterior;
    private javax.swing.JButton jb_registro_siguiente;
    private javax.swing.JButton jb_ultimo_registro;
    private javax.swing.JLabel jl_color1;
    private javax.swing.JLabel jl_existencias1;
    private javax.swing.JLabel jl_id1;
    private javax.swing.JLabel jl_inventario;
    private javax.swing.JLabel jl_marca1;
    private javax.swing.JLabel jl_modelo1;
    private javax.swing.JLabel jl_nombre_descripcion1;
    private javax.swing.JLabel jl_precio2;
    private javax.swing.JLabel jl_rfc_proveedor1;
    private javax.swing.JPanel jp_agregar;
    private javax.swing.JPanel jp_botonesn;
    private javax.swing.JPanel jp_eli;
    private javax.swing.JPanel jp_mode;
    private javax.swing.JPanel jp_na;
    private javax.swing.JTextField jtf_color;
    private javax.swing.JTextField jtf_existencias;
    private javax.swing.JTextField jtf_id;
    private javax.swing.JTextField jtf_marca;
    private javax.swing.JTextField jtf_modelo;
    private javax.swing.JTextField jtf_nombre_descripcion;
    private javax.swing.JTextField jtf_precio;
    private javax.swing.JTextField jtf_rfc_proveedor;
    // End of variables declaration//GEN-END:variables

    private void setVisisble(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
