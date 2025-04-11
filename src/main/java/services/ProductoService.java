package services;

import java.util.List;
import models.Producto;

public interface ProductoService {
	
	List<Producto> listarProductos();
	List<Producto> listarProductosPorIdMarca(int idMarca);
	List<Producto> listarProductosPorIdCategoria(int idCategoria);
	List<Producto> listarProductosPorIdProducto(int idProducto);
	Producto obtenerProductoPorIdProducto(int idProducto);
}
