
package Model;

public class cliente_restaurante {
    
    String ruc;
    String contrasena_restaurante;
    String nombre_restaurante;  
    String propietario;
    String direccion_restaurante;
    String telefono_restaurante;
    String correo_electronico_restaurante;
    int calificacion;

    public cliente_restaurante() {
    }

    public cliente_restaurante(String ruc, String contrasena_restaurante, String nombre_restaurante, String propietario, String direccion_restaurante, String telefono_restaurante, String correo_electronico_restaurante, int calificacion) {
        this.ruc = ruc;
        this.contrasena_restaurante = contrasena_restaurante;
        this.nombre_restaurante = nombre_restaurante;
        this.propietario = propietario;
        this.direccion_restaurante = direccion_restaurante;
        this.telefono_restaurante = telefono_restaurante;
        this.correo_electronico_restaurante = correo_electronico_restaurante;
        this.calificacion = calificacion;
    }
    
    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }


    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getContrasena_restaurante() {
        return contrasena_restaurante;
    }

    public void setContrasena_restaurante(String contrasena_restaurante) {
        this.contrasena_restaurante = contrasena_restaurante;
    }

    public String getNombre_restaurante() {
        return nombre_restaurante;
    }

    public void setNombre_restaurante(String nombre_restaurante) {
        this.nombre_restaurante = nombre_restaurante;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getDireccion_restaurante() {
        return direccion_restaurante;
    }

    public void setDireccion_restaurante(String direccion_restaurante) {
        this.direccion_restaurante = direccion_restaurante;
    }

    public String getTelefono_restaurante() {
        return telefono_restaurante;
    }

    public void setTelefono_restaurante(String telefono_restaurante) {
        this.telefono_restaurante = telefono_restaurante;
    }

    public String getCorreo_electronico_restaurante() {
        return correo_electronico_restaurante;
    }

    public void setCorreo_electronico_restaurante(String correo_electronico_restaurante) {
        this.correo_electronico_restaurante = correo_electronico_restaurante;
    }
  
    
}
