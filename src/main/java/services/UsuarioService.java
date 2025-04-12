package services;
import java.util.List;
import models.Usuario;

public interface UsuarioService {

	void insertarUsuario(Usuario usuario);
	List<Usuario> ListarUsuario();
}
