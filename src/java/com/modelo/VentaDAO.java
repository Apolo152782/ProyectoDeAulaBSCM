package com.modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.conexion.Conexion;


public class VentaDAO extends  Conexion {
    int r;
    public String GenerarSerie(){
        String numeroserie = "";
        String sql = "select max(NumeroSerie) from ventas";
        try {
            this.conectar();
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet rs;
            rs = pre.executeQuery();
            while(rs.next()){
                numeroserie=rs.getString(1);
            }
        } catch (SQLException e) {
            System.err.println(e.toString());
        }
        return numeroserie;
    }
    public String IdVentas(){
        String idventas="";
        String sql="select max(id) from ventas";
        try {
            this.conectar();
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet rs;
            rs = pre.executeQuery();
            while(rs.next()){
                idventas=rs.getString(1);
            }
        } catch (Exception e) {
        }
        return idventas;
    }
    public int guardarVenta(Venta v){
        String sql = "INSERT INTO ventas (cliente, vendedor, total, fecha)Values(?, ?, ?, ?)";        
        try {
            this.conectar();
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            
            pre.setString(1,v.getCodcliente());
            pre.setString(2,v.getCodempleado());
            pre.setDouble(3,v.getSubtotal());
            pre.setString(4, v.getFecha());
            pre.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
   public int guardarDetalleventas(Venta venta){
        String sql = "INSERT INTO detalles (cod_pro, Nompro,cantidad, precio, id_venta) VALUES (?,?,?,?,?)";
        try {
            this.conectar();
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, venta.getCodproducto());
            pre.setString(2,venta.getDescripcionP());
            pre.setInt(3, venta.getCantidad());
            pre.setDouble(4, venta.getPrecio());
            pre.setInt(5, venta.getId());
            pre.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
}
