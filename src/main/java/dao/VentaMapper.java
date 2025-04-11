package dao;

import models.Venta;

public interface VentaMapper {

	Venta obtenerVentaPorCodigoInterno(String codigoInterno);
	void insertarVenta(Venta venta);
	void actualizarVentaMontoTotal(Integer idVenta);
}
