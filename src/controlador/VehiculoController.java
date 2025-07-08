/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import conexion.Conexion;
import modelo.Vehiculo;
import java.sql.*;
import java.sql.ResultSet;
import java.util.ArrayList;

public class VehiculoController {
    
    public boolean guardar(Vehiculo objeto){
    boolean respuesta = false;
    Connection cn = Conexion.conectar();
    try {
        PreparedStatement consulta = cn.prepareStatement(
            "INSERT INTO tb_vehiculo (placa, propietario, tipo_vehiculo, hora_entrada, hora_salida, valor_pagado, estado, tipo_cliente, id_usuario) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"
        );


            consulta.setString(1, objeto.getPlaca());
            consulta.setString(2, objeto.getPropietario());
            consulta.setString(3, objeto.getTipoVehiculo());
            consulta.setString(4, objeto.getHoraEntrada());
            consulta.setString(5, objeto.getHoraSalida());
            consulta.setDouble(6, objeto.getValorPagado());
            consulta.setString(7, objeto.getEstado());
            consulta.setString(8, objeto.getTipoCliente());
            consulta.setInt(9, objeto.getIdUsuario());


        if (consulta.executeUpdate() > 0) {
            respuesta = true;
        }
    } catch (SQLException e) {
        System.out.println("Error al registrar vehículo: " + e);
    }
    return respuesta;
}

    // metodo consulta vehiculo a buscar
    public ArrayList<Vehiculo> listaVehiculo = new ArrayList<>();

public ArrayList<Vehiculo> buscarVehiculoPlacaFecha(String placaPropietario, String fecha) {
    listaVehiculo.clear(); // Limpiar resultados anteriores
    fecha = fecha.replace("/", "-");
    
    String sql = "";
    
    if (!placaPropietario.isEmpty() && !fecha.isEmpty()) {
        sql = "SELECT * FROM tb_vehiculo WHERE (placa LIKE ? OR propietario LIKE ?) AND hora_entrada LIKE ?";
    } else if (!placaPropietario.isEmpty()) {
        sql = "SELECT * FROM tb_vehiculo WHERE placa LIKE ? OR propietario LIKE ?";
    } else if (!fecha.isEmpty()) {
        sql = "SELECT * FROM tb_vehiculo WHERE hora_entrada LIKE ?";
    }

    try {
        Connection cn = Conexion.conectar();
        PreparedStatement pst = cn.prepareStatement(sql);
        
        if (!placaPropietario.isEmpty() && !fecha.isEmpty()) {
            pst.setString(1, "%" + placaPropietario + "%");
            pst.setString(2, "%" + placaPropietario + "%");
            pst.setString(3, fecha + "%");
        } else if (!placaPropietario.isEmpty()) {
            pst.setString(1, "%" + placaPropietario + "%");
            pst.setString(2, "%" + placaPropietario + "%");
        } else if (!fecha.isEmpty()) {
            pst.setString(1, fecha + "%");
        }

        ResultSet rs = pst.executeQuery();
        
        while (rs.next()) {
            Vehiculo vehiculo = new Vehiculo();
            vehiculo.setIdVehiculo(rs.getInt("id_vehiculo"));
            vehiculo.setPlaca(rs.getString("placa"));
            vehiculo.setPropietario(rs.getString("propietario"));
            vehiculo.setTipoVehiculo(rs.getString("tipo_vehiculo"));
            vehiculo.setTipoCliente(rs.getString("tipo_cliente"));
            vehiculo.setHoraEntrada(rs.getString("hora_entrada"));
            vehiculo.setHoraSalida(rs.getString("hora_salida"));
            vehiculo.setValorPagado(rs.getDouble("valor_pagado"));
            vehiculo.setEstado(rs.getString("estado"));
            
            listaVehiculo.add(vehiculo);
        }

    } catch (SQLException e) {
        System.out.println("ERROR AL CONSULTAR VEHICULOS: " + e);
    }

    return listaVehiculo;
}

    
    public boolean actualizar(Vehiculo objeto, int idVehiculo) {
    boolean respuesta = false;
    Connection cn = Conexion.conectar();

    try {
        PreparedStatement consulta = cn.prepareStatement(
            "UPDATE tb_vehiculo SET hora_salida = ?, valor_pagado = ?, estado = ? WHERE id_vehiculo = ?"
        );
        consulta.setString(1, objeto.getHoraSalida());
        consulta.setDouble(2, objeto.getValorPagado());
        consulta.setString(3, objeto.getEstado());
        consulta.setInt(4, idVehiculo);

        if (consulta.executeUpdate() > 0) {
            respuesta = true;
        }
    } catch (SQLException e) {
        System.out.println("ERROR DE ACTUALIZACION: " + e.getMessage());
    }
        
        
        return respuesta;
    }
}
