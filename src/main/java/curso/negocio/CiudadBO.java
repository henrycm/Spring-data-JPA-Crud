package curso.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.dao.ICiudadDAO;
import curso.modelo.Ciudad;

@Service
public class CiudadBO {

	@Autowired
	private ICiudadDAO dao;

	public List<Ciudad> listar() {
		return dao.findAll();
	}
}
