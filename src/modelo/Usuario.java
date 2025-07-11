
package modelo;


public class Usuario {
    //Atributos
    private int idUsuario;
    private String usuario;
    private String contraseña;
    
    //Constructor
    public Usuario(){
        this.idUsuario = 0;
        this.usuario = "";
        this.contraseña = "";
    }
    
    //metodos get y set

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", usuario=" + usuario + ", contrase\u00f1a=" + contraseña + '}';
    }
    
}
