package conexion;

import java.sql.*;

public class Conexion {

    public static Connection conectar() {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/vehiculos", "root", "");
            return cn;
        } catch (SQLException e) {
            System.out.println("Error en la conexión local: " + e);
            return null;
        }
    }
}
