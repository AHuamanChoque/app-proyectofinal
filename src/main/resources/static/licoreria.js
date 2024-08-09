// licoreria.js
document.getElementById('btn-inicio').addEventListener('click', function() {
    document.getElementById('inicio').scrollIntoView({ behavior: 'smooth' });
});

document.getElementById('btn-ofertas').addEventListener('click', function() {
    document.getElementById('ofertas').scrollIntoView({ behavior: 'smooth' });
});

document.getElementById('btn-todos').addEventListener('click', function() {
    document.getElementById('todos').scrollIntoView({ behavior: 'smooth' });
});

document.getElementById('btn-rones').addEventListener('click', function() {
    document.getElementById('rones').scrollIntoView({ behavior: 'smooth' });
});

document.getElementById('btn-espumantes').addEventListener('click', function() {
    document.getElementById('espumantes').scrollIntoView({ behavior: 'smooth' });
});

document.getElementById('btn-whiskies').addEventListener('click', function() {
    document.getElementById('whiskies').scrollIntoView({ behavior: 'smooth' });
});

document.getElementById('btn-vodkas').addEventListener('click', function() {
    document.getElementById('vodkas').scrollIntoView({ behavior: 'smooth' });
});

document.getElementById('btn-vinos').addEventListener('click', function() {
    document.getElementById('vinos').scrollIntoView({ behavior: 'smooth' });
});

document.getElementById('btn-piscos').addEventListener('click', function() {
    document.getElementById('piscos').scrollIntoView({ behavior: 'smooth' });
});

document.getElementById('btn-tequilas').addEventListener('click', function() {
    document.getElementById('tequilas').scrollIntoView({ behavior: 'smooth' });
});

document.addEventListener('DOMContentLoaded', function() {
    const cartButtons = document.querySelectorAll('.add-to-cart'); // Todos los botones "Agregar al Carrito"
    const cartModal = new bootstrap.Modal(document.getElementById('cartModal')); // Modal del carrito
    const cartList = document.getElementById('cart-list'); // Lista de productos en el carrito
    const cartTotal = document.getElementById('cart-total'); // Total del carrito
    const cartBtn = document.getElementById('cart-btn'); // Botón fijo del carrito

    // Evento para abrir el modal del carrito al hacer clic en cualquier botón "Agregar al Carrito"
    cartButtons.forEach(button => {
        button.addEventListener('click', function() {
            const productInfo = this.parentElement; // Div padre que contiene la información del producto

            // Crear un nuevo elemento de lista para el producto seleccionado
            const listItem = document.createElement('li');
            listItem.classList.add('list-group-item');
            listItem.innerHTML = `
                ${productInfo.querySelector('p').textContent} 
                <button class="btn btn-danger btn-remove">Eliminar</button>
            `; // Descripción del producto con botón de eliminar

            // Añadir el elemento de lista al carrito
            cartList.appendChild(listItem);

            // Mostrar el modal del carrito
            updateCartTotal();
            cartModal.show();
        });
    });

    // Evento para enviar el formulario de registro
    const registerForm = document.getElementById('register-form');
    registerForm.addEventListener('submit', function(event) {
        event.preventDefault(); // Evitar el envío del formulario por defecto

        // Aquí puedes agregar la lógica para enviar los datos del formulario de registro
        // Por ejemplo, puedes usar fetch() para enviar los datos a un servidor
        // y recibir una respuesta para mostrar algún mensaje de confirmación al usuario

        // Resetear el formulario después de enviar los datos
        this.reset();

        // Cerrar el modal de registro después de enviar exitosamente
        const registerModal = new bootstrap.Modal(document.getElementById('registerModal'));
        registerModal.hide();
    });

    // Evento para enviar el formulario de inicio de sesión
    const loginForm = document.getElementById('login-form');
    loginForm.addEventListener('submit', function(event) {
        event.preventDefault(); // Evitar el envío del formulario por defecto

        // Aquí puedes agregar la lógica para enviar los datos del formulario de inicio de sesión
        // Por ejemplo, puedes usar fetch() para enviar los datos a un servidor
        // y recibir una respuesta para autenticar al usuario y redirigirlo si es necesario

        // Resetear el formulario después de enviar los datos
        this.reset();

        // Cerrar el modal de inicio de sesión después de enviar exitosamente
        const loginModal = new bootstrap.Modal(document.getElementById('loginModal'));
        loginModal.hide();
    });

    // Evento para abrir el modal del carrito al hacer clic en el botón fijo del carrito
    cartBtn.addEventListener('click', function() {
        updateCartTotal();
        cartModal.show();
    });

    // Función para actualizar el total del carrito
    function updateCartTotal() {
        // Calcular el total sumando el valor de todos los productos en el carrito
        let total = 0;
        cartList.querySelectorAll('li').forEach(item => {
            // Aquí puedes agregar la lógica para obtener el precio de cada producto y sumarlo al total
            // Ejemplo: total += parseFloat(item.dataset.price);
        });

        // Actualizar el texto del total en el modal del carrito
        cartTotal.textContent = `$${total.toFixed(2)}`;
    }

    // Función para eliminar un producto del carrito
    cartList.addEventListener('click', function(event) {
        if (event.target.classList.contains('btn-remove')) {
            event.target.parentElement.remove(); // Eliminar el elemento de la lista del carrito
            updateCartTotal(); // Actualizar el total del carrito después de eliminar un producto
        }
    });

    // Eventos para abrir los modales de registro e inicio de sesión
    document.getElementById('register-btn').addEventListener('click', function() {
        const registerModal = new bootstrap.Modal(document.getElementById('registerModal'));
        registerModal.show();
    });

    document.getElementById('login-btn').addEventListener('click', function() {
        const loginModal = new bootstrap.Modal(document.getElementById('loginModal'));
        loginModal.show();
    });

    const searchBtn = document.getElementById('search-btn');
    const searchInput = document.getElementById('search-input');
    const productsContainer = document.querySelector('.products-container');

    searchBtn.addEventListener('click', function() {
        const searchTerm = searchInput.value.toLowerCase().trim();

        // Mostrar todos los productos inicialmente
        const allProducts = Array.from(productsContainer.querySelectorAll('.product'));
        allProducts.forEach(product => product.style.display = 'block');

        // Filtrar productos por término de búsqueda
        if (searchTerm !== '') {
            let found = false;
            allProducts.forEach(product => {
                const productDescription = product.querySelector('p').textContent.toLowerCase();
                if (productDescription.includes(searchTerm)) {
                    product.style.display = 'block';
                    found = true;
                } else {
                    product.style.display = 'none';
                }
            });

            // Mostrar mensaje si no se encontraron productos
            if (!found) {
                const noResultsMessage = document.createElement('div');
                noResultsMessage.classList.add('no-results');
                noResultsMessage.textContent = 'Producto no encontrado';
                productsContainer.appendChild(noResultsMessage);
            } else {
                // Eliminar el mensaje de "Producto no encontrado" si existe
                const noResultsMessage = productsContainer.querySelector('.no-results');
                if (noResultsMessage) {
                    noResultsMessage.remove();
                }
            }
        } else {
            // Mostrar todos los productos si el campo de búsqueda está vacío
            allProducts.forEach(product => product.style.display = 'block');
        }
    });
});
