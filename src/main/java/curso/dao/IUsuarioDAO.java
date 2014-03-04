package curso.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import curso.modelo.Usuario;

public interface IUsuarioDAO extends JpaRepository<Usuario, Integer> {

}
