/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import ConexionBD.conexionBD;
import Model.cliente_restaurante;
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
public class cliente_restauranteDaoImpl implements cliente_restauranteDAO {
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    conexionBD conex= new conexionBD();
    cliente_restaurante resta = new cliente_restaurante();
    int res;
    String mensaje;
    
    @Override
    public List<cliente_restaurante> listar_restaurante() {
       List<cliente_restaurante> datos_restaurante = new ArrayList<>();
       String sql = "select * from cliente_restaurante";
       try{
           con = conex.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while(rs.next()){
               cliente_restaurante restaurante = new cliente_restaurante();
               restaurante.setRuc(rs.getString("ruc"));
               restaurante.setNombre_restaurante(rs.getString("nombre_restaurante"));
               restaurante.setContrasena_restaurante(rs.getString("contrasena_restaurante"));
               restaurante.setPropietario(rs.getString("propietario"));
               restaurante.setDireccion_restaurante(rs.getString("direccion_restaurante"));
               restaurante.setTelefono_restaurante(rs.getString("telefono_restaurante"));
               restaurante.setCorreo_electronico_restaurante(rs.getString("correo_electronico_restaurante"));
               restaurante.setCalificacion(rs.getInt("calificacion")); //eliminar calificacion
               datos_restaurante.add(restaurante);
           }
       } catch (SQLException e){
           
       }
       return datos_restaurante;
    }

    @Override
    public cliente_restaurante listarRuc_restaurante(String ruc) {
        String sql = "select * from cliente_restaurante where ruc="+ruc;
        try {
           con = conex.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while(rs.next()){
               resta.setRuc(rs.getString("ruc"));
               resta.setContrasena_restaurante(rs.getString("contrasena_restaurante"));
               resta.setNombre_restaurante(rs.getString("nombre_restaurante"));
               resta.setPropietario(rs.getString("propietario"));
               resta.setDireccion_restaurante(rs.getString("direccion_restaurante"));
               resta.setTelefono_restaurante(rs.getString("telefono_restaurante"));
               resta.setCorreo_electronico_restaurante(rs.getString("correo_electronico_restaurante"));
               resta.setCalificacion(rs.getInt("calificacion"));              
            } 
        }
        catch (Exception e) {
        }
        return resta;
    }

    @Override
    public String editar_restaurante(String ruc, String contrasena_restaurante, String nombre_restaurante, String propietario, String direccion_restaurante, String telefono_restaurante, String correo_electronico_restaurante) {
        String sql = "update producto set nombre_restaurante=?, contrasena_restaurante=?, propietario=?, "
                + "direccion_restaurante=?, telefono_restaurante=?, correo_electronico_restaurante=? where id_producto=" + ruc;
        try{
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ruc);
            ps.setString(2, nombre_restaurante);
            ps.setString(3, contrasena_restaurante);
            ps.setString(4, propietario);
            ps.setString(5, direccion_restaurante);
            ps.setString(6, telefono_restaurante);
            ps.setString(7, correo_electronico_restaurante);
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
    public String agregar_restaurante(String ruc, String contrasena_restaurante, String nombre_restaurante, String propietario, String direccion_restaurante, String telefono_restaurante, String correo_electronico_restaurante, int calificacion) {
        String sql = "INSERT INTO cliente_restaurante(ruc, contrasena_restaurante, nombre_restaurante, propietario, direccion_restaurante, telefono_restaurante, correo_electronico_restaurante, calificacion) VALUES (?,?,?,?,?,?,?,?)";
        try{
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ruc);
            ps.setString(2, contrasena_restaurante);
            ps.setString(3, nombre_restaurante);
            ps.setString(4, propietario);
            ps.setString(5, direccion_restaurante);
            ps.setString(6, telefono_restaurante);
            ps.setString(7, correo_electronico_restaurante);
            ps.setInt(8, calificacion);
    
            res = ps.executeUpdate();
            if(res == 1){
                mensaje = "Restaurante Agregado Correctamente";
            } 
            else{
                mensaje = "Error";
            }     
        } catch(SQLException e){
            
        }
        return mensaje;
    }

    @Override
    public cliente_restaurante eliminar(String ruc) {
        String sql = "delete from cliente_restaurante where ruc="+ruc;
        try{
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e){
            
        }
        return resta;
    }
}
