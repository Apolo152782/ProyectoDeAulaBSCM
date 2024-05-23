package com.modelo;

public class DetalleVentas {

    private int id;
    private String cod_pro;
    private String Nompro;
    private int cantidad;
    private double precio;
    private int id_venta;
    private String fecha;

    public DetalleVentas() {
    }

    public DetalleVentas(int id, String cod_pro, String Nompro,int cantidad, double precio, int id_venta,String fecha) {
        this.id = id;
        this.cod_pro = cod_pro;
        this.Nompro =Nompro;
        this.fecha= fecha;
        this.cantidad = cantidad;
        this.precio = precio;
        this.id_venta = id_venta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCod_pro() {
        return cod_pro;
    }

    public String getNompro() {
        return Nompro;
    }

    public void setNompro(String Nompro) {
        this.Nompro = Nompro;
    }

    public void setCod_pro(String cod_pro) {
        this.cod_pro = cod_pro;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

}
