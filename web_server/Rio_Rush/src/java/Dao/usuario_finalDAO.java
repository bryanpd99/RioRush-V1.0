package Dao;

import Model.usuario_final;
import java.util.List;

public interface usuario_finalDAO {
    public List<usuario_final> listar_usuario();    //prototipo metodo listar
    public usuario_final listarCedula_usuario(String cedula_usuario);
    public String editar_usuario(String cedula_usuario, String contrasena_usuario, String correo_electronico_usuario, int id_direccion, String telefono_usuario);    //prototipo metodo editar 
    public String agregar_usuario(String cedula_usuario, String contrasena_usuario, int id_direccion, String nombre_usuario, String apellido_usuario, String telefono_usuario, String correo_electronico_usuario);   //prototipo metodo guardar 
    public usuario_final eliminar_usuario(String cedula_usuario);      //prototipo metodo borrar 
}