package controlador;

import conexion.Conexion;
import modelo.Usuario;
import java.sql.*;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class UsuarioController {

    // Método seguro para iniciar sesión
    public boolean login(Usuario objeto) {
        boolean respuesta = false;
        String sql = "SELECT usuario FROM tb_usuario WHERE usuario = ? AND contraseña = ?";

        try (Connection cn = Conexion.conectar();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, objeto.getUsuario());
            ps.setString(2, objeto.getContraseña());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al iniciar sesión: " + e);
            JOptionPane.showMessageDialog(null, "Error al iniciar sesión");
        }
        return respuesta;
    }
}
