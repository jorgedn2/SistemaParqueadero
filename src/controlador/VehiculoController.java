/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import conexion.Conexion;
import modelo.Vehiculo;
import java.sql.*;
import java.util.ArrayList;

public class VehiculoController {
    
    public boolean guardar(Vehiculo objeto){
    boolean respuesta = false;
    Connection cn = Conexion.conectar();
    try {
        PreparedStatement consulta = cn.prepareStatement(
            "insert into tb_vehiculo (id_vehiculo, placa, propietario, tipo_vehiculo, hora_entrada, hora_salida, valor_pagado, estado, id_usuario) " +
            "values (?, ?, ?, ?, ?, ?, ?, ?, ?)"
        );
        consulta.setInt(1, 0);
        consulta.setString(2, objeto.getPlaca());
        consulta.setString(3, objeto.getPropietario());
        consulta.setString(4, objeto.getTipoVehiculo());
        consulta.setString(5, objeto.getHoraEntrada());
        consulta.setString(6, objeto.getHoraSalida());
        consulta.setDouble(7, objeto.getValorPagado());
        consulta.setString(8, objeto.getEstado());
        consulta.setInt(9, objeto.getIdUsuario()); // NUEVO

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
    public ArrayList buscarVehiculoPlacaFecha(String placaPropietario, String fecha){
        String sql = "";
        fecha = fecha.replace("/", "-");
        
        if(!placaPropietario.isEmpty() && !fecha.isEmpty()){
            sql="select*from tb_vehiculo where placa LIKE '%"+ placaPropietario
                    + "%' OR propietario LIKE '%" + placaPropietario + 
                    "%' AND hora_entrada LIKE '" + fecha + "%';";
        } else if(!placaPropietario.isEmpty()){
            sql="select*from tb_vehiculo where placa LIKE '%"+ placaPropietario
                    + "%' OR propietario LIKE '%" + placaPropietario + 
                    "%';";
        } else if (!fecha.isEmpty()){
            sql="select*from tb_vehiculo where hora_entrada LIKE '" + fecha + "%';";
        }
        Statement st;
        try{
            Connection cn = Conexion.conectar();
            st= cn.createStatement();
            ResultSet rs=(ResultSet) st.executeQuery(sql);
            
            Vehiculo vehiculo;
            while (rs.next()){
                vehiculo=new Vehiculo();
                vehiculo.setIdVehiculo(rs.getInt("id_vehiculo"));
                vehiculo.setPlaca(rs.getString("placa"));
                vehiculo.setPropietario(rs.getString("propietario"));
                vehiculo.setTipoVehiculo(rs.getString("tipo_vehiculo"));
                vehiculo.setHoraEntrada(rs.getString("hora_entrada"));
                vehiculo.setHoraSalida(rs.getString("hora_salida"));
                vehiculo.setValorPagado(rs.getDouble("valor_pagado"));
                vehiculo.setEstado(rs.getString("estado"));
                
                listaVehiculo.add(vehiculo);
            }
            
        } catch(SQLException e) {
            System.out.println("ERROR AL CONSULTAR VEHICULOS: "+e);
        }
        return listaVehiculo;
    }
    
    public boolean actualizar(Vehiculo objeto,int idVehiculo){
        boolean respuesta =false;
        Connection cn = Conexion.conectar();
        
        try{
            PreparedStatement consulta = cn.prepareStatement("update tb_vehiculo set hora_salida=?,valor_pagado=?, "
                    + "estado=? where id_vehiculo = '" + idVehiculo +"';");
            consulta.setString(1, objeto.getHoraSalida());
            consulta.setDouble(2, objeto.getValorPagado());
            consulta.setString(3,objeto.getEstado());
            
            if(consulta.executeUpdate()>0){
                respuesta=true;
            }
        }catch(SQLException e){
            System.out.println("ERROR DE ACTUALIZACION" +e );
            
        }
        
        
        return false;
    }
}
