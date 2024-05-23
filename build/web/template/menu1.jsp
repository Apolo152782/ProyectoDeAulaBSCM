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
                            <a class="nav-link active" aria-current="page" href="${pageContext.servletContext.contextPath}/vistas/RegistrarVentas.jsp">  
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
                               <i class="bi bi-bag-check"> Proveedores</i>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="${pageContext.servletContext.contextPath}/vistas/productos.jsp"> 
                                <i class="bi bi-box"> Productos</i> 
                            </a>
                        </li>   
                        
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="${pageContext.servletContext.contextPath}/vistas/detalleVentas.jsp"> 
                               <i class="bi bi-receipt-cutoff"> Ventas</i> 
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
            <header class="bg_animate">
                <div class="header_nav">
                    <div class="contenedor">
                        <h1>Bienvenido al sistema de ventas Ice Cream</h1>
                        <nav>
                            <a href="#">Servicios</a> <!--  podemos colocar que ofreces como empresa, por ejemplo tipo mision, vision, etc  -->
                            <a href="#">Contacto</a> <!--un link a nuestro email para ofrecer el software -->
                        </nav>
                    </div>
                </div>

                <section class="banner contenedor">
                    <secrion class="banner_title">
                        <h2>Necesitas ayuda, <br>puedes escribirnos</h2> <!-- se me ocurre tipo como un lema -->
                        <a href="https://wa.link/bva55j" class="llamanos">Contáctanos!</a>
                    </secrion>
                    <div class="banner_img">
                        <img src="vistas/LogoInicio1.png" alt="">
                    </div>
                </section>
                <style>
                    *{
                        margin: 0;
                        padding: 0;
                        box-sizing: border-box;
                    }

                    body{
                        font-family: 'Roboto', 'Sans serif';
                    }

                    .contenedor{
                        width: 90%;
                        max-width: 1200px;
                        margin: auto;
                    }

                    .bg_animate{
                        width: 100%;
                        height: 100vh;
                        background: linear-gradient(to right, #005C98, #505BDA);
                        position: relative;
                        overflow: hidden;
                    }

                    .header_nav{
                        width: 100%;
                        position: absolute;
                        top: 0;
                        left: 0;
                    }

                    .header_nav .contenedor{
                        display: flex;
                        justify-content: space-between;
                        align-items: center;
                        padding: 15px 0;
                    }

                    .header_nav h1{
                        color: #fff;
                        font-family: 'Gagalin';
                    }

                    .header_nav nav a{
                        color: #fff;
                        text-decoration: none;
                        margin-right: 10px;
                    }

                    .banner{
                        display: flex;
                        justify-content: space-between;
                        align-items: center;
                        height: 100%;
                    }

                    .banner_title h2{
                        color: #fff;
                        font-size: 60px;
                        font-weight: 800;
                        margin-bottom: 20px;
                    }

                    .banner_title .llamanos{
                        color: #fff;
                        font-size: 20px;
                        text-decoration: none;
                        display: inline-block;
                        background: #1A2849;
                        padding: 20px;
                    }

                    .banner_img{
                        animation: movimiento 2.5s linear infinite;
                    }

                    .banner_img img{
                        width: 600px;
                        display: block;
                    }

                    /* burbujas */

                    .burbuja{
                        border-radius: 50%;
                        background: #fff;
                        opacity: .3;

                        position: absolute;
                        bottom: -150px;

                        animation: burbujas 3s linear infinite ;
                    }

                    .burbuja:nth-child(1){
                        width: 80px;
                        height: 80px;
                        left: 5%;
                        animation-duration: 3s;
                        animation-delay: 3s;
                    }

                    .burbuja:nth-child(2){
                        width: 100px;
                        height: 100px;
                        left: 35%;
                        animation-duration: 3s;
                        animation-delay: 5s;
                    }

                    .burbuja:nth-child(3){
                        width: 20px;
                        height: 20px;
                        left: 15%;
                        animation-duration: 1.5s;
                        animation-delay: 7s;
                    }

                    .burbuja:nth-child(4){
                        width: 50px;
                        height: 50px;
                        left: 90%;
                        animation-duration: 6s;
                        animation-delay: 3s;
                    }

                    .burbuja:nth-child(5){
                        width: 70px;
                        height: 70px;
                        left: 65%;
                        animation-duration: 3s;
                        animation-delay: 1s;
                    }

                    .burbuja:nth-child(6){
                        width: 20px;
                        height: 20px;
                        left: 50%;
                        animation-duration: 4s;
                        animation-delay: 5s;
                    }

                    .burbuja:nth-child(7){
                        width: 20px;
                        height: 20px;
                        left: 50%;
                        animation-duration: 4s;
                        animation-delay: 5s;
                    }

                    .burbuja:nth-child(8){
                        width: 100px;
                        height: 100px;
                        left: 52%;
                        animation-duration: 5s;
                        animation-delay: 5s;
                    }

                    .burbuja:nth-child(9){
                        width: 65px;
                        height: 65px;
                        left: 51%;
                        animation-duration: 3s;
                        animation-delay: 2s;
                    }

                    .burbuja:nth-child(10){
                        width: 40px;
                        height: 40px;
                        left: 35%;
                        animation-duration: 3s;
                        animation-delay: 4s;
                    }


                    @keyframes burbujas{
                        0%{
                            bottom: 0;
                            opacity: 0;
                        }
                        30%{
                            transform: translateX(30px);
                        }
                        50%{
                            opacity: .4;
                        }
                        100%{
                            bottom: 100vh;
                            opacity: 0;
                        }
                    }

                    @keyframes movimiento{
                        0%{
                            transform: translateY(0);
                        }
                        50%{
                            transform: translateY(30px);
                        }
                        100%{
                            transform: translateY(0);
                        }
                    }
                </style>
            <div class="burbujas">
                <div class="burbuja"></div>
                <div class="burbuja"></div>
                <div class="burbuja"></div>
                <div class="burbuja"></div>
                <div class="burbuja"></div>
                <div class="burbuja"></div>
                <div class="burbuja"></div>
                <div class="burbuja"></div>
                <div class="burbuja"></div>
                <div class="burbuja"></div>
            </div>

                               
    </body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
    crossorigin="anonymous"></script>

</html>