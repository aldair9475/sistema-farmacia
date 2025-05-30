package models;

public class Producto {

	private int idProducto;
	private int idCategoria;
	private int idMarca;
	private int idPresentacion;
	private String codigo;
	private String nombre;
	private String descripcion;
	private String registroSanitario;
	private double precioUnitario;
	private int stockActual;
	private String estado;
	private String imagenUrl;
	
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public int getIdMarca() {
		return idMarca;
	}
	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}
	public int getIdPresentacion() {
		return idPresentacion;
	}
	public void setIdPresentacion(int idPresentacion) {
		this.idPresentacion = idPresentacion;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getRegistroSanitario() {
		return registroSanitario;
	}
	public void setRegistroSanitario(String registroSanitario) {
		this.registroSanitario = registroSanitario;
	}
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public int getStockActual() {
		return stockActual;
	}
	public void setStockActual(int stockActual) {
		this.stockActual = stockActual;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getImagenUrl() {
		return imagenUrl;
	}
	public void setImagenUrl(String imagenUrl) {
		this.imagenUrl = imagenUrl;
	}
	
	
	
}
