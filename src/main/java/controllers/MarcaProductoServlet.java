package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Presentacion;
import models.Producto;
import services.PresentacionService;
import services.ProductoService;
import services.impl.PresentacionServiceImpl;
import services.impl.ProductoServiceImpl;

@WebServlet("/marca-producto")
public class MarcaProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PresentacionService presentacionService;
	private ProductoService productoService;
       
   
    public MarcaProductoServlet() {
        super();
        presentacionService = new PresentacionServiceImpl();
        productoService = new ProductoServiceImpl();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idMarca = Integer.parseInt(request.getParameter("idMarca"));
		List<Producto> productos = productoService.listarProductoPorMarca(idMarca);
	    request.setAttribute("productos", productos);
	    
	    List<Presentacion> presentaciones = presentacionService.listarPresentaciones();
	    request.setAttribute("presentaciones", presentaciones);
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/views/marca-producto.jsp");
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
