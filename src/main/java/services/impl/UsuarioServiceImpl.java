package services.impl;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import config.MyBatisUtil;
import dao.UsuarioMapper;
import models.Usuario;
import services.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {

	@Override
	public List<Usuario> ListarUsuario() {
		try {
			SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
			UsuarioMapper usuarioMapper = session.getMapper(UsuarioMapper.class);
			return usuarioMapper.ListarUsuario();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	@Override
	public Usuario insertarUsuario(Usuario usuario) {
		try {
			SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
			UsuarioMapper usuarioMapper = session.getMapper(UsuarioMapper.class);
			usuarioMapper.insertarUsuario(usuario);
			session.commit();
			return usuario;
		} catch (Exception e) {
			System.out.println("insertarUsuario:: " + e);
			e.printStackTrace();
			return null;
		}
	}
}
