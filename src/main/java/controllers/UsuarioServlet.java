package controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Categoria;
import models.Marca;
import models.Presentacion;
import models.Producto;
import models.Usuario;
import services.CategoriaService;
import services.MarcaService;
import services.PresentacionService;
import services.ProductoService;
import services.UsuarioService;
import services.impl.CategoriaServiceImpl;
import services.impl.MarcaServiceImpl;
import services.impl.PresentacionServiceImpl;
import services.impl.ProductoServiceImpl;
import services.impl.UsuarioServiceImpl;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final UsuarioService usuarioService;
	private final ProductoService productoService;
	private final MarcaService marcaService;
	private final CategoriaService categoriaService;
	private final PresentacionService presentacionService;
    
    public UsuarioServlet() {
        super();
        usuarioService = new UsuarioServiceImpl();
    	productoService = new ProductoServiceImpl();
		marcaService = new MarcaServiceImpl();
		categoriaService = new CategoriaServiceImpl();
		presentacionService = new PresentacionServiceImpl();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accion = request.getParameter("accion");
		String username = request.getParameter("username");
		String clave = request.getParameter("password");
		

		if (username != null && clave != null) {

			Usuario usuario = usuarioService.validarUsuario(username, clave);
			if (usuario != null) {

				List<Marca> marcas = marcaService.listarMarcas();
				request.setAttribute("marcas", marcas);

				List<Producto> productos = productoService.listarProductos();
				request.setAttribute("productos", productos);

				List<Categoria> categorias = categoriaService.listarCategorias();
				request.setAttribute("categorias", categorias);

				List<Presentacion> presentaciones = presentacionService.listarPresentaciones();
				request.setAttribute("presentaciones", presentaciones);
				request.setAttribute("usuario", usuario);
				System.out.println("USUARIO -> "+usuario.getUsername());

				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
				return;
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/views/inicioSesion.jsp");
				dispatcher.forward(request, response);
				System.out.println("NOMBRE DE USUARIO O CLAVE INCORRECTOS");
				return;
			}
		}
		
		if ("registro".equals(accion)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/registroUsuario.jsp");
			dispatcher.forward(request, response);
		}
		
		if("inicioSesion".equals(accion)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/inicioSesion.jsp");
			dispatcher.forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tipoDocumento = request.getParameter("tipoDocumento");
		String numeroDocumento = request.getParameter("numeroDocumento");
		String userName = request.getParameter("userName");
		String clave = request.getParameter("clave");
		String nombres = request.getParameter("nombres");
		String apellidoPaterno = request.getParameter("apellidoPaterno");
		String apellidoMaterno = request.getParameter("apellidoMaterno");
		String correo = request.getParameter("correo");
		String telefono = request.getParameter("telefono");
		String sexo = request.getParameter("sexo");
		String fechaNacimiento = request.getParameter("fechaNacimiento");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			java.util.Date fecha = sdf.parse(fechaNacimiento);
			java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());

			Usuario usuario = new Usuario();
			usuario.setTipoDocumento(tipoDocumento.substring(0, 1));
			usuario.setNumeroDocumento(numeroDocumento);
			usuario.setUsername(userName);
			usuario.setClave(clave);
			usuario.setNombres(nombres);
			usuario.setApellidoPaterno(apellidoPaterno);
			usuario.setApellidoMaterno(apellidoMaterno);
			usuario.setCorreo(correo);
			usuario.setTelefono(telefono);
			usuario.setSexo(sexo.substring(0, 1));
			usuario.setFechaNacimiento(fechaSQL);
			usuarioService.insertarUsuario(usuario);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/registroUsuario.jsp");
			dispatcher.forward(request, response);

			System.out.println("USUARIO REGISTRADO CORRECTAMENTE");

		} catch (Exception e) {
			System.out.println(e);

		}

	
	}

}
