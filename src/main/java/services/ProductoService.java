package services;

import java.util.List;
import models.Producto;

public interface ProductoService {
	
	List<Producto> listarProductos();
	List<Producto> listarProductoPorMarca(int idMarca);

}
