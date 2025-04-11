package services.impl;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import config.MyBatisUtil;
import dao.ProductoMapper;
import models.Producto;
import services.ProductoService;

public class ProductoServiceImpl implements ProductoService{

	@Override
	public List<Producto> listarProductos() {
		try {
			SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
			ProductoMapper productoMapper = session.getMapper(ProductoMapper.class);
			return productoMapper.listarProductos();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	@Override
	public List<Producto> listarProductosPorIdCategoria(int idCategoria) {
		try {
			SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
			ProductoMapper productoMapper = session.getMapper(ProductoMapper.class);
			return productoMapper.listarProductosPorIdCategoria(idCategoria);

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public List<Producto> listarProductosPorIdMarca(int idMarca) {
		try {
			SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
			ProductoMapper productoMapper = session.getMapper(ProductoMapper.class);
			return productoMapper.listarProductosPorIdMarca(idMarca);

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public List<Producto> listarProductosPorIdProducto(int idProducto) {
		try {
			SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
			ProductoMapper productoMapper = session.getMapper(ProductoMapper.class);
			return productoMapper.listarProductosPorIdProducto(idProducto);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public Producto obtenerProductoPorIdProducto(int idProducto) {
		try {
			SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
			ProductoMapper productoMapper = session.getMapper(ProductoMapper.class);
			return productoMapper.obtenerProductoPorIdProducto(idProducto);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}



}
