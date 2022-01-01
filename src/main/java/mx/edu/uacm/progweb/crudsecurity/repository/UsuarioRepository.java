package mx.edu.uacm.progweb.crudsecurity.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import mx.edu.uacm.progweb.crudsecurity.dominio.Usuario;


public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	@Query("SELECT u FROM Usuario u WHERE u.nombreDeUsuario = :nombreDeUsuario")
	public Usuario getUserByUsername(@Param("nombreDeUsuario") String nombreDeUsuario);
}
