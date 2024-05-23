package com.controlador;

import com.modelo.RegistroDao;
import com.modelo.Registro;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ValidarRegistros", urlPatterns = {"/ValidarRegistros"})
public class ValidarRegistros extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            int id = Integer.parseInt(request.getParameter("txtid"));
            String nombre = request.getParameter("txtnombre"); // Cambiado de txtid a txtnombre
            String correo = request.getParameter("txtuser");
            String pass = request.getParameter("txtpass");
            String rol = request.getParameter("txtrol");
            String mensaje;

            Registro registro = new Registro(id, nombre, correo, pass, rol);
            RegistroDao Rdao = new RegistroDao();

            if (request.getParameter("btnGuardar") != null) {
                boolean res = Rdao.registrar(registro);
                if (res) {
                    mensaje = "Registro Agregado";
                } else {
                    mensaje = "Error al agregar el registro";
                }
            } else {
                mensaje = "Error: no se presionó el botón de guardar.";
            }
            request.setAttribute("message", mensaje);
            request.getRequestDispatcher("/vistas/registro_exitoso.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "Error: " + e.getMessage());
            request.getRequestDispatcher("/vistas/NoLogin.jsp").forward(request, response);
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
        return "Servlet que valida y registra un nuevo usuario";
    }
}