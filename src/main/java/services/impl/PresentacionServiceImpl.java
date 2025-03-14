package services.impl;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import config.MyBatisUtil;
import dao.PresentacionMapper;
import models.Presentacion;
import services.PresentacionService;

public class PresentacionServiceImpl implements PresentacionService {

	@Override
	public List<Presentacion> listarPresentacion() {
		try {
			SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
			PresentacionMapper presentacionMapper = session.getMapper(PresentacionMapper.class);
			return presentacionMapper.listarPresentacion();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
