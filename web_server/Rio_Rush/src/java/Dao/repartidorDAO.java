package Dao;

import Model.repartidor;
import java.util.List;

public interface repartidorDAO {
    public List<repartidor> listar_repartidor();    //prototipo metodo listar
    public repartidor listarCedula_repartidor(String cedula_repartidor);
    public String editar_repartidor(String cedula, String contrasena_repartidor, String telefono_repartidor, String correo_electronico_repartidor, String placa_vehiculo, String tipo_vehiculo);    //prototipo metodo editar 
    public String agregar_repartidor(String cedula_repartidor,String contrasena_repartidor, String nombre_repartidor, String apellido_repartidor, String telefono_repartidor, String correo_electronico_repartidor, String placa_vehiculo, String tipo_vehiculo);   //prototipo metodo guardar 
    public repartidor eliminar_repartidor(String cedula_repartidor);      //prototipo metodo borrar 
}