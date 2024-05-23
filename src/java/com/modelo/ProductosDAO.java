package com.modelo;

import com.conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


    public class ProductosDAO extends Conexion {
    public int insertarProductos(Productos pro){
        int res = 0;
        try {
            this.conectar();
            String sql = "INSERT INTO productos ( codigo, nombre, proveedores, stock, precio)Values(?, ?, ?, ?, ?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, pro.getCodigo());
            pre.setString(2, pro.getNombre());
            pre.setString(3, pro.getProveedores());
            pre.setInt(4, pro.getStock());
            pre.setDouble(5, pro.getPrecio());
            
            res = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar "+e.getMessage());
        } finally {
            this.desconectar();
        }
        
        return res;
    }
    
    public Productos ListarCodigo (String codigo){
        Productos pro = new Productos();
        String sql = "SELECT * FROM productos WHERE codigo =" + codigo;
        try {
            this.conectar();
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet rs;
            rs = pre.executeQuery();
            while(rs.next()){
                pro.setId(rs.getInt(1));
                pro.setCodigo(rs.getInt (2));
                pro.setNombre(rs.getString(3));
                pro.setProveedores(rs.getString(4));
                pro.setStock(rs.getInt(5));
                pro.setPrecio(rs.getInt(6));
            }
            
        } catch (SQLException e) {
            System.err.println(e.toString());
        }
        return pro;
    }
    
    
    public ArrayList<Productos> mostrarProductos(){
        ArrayList<Productos> lista = new ArrayList<>();
        try {
            this.conectar();
            String sql = "SELECT * FROM productos";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet rs;
            rs = pre.executeQuery();
            while(rs.next()){
                Productos pro = new Productos();
                pro.setId(rs.getInt(1));
                pro.setCodigo(rs.getInt(2));
                pro.setNombre(rs.getString(3));
                pro.setProveedores(rs.getString(4));
                pro.setStock(rs.getInt(5));
                pro.setPrecio(rs.getDouble(6));
                
                lista.add(pro);
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar "+e.getMessage());
        } finally {
            this.desconectar();
        }
        return lista;
    }
    
    public int modificarProdcutos (Productos pro){
        int res = 0;
        try {
            this.conectar();
            String sql = "UPDATE productos SET codigo=?, nombre=?, proveedores=?, stock=?, precio=? WHERE id=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1,pro.getCodigo());
            pre.setString(2,pro.getNombre());
            pre.setString(3, pro.getProveedores());
            pre.setInt(4,pro.getStock());
            pre.setDouble(5,pro.getPrecio());
            pre.setInt(6, pro.getId());
            
            res = pre.executeUpdate();            
        } catch (SQLException e) {
            System.out.println("Error al modificar "+e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }    
    
    public int eliminarProductos(Productos pro){
        int res = 0;
        try {
            this.conectar();
            String sql = "DELETE FROM productos WHERE id=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, pro.getId());
            
            res = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar "+e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }
    public Productos buscar(int codigo) {
        Productos pro = new Productos();
        String sql = "select * from productos where codigo=" + codigo;
        try {
            this.conectar();
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet rs;
            rs = pre.executeQuery();
            while (rs.next()) {
                pro.setId(rs.getInt(1));
                pro.setCodigo(rs.getInt(2));
                pro.setNombre(rs.getString(3));
                pro.setProveedores(rs.getString(4));
                pro.setStock(rs.getInt(5));
                pro.setPrecio(rs.getDouble(6));
            }
        } catch (Exception e) {
        }
        return pro;
    }
    
    public int actualizarstock(int codigo, int stock) {
        String sql = "update productos set stock=? where codigo=?";
        int r = 0;
        try {
            this.conectar();
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            
            pre.setInt(1, stock);
            pre.setInt(2, codigo);
            pre.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
}

    

