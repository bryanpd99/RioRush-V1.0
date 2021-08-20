package Dao;


import Model.cliente_restaurante;
import java.util.List;

public interface cliente_restauranteDAO {
    public List<cliente_restaurante> listar_restaurante();    //prototipo metodo listar
    public cliente_restaurante listarRuc_restaurante(String ruc);
    public String editar_restaurante(String ruc, String contrasena_restaurante, String nombre_restaurante, String propietario, String direccion_restaurante, String telefono_restaurante, String correo_electronico_restaurante);    //prototipo metodo editar 
    public String agregar_restaurante(String ruc, String contrasena_restaurante, String nombre_restaurante, String propietario, String direccion_restaurante, String telefono_restaurante, String correo_electronico_restaurante, int calificacion);   //prototipo metodo guardar 
    public cliente_restaurante eliminar(String ruc);      //prototipo metodo borrar 
}
