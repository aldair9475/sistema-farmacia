<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="models.Medicamento"%>
<%@ page import="models.Marca"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
<script src="https://unpkg.com/@tailwindcss/browser@4"></script>
<title>SISTEMA FARMACIA</title>
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
				<div class="absolute right-1 top-1/2 transform -translate-y-1/2 w-9 h-9 rounded-md bg-green-600 flex items-center justify-center cursor-pointer">				
						<i class="fas fa-search text-white"></i>
				</div>
			</div>
			
			<div class="flex items-center gap-6">
				<a href="/app-prueba"
					class="text-gray-700 text-sm flex items-center gap-1 hover:text-green-600">
					<i class="fas fa-home"></i> Inicio
				</a> 
				<a href="# "
					class="text-gray-700 text-sm flex items-center gap-1 hover:text-green-600">
					<i class="fas fa-address-book"></i> Contacto
				</a>
				 <a href="#"
					class="text-gray-700 text-sm flex items-center gap-1 hover:text-green-600">
					<i class="fas fa-user"></i> Iniciar sesión
				</a> 
				<a href="#"
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
	
	
	<main class="bg-gray-200">
		<div>
			<img class="w-full h-100"
				src="https://imgs.search.brave.com/z2zSCx1qQVC0aHBjse7PfEYhElWC50rnCwHUT_njuTU/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9tZWRp/YS5pc3RvY2twaG90/by5jb20vaWQvODc4/ODUyNzE4L2VzL2Zv/dG8vZmFybWFjJUMz/JUE5dXRpY28tY29u/LWNhamEtZGUtbGEt/bWVkaWNpbmEteS1w/YXF1ZXRlLWRlLWMl/QzMlQTFwc3VsYS5q/cGc_cz02MTJ4NjEy/Jnc9MCZrPTIwJmM9/cE5MVmd6T2pKcDY3/bU5DMlEzazVVMDBa/aFdvNHdXbjhnVUN6/c1JOTGtaMD0"
				alt="Fármaco">
		</div>

		<%
		List<Marca> marcas = (List<Marca>) request.getAttribute("marcas");
		if (marcas != null && !marcas.isEmpty()) {
		%>
		<div class="flex flex-row flex-wrap justify-center p-4 gap-4">
			<%
			for (Marca marca : marcas) {
			%>
			<div class="flex flex-col items-center">
				<a href="panadol-medicamentos?idMarca=<%= marca.getIdMarca() %>">
				 <img class="p-4 w-32 h-26 rounded-full" alt="" src="<%=marca.getImagenUrl()%>">				
				</a>
				<h4 class="text-center font-semibold text-gray-700"><%=marca.getNombre()%></h4>
			</div>

			<%
			}
			%>
		</div>
		<%
		} else {
		%>
		<p>No se encontraron registros</p>
		<%
		}
		%>

		<div class="flex flex-row gap-4 mt-4">

			<aside class="w-1/4 bg-white p-4 rounded-md shadow-md">
				<h2 class="text-xl font-bold mb-4">Filtros</h2>
				
				<div class="space-y-4">					
					<div>
						<label class="block text-gray-700 font-medium mb-1">Categoría
						</label>
						<div class="flex flex-col space-y-2">
							<div class="flex items-center">
								<input type="checkbox" id="" name="categoria" value=""  class="mr-2 cursor-pointer filter-checkbox">							
						       <label for="" class="text-gray-700 cursor-pointer">									
								</label>
							</div>						
							<p class="text-gray-500">No se encontraron registros</p>						
						</div>
					</div>
					
					<div>
						<label class="block text-gray-700 font-medium mb-1">Presentacion
						</label>
						<div class="flex flex-col space-y-2">
							<div class="flex items-center">
								<input type="checkbox" id="" name="categoria" value="" class="mr-2">
								  <label for="" class="text-gray-700">Opcion</label>
							</div>						
							<p class="text-gray-500">No se encontraron registros</p>						
						</div>
					</div>
				</div>
			</aside>


		
			<section class="w-3/4">
				<div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
					<%
					List<Medicamento> medicamentos = (List<Medicamento>) request.getAttribute("medicamentos");
					if (medicamentos != null && !medicamentos.isEmpty()) {
						for (Medicamento medicamento : medicamentos) {							
					%>
					<div
						class="bg-white p-4 rounded-md border border-gray-300 hover:border-green-600 cursor-pointer flex flex-col items-center">
						<img class="rounded-sm mb-2"
							src="<%=medicamento.getImagenUrl()%>"
							alt="<%=medicamento.getNombre()%>" width="150">
							 <span class="text-sm text-gray-500"><%=medicamento.getIdPresentacion()%></span>						
						<p class="text-center font-bold text-gray-600"><%=medicamento.getNombre()%></p>
						<span class="text-lg font-semibold">S/ <%=String.format("%.2f", medicamento.getPrecioUnitario()).replace(',', '.')%></span>
						<button
							class="w-full h-12 bg-green-700 text-white font-semibold rounded-full shadow-md hover:bg-green-600 transition duration-300 mt-2 cursor-pointer">
							Agregar al carrito
						</button>
					</div>
					<%
					}
					} else {
					%>
					<p>No se encontraron registros</p>
					<%
					}
					%>
				</div>
				<div class="mt-4">
					Total registros:
					<%=(medicamentos != null ? medicamentos.size() : 0)%>
				</div>
				</section>
		</div>
	</main>


</body>
</html>