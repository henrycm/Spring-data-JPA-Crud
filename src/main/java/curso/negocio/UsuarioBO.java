package curso.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.dao.UsuarioRepository;
import curso.modelo.Usuario;

@Service
public class UsuarioBO {
	@Autowired
	private UsuarioRepository dao;

	public boolean guardar(Usuario u) {
		boolean ret = dao.save(u) != null;
		return ret;
	}

	public List<Usuario> listar() {		
		return dao.findAll();
	}

	public Usuario consultar(int id) {
		return dao.findOne(id);
	}
}
