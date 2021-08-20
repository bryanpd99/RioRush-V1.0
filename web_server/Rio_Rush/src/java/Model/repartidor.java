/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author INTEL 2021
 */
public class repartidor {
    String cedula_repartidor;
    String contrasena_repartidor;
    String nombre_repartidor;
    String apellido_repartidor;
    String telefono_repartidor;
    String correo_electronico_repartidor;
    String placa_vehiculo;
    String tipo_vehiculo;
    int calificacion;

    public repartidor() {
    }

    public repartidor(String cedula_repartidor, String contrasena_repartidor, String nombre_repartidor, String apellido_repartidor, String telefono_repartidor, String correo_electronico_repartidor, String placa_vehiculo, String tipo_vehiculo, int calificacion) {
        this.cedula_repartidor = cedula_repartidor;
        this.contrasena_repartidor = contrasena_repartidor;
        this.nombre_repartidor = nombre_repartidor;
        this.apellido_repartidor = apellido_repartidor;
        this.telefono_repartidor = telefono_repartidor;
        this.correo_electronico_repartidor = correo_electronico_repartidor;
        this.placa_vehiculo = placa_vehiculo;
        this.tipo_vehiculo = tipo_vehiculo;
        this.calificacion = calificacion;
    }

    public String getCedula_repartidor() {
        return cedula_repartidor;
    }

    public void setCedula_repartidor(String cedula_repartidor) {
        this.cedula_repartidor = cedula_repartidor;
    }

    public String getContrasena_repartidor() {
        return contrasena_repartidor;
    }

    public void setContrasena_repartidor(String contrasena_repartidor) {
        this.contrasena_repartidor = contrasena_repartidor;
    }

    public String getNombre_repartidor() {
        return nombre_repartidor;
    }

    public void setNombre_repartidor(String nombre_repartidor) {
        this.nombre_repartidor = nombre_repartidor;
    }

    public String getApellido_repartidor() {
        return apellido_repartidor;
    }

    public void setApellido_repartidor(String apellido_repartidor) {
        this.apellido_repartidor = apellido_repartidor;
    }

    public String getTelefono_repartidor() {
        return telefono_repartidor;
    }

    public void setTelefono_repartidor(String telefono_repartidor) {
        this.telefono_repartidor = telefono_repartidor;
    }

    public String getCorreo_electronico_repartidor() {
        return correo_electronico_repartidor;
    }

    public void setCorreo_electronico_repartidor(String correo_electronico_repartidor) {
        this.correo_electronico_repartidor = correo_electronico_repartidor;
    }

    public String getPlaca_vehiculo() {
        return placa_vehiculo;
    }

    public void setPlaca_vehiculo(String placa_vehiculo) {
        this.placa_vehiculo = placa_vehiculo;
    }

    public String getTipo_vehiculo() {
        return tipo_vehiculo;
    }

    public void setTipo_vehiculo(String tipo_vehiculo) {
        this.tipo_vehiculo = tipo_vehiculo;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
    
    
    
    
}
