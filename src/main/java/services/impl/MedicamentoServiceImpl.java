package services.impl;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import config.MyBatisUtil;
import dao.MedicamentoMapper;
import models.Medicamento;
import services.MedicamentoService;

public class MedicamentoServiceImpl implements MedicamentoService{

	@Override
	public List<Medicamento> listarMedicamentos() {
		try {
			SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
			MedicamentoMapper medicamentoMapper = session.getMapper(MedicamentoMapper.class);
			return medicamentoMapper.listarMedicamentos();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
