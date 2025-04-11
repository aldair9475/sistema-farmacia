<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="models.Producto"%>
<%@ page import="models.Categoria"%>
<%@ page import="models.Presentacion"%>
<%@ page import= "shared.Constants" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
<script src="https://unpkg.com/@tailwindcss/browser@4"></script>
<title>PRODUCTO CATEGORIA</title>
</head>
<body>

	<header class="bg-white p-4 shadow-lg fixed top-0 right-0 left-0 ">
		<nav class="flex items-center justify-between max-w-screen-xl mx-auto">
			
			<div class="flex items-center gap-2">
				<i class="fas fa-clinic-medical text-3xl text-green-600"></i>
				 <span class="font-bold text-2xl text-green-600">Farmacia</span>
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
				<a href="/sistema-farmacia" class="text-gray-700 text-sm flex items-center gap-1 hover:text-green-600">
					<i class="fas fa-home"></i> Inicio
				</a> 
				<a href="# " class="text-gray-700 text-sm flex items-center gap-1 hover:text-green-600">
					<i class="fas fa-address-book"></i> Contacto
				</a> 
				<a href="#" class="text-gray-700 text-sm flex items-center gap-1 hover:text-green-600">
					<i class="fas fa-user"></i> Iniciar sesión
				</a> 
				<a href="#"	class="text-gray-700 text-sm flex items-center gap-1 hover:text-green-600">
					<i class="fas fa-user-circle"></i> Registro
				</a>
				<a href="#" class="text-blue-500 bg-cyan-100 hover:bg-sky-400 p-2 rounded-lg transition">
					<i class="fas fa-shopping-cart text-lg"></i>
				</a>
			</div>
		</nav>

		<nav class="flex items-center mt-8 justify-between max-w-screen-xl mx-auto">
			<div class="flex items-center gap-6">
				<label class="text-1xl"><i class="fas fa-list text-green-700"></i>
					Categorias
				</label>
				<%
			    List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");		    
			    if (categorias != null && !categorias.isEmpty()) { 
			    	for(Categoria categoria : categorias){		    
			    %>
				<a href="/sistema-farmacia/productos?idCategoria=<%= categoria.getIdCategoria() %>" class="text-green-600 font-bold text-sm flex items-center gap-1 hover:text-green-600">
					<i class="fas fa-tag text-sky-600"></i> <%= categoria.getNombre() %>
				</a>
				<% 	} 
				   } else { 
				 %>
				<p class="text-center text-gray-600">No se encontraron registros</p>
				<% } %>
			</div>
		</nav>
	</header>

	<main class="bg-gray-200 w-full">
    	<div>
        	<img class="w-full h-100 object-cover"
            src="https://imgs.search.brave.com/zRylaM4vesdeYxLZ7SigDODutth7KqHMunjgj9HY0c0/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly9tZWRp/YS5pc3RvY2twaG90/by5jb20vaWQvODc4/ODUyNzE4L2VzL2Zv/dG8vZmFybWFjJUMz/JUE5dXRpY28tY29u/LWNhamEtZGUtbGEt/bWVkaWNpbmEteS1w/YXF1ZXRlLWRlLWMl/QzMlQTFwc3VsYS5q/cGc_cz02MTJ4NjEy/Jnc9MCZrPTIwJmM9/cE5MVmd6T2pKcDY3/bU5DMlEzazVVMDBa/aFdvNHdXbjhnVUN6/c1JOTGtaMD0"
            alt="Farmacia">
    	</div>
  
  		<%
  		String nombreCategoria = (String) request.getAttribute("nombreCategoria");
  		%>
    	<div class="flex justify-center mt-6">
          <label class="text-2xl font-bold text-gray-800">Categoria <%= nombreCategoria %></label>
    	</div>

    	<div class="flex flex-row gap-4 mt-4 w-full">    
         <section class="w-full px-4">
            <div class="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-5 gap-4">
                <% 
                List<Presentacion> presentaciones = (List<Presentacion>) request.getAttribute("presentaciones");
                List<Producto> productos = (List<Producto>) request.getAttribute("productos");
                
                if (productos != null && !productos.isEmpty()) { 
                    for (Producto producto : productos) {
                        for (Presentacion presentacion : presentaciones) {
                            if (producto.getIdPresentacion() == presentacion.getIdPresentacion()) {
                %>
                <div class="bg-white p-4 rounded-lg border border-gray-300 hover:shadow-lg transition flex flex-col items-center mx-auto">
				  <a href="/sistema-farmacia/productos?idProducto=<%=producto.getIdProducto()%>" class="text-center">
					<img class="w-full object-cover rounded-md" src="<%=producto.getImagenUrl() != null ? producto.getImagenUrl() : Constants.IMAGEN_PRODUCTO_DEFAULT%>" alt="<%=producto.getNombre()%>" width="120"> 
					<span class="text-sm font-bold text-gray-500"><%=presentacion.getNombre()%></span>
					<h3 class="text-lg font-semibold"><%=producto.getNombre()%></h3>
					<p class="font-bold">S/ <%=String.format("%.2f", producto.getPrecioUnitario()).replace(',', '.')%></p>
				  </a>
				  <button class="w-full h-10 bg-green-700 text-white font-semibold rounded-md hover:bg-green-600 transition mt-2 cursor-pointer">
					Agregar al carrito
				  </button>
				</div>
                <% 
                            }
                        }
                    }
                } else { 
                %>
                <p class="text-center col-span-5 text-gray-600">No se encontraron registros</p>
                <% } %>
            </div>

             <div class="mt-4 text-center font-semibold text-gray-700">
                Total registros: <%= (productos != null ? productos.size() : 0) %>
             </div>
        	</section>
    	</div>
	</main>
	
</body>
</html>