<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script src="https://unpkg.com/@tailwindcss/browser@4"></script>
<title>REGISTRO USUARIO</title>
</head>
<body>

	<section class="bg-gray-50 dark:bg-gray-900 min-h-screen flex items-center justify-center">
		<div class="w-full max-w-4xl bg-white rounded-lg shadow-lg p-8 dark:bg-gray-800">
			<h1	class="text-2xl font-bold text-gray-900 dark:text-white text-center mb-6">Crear	una cuenta</h1>
			<form action="usuario" method="POST" class="grid grid-cols-1 md:grid-cols-2 gap-4">
				<div>
					<label for="tipoDocumento" class="block text-sm font-medium text-gray-900 dark:text-white">Tipo	de Documento</label> 
					<select id="tipoDocumento" name="tipoDocumento"	class="w-full p-2.5 border rounded-lg dark:bg-gray-700 dark:text-white">
						<option value="DNI">DNI</option>
						<option value="RUC">RUC</option>
						<option value="Carnet de Extranjeria">Carnet de	Extranjería</option>
					</select>
				</div>
				<div>
					<label for="numeroDocumento" class="block text-sm font-medium text-gray-900 dark:text-white">Número de Documento</label>
					<input type="text" id="numeroDocumento"	name="numeroDocumento" class="w-full p-2.5 border rounded-lg dark:bg-gray-700 dark:text-white" required>
				</div>
				<div>
					<label for="userName" class="block text-sm font-medium text-gray-900 dark:text-white">Nombre de Usuario</label>
					 <input type="text" id="userName" name="userName" class="w-full p-2.5 border rounded-lg dark:bg-gray-700 dark:text-white" required>
				</div>
				<div>
					<label for="clave" class="block text-sm font-medium text-gray-900 dark:text-white">Clave</label>					
					<input type="password" id="clave" name="clave" class="w-full p-2.5 border rounded-lg dark:bg-gray-700 dark:text-white" required>
				</div>
				<div>
					<label for="nombres" class="block text-sm font-medium text-gray-900 dark:text-white">Nombres</label>					
					<input type="text" id="nombres" name="nombres" class="w-full p-2.5 border rounded-lg dark:bg-gray-700 dark:text-white" required>
				</div>
				<div>
					<label for="apellidoPaterno" class="block text-sm font-medium text-gray-900 dark:text-white">Apellido Paterno</label> 
					<input type="text" id="apellidoPaterno"	name="apellidoPaterno" class="w-full p-2.5 border rounded-lg dark:bg-gray-700 dark:text-white" required>
				</div>
				<div>
					<label for="apellidoMaterno" class="block text-sm font-medium text-gray-900 dark:text-white">Apellido Materno</label> 
					<input type="text" id="apellidoMaterno"	name="apellidoMaterno" class="w-full p-2.5 border rounded-lg dark:bg-gray-700 dark:text-white" required>
				</div>
				<div>
					<label for="correo"	class="block text-sm font-medium text-gray-900 dark:text-white">Correo</label>
					<input type="email" id="correo" name="correo" class="w-full p-2.5 border rounded-lg dark:bg-gray-700 dark:text-white" placeholder="correo@example.com" required>
				</div>
				<div>
					<label for="telefono" class="block text-sm font-medium text-gray-900 dark:text-white">Teléfono</label>
					<input type="tel" id="telefono" name="telefono"	class="w-full p-2.5 border rounded-lg dark:bg-gray-700 dark:text-white" required>
				</div>
				<div>
					<label for="sexo" class="block text-sm font-medium text-gray-900 dark:text-white">Sexo</label>
					<select id="sexo" name="sexo" class="w-full p-2.5 border rounded-lg dark:bg-gray-700 dark:text-white">
						<option value="Masculino">Masculino</option>
						<option value="Femenino">Femenino</option>
						<option value="Otro">Otro</option>
					</select>
				</div>
				<div>
					<label for="fechaNacimiento" class="block text-sm font-medium text-gray-900 dark:text-white">Fecha de Nacimiento</label> 
					<input type="date" id="fechaNacimiento"	name="fechaNacimiento" class="w-full p-2.5 border rounded-lg dark:bg-gray-700 dark:text-white" required>
				</div>
				<div class="md:col-span-2 flex justify-center">
					<button type="submit" class="w-full md:w-1/2 cursor-pointer text-white bg-blue-600 hover:bg-blue-700 font-medium rounded-lg text-sm px-5 py-2.5 text-center">
						Crear cuenta
					</button>					
				</div>
				<div class="md:col-span-2 flex justify-center">
					<p class="text-sm font-light text-gray-500 dark:text-gray-400">
						¿Ya tienes una cuenta? 
					   <a href="/sistema-farmacia/usuario?accion=inicioSesion" class="font-medium text-blue-600 hover:underline dark:text-blue-500 ml-1">
							Iniciar Sesión aquí 
					   </a>
					</p>
				</div>
				<div class="md:col-span-2 flex justify-center">
					<p class="text-sm font-light text-gray-500 dark:text-gray-400">
						 <a href="/sistema-farmacia" class="font-medium text-blue-600 hover:underline dark:text-blue-500 ml-1">
							Volver al inicio 
						 </a>
					</p>
				</div>			
			</form>
		</div>
	</section>

</body>
</html>