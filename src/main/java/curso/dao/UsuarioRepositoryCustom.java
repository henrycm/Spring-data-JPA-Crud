package curso.dao;

import java.util.List;

import curso.modelo.Usuario;

public interface UsuarioRepositoryCustom {
	public List<Usuario> buscarPersonalizado(String nombre);
}
