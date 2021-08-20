package Dao;

import Model.pedido;
import java.util.List;

public interface pedidoDAO {
    public List<pedido> listar();    //prototipo metodo listar
    public pedido listarID_pedido(int id_pedido);
    public String agregar(int id_producto, String ruc, String nombre_producto, String descripcion, double precio_unitario);   //prototipo metodo guardar 
  
}
