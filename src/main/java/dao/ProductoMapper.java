package dao;

import java.util.List;
import models.Producto;

public interface ProductoMapper {

	List<Producto> listarProductos();
	List<Producto> listarProductosPorIdMarca(int idMarca);
	List<Producto> listarProductosPorIdCategoria(int idCategoria);
	List<Producto> listarProductosPorIdProducto(int idProducto);
}
