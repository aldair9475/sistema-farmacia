package services.impl;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import config.MyBatisUtil;
import dao.ProductoMapper;
import models.Productos;
import services.ProductoService;

public class ProductoServiceImpl implements ProductoService{

	@Override
	public List<Productos> listarProductos() {
		try {
			SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
			ProductoMapper ProductoMapper = session.getMapper(ProductoMapper.class);
			return ProductoMapper.listarProductos();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
