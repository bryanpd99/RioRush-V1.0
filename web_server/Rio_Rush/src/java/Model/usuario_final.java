
package Model;


public class usuario_final {
    String cedula_usuario;
    String contrasena_usuario;
    String nombre_usuario;
    String apellido_usuario;
    String telefono_usuario;
    String correo_electronico_usuario;
    int direccion;

    public usuario_final() {
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    public usuario_final(String cedula_usuario, String contrasena_usuario, String nombre_usuario, String apellido_usuario, String telefono_usuario, String correo_electronico_usuario, int direccion) {
        this.cedula_usuario = cedula_usuario;
        this.contrasena_usuario = contrasena_usuario;
        this.nombre_usuario = nombre_usuario;
        this.apellido_usuario = apellido_usuario;
        this.telefono_usuario = telefono_usuario;
        this.correo_electronico_usuario = correo_electronico_usuario;
        this.direccion = direccion;
    }

    public String getCedula_usuario() {
        return cedula_usuario;
    }

    public void setCedula_usuario(String cedula_usuario) {
        this.cedula_usuario = cedula_usuario;
    }

    public String getContrasena_usuario() {
        return contrasena_usuario;
    }

    public void setContrasena_usuario(String contrasena_usuario) {
        this.contrasena_usuario = contrasena_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getApellido_usuario() {
        return apellido_usuario;
    }

    public void setApellido_usuario(String apellido_usuario) {
        this.apellido_usuario = apellido_usuario;
    }

    public String getTelefono_usuario() {
        return telefono_usuario;
    }

    public void setTelefono_usuario(String telefono_usuario) {
        this.telefono_usuario = telefono_usuario;
    }

    public String getCorreo_electronico_usuario() {
        return correo_electronico_usuario;
    }

    public void setCorreo_electronico_usuario(String correo_electronico_usuario) {
        this.correo_electronico_usuario = correo_electronico_usuario;
    }
      
}
