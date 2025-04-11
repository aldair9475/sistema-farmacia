<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="models.VentaDetalle"%>
<%@ page import="models.Categoria"%>
<%@ page import="shared.Constants"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
<script src="https://unpkg.com/@tailwindcss/browser@4"></script>
<title>CARRITO</title>
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
  
  	<section class="mt-40">
		  <div class="flex flex-col md:flex-row gap-6">
        <!-- Tabla -->
        <%
        	
        %>
        <div class="w-full md:w-2/3">
          <table class="w-full border-collapse border border-gray-200">
            <thead class="bg-gray-100">
              <tr>
                <th class="border border-gray-300 px-4 py-2 text-left">Producto</th>
                 <th class="border border-gray-300 px-4 py-2 text-left">Imagen</th>
                <th class="border border-gray-300 px-4 py-2 text-left">Presentación</th>
                <th class="border border-gray-300 px-4 py-2 text-left">Cantidad</th>
                <th class="border border-gray-300 px-4 py-2 text-left">Precio Unitario</th>
                <th class="border border-gray-300 px-4 py-2 text-left">Subtotal</th>
              </tr>
            </thead>
            <tbody>
            <%
            List<VentaDetalle> ventasDetalle = (List<VentaDetalle>) request.getAttribute("ventasDetalle");
        	if(ventasDetalle != null && !ventasDetalle.isEmpty()){
            	for(VentaDetalle ventaDetalle : ventasDetalle){
            %>
              <tr>
            <!--   	<td class="border border-gray-300 px-4 py-2"></td>--> 
                <td class="border border-gray-300 px-4 py-2"><%= ventaDetalle.getNombreProducto() %></td>
                <td class="border border-gray-300 px-4 py-2">
               		<img class="h-20 w-20 object-fill" alt="" src="<%= ventaDetalle.getImagenProducto() != null ? ventaDetalle.getImagenProducto():Constants.IMAGEN_PRODUCTO_DEFAULT %>">
                </td>
                <td class="border border-gray-300 px-4 py-2"><%= ventaDetalle.getNombrePresentacion() %></td>
                <td class="border border-gray-300 px-4 py-2"><%= ventaDetalle.getCantidad() %></td>
                <td class="border border-gray-300 px-4 py-2">S/ <%= String.format("%.2f",ventaDetalle.getPrecioUnitario()).replace(',','.') %></td>
                <td class="border border-gray-300 px-4 py-2">S/ <%= String.format("%.2f", ventaDetalle.getPrecioUnitario()*ventaDetalle.getCantidad()).replace(',', '.') %></td>
              </tr>
              <%
        			}
        	%>
            </tbody>
          </table>
        </div>
      
        <div class="w-full md:w-1/3 h-1/3 bg-gray-50 border border-gray-300 rounded-md p-4">
          <h2 class="text-lg font-semibold mb-4">Resumen de compra</h2>
          <%for(VentaDetalle ventaDetalle : ventasDetalle){ %>
          <p class="text-gray-700">Total a pagar : <span class="font-bold">S/ <%=String.format("%.2f",ventaDetalle.getMontoTotal()).replace(',','.') %></span></p>
          <%
             break;
             }
           }else{%>
				<p class="text-center text-gray-600">No se encontraron registros</p>
				<% } %>
          <button class="mt-4 w-full h-10 bg-green-700 text-white font-semibold rounded-md hover:bg-green-600 transition">
            Comprar
          </button>
        </div>
      </div>
	</section>
  	

</body>
</html>