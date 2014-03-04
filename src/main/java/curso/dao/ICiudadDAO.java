package curso.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import curso.modelo.Ciudad;

public interface ICiudadDAO extends JpaRepository<Ciudad, Integer> {

}
