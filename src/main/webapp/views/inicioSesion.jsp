<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
<script src="https://unpkg.com/@tailwindcss/browser@4"></script>
<title>INICIAR SESION</title>
</head>
<body>

	<section class="bg-gray-50 dark:bg-gray-900">
		<div class="flex flex-col items-center justify-center px-6 py-8 mx-auto md:h-screen lg:py-0">
			<a href="#" class="flex items-center mb-6 text-2xl font-semibold text-gray-900 dark:text-white">
				<i class="fas fa-clinic-medical text-2xl text-green-600 mr-2"></i>
				Farmacia
			</a>
			<div
				class="w-full bg-white rounded-lg shadow dark:border md:mt-0 sm:max-w-md xl:p-0 dark:bg-gray-800 dark:border-gray-700">
				<div class="p-6 space-y-4 md:space-y-6 sm:p-8">
					<h1	class="text-xl font-bold leading-tight tracking-tight text-gray-900 md:text-2xl dark:text-white">
						Iniciar sesión
					</h1>
					<form action="usuario" method="GET" class="space-y-4 md:space-y-6">
						<div>
							<label for="username" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Usuario</label>
							<input type="text" name="username" id="username" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" required>
						</div>
						<div>
							<label for="password" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Contraseña</label>
							<input type="password" name="password" id="password" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" required>
						</div>
						<button type="submit" class="w-full text-white bg-blue-600 hover:bg-blue-700 cursor-pointer focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
						Iniciar	sesión
						</button>
				<div class="md:col-span-2 flex justify-center">
					<p class="text-sm font-light text-gray-500 dark:text-gray-400">
						¿No tienes una cuenta? 
					  <a href="/sistema-farmacia/usuario?accion=registro" class="font-medium text-blue-600 hover:underline dark:text-blue-500 ml-1">
							Registrarte aquí 
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
			</div>
		</div>
	</section>
	

</body>
</html>