
package com.controlador;

import com.modelo.Cliente;
import com.modelo.ClienteDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ClienteServlet", urlPatterns = {"/ClienteServlet"})
public class ClienteServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            int id = Integer.parseInt(request.getParameter("txtId"));
            int dni = Integer.parseInt(request.getParameter("txtDni"));
            String nombre = request.getParameter("txtNombre");
            int telefono = Integer.parseInt(request.getParameter("txtTelefono"));
            String direccion = request.getParameter("txtDireccion");
            String Razon = request.getParameter("txtRazon");
            String mensaje = "Error";
            int res;

            Cliente c = new Cliente(id, dni, nombre, telefono, direccion,Razon );
            ClienteDAO clienteDAO = new ClienteDAO();

            if (request.getParameter("btnGuardar") != null) {
                res = clienteDAO.insertarCliente(c);
                if (res != 0) {
                    mensaje = "Registro Agregado";
                }
            } else if (request.getParameter("btnEditar") != null) {
                res = clienteDAO.modificarCliente(c);
                if (res != 0) {
                    mensaje = "Registro Modificado";
                }
            } else if (request.getParameter("btnEliminar") != null) {
                res = clienteDAO.eliminarCliente(c);
                if (res != 0) {
                    mensaje = "Registro Eliminado";
                }
            }
            request.setAttribute("message", mensaje);
            request.getRequestDispatcher("/vistas/clientes.jsp").forward(request, response);

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
