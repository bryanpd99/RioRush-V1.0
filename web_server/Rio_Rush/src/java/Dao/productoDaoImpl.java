package Dao;

import ConexionBD.conexionBD;
import Model.producto;
import static java.rmi.Naming.list;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;

public class productoDaoImpl implements productoDAO{

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    conexionBD conex= new conexionBD();
    producto pro = new producto();
    int res;
    String mensaje;
    
    @Override
    public List<producto> listar() {
       List<producto> datos = new ArrayList<>();
       String sql = "select * from producto";
       try{
           con = conex.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while(rs.next()){
               producto product = new producto();
               product.setId_producto(rs.getInt("id_producto"));
               product.setNombre_producto(rs.getString("nombre_producto"));
               product.setRuc(rs.getString("ruc"));
               product.setDescripcion(rs.getString("descripcion"));
               product.setPrecio_unitario(rs.getDouble("precio_unitario"));
               datos.add(product);
           }
       } catch (SQLException e){
           
       }
       return datos;
    }

    @Override
    public String editar(int id_producto, String nombre_producto, String descripcion, double precio_unitario){
        String sql = "update producto set nombre_producto=?, descripcion=?, precio_unitario=? where id_producto=" + id_producto;
        try{
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre_producto);
            ps.setString(2, descripcion);
            ps.setDouble(3, precio_unitario);
            res = ps.executeUpdate();
            if(res == 1){
                mensaje = "Producto Actualizado";
            }
            else{
                mensaje = "Error";
            }
    
        }catch (Exception e){
            
        }
        return mensaje;     
    }

    @Override
    public String agregar(int id_producto, String ruc, String nombre_producto, String descripcion, double precio_unitario) {
        String sql = "INSERT INTO producto(id_producto, ruc, nombre_producto, descripcion, precio_unitario) VALUES (?,?,?,?,?)";
        try{
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_producto);
            ps.setString(2, ruc);
            ps.setString(3, nombre_producto);
            ps.setString(4, descripcion);
            ps.setDouble(5, precio_unitario);
            res = ps.executeUpdate();
            if(res == 1){
                mensaje = "Producto Agregado Correctamente";
            } 
            else{
                mensaje = "Error";
            }     
        } catch(SQLException e){
            
        }
        return mensaje;
    }

    @Override
    public producto eliminar(int id_producto) {
        String sql = "delete from producto where id_producto="+id_producto;
        try{
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e){
            
        }
        return pro;
    }

    @Override
    public producto listarID(int id_producto) {
        String sql = "select * from producto where id_producto="+id_producto;
        try {
           con = conex.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while(rs.next()){
               pro.setId_producto(rs.getInt("id_producto"));
               pro.setNombre_producto(rs.getString("nombre_producto"));
               pro.setRuc(rs.getString("ruc"));
               pro.setDescripcion(rs.getString("descripcion"));
               pro.setPrecio_unitario(rs.getDouble("precio_unitario"));
            } 
        }
        catch (Exception e) {
        }
        return pro;
    }
    
    @Override
    public producto listarNombre_producto(String nombre_producto) {
        String sql = "select * from producto where nombre_producto="+nombre_producto;
        try {
           con = conex.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while(rs.next()){
               pro.setNombre_producto(rs.getString("nombre_producto"));
               pro.setRuc(rs.getString("ruc"));
               pro.setDescripcion(rs.getString("descripcion"));
               pro.setPrecio_unitario(rs.getDouble("precio_unitario"));
            } 
        }
        catch (Exception e) {
        }
        return pro;
    }  
}
