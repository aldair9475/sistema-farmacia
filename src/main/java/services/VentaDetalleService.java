package services;

import java.util.List;

import models.VentaDetalle;

public interface VentaDetalleService {

	VentaDetalle obtenerVentaDetallePorIdVentaYIdProducto(Integer idVenta, Integer idProducto);
	VentaDetalle insertarVentaDetalle(VentaDetalle ventaDetalle);
	void aumentarVentaDetalleCantidad(Integer idVentaDetalle);
	void actualizarVentaDetalleSubTotal(Integer idProducto);
	List<VentaDetalle> listarVentaDetalleCarrito(Integer idVenta);
	void eliminarPorIdVentaDetalle(Integer idVentaDetalle);
}
