
package modelo;

public class Vehiculo {
    
    private int idVehiculo;
    private String placa;
    private String propietario;
    private String tipoVehiculo;
    private String horaEntrada;
    private String horaSalida;
    private double valorPagado;
    private String estado;
    private int idUsuario;
    private String tipoCliente;
    
    public Vehiculo(){
    this.idVehiculo = 0;
    this.placa = "";
    this.propietario = "";
    this.tipoVehiculo = "";
    this.horaEntrada = "";
    this.horaSalida = "";
    this.valorPagado = 0.00;
    this.estado = "";
    this.idUsuario = 0;
    this.tipoCliente = "Ninguno";
        }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public double getValorPagado() {
        return valorPagado;
    }

    public void setValorPagado(double valorPagado) {
        this.valorPagado = valorPagado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "idVehiculo=" + idVehiculo + ", placa=" + placa + ", propietario=" + propietario + ", tipoVehiculo=" + tipoVehiculo + ", horaEntrada=" + horaEntrada + ", horaSalida=" + horaSalida + ", valorPagado=" + valorPagado + ", estado=" + estado + ", idUsuario=" + idUsuario + ", tipoCliente=" + tipoCliente + '}';
    }

}
