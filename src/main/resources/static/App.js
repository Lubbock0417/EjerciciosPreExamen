document.addEventListener('DOMContentLoaded', function () {
    cargarClientes();
    cargarFacturas();
});

function cargarClientes() {
    // Realiza una solicitud GET a la API de clientes y muestra los resultados en el div "clientes"
    fetch('/api/clientes')
        .then(response => response.json())
        .then(data => {
            const clientesDiv = document.getElementById('clientes');
            clientesDiv.innerHTML = '<h2>Clientes</h2>';
            data.forEach(cliente => {
                clientesDiv.innerHTML += `<p>${cliente.nombre} - ${cliente.correoElectronico}</p>`;
            });
        })
        .catch(error => console.error('Error al cargar clientes:', error));
}

function cargarFacturas() {
    // Realiza una solicitud GET a la API de facturas y muestra los resultados en el div "facturas"
    fetch('/api/facturas')
        .then(response => response.json())
        .then(data => {
            const facturasDiv = document.getElementById('facturas');
            facturasDiv.innerHTML = '<h2>Facturas</h2>';
            data.forEach(factura => {
                facturasDiv.innerHTML += `<p>Número: ${factura.numeroFactura}, Fecha: ${factura.fechaEmision}</p>`;
            });
        })
        .catch(error => console.error('Error al cargar facturas:', error));
}

// Validar el nombre del cliente
function validarNombre(nombre) {
    if (nombre.length < 3) {
        return false;
    }
    return true;
}

// Validar el correo electrónico del cliente
function validarCorreoElectronico(correoElectronico) {
    if (!correoElectronico.match(/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/)) {
        return false;
    }
    return true;
}

// Procesar la solicitud de creación de un cliente
function crearCliente(nombre, correoElectronico) {
    // Validar los datos introducidos por el usuario
    if (!validarNombre(nombre)) {
        alert("El nombre debe tener al menos 3 caracteres");
        return;
    }
    if (!validarCorreoElectronico(correoElectronico)) {
        alert("El correo electrónico no es válido");
        return;
    }

    // Enviar la solicitud al servidor
    fetch('/api/clientes', {
        method: 'post',
        body: JSON.stringify({
            nombre: nombre,
            correoElectronico: correoElectronico
        })
    })
        .then(response => response.json())
        .then(data => {
            if (data.exito) {
                alert("Cliente creado correctamente");
            } else {
                alert("Error al crear el cliente: " + data.error);
            }
        })
        .catch(error => console.error('Error al crear el cliente:', error));
}