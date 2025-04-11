package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import models.VentaDetalle;

public interface VentaDetalleMapper {
	
	VentaDetalle obtenerVentaDetallePorIdVentaYIdProducto(@Param("idVenta") Integer idVenta,@Param("idProducto") Integer idProducto);
	void insertarVentaDetalle(VentaDetalle ventaDetalle);
	void aumentarVentaDetalleCantidad(Integer idVentaDetalle);
	void actualizarVentaDetalleSubTotal(Integer idProducto);
	List<VentaDetalle> listarVentaDetalleCarrito(Integer idVenta);
}
