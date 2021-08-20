/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Dao.productoDaoImpl;
import Model.producto;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author INTEL 2021
 */
@WebService(serviceName = "Cliente_restaurante")
public class Cliente_restaurante {
    productoDaoImpl pro = new productoDaoImpl();
    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "Listar_producto")
    public List<producto> Listar_producto() {
        List productos = pro.listar();
        return productos;       
    }
    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "Agregar_producto")
    public String Agregar_producto(@WebParam(name = "id_producto") int id_producto, @WebParam(name = "ruc") String ruc, @WebParam(name = "nombre_producto") String nombre_producto, @WebParam(name = "descripcion") String descripcion, @WebParam(name = "precio_unitario") double precio_unitario) {
 
        String verificar = validacionrucnatural(ruc);
        if(verificar.equals("Ruc Natural Correcto")){
            String datos = pro.agregar(id_producto, ruc, nombre_producto, descripcion, precio_unitario);
            return datos;
        }
            return "Error: No existe ese ruc natural";          
    }
    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "Editar_producto")
    public String Editar_producto(@WebParam(name = "id_producto") int id_producto, @WebParam(name = "nombre_producto") String nombre_producto, @WebParam(name = "descripcion") String descripcion, @WebParam(name = "precio_unitario") double precio_unitario) {  
        String datos = pro.editar(id_producto, nombre_producto, descripcion, precio_unitario);
        return datos;
    }
    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "ListarID")
    public producto ListarID_producto(@WebParam(name = "id_producto") int id_producto) {
        producto prod = pro.listarID(id_producto);
        return prod;
    }
     /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "Eliminar")
    public producto Eliminar_producto(@WebParam(name = "id_producto") int id_producto) {
        producto prod = pro.eliminar(id_producto);
        return prod;  
    }
    
     /**
     * Web service operation
     * @param cedula
     * @return 
     */
    @WebMethod(operationName = "validacioncedula")
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

    /**
     * Web service operation
     * @param ruc_natural
     * @return 
     */
    @WebMethod(operationName = "validacionrucnatural")
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

