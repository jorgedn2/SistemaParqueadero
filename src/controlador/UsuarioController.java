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
    
    
    public boolean registrar(Usuario usuario) {
    String sql = "INSERT INTO tb_usuario (usuario, contraseña, estado) VALUES (?, ?, ?)";
        try (Connection cn = Conexion.conectar();
             PreparedStatement pst = cn.prepareStatement(sql)) {

            pst.setString(1, usuario.getUsuario());
            pst.setString(2, usuario.getContraseña());
            pst.setString(3, usuario.getEstado());

            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al registrar usuario: " + e);
            return false;
        }
    }

}

