package models;

import java.sql.Date;

public class Venta {

	private int idVenta;
	private int idUsuarioComprador;
	private Date fechaVenta;
	private int idMetodoPago;
	private int idMetodoEnvio;
	private String numeroBoleta;
	private String boletaUrl;
	private String montoTotal;
	private String estado;

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public int getIdUsuarioComprador() {
		return idUsuarioComprador;
	}

	public void setIdUsuarioComprador(int idUsuarioComprador) {
		this.idUsuarioComprador = idUsuarioComprador;
	}

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public int getIdMetodoPago() {
		return idMetodoPago;
	}

	public void setIdMetodoPago(int idMetodoPago) {
		this.idMetodoPago = idMetodoPago;
	}

	public int getIdMetodoEnvio() {
		return idMetodoEnvio;
	}

	public void setIdMetodoEnvio(int idMetodoEnvio) {
		this.idMetodoEnvio = idMetodoEnvio;
	}

	public String getNumeroBoleta() {
		return numeroBoleta;
	}

	public void setNumeroBoleta(String numeroBoleta) {
		this.numeroBoleta = numeroBoleta;
	}

	public String getBoletaUrl() {
		return boletaUrl;
	}

	public void setBoletaUrl(String boletaUrl) {
		this.boletaUrl = boletaUrl;
	}

	public String getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(String montoTotal) {
		this.montoTotal = montoTotal;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
