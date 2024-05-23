package com.modelo;
import com.conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

     
public class DetallesVentasDao extends Conexion{
       public ArrayList<DetalleVentas> mostrarDetallesVentas(){
        ArrayList<DetalleVentas> lista = new ArrayList<>();
        try {
            
            this.conectar();
            String sql = "SELECT * FROM detalles";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet rs;
            rs = pre.executeQuery();
            while(rs.next()){
                DetalleVentas detalles = new DetalleVentas();
                detalles.setId(rs.getInt(1));
                detalles.setCod_pro(rs.getString(2));
                detalles.setNompro(rs.getString(3));                
                detalles.setCantidad(rs.getInt(4));
                detalles.setPrecio(rs.getDouble(5));
                detalles.setId_venta(rs.getInt(6));
                detalles.setFecha(rs.getString(7));
              
                lista.add(detalles);
                
                
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar "+e.getMessage());
        } finally {
            this.desconectar();
        }
        return lista;
    }
    
}
