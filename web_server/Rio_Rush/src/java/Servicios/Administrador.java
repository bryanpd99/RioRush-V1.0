/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Dao.cliente_restauranteDaoImpl;
import Dao.repartidorDaoImpl;
import Model.cliente_restaurante;
import Model.repartidor;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


@WebService(serviceName = "Administrador")
public class Administrador {

    cliente_restauranteDaoImpl restau = new cliente_restauranteDaoImpl();
    repartidorDaoImpl repar = new repartidorDaoImpl();
    
    
    //GESTION RESTAURANTES
    @WebMethod(operationName = "Listar_restaurante")
    public List<cliente_restaurante> Listar_restaurante() {
        List restaurantes = restau.listar_restaurante();
        return restaurantes;       
    }

    @WebMethod(operationName = "Agregar_restaurante")
    public String Agregar_restaurante(@WebParam(name = "ruc") String ruc, @WebParam(name = "contrasena_restaurante") String contrasena_restaurante, @WebParam(name = "nombre_restaurante") String nombre_restaurante, @WebParam(name = "propietario") String propietario, @WebParam(name = "direccion_restaurante") String direccion_restaurante, @WebParam(name = "telefono_restaurante") String telefono_restaurante, @WebParam(name = "correo_electronico_restaurante") String correo_electronico_restaurante, @WebParam(name = "calificacion") int calificacion) {
        String verificar = validacionrucnatural(ruc);
        if(verificar.equals("Ruc Natural Correcto")){
            String datos = restau.agregar_restaurante(ruc, contrasena_restaurante, nombre_restaurante, propietario, direccion_restaurante, telefono_restaurante, correo_electronico_restaurante, calificacion);
            return datos;
        }
            return "Error: No existe ese ruc natural";  
    }
    
    @WebMethod(operationName = "Editar_restaurante")
    public String Editar_restaurante(@WebParam(name = "ruc") String ruc, @WebParam(name = "contrasena_restaurante") String contrasena_restaurante, @WebParam(name = "nombre_restaurante") String nombre_restaurante, @WebParam(name = "propietario") String propietario, @WebParam(name = "direccion_restaurante") String direccion_restaurante, @WebParam(name = "telefono_restaurante") String telefono_restaurante, @WebParam(name = "correo_electronico_restaurante") String correo_electronico_restaurante) {
        String verificar = validacionrucnatural(ruc);
        if(verificar.equals("Ruc Natural Correcto")){
            String datos = restau.editar_restaurante(ruc, contrasena_restaurante, nombre_restaurante, propietario, direccion_restaurante, telefono_restaurante, correo_electronico_restaurante);
            return datos;
        }
        return "Error: No existe ese ruc natural";  
    }

    @WebMethod(operationName = "ListarRuc_restaurante")
    public cliente_restaurante ListarRuc_restaurante(@WebParam(name = "ruc") String ruc) {
        cliente_restaurante res = restau.listarRuc_restaurante(ruc);  
        return res;
    }

    @WebMethod(operationName = "Eliminar_restaurante")
    public cliente_restaurante Eliminar_restaurante(@WebParam(name = "ruc") String ruc) {
        cliente_restaurante res = restau.eliminar(ruc);
        return res;  
    }
    
    //GESTION DE REPARTIDOR
    
    @WebMethod(operationName = "Listar_repartidor")
    public List<repartidor> Listar_repartidor() {
        List repartidor = repar.listar_repartidor();
        return repartidor;       
    }
    
    @WebMethod(operationName = "Agregar_repartidor")
    public String Agregar_repartidor(@WebParam(name = "cedula_repartidor") String cedula_repartidor, @WebParam(name = "contrasena_repartidor") String contrasena_repartidor, @WebParam(name = "nombre_repartidor") String nombre_repartidor, @WebParam(name = "apellido_repartidor") String apellido_repartidor, @WebParam(name = "telefono_repartidor") String telefono_repartidor, @WebParam(name = "correo_electronico_repartidor") String correo_electronico_repartidor, @WebParam(name = "placa_vehiculo") String placa_vehiculo, @WebParam(name = "tipo_vehiculo") String tipo_vehiculo) {
        String verificar = validacedula(cedula_repartidor);
        
        if(verificar.equals("Cedula Corrrecta")){
            String datos = repar.agregar_repartidor(cedula_repartidor,contrasena_repartidor,nombre_repartidor,apellido_repartidor,telefono_repartidor,correo_electronico_repartidor,placa_vehiculo,tipo_vehiculo);
            return datos;
        }
            return "Error: No existe la cedula del repartidor";  
    }
    
     @WebMethod(operationName = "Editar_repartidor")
    public String Editar_repartidor(@WebParam(name = "cedula_repartidor") String cedula_repartidor, @WebParam(name = "contrasena_repartidor") String contrasena_repartidor, @WebParam(name = "telefono_repartidor") String telefono_repartidor, @WebParam(name = "correo_electronico_repartidor") String correo_electronico_repartidor, @WebParam(name = "placa_vehiculo") String placa_vehiculo, @WebParam(name = "tipo_vehiculo") String tipo_vehiculo) {
        String verificar = validacedula(cedula_repartidor);
        
        if(verificar.equals("Cedula Corrrecta")){
            String datos = repar.editar_repartidor(cedula_repartidor,contrasena_repartidor, telefono_repartidor, correo_electronico_repartidor, placa_vehiculo, tipo_vehiculo);
            return datos;
        }
         return "Error: No existe la cedula del repartidor";  
    }
    
    @WebMethod(operationName = "Eliminar_repartidor")
    public repartidor Eliminar_repartidor(@WebParam(name = "cedula_repartidor") String cedula_repartidor) {
        repartidor repa = repar.eliminar_repartidor(cedula_repartidor);
        return repa;  
    } 
    
    @WebMethod(operationName = "ListarCedula_repartidor")
    public repartidor ListarCedula_repartidor(@WebParam(name = "cedula_repartidor") String cedula_repartidor) {
        repartidor repa = repar.listarCedula_repartidor(cedula_repartidor);
        return repa;
    }
    
    
    //VAALIDACION CEDULAA Y RUC NATURAL
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
