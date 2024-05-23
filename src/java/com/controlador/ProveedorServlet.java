package com.controlador;

import com.modelo.Proveedor;
import com.modelo.ProveedorDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "ProveedorServlet", urlPatterns = {"/ProveedorServlet"})
public class ProveedorServlet extends HttpServlet {

     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            int id = Integer.parseInt(request.getParameter("txtId"));
            int ruc = Integer.parseInt(request.getParameter("txtRuc"));
            String nombre = request.getParameter("txtNombre");
            int telefono = Integer.parseInt(request.getParameter("txtTelefono"));
            String direccion = request.getParameter("txtDireccion");
            String Razon = request.getParameter("txtRazon");
            String mensaje = "Error";
            int res;

            Proveedor pv = new Proveedor(id, ruc, nombre, telefono, direccion,Razon );
            ProveedorDAO proveedorDAO = new ProveedorDAO();

            if (request.getParameter("btnGuardar") != null) {
                res = proveedorDAO.insertarProveedor(pv);
                if (res != 0) {
                    mensaje = "Registro Agregado";
                }
            } else if (request.getParameter("btnEditar") != null) {
                res = proveedorDAO.modificarProveedor(pv);
                if (res != 0) {
                    mensaje = "Registro Modificado";
                }
            } else if (request.getParameter("btnEliminar") != null) {
                res = proveedorDAO.eliminarProveedor(pv);
                if (res != 0) {
                    mensaje = "Registro Eliminado";
                }
            }
            request.setAttribute("message", mensaje);
            request.getRequestDispatcher("/vistas/proveedores.jsp").forward(request, response);

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
