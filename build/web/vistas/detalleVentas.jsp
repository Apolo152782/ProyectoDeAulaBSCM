<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.modelo.DetallesVentasDao" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.modelo.DetalleVentas" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>..::Detalle::..</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdn.datatables.net/1.12.1/css/dataTables.bootstrap5.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/11.4.38/sweetalert2.min.css" />
    </head>
    <body>
        <div >
            <%@include file="../template/menu.jsp"%>
            <hr>
            <div class="row align-items-start">
                <div class="col-9"><h1>Detalles de ventas</h1></div>
                <div class="col-3 align-self-center">
                    <li class="nav-item">
                        <form action="${pageContext.servletContext.contextPath}/GenerarReportes" method="post" target="_blank">
                            <button type="submit" class="btn btn-primary">Generar reportes de ventas en PDF</button>
                        </form>
                    </li>
                </div>
            </div>
            <hr>
            <div class="table-responsive" class="container">
                <table class="table table-striped" id="mydataTable">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Código de Producto</th>
                            <th>Nombre del producto</th>
                            <th>Cantidad</th>
                            <th>Precio</th>
                            <th>ID de Venta</th>
                            <th>Fecha y Hora</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                        DetallesVentasDao dao = new DetallesVentasDao();
                        ArrayList<DetalleVentas> listaDetalleVentas = dao.mostrarDetallesVentas();
                        for (DetalleVentas elem : listaDetalleVentas) {
                        %>
                        <tr>
                            <td class="id"><%= elem.getId() %></td>
                            <td class="codigo"><%= elem.getCod_pro() %></td>
                            <td class="npro"><%= elem.getNompro()%></td>
                            <td class="cantidad"><%= elem.getCantidad() %></td>
                            <td class="precio"><%= elem.getPrecio() %></td>
                            <td class="idventa"><%= elem.getId_venta()%></td>
                            <td class="fechahora" ><%= elem.getFecha()%></td>
                        </tr>
                        <%
                        }
                        %>
                    </tbody>
                </table>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.6.1.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap5.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/11.4.38/sweetalert2.all.min.js"></script>

        <%
        if (request.getAttribute("message") != null) {
        %>
        <script>
            $(document).ready(function () {
                Swal.fire({
                    position: 'center',
                    icon: 'success',
                    title: '<%= request.getAttribute("message") %>',
                    showConfirmButton: false,
                    timer: 3000
                });
            });
        </script>
        <%
        }
        %>

        <script>
            $(document).ready(function () {
                if ($.fn.DataTable.isDataTable('#mydataTable')) {
                    $('#mydataTable').DataTable().destroy();
                }

                $('#mydataTable').DataTable({
                    language: {
                        search: "Buscar:",
                        paginate: {
                            first: "Primero",
                            last: "Último",
                            next: "Siguiente",
                            previous: "Anterior"
                        },
                        info: "Mostrando la página _PAGE_ de _PAGES_",
                        infoFiltered: "(filtrado de _MAX_ registros totales)",
                        lengthMenu: "Mostrar _MENU_ registros por página"
                    }
                });
            });
        </script>
    </body>
</html>
