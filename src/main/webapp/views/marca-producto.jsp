<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List"%>
<%@ page import="models.Producto"%>
<%@ page import="models.Presentacion"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
<script src="https://unpkg.com/@tailwindcss/browser@4"></script>
<title>Marcas producto</title>
</head>
<body>

<header class="bg-white p-4 shadow-lg fixed top-0 right-0 left-0 ">
		<nav class="flex items-center justify-between max-w-screen-xl mx-auto">
			
			<div class="flex items-center gap-2">
				<i class="fas fa-clinic-medical text-3xl text-green-600"></i> <span
					class="font-bold text-2xl text-green-600">Farmacia</span>
			</div>

			<div class="relative flex items-center">
				<input type="text"
					class="bg-slate-200 rounded-md p-2 pl-10 text-sm w-70 md:w-96 focus:ring-2 focus:ring-green-500 outline-none"
					placeholder="Buscar una marca o producto">
				<div
					class="absolute right-1 top-1/2 transform -translate-y-1/2 w-9 h-9 rounded-md bg-green-600 flex items-center justify-center cursor-pointer">
					<i class="fas fa-search text-white"></i>
				</div>
			</div>

			<div class="flex items-center gap-6">
				<a href="/sistema-farmacia"
					class="text-gray-700 text-sm flex items-center gap-1 hover:text-green-600">
					<i class="fas fa-home"></i> Inicio
				</a> <a href="# "
					class="text-gray-700 text-sm flex items-center gap-1 hover:text-green-600">
					<i class="fas fa-address-book"></i> Contacto
				</a> <a href="#"
					class="text-gray-700 text-sm flex items-center gap-1 hover:text-green-600">
					<i class="fas fa-user"></i> Iniciar sesión
				</a> <a href="#"
					class="text-gray-700 text-sm flex items-center gap-1 hover:text-green-600">
					<i class="fas fa-user-circle"></i> Registro
				</a>
				
				<a href="#"
					class="text-blue-500 bg-cyan-100 hover:bg-sky-400 p-2 rounded-lg transition">
					<i class="fas fa-shopping-cart text-lg"></i>
				</a>
			</div>
		</nav>
	</header>

	<main class="flex flex-col bg-gray-100 mt-24 p-6">
    
    <h2 class="text-2xl font-bold text-gray-800 mb-6">Productos</h2>
    
    <section class="w-full">
        <div class="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-6">
            <%
            List<Presentacion> presentaciones = (List<Presentacion>) request.getAttribute("presentaciones");
            List<Producto> productos = (List<Producto>) request.getAttribute("productos");
            
            if (productos != null && !productos.isEmpty()) {
                for (Producto producto : productos) {
                	for(Presentacion presentacion : presentaciones){
						if(producto.getIdPresentacion() == presentacion.getIdPresentacion()){
            %>
            <div class="bg-white p-4 rounded-xl shadow-lg border border-gray-200 hover:shadow-2xl transition duration-300 cursor-pointer flex flex-col items-center">
                <img class="rounded-md mb-3 w-40 h-40 object-cover" src="<%=producto.getImagenUrl()%>"
                    alt="<%=producto.getNombre()%>">
                <span class="text-sm text-gray-500"><%=presentacion.getNombre()%></span>
                <p class="text-lg font-semibold text-gray-700 text-center mt-2"><%=producto.getNombre()%></p>
                <span class="text-lg font-bold">S/ <%=String.format("%.2f", producto.getPrecioUnitario()).replace(',', '.')%></span>
                <button class="w-full h-12 bg-green-700 text-white font-semibold rounded-full shadow-md hover:bg-green-600 focus:ring-2 focus:ring-green-300 transition duration-300 mt-3 cursor-pointer">
                    Agregar al carrito
                </button>
            </div>
            <%
						}
                	}
                }
            } else {
            %>
            <p class="text-center text-gray-600 col-span-full">No se encontraron registros</p>
            <%
            }
            %>
        </div>

        <div class="mt-6 text-gray-700 text-lg font-semibold">
            Total registros: <%= (productos != null ? productos.size() : 0) %>
        </div>
    </section>

</main>

</body>
</html>