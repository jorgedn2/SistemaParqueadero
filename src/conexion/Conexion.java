package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Conexion {
    private static final Logger logger = LoggerFactory.getLogger(Conexion.class);

    public static Connection conectar() {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/vehiculos", "root", "");
            logger.info("Conexión establecida con la base de datos.");
            return cn;
        } catch (SQLException e) {
            logger.error("Error en la conexión local", e);
            return null;
        }
    }
}
