package vista;

import conexion.Conexion;
import controlador.ReportesController;
import controlador.VehiculoController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Vehiculo;
import java.sql.*;
import java.text.ParseException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import modelo.Usuario;

public class FormMenu extends javax.swing.JFrame {

    private int idVehiculo = 0;
    private double valorAPagar = 0;
    private Usuario usuarioActual;

    public FormMenu(Usuario usuario) {
        initComponents();
        this.usuarioActual = usuario; // Guarda el usuario que inició sesión
        this.setTitle("Menú Principal - Bienvenido " + usuarioActual.getUsuario());
        this.setLocationRelativeTo(null);
    }
    public FormMenu() {
        initComponents();
        initComponents();
        this.setSize(900, 415);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Sistema de Parqueadero");
        this.cargarTablaVehiculos();
        jLabel_info.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel_logo = new javax.swing.JLabel();
        jButton_cerrar_sesion = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel_retirar_vehiculo = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel_info = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField_placa_retiro = new javax.swing.JTextField();
        jButton_buscar_placa = new javax.swing.JButton();
        jButton_retirar = new javax.swing.JButton();
        jLabel_propietario = new javax.swing.JLabel();
        jLabel_hora_entrada = new javax.swing.JLabel();
        jLabel_footer = new javax.swing.JLabel();
        jLabel_hora_salida = new javax.swing.JLabel();
        jLabel_valor_pagar = new javax.swing.JLabel();
        jPanel_administrar_vehiculos = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField_busqueda_criterio = new javax.swing.JTextField();
        jDateChooser_fecha_busqueda = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_vehiculos = new javax.swing.JTable();
        jButton_buscar = new javax.swing.JButton();
        jPanel_registrar_vehiculo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField_placa = new javax.swing.JTextField();
        jTextField_propietario = new javax.swing.JTextField();
        jComboBox_tipo_vehiculo = new javax.swing.JComboBox<>();
        jButton_registrar = new javax.swing.JButton();
        jPanel_Graficoss = new javax.swing.JPanel();
        jButton_TipoVehiculo = new javax.swing.JButton();
        jButton_Consulta = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel_Graficos = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("SISTEMA DE PARQUEADERO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLabel_logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/estacionamiento.png"))); // NOI18N
        jPanel1.add(jLabel_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 180, 160));

        jButton_cerrar_sesion.setBackground(new java.awt.Color(255, 51, 51));
        jButton_cerrar_sesion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_cerrar_sesion.setForeground(new java.awt.Color(255, 255, 255));
        jButton_cerrar_sesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salir.png"))); // NOI18N
        jButton_cerrar_sesion.setText("CERRAR SESION");
        jButton_cerrar_sesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cerrar_sesionActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_cerrar_sesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 210, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 380));

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setForeground(new java.awt.Color(255, 51, 51));

        jPanel_retirar_vehiculo.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_retirar_vehiculo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 51, 51));
        jLabel9.setText("Retiro de Vehiculo del Parqueadero");
        jPanel_retirar_vehiculo.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 250, 30));

        jLabel_info.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_info.setForeground(new java.awt.Color(0, 255, 255));
        jLabel_info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_info.setText("Vehiculo Retirado");
        jPanel_retirar_vehiculo.add(jLabel_info, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 250, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 51, 51));
        jLabel10.setText("Placa:");
        jPanel_retirar_vehiculo.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 100, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 51, 51));
        jLabel11.setText("Propietario:");
        jPanel_retirar_vehiculo.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 100, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 51, 51));
        jLabel12.setText("Hora Entrada:");
        jPanel_retirar_vehiculo.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 100, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 51, 51));
        jLabel13.setText("Hora Salida:");
        jPanel_retirar_vehiculo.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 100, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 51, 51));
        jLabel14.setText("Valor a Pagar:");
        jPanel_retirar_vehiculo.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 100, 30));

        jTextField_placa_retiro.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextField_placa_retiro.setForeground(new java.awt.Color(0, 102, 102));
        jPanel_retirar_vehiculo.add(jTextField_placa_retiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 125, 30));

        jButton_buscar_placa.setBackground(new java.awt.Color(0, 0, 0));
        jButton_buscar_placa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_buscar_placa.setForeground(new java.awt.Color(255, 255, 255));
        jButton_buscar_placa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lupa.png"))); // NOI18N
        jButton_buscar_placa.setText("BUSCAR");
        jButton_buscar_placa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_buscar_placaActionPerformed(evt);
            }
        });
        jPanel_retirar_vehiculo.add(jButton_buscar_placa, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 125, 30));

        jButton_retirar.setBackground(new java.awt.Color(0, 0, 0));
        jButton_retirar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_retirar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_retirar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/coche.png"))); // NOI18N
        jButton_retirar.setText("RETIRAR");
        jButton_retirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_retirarActionPerformed(evt);
            }
        });
        jPanel_retirar_vehiculo.add(jButton_retirar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 250, 30));

        jLabel_propietario.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel_propietario.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_propietario.setText("ALGUIEN");
        jPanel_retirar_vehiculo.add(jLabel_propietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 200, 30));

        jLabel_hora_entrada.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel_hora_entrada.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_hora_entrada.setText("00:00:00");
        jPanel_retirar_vehiculo.add(jLabel_hora_entrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 200, 30));

        jLabel_footer.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel_footer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_footer.setText("Desarrollado por grupo 5");
        jPanel_retirar_vehiculo.add(jLabel_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 600, 30));

        jLabel_hora_salida.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel_hora_salida.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_hora_salida.setText("00:00:00");
        jPanel_retirar_vehiculo.add(jLabel_hora_salida, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 200, 30));

        jLabel_valor_pagar.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel_valor_pagar.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_valor_pagar.setText("S/ 0.00");
        jPanel_retirar_vehiculo.add(jLabel_valor_pagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 200, 30));

        jTabbedPane1.addTab("Retirar Vehiculo", jPanel_retirar_vehiculo);

        jPanel_administrar_vehiculos.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_administrar_vehiculos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 51, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Administracion del Parqueadero de Vehiculos");
        jPanel_administrar_vehiculos.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 580, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 51, 51));
        jLabel7.setText("Placa/Propietario");
        jPanel_administrar_vehiculos.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 30));

        jTextField_busqueda_criterio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField_busqueda_criterio.setForeground(new java.awt.Color(0, 102, 102));
        jPanel_administrar_vehiculos.add(jTextField_busqueda_criterio, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 200, 30));

        jDateChooser_fecha_busqueda.setForeground(new java.awt.Color(0, 102, 102));
        jDateChooser_fecha_busqueda.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel_administrar_vehiculos.add(jDateChooser_fecha_busqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 150, 30));

        jTable_vehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable_vehiculos);

        jPanel_administrar_vehiculos.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 85, 580, 180));

        jButton_buscar.setBackground(new java.awt.Color(255, 51, 51));
        jButton_buscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_buscar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lupa.png"))); // NOI18N
        jButton_buscar.setText("BUSCAR");
        jButton_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_buscarActionPerformed(evt);
            }
        });
        jPanel_administrar_vehiculos.add(jButton_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, 130, 30));

        jTabbedPane1.addTab("Administrar Vehiculo", jPanel_administrar_vehiculos);

        jPanel_registrar_vehiculo.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_registrar_vehiculo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("Registro de ingreso de vehiculos al parqueadero");
        jPanel_registrar_vehiculo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("Placa:");
        jPanel_registrar_vehiculo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, -1, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 51));
        jLabel4.setText("Propietario:");
        jPanel_registrar_vehiculo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, -1, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 51));
        jLabel5.setText("Tipo de vehiculo:");
        jPanel_registrar_vehiculo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, -1, 30));

        jTextField_placa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextField_placa.setForeground(new java.awt.Color(0, 102, 102));
        jTextField_placa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_placaKeyPressed(evt);
            }
        });
        jPanel_registrar_vehiculo.add(jTextField_placa, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 230, 30));

        jTextField_propietario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextField_propietario.setForeground(new java.awt.Color(0, 102, 102));
        jPanel_registrar_vehiculo.add(jTextField_propietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 230, 30));

        jComboBox_tipo_vehiculo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBox_tipo_vehiculo.setForeground(new java.awt.Color(255, 51, 51));
        jComboBox_tipo_vehiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione:", "Automovil", "Motocicleta" }));
        jComboBox_tipo_vehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_tipo_vehiculoActionPerformed(evt);
            }
        });
        jPanel_registrar_vehiculo.add(jComboBox_tipo_vehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 230, 30));

        jButton_registrar.setBackground(new java.awt.Color(255, 51, 51));
        jButton_registrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_registrar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/coche-revisado.png"))); // NOI18N
        jButton_registrar.setText("REGISTRAR");
        jButton_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_registrarActionPerformed(evt);
            }
        });
        jPanel_registrar_vehiculo.add(jButton_registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 230, 30));

        jTabbedPane1.addTab("Registrar Vehiculo", jPanel_registrar_vehiculo);

        jPanel_Graficoss.setBackground(new java.awt.Color(255, 255, 255));

        jButton_TipoVehiculo.setBackground(new java.awt.Color(255, 51, 51));
        jButton_TipoVehiculo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_TipoVehiculo.setForeground(new java.awt.Color(255, 255, 255));
        jButton_TipoVehiculo.setText("Tipo Vehiculo");
        jButton_TipoVehiculo.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jButton_TipoVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TipoVehiculoActionPerformed(evt);
            }
        });
        jPanel_Graficoss.add(jButton_TipoVehiculo);

        jButton_Consulta.setBackground(new java.awt.Color(255, 51, 51));
        jButton_Consulta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_Consulta.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Consulta.setText("Consulta Mensual");
        jButton_Consulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ConsultaActionPerformed(evt);
            }
        });
        jPanel_Graficoss.add(jButton_Consulta);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel_Graficoss.add(jPanel3);

        jPanel_Graficos.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_Graficos.setMinimumSize(new java.awt.Dimension(350, 340));
        jPanel_Graficos.setPreferredSize(new java.awt.Dimension(350, 250));
        jPanel_Graficoss.add(jPanel_Graficos);

        jTabbedPane1.addTab("Graficos", jPanel_Graficoss);

        jPanel2.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 600, 340));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 650, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_cerrar_sesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cerrar_sesionActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton_cerrar_sesionActionPerformed

    private void jComboBox_tipo_vehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_tipo_vehiculoActionPerformed
        
    }//GEN-LAST:event_jComboBox_tipo_vehiculoActionPerformed

    private void jButton_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_registrarActionPerformed
        String placa = jTextField_placa.getText().trim();
    String propietario = jTextField_propietario.getText().trim();

    if (placa.isEmpty() || propietario.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Ingrese los datos");
    } else {
        String tipo_vehiculo = jComboBox_tipo_vehiculo.getSelectedItem().toString().trim();
        if (tipo_vehiculo.equalsIgnoreCase("Seleccione:")) {
            JOptionPane.showMessageDialog(null, "Seleccione un tipo de vehiculo");
        } else {
            VehiculoController controlVehiculo = new VehiculoController();
            Vehiculo vehiculo = new Vehiculo();
            vehiculo.setPlaca(placa);
            vehiculo.setPropietario(propietario);
            vehiculo.setTipoVehiculo(tipo_vehiculo);

            DateFormat dateFormatFecha = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Calendar calendar = Calendar.getInstance();
            Date date = calendar.getTime();
            String fecha = dateFormatFecha.format(date);

            vehiculo.setHoraEntrada(fecha);
            vehiculo.setHoraSalida(null);
            vehiculo.setEstado("INGRESADO");

            // 👇 ESTA ES LA LÍNEA QUE FALTABA
            vehiculo.setIdUsuario(usuarioActual.getIdUsuario());

            // Validación
            if (vehiculo.getIdUsuario() <= 0) {
                JOptionPane.showMessageDialog(null, "ERROR: No se ha establecido un usuario válido.");
                return;
            }

            if (controlVehiculo.guardar(vehiculo)) {
                JOptionPane.showMessageDialog(null, "**Vehiculo ingresado correctamente**");
                this.cargarTablaVehiculos();
                jTextField_placa.setText("");
                jTextField_propietario.setText("");
                jComboBox_tipo_vehiculo.setSelectedItem("Seleccione:");
            } else {
                JOptionPane.showMessageDialog(null, "ERROR al ingresar el registro del vehiculo");
            }
        }
    }

    }//GEN-LAST:event_jButton_registrarActionPerformed

    private void jTextField_placaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_placaKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            jTextField_propietario.requestFocus();
        }
    }//GEN-LAST:event_jTextField_placaKeyPressed

    private void jButton_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_buscarActionPerformed

        String PlacaPropietarioBusqueda = jTextField_busqueda_criterio.getText().trim();
        Date fechaBusqueda = jDateChooser_fecha_busqueda.getDate();
        String fechaComoCadena = "";
        if (fechaBusqueda != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            fechaComoCadena = sdf.format(fechaBusqueda);
        }

        if (PlacaPropietarioBusqueda.isEmpty() && fechaComoCadena.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese Placa o Propietario para busqueda");
            this.cargarTablaVehiculos();
        } else {
            VehiculoController vehiculoController = new VehiculoController();
            vehiculoController.buscarVehiculoPlacaFecha(PlacaPropietarioBusqueda, fechaComoCadena);
            ArrayList<Vehiculo> listaVehiculo = vehiculoController.listaVehiculo;

            DefaultTableModel model = new DefaultTableModel();
            this.jTable_vehiculos = new JTable(model);
            this.jScrollPane1.setViewportView(this.jTable_vehiculos);
            model.addColumn("N°");
            model.addColumn("Placa");
            model.addColumn("Propietario");
            model.addColumn("Tipo de Vehiculo");
            model.addColumn("Valor pagado");
            model.addColumn("Estado");

            Object fila[] = new Object[6];
            for (Vehiculo vehiculo : listaVehiculo) {
                fila[0] = vehiculo.getIdVehiculo();
                fila[1] = vehiculo.getPlaca();
                fila[2] = vehiculo.getPropietario();
                fila[3] = vehiculo.getTipoVehiculo();
                fila[4] = vehiculo.getValorPagado();
                fila[5] = vehiculo.getEstado();
                model.addRow(fila);

            }

            //evento
            jTable_vehiculos.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int fila_point = jTable_vehiculos.rowAtPoint(e.getPoint());
                    int columna_point = 0;

                    if (fila_point > -1) {
                        idVehiculo = (int) model.getValueAt(fila_point, columna_point);
                        EnviarDatosVehiculoSeleccionado(idVehiculo);
                    }
                }
            });
        }

        jTextField_busqueda_criterio.setText("");


    }//GEN-LAST:event_jButton_buscarActionPerformed

    private void jButton_buscar_placaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_buscar_placaActionPerformed
       String placaBuscar=jTextField_placa_retiro.getText().trim();
       String estado="", salida="";
       double valor = 0.00;
       
       if(placaBuscar.isEmpty()){
           JOptionPane.showMessageDialog(null,"Ingrese una placa");
       }else{
           Connection cn = Conexion.conectar();
           String sql = "select * from tb_vehiculo where placa = '" + placaBuscar + "'";
           Statement st;
           
           DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
           Calendar calendar = Calendar.getInstance();
           Date date = calendar.getTime();
           
           try{
               st=cn.createStatement();
               ResultSet rs = st.executeQuery(sql);
               
               if(rs.next()){
                   idVehiculo =rs.getInt("id_vehiculo");
                   jLabel_propietario.setText(rs.getString("propietario"));
                   jLabel_hora_entrada.setText(rs.getString("hora_entrada"));
                   salida = rs.getString("hora_salida");
                   valor = rs.getDouble("valor_pagado");
                   estado= rs.getString("estado");
                   
                   String tiempoIngresado = rs.getString("hora_entrada");
                   Date tiempo =dateFormat.parse(tiempoIngresado);
                   int minutosACobrar=(int)(date.getTime()-tiempo.getTime())/60000;
                   
                   if(rs.getString("tipo_vehiculo").equals("Automovil")){
                       if(minutosACobrar<60){
                           valorAPagar =0.50;
                       }else{
                           valorAPagar =((minutosACobrar-60)*0.01)+ 0.50;
                       }
                   }else if(rs.getString("tipo_vehiculo").equals("Motocicleta")){
                       if(minutosACobrar<60){
                           valorAPagar =0.25;
                       }else{
                           valorAPagar =((minutosACobrar-60)*0.01)+ 0.25;
                       }
                   }
                   
                   String fecha = dateFormat.format(date);
                   jLabel_hora_salida.setText(fecha);
                   jLabel_valor_pagar.setText("$ " + valorAPagar);
                   if(estado.equalsIgnoreCase("EGRESADO")){
                       jButton_retirar.setEnabled(false);
                       jLabel_info.setVisible(true);
                       jLabel_hora_salida.setText(salida);
                       jLabel_valor_pagar.setText(String.valueOf(valor));
                   }else{
                       jButton_retirar.setEnabled(true);
                       jLabel_info.setVisible(false);
                       
                       
                   }
                   
               }else{
                   JOptionPane.showMessageDialog(null,"PLACA NO REGISTRADA");
                   jLabel_propietario.setText("");
                   jLabel_hora_entrada.setText("00:00:00");
                   jLabel_hora_salida.setText("00:00:00");
                   jLabel_valor_pagar.setText("$ 0.00");
               }
           }catch(SQLException e){
               System.out.println("Error al buscar datos del vehiculo" + e);
           } catch (ParseException ex) {
               Logger.getLogger(FormMenu.class.getName()).log(Level.SEVERE, null, ex);
           }
           
           
       }
    }//GEN-LAST:event_jButton_buscar_placaActionPerformed

    private void jButton_retirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_retirarActionPerformed
        if (jLabel_propietario.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "SELECCIONE UN VEHICULO");
    } else {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        String fecha = dateFormat.format(date);

        Vehiculo vehiculo = new Vehiculo();
        VehiculoController vehiculoController = new VehiculoController();

        vehiculo.setHoraSalida(fecha);
        vehiculo.setValorPagado(valorAPagar);
        vehiculo.setEstado("EGRESADO");

        if (vehiculoController.actualizar(vehiculo, idVehiculo)) {
            JOptionPane.showMessageDialog(null, "VEHICULO RETIRADO");
            this.cargarTablaVehiculos();

            jTextField_placa_retiro.setText("");
            jLabel_propietario.setText("");
            jLabel_hora_entrada.setText("00:00:00");
            jLabel_hora_salida.setText("00:00:00");
            jLabel_valor_pagar.setText("S/ 0.00");

            ReportesController ticket = new ReportesController();
            try {
                ticket.TicketRetiro(idVehiculo);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al generar el ticket de retiro: " + e.getMessage());
                e.printStackTrace();
            }

        } else {
            System.out.println("ERROR AL ACTUALIZAR");
        }
    }
    }//GEN-LAST:event_jButton_retirarActionPerformed

    private void jButton_TipoVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TipoVehiculoActionPerformed
        Map<String, Double> dataMap = new LinkedHashMap<>();
    int totalCarros = 0;
    int totalMotos = 0;
    StringBuilder resumenPorTipo = new StringBuilder();

    try {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vehiculos", "root", "");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT tipo_vehiculo, COUNT(*) AS cantidad FROM tb_vehiculo GROUP BY tipo_vehiculo");

        while (rs.next()) {
            String tipo = rs.getString("tipo_vehiculo");
            int cantidad = rs.getInt("cantidad");

            if (tipo.equalsIgnoreCase("Automovil")) {
                totalCarros = cantidad;
            } else if (tipo.equalsIgnoreCase("Motocicleta")) {
                totalMotos = cantidad;
            }

            dataMap.put(tipo, (double) cantidad);
        }

        mostrarGraficoEnPanel(dataMap, "Cantidad por Tipo de Vehículo", resumenPorTipo.toString(), false);

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al generar gráfico de tipos de vehículos:\n" + e.getMessage());
    }
    }//GEN-LAST:event_jButton_TipoVehiculoActionPerformed

    private void jButton_ConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ConsultaActionPerformed
        Map<String, Double> dataMap = new LinkedHashMap<>();
    double totalGanado = 0;
    StringBuilder resumenPorMes = new StringBuilder();

    try {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vehiculos", "root", "");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT MONTH(hora_salida) AS mes, SUM(valor_pagado) AS total FROM tb_vehiculo WHERE estado = 'EGRESADO' GROUP BY mes ORDER BY mes");

        while (rs.next()) {
            int mes = rs.getInt("mes");
            double total = rs.getDouble("total");
            String nombreMes = obtenerNombreMes(mes);
            dataMap.put(nombreMes, total);
            totalGanado += total;
        }

        resumenPorMes.append(" TOTAL: S/").append(String.format("%.2f", totalGanado));
        mostrarGraficoEnPanel(dataMap, "Ganancia por Mes", resumenPorMes.toString(),false);

    } catch (Exception e) {
        e.printStackTrace();
    }
    }//GEN-LAST:event_jButton_ConsultaActionPerformed

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
            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Consulta;
    private javax.swing.JButton jButton_TipoVehiculo;
    private javax.swing.JButton jButton_buscar;
    private javax.swing.JButton jButton_buscar_placa;
    private javax.swing.JButton jButton_cerrar_sesion;
    private javax.swing.JButton jButton_registrar;
    private javax.swing.JButton jButton_retirar;
    private javax.swing.JComboBox<String> jComboBox_tipo_vehiculo;
    private com.toedter.calendar.JDateChooser jDateChooser_fecha_busqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_footer;
    private javax.swing.JLabel jLabel_hora_entrada;
    private javax.swing.JLabel jLabel_hora_salida;
    private javax.swing.JLabel jLabel_info;
    private javax.swing.JLabel jLabel_logo;
    private javax.swing.JLabel jLabel_propietario;
    private javax.swing.JLabel jLabel_valor_pagar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel_Graficos;
    private javax.swing.JPanel jPanel_Graficoss;
    private javax.swing.JPanel jPanel_administrar_vehiculos;
    private javax.swing.JPanel jPanel_registrar_vehiculo;
    private javax.swing.JPanel jPanel_retirar_vehiculo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable_vehiculos;
    private javax.swing.JTextField jTextField_busqueda_criterio;
    private javax.swing.JTextField jTextField_placa;
    private javax.swing.JTextField jTextField_placa_retiro;
    private javax.swing.JTextField jTextField_propietario;
    // End of variables declaration//GEN-END:variables

    private void cargarTablaVehiculos() {
    Connection cn = Conexion.conectar();
    DefaultTableModel model = new DefaultTableModel();
    String sql = "SELECT v.id_vehiculo, v.placa, v.propietario, v.tipo_vehiculo, v.valor_pagado, v.estado, u.usuario AS registrado_por " +
                 "FROM tb_vehiculo v INNER JOIN tb_usuario u ON v.id_usuario = u.id_usuario";
    Statement st;
    try {
        st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        this.jTable_vehiculos = new JTable(model);
        this.jScrollPane1.setViewportView(this.jTable_vehiculos);

        model.addColumn("N°");
        model.addColumn("Placa");
        model.addColumn("Propietario");
        model.addColumn("Tipo de vehiculo");
        model.addColumn("Valor pagado");
        model.addColumn("Estado");
        model.addColumn("Registrado por");

        while (rs.next()) {
            Object fila[] = new Object[7];
            for (int i = 0; i < 7; i++) {
                fila[i] = rs.getObject(i + 1);
            }
            model.addRow(fila);
        }
    } catch (SQLException e) {
        System.out.println("ERROR AL LLENAR LA TABLA DE VEHICULOS: " + e);
    }

    //evento
    jTable_vehiculos.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int fila_point = jTable_vehiculos.rowAtPoint(e.getPoint());
            int columna_point = 0;

            if (fila_point > -1) {
                idVehiculo = (int) model.getValueAt(fila_point, columna_point);
                EnviarDatosVehiculoSeleccionado(idVehiculo);
            }
        }
    });
}

    //metodo que envia datos
    private void EnviarDatosVehiculoSeleccionado(int idVehiculo) {
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select*from tb_vehiculo where id_vehiculo = '" + idVehiculo + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                DetalleVehiculo detalle = new DetalleVehiculo();
                detalle.setVisible(true);

                DetalleVehiculo.jLabel_placa_detalle.setText(rs.getString("placa"));
                DetalleVehiculo.jLabel_propietario_detalle.setText(rs.getString("propietario"));
                DetalleVehiculo.jLabel_hora_entrada_detalle.setText(rs.getString("hora_entrada"));
                DetalleVehiculo.jLabel_hora_salida_detalle.setText(rs.getString("hora_salida"));
                DetalleVehiculo.jLabel_valor_pagado_detalle.setText(rs.getString("valor_pagado"));
                DetalleVehiculo.jLabel_tipo_vehiculo_detalle.setText(rs.getString("tipo_vehiculo"));
                DetalleVehiculo.jLabel_estado_detalle.setText(rs.getString("estado"));
            }

        } catch (SQLException e) {
            System.out.println("ERROR AL SELECCIONAR VEHICULO" + e);
        }
    }
    
    //mostrar grafico en panel
    private void mostrarGraficoEnPanel(Map<String, Double> data, String titulo, String resumenTexto, boolean esMonto) {
    jPanel_Graficos.removeAll();
    jPanel_Graficos.setLayout(new BorderLayout());

    JPanel panel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;

            int width = getWidth();
            int height = getHeight();
            int padding = 60;
            int barWidth = 40;
            int spacing = 50;

            double max = data.values().stream().max(Double::compare).orElse(1.0);

            int x = padding;

            // Título
            g2.setFont(new Font("SansSerif", Font.BOLD, 16));
            g2.setColor(Color.BLACK);
            g2.drawString(titulo, width / 2 - 80, 30);

            // Dibujar barras
            g2.setFont(new Font("SansSerif", Font.PLAIN, 12));
            for (Map.Entry<String, Double> entry : data.entrySet()) {
                int barHeight = (int) ((entry.getValue() / max) * (height - 120));
                int y = height - barHeight - 40;

                g2.setColor(Color.RED);
                g2.fillRect(x, y, barWidth, barHeight);
                g2.setColor(Color.BLACK);
                g2.drawRect(x, y, barWidth, barHeight);

                // Etiqueta: nombre + valor
                String valorTexto = esMonto
                    ? "S/ " + String.format("%.2f", entry.getValue())
                    : String.valueOf(entry.getValue().intValue());

                String label = entry.getKey() + " (" + valorTexto + ")";
                int labelWidth = g2.getFontMetrics().stringWidth(label);
                g2.drawString(label, x - (labelWidth / 2) + (barWidth / 2), height - 15);

                x += barWidth + spacing;
            }

            // Resumen
            g2.setColor(Color.BLUE);
            g2.setFont(new Font("SansSerif", Font.BOLD, 13));
            g2.drawString(resumenTexto, padding + 5, height - 5);
        }

        @Override
        public java.awt.Dimension getPreferredSize() {
            return new java.awt.Dimension(600, 300);
        }
    };

    panel.setOpaque(true);
    panel.setBackground(Color.WHITE);

    jPanel_Graficos.add(panel, BorderLayout.CENTER);
    jPanel_Graficos.revalidate();
    jPanel_Graficos.repaint();
}


    private String obtenerNombreMes(int mes) {
    String[] meses = {"Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"};
    if (mes >= 1 && mes <= 12) {
        return meses[mes - 1];
    } else {
        return "Desconocido";
    }
    }


}
