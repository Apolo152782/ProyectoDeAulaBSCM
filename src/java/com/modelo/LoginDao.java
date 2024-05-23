package com.modelo;

import com.conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginDao extends Conexion{
    
    
    public login validar (String correo, String pass) throws ClassNotFoundException{
        login l= new login ();
        String sql = "SELECT * FROM usuarios WHERE correo =? AND pass =?";
        try{
            this.conectar();
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet rs;
            pre.setString(1, correo);
            pre.setString(2, pass);
            rs = pre.executeQuery();
            
            while (rs.next()){
                l.setId(rs.getInt("id"));
                l.setNombre(rs.getString("nombre"));
                l.setCorreo(rs.getString("correo"));
                l.setPass(rs.getString("pass"));
                l.setRol(rs.getString("rol"));
                
            }    
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return l;
    }
    
}

