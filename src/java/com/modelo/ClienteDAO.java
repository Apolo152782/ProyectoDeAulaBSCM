 package com.modelo;

import com.conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ClienteDAO extends Conexion {
    public int insertarCliente(Cliente c){
        int res = 0;
        try {
            this.conectar();
            String sql = "INSERT INTO cliente (dni, nombre, telefono, dirección, Razon)Values(?, ?, ?, ?, ?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, c.getDni());
            pre.setString(2, c.getNombre());
            pre.setInt(3, c.getTelefono());
            pre.setString(4, c.getDireccion());
            pre.setString(5, c.getRazon());
            
            res = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar "+e.getMessage());
        } finally {
            this.desconectar();
        }
        
        return res;
    }
    
    public Cliente buscar (String dni){
        Cliente c = new Cliente();
        String sql = "SELECT * FROM cliente WHERE dni ="+dni;
        try {
            this.conectar();
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet rs;
            rs = pre.executeQuery();
            while(rs.next()){
                c.setId(rs.getInt(1));
                c.setDni(rs.getInt(2));
                c.setNombre(rs.getString(3));
                c.setTelefono(rs.getInt(4));
                c.setDireccion(rs.getString(5));
                c.setRazon(rs.getString(6));
            }
            
        } catch (SQLException e) {
            System.err.println(e.toString());
        }
        return c;
    }
    
    public ArrayList<Cliente> mostrarClientes(){
        ArrayList<Cliente> lista = new ArrayList<>();
        try {
            this.conectar();
            String sql = "SELECT * FROM cliente";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet rs;
            rs = pre.executeQuery();
            while(rs.next()){
                Cliente c = new Cliente();
                c.setId(rs.getInt(1));
                c.setDni(rs.getInt(2));
                c.setNombre(rs.getString(3));
                c.setTelefono(rs.getInt(4));
                c.setDireccion(rs.getString(5));
                c.setRazon(rs.getString(6));
                
                lista.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar "+e.getMessage());
        } finally {
            this.desconectar();
        }
        return lista;
    }
    
    public int modificarCliente(Cliente c){
        int res = 0;
        try {
            this.conectar();
            String sql = "UPDATE cliente SET dni=?, nombre=?, telefono=?, dirección=?, Razon=? WHERE id=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1,c.getDni());
            pre.setString(2,c.getNombre());
            pre.setInt(3, c.getTelefono());
            pre.setString(4,c.getDireccion());
            pre.setString(5,c.getRazon());
            pre.setInt(6, c.getId());
            
            res = pre.executeUpdate();            
        } catch (SQLException e) {
            System.out.println("Error al modificar "+e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }    
    
    public int eliminarCliente(Cliente c){
        int res = 0;
        try {
            this.conectar();
            String sql = "DELETE FROM cliente WHERE id=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, c.getId());
            
            res = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar "+e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }
}
