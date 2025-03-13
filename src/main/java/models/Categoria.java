package models;

public class Categoria {
	
	  private int idCategoria;
	    private String Nombre;
	    private String ImagenUrl;
	    private String Descripcion;
	    private int Estado;
	    
	    
		public int getIdCategoria() {
			return idCategoria;
		}
		public void setIdCategoria(int idCategoria) {
			this.idCategoria = idCategoria;
		}
		public String getNombre() {
			return Nombre;
		}
		public void setNombre(String nombre) {
			Nombre = nombre;
		}
		public String getImagenUrl() {
			return ImagenUrl;
		}
		public void setImagenUrl(String imagenUrl) {
			ImagenUrl = imagenUrl;
		}
		public String getDescripcion() {
			return Descripcion;
		}
		public void setDescripcion(String descripcion) {
			Descripcion = descripcion;
		}
		public int getEstado() {
			return Estado;
		}
		public void setEstado(int estado) {
			Estado = estado;
		}
	    
	    
}
