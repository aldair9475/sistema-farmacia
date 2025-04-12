package services;

import org.apache.ibatis.annotations.Param;

import models.Usuario;

public interface UsuarioService {

	void insertarUsuario(Usuario usuario);
	Usuario validarUsuario(@Param("username") String username, @Param("clave") String clave);

}
