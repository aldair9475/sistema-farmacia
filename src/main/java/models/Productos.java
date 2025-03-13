package models;

public class Productos {

	private Integer idProducto;
	private Integer idCategoria;
	private Integer idMarca;
	private Integer idPresentacion;
	private String Nombre;
	private String Descripcion;
	private String ImagenUrl;
	private Double PrecioUnitario;
	private Integer StockActual;
	private Integer Estado;
	
	
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	public Integer getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	public Integer getIdMarca() {
		return idMarca;
	}
	public void setIdMarca(Integer idMarca) {
		this.idMarca = idMarca;
	}
	public Integer getIdPresentacion() {
		return idPresentacion;
	}
	public void setIdPresentacion(Integer idPresentacion) {
		this.idPresentacion = idPresentacion;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public String getImagenUrl() {
		return ImagenUrl;
	}
	public void setImagenUrl(String imagenUrl) {
		ImagenUrl = imagenUrl;
	}
	public Double getPrecioUnitario() {
		return PrecioUnitario;
	}
	public void setPrecioUnitario(Double precioUnitario) {
		PrecioUnitario = precioUnitario;
	}
	public Integer getStockActual() {
		return StockActual;
	}
	public void setStockActual(Integer stockActual) {
		StockActual = stockActual;
	}
	public Integer getEstado() {
		return Estado;
	}
	public void setEstado(Integer estado) {
		Estado = estado;
	}
	
	
	
}
