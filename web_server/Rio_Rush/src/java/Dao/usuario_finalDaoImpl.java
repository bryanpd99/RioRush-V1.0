/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import ConexionBD.conexionBD;
import Model.producto;
import Model.usuario_final;
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
public class usuario_finalDaoImpl implements usuario_finalDAO {
    
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    conexionBD conex= new conexionBD();
    usuario_final usua = new usuario_final();
    int res;
    String mensaje;
    
    @Override
    public List<usuario_final> listar_usuario() {
       
       List<usuario_final> datos = new ArrayList<>();
       String sql = "select * from usuario_final";
       try{
           con = conex.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while(rs.next()){
               usuario_final u = new usuario_final();
               u.setCedula_usuario(rs.getString("cedula_usuario"));
               u.setContrasena_usuario(rs.getString("contrasena_usuario"));
               u.setNombre_usuario(rs.getString("nombre_usuari"));
               u.setApellido_usuario(rs.getString("apellido_usuario"));
               u.setTelefono_usuario(rs.getString("telefono_usuario"));
               u.setCorreo_electronico_usuario(rs.getString("correo_electronico_usuario"));
               u.setDireccion(rs.getInt("id_direccion"));
               datos.add(u);
           }
       } catch (SQLException e){
           
       }
       return datos;
    }

    @Override
    public usuario_final listarCedula_usuario(String cedula_usuario) {
        String sql = "select * from usuario_final where cedula_usuario="+cedula_usuario;
        try {
           con = conex.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while(rs.next()){
               usua.setCedula_usuario(rs.getString("cedula_usuario"));
               usua.setContrasena_usuario(rs.getString("contrasena_usuario"));
               usua.setNombre_usuario(rs.getString("nombre_usuari"));
               usua.setApellido_usuario(rs.getString("apellido_usuario"));
               usua.setTelefono_usuario(rs.getString("telefono_usuario"));
               usua.setCorreo_electronico_usuario(rs.getString("correo_electronico_usuario"));
               usua.setDireccion(rs.getInt("id_direccion"));
            } 
        }
        catch (Exception e) {
        }
        return usua;
    }


    @Override
    public usuario_final eliminar_usuario(String cedula_usuario) {
        String sql = "delete from usuario_final where cedula_usuario="+cedula_usuario;
        try{
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e){
            
        }
        return usua;
    }

    @Override
    public String agregar_usuario(String cedula_usuario, String contrasena_usuario, int id_direccion, String nombre_usuario, String apellido_usuario, String telefono_usuario, String correo_electronico_usuario) {
        String sql = "INSERT INTO usuario_final(cedula_usuario, contrasena_usuario,id_direccion, nombre_usuario, apellido_usuario, telefono_usuario, correo_electronico_usuario) VALUES (?,?,?,?,?,?,?)";
        try{
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cedula_usuario);
            ps.setString(2, contrasena_usuario);
            ps.setInt(3, id_direccion);
            ps.setString(4, nombre_usuario);
            ps.setString(5, apellido_usuario);
            ps.setString(6, telefono_usuario);
            ps.setString(7, correo_electronico_usuario);
                  
            res = ps.executeUpdate();
            if(res == 1){
                mensaje = "Usuario Agregado Correctamente";
            } 
            else{
                mensaje = "Error";
            }     
        } catch(SQLException e){
            
        }
        return mensaje;
    }

    @Override
    public String editar_usuario(String cedula_usuario, String contrasena_usuario, String correo_electronico_usuario, int id_direccion, String telefono_usuario) {
        String sql = "update usuario_final set contrasena_usuario=?, correo_electronico_usuario=?, id_direccion=?, telefono_usuario=? where cedula_usuario=" + cedula_usuario;
        try{
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, contrasena_usuario);
            ps.setString(2, correo_electronico_usuario);
            ps.setInt(3, id_direccion);
            ps.setString(4, telefono_usuario);
            res = ps.executeUpdate();
            if(res == 1){
                mensaje = "Usuario Actualizado";
            }
            else{
                mensaje = "Error";
            }
    
        }catch (Exception e){
            
        }
        return mensaje; 
    }
    
}
