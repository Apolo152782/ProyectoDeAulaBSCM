<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="style </headsheet" href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/11.4.38/sweetalert2.min.css" />
        <title>Registrar ventas</title>
    </head>
    <body>
        <div class="container-fluid navbar-light bg-light">
            <%@include file="../template/menu.jsp" %>
            <hr>
            <div class="row align-items-start">
                <div class="col-9"><h1>Gestion de Venta</h1></div>
                <div class="col-3 align-self-center">

                </div>
            </div>

            <div class="d-flex">
                <div class="col-sm-5">
                    <div class="card">
                        <form action="${pageContext.servletContext.contextPath}/VentaServlet" method="POST" role="form">
                            <div class="card-body">
                                <div class="form-group">
                                    <label>Datos del Cliente</label>
                                </div>
                                <div class="form-group d-flex ">
                                    <div class="col-sm-6 d-flex ">
                                        <input type="text" name="codigoCliente" value="${c.getDni()}" class="form-control" placeholder="Dni">
                                        <button type="submit" name="accion" value="BuscarCliente" class="btn btn-primary">  Buscar</button>
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" name="nombrecliente" value="${c.getNombre()}" class="form-control ">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label>Datos del Producto</label>
                                </div>
                                <div class="form-group d-flex ">
                                    <div class="col-sm-6 d-flex ">
                                        <input type="text" name="codigoproducto" value="${producto.getCodigo()}"class="form-control"  placeholder="Codigo">
                                        <button type="submit" name="accion" value="BuscarProducto" class="btn btn-primary">  Buscar</button>
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" name="nombreproducto" value="${producto.getNombre()}" class="form-control " placeholder="Datos Producto">
                                    </div>
                                </div>
                                <div class="form-group d-flex">
                                    <div class="col-sm-6 d-flex ">
                                        <input type="text" name="precio" class="form-control" value="${producto.getPrecio()}" placeholder="$/0.00">
                                    </div>

                                    <div class="col-sm-3 d-flex ">
                                        <input type="number" name="cantidad" class="form-control"value="1" >
                                    </div>

                                    <div class="col-sm-3 d-flex ">
                                        <input type="text" name="stock" class="form-control" value="${producto.getStock()}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input type="submit" name="accion" value="Agregar" class="btn btn-success">
                                </div>                            
                                    
                        </form>
                    </div>
                </div> 
            </div>
            <div class="col-sm-7">
                <div class="card">
                    <div class="card-body ">
                       
                        <br>
                        <table class="table table-dark table-hover"">
                            <thead>
                                <tr>
                                    <th>Nro</th>
                                    <th>Codigo</th>
                                    <th>Decripcion</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>Subtotal</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="list" items="${lista}">
                                <tr>
                                    <td>${list.getItem()}</td>
                                    <td>${list.getCodproducto()}</td>
                                    <td>${list.getDescripcionP()} </td>
                                    <td>${list.getPrecio()}</td>
                                    <td>${list.getCantidad()}</td>
                                    <td>${list.getSubtotal()}</td>
                                    <td class="d-flex text-center">
                                        <a href="VentaServlet?accion=Eliminar&id=${list.getCodproducto()}" class="btn btn-danger">Eliminar</a>                                    
                                    </td>
                                 
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>

                    </div>

                    <div class="card-footer d-flex">
                        <div class="colm-sm-6">
                            <a href =VentaServlet?accion=GenerarVenta class ="btn btn-success">Generar Venta</a>
                            <input type="submit" name="accion" value="Cancelar "class="btn btn-danger" >
                        </div>
                        <div class="colm-sm-3 ml-auto">
                            <input type="type" name="txtTotal" value="${totalpagar}" class="form-control">
                        </div>
                    </div>    
                </div>
            </div>
        </div>     
                        
           <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script> 
    </body>
</html>
