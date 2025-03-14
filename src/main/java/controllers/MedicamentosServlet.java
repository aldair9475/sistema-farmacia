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
import models.Productos;
import services.MarcaService;
import services.ProductoService;
import services.impl.MarcaServiceImpl;
import services.impl.ProductoServiceImpl;

@WebServlet("/medicamentos")
public class MedicamentosServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private final ProductoService productoService;
	private final MarcaService marcaService;
       
    
    public MedicamentosServlet() {
        super();
        productoService = new ProductoServiceImpl();
        marcaService = new MarcaServiceImpl();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Productos> productos = productoService.listarProductos();
		request.setAttribute("medicamentos", productos);
		
		List<Marca> marcas = marcaService.listarMarcas();
		request.setAttribute("marcas", marcas);
		
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
