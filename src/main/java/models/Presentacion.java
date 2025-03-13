package models;

public class Presentacion {

	private int idPresentacion;
    private String Nombre;
    private String Descripcion;
    
	public int getIdPresentacion() {
		return idPresentacion;
	}
	public void setIdPresentacion(int idPresentacion) {
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
    
    
}
