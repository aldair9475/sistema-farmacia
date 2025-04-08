<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="models.Producto"%>
<%@ page import="models.Marca"%>
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
<title>Detalle Producto</title>
</head>
<body>
	<header class="bg-white p-4 shadow-lg fixed top-0 right-0 left-0">
       <nav class="flex items-center justify-between max-w-screen-xl mx-auto">
   
          <div class="flex items-center gap-2">
            <i class="fas fa-clinic-medical text-3xl text-green-600"></i>
            <span class="font-bold text-2xl text-green-600">Farmacia</span>
          </div>

         <div class="relative flex items-center">
            <input type="text" class="bg-slate-200 rounded-md p-2 pl-10 text-sm w-70 md:w-96 focus:ring-2 focus:ring-green-500 outline-none"
                   placeholder="Buscar una marca o producto">
            <div class="absolute right-1 top-1/2 transform -translate-y-1/2 w-9 h-9 rounded-md bg-green-600 flex items-center justify-center cursor-pointer">
             <i class="fas fa-search text-white"></i>
            </div>
        </div>

        <div class="flex items-center gap-6">
            <a href="/sistema-farmacia" class="text-gray-700 text-sm flex items-center gap-1 hover:text-green-600">
                <i class="fas fa-home"></i> Inicio
            </a>
            <a href="#" class="text-gray-700 text-sm flex items-center gap-1 hover:text-green-600">
                <i class="fas fa-address-book"></i> Contacto
            </a>
            <a  href="#" class="text-gray-700 text-sm flex items-center gap-1 hover:text-green-600">
              <i class="fas fa-user"></i> Iniciar sesión
            </a>
            <a  href="#" class="text-gray-700 text-sm flex items-center gap-1 hover:text-green-600">
              <i class="fas fa-user-circle"></i> Registro
            </a> 
            <a href="#" class="text-blue-500 bg-cyan-100 hover:bg-sky-400 p-2 rounded-lg transition">
                <i class="fas fa-shopping-cart text-lg"></i>
            </a> 
        </div>
    </nav>
  </header>
    
    <%
	  List<Producto> productos = (List<Producto>) request.getAttribute("productos");	
	  if (productos != null && !productos.isEmpty()) {
		for (Producto producto : productos) {					
	 %>
   <div class="bg-gray-200 h-screen p-2">
	<div class="max-w-4xl mx-auto bg-white p-6 rounded-lg shadow-md mt-20">
		<h1 class="text-2xl font-bold text-center mb-6"><%=producto.getNombre()%></h1>
		<div class="flex flex-col md:flex-row">
			<div class="md:w-1/2">
				<%
				List<String> imagenes = (List<String>) request.getAttribute("imagenes");
				if (imagenes != null && !imagenes.isEmpty()) {
				%>
				<img id="productoImagen" src="<%= producto.getImagenUrl() != null ? producto.getImagenUrl() : Constants.IMAGEN_PRODUCTO_DEFAULT%>" alt="Producto"class="rounded-lg w-50 h-50">					
				<ul class="flex justify-center mt-5 space-x-2">
					<%
						int index = 1;
						for (String imagen : imagenes) {
					%>
					<li class="bg-gray-300 hover:bg-green-600 px-2 py-1 rounded-full cursor-pointer">					
						<a href="#" onclick="cambiarImagen('<%=imagen%>')"><%=index++%></a>
					</li>
					<%
						}
					}
					%>
				</ul>
			</div>

			<div class="md:w-1/2 md:pl-6">
				<div class="mb-4">
				<%
				List<Presentacion> presentaciones = (List<Presentacion>) request.getAttribute("presentaciones");
				if(presentaciones != null && !presentaciones.isEmpty()){
					for(Presentacion presentacion : presentaciones){
						if(producto.getIdPresentacion() == presentacion.getIdPresentacion()){
				%>
					<p class="text-lg"><strong>Presentacion : </strong><%= presentacion.getNombre()%></p>
					<%
						}
					   }
					}
					%>					
            	<p class="text-lg flex items-center">
            	<%
            	List<Marca> marcas = (List<Marca>) request.getAttribute("marcas");
            	if(marcas != null && !marcas.isEmpty()){
            		for(Marca marca : marcas){     
            			if(producto.getIdMarca() == marca.getIdMarca()){
            	%>
            		<strong>Marca:</strong>
            		<span class="flex items-center gap-2 ml-2">
                	<%= marca.getNombre()%>
                	<img src="<%= (marca.getImagenUrl() != null) ? marca.getImagenUrl() : Constants.IMAGEN_PRODUCTO_DEFAULT%>"  alt="Logo de la marca" class="w-10 h-10">
            		</span>
            		<%		} 
            			}
            		}
            		%>
        		</p>
					<p class="text-lg"><strong>Codigo : </strong><%=producto.getCodigo()%></p>						
					<p class="text-lg"><strong>Registro Sanitario : </strong><%=producto.getRegistroSanitario() %></p>																					
					<p class="text-lg"><strong>Estado : </strong><%=(producto.getEstado().equals("D") ? "DISPONIBLE" : "AGOTADO") %></p>
					<p class="text-lg"><strong>Precio : </strong> S/<%=String.format("%.2f", producto.getPrecioUnitario()).replace(',', '.')%></p>
					<p class="text-lg"><strong>Stock : </strong><%=producto.getStockActual()%> unidades</p>
				</div>
			</div>
		</div>

		<div class="mt-6">
			<h2 class="text-xl font-bold mb-4">Descripción del Producto</h2>
			<p class="text-gray-700">
				<%=producto.getDescripcion()%>
			</p>
		</div>
	</div>
 </div>
	<%
		}
	}	
	%>

	<script>
		function cambiarImagen(imagenUrl) {
			const productoImagen = document.getElementById('productoImagen');
			productoImagen.src = imagenUrl;
		}
	</script>
</body>
</html>