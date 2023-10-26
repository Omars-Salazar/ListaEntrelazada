// Obtiene los elementos HTML por su ID
const container = document.getElementById('container'); // El div que contiene las pantallas de registro y login.
const registerBtn = document.getElementById('register'); // El botón para mostrar la pantalla de registro.
const loginBtn = document.getElementById('login'); // El botón para mostrar la pantalla de inicio de sesión.

// Agrega un event listener al botón de registro
registerBtn.addEventListener('click', () => {
  // Cuando se hace clic en el botón de registro, agrega la clase "active" al contenedor.
  container.classList.add("active");
});

// Agrega un event listener al botón de inicio de sesión
loginBtn.addEventListener('click', () => {
  // Cuando se hace clic en el botón de inicio de sesión, elimina la clase "active" del contenedor.
  container.classList.remove("active");
});


