package com.juamber.arquitectos.repositorys;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.juamber.arquitectos.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	Optional<Usuario> findByNombre(String nombreUsuario);
	Optional<Usuario> findByEmail(String email);
	Optional<Usuario> findByNombreOrEmail(String nombre, String email);
	boolean existsByNombre(String nombreUsuario);

}
