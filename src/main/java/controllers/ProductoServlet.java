package controllers;

import java.io.IOException;
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

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Producto> productos = productoService.listarProductos();
		request.setAttribute("productos", productos);
		
		List<Marca> marcas = marcaService.listarMarcas();
		request.setAttribute("marcas", marcas);
		
		List<Categoria> categorias = categoriaService.listarCategorias();
		request.setAttribute("categorias", categorias);
		
		List<Presentacion> presentacion = presentacionService.listarPresentaciones();
		request.setAttribute("presentacion", presentacion);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
