/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import ConexionBD.conexionBD;
import Model.pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author INTEL 2021
 */
public class pedidoDaoImpl implements pedidoDAO {
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    conexionBD conex= new conexionBD();
    pedido pedid = new pedido();
    int res;
    String mensaje;
    

    @Override
    public List<pedido> listar() {
        List<pedido> datos_pedido = new ArrayList<>();
       String sql = "select * from pedido";
       try{
           con = conex.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while(rs.next()){
               pedido ped = new pedido();
               ped.setid_pedido(rs.getInt("id_pedido"));
               ped.setRuc(rs.getString("ruc"));
               ped.setnombre_producto(rs.getString("nombre_producto"));
               ped.setdescripcion(rs.getString("descripcion"));
               ped.setprecio_unitario(rs.getString("precio_unitario"));
               datos_pedido.add(ped);
           }
       } catch (SQLException e){
           
       }
       return datos_pedido;
    }

    @Override
    public pedido listarID_pedido(int id_pedido) {
         String sql = "select * from pedido where id_pedido="+id_pedido;
        try {
           con = conex.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while(rs.next()){
               pedid.setid_pedido(rs.getInt(id_pedido));
               pedid.setRuc(rs.getString("ruc"));
               pedid.setnombre_producto(rs.getString("nombre_producto"));
               pedid.setdescripcion(rs.getString("descripcion"));
               pedid.setprecio_unitario(rs.getString("precio_unitario"));
                         
            } 
        }
        catch (Exception e) {
        }
        return pedid;
    }

    @Override
    public String agregar(int id_producto, String ruc, String nombre_producto, String descripcion, double precio_unitario) {
         String sql = "INSERT INTO pedido(id_producto, ruc, nombre_producto, descripcion, precio_unitario) VALUES (?,?,?,?,?)";
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
                mensaje = "Pedido Agregado Correctamente";
            } 
            else{
                mensaje = "Error";
            }     
        } catch(SQLException e){
            
        }
        return mensaje;
    }

   
}
