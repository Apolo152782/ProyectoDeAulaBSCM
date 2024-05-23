<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
  
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Inicio</title>
</head>
<body>
    <style>
        .nav-link:hover {
            background-color: #fff59d;
            padding: 15px 30px;
            border-radius: 20px;

        }
        .nav-link {
            color: #fff;
            text-decoration: none;
            display: block;
            padding: 20px 30px;
            transition: padding 0.5s;
            border-radius: 20px;
        }
        .nav-item {
            margin-right:  25px; /* Ajusta este valor para aumentar o disminuir la separación entre los botos home, nueva venta, etc */
        }
        .container-fluid{
            background-color: #1ABC9C;
        }
        .nav-link .bi {
            margin-right: 4px; /* Espacio entre el icono y el texto */
            vertical-align: middle; /* Alineación vertical */
        }
        .navbar {
            margin-top: 0;
            margin-bottom: 0;
            padding-top: 0;
            padding-bottom: 0;
            margin-left: 0;
            margin-right: 0;

        }
        body, html {
            margin: 0;
            padding: 0;
        }

    </style>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">IceCream</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="${pageContext.servletContext.contextPath}/Controlador?accion=menu1">
                            <i class="bi bi-house"> Home</i> 
                        </a>
                    </li>
                    <li class="nav-item ">
                        <a class="nav-link active" aria-current="page" href="${pageContext.servletContext.contextPath}/vistas/RegistrarVentas.jsp" target="_blank">  
                            <i class="bi bi-shop"> Nueva venta</i>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page"  href="${pageContext.servletContext.contextPath}/vistas/clientes.jsp">
                            <i class="bi bi-person-add"> Clientes</i>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page"  href="${pageContext.servletContext.contextPath}/vistas/proveedores.jsp">
                            <i class="bi bi-person-add"> Proveedores</i>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="${pageContext.servletContext.contextPath}/vistas/productos.jsp"> 
                            <i class="bi bi-box"> Productos</i> 
                        </a>
                    </li>   
                    
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="${pageContext.servletContext.contextPath}/vistas/detalleVentas.jsp"> 
                            <i class="bi bi-box"> Ventas</i> 
                        </a>
                    </li>       
                </ul>
                <!-- Example single danger button -->
                <div class="btn-group">
                    <button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown"
                            aria-expanded="false">
                        Usuario en linea
                    </button>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" style="cursor: pointer"></a></li>
                        <li><a class="dropdown-item" href="/ProyectoDeAula/index.jsp">Cerrar Sesion</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </nav>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
crossorigin="anonymous"></script>

</html>
