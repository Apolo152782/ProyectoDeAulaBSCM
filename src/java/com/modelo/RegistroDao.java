package com.modelo;

import com.conexion.Conexion;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistroDao extends Conexion {
  public boolean registrar(Registro registro) {
        try {
            this.conectar();
            String sql = "INSERT INTO usuarios (nombre, correo, pass, rol) VALUES (?, ?, ?, ?)";

            PreparedStatement pre = this.getCon().prepareStatement(sql);
            
            pre.setString(1, registro.getNombre());
            pre.setString(2, registro.getCorreo());
            pre.setString(3, registro.getPass());
            pre.setString(4, registro.getRol());
            pre.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar registro en la base de datos: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return false;
    }
}