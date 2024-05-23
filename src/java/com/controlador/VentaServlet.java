package com.controlador;

import com.modelo.Venta;
import com.modelo.Cliente;
import com.modelo.ClienteDAO;
import com.modelo.Productos;
import com.modelo.ProductosDAO;
import com.modelo.VentaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "VentaServlet", urlPatterns = {"/VentaServlet"})
public class VentaServlet extends HttpServlet {
    
    Cliente c = new Cliente();
    ClienteDAO cdao = new ClienteDAO();
    Productos p = new Productos();
    ProductosDAO pdao = new ProductosDAO();
    Venta v  = new Venta();
    VentaDAO vdao = new VentaDAO();
    List<Venta>Lista=new ArrayList<>();
    
    java.util.Date ahora = new java.util.Date();
    SimpleDateFormat formateador= new SimpleDateFormat("yyyy/MM/dd");
    
    int item;
    int cod;
    String descripcion;
    double precio;
    int cant;
    double subtotal;
    double totalpagar;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion =request.getParameter("accion");
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            
            switch (accion) {
                case "BuscarCliente":
                    String dni = request.getParameter("codigoCliente");
                    c.setDni(0);
                    c =cdao.buscar(dni);
                    request.setAttribute("c", c);
                    break;
                case "BuscarProducto":   
                    String codigo =request.getParameter("codigoproducto");
                    p=pdao.ListarCodigo(codigo);
                    request.setAttribute("producto", p);
                    request.setAttribute("lista", Lista);
                    request.setAttribute("totalpagar", totalpagar);
                    request.setAttribute("c", c);
                    break;
                case"Agregar" :
                    totalpagar = 0.0;
                    item = item+1;
                    cod=p.getCodigo();
                    descripcion=request.getParameter("nombreproducto");
                    precio=Double.parseDouble(request.getParameter("precio"));
                    cant=Integer.parseInt(request.getParameter("cantidad"));
                    subtotal=precio*cant;
                    v=new Venta();
                    v.setItem(item);
                    v.setCodproducto(cod);
                    v.setDescripcionP(descripcion);
                    v.setPrecio(precio);
                    v.setCantidad(cant);
                    v.setSubtotal(subtotal);
                    Lista.add(v);
                    
                    for (int i = 0; i < Lista.size(); i++) {
                        totalpagar=totalpagar+Lista.get(i).getSubtotal();
                    }
                    request.setAttribute("totalpagar", totalpagar);
                    request.setAttribute("lista", Lista);
                    
                    break;
                    
                    case "Eliminar":
                    int idEliminar = Integer.parseInt(request.getParameter("id"));
                    for (int i = 0; i < Lista.size(); i++) {
                        if (Lista.get(i).getCodproducto() == idEliminar) {
                            Lista.remove(i);
                            break;
                        }
                    }
                    totalpagar = 0.0;
                    for (int i = 0; i < Lista.size(); i++) {
                        totalpagar = totalpagar + Lista.get(i).getSubtotal();
                    }
                    request.setAttribute("totalpagar", totalpagar);
                    request.setAttribute("lista", Lista);
                    break;
                    
                case "GenerarVenta":
                    //ActualizarStock
                    for (int i = 0; i < Lista.size(); i++) {
                        Productos pr = new Productos();
                        int cantidad = Lista.get(i).getCantidad();
                        int id = Lista.get(i).getCodproducto();
                        ProductosDAO aO = new ProductosDAO();
                        pr = aO.buscar(id);
                        int sac = pr.getStock() - cantidad;
                        aO.actualizarstock(id, sac);
                    }
                 
                    //guardar venta
                    v.setCodcliente(c.getNombre());
                    v.setCodempleado("juan");
                    v.setSubtotal(totalpagar);
                    v.setFecha(formateador.format(ahora));
                    vdao.guardarVenta(v);
                    
                    //guardar detalle venta
                   int idv = Integer.parseInt(vdao.IdVentas());
                    for (int i = 0; i < Lista.size(); i++) {
                        v = new Venta();
                        v.setId(idv);
                        v.setCodproducto(Lista.get(i).getCodproducto());
                        v.setDescripcionP(Lista.get(i).getDescripcionP());
                        v.setCantidad(Lista.get(i).getCantidad());
                        v.setPrecio(Lista.get(i).getPrecio());
                        vdao.guardarDetalleventas(v);
                    }
                    
                    Lista = new ArrayList<>();
                    break;
                    
                    
                default:
                    
                    
                    request.getRequestDispatcher("/vistas/RegistrarVentas.jsp").forward(request, response);
            }
            
            request.getRequestDispatcher("/vistas/RegistrarVentas.jsp").forward(request, response);

        } catch (Exception e) {
            System.out.println("Error " + e.getLocalizedMessage());
        }
    }

      
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
