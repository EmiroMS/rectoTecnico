/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sofka.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 57321
 */
public class LogicaNave extends ConexionBd{
    
    // metodo de registro
    public boolean registroNave(ModeloNave modelNave){
        
        PreparedStatement ps = null;
        Connection conectar = establecerConexion();
        
        String sql = "INSERT INTO bd_nave (tipo,color,peso) VALUES (?,?,?)";
        
        try {
            ps = conectar.prepareStatement(sql);
            ps.setString(1, modelNave.getTipo());
            ps.setString(2, modelNave.getColor());
            ps.setInt(3, modelNave.getPeso());
            ps.execute();
            return true;
        }catch(SQLException e) {
            System.err.println(e);
            return false;
        }finally{
        
            try {
                conectar.close();
            }catch(SQLException e) {
                System.err.println(e);
            }
        
       }
    }
    
    //metodo de actualizar
    public boolean ActualizarNave(ModeloNave modelNave){
        
        PreparedStatement ps = null;
        Connection conectar = establecerConexion();
        
        String sql = "UPDATE bd_nave SET tipo=?,color=?,peso=? WHERE id=?";
        
        try {
            ps = conectar.prepareStatement(sql);
            ps.setString(1, modelNave.getTipo());
            ps.setString(2, modelNave.getColor());
            ps.setInt(3, modelNave.getPeso());
            ps.setInt(4, modelNave.getId());
            ps.execute();
            return true;
        }catch(SQLException e) {
            System.err.println(e);
            return false;
        }finally{
        
            try {
                conectar.close();
            }catch(SQLException e) {
                System.err.println(e);
            }
        
       }
    }


//metodo eliminar
     public boolean EliminarNave(ModeloNave modelNave){
        
        PreparedStatement ps = null;
        Connection conectar = establecerConexion();
        
        String sql = "DELETE FROM bd_nave WHERE id=?";
        
        try {
            ps = conectar.prepareStatement(sql);
            ps.setInt(1, modelNave.getId());
            ps.execute();
            return true;
        }catch(SQLException e) {
            System.err.println(e);
            return false;
        }finally{
        
            try {
                conectar.close();
            }catch(SQLException e) {
                System.err.println(e);
            }
        
       }
    }

// metodo de buscar o filtrar
     public boolean filtrarNave(ModeloNave modelNave){
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conectar = establecerConexion();
        
        String sql = "SELECT * FROM bd_nave WHERE tipo=?";
        
        try {
            ps = conectar.prepareStatement(sql);
            ps.setString(1, modelNave.getTipo());
            rs=ps.executeQuery();
            
            
            if(rs.next()){
                modelNave.setId(Integer.parseInt( rs.getString("id")));
                modelNave.setTipo(rs.getString("tipo"));
                modelNave.setColor(rs.getString("color"));
                modelNave.setPeso(Integer.parseInt( rs.getString("peso")));
                return true;
            }
            
            
            return false;
        }catch(SQLException e) {
            System.err.println(e);
            return false;
        }finally{
        
            try {
                conectar.close();
            }catch(SQLException e) {
                System.err.println(e);
            }
        
       }
    }
}