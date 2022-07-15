/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sofka.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author 57321
 */
public class ConexionBd {
    
    Connection conectar = null;
    
    String usuario= "postgres";
    String contrasenia= "12345";
    String bd= "bd_nave";
    String ip= "localhost";
    String puerto= "5432";
    
    String cadena="jdbc:postgresql://"+ip+":"+puerto+"/"+bd;
    
    public Connection establecerConexion(){
        try{
            Class.forName("org.postgresql.Driver");     
            conectar = DriverManager.getConnection(cadena,usuario,contrasenia);
            JOptionPane.showMessageDialog(null,"se conecto correctamente a la base de datos");
        
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"error! no se conecto a la base de datos");
        }
           return conectar; 
    }
}
