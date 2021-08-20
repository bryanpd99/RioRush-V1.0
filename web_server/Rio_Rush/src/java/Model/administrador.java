package Model;

public class administrador {
    
    String cedula_administrador;
    String contrasena_admin;
    String cedula_repartidor;
    String ruc;
    String nombre_administrador;
    String apellido_administrador;
    String telefono;
    String correo_electronico_administrador;

    public administrador(String cedula_administrador, String contrasena_admin, String cedula_repartidor, String ruc, String nombre_administrador, String apellido_administrador, String telefono, String correo_electronico_administrador) {
        this.cedula_administrador = cedula_administrador;
        this.contrasena_admin = contrasena_admin;
        this.cedula_repartidor = cedula_repartidor;
        this.ruc = ruc;
        this.nombre_administrador = nombre_administrador;
        this.apellido_administrador = apellido_administrador;
        this.telefono = telefono;
        this.correo_electronico_administrador = correo_electronico_administrador;
    }

    public administrador() {
    }

    public String getCedula_administrador() {
        return cedula_administrador;
    }

    public void setCedula_administrador(String cedula_administrador) {
        this.cedula_administrador = cedula_administrador;
    }

    public String getContrasena_admin() {
        return contrasena_admin;
    }

    public void setContrasena_admin(String contrasena_admin) {
        this.contrasena_admin = contrasena_admin;
    }

    public String getCedula_repartidor() {
        return cedula_repartidor;
    }

    public void setCedula_repartidor(String cedula_repartidor) {
        this.cedula_repartidor = cedula_repartidor;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNombre_administrador() {
        return nombre_administrador;
    }

    public void setNombre_administrador(String nombre_administrador) {
        this.nombre_administrador = nombre_administrador;
    }

    public String getApellido_administrador() {
        return apellido_administrador;
    }

    public void setApellido_administrador(String apellido_administrador) {
        this.apellido_administrador = apellido_administrador;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo_electronico_administrador() {
        return correo_electronico_administrador;
    }

    public void setCorreo_electronico_administrador(String correo_electronico_administrador) {
        this.correo_electronico_administrador = correo_electronico_administrador;
    }
    
    
}

