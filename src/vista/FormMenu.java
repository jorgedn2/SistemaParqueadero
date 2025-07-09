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
import java.io.File;
import java.io.FileOutputStream;
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
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import modelo.Usuario;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.base.Strings;
import org.apache.commons.lang3.StringUtils;

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
        jPanel_registrar_vehiculo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtext4 = new javax.swing.JLabel();
        jTextField_placa = new javax.swing.JTextField();
        jTextField_propietario = new javax.swing.JTextField();
        jComboBox_tipo_vehiculo = new javax.swing.JComboBox<>();
        jButton_registrar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jCombo_tipoCliente = new javax.swing.JComboBox<>();
        jPanel_administrar_vehiculos = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField_busqueda_criterio = new javax.swing.JTextField();
        jDateChooser_fecha_busqueda = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_vehiculos = new javax.swing.JTable();
        jButton_buscar = new javax.swing.JButton();
        jPanel_Graficoss = new javax.swing.JPanel();
        jButton_TipoVehiculo = new javax.swing.JButton();
        jButton_Consulta = new javax.swing.JButton();
        jButton_tipoCliente = new javax.swing.JButton();
        jButton_ExportarExcel = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel_Graficos = new javax.swing.JPanel();
        jPanel_retirar_vehiculo = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel_info = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField_placa_retiro = new javax.swing.JTextField();
        jButton_buscar_placa = new javax.swing.JButton();
        jButton_retirar = new javax.swing.JButton();
        jLabel_hora_entrada = new javax.swing.JLabel();
        jLabel_footer = new javax.swing.JLabel();
        jLabel_hora_salida = new javax.swing.JLabel();
        jLabel_valor_pagar = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel_propietario = new javax.swing.JLabel();

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

        jtext4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jtext4.setForeground(new java.awt.Color(255, 51, 51));
        jtext4.setText("Tipo cliente:");
        jPanel_registrar_vehiculo.add(jtext4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, -1, 30));

        jTextField_placa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextField_placa.setForeground(new java.awt.Color(0, 102, 102));
        jTextField_placa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_placaActionPerformed(evt);
            }
        });
        jTextField_placa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_placaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_placaKeyReleased(evt);
            }
        });
        jPanel_registrar_vehiculo.add(jTextField_placa, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 230, 30));

        jTextField_propietario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextField_propietario.setForeground(new java.awt.Color(0, 102, 102));
        jPanel_registrar_vehiculo.add(jTextField_propietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 230, 30));

        jComboBox_tipo_vehiculo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBox_tipo_vehiculo.setForeground(new java.awt.Color(255, 51, 51));
        jComboBox_tipo_vehiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione:", "Motocicleta", "Automovil" }));
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
        jPanel_registrar_vehiculo.add(jButton_registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 230, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 51, 51));
        jLabel8.setText("Tipo de vehiculo:");
        jPanel_registrar_vehiculo.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, -1, 30));

        jCombo_tipoCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jCombo_tipoCliente.setForeground(new java.awt.Color(255, 51, 51));
        jCombo_tipoCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ninguno", "Discapacitado", "Recurrente" }));
        jCombo_tipoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCombo_tipoClienteActionPerformed(evt);
            }
        });
        jPanel_registrar_vehiculo.add(jCombo_tipoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 230, 30));

        jTabbedPane1.addTab("Registrar Vehiculo", jPanel_registrar_vehiculo);

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

        jButton_tipoCliente.setBackground(new java.awt.Color(255, 51, 51));
        jButton_tipoCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_tipoCliente.setForeground(new java.awt.Color(255, 255, 255));
        jButton_tipoCliente.setText("Tipo Cliente");
        jButton_tipoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_tipoClienteActionPerformed(evt);
            }
        });
        jPanel_Graficoss.add(jButton_tipoCliente);

        jButton_ExportarExcel.setBackground(new java.awt.Color(255, 51, 51));
        jButton_ExportarExcel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_ExportarExcel.setForeground(new java.awt.Color(255, 255, 255));
        jButton_ExportarExcel.setText("Exportar");
        jButton_ExportarExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ExportarExcelActionPerformed(evt);
            }
        });
        jPanel_Graficoss.add(jButton_ExportarExcel);

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

        jPanel_retirar_vehiculo.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_retirar_vehiculo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 51, 51));
        jLabel9.setText("Retiro de Vehiculo del Parqueadero");
        jPanel_retirar_vehiculo.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 250, 30));

        jLabel_info.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_info.setForeground(new java.awt.Color(0, 255, 255));
        jLabel_info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_info.setText("Vehiculo Retirado");
        jPanel_retirar_vehiculo.add(jLabel_info, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 250, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 51, 51));
        jLabel10.setText("Placa:");
        jPanel_retirar_vehiculo.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 100, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 51, 51));
        jLabel11.setText("Propietario:");
        jPanel_retirar_vehiculo.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 100, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 51, 51));
        jLabel12.setText("Hora Entrada:");
        jPanel_retirar_vehiculo.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 100, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 51, 51));
        jLabel13.setText("Hora Salida:");
        jPanel_retirar_vehiculo.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 100, 30));

        jTextField_placa_retiro.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextField_placa_retiro.setForeground(new java.awt.Color(0, 102, 102));
        jTextField_placa_retiro.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTextField_placa_retiroAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTextField_placa_retiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_placa_retiroActionPerformed(evt);
            }
        });
        jTextField_placa_retiro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_placa_retiroKeyReleased(evt);
            }
        });
        jPanel_retirar_vehiculo.add(jTextField_placa_retiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 125, 30));

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
        jPanel_retirar_vehiculo.add(jButton_buscar_placa, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 125, 30));

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

        jLabel_hora_entrada.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel_hora_entrada.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_hora_entrada.setText("00:00:00");
        jPanel_retirar_vehiculo.add(jLabel_hora_entrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 200, 30));

        jLabel_footer.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel_footer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_footer.setText("Desarrollado por grupo 5");
        jPanel_retirar_vehiculo.add(jLabel_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 600, 30));

        jLabel_hora_salida.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel_hora_salida.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_hora_salida.setText("00:00:00");
        jPanel_retirar_vehiculo.add(jLabel_hora_salida, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 200, 30));

        jLabel_valor_pagar.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel_valor_pagar.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_valor_pagar.setText("S/ 0.00");
        jPanel_retirar_vehiculo.add(jLabel_valor_pagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 200, 30));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 51, 51));
        jLabel15.setText("Valor a Pagar:");
        jPanel_retirar_vehiculo.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 100, 30));

        jLabel_propietario.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel_propietario.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_propietario.setText("ALGUIEN");
        jPanel_retirar_vehiculo.add(jLabel_propietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 200, 30));

        jTabbedPane1.addTab("Retirar Vehiculo", jPanel_retirar_vehiculo);

        jPanel2.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 600, 340));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 650, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_cerrar_sesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cerrar_sesionActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton_cerrar_sesionActionPerformed

    private void jComboBox_tipo_vehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_tipo_vehiculoActionPerformed
        
    }//GEN-LAST:event_jComboBox_tipo_vehiculoActionPerformed

    private void jButton_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_registrarActionPerformed
    String placa = jTextField_placa.getText().trim().toUpperCase();
    String propietario = jTextField_propietario.getText().trim();

    if (placa.length() == 6 && !placa.contains("-")) {
        placa = placa.substring(0, 3) + "-" + placa.substring(3);
    }

    // Validar con Apache Commons Lang
    if (StringUtils.isBlank(placa) || StringUtils.isBlank(propietario)) {
        JOptionPane.showMessageDialog(null, "Ingrese la placa y el propietario");
        return;
    }

    String tipo_vehiculo = jComboBox_tipo_vehiculo.getSelectedItem().toString().trim();
    if (StringUtils.equalsIgnoreCase(tipo_vehiculo, "Seleccione:")) {
        JOptionPane.showMessageDialog(null, "Seleccione un tipo de vehículo");
        return;
    }

    // Crear objeto Vehiculo
    VehiculoController controlVehiculo = new VehiculoController();
    Vehiculo vehiculo = new Vehiculo();

    vehiculo.setPlaca(placa);
    vehiculo.setPropietario(propietario);
    vehiculo.setTipoVehiculo(tipo_vehiculo);

    // Tipo de Cliente
    String tipo_cliente = jCombo_tipoCliente.getSelectedItem().toString().trim();
    vehiculo.setTipoCliente(tipo_cliente);

    // Fecha de entrada
    DateFormat dateFormatFecha = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Calendar calendar = Calendar.getInstance();
    Date date = calendar.getTime();
    String fecha = dateFormatFecha.format(date);

    vehiculo.setHoraEntrada(fecha);
    vehiculo.setHoraSalida(null);
    vehiculo.setEstado("INGRESADO");

    // Usuario que registra
    vehiculo.setIdUsuario(usuarioActual.getIdUsuario());
    if (vehiculo.getIdUsuario() <= 0) {
        JOptionPane.showMessageDialog(null, "ERROR: No se ha establecido un usuario válido.");
        return;
    }

    // Guardar vehículo
    if (controlVehiculo.guardar(vehiculo)) {
        JOptionPane.showMessageDialog(null, "**Vehículo ingresado correctamente**");
        this.cargarTablaVehiculos();
        jTextField_placa.setText("");
        jTextField_propietario.setText("");
        jComboBox_tipo_vehiculo.setSelectedItem("Seleccione:");
        jCombo_tipoCliente.setSelectedItem("Ninguno");
    } else {
        JOptionPane.showMessageDialog(null, "ERROR al ingresar el registro del vehículo");
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
            model.addColumn("Tipo Cliente");
            model.addColumn("Tipo de Vehiculo");
            model.addColumn("Valor pagado");
            model.addColumn("Estado");

            Object fila[] = new Object[7];
            for (Vehiculo vehiculo : listaVehiculo) {
                fila[0] = vehiculo.getIdVehiculo();
                fila[1] = vehiculo.getPlaca();
                fila[2] = vehiculo.getPropietario();
                fila[3] = vehiculo.getTipoCliente();
                fila[4] = vehiculo.getTipoVehiculo();
                fila[5] = vehiculo.getValorPagado();
                fila[6] = vehiculo.getEstado();
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
       String placaBuscar = jTextField_placa_retiro.getText().trim();
    String estado = "", salida = "";
    double valor = 0.00;

    if (placaBuscar.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Ingrese una placa");
    } else {
        Connection cn = Conexion.conectar();
        String sql = "SELECT * FROM tb_vehiculo WHERE placa = '" + placaBuscar + "'";
        Statement st;

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                idVehiculo = rs.getInt("id_vehiculo");
                jLabel_propietario.setText(rs.getString("propietario"));
                jComboBox_tipo_vehiculo.setSelectedItem(rs.getString("tipo_cliente"));
                jLabel_hora_entrada.setText(rs.getString("hora_entrada"));
                salida = rs.getString("hora_salida");
                valor = rs.getDouble("valor_pagado");
                estado = rs.getString("estado");

                String tipoVehiculo = rs.getString("tipo_vehiculo");
                String tipoCliente = rs.getString("cliente");
                String tiempoIngresado = rs.getString("hora_entrada");
                Date tiempo = dateFormat.parse(tiempoIngresado);
                int minutosACobrar = (int) (date.getTime() - tiempo.getTime()) / 60000;
                int horas = minutosACobrar / 60;
                int minutosExtra = minutosACobrar % 60;

                //Aplica tolerancia de 15 minutos
                if (horas == 0 && minutosExtra <= 15) {
                    valorAPagar = 0.00;
                } else {
                    if (minutosExtra > 15) {
                        horas += 1;
                    }

                    //Tarifa base por tipo de vehículo
                    if (tipoVehiculo.equals("Automovil")) {
                        valorAPagar = horas * 5;
                    } else if (tipoVehiculo.equals("Motocicleta")) {
                        valorAPagar = horas * 2.5;
                    }

                    //Aplica descuento según tipo de cliente
                    switch (tipoCliente.toUpperCase()) {
                        case "Recurrente":
                            valorAPagar *= 0.70; // 30% de descuento
                            break;
                        case "Discapacitado":
                            valorAPagar *= 0.50; // 50% de descuento
                            break;
                        case "Ninguno":
                        default:
                            // Sin descuento
                            break;
                    }
                }

                //Mostrar hora de salida y valor a pagar
                String fecha = dateFormat.format(date);
                jLabel_hora_salida.setText(fecha);
                jLabel_valor_pagar.setText("S/ " + String.format("%.2f", valorAPagar));

                //Comprobar si ya egresó
                if (estado.equalsIgnoreCase("EGRESADO")) {
                    jButton_retirar.setEnabled(false);
                    jLabel_info.setVisible(true);
                    jLabel_hora_salida.setText(salida);
                    jLabel_valor_pagar.setText("S/ " + String.format("%.2f", valor));
                } else {
                    jButton_retirar.setEnabled(true);
                    jLabel_info.setVisible(false);
                }

            } else {
                JOptionPane.showMessageDialog(null, "PLACA NO REGISTRADA");
                jLabel_propietario.setText("Nadie");
                jLabel_hora_entrada.setText("00:00:00");
                jLabel_hora_salida.setText("00:00:00");
                jLabel_valor_pagar.setText("S/ 0.00");
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar datos del vehículo: " + e);
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
        //commons
        Multimap<String, String> tipos = ArrayListMultimap.create();
        Map<String, Double> dataMap = new LinkedHashMap<>();

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vehiculos", "root", "");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT tipo_vehiculo FROM tb_vehiculo");

            while (rs.next()) {
                String tipo = Strings.nullToEmpty(rs.getString("tipo_vehiculo")).trim();
                tipos.put(tipo, tipo);
            }

            int totalCarros = tipos.get("Automovil").size();
            int totalMotos = tipos.get("Motocicleta").size();

            dataMap.put("Automovil", (double) totalCarros);
            dataMap.put("Motocicleta", (double) totalMotos);

            String resumen = "Automóviles: " + totalCarros + " — Motocicletas: " + totalMotos;
            mostrarGraficoEnPanel(dataMap, "Cantidad por Tipo de Vehículo", resumen, false);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar datos de tipos:\n" + e.getMessage());
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

    private void jTextField_placa_retiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_placa_retiroActionPerformed
        String texto = jTextField_placa.getText().replace("-", "").toUpperCase();

    if (texto.length() > 6) {
        texto = texto.substring(0, 6); // Limita a 6 caracteres
    }

    if (texto.length() >= 3) {
        texto = texto.substring(0, 3) + "-" + texto.substring(3);
    }

    jTextField_placa.setText(texto);
    }//GEN-LAST:event_jTextField_placa_retiroActionPerformed

    private void jTextField_placaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_placaActionPerformed

    }//GEN-LAST:event_jTextField_placaActionPerformed

    private void jTextField_placaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_placaKeyReleased
        
    String texto = jTextField_placa.getText().replace("-", "").toUpperCase();

    if (texto.length() > 6) {
        texto = texto.substring(0, 6); // Limita a 6 caracteres
    }

    if (texto.length() >= 3) {
        texto = texto.substring(0, 3) + "-" + texto.substring(3);
    }

    jTextField_placa.setText(texto);

    }//GEN-LAST:event_jTextField_placaKeyReleased

    private void jButton_ExportarExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ExportarExcelActionPerformed
try {
        Connection cn = Conexion.conectar();
        Workbook workbook = new XSSFWorkbook();

        // HOJA 1: Lista de vehículos
        Sheet sheetVehiculos = workbook.createSheet("Vehiculos");
        Statement st1 = cn.createStatement();
        ResultSet rs1 = st1.executeQuery("SELECT placa, propietario, tipo_vehiculo, valor_pagado, estado FROM tb_vehiculo");

        Row header = sheetVehiculos.createRow(0);
        String[] columnas = {"Placa", "Propietario", "Tipo", "Valor Pagado", "Estado"};
        for (int i = 0; i < columnas.length; i++) {
            header.createCell(i).setCellValue(columnas[i]);
        }

        int rowIdx = 1;
        while (rs1.next()) {
            Row row = sheetVehiculos.createRow(rowIdx++);
            row.createCell(0).setCellValue(rs1.getString("placa"));
            row.createCell(1).setCellValue(rs1.getString("propietario"));
            row.createCell(2).setCellValue(rs1.getString("tipo_vehiculo"));
            row.createCell(3).setCellValue(rs1.getDouble("valor_pagado"));
            row.createCell(4).setCellValue(rs1.getString("estado"));
        }

        // HOJA 2: Resumen Tipos (Vehículos y Usuarios)
        Sheet sheetResumenTipos = workbook.createSheet("Resumen Tipos");

        // Parte 1: Tipos de vehículos
        Statement st2 = cn.createStatement();
        ResultSet rs2 = st2.executeQuery("SELECT tipo_vehiculo, COUNT(*) as cantidad FROM tb_vehiculo GROUP BY tipo_vehiculo");

        Row header2 = sheetResumenTipos.createRow(0);
        header2.createCell(0).setCellValue("Tipo de Vehículo");
        header2.createCell(1).setCellValue("Cantidad");

        int rowIdx2 = 1;
        while (rs2.next()) {
            Row row = sheetResumenTipos.createRow(rowIdx2++);
            row.createCell(0).setCellValue(rs2.getString("tipo_vehiculo"));
            row.createCell(1).setCellValue(rs2.getInt("cantidad"));
        }

        // Espacio entre tablas
        rowIdx2 += 2;

        // Parte 2: Tipos de usuarios
        Statement stUsuarios = cn.createStatement();
        ResultSet rsUsuarios = stUsuarios.executeQuery("SELECT tipo_cliente, COUNT(*) AS cantidad FROM tb_vehiculo GROUP BY tipo_cliente");

        Row headerUsuarios = sheetResumenTipos.createRow(rowIdx2++);
        headerUsuarios.createCell(0).setCellValue("Tipo de Cliente");
        headerUsuarios.createCell(1).setCellValue("Cantidad");

        while (rsUsuarios.next()) {
            Row row = sheetResumenTipos.createRow(rowIdx2++);
            row.createCell(0).setCellValue(rsUsuarios.getString("tipo_cliente"));
            row.createCell(1).setCellValue(rsUsuarios.getInt("cantidad"));
        }
        
        rowIdx2 += 2;

        Statement st3 = cn.createStatement();
        ResultSet rs3 = st3.executeQuery("SELECT MONTH(hora_salida) AS mes, SUM(valor_pagado) AS total FROM tb_vehiculo WHERE estado = 'EGRESADO' GROUP BY mes ORDER BY mes");

        Row header3 = sheetResumenTipos.createRow(0);
        header3.createCell(0).setCellValue("Mes");
        header3.createCell(1).setCellValue("Total Ganado (S/.)");

        int rowIdx3 = 1;
        while (rs3.next()) {
            Row row = sheetResumenTipos.createRow(rowIdx3++);
            int mes = rs3.getInt("mes");
            double total = rs3.getDouble("total");

            String[] nombresMeses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
            String nombreMes = (mes >= 1 && mes <= 12) ? nombresMeses[mes - 1] : "Desconocido";

            row.createCell(0).setCellValue(nombreMes);
            row.createCell(1).setCellValue(total);
        }

        // GUARDAR ARCHIVO
        String ruta = System.getProperty("user.home");
        FileOutputStream out = new FileOutputStream(ruta + "/Desktop/vehiculos_exportados.xlsx");
        workbook.write(out);
        out.close();
        workbook.close();

        JOptionPane.showMessageDialog(this, "Archivo Excel generado correctamente en tu escritorio.");

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al exportar: " + e.getMessage());
    }
    }//GEN-LAST:event_jButton_ExportarExcelActionPerformed

    private void jTextField_placa_retiroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_placa_retiroKeyReleased
        String texto = jTextField_placa.getText().replace("-", "").toUpperCase();

    if (texto.length() > 6) {
        texto = texto.substring(0, 6); // Limita a 6 caracteres
    }

    if (texto.length() >= 3) {
        texto = texto.substring(0, 3) + "-" + texto.substring(3);
    }

    jTextField_placa.setText(texto);
    }//GEN-LAST:event_jTextField_placa_retiroKeyReleased

    private void jCombo_tipoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCombo_tipoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCombo_tipoClienteActionPerformed

    private void jButton_tipoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_tipoClienteActionPerformed
       Map<String, Double> dataMap = new LinkedHashMap<>();
    StringBuilder resumenPorTipo = new StringBuilder();

    try {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vehiculos", "root", "");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT tipo_cliente, COUNT(*) AS cantidad FROM tb_vehiculo GROUP BY tipo_cliente");

        while (rs.next()) {
            String tipoCliente = rs.getString("tipo_cliente");
            int cantidad = rs.getInt("cantidad");

            resumenPorTipo.append(tipoCliente).append(": ").append(cantidad).append("\n");

            dataMap.put(tipoCliente, (double) cantidad);
        }

        mostrarGraficoEnPanel(dataMap, "Cantidad por Tipo de Cliente", resumenPorTipo.toString(), false);

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al generar gráfico de tipos de cliente:\n" + e.getMessage());
    } 
    }//GEN-LAST:event_jButton_tipoClienteActionPerformed

    private void jTextField_placa_retiroAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTextField_placa_retiroAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_placa_retiroAncestorAdded

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
    private javax.swing.JButton jButton_ExportarExcel;
    private javax.swing.JButton jButton_TipoVehiculo;
    private javax.swing.JButton jButton_buscar;
    private javax.swing.JButton jButton_buscar_placa;
    private javax.swing.JButton jButton_cerrar_sesion;
    private javax.swing.JButton jButton_registrar;
    private javax.swing.JButton jButton_retirar;
    private javax.swing.JButton jButton_tipoCliente;
    private javax.swing.JComboBox<String> jComboBox_tipo_vehiculo;
    private javax.swing.JComboBox<String> jCombo_tipoCliente;
    private com.toedter.calendar.JDateChooser jDateChooser_fecha_busqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
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
    private javax.swing.JLabel jtext4;
    // End of variables declaration//GEN-END:variables

    private void cargarTablaVehiculos() {
    Connection cn = Conexion.conectar();
    DefaultTableModel model = new DefaultTableModel();
    String sql = "SELECT v.id_vehiculo, v.placa, v.propietario, v.tipo_vehiculo,v.tipo_cliente, v.valor_pagado, v.estado, u.usuario AS registrado_por " +
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
        model.addColumn("Tipo de cliente");
        model.addColumn("Valor pagado");
        model.addColumn("Estado");
        model.addColumn("Registrado por");

        while (rs.next()) {
            Object fila[] = new Object[8];
            for (int i = 0; i < 8; i++) {
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
                DetalleVehiculo.jLabel_tipo_vehiculo_detalle.setText(rs.getString("tipo_cliente"));
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
