package ConexionBD;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author INTEL 2021
 */
public class conexionBD {
    Connection con;
    public conexionBD(){
        try{
            Class.forName("org.postgresql.Driver");
            con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/Rio_Rush","postgres","1234");         
        }
        catch(Exception e){
            
        }
    }  
    public Connection getConnection(){
        return con;
    }
  
}
