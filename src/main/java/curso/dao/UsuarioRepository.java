package curso.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import curso.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>,
		UsuarioRepositoryCustom {

	public Usuario findByNombre(String nombre);

	@Query(value = "SELECT u FROM usuario u " + "WHERE u.nombre = :par_nombre")
	public Usuario consultarPorNombre(@Param("par_nombre") String par_nombre);
}
