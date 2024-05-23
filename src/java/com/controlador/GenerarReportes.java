package com.controlador;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


@WebServlet("/GenerarReportes")
public class GenerarReportes extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Configuración de la respuesta
        response.setContentType("application/pdf");
       response.setHeader("Content-Disposition", "inline; filename=\"reporte.pdf\"");
        // Obtiene los datos de la base de datos
        try {
            String jdbcUrl = "jdbc:mysql://localhost/heladeria";
            String username = "root";
            String password = "";

            // Consulta para obtener los datos que deseas exportar
            try ( // Establece la conexión con la base de datos
                    Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
                // Consulta para obtener los datos que deseas exportar
                String sql = "SELECT id, cod_pro, Nompro,cantidad, precio, id_venta,fecha FROM detalles";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                // Crea el documento PDF
                Document document = new Document(PageSize.A3);
                PdfWriter.getInstance(document, response.getOutputStream());
                document.open();
                // Agrega el título al documento
                Paragraph title = new Paragraph("DETALLES DE VENTAS");
                title.setAlignment(Element.ALIGN_CENTER);
                document.add(title);
                document.add(new Paragraph("\n\n ")); // Espacio en blanco
                // Crea la tabla para almacenar los datos
                PdfPTable table = new PdfPTable(7); // Cinco columnas
                // Agrega encabezados de columna
                table.addCell("ID");
                table.addCell("Código de Producto");
                table.addCell("Cantidad");
                table.addCell("Nombre de Producto");
                table.addCell("Precio");
                table.addCell("ID de Venta");
                table.addCell("Fecha y Hora");
                // Agrega los datos a la tabla
                while (resultSet.next()) {
                    table.addCell(resultSet.getString("id"));
                    table.addCell(resultSet.getString("cod_pro"));
                    table.addCell(resultSet.getString("Nompro"));
                    table.addCell(resultSet.getString("cantidad"));
                    table.addCell(resultSet.getString("precio"));
                    table.addCell(resultSet.getString("id_venta"));
                    table.addCell(resultSet.getString("fecha"));
                }   // Agrega la tabla al documento
                document.add(table);
                // Cierra el documento
                document.close();
                // Cierra la conexión
            }
        } catch (DocumentException | IOException | SQLException e) {
            response.getWriter().println("Error al generar el PDF: " + e.getMessage());
        }
    }
}
