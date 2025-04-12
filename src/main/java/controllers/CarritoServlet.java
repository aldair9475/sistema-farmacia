package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Categoria;
import models.Producto;
import models.Venta;
import models.VentaDetalle;
import services.impl.CategoriaServiceImpl;
import services.impl.ProductoServiceImpl;
import services.impl.VentaDetalleServiceImpl;
import services.impl.VentaServiceImpl;
import shared.Util;


@WebServlet("/carrito")
public class CarritoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VentaServiceImpl ventaServiceImpl;
	private VentaDetalleServiceImpl ventaDetalleServiceImpl;
	private ProductoServiceImpl productoServiceImpl;
	private CategoriaServiceImpl categoriaServiceImpl;
    int contador = 0;
   
    public CarritoServlet() {
        super();
        ventaServiceImpl = new VentaServiceImpl();
        ventaDetalleServiceImpl = new VentaDetalleServiceImpl();
    	productoServiceImpl = new ProductoServiceImpl();
    	categoriaServiceImpl = new CategoriaServiceImpl();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accion = request.getParameter("accion");
		String idVentaDetalle = request.getParameter("idVentaDetalle");
		String sessionId = Util.getCookieValue(request.getCookies(), "JSESSIONID");
		
		
		if("eliminar".equals(accion)) {
			
			Venta venta = ventaServiceImpl.obtenerVentaPorCodigoInterno(sessionId);
			ventaDetalleServiceImpl.eliminarPorIdVentaDetalle(Integer.parseInt(idVentaDetalle));
			ventaServiceImpl.actualizarVentaMontoTotal(venta.getIdVenta());
			List<VentaDetalle> ventasDetalle = ventaDetalleServiceImpl.listarVentaDetalleCarrito(venta.getIdVenta());
			List<Categoria> categorias = categoriaServiceImpl.listarCategorias();
			contador = ventasDetalle.size();
			
			request.setAttribute("categorias", categorias);
			request.setAttribute("ventasDetalle", ventasDetalle);
			request.setAttribute("contador", contador);
			
			 RequestDispatcher dispatcher = request.getRequestDispatcher("/views/carrito.jsp");
			 dispatcher.forward(request, response);
		}else {
			Venta venta = ventaServiceImpl.obtenerVentaPorCodigoInterno(sessionId);
			
			List<VentaDetalle> ventasDetalle = ventaDetalleServiceImpl.listarVentaDetalleCarrito(venta.getIdVenta());
			List<Categoria> categorias = categoriaServiceImpl.listarCategorias();
			
			request.setAttribute("categorias", categorias);
			request.setAttribute("ventasDetalle", ventasDetalle);
			request.setAttribute("contador", contador);
			
			 RequestDispatcher dispatcher = request.getRequestDispatcher("/views/carrito.jsp");
			 dispatcher.forward(request, response);
		}
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer idProducto = Integer.parseInt(request.getParameter("idProducto"));
		System.out.println("Se esta agregando un elemento al carrito idProducto : " + idProducto);

		String sessionId = Util.getCookieValue(request.getCookies(), "JSESSIONID");
		System.out.println("sessionId : "+sessionId);
		
		Venta venta = ventaServiceImpl.obtenerVentaPorCodigoInterno(sessionId);
		if(venta==null) {
			Venta newVenta = new Venta();
			newVenta.setCodigoInterno(sessionId);
			venta = ventaServiceImpl.insertarVenta(newVenta);
		}
		
		System.out.println("Ventaid::"+venta.getIdVenta());
		
		VentaDetalle ventaDetalle = ventaDetalleServiceImpl.obtenerVentaDetallePorIdVentaYIdProducto(venta.getIdVenta(), idProducto); 
		Producto producto = productoServiceImpl.obtenerProductoPorIdProducto(idProducto);
		if(ventaDetalle == null) {
			VentaDetalle newVentaDetalle = new VentaDetalle();
			newVentaDetalle.setIdVenta(venta.getIdVenta());
			newVentaDetalle.setIdProducto(idProducto);
			newVentaDetalle.setPrecioUnitario(producto.getPrecioUnitario());
			newVentaDetalle.setSubtotal(producto.getPrecioUnitario());
			ventaDetalle = ventaDetalleServiceImpl.insertarVentaDetalle(newVentaDetalle);
			contador++;
		} else {
			ventaDetalleServiceImpl.aumentarVentaDetalleCantidad(ventaDetalle.getIdVentaDetalle());
			ventaDetalleServiceImpl.actualizarVentaDetalleSubTotal(ventaDetalle.getIdVentaDetalle());
		}	
		ventaServiceImpl.actualizarVentaMontoTotal(venta.getIdVenta());
		System.out.println("VentaDetalleId::"+ventaDetalle.getIdVentaDetalle());
		
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(String.valueOf(contador));
		
		

	}

}
