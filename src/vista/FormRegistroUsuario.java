
package vista;

import controlador.UsuarioController;
import javax.swing.*;
import java.awt.event.*;
import modelo.Usuario;

public class FormRegistroUsuario extends javax.swing.JFrame {

    private JTextField txtUsuario;
    private JPasswordField txtContraseña;
    private JComboBox<String> comboEstado;
    private JButton btnRegistrar;

    public FormRegistroUsuario() {
        setTitle("Registro de Usuario");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(30, 30, 100, 25);
        add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(140, 30, 200, 25);
        add(txtUsuario);

        JLabel lblContraseña = new JLabel("Contraseña:");
        lblContraseña.setBounds(30, 70, 100, 25);
        add(lblContraseña);

        txtContraseña = new JPasswordField();
        txtContraseña.setBounds(140, 70, 200, 25);
        add(txtContraseña);

        JLabel lblEstado = new JLabel("Estado:");
        lblEstado.setBounds(30, 110, 100, 25);
        add(lblEstado);

        comboEstado = new JComboBox<>(new String[]{"activo", "inactivo"});
        comboEstado.setBounds(140, 110, 200, 25);
        add(comboEstado);

        btnRegistrar = new JButton("Registrar Usuario");
        btnRegistrar.setBounds(110, 160, 160, 30);
        add(btnRegistrar);

        btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrarUsuario();
            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FormRegistroUsuario().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private void registrarUsuario() {
        String usuario = txtUsuario.getText().trim();
        String contraseña = String.valueOf(txtContraseña.getPassword()).trim();
        String estado = comboEstado.getSelectedItem().toString();

        if (usuario.isEmpty() || contraseña.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.");
            return;
        }

        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setUsuario(usuario);
        nuevoUsuario.setContraseña(contraseña);
        nuevoUsuario.setEstado(estado);

        UsuarioController controller = new UsuarioController();
        boolean registrado = controller.registrar(nuevoUsuario);

        if (registrado) {
            JOptionPane.showMessageDialog(this, "Usuario registrado correctamente.");
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar usuario.");
        }
    }

}
