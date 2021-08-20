/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import ConexionBD.conexionBD;
import Model.repartidor;
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
public class repartidorDaoImpl implements repartidorDAO{
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    conexionBD conex= new conexionBD();
    repartidor repar = new repartidor();
    int res;
    String mensaje;

    @Override
    public List<repartidor> listar_repartidor() {
       List<repartidor> datos = new ArrayList<>();
       String sql = "select * from repartidor";
       try{
           con = conex.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while(rs.next()){
               repartidor repa = new repartidor();
               repa.setCedula_repartidor(rs.getString("cedula_repartidor"));
               repa.setContrasena_repartidor(rs.getString("contrasena_repartidor"));
               repa.setNombre_repartidor(rs.getString("nombre_repartidor"));
               repa.setApellido_repartidor(rs.getString("apellido_repartidor"));
               repa.setTelefono_repartidor(rs.getString("telefono_repartidor"));
               repa.setCorreo_electronico_repartidor(rs.getString("correo_electronico_repartidor"));
               repa.setPlaca_vehiculo(rs.getString("placa_vehiculo"));
               repa.setTipo_vehiculo(rs.getString("tipo_vehiculo"));
               repa.setCalificacion(rs.getInt("calificacion"));
               datos.add(repa);
           }
       } catch (SQLException e){
           
       }
       return datos;
    }

    @Override
    public repartidor listarCedula_repartidor(String cedula_repartidor) {
        String sql = "select * from repartidor where cedula_repartidor="+cedula_repartidor;
        try {
           con = conex.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while(rs.next()){
               repar.setCedula_repartidor(rs.getString("cedula_repartidor"));
               repar.setContrasena_repartidor(rs.getString("contrasena_repartidor"));
               repar.setNombre_repartidor(rs.getString("nombre_repartidor"));
               repar.setApellido_repartidor(rs.getString("apellido_repartidor"));
               repar.setTelefono_repartidor(rs.getString("telefono_repartidor"));
               repar.setCorreo_electronico_repartidor(rs.getString("correo_electronico_repartidor"));
               repar.setPlaca_vehiculo(rs.getString("placa_vehiculo"));
               repar.setTipo_vehiculo(rs.getString("tipo_vehiculo"));
               repar.setCalificacion(rs.getInt("calificacion"));
            } 
        }
        catch (Exception e) {
        }
        return repar;
      
    }

    @Override
    public String agregar_repartidor(String cedula_repartidor,String contrasena_repartidor, String nombre_repartidor, String apellido_repartidor, String telefono_repartidor, String correo_electronico_repartidor, String placa_vehiculo, String tipo_vehiculo) {
        String sql = "INSERT INTO repartidor(cedula_repartidor,contrasena_repartidor,nombre_repartidor,apellido_repartidor,telefono_repartidor,correo_electronico_repartidor,placa_vehiculo,tipo_vehiculo) VALUES (?,?,?,?,?,?,?,?)";
        try{
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cedula_repartidor);
            ps.setString(2,  contrasena_repartidor);
            ps.setString(3,  nombre_repartidor);
            ps.setString(4, apellido_repartidor);
            ps.setString(5, telefono_repartidor);
            ps.setString(6,  correo_electronico_repartidor);
            ps.setString(7, placa_vehiculo);
            ps.setString(8, tipo_vehiculo);
            res = ps.executeUpdate();
            if(res == 1){
                mensaje = "Repartidor Agregado Correctamente";
            } 
            else{
                mensaje = "Error";
            }     
        } catch(SQLException e){
            
        }
        return mensaje;
    }

    @Override
    public String editar_repartidor(String cedula_repartidor, String contrasena_repartidor, String telefono_repartidor, String correo_electronico_repartidor, String placa_vehiculo, String tipo_vehiculo) {
        String sql = "update repartidor set contrasena_repartidor=?, telefono_repartidor=?, correo_electronico_repartidor=?, placa_vehiculo=?, tipo_vehiculo=? where cedula_repartidor=" + cedula_repartidor;
        try{
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, contrasena_repartidor);
            ps.setString(2, telefono_repartidor);
            ps.setString(3, correo_electronico_repartidor);
            ps.setString(4, placa_vehiculo);
            ps.setString(5, tipo_vehiculo);
            res = ps.executeUpdate();
            if(res == 1){
                mensaje = "Repartidor Actualizado";
            }
            else{
                mensaje = "Error";
            }
    
        }catch (Exception e){
            
        }
        return mensaje;  
    }

    @Override
    public repartidor eliminar_repartidor(String cedula_repartidor) {
        String sql = "delete from repartidor where cedula_repartidor="+cedula_repartidor;
        try{
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e){
            
        }
        return repar;
    } 
    
}
