package services.impl;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import config.MyBatisUtil;
import dao.MarcaMapper;
import models.Marca;
import services.MarcaService;

public class MarcaServiceImpl implements MarcaService{

	@Override
	public List<Marca> listarMarcas() {
		try {
			SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
			MarcaMapper marcaMapper = session.getMapper(MarcaMapper.class);
			return marcaMapper.listarMarcas();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
