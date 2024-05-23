package com.controlador;

import com.modelo.LoginDao;
import com.modelo.login;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "Validar", urlPatterns = {"/Validar"})
public class Validar extends HttpServlet {

    LoginDao LDao = new LoginDao();
    login l = new login();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        
        // Verificar si el usuario intenta acceder al inicio sin iniciar sesión
        if (accion != null && accion.equalsIgnoreCase("Inicio")) {
            HttpSession session = request.getSession(false);
            if (session == null || session.getAttribute("autenticado") == null) {
                // Si el usuario no está autenticado, redirigirlo a la página de inicio de sesión
                request.getRequestDispatcher("vistas/Login.jsp").forward(request, response);
                return; // Salir del método para evitar procesar más la solicitud
            }
        }
        
        if ("Ingresar".equalsIgnoreCase(accion)) {
            String correo = request.getParameter("txtuser");
            String pass = request.getParameter("txtpass");

            // Validar si el correo o la contraseña son nulos
            if (correo == null || correo.isEmpty() || pass == null || pass.isEmpty()) {
                // Si el correo o la contraseña son nulos, redirigir a la página de error
                request.getRequestDispatcher("vistas/NoLogin.jsp").forward(request, response);
            } else {
                try {
                    l = LDao.validar(correo, pass);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Validar.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (l.getCorreo() != null) {
                    request.getRequestDispatcher("Controlador?accion=menu1").forward(request, response);
                } else {
                    request.getRequestDispatcher("vistas/LoginError.jsp").forward(request, response);
                }
            }
        } else {
            request.getRequestDispatcher("vistas/LoginError.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
