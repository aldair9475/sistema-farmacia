package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Marca;
import models.Producto;
import models.Categoria;
import models.Presentacion;
import services.MarcaService;
import services.ProductoService;
import services.impl.MarcaServiceImpl;
import services.impl.ProductoServiceImpl;
import services.CategoriaService;
import services.PresentacionService;
import services.impl.CategoriaServiceImpl;
import services.impl.PresentacionServiceImpl;

@WebServlet("/productos")
public class ProductoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final ProductoService productoService;
	private final MarcaService marcaService;
	private final CategoriaService categoriaService;
	private final PresentacionService presentacionService;

	public ProductoServlet() {
		super();
		productoService = new ProductoServiceImpl();
		marcaService = new MarcaServiceImpl();
		categoriaService = new CategoriaServiceImpl();
		presentacionService = new PresentacionServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idCategoria = request.getParameter("idCategoria");
		String idMarca = request.getParameter("idMarca");
		String idProducto = request.getParameter("idProducto");

		// filatramos los prodcutos por categoria
		if (idCategoria != null && !idCategoria.isEmpty()) {
			List<Producto> productos = productoService.listarProductosPorIdCategoria(Integer.parseInt(idCategoria));
			List<Categoria> categorias = categoriaService.listarCategorias();
			List<Presentacion> presentaciones = presentacionService.listarPresentaciones();
			String nombreCategoria = "";

			for (Producto producto : productos) {
				for (Categoria categoria : categorias) {
					if (producto.getIdCategoria() == categoria.getIdCategoria()) {
						nombreCategoria = categoria.getNombre();
						break;
					}
				}
			}

			request.setAttribute("nombreCategoria", nombreCategoria);
			request.setAttribute("categorias", categorias);		
			request.setAttribute("presentaciones", presentaciones);
			request.setAttribute("productos", productos);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/productoCategoria.jsp");
			dispatcher.forward(request, response);
		}

		// fialtaramo oos prodcutos por marca
		if (idMarca != null && !idMarca.isEmpty()) {
			List<Producto> productos = productoService.listarProductosPorIdMarca(Integer.parseInt(idMarca));
			List<Marca> marcas = marcaService.listarMarcas();
			List<Categoria> categorias = categoriaService.listarCategorias();
			List<Presentacion> presentaciones = presentacionService.listarPresentaciones();
			String nombreMarca = "";

			for (Producto producto : productos) {
				for (Marca marca : marcas) {
					if (producto.getIdMarca() == marca.getIdMarca()) {
						nombreMarca = marca.getNombre();
						break;
					}
				}
			}

			request.setAttribute("nombreMarca", nombreMarca);
			request.setAttribute("productos", productos);
			request.setAttribute("presentaciones", presentaciones);
			request.setAttribute("categorias", categorias);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/productoMarca.jsp");
			dispatcher.forward(request, response);
		}

		// detalle del producto
		if (idProducto != null && !idProducto.isEmpty()) {
			List<Producto> productos = productoService.listarProductosPorIdProducto(Integer.parseInt(idProducto));
			List<Presentacion> presentaciones = presentacionService.listarPresentaciones();
			List<Marca> marcas = marcaService.listarMarcas();
			List<String> imagenes = new ArrayList<>();

			if (productos != null && !productos.isEmpty()) {
				for (Producto producto : productos) {
					imagenes.add(producto.getImagenUrl());
				}
			}
			productos = productos.subList(0, 1);

			request.setAttribute("marcas", marcas);	
			request.setAttribute("presentaciones", presentaciones);
			request.setAttribute("imagenes", imagenes);
			request.setAttribute("productos", productos);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/detalleProducto.jsp");
			dispatcher.forward(request, response);

		}

		List<Producto> productos = productoService.listarProductos();
		request.setAttribute("productos", productos);

		List<Marca> marcas = marcaService.listarMarcas();
		request.setAttribute("marcas", marcas);

		List<Categoria> categorias = categoriaService.listarCategorias();
		request.setAttribute("categorias", categorias);

		List<Presentacion> presentaciones = presentacionService.listarPresentaciones();
		request.setAttribute("presentaciones", presentaciones);

		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
