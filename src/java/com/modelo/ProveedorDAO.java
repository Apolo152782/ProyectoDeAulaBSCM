/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.modelo;

import com.conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProveedorDAO extends Conexion {
    public int insertarProveedor(Proveedor pv){
        int res = 0;
        try {
            this.conectar();
            String sql = "INSERT INTO proveedores (ruc, nombre, telefono, dirección, Razon)Values(?, ?, ?, ?, ?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, pv.getRuc());
            pre.setString(2, pv.getNombre());
            pre.setInt(3, pv.getTelefono());
            pre.setString(4, pv.getDireccion());
            pre.setString(5, pv.getRazon());
            res = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar "+e.getMessage());
        } finally {
            this.desconectar();
        }
        
        return res;
    }
    
    public Proveedor buscar (String ruc){
        Proveedor pv = new Proveedor();
        String sql = "SELECT * FROM proveedores WHERE ruc ="+ruc;
        try {
            this.conectar();
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet rs;
            rs = pre.executeQuery();
            while(rs.next()){
                pv.setId(rs.getInt(1));
                pv.setRuc(rs.getInt(2));
                pv.setNombre(rs.getString(3));
                pv.setTelefono(rs.getInt(4));
                pv.setDireccion(rs.getString(5));
                pv.setRazon(rs.getString(6));
            }
            
        } catch (SQLException e) {
            System.err.println(e.toString());
        }
        return pv;
    }
    
    public ArrayList<Proveedor> mostrarProveedor(){
        ArrayList<Proveedor> lista = new ArrayList<>();
        try {
            this.conectar();
            String sql = "SELECT * FROM proveedores";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet rs;
            rs = pre.executeQuery();
            while(rs.next()){
                Proveedor pv = new Proveedor();
                pv.setId(rs.getInt(1));
                pv.setRuc(rs.getInt(2));
                pv.setNombre(rs.getString(3));
                pv.setTelefono(rs.getInt(4));
                pv.setDireccion(rs.getString(5));
                pv.setRazon(rs.getString(6));
                
                lista.add(pv);
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar "+e.getMessage());
        } finally {
            this.desconectar();
        }
        return lista;
    }
    
    public int modificarProveedor(Proveedor pv){
        int res = 0;
        try {
            this.conectar();
            String sql = "UPDATE proveedores SET ruc=?, nombre=?, telefono=?, dirección=?, Razon=? WHERE id=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1,pv.getRuc());
            pre.setString(2,pv.getNombre());
            pre.setInt(3, pv.getTelefono());
            pre.setString(4,pv.getDireccion());
            pre.setString(5,pv.getRazon());
            pre.setInt(6, pv.getId());
            
            res = pre.executeUpdate();            
        } catch (SQLException e) {
            System.out.println("Error al modificar "+e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }    
    
    public int eliminarProveedor(Proveedor pv){
        int res = 0;
        try {
            this.conectar();
            String sql = "DELETE FROM proveedores WHERE id=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, pv.getId());
            
            res = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar "+e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }
    
    public String SeleccionarProveedor(){
        String elementos="";
        try{
            this.conectar();
            String sql = "Select nombre from proveedores";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet rs;
            rs = pre.executeQuery();
            while(rs.next()){
                
                String nom = rs.getString("nombre");
                elementos+="<option value='"+nom+"'>"+nom+"</option>";
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar "+e.getMessage());
        } finally {
            this.desconectar();
        }
        return elementos;
    }
}
