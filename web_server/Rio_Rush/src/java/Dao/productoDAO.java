package Dao;

import Model.producto;
import java.util.List;

public interface productoDAO {
    public List<producto> listar();    //prototipo metodo listar
    public producto listarID(int id_producto);
    public String editar(int id_producto, String nombre_producto, String descripcion, double precio_unitario);    //prototipo metodo editar 
    public String agregar(int id_producto, String ruc, String nombre_producto, String descripcion, double precio_unitario);   //prototipo metodo guardar 
    public producto eliminar(int id_producto);      //prototipo metodo borrar
    public producto listarNombre_producto(String nombre_producto);
}