package com.controlador;

import com.modelo.Productos;
import com.modelo.ProductosDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "ProductosServlet", urlPatterns = {"/ProductosServlet"})
public class ProductosServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            int id = Integer.parseInt(request.getParameter("txtId"));
            int codigo = Integer.parseInt(request.getParameter("txtCodigo"));
            String nombre = request.getParameter("txtNombre");
            String proveedores = request.getParameter("txtProveedores");
            int stock = Integer.parseInt(request.getParameter("txtStock"));
            double precio = Double.parseDouble(request.getParameter("txtPrecio"));
            String mensaje = "Error";
            int res;
  
    Productos c = new Productos(id, codigo, nombre, proveedores, stock,precio);
            ProductosDAO productosDAO = new ProductosDAO();
            
            if (request.getParameter("btnGuardar") != null) {
                res = productosDAO.insertarProductos(c);
                if (res != 0) {
                    mensaje = "Registro Agregado";
                }
            } else if (request.getParameter("btnEditar") != null) {
                res = productosDAO.modificarProdcutos(c);
                if (res != 0) {
                    mensaje = "Registro Modificado";
                }
            } else if (request.getParameter("btnEliminar") != null) {
                res = productosDAO.eliminarProductos(c);
                if (res != 0) {
                    mensaje = "Registro Eliminado";
                }
            }
            request.setAttribute("message", mensaje);
            request.getRequestDispatcher("/vistas/productos.jsp").forward(request, response);

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
    }// </editor-fold>

}
