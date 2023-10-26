<%-- 
    Document   : listas
    Created on : 22 oct 2023, 19:29:25
    Author     : omar salazar
--%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="/templates/header.jsp" %>
<html>
    <head>
        
        <link rel="stylesheet"  href="static/css/style.css"><link>
        <title>Principal</title>
    </head>
    <body>

            <%
                String relativePath = getServletContext().getRealPath("/data");
               String archivoGuardar = "usuarios.txt";
               
               File data = new File(relativePath);
               File archivo = new File(data + "/" + archivoGuardar);   
               data.mkdir();
               archivo.createNewFile();
            %>
        
        <section class="h-100 gradient-form" style="background-color: #fccb90;">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-xl-10">
                <div class="card rounded-3 text-black">
                    <div class="row g-0">
                        <div class="col-lg-6">
                            <div class="card-body p-md-5 mx-md-4">

                                <div class="text-center">
                                    <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/lotus.webp"
                                         style="width: 185px;" alt="logo">
                                    <h4 class="mt-1 mb-5 pb-1">Universidad 420, mas que sueños</h4>
                                </div>

                                <form action="SvVerificar" method="POST">
                                    <p>Por favor ingresa tu cuenta </p>

                                    <div class="form-outline mb-4">
                                        <input type="text" name="email" id="form2Example11" class="form-control"
                                               placeholder="Usuario" required />
                                        <label class="form-label" for="form2Example11">Usuario</label>
                                    </div>

                                    <div class="form-outline mb-4">
                                        <input type="password" name="contra" id="form2Example22" class="form-control" placeholder="contraseña" required />
                                        <label class="form-label" for="form2Example11">Contraseña</label>
                                    </div>

                                    <div class="text-center pt-1 mb-5 pb-1">
                                        <button class="btn btn-primary btn-block fa-lg gradient-custom-2 mb-3" type="submit">Acceder</button>
                                        
                                    </div>

                                    <div class="d-flex align-items-center justify-content-center pb-4">
                                        <a class="text-muted">¿olvidaste tu contrseña?</a>
                                        <p style="color:white;">O</p>
                                        <button id="openRegistrationModalBtn" class="btn btn-primary btn-block fa-lg gradient-custom-2 mb-3" type="button">Crea una cuenta</button>
                                    </div>
                                    

                                </form>

                            </div>
                        </div>
                        <div class="col-lg-6 d-flex align-items-center gradient-custom-2">
                            <div class="text-white px-3 py-4 p-md-5 mx-md-4">
                                <h4 class="mb-4">¡HOLA ESTUDIANTE!</h4>
                                <p class="small mb-0">¡Bienvenidos a nuestra plataforma de gestión de tareas para estudiantes de la Universidad 420! Aquí, hemos creado un espacio digital especialmente diseñado para simplificar tu vida académica. Desde agregar y organizar tus tareas hasta editar y eliminarlas, estamos aquí para ayudarte a mantener un registro eficiente de tus responsabilidades académicas. ¡Comencemos a optimizar tu gestión de tareas y a impulsar tu éxito académico juntos!
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
     </div>
     </section>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
        <script src="static/script/verificar.js"></script>
    </body>
    <section class="background-radial-gradient overflow-hidden">
  <style>
  /* Estilo del botón de "Registrarse" */
  #openRegistrationModalBtn {
    background-color: hsl(218, 81%, 75%);
    color: white;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-family: 'Segoe UI', sans-serif;
    font-size: 16px;
  }

  /* Estilo del modal */
  #registrationModal {
    display: none;
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.7);
    z-index: 1000;
    text-align: center;
  }


  .modal-content {
    background-color: hsl(218, 41%, 15%);
    margin: 10% auto;
    padding: 20px;
    border-radius: 10px;
    width: 70%;
    max-width: 400px;
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.5);
  }

  .modal-content h2 {
    color: hsl(218, 81%, 75%);
  }

  /* Estilo del botón "Cerrar" en el modal */
  .close {
     position: absolute;
    top: 10px;
    right: 10px;
    font-size: 24px;
    color: hsl(218, 41%, 35%);
    cursor: pointer;
  }
</style>


  <div class="container px-4 py-5 px-md-5 text-center text-lg-start my-5">
    <!-- ... Contenido existente ... -->

    <!-- Modal de Registro -->
    <div id="registrationModal" class="modal">
      <div class="modal-content" style="background-color: hsl(40, 0%, 100%); color: hsl(40, 100%, 50%);">
        <span class="close" id="closeModalBtn" style="color: hsl(218, 41%, 35);">&times;</span>
        <h2 style="color: hsl(40, 0%, 0%);">Registro</h2>
        <form id="registrationForm" action="SvRegistrar" method="post">
          <label for="nombre"  class="form-label" style="color:black;">Nombre:</label>
          <input type="text" class="form-control"  name="usuario" aria-describedby="basic-addon1" required><br>
          <div id="nombre" class="form-text" ></div>
          
          <label for="usuario" class="form-label"style="color:black;">Cedula:</label>
          <input type="text" class="form-control" name="cedula" required><br>
          <div id="usuario" class="campo-input"></div>

          <label for="contrasenia" class="form-label" style="color:black;">Contraseña:</label>
          <input type="password" class="form-control" name="contrasenia" required><br>
      
          <input type="submit" value="Registrar"style="background-color: hsl(337, 92%, 31%); color: hsl(338, 0%, 100%)">
        </form>
      </div>
    </div>
    <!-- Fin del Modal de Registro -->
  </div>
</section>

<script>
  document.addEventListener('DOMContentLoaded', function () {
    // Obtén referencias a los elementos HTML
    const openRegistrationModalBtn = document.getElementById('openRegistrationModalBtn');
    const registrationModal = document.getElementById('registrationModal');

    // Abre el modal de registro cuando se hace clic en el botón "Registrarse"
    openRegistrationModalBtn.addEventListener('click', () => {
      registrationModal.style.display = 'block';
    });
  });
</script>
<script>
  // Obtén referencias a los elementos HTML
  const closeModalBtn = document.getElementById('closeModalBtn');
  const registrationModal = document.getElementById('registrationModal');

  // Cierra el modal cuando se hace clic en la "x"
  closeModalBtn.addEventListener('click', () => {
    registrationModal.style.display = 'none';
  });

  // Abre el modal de registro cuando sea necesario (puedes agregar un botón)
  // Por ejemplo, aquí se agrega un botón "Registro" para abrir el modal:
  const openModalBtn = document.createElement('button');
  openModalBtn.textContent = 'Registro';
  openModalBtn.addEventListener('click', () => {
    registrationModal.style.display = 'block';
  });

  // Agrega el botón "Registro" donde desees en tu página
  const registrationButtonContainer = document.getElementById('registrationButtonContainer');
  registrationButtonContainer.appendChild(openModalBtn);
</script>
    <%@include file="/templates/footer.jsp" %>
</html>