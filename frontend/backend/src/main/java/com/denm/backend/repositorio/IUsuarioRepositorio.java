package com.denm.backend.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.denm.backend.modelo.entidad.Usuario;

@Component
@Repository
public interface IUsuarioRepositorio extends JpaRepository<Usuario, Integer>{
	
	@Query("select u from Usuario u join fetch u.fkIdRol "
			+ "where u.userUsuario=:userUsuario "
			+ "AND u.passUsuario=:passUsuario")
	Optional<Usuario> loginUsuario(
			          @Param("userUsuario") String userUsuario, 
			          @Param("passUsuario") String passUsuario);

}
