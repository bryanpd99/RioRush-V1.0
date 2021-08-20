/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Dao.productoDaoImpl;
import Dao.usuario_finalDaoImpl;
import Model.producto;
import Model.usuario_final;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author INTEL 2021
 */
@WebService(serviceName = "Usuario_final")
public class Usuario_final {

    usuario_finalDaoImpl usua = new usuario_finalDaoImpl();
    productoDaoImpl pro = new productoDaoImpl();
    
    //GESTION USUARIO
    @WebMethod(operationName = "Listar_usuario")
    public List<usuario_final> Listar_usuario() {
        List usuario = usua.listar_usuario();
        return usuario;       
    }

    @WebMethod(operationName = "ListarCedula_usuario")
    public usuario_final ListarRuc_usuario(@WebParam(name = "usuario_final") String usuario_final) {
        usuario_final u = usua.listarCedula_usuario(usuario_final);
        return u;
    }

    @WebMethod(operationName = "Eliminar")
    public usuario_final Eliminar_usuario(@WebParam(name = "usuario_final") String usuario_final) {
        usuario_final u = usua.eliminar_usuario(usuario_final);
        return u;  
    }
    
    @WebMethod(operationName = "Agregar_usuario")
    public String Agregar_usuario(@WebParam(name = "cedula_usuario") String cedula_usuario, @WebParam(name = "contrasena_usuario") String contrasena_usuario, @WebParam(name = "nombre_usuario") String nombre_usuario, @WebParam(name = "apellido_usuario") String apellido_usuario, @WebParam(name = "telefono_usuario") String telefono_usuario, @WebParam(name = "correo_electronico_usuario") String correo_electronico_usuario) {
        String verificar = validacedula(cedula_usuario);
        if(verificar.equals("Cedula Correcta")){
            String datos = usua.agregar_usuario(cedula_usuario, contrasena_usuario, 0, nombre_usuario, apellido_usuario, telefono_usuario, correo_electronico_usuario);
            return datos;
        }
            return "Error: No existe la cedula";  
    }
    
    @WebMethod(operationName = "Editar_usuario")
    public String Editar_usuario(@WebParam(name = "cedula_usuario") String cedula_usuario, @WebParam(name = "contrasena_usuario") String contrasena_usuario,  @WebParam(name = "id_direccion") int id_direccion,  @WebParam(name = "telefono_usuario") String telefono_usuario, @WebParam(name = "correo_electronico_usuario") String correo_electronico_usuario) {
        String verificar = validacedula(cedula_usuario);
        if(verificar.equals("Cedula Correcta")){
            String datos = usua.editar_usuario(cedula_usuario, contrasena_usuario, correo_electronico_usuario, id_direccion, telefono_usuario);
            return datos;  
        }
        return "Error: No existe la cedula";  
    }

    
    //VISUALIZAR PRODUCTO
    @WebMethod(operationName = "ListarNombre_producto")
    public producto ListarNombre_producto(@WebParam(name = "nombre_producto") String nombre_producto) {
        producto prod = pro.listarNombre_producto(nombre_producto);
        return prod;
    }
 
    //VALIDACION CEDULA Y RUC NATURAL
    public String validacedula(@WebParam(name = "cedula") String cedula) {
        byte sum = 0;
            try {
                if (cedula.trim().length() != 10)
                    return "Cedula Incorrecta";
                String[] data = cedula.split("");
                byte verifier = Byte.parseByte(data[0] + data[1]);
                if (verifier < 1 || verifier > 24)
                    return "Cedula Incorrecta";
                byte[] digits = new byte[data.length];
                for (byte i = 0; i < digits.length; i++)
                    digits[i] = Byte.parseByte(data[i]);
                if (digits[2] > 6)
                    return "Cedula Incorrecta";
                for (byte i = 0; i < digits.length - 1; i++) {
                    if (i % 2 == 0) {
                        verifier = (byte) (digits[i] * 2);
                        if (verifier > 9)
                            verifier = (byte) (verifier - 9);
                    } else
                        verifier = (byte) (digits[i] * 1);
                    sum = (byte) (sum + verifier);
                }
                if ((sum - (sum % 10) + 10 - sum) == digits[9])
                    return "Cedula Correcta";
                
            } catch (Exception e) {
                return "Cedula no ingresada";
            }
        return "Cedula Incorrecta";
    }  
   
    public String validacionrucnatural(@WebParam(name = "ruc_natural") String ruc_natural) {
        try{
            String ruc1 = ruc_natural; //1804805008001
            String subcadena = ruc1.substring(0,10);     //1804805008  
            String ruc = validacedula(subcadena); //"Cedula Correcta"  
            
            if(ruc.equals("Cedula Correcta")){
                if(ruc_natural.equalsIgnoreCase(subcadena))
                {
                     return "Ruc Natural Incorrecto";
                }  
                else{
                    return "Ruc Natural Correcto";
                }
            }
            else{
                return "Ruc Natural Incorrecto";
            }
        }
        catch (Exception e){
            return "Ruc no ingresado";
        }
    }   
    
}
