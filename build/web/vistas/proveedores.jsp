<%@page import="com.modelo.Proveedor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.modelo.ProveedorDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>..::Clientes::..</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdn.datatables.net/1.12.1/css/dataTables.bootstrap5.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/11.4.38/sweetalert2.min.css" />
    </head>
    <body>
        <%! 
            ProveedorDAO proveedorDAO = new ProveedorDAO();
        %>
        <div class="container-fluid navbar-light bg-light">
            <%@include file="/template/menu.jsp" %>
            <hr>
            <div class="row align-items-start">
                <div class="col-9"><h1>Gestion de Proveedores</h1></div>
                <div class="col-3 align-self-center">
                    <div class="d-grid gap-2">
                        <button type="button" class="btn btn-success btnAdd" data-bs-toggle="modal" data-bs-target="#exampleModal">Agregar</button>
                    </div>                    
                </div>
            </div>


            <hr>
            <div class="table-responsive">
                <table class="table table-striped" id="mydataTable">
                    <thead>
                    <th>Id</th>
                    <th>Ruc</th>
                    <th>Nombre</th>
                    <th>Numero de Telefono</th>
                    <th>Direccion</th>
                    <th>Razon</th>
                    <th>Acciones</th>
                    
                    </thead>
                    <tbody>
                        <%
                        ArrayList<Proveedor> listaProveedor = proveedorDAO.mostrarProveedor();
                        
                        for (Proveedor elem : listaProveedor) {     
                            
                        %>
                        <tr>
                            <td class="id"><%= elem.getId() %></td>
                            <td class="ruc"><%= elem.getRuc()%></td>
                            <td class="nombre"><%= elem.getNombre() %></td>
                            <td class="telefono"><%= elem.getTelefono() %></td>
                            <td class = "direccion"><%= elem.getDireccion()%></td>
                            <td class="razon"><%= elem.getRazon() %></td>
                            <td>
                                <button type="button" class="btn btn-dark btnEditar" data-bs-toggle="modal" data-bs-target="#exampleModal">Editar</button>
                                <button type="button" class="btn btn-danger btnEliminar" data-bs-toggle="modal" data-bs-target="#exampleModal">Eliminar</button>
                            </td>
                        </tr>
                        <%
                        }
                        %>
                    </tbody>
                </table>
            </div>
        </div>
        <!-- Button trigger modal -->
        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Datos Proveedor</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form action="${pageContext.servletContext.contextPath}/ProveedorServlet" method="POST" role="form">
                            <div class="row">
                                <div class="col-6">
                                    <label>Id</label>
                                    <input type="number" name="txtId" class="form-control" id="txtId" value="1" readonly="true">
                                </div>
                                <div class="col-6">
                                    <label>Nombre</label>
                                    <input type="text" name="txtNombre" class="form-control" id="txtNombre">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-6">
                                    <label>Ruc</label>
                                    <input type="number" min="1" name="txtRuc" class="form-control" id="txtRuc">
                                </div>
                                
                                <div class="col-6">
                                    <label>Telefono</label>
                                    <input type="tel" min="17" name="txtTelefono" class="form-control" id="txtTelefono">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-6">
                                    <label>Direccion</label>
                                    <input type="text" min="50" name="txtDireccion" class="form-control" id="txtDireccion">
                                </div>
                                <div class="col-6">
                                    <label>Razon</label>
                                    <input type="text" min="50" name="txtRazon" class="form-control" id="txtRazon">
                                </div>
                            </div><br>
                            <div class="row">
                                <div class="col-12">
                                    <button type="submit" name="btnGuardar" class="btn btn-success btnOcultar1">Guardar</button>
                                    <button type="submit" name="btnEditar" class="btn btn-dark btnOcultar">Editar</button>
                                    <button type="submit" name="btnEliminar" class="btn btn-danger btnOcultar">Eliminar</button>
                                    <button type="button" class="btn btn-info" data-bs-dismiss="modal">Cancelar</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
         <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js" ></script>
        <script src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap5.min.js" ></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/11.4.38/sweetalert2.all.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

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
         $('#mydataTable').DataTable({
                    language: {
                        search: "Buscar proveedor",
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
            
            </script>
        <script src="${pageContext.servletContext.contextPath}/js/cliente.js"></script>
    </body>
</html>

