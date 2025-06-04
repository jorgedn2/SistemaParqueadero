package controlador;

import conexion.Conexion;
import modelo.Usuario;
import java.sql.*;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class UsuarioController {

    // Método para iniciar sesión y devolver el usuario autenticado
    public Usuario login(String usuario, String contraseña) {
        Usuario usuarioAutenticado = null;
        String sql = "SELECT * FROM tb_usuario WHERE usuario = ? AND contraseña = ?";

        try (Connection cn = Conexion.conectar();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, usuario);
            ps.setString(2, contraseña);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usuarioAutenticado = new Usuario();
                usuarioAutenticado.setIdUsuario(rs.getInt("id_usuario"));
                usuarioAutenticado.setUsuario(rs.getString("usuario"));
                usuarioAutenticado.setContraseña(rs.getString("contraseña"));
                usuarioAutenticado.setEstado(rs.getString("estado"));
            }

        } catch (SQLException e) {
            System.out.println("Error al iniciar sesión: " + e);
            JOptionPane.showMessageDialog(null, "Error al iniciar sesión");
        }
        return usuarioAutenticado;
    }
}

