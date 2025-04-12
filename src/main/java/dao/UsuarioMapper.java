package dao;
import java.util.List;

import models.Usuario;

public interface UsuarioMapper {

	void insertarUsuario(Usuario usuario);
	List<Usuario> ListarUsuario();
}
