package services;

import models.Venta;

public interface VentaService {

	Venta obtenerVentaPorCodigoInterno(String codigoInterno);
	Venta insertarVenta(Venta venta);
	void actualizarVentaMontoTotal(Integer idVenta);
}
