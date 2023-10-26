$('#exampleModal').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget); // Botón que desencadenó el evento
                var nombre = button.data('nombre'); // Obtén el nombre del perro

                // Realiza una solicitud AJAX al servlet para obtener los detalles del perro por su nombre
                $.ajax({
                    url: 'SvControl?nombre=' + nombre, // Cambia 'id' por el nombre del parámetro que esperas en tu servlet
                    method: 'GET',
                    success: function (data) {
                        // Actualiza el contenido del modal con los detalles del perro
                        $('#perro-details').html(data);
                    },
                    error: function () {
                        // Maneja errores aquí si es necesario
                        console.log('Error al cargar los detalles del perro.');
                    }
                });
            });



