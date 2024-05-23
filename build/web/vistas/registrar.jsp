<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet" />
        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet" />
        <!-- MDB -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.2.0/mdb.min.css" rel="stylesheet" />
        <style>
            html, body {
                height: 100%;
                margin: 0;
                padding: 0;
            }

            body {
                display: flex;
                justify-content: center;
                align-items: center;
                background: hsl(218, 41%, 15%);
                background-image: radial-gradient(800px circle at 0% 0%,
                    hsl(218, 41%, 35%) 15%,
                    hsl(218, 41%, 30%) 35%,
                    hsl(218, 41%, 20%) 75%,
                    hsl(218, 41%, 19%) 80%,
                    transparent 100%),
                    radial-gradient(1250px circle at 100% 100%,
                    hsl(218, 41%, 45%) 15%,
                    hsl(218, 41%, 30%) 35%,
                    hsl(218, 41%, 20%) 75%,
                    hsl(218, 41%, 19%) 80%,
                    transparent 100%);
            }

            .background-radial-gradient {
                width: 100%;
                height: 100%;
            }

            #radius-shape-1 {
                height: 220px;
                width: 220px;
                top: -60px;
                left: -130px;
                background: radial-gradient(#44006b, #ad1fff);
                overflow: hidden;
            }

            #radius-shape-2 {
                border-radius: 38% 62% 63% 37% / 70% 33% 67% 30%;
                bottom: -60px;
                right: -110px;
                width: 300px;
                height: 300px;
                background: radial-gradient(#44006b, #ad1fff);
                overflow: hidden;
            }

            .bg-glass {
                background-color: hsla(0, 0%, 100%, 0.9) !important;
                backdrop-filter: saturate(200%) blur(25px);
            }

            h1 {
                text-align: center;
            }

            .btn-disabled {
                background-color: #cccccc;
                color: #666666;
                cursor: not-allowed;
            }
        </style>
    </head>

    <body>
        <!-- Section: Design Block -->
        <section class="background-radial-gradient">
            <div class="container px-4 py-5 px-md-5 text-center text-lg-start my-5">
                <div class="row gx-lg-5 align-items-center mb-5">
                    <div class="col-lg-6 mb-5 mb-lg-0" style="z-index: 10">
                        <h1 class="my-5 display-5 fw-bold ls-tight" style="color: hsl(218, 81%, 95%)">
                            El mejor sistema de ventas <br />
                            <span style="color: hsl(218, 81%, 75%)">para tu negocio</span>
                        </h1>
                    </div>

                    <div class="col-lg-6 mb-5 mb-lg-0 position-relative">
                        <div id="radius-shape-1" class="position-absolute rounded-circle shadow-5-strong"></div>
                        <div id="radius-shape-2" class="position-absolute shadow-5-strong"></div>

                        <div class="card bg-glass">
                            <div class="card-body px-4 py-5 px-md-5">
                                <form action="${pageContext.servletContext.contextPath}/ValidarRegistros" method="POST">
                                    <h1>Registrarse</h1><br>
                                    <div data-mdb-input-init class="form-outline mb-4">
                                        <input type="text" class="form-control" name="txtid">
                                        <label class="form-label" for="form3Example3">Id</label>
                                    </div>
                                    <div data-mdb-input-init class="form-outline mb-4">
                                        <input type="text" class="form-control" name="txtnombre">
                                        <label class="form-label" for="form3Example3">Nombre</label>
                                    </div>
                                    
                                    <!-- Correo  -->
                                    <div data-mdb-input-init class="form-outline mb-4">
                                        <input type="email" class="form-control" name="txtuser">
                                        <label class="form-label" for="form3Example3">Correo electronico</label>
                                    </div>

                                    <!-- Contrasea  -->
                                    <div data-mdb-input-init class="form-outline mb-4">
                                        <input type="password" class="form-control" name="txtpass">
                                        <label class="form-label" for="form3Example4">Contraseña</label>
                                    </div>
                                    
                                    <div data-mdb-input-init class="form-outline mb-4">
                                        <input type="text" class="form-control" name="txtrol">
                                        <label class="form-label" for="form3Example3">rol</label>
                                    </div>
                                    
                                    <!-- Checkbox  terminos y condiciones -->
                                    <div class="form-check d-flex mb-4">
                                        <input class="form-check-input me-2" type="checkbox" value="" id="termsCheckbox" />
                                        <p>Acepto terminos y condiciones</p>
                                    </div>

                                    <!-- Boton -->
                                    <button type="submit" class="btn btn-primary btn-block mb-4 btn-disabled"  name="btnGuardar" value ="Ingresar" id="submitButton" disabled>
                                        Registrase
                                    </button>
                                   
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.2.0/mdb.umd.min.js"></script>
        <script>
            document.getElementById('termsCheckbox').addEventListener('change', function () {
                const submitButton = document.getElementById('submitButton');
                if (this.checked) {
                    submitButton.disabled = false;
                    submitButton.classList.remove('btn-disabled');
                } else {
                    submitButton.disabled = true;
                    submitButton.classList.add('btn-disabled');
                }
            });
        </script>
    </body>

</html>
