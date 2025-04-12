package services.impl;

import org.apache.ibatis.session.SqlSession;
import config.MyBatisUtil;
import dao.UsuarioMapper;
import models.Usuario;
import services.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {

	
	@Override
	public void insertarUsuario(Usuario usuario) {
		
		try {
			SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
			UsuarioMapper usuarioMapper = session.getMapper(UsuarioMapper.class);
			usuarioMapper.insertarUsuario(usuario);
			session.commit();
		} catch (Exception e) {
			System.out.println(e);		
		}
		
	}

	@Override
	public Usuario validarUsuario(String username, String clave) {
		Usuario usuario = null;
		try {
			SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
			UsuarioMapper usuarioMapper = session.getMapper(UsuarioMapper.class);
			usuario = usuarioMapper.validarUsuario(username, clave);
		} catch (Exception e) {
			System.out.println(e);	
		}
		return usuario;
	}
	
}
