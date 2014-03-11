package curso.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import curso.modelo.Usuario;

public class UsuarioRepositoryImpl implements UsuarioRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Usuario> buscarPersonalizado(String nombre) {
		String sql = "SELECT u FROM usuario u where u.nombre = :pnombre";
		TypedQuery<Usuario> query = em.createQuery(sql, Usuario.class);
		query.setParameter("pnombre", nombre);
		return query.getResultList();
	}

}
